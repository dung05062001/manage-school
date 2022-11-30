package com.mycompany.manage_school.entity;

import java.time.LocalDate;

public class members {

	private int ID;
	private String firstname = "";
	private String lastname = "";
	private String address = "";
	private LocalDate birthday;
	private String phone = "";

	public members() {

	}

	public members(int iD, String firstname, String lastname, String address, LocalDate birthday, String phone) {
		this.ID = iD;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.birthday = birthday;
		this.phone = phone;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	
	@Override
	public String toString() {
		return "members [ID=" + ID + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ ", birthday=" + birthday + ", phone=" + phone + "]";
	}

}
