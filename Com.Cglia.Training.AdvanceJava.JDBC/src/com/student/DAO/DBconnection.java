package com.student.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	public static Connection DBconn() {
		String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	      String userName = "SYSTEM";
	      String password = "SYSTEM";
	      Connection con = null;
	      try {
	         System.out.println("Connecting to database..............."+jdbcURL);
	         Class.forName("oracle.jdbc.OracleDriver");
	         con = DriverManager.getConnection(jdbcURL, userName, password);
	         System.out.println("Connection is successful!!!!!!");
	      } catch(Exception e) {
	         e.printStackTrace();
	      } 
	      return con;
	}

}
