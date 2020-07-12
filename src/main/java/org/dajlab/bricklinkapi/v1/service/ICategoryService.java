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

import org.dajlab.bricklinkapi.v1.vo.BricklinkException;
import org.dajlab.bricklinkapi.v1.vo.CategoriesList;
import org.dajlab.bricklinkapi.v1.vo.Category;

/**
 * Service for Bricklink categories.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CategoryMethod">Category</a>
 * @author Erik Amzallag
 *
 */
public interface ICategoryService {

	/**
	 * This method retrieves a list of the categories defined within BrickLink
	 * catalog.
	 * 
	 * @return a list of category resource
	 * @throws BricklinkException exception
	 */
	CategoriesList getCategoryList() throws BricklinkException;

	/**
	 * This method retrieves information about a specific category.
	 * 
	 * @param categoryId The ID of the category to get
	 * @return a category resource
	 * @throws BricklinkException exception
	 */
	Category getCategory(Integer categoryId) throws BricklinkException;
}
