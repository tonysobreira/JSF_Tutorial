package com.jsf.bean;

import java.io.Serializable;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.h2.tools.RunScript;

import com.jsf.model.Car;

@ManagedBean
@SessionScoped
public class CarBean implements Serializable {

	private static final long serialVersionUID = 6081417964063918994L;

	public List<Car> getCars() throws ClassNotFoundException, SQLException {

		Connection connect = null;

		//String url = "jdbc:mysql://localhost:3306/cardb";
		String url = "jdbc:h2:~/test";

		String username = "sa";
		String password = "";

		try {

			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("org.h2.Driver");

			connect = DriverManager.getConnection(url, username, password);
			// System.out.println("Connection established"+connect);
			
			StringBuilder sb = new StringBuilder();
					
//			sb = new StringBuilder("CREATE DATABASE cardb;");
//			RunScript.execute(connect, new StringReader(sb.toString()));
//			
//			sb = new StringBuilder("USE cardb;");
//			RunScript.execute(connect, new StringReader(sb.toString()));
			
			sb = new StringBuilder("DROP TABLE Car;");
			RunScript.execute(connect, new StringReader(sb.toString()));
			
			sb = new StringBuilder("CREATE TABLE Car(\r\n" + 
					"	car_id INTEGER NOT NULL AUTO_INCREMENT,\r\n" + 
					"	cname VARCHAR(60) NOT NULL,\r\n" + 
					"	color VARCHAR(60),\r\n" + 
					"	speed INTEGER,\r\n" + 
					"	Manufactured_Country VARCHAR(100),\r\n" + 
					"	PRIMARY KEY(car_id));");
			RunScript.execute(connect, new StringReader(sb.toString()));
			
			sb = new StringBuilder("INSERT INTO Car VALUES(1,'Zen','Grey',45.34,'India');\r\n" + 
					"INSERT INTO Car VALUES(2,'Volkswagen','Black',49.64,'Germany');\r\n" + 
					"INSERT INTO Car VALUES(3,'Polo','White',52.33,'Japan');\r\n" + 
					"INSERT INTO Car VALUES(4,'Audi','Blue',55.98,'Germany');\r\n" + 
					"INSERT INTO Car VALUES(5,'Innova','Maroon',39.97,'France');\r\n" + 
					"INSERT INTO Car VALUES(6,'FiatPalio','Silver',35.45,'Italy');\r\n" + 
					"INSERT INTO Car VALUES(7,'Qualis','Red',23.35,'Paris');\r\n" + 
					"INSERT INTO Car VALUES(8,'Tesla','Grey',25.55,'EUA');");
			RunScript.execute(connect, new StringReader(sb.toString()));

		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}

		List<Car> cars = new ArrayList<Car>();
		PreparedStatement pstmt = connect
				.prepareStatement("select car_id, cname, color, speed, Manufactured_Country from Car");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			Car car = new Car();
			car.setCid(rs.getInt("car_id"));
			car.setCname(rs.getString("cname"));
			car.setColor(rs.getString("color"));
			car.setSpeed(rs.getInt("speed"));
			car.setMfdctry(rs.getString("Manufactured_Country"));

			cars.add(car);

		}

		// close resources
		rs.close();
		pstmt.close();
		connect.close();

		return cars;

	}

}