package com.mycompany.manage_school.control.Admin.functionLog;

import java.util.Scanner;

import com.mycompany.manage_school.control.homepage;
import com.mycompany.manage_school.control.Admin.Home;
import com.mycompany.manage_school.factory.scannerFactory;
import com.mycompany.manage_school.model.DAO;

public class logAdminAccountCensorship {

	private Scanner scanner;
	
	public logAdminAccountCensorship() {
		
		scannerFactory scannerFactory = new scannerFactory();
		scanner = scannerFactory.getScanner();
	}
	
	
	public void function() {

		System.out.println("back(0)");
		System.out.println("homepage of admin(1)");
		System.out.println("homepage school(2)");
		System.out.println("log(3)");

		int choose = scanner.nextInt();
		scanner.nextLine();

		switch (choose) {
//		quay lại trang trước (trong log của admin)
		case 0:
			log PageLogOfAdmin = new log();
			PageLogOfAdmin.function();
			break;

//		quay lại trang chủ của page admin
		case 1:

			Home homepageOfAdmin = new Home();
			homepageOfAdmin.functionGeneral();
			break;

//		quay lại trang chủ của trường
		case 2:

			homepage homepageOfSchool = new homepage();
			homepageOfSchool.viewLayout();

			break;

//			log admin account censorship
		case 3:
			boolean result = logAdminAccountCensorship();
			if(result) {
				Home homeofAdmin = new Home();
				homeofAdmin.functionAdminAccountCensorship();
			}
			break;

		default:
			break;
		}
	}

	private boolean logAdminAccountCensorship() {

		System.out.println("      LOG ADMIN ACCOUNT CENSORSHIP ");
		System.out.println("enter username :");
		String username = scanner.nextLine();

		System.out.println("enter password : ");
		String password = scanner.nextLine();

		boolean resultLogAdminManager = DAO.logAdminDepartment(username, password, "account censorship");
		System.out.println(resultLogAdminManager);
		if (resultLogAdminManager) {
			System.out.println("@login succes!");
			return true;
		} else {
			System.out.println("@login wrong ,please re-enter!");
			System.out.println("get out (0)");
			System.out.println("continue (1)");
			int chooses = scanner.nextInt();
			scanner.nextLine();

//			quay về page chính của log admin account censorship
			if (chooses == 0) {
				logAdminAccountCensorship logadmin = new logAdminAccountCensorship(); 
				logadmin.function();
			} else {
				logAdminAccountCensorship();
			}
			return false;
		}
		
	}
	

}
