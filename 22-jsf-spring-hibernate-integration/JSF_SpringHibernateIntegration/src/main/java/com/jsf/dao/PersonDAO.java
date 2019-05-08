package com.jsf.dao;

import java.util.List;

import com.jsf.model.Person;

public interface PersonDAO {

	public void addPerson(Person p);

	public List<Person> listPersons();
	
	public void removePerson(Person p);

}
