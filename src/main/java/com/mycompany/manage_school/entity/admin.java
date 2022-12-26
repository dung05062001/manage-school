package com.mycompany.manage_school.entity;

import java.time.LocalDateTime;

public class admin {
	
	private int ID;
	private String fullname;
	private String address;
	private LocalDateTime timeCreate;
	
	public admin(int iD, String fullname, String address, LocalDateTime timeCreate) {
		this.ID = iD;
		this.fullname = fullname;
		this.address = address;
		this.timeCreate = timeCreate;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getTimeCreate() {
		return timeCreate;
	}

	public void setTimeCreate(LocalDateTime timeCreate) {
		this.timeCreate = timeCreate;
	}
	
	
	
	
}