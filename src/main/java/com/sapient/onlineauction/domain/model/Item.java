package com.sapient.onlineauction.domain.model;

public class Item {

	private String name;
	private int baseBidPrice;
	private String description;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the baseBidPrice
	 */
	public int getBaseBidPrice() {
		return baseBidPrice;
	}

	/**
	 * @param baseBidPrice
	 *            the baseBidPrice to set
	 */
	public void setBaseBidPrice(int baseBidPrice) {
		this.baseBidPrice = baseBidPrice;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
