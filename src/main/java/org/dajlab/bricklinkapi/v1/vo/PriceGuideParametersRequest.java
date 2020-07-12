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

import org.dajlab.bricklinkapi.v1.enumeration.GuideType;
import org.dajlab.bricklinkapi.v1.enumeration.NewOrUsed;
import org.dajlab.bricklinkapi.v1.enumeration.Region;
import org.dajlab.bricklinkapi.v1.enumeration.Vat;

/**
 * Describes the optional parameters for the Price Guide request.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogMethod#Get-Price-Guide">Price
 *      Guide</a>
 * @author Erik Amzallag
 *
 */
public class PriceGuideParametersRequest {

	/**
	 * The color of the item.
	 */
	private Integer colorId;

	/**
	 * Indicates that which statistics to be provided. Acceptable values are:
	 * <li>"Sold": Gets the price statistics of "Last 6 Months Sales"
	 * <li>"Stock": Gets the price statistics of "Current Items for Sale" (default)
	 */
	private GuideType guideType;

	/**
	 * Indicates the condition of items that are included in the statistics.
	 * Acceptable values are:
	 * <li>"New": new item (default)
	 * <li>"Used": used item
	 */
	private NewOrUsed newOrUsed;

	/**
	 * The result includes only items in stores which are located in specified
	 * country. If you don't specify both country_code and region, this method
	 * retrieves the price information regardless of the store's location
	 */
	private String countryCode;

	/**
	 * The result includes only items in stores which are located in specified
	 * region. If you don't specify both country_code and region, this method
	 * retrieves the price information regardless of the store's location
	 */
	private Region region;

	/**
	 * This method returns price in the specified currency code. If you don't
	 * specify this value, price is retrieved in the base currency of the user
	 * profile's
	 */
	private String currencyCode;

	/**
	 * Indicates that price will include VAT for the items of VAT enabled stores.
	 * Available values are:
	 * <li>"N": Exclude VAT (default)
	 * <li>"Y": Include VAT
	 * <li>"O": Include VAT as Norway settings
	 */
	private Vat vat;

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
	 * @return the guideType
	 */
	public GuideType getGuideType() {
		return guideType;
	}

	/**
	 * @param guideType the guideType to set
	 */
	public void setGuideType(GuideType guideType) {
		this.guideType = guideType;
	}

	/**
	 * @return the newOrUsed
	 */
	public NewOrUsed getNewOrUsed() {
		return newOrUsed;
	}

	/**
	 * @param newOrUsed the newOrUsed to set
	 */
	public void setNewOrUsed(NewOrUsed newOrUsed) {
		this.newOrUsed = newOrUsed;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @return the currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode the currencyCode to set
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @return the vat
	 */
	public Vat getVat() {
		return vat;
	}

	/**
	 * @param vat the vat to set
	 */
	public void setVat(Vat vat) {
		this.vat = vat;
	}

}
