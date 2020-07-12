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
 * 
 * Describes a SubsetEntry.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogResource#Subset-Entry">Subset
 *      Entry</a>
 * @author Erik Amzallag
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubsetEntry implements DataInterface {

	/**
	 * A identification number given to a matching group that consists of regular
	 * items and alternate items.
	 */
	@JsonProperty("match_no")
	private Integer matchNo;

	/**
	 * A list of the items that include the specified item.
	 */
	private List<SubsetEntryEntry> entries;

	/**
	 * @return the matchNo
	 */
	public Integer getMatchNo() {
		return matchNo;
	}

	/**
	 * @param matchNo the matchNo to set
	 */
	public void setMatchNo(Integer matchNo) {
		this.matchNo = matchNo;
	}

	/**
	 * @return the entries
	 */
	public List<SubsetEntryEntry> getEntries() {
		return entries;
	}

	/**
	 * @param entries the entries to set
	 */
	public void setEntries(List<SubsetEntryEntry> entries) {
		this.entries = entries;
	}

}
