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

import org.dajlab.bricklinkapi.v1.enumeration.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes an item.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogResource#Item">Item</a>
 * 
 * @author Erik Amzallag
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements DataInterface {

	/**
	 * Item's identification number in BrickLink catalog.
	 */
	private String no;
	/**
	 * The name of the item.
	 */
	private String name;
	/**
	 * The type of the item.
	 */
	private Type type;
	/**
	 * The main category of the item.
	 */
	@JsonProperty("category_id")
	private Integer categoryId;
	/**
	 * Alternate item number.
	 */
	@JsonProperty("alternate_no")
	private String alternateNo;
	/**
	 * Image link for this item.
	 */
	@JsonProperty("image_url")
	private String imageUrl;
	/**
	 * Image thumbnail link for this item.
	 */
	@JsonProperty("thumbnail_url")
	private String thumbnailUrl;
	/**
	 * The weight of the item in grams.
	 */
	private Double weight;
	/**
	 * Length of the item.
	 */
	@JsonProperty("dim_x")
	private String dimX;
	/**
	 * Width of the item.
	 */
	@JsonProperty("dim_y")
	private String dimY;
	/**
	 * Height of the item.
	 */
	@JsonProperty("dim_z")
	private String dimZ;
	/**
	 * Item year of release.
	 */
	@JsonProperty("year_released")
	private Integer yearReleased;
	/**
	 * Short description for this item.
	 */
	private String description;
	/**
	 * Indicates whether the item is obsolete.
	 */
	@JsonProperty("is_obsolete")
	private Boolean obsolete;
	/**
	 * Item language code.
	 */
	@JsonProperty("language_code")
	private String languageCode;

	/**
	 * @return the no
	 */
	public String getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(String no) {
		this.no = no;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the alternateNo
	 */
	public String getAlternateNo() {
		return alternateNo;
	}

	/**
	 * @param alternateNo the alternateNo to set
	 */
	public void setAlternateNo(String alternateNo) {
		this.alternateNo = alternateNo;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the thumbnailUrl
	 */
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	/**
	 * @param thumbnailUrl the thumbnailUrl to set
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * @return the dimX
	 */
	public String getDimX() {
		return dimX;
	}

	/**
	 * @param dimX the dimX to set
	 */
	public void setDimX(String dimX) {
		this.dimX = dimX;
	}

	/**
	 * @return the dimY
	 */
	public String getDimY() {
		return dimY;
	}

	/**
	 * @param dimY the dimY to set
	 */
	public void setDimY(String dimY) {
		this.dimY = dimY;
	}

	/**
	 * @return the dimZ
	 */
	public String getDimZ() {
		return dimZ;
	}

	/**
	 * @param dimZ the dimZ to set
	 */
	public void setDimZ(String dimZ) {
		this.dimZ = dimZ;
	}

	/**
	 * @return the yearReleased
	 */
	public Integer getYearReleased() {
		return yearReleased;
	}

	/**
	 * @param yearReleased the yearReleased to set
	 */
	public void setYearReleased(Integer yearReleased) {
		this.yearReleased = yearReleased;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the obsolete
	 */
	public Boolean getObsolete() {
		return obsolete;
	}

	/**
	 * @param obsolete the obsolete to set
	 */
	public void setObsolete(Boolean obsolete) {
		this.obsolete = obsolete;
	}

	/**
	 * @return the languageCode
	 */
	public String getLanguageCode() {
		return languageCode;
	}

	/**
	 * @param languageCode the languageCode to set
	 */
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

}
