package com.jsf.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.jsf.dao.LoginDAO;
import com.jsf.util.SessionUtils;

@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String username;
	private String password;
	private String message;

	// validate login
	public String validateUsernamePassword() {
		boolean valid = LoginDAO.validate(username, password);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", username);
			System.out.println(SessionUtils.getUserId());
			System.out.println(SessionUtils.getUserName());
			return "admin";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Password", "Please enter correct Username and Password"));
			return "login";
		}
	}

	// logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}