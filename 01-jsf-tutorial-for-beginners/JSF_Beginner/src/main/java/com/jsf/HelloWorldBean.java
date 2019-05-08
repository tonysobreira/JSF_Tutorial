package com.jsf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "helloWorldBean")
@SessionScoped
public class HelloWorldBean implements Serializable {

	private static final long serialVersionUID = -6913972022251814607L;

	private String message = "";

	@PostConstruct
	public void init() {
		this.message = "Hello World!!";
	}

	public String getMessage() {
		System.out.println(message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
