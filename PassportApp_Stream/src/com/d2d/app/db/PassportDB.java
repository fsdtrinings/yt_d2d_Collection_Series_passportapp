package com.d2d.app.db;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.d2d.app.entity.Passport;
import com.d2d.app.entity.PassportType;

public class PassportDB {

    static public List<Passport> allPassports;

    static {

        allPassports = new ArrayList<>();

   
        for (int i = 1; i <= 1000000; i++) {

            String passportNumber = "P" + (10 + i);
            String name = "User" + i;

            String nationality = (i % 2 == 0) ? "Indian" : "American";

            LocalDate dob = LocalDate.of(1980 + (i % 20), (i % 12) + 1, (i % 28) + 1);
            LocalDate issueDate = LocalDate.of(2010 + (i % 10), (i % 12) + 1, (i % 28) + 1);
            LocalDate expiryDate = issueDate.plusYears(20);

            boolean isBlackListed = (i % 5 == 0); // every 5th passport blacklisted

            PassportType type;  // enum
            if (i % 4 == 0) {
                type = PassportType.DEFENCE;
            } else if (i % 4 == 1) {
                type = PassportType.DIPLOMAT;
            } else if (i % 4 == 2) {
                type = PassportType.GOVERNMENT_EMPLOYEE;
            } else {
                type = PassportType.GENERAL;
            }

            Passport passport = new Passport(
                    passportNumber,
                    name,
                    nationality,
                    dob,
                    issueDate,
                    expiryDate,
                    isBlackListed,
                    type
            );

            allPassports.add(passport);
        }
    }

    public void addPassport(Passport passport) {
        allPassports.add(passport);
    }
}