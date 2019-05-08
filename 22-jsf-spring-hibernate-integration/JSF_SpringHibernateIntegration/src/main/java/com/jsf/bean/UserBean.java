package com.jsf.bean;

import java.io.Serializable;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.h2.tools.RunScript;

import com.jsf.model.User;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean extends BaseBean implements Serializable {

	private static final long serialVersionUID = -54255255545386196L;
	private User user;
	
	public UserBean() {
		user = new User();
		
		//Test
		String url = "jdbc:h2:~/test";
		String username = "sa";
		String password = "";
		
		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			
			StringBuilder sb = new StringBuilder();
			
//			sb = new StringBuilder("DROP TABLE Users;");
//			RunScript.execute(connect, new StringReader(sb.toString()));
			
			sb = new StringBuilder(" CREATE TABLE USERS ( \r\n" + 
					"  id int(11) unsigned NOT NULL AUTO_INCREMENT, \r\n" + 
					"  username varchar(20) NOT NULL DEFAULT '', \r\n" + 
					"  password varchar(20) NOT NULL DEFAULT '', \r\n" + 
					"  PRIMARY KEY (`id`) \r\n" + 
					") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8; ");
			
			RunScript.execute(connect, new StringReader(sb.toString()));
			
		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}
		
	}

	public void test() {
		for (User user : getFacade().listUser()) {
			System.out.println(user);
		}
	}
	
	public List<User> listUser() {
		return getFacade().listUser();
	}
	
	public void saveUser() {
		getFacade().saveUser(user);
		user = new User();
	}
	
	public void deleteUser(User user) {
		getFacade().deleteUser(user);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
