package com.mycompany.manage_school.control;

import java.time.LocalDate;
import java.util.Scanner;

import com.mycompany.manage_school.entity.account;
import com.mycompany.manage_school.entity.members;
import com.mycompany.manage_school.exception.BirthdayException;
import com.mycompany.manage_school.exception.PasswordException;
import com.mycompany.manage_school.exception.PhoneException;
import com.mycompany.manage_school.exception.UsernameException;
import com.mycompany.manage_school.exception.firstnameException;
import com.mycompany.manage_school.exception.lastnameException;
import com.mycompany.manage_school.factory.scannerFactory;
import com.mycompany.manage_school.handleInput.log;

public class register {

	private Scanner scanner;

	public register() {
		scanner = scannerFactory.getScanner();
	}

	private String option() {
		System.out.println("				   Home page (0)");
		System.out.println("				   Login(1)");
		System.out.println("				   Exit(2)");
		System.out.println("				   Continue(3)");

		System.out.println("enter choose : ");
		int option = scanner.nextInt();
		scanner.nextLine();
		if (option == 0) {
			homepage a = new homepage();
			a.viewLayout();
		} else if (option == 1) {
			login log = new login();
			log.handleLog();
		} else if (option == 2) {
		} else if (option == 3) {
			return scanner.nextLine();
		} else {
			System.out.println("wrong , Please re-enter!");
			option();
		}

		return null;
	}

	public void registers() {

		System.out.println("              			-----------------------------------------------------");
		System.out.println("							REGISTER");

		System.out.println("				   Option (0)");

		System.out.println("				  Username:");
		String username = scanner.nextLine();
		if (username.equals("0")) {
			String option = option();
			if (option != null) {
				username = option;
			} else {
				return;
			}
		}

		System.out.println("				  Password:");
		String password = scanner.nextLine();
		if (password.equals("0")) {
			String option = option();
			if (option != null) {
				password = option;
			} else {
				return;
			}
		}
		System.out.println("				  first name :");
		String firstname = scanner.nextLine();
		if (firstname.equals("0")) {
			String option = option();
//			if user choose option 'continue' and enter again 'data' in first name
			if (option != null) {
				firstname = option;
			} else {
				return;
			}
		}
		System.out.println("				  last name :");
		String lastname = scanner.nextLine();
		if (lastname.equals("0")) {
			String option = option();
			if (option != null) {
				lastname = option;
			} else {
				return;
			}
		}
		System.out.println("				  Address :");
		String address = scanner.nextLine();
		if (address.equals("0")) {
			String option = option();
			if (option != null) {
				address = option;
			} else {
				return;
			}
		}
		System.out.println("				  Phone   :");
		String phone = scanner.nextLine();
		if (phone.equals("0")) {
			String option = option();
			if (option != null) {
				phone = option;
			} else {
				return;
			}
		}
		System.out.println("				  Birthday:");
		System.out.println("			day: ");
		String day = scanner.nextLine();
		if (day.equals("0")) {
			String option = option();
			if (option != null) {
				day = option;
			} else {
				return;
			}
		}
		System.out.println("			month : ");
		String month = scanner.nextLine();
		if (month.equals("0")) {
			String option = option();
			if (option != null) {
				month = option;
			} else {
				return;
			}
		}
		System.out.println("			year: ");
		String year = scanner.nextLine();
		if (year.equals("0")) {
			String option = option();
			if (option != null) {
				year = option;
			} else {
				return;
			}
		}
//		String birthday = day + "/" + month + "/" + year;
//		System.out.println("birthday of your is : " + birthday);

		LocalDate birthday = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));

		account acc = new account(username, password);
		members studentRegister = new members(0, firstname, lastname, address, birthday, phone);
		String resultConfirm = confirm(studentRegister);
		if (resultConfirm.equals("Register")) {
			
//			check data user input , return true if valid and register success, otherwise false
			boolean result =  handleDataRegister(acc, studentRegister);
			if(result) {
				System.out.println("register succes!");
			}
			else{
				System.out.println("register wrong , Please re-enter!");
			}
		}
	}

	private boolean handleDataRegister(account acc, members studentRegister) {
		String username = acc.getUsername();
		String password = acc.getPassword();
		String firstname = studentRegister.getFirstname();
		String lastname = studentRegister.getLastname();
		String address = studentRegister.getAddress();
		String phone = studentRegister.getPhone();
		LocalDate birthday = studentRegister.getBirthday();

		
		
//		check data input of user (student)
		com.mycompany.manage_school.handleInput.register checkregister = new com.mycompany.manage_school.handleInput.register();
		try {
			log.CheckUsername(username);
			log.CheckPassword(password);
			checkregister.firstname(firstname);
			checkregister.lastname(lastname);
			checkregister.phone(phone);
			checkregister.Birthday(birthday);
			
			return true;
		} catch (UsernameException e) {
			e.printStackTrace();
		} catch (PasswordException e) {
			e.printStackTrace();
		} catch (firstnameException e) {
			e.printStackTrace();
		} catch (lastnameException e) {
			e.printStackTrace();
		} catch (PhoneException e) {
			e.printStackTrace();
		} catch (BirthdayException e) {
			e.printStackTrace();
		}
		return false;
	}

//	confirm to register (save to database)
	private String confirm(members studentRegister) {

		System.out.println("confirm(3)");
		int confirm = scanner.nextInt();
		if (confirm == 3) {
			System.out.println("register succes!");
			return "Register";
		} else if (confirm == 0) {
			String option = option();

//			if user choose option 'continue' and enter 3 to confirm 
			if (option.equals("3")) {
				System.out.println("register succes!");
				return "Register";
			}

//			if user choose option 'continue ' and enter != 3 to confirm , after will re-confirm
			else if (option != null && !option.equals("3")) {
				confirm(studentRegister);
			}
		} else {
			confirm(studentRegister);
		}
		return "No Register";
	}

}
