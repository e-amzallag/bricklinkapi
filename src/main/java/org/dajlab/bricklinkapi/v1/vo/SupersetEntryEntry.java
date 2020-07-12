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
 * Entry of a SupersetEntry.
 * 
 * @author Erik Amzallag
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupersetEntryEntry {

	/**
	 * An object representation of the super item that includes the specified item.
	 */
	private EntryItem item;

	/**
	 * Indicates that how many specified items are included in this super item.
	 */
	private Integer quantity;

	/**
	 * Indicates how an entry in an inventory appears as.<br>
	 * A: Alternate, C: Counterpart, E: Extra, R: Regular
	 */
	@JsonProperty("appear_as")
	private String appearAs;

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
	 * @return the appearAs
	 */
	public String getAppearAs() {
		return appearAs;
	}

	/**
	 * @param appearAs the appearAs to set
	 */
	public void setAppearAs(String appearAs) {
		this.appearAs = appearAs;
	}

}
