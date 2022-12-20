package com.mycompany.manage_school.control.Admin.functionLog;

import java.util.Scanner;

import javax.sound.midi.Soundbank;

import com.mycompany.manage_school.control.homepage;
import com.mycompany.manage_school.control.Admin.Home;
import com.mycompany.manage_school.factory.scannerFactory;
import com.mycompany.manage_school.model.DAO;

public class logAdminManager {

	private Scanner scanner;

	public logAdminManager() {

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
			homepageOfAdmin.function();
			break;

//		quay lại trang chủ của trường
		case 2:

			homepage homepageOfSchool = new homepage();
			homepageOfSchool.viewLayout();

			break;

//			log admin manager
		case 3:
//			gọi function log admin manager
			boolean result = logAdminManager();
			if(result) {
				Home homeOfAdmin = new Home();
				homeOfAdmin.function();
			}
			break;

		default:
			break;
		}
	}

	private boolean logAdminManager() {

		System.out.println("      LOG ADMIN MANAGER");
		System.out.println("enter username :");
		String username = scanner.nextLine();

		System.out.println("enter password : ");
		String password = scanner.nextLine();

		boolean resultLogAdminManager = DAO.LogAdminManager(username, password);
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

//			quay về page chính của log admin manager
			if (chooses == 0) {
				logAdminManager logadmin = new logAdminManager();
				logadmin.function();
			} else {
				logAdminManager();
			}
			return false;
		}
		
	}

	public static void main(String[] args) {
		
		logAdminManager log = new logAdminManager();
		log.function();
		
		
	}
}
