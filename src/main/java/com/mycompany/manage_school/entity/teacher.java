package com.mycompany.manage_school.entity;

import java.time.LocalDate;

public class teacher extends members{

	private String history = "";
	private String contract = "";
	private String term = "";
	
	public teacher() {
	}

	public teacher(int iD, String firstname, String lastname, String address, LocalDate birthday, String phone,
			 String history,  String contract, String term) {
		super(iD, firstname, lastname, address, birthday, phone);
		this.history = history;
		this.contract = contract;
		this.term = term;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "teacher [history=" + history + ", contract=" + contract + ", getID()=" + getID() + ", getFirstname()="
				+ getFirstname() + ", getLastname()=" + getLastname() + ", getAddress()=" + getAddress()
				+ ", getBirthday()=" + getBirthday() + ", getPhone()=" + getPhone() + ", getTerm()=" + getTerm()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

}
