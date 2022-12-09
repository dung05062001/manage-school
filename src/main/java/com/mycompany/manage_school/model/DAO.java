package com.mycompany.manage_school.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mycompany.manage_school.entity.account;
import com.mycompany.manage_school.entity.members;
import com.mycompany.manage_school.entity.student;
import com.mycompany.manage_school.entity.teacher;

public class DAO {

	public static Connection connectSqlServer() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connect = "jdbc:sqlserver://DESKTOP-R6Q5367\\SQLEXPRESS:1433;databaseName=managerstudent";
			String user = "websale";
			String pass = "dung11b4";
			connection = DriverManager.getConnection(connect, user, pass);
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static boolean addAccountStudent(account accountStudent) {
		
		String query = "insert into account values ('"+ accountStudent.getUsername()+"','"
		+ accountStudent.getPassword() 
		+"','student')";
		
//		get connect to SQL server
		Connection connect = connectSqlServer();
		
//		get statement
		try {
			Statement statement = connect.createStatement();
			
			int result = statement.executeUpdate(query);
			if(result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	// viết function handle information user by admin 
	// sửa lại các function login
	// test
	
	public static boolean RegisterMemberByAdmin(members member, int ID_ADMIN) {
		
//		insert information general of member
		String  queryMember = "insert into Information values ('"+ member.getFirstname() +"','"+ member.getLastname() 
		+"', '"+ member.getAddress() +"'"
				+ ",'"+member.getBirthday() +"','"+ member.getTerm() +"', '"+ member.getPhone()
				+"', "+ ID_ADMIN +")";
		
//  get connect to SQL server
		Connection connect = connectSqlServer();
		
//	get statement
		try {
			Statement statement = connect.createStatement();
			
			int result = statement.executeUpdate(queryMember);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
//		insert follow category (student or teacher)
		String QueryFollowCategory = "";
		if(member instanceof student) {
			QueryFollowCategory = "insert into student values ('"+ ((student) member).getName_father() 
					+"', '"+((student) member).getPhone_father()+"', '"+ ((student) member).getName_mother()
					+"', '"+ ((student) member).getPhone_mother() +"', '"+ ((student) member).getClasses() +"')";
		}
		else if(member instanceof teacher) {
			 QueryFollowCategory = "";
		}
//	get statement
				try {
					Statement statement = connect.createStatement();
					int result = statement.executeUpdate(QueryFollowCategory);
					if(result > 0) {
						return true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return false;

	}
}
