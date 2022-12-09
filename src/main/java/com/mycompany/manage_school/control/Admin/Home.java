package com.mycompany.manage_school.control.Admin;

import java.util.Scanner;

import com.mycompany.manage_school.factory.scannerFactory;

public class Home {

	private Scanner scanner;
	
	public Home() {
		scannerFactory scannerFactory = new scannerFactory();
		scanner = scannerFactory.getScanner();
	}

	public void function() {
		
		System.out.println("home(0)");
		System.out.println("back(1)");
		System.out.println("Register For Member(2)");
		System.out.println("Change schedule(3)");
		System.out.println("view teacher and students (4)");
		
		System.out.println("enter choose of you : ");
		int choose = scanner.nextInt();
		
		switch (choose) {
		case 0:
			
			break;
		case 1:
			
			
			break;
		case 2:
			
			RegisterForMember AddInforOfStudent = new RegisterForMember();
			AddInforOfStudent.function();
			break;

		default:
			break;
		}
	}
	
	
	
	
}
