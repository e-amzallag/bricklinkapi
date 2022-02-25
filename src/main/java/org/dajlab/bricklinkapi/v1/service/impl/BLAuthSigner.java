package org.dajlab.bricklinkapi.v1.service.impl;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.dajlab.bricklinkapi.v1.vo.BricklinkException;

/**
 * Class imported and adapted from
 * http://apidev.bricklink.com/redmine/attachments/download/5/BLAuthTest.zip
 *
 */
public class BLAuthSigner {

	public static final String TIMESTAMP = "oauth_timestamp";
	public static final String SIGN_METHOD = "oauth_signature_method";
	public static final String SIGNATURE = "oauth_signature";
	public static final String CONSUMER_SECRET = "oauth_consumer_secret";
	public static final String CONSUMER_KEY = "oauth_consumer_key";
	public static final String CALLBACK = "oauth_callback";
	public static final String VERSION = "oauth_version";
	public static final String NONCE = "oauth_nonce";
	public static final String PARAM_PREFIX = "oauth_";
	public static final String TOKEN = "oauth_token";
	public static final String TOKEN_SECRET = "oauth_token_secret";
	public static final String OUT_OF_BAND = "oob";
	public static final String VERIFIER = "oauth_verifier";
	public static final String HEADER = "Authorization";
	public static final String SCOPE = "scope";

	private static final String CHARSET = "UTF-8";
	private static final String HMAC_SHA1 = "HmacSHA1";
	private static final String EMPTY_STRING = "";
	private static final String CARRIAGE_RETURN = "\r\n";

	private String signMethod = "HMAC-SHA1";
	private String version = "1.0";
	private String consumerKey;
	private String consumerSecret;
	private String tokenValue;
	private String tokenSecret;

	private String url;
	private String verb;

	private Map<String, String> oauthParameters;
	private Map<String, String> queryParameters;

	private Timer timer;

	public BLAuthSigner(String consumerKey, String consumerSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.oauthParameters = new TreeMap<>();
		this.queryParameters = new TreeMap<>();
		this.timer = new Timer();
	}

	public void setToken(String tokenValue, String tokenSecret) {
		this.tokenValue = tokenValue;
		this.tokenSecret = tokenSecret;
	}

	public void setURL(String url) {
		this.url = url;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public void addParameter(String key, String value) {
		queryParameters.put(key, value);
	}

	public Map<String, String> getFinalOAuthParams() throws BricklinkException {
		String signature = computeSignature();

		Map<String, String> params = new TreeMap<>();
		params.putAll(oauthParameters);
		params.put(SIGNATURE, signature);

		return params;
	}

	public String computeSignature() throws BricklinkException {
		addOAuthParameter(VERSION, version);
		addOAuthParameter(TIMESTAMP, getTimestampInSeconds());
		addOAuthParameter(NONCE, getNonce());
		addOAuthParameter(TOKEN, tokenValue);
		addOAuthParameter(CONSUMER_KEY, consumerKey);
		addOAuthParameter(SIGN_METHOD, signMethod);

		String baseString = getBaseString();
		String keyString = OAuthEncoder.encode(consumerSecret) + '&' + OAuthEncoder.encode(tokenSecret);
		String signature = doSign(baseString, keyString);
		return signature;
	}

	private void addOAuthParameter(String key, String value) {
		oauthParameters.put(key, value);
	}

	private String getTimestampInSeconds() {
		Long ts = timer.getMilis();
		return String.valueOf(TimeUnit.MILLISECONDS.toSeconds(ts));
	}

	private String getNonce() {
		Long ts = timer.getMilis();
		return String.valueOf(ts + Math.abs(timer.getRandomInteger()));
	}

	private String getBaseString() throws BricklinkException {
		List<String> params = new ArrayList<>();

		for (Entry<String, String> entry : oauthParameters.entrySet()) {
			String param = OAuthEncoder.encode(entry.getKey()).concat("=").concat(entry.getValue());
			params.add(param);
		}

		for (Entry<String, String> entry : queryParameters.entrySet()) {
			String param = OAuthEncoder.encode(entry.getKey()).concat("=").concat(entry.getValue());
			params.add(param);
		}

		Collections.sort(params);

		StringBuilder builder = new StringBuilder();
		for (String param : params) {
			builder.append('&').append(param);
		}

		String formUrlEncodedParams = OAuthEncoder.encode(builder.toString().substring(1));
		String sanitizedURL = OAuthEncoder.encode(url.replaceAll("\\?.*", "").replace("\\:\\d{4}", ""));

		return String.format("%s&%s&%s", verb, sanitizedURL, formUrlEncodedParams);
	}

	private String doSign(String toSign, String keyString) throws BricklinkException {
		try {
			SecretKeySpec key = new SecretKeySpec((keyString).getBytes(CHARSET), HMAC_SHA1);
			Mac mac = Mac.getInstance(HMAC_SHA1);
			mac.init(key);
			byte[] bytes = mac.doFinal(toSign.getBytes(CHARSET));
			return bytesToBase64String(bytes).replace(CARRIAGE_RETURN, EMPTY_STRING);
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

	private String bytesToBase64String(byte[] bytes) throws Exception {
		return new String(Base64.encodeBase64(bytes), "UTF-8");
	}

	static class Timer {
		private final Random rand = new Random();

		Long getMilis() {
			return System.currentTimeMillis();
		}

		Integer getRandomInteger() {
			return rand.nextInt();
		}
	}

	static class OAuthEncoder {
		private static final Map<String, String> ENCODING_RULES;

		static {
			Map<String, String> rules = new TreeMap<>();
			rules.put("*", "%2A");
			rules.put("+", "%20");
			rules.put("%7E", "~");
			ENCODING_RULES = Collections.unmodifiableMap(rules);
		}

		public static String encode(String plain) throws BricklinkException {
			try {
				String encoded = URLEncoder.encode(plain, CHARSET);

				for (Map.Entry<String, String> rule : ENCODING_RULES.entrySet()) {
					encoded = encoded.replaceAll(Pattern.quote(rule.getKey()), rule.getValue());
				}
				return encoded;
			} catch (Exception e) {
				throw new BricklinkException(e.getMessage());
			}
		}
	}
}
