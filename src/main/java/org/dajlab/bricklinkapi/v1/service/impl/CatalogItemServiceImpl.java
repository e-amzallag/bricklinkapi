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

import java.util.HashMap;
import java.util.Map;

import org.dajlab.bricklinkapi.v1.enumeration.Method;
import org.dajlab.bricklinkapi.v1.enumeration.Type;
import org.dajlab.bricklinkapi.v1.service.ICatalogItemService;
import org.dajlab.bricklinkapi.v1.vo.BricklinkException;
import org.dajlab.bricklinkapi.v1.vo.Item;
import org.dajlab.bricklinkapi.v1.vo.KnownColorsList;
import org.dajlab.bricklinkapi.v1.vo.PriceGuide;
import org.dajlab.bricklinkapi.v1.vo.PriceGuideParametersRequest;
import org.dajlab.bricklinkapi.v1.vo.Response;
import org.dajlab.bricklinkapi.v1.vo.SubsetEntriesList;
import org.dajlab.bricklinkapi.v1.vo.SubsetParametersRequest;
import org.dajlab.bricklinkapi.v1.vo.SupersetEntriesList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of {@link ICatalogItemService}.
 * 
 *
 */
public class CatalogItemServiceImpl extends AbstractBricklinkService implements ICatalogItemService {

	/**
	 * Uri.
	 */
	private static final String BASE_URI = "/items/";

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
	public CatalogItemServiceImpl(String consumerKey, String consumerSecret, String tokenValue, String tokenSecret) {
		super(consumerKey, consumerSecret, tokenValue, tokenSecret);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Item getItem(Type type, String no) throws BricklinkException {

		String uri = BASE_URI + type.name() + "/" + no;
		String output = returnJsonResponse(Method.GET, uri);
		try {
			TypeReference<Response<Item>> ref = new TypeReference<Response<Item>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<Item> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Item getItemImage(Type type, String no, Integer colorId) throws BricklinkException {

		String uri = BASE_URI + type.name() + "/" + no + "/images/" + colorId;
		String output = returnJsonResponse(Method.GET, uri);
		try {
			TypeReference<Response<Item>> ref = new TypeReference<Response<Item>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<Item> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SupersetEntriesList getSupersets(Type type, String no) throws BricklinkException {

		return getSupersets(type, no, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SupersetEntriesList getSupersets(Type type, String no, Integer colorId) throws BricklinkException {

		Map<String, String> parameters = null;
		if (colorId != null) {
			parameters = new HashMap<>();
			parameters.put("color_id", colorId.toString());
		}
		String uri = BASE_URI + type.name() + "/" + no + "/supersets";
		String output = returnJsonResponse(Method.GET, uri, parameters);
		try {
			TypeReference<Response<SupersetEntriesList>> ref = new TypeReference<Response<SupersetEntriesList>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<SupersetEntriesList> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SubsetEntriesList getSubsets(Type type, String no) throws BricklinkException {

		return getSubsets(type, no, null);
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public SubsetEntriesList getSubsets(Type type, String no, SubsetParametersRequest parameters)
			throws BricklinkException {

		String uri = BASE_URI + type.name() + "/" + no + "/subsets";
		Map<String, String> mapParameters = null;
		if (parameters != null) {
			mapParameters = new HashMap<>();
			if (parameters.getColorId() != null) {
				mapParameters.put("color_id", parameters.getColorId().toString());
			}
			if (parameters.getBox() != null) {
				mapParameters.put("box", parameters.getBox().toString());
			}
			if (parameters.getInstruction() != null) {
				mapParameters.put("instruction", parameters.getInstruction().toString());
			}
			if (parameters.getBreakMinifigs() != null) {
				mapParameters.put("break_minifigs", parameters.getBreakMinifigs().toString());
			}
			if (parameters.getBreakSubsets() != null) {
				mapParameters.put("break_subsets", parameters.getBreakSubsets().toString());
			}
		}
		String output = returnJsonResponse(Method.GET, uri, mapParameters);
		try {
			TypeReference<Response<SubsetEntriesList>> ref = new TypeReference<Response<SubsetEntriesList>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<SubsetEntriesList> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PriceGuide getPrice(Type type, String no) throws BricklinkException {

		String uri = BASE_URI + type.name() + "/" + no + "/price";
		String output = returnJsonResponse(Method.GET, uri);
		try {
			TypeReference<Response<PriceGuide>> ref = new TypeReference<Response<PriceGuide>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<PriceGuide> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PriceGuide getPrice(Type type, String no, PriceGuideParametersRequest parameters) throws BricklinkException {

		String uri = BASE_URI + type.name() + "/" + no + "/price";
		Map<String, String> mapParameters = null;
		if (parameters != null) {
			mapParameters = new HashMap<>();
			if (parameters.getColorId() != null) {
				mapParameters.put("color_id", parameters.getColorId().toString());
			}
			if (parameters.getGuideType() != null) {
				mapParameters.put("guide_type", parameters.getGuideType().getCode());
			}
			if (parameters.getNewOrUsed() != null) {
				mapParameters.put("new_or_used", parameters.getNewOrUsed().getCode());
			}
			if (parameters.getCountryCode() != null) {
				mapParameters.put("country_code", parameters.getCountryCode());
			}
			if (parameters.getRegion() != null) {
				mapParameters.put("region", parameters.getRegion().getCode());
			}
			if (parameters.getCurrencyCode() != null) {
				mapParameters.put("currency_code", parameters.getCurrencyCode());
			}
			if (parameters.getVat() != null) {
				mapParameters.put("vat", parameters.getVat().getCode());
			}
		}

		String output = returnJsonResponse(Method.GET, uri, mapParameters);
		try {
			TypeReference<Response<PriceGuide>> ref = new TypeReference<Response<PriceGuide>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<PriceGuide> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public KnownColorsList getKnownColors(Type type, String no) throws BricklinkException {

		String uri = BASE_URI + type.name() + "/" + no + "/colors";
		String output = returnJsonResponse(Method.GET, uri);
		try {
			TypeReference<Response<KnownColorsList>> ref = new TypeReference<Response<KnownColorsList>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<KnownColorsList> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

}
