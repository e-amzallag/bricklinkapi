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

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a price detail.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogResource#Price-Detail">Price
 *      Detail</a>
 * @author Erik Amzallag
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDetail {

	/**
	 * The number of the items in the inventory.
	 */
	private Integer quantity;

	/**
	 * The original price of this item per sale unit (Current Items for Sale)<br>
	 * The original price of this item per sale unit (Last 6 Months Sales)
	 */
	@JsonProperty("unit_price")
	private Double unitPrice;

	/**
	 * Indicates whether or not the seller ships to your country(based on the user
	 * profile).
	 */
	@JsonProperty("shipping_available")
	private String shippingAvailable;

	/**
	 * The country code of the seller's location (Last 6 Months Sales)
	 */
	@JsonProperty("seller_country_code")
	private String sellerCountryCode;

	/**
	 * The country code of the buyer's location (Last 6 Months Sales)
	 */
	@JsonProperty("buyer_country_code")
	private String buyerCountryCode;

	/**
	 * The time the order was created (Last 6 Months Sales)
	 */
	@JsonProperty("date_ordered")
	private Calendar dateOrdered;

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
	 * @return the unitPrice
	 */
	public Double getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the shippingAvailable
	 */
	public String getShippingAvailable() {
		return shippingAvailable;
	}

	/**
	 * @param shippingAvailable the shippingAvailable to set
	 */
	public void setShippingAvailable(String shippingAvailable) {
		this.shippingAvailable = shippingAvailable;
	}

	/**
	 * @return the sellerCountryCode
	 */
	public String getSellerCountryCode() {
		return sellerCountryCode;
	}

	/**
	 * @param sellerCountryCode the sellerCountryCode to set
	 */
	public void setSellerCountryCode(String sellerCountryCode) {
		this.sellerCountryCode = sellerCountryCode;
	}

	/**
	 * @return the buyerCountryCode
	 */
	public String getBuyerCountryCode() {
		return buyerCountryCode;
	}

	/**
	 * @param buyerCountryCode the buyerCountryCode to set
	 */
	public void setBuyerCountryCode(String buyerCountryCode) {
		this.buyerCountryCode = buyerCountryCode;
	}

	/**
	 * @return the dateOrdered
	 */
	public Calendar getDateOrdered() {
		return dateOrdered;
	}

	/**
	 * @param dateOrdered the dateOrdered to set
	 */
	public void setDateOrdered(Calendar dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

}
