package com.gullak.Loader;

import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.gullak.domain.MechantCategory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ClassPathResource;


@Component
public class MerchantCategoryLoader {
	
	@Value("classpath:merchantcategory.yml")
	private Resource merchantCategories;
	
	private static final Map<String,String> merchantCategoryMap = new HashMap<>();
	
	/**
	 * @return the merchantcategorymap
	 */
	public static Map<String, String> getMerchantcategorymap() {
		return merchantCategoryMap;
	}
	@PostConstruct
	public void initializePortinMessagesYmlfile()  {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		try {
			MechantCategory[] mechantCategory = mapper.readValue(merchantCategories.getInputStream(), MechantCategory[].class);
			for(MechantCategory element: mechantCategory) {
				String merchants=element.getMerchants();
				String[] merchantsList=merchants.split(",");
				for(String s:merchantsList) {
					System.out.println(s);
					merchantCategoryMap.put(s, element.getCategory());
				}
				
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	public String getMerchantCategory(String merchant) {
		if( merchant!= null) {
			return merchantCategoryMap.get(merchant);
		}
		return null;
	}
	
}
