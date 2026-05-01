package com.d2d.app.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.d2d.app.entity.Passport;
import com.d2d.app.entity.PassportType;

public class PassportDB {
	
	static public List<Passport> allPassports ;
	
	static {
		
		Passport p1 = new Passport("A123B", "Mike", "Indian", 
                LocalDate.of(1998, 01, 15),LocalDate.of(2020, 01, 15) ,LocalDate.of(2040, 01, 15) , 
                true,PassportType.GENERAL );

		Passport p2 = new Passport("B123E", "Ramesh", "Indian", 
                LocalDate.of(1988, 01, 15),LocalDate.of(2005, 01, 15) ,LocalDate.of(2045, 01, 15) , 
                true,PassportType.DIPLOMAT);

		Passport p3 = new Passport("K123B", "Nita", "Indian", 
                LocalDate.of(1993, 11, 15),LocalDate.of(2019, 01, 15) ,LocalDate.of(2039, 01, 15) , 
                false,PassportType.GENERAL);
		
		Passport p4 = new Passport("K584B", "Suresh", "Indian", 
                LocalDate.of(1993, 11, 15),LocalDate.of(2019, 01, 15) ,LocalDate.of(2039, 01, 15) , 
                false,PassportType.GENERAL);
		
		Passport p5 = new Passport("Y963B", "Donald", "American", 
                LocalDate.of(1973, 11, 15),LocalDate.of(1995, 01, 15) ,LocalDate.of(2039, 01, 15) , 
                false,PassportType.GOVERNMENT_EMPLOYEE);
		
		
		allPassports = Arrays.asList(p1,p2,p3,p4,p5); // instead you can also use list.add() method

		
		
	}
	
	public void addPassport(Passport passport)
	{
		allPassports.add(passport);
	}
	
	

}
