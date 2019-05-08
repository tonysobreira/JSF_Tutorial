package com.jsf.util;

import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;

import org.h2.tools.RunScript;

public class DataConnect {
	
	public static Connection getConnection() {
		try {
			//Class.forName("org.postgresql.Driver"); 
			//Connection con = DriverManager.getConnection("jdbc:postgresql://10.41.24.27:5432/logintest", "postgres", "1234");
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
	        
			//RunScript.execute(con, new FileReader("C:/Projects/JSF Tutorial/19-jsf-authentication-login-logout-database/JSF_AuthenticationLoginLogoutDatabase/src/main/resources/test.sql"));
			StringBuilder sb = new StringBuilder("DROP TABLE users");
			RunScript.execute(con, new StringReader(sb.toString()));
			
			sb = new StringBuilder("CREATE TABLE users ( \r\n" + 
					"id int(20) NOT NULL AUTO_INCREMENT, \r\n" + 
					"username VARCHAR(60) NOT NULL, \r\n" + 
					"password VARCHAR(60) NOT NULL, \r\n" + 
					"PRIMARY KEY(id))");
			RunScript.execute(con, new StringReader(sb.toString()));
			
			sb = new StringBuilder("INSERT INTO users VALUES(1,'admin','admin');");
			RunScript.execute(con, new StringReader(sb.toString()));
			
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error --> " + ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}

}
