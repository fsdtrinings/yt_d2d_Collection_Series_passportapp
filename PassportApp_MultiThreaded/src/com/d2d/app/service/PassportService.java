package com.d2d.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.d2d.app.db.PassportDB;
import com.d2d.app.entity.Passport;

/*   this service layer will filter all the passports , through parallel operations*/
public class PassportService {

	List<Passport> allPassports;

	public PassportService() {
		allPassports = PassportDB.allPassports;
	}

	public List<Passport> filterPassportBasedonStatus(boolean token)throws InterruptedException
	{
		
		List<Passport> resultList = Collections.synchronizedList(new ArrayList<Passport>());
		
		
		
		int myCore = Runtime.getRuntime().availableProcessors();
		System.out.println("my core "+myCore);
		
		
		int mid = allPassports.size()/2;
		List<Passport> part1 = allPassports.subList(0,mid);
		List<Passport> part2 = allPassports.subList(mid, allPassports.size());
				
		
		
		Thread t1 = new Thread(new Runnable() {
					
			@Override
			public void run() {
				for(Passport p:part1)
				{
					//System.out.println("Thread - 1 "+p.getName()+" - "+p.isBlackListed());
					
					if(p.isBlackListed() == true)
					{
					//	System.out.println("\tThread - 1 "+p.getName()+" - "+p.isBlackListed());
						resultList.add(p);
					}
				}
				
			}
		});
				
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(Passport p:part2)
				{
				//	System.out.println("Thread - 2 "+p.getName()+" - "+p.isBlackListed());
					
					if(p.isBlackListed() == true)
					{
					//	System.out.println("\tThread - 2 "+p.getName()+" - "+p.isBlackListed());
						resultList.add(p);
					}
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		
		return resultList;
	}

}
