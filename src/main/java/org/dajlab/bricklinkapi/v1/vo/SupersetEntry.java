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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a Superset entry.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogResource#Superset-Entry">Superset
 *      Entry</a>
 * @author Erik Amzallag
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupersetEntry implements DataInterface {

	/**
	 * The ID of the color of the item.
	 */
	@JsonProperty("color_id")
	private Integer colorId;

	/**
	 * A list of the items that include the specified item.
	 */
	private List<SupersetEntryEntry> entries;

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
	 * @return the entries
	 */
	public List<SupersetEntryEntry> getEntries() {
		return entries;
	}

	/**
	 * @param entries the entries to set
	 */
	public void setEntries(List<SupersetEntryEntry> entries) {
		this.entries = entries;
	}

}
