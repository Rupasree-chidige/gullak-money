package com.gullak.domain;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Summary {
	
	private List<SummaryItem> summaryItemList;

	/**
	 * @return the summaryItemList
	 */
	public List<SummaryItem> getSummaryItemList() {
		return summaryItemList;
	}

	/**
	 * @param summaryItemList the summaryItemList to set
	 */
	public void setSummaryItemList(List<SummaryItem> summaryItemList) {
		this.summaryItemList = summaryItemList;
	}

}
