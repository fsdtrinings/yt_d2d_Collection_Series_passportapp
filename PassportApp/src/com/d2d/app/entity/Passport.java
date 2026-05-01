package com.d2d.app.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

// Bean class , POJO , entity 

                        // #1
public class Passport implements Serializable{

	//#2
	private String passportNumber;
	private String name;
	private String nationality;
	private LocalDate dob;
	private LocalDate dateofIssue;
	private LocalDate expiryDate;
	private boolean isBlackListed;
	private PassportType passportType;
	
	//#3
	public Passport() {
	}
	
	
	public Passport(String passportNumber, String name, String nationality, LocalDate dob, LocalDate dateofIssue,
			LocalDate expiryDate, boolean isBlackListed, PassportType passportType) {
		super();
		this.passportNumber = passportNumber;
		this.name = name;
		this.nationality = nationality;
		this.dob = dob;
		this.dateofIssue = dateofIssue;
		this.expiryDate = expiryDate;
		this.isBlackListed = isBlackListed;
		this.passportType = passportType;
	}



	// #4
	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	
	public LocalDate getDateofIssue() {
		return dateofIssue;
	}

	public void setDateofIssue(LocalDate dateofIssue) {
		this.dateofIssue = dateofIssue;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isBlackListed() {
		return isBlackListed;
	}

	public void setBlackListed(boolean isBlackListed) {
		this.isBlackListed = isBlackListed;
	}

	public PassportType getPassportType() {
		return passportType;
	}

	public void setPassportType(PassportType passportType) {
		this.passportType = passportType;
	}

	
	// #4
	
	@Override
	public int hashCode() {
		return Objects.hash(dateofIssue, dob, expiryDate, isBlackListed, name, nationality, passportNumber,
				passportType);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passport other = (Passport) obj;
		return Objects.equals(dateofIssue, other.dateofIssue) && Objects.equals(dob, other.dob)
				&& Objects.equals(expiryDate, other.expiryDate) && isBlackListed == other.isBlackListed
				&& Objects.equals(name, other.name) && Objects.equals(nationality, other.nationality)
				&& Objects.equals(passportNumber, other.passportNumber) && passportType == other.passportType;
	}


	@Override
	public String toString() {
		return passportNumber+" "+name+" "+isBlackListed+" "+passportType;
	}
	
	
	
	
	
	
}//end class
