package com.mycompany.manage_school.control;

import java.util.Scanner;

import javax.sql.rowset.serial.SQLOutputImpl;

import com.mycompany.manage_school.entity.account;
import com.mycompany.manage_school.exception.PasswordException;
import com.mycompany.manage_school.exception.UsernameException;
import com.mycompany.manage_school.factory.scannerFactory;
import com.mycompany.manage_school.handleInput.log;

public class login {

	private Scanner scanner;
	private homepage home;
	
	public login() {
		
		this.scanner = scannerFactory.getScanner();
	}
	
	public void handleLog() {
		
		boolean checksucces = false;
		login login = new login();
		account accInput = login.input();
		if(accInput != null) {
			
			String username = accInput.getUsername();
			String password = accInput.getPassword();
			
			try {

				log.CheckUsername(username);
				log.CheckPassword(password);
				checksucces = true;
			} catch (UsernameException e) {
				System.out.println(e.getMessage());
			}
			catch (PasswordException e) {
				System.out.println(e.getMessage());
			}
			if(checksucces) {
				System.out.println("@result :");
				System.out.println("---login succes---");
				System.out.println();
			}
			else {
//				if log wrong 
//				call back login by method : handleLog()
				login.handleLog();
			}
		}
	}
	
	private  account input() {
		
		System.out.println("              			-----------------------------------------------------");
		System.out.println("							LOGIN");
		
		System.out.println("				   Home page (0)");
		System.out.println("				   Forgot your password?(1)");
		System.out.println("				   or Register(2)");
		System.out.print("				  Username : ");
		String username = scanner.nextLine();
		
		if(username.equals("0")) {
			
			home = new homepage();
			home.viewLayout();
			return null;
		}
		if(username.equals("1")) {
			
		}
		if(username.equals("2")) {
			register register = new register();
			register.registers();
			return null;
		}
		
		System.out.print("				  Password : ");
		String password = scanner.nextLine();
		
		account user = new account(username, password);
		return user;
	}

}
