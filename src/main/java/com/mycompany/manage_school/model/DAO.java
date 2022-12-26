package com.mycompany.manage_school.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

		String query = "insert into account values ('" + accountStudent.getUsername() + "','"
				+ accountStudent.getPassword() + "','student')";

//		get connect to SQL server
		Connection connect = connectSqlServer();

//		get statement
		try {
			Statement statement = connect.createStatement();

			int result = statement.executeUpdate(query);
			if (result > 0) {
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
		String queryMember = "insert into Information values ('" + member.getFirstname() + "','" + member.getLastname()
				+ "', '" + member.getAddress() + "'" + ",'" + member.getBirthday() + "','" + member.getTerm() + "', '"
				+ member.getPhone() + "', " + ID_ADMIN + ")";

//  get connect to SQL server
		Connection connect = connectSqlServer();

		int idOfInformationCurrent = takeIdBiggestOfInformation();

//	get statement
		try {
			Statement statement = connect.createStatement();
			int result = statement.executeUpdate(queryMember);
			if (result <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

//		insert follow category (student or teacher)
		String QueryFollowCategory = "";
		if (member instanceof student) {
			QueryFollowCategory = "insert into student values (" + (idOfInformationCurrent + 1) + ",'"
					+ ((student) member).getName_father() + "', '" + ((student) member).getPhone_father() + "', '"
					+ ((student) member).getName_mother() + "', '" + ((student) member).getPhone_mother() + "', '"
					+ ((student) member).getClasses() + "')";
		} else if (member instanceof teacher) {
			QueryFollowCategory = "";
		}
//	get statement
		try {
			Statement statement = connect.createStatement();
			int result = statement.executeUpdate(QueryFollowCategory);
			if (result > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

//	 take id biggest (id auto increase) of Information
//	 purpose is insert into the ID of student and teacher
	private static int takeIdBiggestOfInformation() {
		String query = "select TOP 1 ID from Information	\r\n" + "ORDER BY ID DESC";

		Connection connect = connectSqlServer();
		try {
			Statement statement = connect.createStatement();
			ResultSet result = statement.executeQuery(query);
			if (result != null) {
				while (result.next()) {
					int ID = result.getInt("ID");
					return ID;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static boolean LogAdminManager(String username, String password) {
		Connection connect = connectSqlServer();
		String query = "select * from adminManager\r\n" + "where username = '" + username + "'";
		try {
			Statement statement = connect.createStatement();
			ResultSet AccountAdminManager = statement.executeQuery(query);
			if (AccountAdminManager != null) {
				while (AccountAdminManager.next()) {
					String passwordOfSQL = AccountAdminManager.getString("password");

//					so sánh pass của input và pass trong database
					if (password.equals(passwordOfSQL.strip())) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

// log Admin admissions , posts, account Censorship
	public static boolean logAdminDepartment(String username, String password, String category) {

		Connection connect = connectSqlServer();
		String query = "select * from accountAdmin \r\n" + "where username = '" + username + "' and category = '"
				+ category + "'";
		try {
			Statement statement = connect.createStatement();
			ResultSet Account = statement.executeQuery(query);
			if (Account != null) {
				while (Account.next()) {
					String passwordOfSQL = Account.getString("password");

//					so sánh pass của input và pass trong database
					if (password.equals(passwordOfSQL.strip())) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean ChangePassword(String username, String category, String phoneInput, String phonefather,
			String phonemother) {

		Connection connect = connectSqlServer();
		String query = "select i.phone , s.số_điện_thoại_bố as phoneFather,  s.số_điện_thoại_mẹ as phoneMother\r\n"
				+ "From Information i\r\n" + "inner join account a on a.ID_account = i.ID\r\n"
				+ "inner join student s on i.ID = s.IDstudent\r\n" + "where a.username = '" + username + "'";
		try {
			Statement statement = connect.createStatement();
			ResultSet Account = statement.executeQuery(query);
			if (Account != null) {
				while (Account.next()) {
					String phone = Account.getString("phone");
					String phoneFather = Account.getString("phoneFather");
					String phoneMother = Account.getString("phoneMother");

//					so sánh input của người dùng và trong database
					if (phone.equals(phoneInput) && phoneFather.equals(phonefather)
							&& phoneMother.equals(phonemother)) {
						return true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean updateNewPassword(String username, String newpassword) {

		Connection connect = connectSqlServer();
		String query = "UPDATE account \r\n"
				+ "SET password = '"+ newpassword +"'\r\n"
				+ "WHERE username = '"+ username +"'";
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

}
