package com.gullak.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gullak.Loader.MerchantCategoryLoader;
import com.gullak.domain.SMS;
import com.gullak.domain.Summary;
import com.gullak.domain.SummaryItem;


@Service
public class SMSCategorizeImpl implements SMSCategorize{
	
	@Autowired
	private MerchantCategoryLoader merchantCategoryLoader;


	@Override
	public Summary categorize(List<SMS> sms) {
		Summary summaryResponse=new Summary();
		HashMap<String,SummaryItem> hm=new HashMap<>();
		for(SMS s:sms) {
			String amountString=searchAmount(s.getText());
			double amount=0;
			if(amountString!=null)
				amount=Double.parseDouble(amountString);
			String searchkey=searchDefinition(s.getText(),MerchantCategoryLoader.getMerchantcategorymap());
			if(searchkey!=null) {
				String category=merchantCategoryLoader.getMerchantCategory(searchkey);
				if(hm.containsKey(category)) {
					SummaryItem summaryItem=hm.get(category);
					summaryItem.setTotalAmount(summaryItem.getTotalAmount()+amount);
					summaryItem.getSmsArray().add(s);
				}else {
					SummaryItem summaryItem=new SummaryItem();
					summaryItem.setCategory(category);
					summaryItem.setTotalAmount(amount);
					List<SMS> smsArray=new ArrayList<>();
					smsArray.add(s);
					summaryItem.setSmsArray(smsArray);
					hm.put(category, summaryItem);
				}
			}
		}
		List<SummaryItem> summary=new ArrayList<>();
		for (SummaryItem s : hm.values()) {
			summary.add(s);
		}
		summaryResponse.setSummaryItemList(summary);
		return summaryResponse;
	}
	/*
	 * */
	private String searchDefinition(String regex,Map<String, String> map) {
	    Set<String> keys = map.keySet();
	    for(String key:keys) {
	    	if(regex.toLowerCase().contains(key.toLowerCase())){
	        	return key;
	        }
	    }
	    return null;

	   }
	private String searchAmount(String text) {
		String pattern="Rs[.\\s]*[0-9,]+[.]*[0-9]*";
        Pattern pattern1 = Pattern.compile(pattern);    
        //String text="Thank you for using your Kotak Debit card X2678. Rs.378.00 is debited at Dominos Pizza Hyderabad. on 05-12-2020. Avl balance is Rs.13,909.21";
        Matcher matcher = pattern1.matcher(text);    
        boolean found = matcher.find();   
        while (found) {
            String ans=matcher.group().replace("Rs","").replace(",","").trim();
            if(ans.startsWith(".")){
                return ans.substring(1); 
            }
             return ans;
        } 
        return null;
	}
}
	
