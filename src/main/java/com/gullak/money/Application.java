package com.gullak.money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.gullak.Loader.MerchantCategoryLoader;
import com.gullak.controller.SMSCategoryContoller;

@SpringBootApplication
@ComponentScan({"com.gullak.money","com.gullak.controller","com.gullak.domain","com.gullak.service","com.gullak.Loader"})
public class Application {
	
//	@Autowired
//	private static MerchantCategoryLoader merchantCategoryLoader;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//MerchantCategoryLoader merchantCategoryLoader = new MerchantCategoryLoader();
		//merchantCategoryLoader.initializePortinMessagesYmlfile();
		//System.out.println(merchantCategoryLoader.getMerchantCategory("amazon"));
	}

}
