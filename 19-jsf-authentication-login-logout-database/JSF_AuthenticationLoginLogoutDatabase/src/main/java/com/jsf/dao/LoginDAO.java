package com.jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsf.model.User;
import com.jsf.util.DataConnect;

public class LoginDAO {

	public static boolean validate(String username, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DataConnect.getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(" select username, password ");
			sql.append(" from users ");
			sql.append(" where 1 = 1 ");
			sql.append(" and username = ? ");
			sql.append(" and password = ? ");

			ps = con.prepareStatement(sql.toString());
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				// result found, means valid inputs
				
				User user = new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error --> " + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
		return false;
	}

}
