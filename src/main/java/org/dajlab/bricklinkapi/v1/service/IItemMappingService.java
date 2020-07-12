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
import org.dajlab.bricklinkapi.v1.vo.ItemMappingList;

/**
 * Interface for item mapping.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/ItemMappingMethod">Item
 *      Mapping Method</a>
 * @author Erik Amzallag
 *
 */
public interface IItemMappingService {

	/**
	 * This method returns Part-Color-Code(A.K.A ElementID) of the specified item.
	 * 
	 * @param no Identification number of an item to get.
	 * @return a item mapping resource
	 * @throws BricklinkException exception
	 */
	ItemMappingList getElementId(String no) throws BricklinkException;

	/**
	 * This method returns Part-Color-Code(A.K.A ElementID) of the specified item.
	 * 
	 * @param no      Identification number of an item to get.
	 * @param colorId Color ID of an item. If not specified, API retrieves element
	 *                IDs of an item in any colors.
	 * @return a item mapping resource
	 * @throws BricklinkException exception
	 */
	ItemMappingList getElementId(String no, Integer colorId) throws BricklinkException;

	/**
	 * This method returns BL Catalog Item Number by Part-Color-Code(A.K.A
	 * ElementID).
	 * 
	 * @param elementId Element ID of the item in specific color
	 * @return item mapping resource
	 * @throws BricklinkException exception
	 */
	ItemMappingList getItemNumber(String elementId) throws BricklinkException;

}
