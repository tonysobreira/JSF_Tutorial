package com.jsf.bean;

import javax.faces.bean.ManagedProperty;

import com.jsf.facade.Facade;

public abstract class BaseBean {

	@ManagedProperty("#{facade}")
	private Facade facade;

	public Facade getFacade() {
		return facade;
	}

	public void setFacade(Facade facade) {
		this.facade = facade;
	}

}
