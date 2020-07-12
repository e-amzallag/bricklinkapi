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

import org.dajlab.bricklinkapi.v1.service.IBricklinkService;
import org.dajlab.bricklinkapi.v1.service.ICatalogItemService;
import org.dajlab.bricklinkapi.v1.service.ICategoryService;
import org.dajlab.bricklinkapi.v1.service.IColorService;
import org.dajlab.bricklinkapi.v1.service.IItemMappingService;

/**
 * Implementation of {@link IBricklinkService}
 * 
 *
 */
public class BricklinkServiceImpl implements IBricklinkService {

	/**
	 * Category service.
	 */
	private ICategoryService categoryService;

	/**
	 * Catalog service.
	 */
	private ICatalogItemService catalogService;

	/**
	 * Color service.
	 */
	private IColorService colorService;

	/**
	 * Item mapping service.
	 */
	private IItemMappingService itemMappingService;

	/**
	 * Constructor.
	 * 
	 * @param consumerKey
	 * @param consumerSecret
	 * @param tokenValue
	 * @param tokenSecret
	 */
	public BricklinkServiceImpl(String consumerKey, String consumerSecret, String tokenValue, String tokenSecret) {

		categoryService = new CategoryServiceImpl(consumerKey, consumerSecret, tokenValue, tokenSecret);
		catalogService = new CatalogItemServiceImpl(consumerKey, consumerSecret, tokenValue, tokenSecret);
		colorService = new ColorServiceImpl(consumerKey, consumerSecret, tokenValue, tokenSecret);
		itemMappingService = new ItemMappingServiceImpl(consumerKey, consumerSecret, tokenValue, tokenSecret);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICatalogItemService getCatalogItem() {

		return catalogService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IColorService getColor() {

		return colorService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICategoryService getCategory() {

		return categoryService;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IItemMappingService getItemMapping() {

		return itemMappingService;
	}

}
