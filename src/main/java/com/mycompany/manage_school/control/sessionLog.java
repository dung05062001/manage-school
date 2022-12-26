package com.mycompany.manage_school.control;

import java.time.LocalDateTime;

import com.mycompany.manage_school.entity.admin;

public class sessionLog {

	private static admin inforLogAdmin;  
	
	public sessionLog(int ID, String fullname, String address, LocalDateTime timeCreate) {
		inforLogAdmin = new admin(ID, fullname, address, timeCreate);
	}

	public static admin getInforLogAdmin() {
		return inforLogAdmin;
	}
	
}
