package com.mycompany.manage_school.handleInput;

import java.time.LocalDate;

import com.mycompany.manage_school.exception.BirthdayException;
import com.mycompany.manage_school.exception.PhoneException;
import com.mycompany.manage_school.exception.firstnameException;
import com.mycompany.manage_school.exception.lastnameException;

public class register {

	public register() {
	}
	
	public void firstname(String firstname) throws firstnameException {
		
		if(firstname.matches("^[A-Za-z]{2,15}$")) {
			
		}
		else {
			throw new  firstnameException("first name is wrong!");
		}
	}
	
	
	public void lastname(String lastname) throws lastnameException {
		
		if(lastname.matches("^[A-Za-z]{1,15}$")) {
			
		}
		else {
			throw new lastnameException("last name is wrong!");
		}
	}
	
	public void phone(String phone) throws PhoneException {
		
		if(phone.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
			
		}
		else {
			throw new PhoneException("phone is wrong!");
		}
	}
	
	public void Birthday(LocalDate Birthday) throws BirthdayException {
		
		int day = Birthday.getDayOfMonth();
		int month = Birthday.getMonthValue();
		int year = Birthday.getYear();
		
		if(day >0 && day < 31 && month > 0 && month < 13 && String.valueOf(year).length() == 4) {
			
		}
		else {
			throw new BirthdayException("birth day is wrong!");
			
		}
	}

	
}
