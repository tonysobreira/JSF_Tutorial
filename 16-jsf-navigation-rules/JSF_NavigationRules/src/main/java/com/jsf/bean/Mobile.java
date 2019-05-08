package com.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Mobile implements Serializable {

	private static final long serialVersionUID = 8914753191519956089L;
	private String mname;
	private String modelno;
	private String color;

	public Mobile() {
	}

	public Mobile(String mname, String modelno, String color) {
		this.mname = mname;
		this.modelno = modelno;
		this.color = color;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getModelno() {
		return modelno;
	}

	public void setModelno(String modelno) {
		this.modelno = modelno;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String add() {
		return "addform";
	}

	public String view() {
		return "viewform";
	}
}