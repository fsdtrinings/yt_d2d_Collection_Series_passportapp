package com.d2d.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.d2d.app.db.PassportDB;
import com.d2d.app.entity.Passport;
import com.d2d.app.service.PassportService;

public class MainClass {

	
	PassportService ps;
	
	public MainClass() {
		ps = new PassportService();
	
	}
	
	public static void main(String[] args) {
		
		MainClass app = new MainClass();
		
	
		
		List<Passport> allPassportsData = PassportDB.allPassports; // fetching all the passports from DB
	
		List<Passport> arrayList = new ArrayList<>(allPassportsData);
		List<Passport> linkedList = new LinkedList<>(allPassportsData);
		
		app.ps.doReadOperation(arrayList, "ArrayList");
		app.ps.doReadOperation(linkedList, "LinkedList");
		
		
		System.err.println("=================================================");
		// call service method
		
		app.ps.doModifyOperation(arrayList, "ArrayList");
		app.ps.doModifyOperation(linkedList, "LinkedList");
		
		
		
		
		
		
	}
	
	
	
	
}//end class



















