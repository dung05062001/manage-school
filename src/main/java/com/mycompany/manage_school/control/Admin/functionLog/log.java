package com.mycompany.manage_school.control.Admin.functionLog;

import java.util.Scanner;

import com.mycompany.manage_school.home;
import com.mycompany.manage_school.control.homepage;
import com.mycompany.manage_school.control.Admin.Home;
import com.mycompany.manage_school.factory.scannerFactory;

public class log {

	private Scanner scanner;
	
	public log() {
		
		scannerFactory scannerFactory = new scannerFactory();
		scanner = scannerFactory.getScanner();
	}
	

	public  void function() {
		
		System.out.println("        LOGIN FOR ADMIN");
		System.out.println("Home page admin(0)");
		System.out.println("back homepage user(1)");
		System.out.println("login ADMIN Manager(2)");
		System.out.println("login ADMIN account censorship(3)");
		System.out.println("login ADMIN admissions(4)");
		System.out.println("login ADMIN posts(5)");
		System.out.println("exit(6)");
		
		int choose  = scanner.nextInt();
		scanner.nextLine();
		switch (choose) {
		
//			back home page của Admin
		case 0:
			Home homeOfAdmin = new Home();
			homeOfAdmin.functionGeneral();
			break;
			
//			back home page của trường 
		case 1:
			homepage homepage = new homepage();
			homepage.viewLayout();
			break;
			
		case 2:
			
			logAdminManager adminManager = new logAdminManager();
			adminManager.function();
			break;
			
//			chức năng : log admin duyệt account 
		case 3:
			logAdminAccountCensorship adminAcountCensorship = new logAdminAccountCensorship();
			
			
			break;
			
//			chức năng : log admin tuyển sinh
		case 4:
			
			logAdminAdmissions adminAdmissions = new logAdminAdmissions();
			
			break;
			
//			chức năng : log admin posts news cho trường
		case 5:
			
			logAdminPost adminPost = new logAdminPost();
			
			break;
			
		case 6:
			
			break;

		default:
			break;
		}
	}
}
