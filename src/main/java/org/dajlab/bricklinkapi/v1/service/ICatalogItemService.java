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

import org.dajlab.bricklinkapi.v1.enumeration.Type;
import org.dajlab.bricklinkapi.v1.vo.BricklinkException;
import org.dajlab.bricklinkapi.v1.vo.Item;
import org.dajlab.bricklinkapi.v1.vo.KnownColorsList;
import org.dajlab.bricklinkapi.v1.vo.PriceGuide;
import org.dajlab.bricklinkapi.v1.vo.PriceGuideParametersRequest;
import org.dajlab.bricklinkapi.v1.vo.SubsetEntriesList;
import org.dajlab.bricklinkapi.v1.vo.SubsetParametersRequest;
import org.dajlab.bricklinkapi.v1.vo.SupersetEntriesList;

/**
 * Service for the Bricklink catalog.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogMethod">Catalog</a>
 * @author Erik Amzallag
 *
 */
public interface ICatalogItemService {

	/**
	 * This method returns information about the specified item in BrickLink
	 * catalog.
	 * 
	 * @see <a href=
	 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogMethod#Get-Item">Get
	 *      Item</a>
	 * @param type The type of the item to get
	 * @param no   Identification number of the item to get
	 * 
	 * @return a catalog item
	 * @throws BricklinkException exception
	 */
	Item getItem(Type type, String no) throws BricklinkException;

	/**
	 * This method returns image URL of the specified item by colors.
	 * 
	 * @see <a href=
	 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogMethod#Get-Item-Image">Get
	 *      Item Image</a>
	 * @param type    type
	 * @param no      identification number
	 * @param colorId color id
	 * @return image url
	 * @throws BricklinkException exception
	 */
	Item getItemImage(Type type, String no, Integer colorId) throws BricklinkException;

	/**
	 * This method returns a list of items that include the specified item.
	 * 
	 * @see <a href=
	 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogMethod#Get-Supersets">Get
	 *      Supersets</a>
	 * @param type The type of the item.
	 * @param no   Identification number of the item
	 * @return list of items
	 * @throws BricklinkException exception
	 */
	SupersetEntriesList getSupersets(Type type, String no) throws BricklinkException;

	/**
	 * This method returns a list of items that include the specified item.
	 * 
	 * @see <a href=
	 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogMethod#Get-Supersets">Get
	 *      Supersets</a>
	 * @param type    The type of the item.
	 * @param no      Identification number of the item
	 * @param colorId The color of the item
	 * @return a list of superset entries
	 * @throws BricklinkException exception
	 */
	SupersetEntriesList getSupersets(Type type, String no, Integer colorId) throws BricklinkException;

	/**
	 * This method returns a list of items that are included in the specified item.
	 * 
	 * @param type The type of the item.
	 * @param no   Identification number of the item
	 * @return a nested list of subset entries
	 * @throws BricklinkException exception
	 */
	SubsetEntriesList getSubsets(Type type, String no) throws BricklinkException;

	/**
	 * This method returns a list of items that are included in the specified item.
	 * 
	 * @param type       The type of the item.
	 * @param no         Identification number of the item
	 * @param parameters optional parameters
	 * @return a nested list of subset entries
	 * @throws BricklinkException exception
	 */
	SubsetEntriesList getSubsets(Type type, String no, SubsetParametersRequest parameters) throws BricklinkException;

	/**
	 * This method returns the price statistics of the specified item in BrickLink
	 * catalog.
	 * 
	 * @see <a href=
	 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogMethod#Get-Price-Guide">Get
	 *      Price Guide</a>
	 * @param type The type of the item.
	 * @param no   Identification number of the item
	 * @return a price guide
	 * @throws BricklinkException exception
	 */
	PriceGuide getPrice(Type type, String no) throws BricklinkException;

	/**
	 * This method returns the price statistics of the specified item in BrickLink
	 * catalog.
	 * 
	 * @see <a href=
	 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogMethod#Get-Price-Guide">Get
	 *      Price Guide</a>
	 * @param type       The type of the item.
	 * @param no         Identification number of the item
	 * @param parameters optional parameters
	 * @return a price guide
	 * @throws BricklinkException exception
	 */
	PriceGuide getPrice(Type type, String no, PriceGuideParametersRequest parameters) throws BricklinkException;

	/**
	 * This method returns currently known colors of the item.
	 * 
	 * @see <a href=
	 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogMethod#Get-Known-Colors">Get
	 *      Known Colors</a>
	 * @param type The type of the item.
	 * @param no   Identification number of the item
	 * @return a list of known colors
	 * @throws BricklinkException exception
	 */
	KnownColorsList getKnownColors(Type type, String no) throws BricklinkException;
}
