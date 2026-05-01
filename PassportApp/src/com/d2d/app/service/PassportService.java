package com.d2d.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.d2d.app.db.PassportDB;
import com.d2d.app.entity.Passport;

public class PassportService {
	
	
	List<Passport> allPassports;
	
	public PassportService() {
		allPassports = PassportDB.allPassports;
	}
	
	/**
	 * this method is tend to filter the passports based on 
	 * isBacklisted == true
	 * 
	 * */
	      // boz of multiple passports 
	public List<Passport> filterPassportBasedonStatus(boolean token)
	{
		
		List<Passport> resultList = new ArrayList<>();
		
		// code to filter the passport 
		//  approach a -> java 8 StreamAPI . filter
		//  approach b -> traditional for loop
		
		resultList = allPassports.stream().filter((p)->{
			return p.isBlackListed() == true;
		}).collect(Collectors.toList());
		
		
		return resultList;
	}

}
