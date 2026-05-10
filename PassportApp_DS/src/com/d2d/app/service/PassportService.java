package com.d2d.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.d2d.app.db.PassportDB;
import com.d2d.app.entity.Passport;
import com.d2d.app.entity.PassportType;

/*   this service layer will filter all the passports ,using Stream API*/
public class PassportService {

	
	// get all blacklisted passports
	public List<Passport> doReadOperation(List<Passport> allPassports,String listType)
	{
		System.out.println(" Reading start .... from "+listType);
		long start = System.currentTimeMillis();
		
		List<Passport> resultlistList = new ArrayList<>();
		
		for (Passport passport : allPassports) {
			
			if(passport.isBlackListed() == true)
			{
				resultlistList.add(passport); // inserting the blacklisted passports
			}
			
		}
		
		long end = System.currentTimeMillis();
		System.out.println(listType+" Input ==>> Iterated "+allPassports.size()+" and Found : "+resultlistList.size()+" items in ");
		System.out.println(" "+(end-start)+" milliSec");
		return resultlistList;
	}
	
	// updating the date of expiry of certain passports 
	public List<Passport> doModifyOperation(List<Passport> allPassports,String listType)
	{
		System.out.println(" Reading start .... from "+listType);
		long start = System.currentTimeMillis();
		
		List<Passport> resultlistList = new ArrayList<>();
		
		for (Passport passport : allPassports) {
			
			if(passport.getPassportType() == PassportType.DIPLOMAT)
			{
				passport.setExpiryDate(passport.getExpiryDate().plusYears(10));
			}
			
		}
		
		long end = System.currentTimeMillis();
		System.out.println(listType+" Input ==>> Iterated "+allPassports.size()+" and Modified : "+resultlistList.size()+" items in ");
		System.out.println(" "+(end-start)+" milliSec");
		return resultlistList;
	}
	

}//end of class
