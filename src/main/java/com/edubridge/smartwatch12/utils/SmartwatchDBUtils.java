package com.edubridge.smartwatch12.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SmartwatchDBUtils {
	public static Connection getConnection() {
		Connection con = null;
		String driver,url,user,password;
		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/edb12492";
		user = "root";
		password = "root";
		
		try {
			Class.forName(driver);
		}catch (ClassNotFoundException e) {
			System.out.println("no driver found");		
		}
			
		try {
			con=DriverManager.getConnection(url,user,password);
		}catch (SQLException e) {
			e.printStackTrace();	}
		return con;
	}
}

