package com.mycompany.manage_school.entity;

import java.time.LocalDate;

public class student extends members{
	
	private String name_father = "";
	private String name_mother = "";
	private String phone_father = "";
	private String phone_mother = "";
	private String Classes = "";
	
	public student(String name_father, String name_mother, String phone_father, String phone_mother, String Classes) {
		
		this.name_father = name_father;
		this.name_mother = name_mother;
		this.phone_father = phone_father;
		this.phone_mother = phone_mother;
		this.Classes = Classes;
	}
	
	public student(String firstname, String lastname, String address, LocalDate birthday, String phone, String term,
			 String name_father, String name_mother, String phone_father, String phone_mother, String Classes) {
		super(firstname, lastname, address, birthday, phone, term);
		this.name_father = name_father;
		this.name_mother = name_mother;
		this.phone_father = phone_father;
		this.phone_mother = phone_mother;
		this.Classes = Classes;
		
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

	
	public String getClasses() {
		return Classes;
	}

	public void setClasses(String classes) {
		Classes = classes;
	}

	@Override
	public String toString() {
		return "student [name_father=" + name_father + ", name_mother=" + name_mother + ", phone_father=" + phone_father
				+ ", phone_mother=" + phone_mother + ", Classes=" + Classes + "]";
	}

	
}
