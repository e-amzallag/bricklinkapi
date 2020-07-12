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
package org.dajlab.bricklinkapi.v1.service;

/**
 * Services for Bricklink.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki">http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki</a>
 * @author Erik Amzallag
 *
 */
public interface IBricklinkService {

	/**
	 * 
	 * @return the CatalogItem service.
	 */
	ICatalogItemService getCatalogItem();

	/**
	 * 
	 * @return the Color service.
	 */
	IColorService getColor();

	/**
	 * 
	 * @return the Category service.
	 */
	ICategoryService getCategory();

	/**
	 * 
	 * @return the Item Mapping service.
	 */
	IItemMappingService getItemMapping();
}
