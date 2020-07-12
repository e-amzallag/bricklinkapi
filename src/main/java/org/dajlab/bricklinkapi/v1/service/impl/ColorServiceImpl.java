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

import org.dajlab.bricklinkapi.v1.enumeration.Method;
import org.dajlab.bricklinkapi.v1.service.IColorService;
import org.dajlab.bricklinkapi.v1.vo.BricklinkException;
import org.dajlab.bricklinkapi.v1.vo.Color;
import org.dajlab.bricklinkapi.v1.vo.ColorsList;
import org.dajlab.bricklinkapi.v1.vo.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of {@link IColorService}
 * 
 *
 */
public class ColorServiceImpl extends AbstractBricklinkService implements IColorService {

	/**
	 * URI.
	 */
	private static final String BASE_URI = "/colors";

	/**
	 * Constructor.
	 * 
	 * @param consumerKey
	 * @param consumerSecret
	 * @param tokenValue
	 * @param tokenSecret
	 */
	public ColorServiceImpl(String consumerKey, String consumerSecret, String tokenValue, String tokenSecret) {
		super(consumerKey, consumerSecret, tokenValue, tokenSecret);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ColorsList getColorList() throws BricklinkException {
		String uri = BASE_URI;
		String output = returnJsonResponse(Method.GET, uri);
		try {
			TypeReference<Response<ColorsList>> ref = new TypeReference<Response<ColorsList>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<ColorsList> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getColor(Integer colorId) throws BricklinkException {
		String uri = BASE_URI + "/" + colorId.toString();
		String output = returnJsonResponse(Method.GET, uri);
		try {
			TypeReference<Response<Color>> ref = new TypeReference<Response<Color>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<Color> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

}
