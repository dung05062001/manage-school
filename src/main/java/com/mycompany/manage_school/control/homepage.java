package com.mycompany.manage_school.control;

import java.util.Scanner;

import com.mycompany.manage_school.factory.scannerFactory;

public class homepage {

	private Scanner scanner;
	
	public homepage() {
		scanner = scannerFactory.getScanner();
	}
	
	public void viewLayout() {
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("HOME PAGE");
		System.out.println("enter 0 : Login");
		System.out.println("enter 1 : Regiser");
		System.out.println("enter 2 : Check Point");
		System.out.println("enter 3 : View Posts");
		System.out.println("enter 4: view Time table");
		System.out.println("enter 5: exit");
		
		System.out.println("@input: your choose ");
		int choose = scanner.nextInt();
		scanner.nextLine();
		System.out.println();
		switch (choose) {
		case 0:
			login login = new login();
			login.handleLog();
			break;
		case 1:
			register register = new register();
			register.registers();
			break;
			
		default:
			break;
		}
	}

	
	
}
