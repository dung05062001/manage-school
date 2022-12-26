package com.mycompany.manage_school.control.user;

import java.sql.SQLOutput;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import com.mycompany.manage_school.control.homepage;
import com.mycompany.manage_school.control.user.login;
import com.mycompany.manage_school.exception.PasswordException;
import com.mycompany.manage_school.factory.scannerFactory;
import com.mycompany.manage_school.handleInput.log;
import com.mycompany.manage_school.model.DAO;

public class changePassword {

	private static Scanner scanner;
	
	public changePassword() {
		
		scannerFactory scannerFactory = new scannerFactory();
		scanner = scannerFactory.getScanner();
	}
	
	public void functions() {
		
		System.out.println("back (0)");
		System.out.println("home page (1)");
		System.out.println("Change Password (2)");
		System.out.println("exit(3)");
		
		System.out.println("Enter choose of you : ");
		int choose = scanner.nextInt();
		scanner.nextLine();
		switch (choose) {
//		quay lại trang login của người dùng
		case 0:
			login loginUser = new login();
			loginUser.handleLog();
			break;

		case 1:
			homepage homepage = new homepage();
			homepage.viewLayout();
			break;
			
		case 2:
			changePassword();
			break;
			
		case 3:
			return;
			
		default:
			break;
		}
	}
	
	
	private static void changePassword() {
		
		System.out.println("enter username : ");
		String username = scanner.nextLine();
		
		System.out.println("phone :");
		String phone = scanner.nextLine();
		
		System.out.println("phone father :");
		String phonefather = scanner.nextLine();

		System.out.println("phone mother:");
		String phonemother = scanner.nextLine();

		boolean result = DAO.ChangePassword(username, "student", phone, phonefather, phonemother);
		if(result) {
			boolean resultInput = inputNewPass(username);
			if(!resultInput) {
				return;
			}
		}
		
		return;
	}

	
	private static boolean inputNewPass(String username) {
		System.out.println("Enter new password :");
		String NewPassword = scanner.nextLine();
		System.out.println("Enter again new password : ");
		String NewPasswordAgain = scanner.nextLine();
		
//			check new password 
		if(NewPassword.equals(NewPasswordAgain)) {

				try {
					log.CheckPassword(NewPasswordAgain);
					
//					save new password vào database
					boolean resultUpdateNewPass = DAO.updateNewPassword(username, NewPasswordAgain);
					if(resultUpdateNewPass) {
						System.out.println("change password succes !");
					}
					else {
						System.out.println("change password wrong! ");
						
					}
				} catch (PasswordException e) {
					System.out.println("password wrong , please re-password !");
					System.out.println("home(0)");
					
					int choose = scanner.nextInt();
					if(choose == 0) {
						homepage home = new homepage();
						home.viewLayout();
					}
					inputNewPass(username);
				}
			}
		return false;
	}
}
