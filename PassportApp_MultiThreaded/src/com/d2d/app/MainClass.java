package com.d2d.app;

import java.util.List;

import com.d2d.app.db.PassportDB;
import com.d2d.app.entity.Passport;
import com.d2d.app.service.PassportService;

public class MainClass {

	
	PassportService passportService;
	
	public MainClass() {
		
		passportService = new PassportService();
		
		
	}
	
	
	public static void main(String[] args)throws InterruptedException {
		MainClass app = new MainClass();
		
		
		
		//app.display(PassportDB.allPassports);
		app.getAllBacklistedPassport();
		
	}//end main
	
	public void display(List<Passport> passportList)
	{
		System.err.println("\n==================================================\n");
		for (Passport passport : passportList) {
			System.out.println(passport);
		}
	}
	
	
	public void getAllBacklistedPassport()throws InterruptedException
	{
		List<Passport> list = passportService.filterPassportBasedonStatus(true);
		display(list);
		
	}
}//end class



















