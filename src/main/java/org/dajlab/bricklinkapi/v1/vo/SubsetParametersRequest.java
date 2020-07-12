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

/**
 * Describes the optional parameters for the Price Guide request.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogMethod#Get-Subsets">Subset
 *      Entry</a>
 * @author Erik Amzallag
 *
 */
public class SubsetParametersRequest {

	/**
	 * The color of the item.
	 */
	private Integer colorId;

	/**
	 * Indicates whether the set includes the original box.
	 */
	private Boolean box;

	/**
	 * Indicates whether the set includes the original instruction.
	 */
	private Boolean instruction;

	/**
	 * Indicates whether the result breaks down minifigs as parts.
	 */
	private Boolean breakMinifigs;

	/**
	 * Indicates whether the result breaks down sets in set.
	 */
	private Boolean breakSubsets;

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
	 * @return the box
	 */
	public Boolean getBox() {
		return box;
	}

	/**
	 * @param box the box to set
	 */
	public void setBox(Boolean box) {
		this.box = box;
	}

	/**
	 * @return the instruction
	 */
	public Boolean getInstruction() {
		return instruction;
	}

	/**
	 * @param instruction the instruction to set
	 */
	public void setInstruction(Boolean instruction) {
		this.instruction = instruction;
	}

	/**
	 * @return the breakMinifigs
	 */
	public Boolean getBreakMinifigs() {
		return breakMinifigs;
	}

	/**
	 * @param breakMinifigs the breakMinifigs to set
	 */
	public void setBreakMinifigs(Boolean breakMinifigs) {
		this.breakMinifigs = breakMinifigs;
	}

	/**
	 * @return the breakSubsets
	 */
	public Boolean getBreakSubsets() {
		return breakSubsets;
	}

	/**
	 * @param breakSubsets the breakSubsets to set
	 */
	public void setBreakSubsets(Boolean breakSubsets) {
		this.breakSubsets = breakSubsets;
	}

}
