package com.jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsf.dao.CarDao;

@Component
@ManagedBean(name = "carBean")
@SessionScoped
public class CarBean {

	@Autowired
	private CarDao carDao;

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	public List<String> fetchCarDetails() {
		return carDao.getCarDetails();
	}

}
