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
package org.dajlab.bricklinkapi.v1.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Entry of a SubsetEntry.
 * 
 * @author Erik Amzallag
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubsetEntryEntry {

	/**
	 * An object representation of the item that is included in the specified item.
	 */
	private EntryItem item;

	/**
	 * The ID of the color of the item.
	 */
	@JsonProperty("color_id")
	private Integer colorId;

	/**
	 * The number of items that are included in.
	 */
	private Integer quantity;

	/**
	 * The number of items that are appear as "extra" item.
	 */
	@JsonProperty("extra_quantity")
	private Integer extraQuantity;

	/**
	 * Indicates that the item is appear as "alternate" item in this specified item.
	 */
	@JsonProperty("is_alternate")
	private String isAlternate;

	/**
	 * @return the item
	 */
	public EntryItem getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(EntryItem item) {
		this.item = item;
	}

	/**
	 * @return the colorId
	 */
	public Integer getColorId() {
		return colorId;
	}

	/**
	 * @param colorId the colorId to set
	 */
	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the extraQuantity
	 */
	public Integer getExtraQuantity() {
		return extraQuantity;
	}

	/**
	 * @param extraQuantity the extraQuantity to set
	 */
	public void setExtraQuantity(Integer extraQuantity) {
		this.extraQuantity = extraQuantity;
	}

	/**
	 * @return the isAlternate
	 */
	public String getIsAlternate() {
		return isAlternate;
	}

	/**
	 * @param isAlternate the isAlternate to set
	 */
	public void setIsAlternate(String isAlternate) {
		this.isAlternate = isAlternate;
	}

}
