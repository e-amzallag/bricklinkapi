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
import org.dajlab.bricklinkapi.v1.service.ICategoryService;
import org.dajlab.bricklinkapi.v1.vo.BricklinkException;
import org.dajlab.bricklinkapi.v1.vo.CategoriesList;
import org.dajlab.bricklinkapi.v1.vo.Category;
import org.dajlab.bricklinkapi.v1.vo.Response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Implementation of {@link ICategoryService}
 * 
 *
 */
public class CategoryServiceImpl extends AbstractBricklinkService implements ICategoryService {

	/**
	 * Uri.
	 */
	private static final String BASE_URI = "/categories";

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
	public CategoryServiceImpl(String consumerKey, String consumerSecret, String tokenValue, String tokenSecret) {
		super(consumerKey, consumerSecret, tokenValue, tokenSecret);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CategoriesList getCategoryList() throws BricklinkException {

		String uri = BASE_URI;
		String output = returnJsonResponse(Method.GET, uri);
		try {
			TypeReference<Response<CategoriesList>> ref = new TypeReference<Response<CategoriesList>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<CategoriesList> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Category getCategory(Integer categoryId) throws BricklinkException {

		String uri = BASE_URI + "/" + categoryId.toString();
		String output = returnJsonResponse(Method.GET, uri);
		try {
			TypeReference<Response<Category>> ref = new TypeReference<Response<Category>>() {
			};
			ObjectMapper mapper = new ObjectMapper();
			Response<Category> response = mapper.readValue(output, ref);
			return response.getData();
		} catch (Exception e) {
			throw new BricklinkException(e.getMessage());
		}
	}

}
