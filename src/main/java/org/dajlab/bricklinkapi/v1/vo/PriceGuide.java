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

import java.util.Collection;

import org.dajlab.bricklinkapi.v1.enumeration.NewOrUsed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a price guide.
 * 
 * @see <a href=
 *      "http://apidev.bricklink.com/redmine/projects/bricklink-api/wiki/CatalogResource#Price-Guide">Price
 *      Guide</a>
 * 
 * @author Erik Amzallag
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceGuide implements DataInterface {

	/**
	 * An object representation of the item.
	 */
	private BasicItem item;

	/**
	 * Indicates whether the price guide is for new or used.
	 */
	@JsonProperty("new_or_used")
	private NewOrUsed newOrUsed;

	/**
	 * The currency code of the price.
	 */
	@JsonProperty("currency_code")
	private String currencyCode;

	/**
	 * The lowest price of the item (in stock / that was sold for last 6 months ).
	 */
	@JsonProperty("min_price")
	private Double minPrice;

	/**
	 * The highest price of the item (in stock / that was sold for last 6 months ).
	 */
	@JsonProperty("max_price")
	private Double maxPrice;

	/**
	 * The average price of the item (in stock / that was sold for last 6 months ).
	 */
	@JsonProperty("avg_price")
	private Double avgPrice;

	/**
	 * The average price of the item (in stock / that was sold for last 6 months )
	 * by quantity.
	 */
	@JsonProperty("qty_avg_price")
	private Double qtyAvgPrice;

	/**
	 * The number of times the item has been sold for last 6 months.<br>
	 * The number of inventories that include the item.
	 */
	@JsonProperty("unit_quantity")
	private String unitQuantity;

	/**
	 * The number of items has been sold for last 6 months.<br>
	 * The total number of the items in stock.
	 */
	@JsonProperty("total_quantity")
	private String totalQuantity;

	/**
	 * A list of objects that represent the detailed information of the price.
	 */
	@JsonProperty("price_detail")
	private Collection<PriceDetail> priceDetail;

	/**
	 * @return the item
	 */
	public BasicItem getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(BasicItem item) {
		this.item = item;
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
	 * @return the minPrice
	 */
	public Double getMinPrice() {
		return minPrice;
	}

	/**
	 * @param minPrice the minPrice to set
	 */
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	/**
	 * @return the maxPrice
	 */
	public Double getMaxPrice() {
		return maxPrice;
	}

	/**
	 * @param maxPrice the maxPrice to set
	 */
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	/**
	 * @return the avgPrice
	 */
	public Double getAvgPrice() {
		return avgPrice;
	}

	/**
	 * @param avgPrice the avgPrice to set
	 */
	public void setAvgPrice(Double avgPrice) {
		this.avgPrice = avgPrice;
	}

	/**
	 * @return the qtyAvgPrice
	 */
	public Double getQtyAvgPrice() {
		return qtyAvgPrice;
	}

	/**
	 * @param qtyAvgPrice the qtyAvgPrice to set
	 */
	public void setQtyAvgPrice(Double qtyAvgPrice) {
		this.qtyAvgPrice = qtyAvgPrice;
	}

	/**
	 * @return the unitQuantity
	 */
	public String getUnitQuantity() {
		return unitQuantity;
	}

	/**
	 * @param unitQuantity the unitQuantity to set
	 */
	public void setUnitQuantity(String unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	/**
	 * @return the totalQuantity
	 */
	public String getTotalQuantity() {
		return totalQuantity;
	}

	/**
	 * @param totalQuantity the totalQuantity to set
	 */
	public void setTotalQuantity(String totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	/**
	 * @return the priceDetail
	 */
	public Collection<PriceDetail> getPriceDetail() {
		return priceDetail;
	}

	/**
	 * @param priceDetail the priceDetail to set
	 */
	public void setPriceDetail(Collection<PriceDetail> priceDetail) {
		this.priceDetail = priceDetail;
	}

}
