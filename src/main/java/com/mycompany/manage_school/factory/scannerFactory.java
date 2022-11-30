package com.mycompany.manage_school.factory;

import java.util.Scanner;

public class scannerFactory {

	private static Scanner scannerfactory;
	
	public scannerFactory() {
		
	}
	
	public static Scanner getScanner() {
		if(scannerfactory == null) {
			scannerfactory = new Scanner(System.in);
		}
		return scannerfactory;
	}

}
