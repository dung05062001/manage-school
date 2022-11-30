package com.mycompany.manage_school.handleInput;

import com.mycompany.manage_school.exception.PasswordException;
import com.mycompany.manage_school.exception.UsernameException;

public class log {

	public log() {
	}

//	check user name
	public static void CheckUsername(String username) throws UsernameException {

		String regexUsername = "^[a-zA-Z0-9._-]{3,}$";
		if(username.matches(regexUsername)) {
			
		}
		else {
			throw new UsernameException("user name is wrong");
		}
	}
	
//	check password
	public static void CheckPassword(String password) throws PasswordException {
		
		String regexUsername = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		if(password.matches(regexUsername)) {
			
		}
		else {
			throw new PasswordException("Password Required :\r\n"
					+ "    @At least 8 chars\r\n"
					+ "    @Contains at least one digit\r\n"
					+ "    @Contains at least one lower alpha char and one upper alpha char\r\n"
					+ "    @Contains at least one char within a set of special chars (@#%$^ etc.)\r\n"
					+ "    @Does not contain space, tab, etc.");
		}
	}
	
}
