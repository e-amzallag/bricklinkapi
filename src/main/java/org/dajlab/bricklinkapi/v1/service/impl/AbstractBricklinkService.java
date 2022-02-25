/*
 * Copyright 2020 Erik Amzallag
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.dajlab.bricklinkapi.v1.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.dajlab.bricklinkapi.v1.enumeration.Method;
import org.dajlab.bricklinkapi.v1.vo.BricklinkException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Abstract class for Bricklink services.
 * 
 * @author Erik Amzallag
 *
 */
public abstract class AbstractBricklinkService {

	/**
	 * Consumer key.
	 */
	private String consumerKey;
	/**
	 * Consumer secret.
	 */
	private String consumerSecret;
	/**
	 * Token value.
	 */
	private String tokenValue;
	/**
	 * Token secret.
	 */
	private String tokenSecret;

	/**
	 * API Base URL.
	 * 
	 * @see <a href=
	 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/General_Notes">General
	 *      Notes</a>
	 */
	private static final String API_BASE_URL = "https://api.bricklink.com/api/store/v1";

	/**
	 * Constructor.
	 * 
	 * @param consumerKey
	 *            consumer Key
	 * @param consumerSecret
	 *            consumer Secret
	 * @param tokenValue
	 *            token Value
	 * @param tokenSecret
	 *            token Secret
	 */
	protected AbstractBricklinkService(String consumerKey, String consumerSecret, String tokenValue,
			String tokenSecret) {
		this.consumerKey = consumerKey;
		this.consumerSecret = consumerSecret;
		this.tokenValue = tokenValue;
		this.tokenSecret = tokenSecret;
	}

	/**
	 * Call the service and return the response.
	 * 
	 * @param method
	 *            http methode
	 * @param uri
	 *            uri
	 * @return the string representation of the JSON response
	 * @throws BricklinkException
	 *             exception
	 */
	protected String returnJsonResponse(Method method, String uri) throws BricklinkException {

		return returnJsonResponse(method, uri, null);
	}

	/**
	 * Call the service and return the response.
	 * 
	 * @param method
	 *            http methode
	 * @param uri
	 *            uri
	 * @param parameters
	 *            request parameters
	 * @return the string representation of the JSON response
	 * @throws BricklinkException
	 *             exception
	 */
	protected String returnJsonResponse(Method method, String uri, Map<String, String> parameters)
			throws BricklinkException {

		String baseUrl = API_BASE_URL + uri;

		if (parameters != null) {
			StringBuilder params = new StringBuilder();
			for (Entry<String, String> param : parameters.entrySet()) {
				params.append("&" + param.getKey() + "=" + param.getValue());
			}
			baseUrl = baseUrl + "?" + params.substring(1);
		}

		String encodedUrl = buildUrl(method, baseUrl, parameters);

		return callRestService(method, encodedUrl);
	}

	/**
	 * Call the REST service with the encoded full url.
	 * 
	 * @param method
	 *            http method
	 * @param url
	 *            the url, complete with paramaters and authorization.
	 * @return the string representation of the JSON response
	 * @throws BricklinkException
	 *             exception
	 */
	private String callRestService(Method method, String url) throws BricklinkException {
		try {
			URL fullurl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) fullurl.openConnection();
			conn.setRequestMethod(method.name());
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new BricklinkException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			return new BufferedReader(new InputStreamReader(conn.getInputStream())).lines()
					.collect(Collectors.joining("\n"));
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

	/**
	 * Encode parameters.
	 * 
	 * @see <a href=
	 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/Authorization">Authentication
	 *      & Authorization</a>
	 * @param method
	 *            http method
	 * @param url
	 *            the url without any parameters
	 * @param parameters
	 *            url parameters
	 * @return the encoded parameters to add to the request
	 * @throws BricklinkException
	 *             exception
	 */
	private Map<String, String> encodeParameters(Method method, String url, Map<String, String> parameters)
			throws BricklinkException {

		BLAuthSigner signer = new BLAuthSigner(consumerKey, consumerSecret);
		signer.setToken(tokenValue, tokenSecret);
		signer.setVerb(method.name());
		signer.setURL(url);
		if (parameters != null) {
			for (Entry<String, String> param : parameters.entrySet()) {
				signer.addParameter(param.getKey(), param.getValue());
			}
		}

		return signer.getFinalOAuthParams();
	}

	/**
	 * Build the full url.
	 * 
	 * @param method
	 *            http method
	 * @param baseUrl
	 *            the url
	 * @param parameters
	 *            parameters
	 * @return the full url
	 * @throws BricklinkException
	 *             exception
	 */
	private String buildUrl(Method method, String url, Map<String, String> parameters) throws BricklinkException {

		Map<String, String> fullParameters = encodeParameters(method, url, parameters);

		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonStr = mapper.writeValueAsString(fullParameters);

			String urlS;
			if (url.contains("?")) {
				urlS = url + "&Authorization=" + URLEncoder.encode(jsonStr, StandardCharsets.UTF_8.toString());
			} else {
				urlS = url + "?Authorization=" + URLEncoder.encode(jsonStr, StandardCharsets.UTF_8.toString());
			}
			return urlS;
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

}
