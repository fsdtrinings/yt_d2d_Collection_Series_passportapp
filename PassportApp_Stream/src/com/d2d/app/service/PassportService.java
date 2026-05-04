package com.d2d.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.d2d.app.db.PassportDB;
import com.d2d.app.entity.Passport;

/*   this service layer will filter all the passports ,using Stream API*/
public class PassportService {

	List<Passport> allPassports;
	public long timeConsummedStream =0;
	public long timeConsummedparallel =0;
	
	public PassportService() {
		allPassports = PassportDB.allPassports;
	}

	public List<Passport> filterPassportBasedonStatus(boolean token)throws InterruptedException
	{
		long start = System.currentTimeMillis();
		
		List<Passport> allBlacklistedPassorts = allPassports.stream().filter((p)->{
			
			if(p.isBlackListed() == token) return true;
			else return false;
			
		}).collect(Collectors.toList());
		
		long end = System.currentTimeMillis();
		timeConsummedStream = (end - start);
		
		
		
		return allBlacklistedPassorts;
	}
	
	public List<Passport> filterPassportBasedonStatus_parallelStream(boolean token)throws InterruptedException
	{
		long start = System.currentTimeMillis();
		
		List<Passport> allBlacklistedPassorts = allPassports.parallelStream().filter((p)->{
			
			if(p.isBlackListed() == token) return true;
			else return false;
			
		}).collect(Collectors.toList());
		
		long end = System.currentTimeMillis();
		timeConsummedparallel = (end - start);
		
		
		
		return allBlacklistedPassorts;
	}

}
