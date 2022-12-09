package com.mycompany.manage_school.control.Admin;

import java.time.LocalDate;
import java.util.Scanner;

import com.mycompany.manage_school.control.homepage;
import com.mycompany.manage_school.control.login;
import com.mycompany.manage_school.entity.account;
import com.mycompany.manage_school.entity.members;
import com.mycompany.manage_school.entity.student;
import com.mycompany.manage_school.factory.scannerFactory;
import com.mycompany.manage_school.model.DAO;

public class AddStudent {

	private Scanner scanner;

	public AddStudent() {

		scannerFactory factory = new scannerFactory();
		scanner = factory.getScanner();
	}

	public void function() {

		System.out.println("home(0)");
		System.out.println("back(1)");
		System.out.println("Add information of student(2)");

		System.out.println("   Enter choose of you : ");
		int choose = scanner.nextInt();

		switch (choose) {
		case 0:
			Home home = new Home();
			home.function();
			break;
		case 1:
//			call function of register

			RegisterForMember register = new RegisterForMember();
			register.function();
			break;
		case 2:

			break;
		default:
			break;
		}

	}

	private String option() {
		System.out.println("				   Home page (0)");
		System.out.println("				   Exit(1)");
		System.out.println("				   Continue(2)");

		System.out.println("enter choose : ");
		int option = scanner.nextInt();
		scanner.nextLine();
		if (option == 0) {
			homepage a = new homepage();
			a.viewLayout();
		} else if (option == 1) {
		} else if (option == 2) {
			return scanner.nextLine();
		} else {
			System.out.println("wrong , Please re-enter!");
			option();
		}

		return null;
	}

	public void AddMember(String category) {

		System.out.println("              			-----------------------------------------------------");
		System.out.println("							REGISTER");

		System.out.println("				   Option (0)");


		System.out.println("				  first name :");
		String firstname = scanner.nextLine();
		if (firstname.equals("0")) {
			String option = option();
//			if Admin choose option 'continue' and enter again 'data' in first name
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
		
		System.out.println("			nhiem ky: ");
		String term = scanner.nextLine();
		if (term.equals("0")) {
			String option = option();
			if (option != null) {
				term = option;
			} else {
				return;
			}
		}
		
		
		
		LocalDate birthday = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));

		members member = null;
		String categoryOfRegister = "";
		if(category.equals("student")) {
			
			student InforStudentPrivate =  registerStudent();
			if(InforStudentPrivate != null) {
				
				categoryOfRegister = "student";
				
//		create object student 
				 member = new student(firstname, lastname, address, birthday, phone, term  , 
						InforStudentPrivate.getName_father() , InforStudentPrivate.getPhone_father()
						, InforStudentPrivate.getName_mother() , InforStudentPrivate.getPhone_mother() 
						, InforStudentPrivate.getClasses());
			}
		}
		else if(category.equals("teacher")){
			
			categoryOfRegister = "teacher";
//			create object teacher
			
		}
		String resultConfirm = confirm();
		if (resultConfirm.equals("Register") && member != null) {

//			check data user input , return true if valid and register success, otherwise false
			boolean result = DAO.RegisterMemberByAdmin(member, 1);
			if (result) {
				System.out.println("register succes!");
			} else {
				System.out.println("register wrong , Please re-enter!");
				AddMember(category);
			}
		}
	}

	
	private student registerStudent() {
		
//		name father
		System.out.println("				  Name Father :");
		String NameFather = scanner.nextLine();
		if (NameFather.equals("0")) {
			String option = option();
			if (option != null) {
				NameFather = option;
			} else {
				return null;
			}
		}

		
		System.out.println("				  Phone Father :");
		String PhoneFather = scanner.nextLine();
		if (PhoneFather.equals("0")) {
			String option = option();
			if (option != null) {
				PhoneFather= option;
			} else {
				return null;
			}
		}
		
		
		System.out.println("				 Name Mother :");
		String NameMother = scanner.nextLine();
		if (NameMother.equals("0")) {
			String option = option();
			if (option != null) {
				NameMother = option;
			} else {
				return null;
			}
		}
		
		System.out.println("				 Phone Mother :");
		String PhoneMother = scanner.nextLine();
		if (PhoneMother.equals("0")) {
			String option = option();
			if (option != null) {
				PhoneMother = option;
			} else {
				return null;
			}
		}
		
		System.out.println("				 Class :");
		String clases = scanner.nextLine();
		if (clases.equals("0")) {
			String option = option();
			if (option != null) {
				clases = option;
			} else {
				return null;
			}
		}
		
		student students = new student(NameFather, PhoneFather, NameMother, PhoneMother, clases);
		return students;
	}
	
	
	private String confirm() {

		System.out.println("confirm(3)");
		int confirm = scanner.nextInt();
		if (confirm == 3) {
			scanner.nextLine();
			return "Register";
		} else if (confirm == 0) {
			String option = option();

//			if Admin choose option 'continue' and enter 3 to confirm 
			if (option.equals("3")) {
				System.out.println("register succes!");
				return "Register";
			}

//			if Admin choose option 'continue ' and enter != 3 to confirm , after will re-confirm
			else if (option != null && !option.equals("3")) {
				confirm();
			}
		} else {
			confirm();
		}
		return "No Register";
	}
}
