package com.gullak.domain;

import java.util.List;

public class SummaryItem {
	private String category;
	private double totalAmount;
	private List<SMS> smsArray;
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the totalAmount
	 */
	public double getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return the smsArray
	 */
	public List<SMS> getSmsArray() {
		return smsArray;
	}
	/**
	 * @param smsArray the smsArray to set
	 */
	public void setSmsArray(List<SMS> smsArray) {
		this.smsArray = smsArray;
	}

}
