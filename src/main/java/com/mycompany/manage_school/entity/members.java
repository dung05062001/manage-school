package com.mycompany.manage_school.entity;

import java.time.LocalDate;

public class members {

	private String firstname = "";
	private String lastname = "";
	private String address = "";
	private LocalDate birthday;
	private String phone = "";
	private String term = "";

	public members() {
	}

	public members(String firstname, String lastname, String address, LocalDate birthday, String phone, String term) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.birthday = birthday;
		this.phone = phone;
		this.term = term;
		
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "members [firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", birthday="
				+ birthday + ", phone=" + phone + ", term=" + term + "]";
	}

	
}
