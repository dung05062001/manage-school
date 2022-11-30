package com.mycompany.manage_school.entity;

import java.time.LocalDate;

public class student extends members{
	
	private String name_father = "";
	private String name_mother = "";
	private String phone_father = "";
	private String phone_mother = "";
	private String term = "";
	
	public student() {
	}
	
	public student(int iD, String firstname, String lastname, String address, LocalDate birthday, String phone,
			 String name_father, String name_mother, String phone_father, String phone_mother, String term) {
		super(iD, firstname, lastname, address, birthday, phone);
		this.name_father = name_father;
		this.name_mother = name_mother;
		this.phone_father = phone_father;
		this.phone_mother = phone_mother;
		this.term = term;
	}

	public String getName_father() {
		return name_father;
	}

	public void setName_father(String name_father) {
		this.name_father = name_father;
	}

	public String getName_mother() {
		return name_mother;
	}

	public void setName_mother(String name_mother) {
		this.name_mother = name_mother;
	}

	public String getPhone_father() {
		return phone_father;
	}

	public void setPhone_father(String phone_father) {
		this.phone_father = phone_father;
	}

	public String getPhone_mother() {
		return phone_mother;
	}

	public void setPhone_mother(String phone_mother) {
		this.phone_mother = phone_mother;
	}

	
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "student [name_father=" + name_father + ", name_mother=" + name_mother + ", phone_father=" + phone_father
				+ ", phone_mother=" + phone_mother + ", getID()=" + getID() + ", getFirstname()=" + getFirstname()
				+ ", getLastname()=" + getLastname() + ", getAddress()=" + getAddress() + ", getBirthday()="
				+ getBirthday() + ", getPhone()=" + getPhone()  + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
