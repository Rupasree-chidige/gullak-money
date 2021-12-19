package com.gullak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gullak.domain.SMS;
import com.gullak.domain.Summary;
import com.gullak.service.SMSCategorize;

@RestController
public class SMSCategoryContoller {
	
	@Autowired
	private SMSCategorize smsCategorize;
	@Autowired
	private Summary summary;
	
	 	@PostMapping("summary")
	    public ResponseEntity<?> getSummary(@RequestBody List<SMS> sms){
	 		try {
	 			 summary=smsCategorize.categorize(sms);
	 		} catch(Exception e) {
	 			 return new ResponseEntity<>("Internal server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	 		}
		 return new ResponseEntity<Summary>(summary, HttpStatus.OK);
	    }
	 
}
