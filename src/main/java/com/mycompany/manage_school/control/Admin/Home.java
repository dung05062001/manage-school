package com.mycompany.manage_school.control.Admin;

import java.util.Scanner;

import com.mycompany.manage_school.control.homepage;
import com.mycompany.manage_school.control.Admin.addmember.RegisterForMember;
import com.mycompany.manage_school.control.Admin.functionLog.log;
import com.mycompany.manage_school.factory.scannerFactory;

public class Home {

	private Scanner scanner;

	public Home() {
		scannerFactory scannerFactory = new scannerFactory();
		scanner = scannerFactory.getScanner();
	}

	public void functionGeneral() {

		System.out.println("Page Of School (0)");
		System.out.println("login(1)");
		System.out.println("exit(2)");

		System.out.println("enter choose of you :");
		int choose = scanner.nextInt();

		switch (choose) {
		case 0:

			homepage homepageOfSchool = new homepage();
			homepageOfSchool.viewLayout();
			break;

		case 1:
			log logadmin = new log();
			logadmin.function();
			break;
		case 2:
			return;

		default:
			break;
		}
	}

	public void functionAdminManager() {

		System.out.println(" 	HOME PAGE OF ADMIN MANAGER");
		System.out.println("Page Of School (0)");
		System.out.println("add profile of Student or Teacher (1)");
		System.out.println("change information of student and teacher (2)");
		System.out.println("register Admin Department (3)");
		System.out.println("schedule (4)");
		System.out.println("score(5)");
		System.out.println("list student (6)");
		System.out.println("list teacher (7)");
		System.out.println("account censorship (8)");
		System.out.println("admission(9)");
		System.out.println("posts(10)");
		System.out.println("exit(11)");
		
		int choose = scanner.nextInt();
		
		switch (choose) {
		case 0:
			homepage homepageOfSchool = new homepage();
			homepageOfSchool.viewLayout();
			break;

//			add profile for users (student or teacher)
		case 1:
			RegisterForMember addprofile = new RegisterForMember();
			addprofile.function();
			break;
//			change profile users
		case 2:
			
			break;
			
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		case 8:
			
			break;
		case 9:
			
			break;
		case 10:
			
			break;
		case 11:
			
			break;
			
		default:
			break;
		}
	}

	public void functionAdminAccountCensorship() {

		System.out.println(" 	HOME PAGE OF ADMIN ACCOUNT CENSORSHIP");
		System.out.println("logout(0)");
		System.out.println("Censor account (1)");
		System.out.println("exit(2)");

	}

	public void functionAdminAddmission() {

		System.out.println(" 	HOME PAGE OF ADMIN Addmission");
		System.out.println("logout(0)");
		System.out.println("View Admission Profile (1)");
		System.out.println("exit(2)");

	}
	
	public void functionAdminPosts() {

		System.out.println(" 	HOME PAGE OF ADMIN Posts");
		System.out.println("logout(0)");
		System.out.println("Add New Posts");
		System.out.println("View Posts (1)");
		System.out.println("exit(2)");
	}
	
	
	
}
