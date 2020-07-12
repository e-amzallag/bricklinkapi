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
 * Describes a color.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/ColorResource#Color">Color</a>
 * 
 * @author Erik Amzallag
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Color implements DataInterface {

	/**
	 * ID of the color.
	 */
	@JsonProperty("color_id")
	private Integer colorId;

	/**
	 * The name of the color.
	 */
	@JsonProperty("color_name")
	private String colorName;

	/**
	 * HTML color code of this color.
	 */
	@JsonProperty("color_code")
	private String colorCode;

	/**
	 * The name of the color group that this color belongs to.
	 */
	@JsonProperty("color_type")
	private String colorType;

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
	 * @return the colorName
	 */
	public String getColorName() {
		return colorName;
	}

	/**
	 * @param colorName the colorName to set
	 */
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	/**
	 * @return the colorCode
	 */
	public String getColorCode() {
		return colorCode;
	}

	/**
	 * @param colorCode the colorCode to set
	 */
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	/**
	 * @return the colorType
	 */
	public String getColorType() {
		return colorType;
	}

	/**
	 * @param colorType the colorType to set
	 */
	public void setColorType(String colorType) {
		this.colorType = colorType;
	}

}
