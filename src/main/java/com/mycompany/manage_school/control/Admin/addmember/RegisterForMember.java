package com.mycompany.manage_school.control.Admin.addmember;

import java.util.Scanner;

import com.mycompany.manage_school.factory.scannerFactory;

public class RegisterForMember {

	private Scanner scanner;

	public RegisterForMember() {

		scannerFactory scannerFactory = new scannerFactory();
		scanner = scannerFactory.getScanner();
	}

	
	public void function() {
		System.out.println("    REGISTER USER BY ADMIN");
		System.out.println("home(0)");
		System.out.println("Add Profile Student(1)");
		System.out.println("Add Profile Teacher(2)");
		
		int choose = scanner.nextInt();
		scanner.nextLine();
		switch (choose) {
		case 0:
			
			break;
			
		case 1:
//			register information for student
			String category = "student";
			AddMember addstudent = new AddMember();
			addstudent.AddMember(category);
			break;
			
		case 2:
			
			break;

		default:
			break;
		}
		
	}
}
