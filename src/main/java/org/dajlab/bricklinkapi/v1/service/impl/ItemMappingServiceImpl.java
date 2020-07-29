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
import org.dajlab.bricklinkapi.v1.service.IItemMappingService;
import org.dajlab.bricklinkapi.v1.vo.BricklinkException;
import org.dajlab.bricklinkapi.v1.vo.ItemMappingList;
import org.dajlab.bricklinkapi.v1.vo.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of {@link IItemMappingService}
 * 
 *
 */
public class ItemMappingServiceImpl extends AbstractBricklinkService implements IItemMappingService {

	/**
	 * Uri.
	 */
	private static final String BASE_URI = "/item_mapping/";

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
	public ItemMappingServiceImpl(String consumerKey, String consumerSecret, String tokenValue, String tokenSecret) {
		super(consumerKey, consumerSecret, tokenValue, tokenSecret);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemMappingList getElementId(String no) throws BricklinkException {

		return getElementId(no, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemMappingList getElementId(String no, Integer colorId) throws BricklinkException {

		Map<String, String> parameters = null;
		if (colorId != null) {
			parameters = new HashMap<>();
			parameters.put("color_id", colorId.toString());
		}
		String uri = BASE_URI + Type.PART.name() + "/" + no;
		String output = returnJsonResponse(Method.GET, uri, parameters);
		try {
			TypeReference<Response<ItemMappingList>> ref = new TypeReference<Response<ItemMappingList>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<ItemMappingList> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ItemMappingList getItemNumber(String elementId) throws BricklinkException {

		String uri = BASE_URI + elementId;
		String output = returnJsonResponse(Method.GET, uri);
		try {
			TypeReference<Response<ItemMappingList>> ref = new TypeReference<Response<ItemMappingList>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<ItemMappingList> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

}
