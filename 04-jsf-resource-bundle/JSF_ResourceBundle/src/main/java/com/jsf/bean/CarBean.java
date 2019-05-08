package com.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "carBean")
@SessionScoped
public class CarBean implements Serializable {

	private static final long serialVersionUID = 2365430039111106167L;

	private String id;
	private String name;
	private String color;
	private String model;
	private String registrationNumber;

	public CarBean() {
	}

	public CarBean(String name, String color, String id, String model, String registrationNumber) {
		this.name = name;
		this.color = color;
		this.id = id;
		this.model = model;
		this.registrationNumber = registrationNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		System.out.println("Car name is: " + name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public void clearAll() {
		this.id = "";
		this.name = "";
		this.color = "";
		this.registrationNumber = "";
		this.model = "";
	}

}
