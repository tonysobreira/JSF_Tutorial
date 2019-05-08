package com.jsf.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsf.dao.UserDAO;
import com.jsf.model.User;

@Service("userService")
public class UserServiceImpl implements UserService, Serializable {

	private static final long serialVersionUID = 4566445645512541971L;

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public void saveUser(User user) {
		this.userDAO.saveUser(user);
	}

	@Transactional
	public List<User> listUser() {
		return this.userDAO.listUser();
	}

	@Transactional
	public void deleteUser(User user) {
		this.userDAO.deleteUser(user);
	}

}
