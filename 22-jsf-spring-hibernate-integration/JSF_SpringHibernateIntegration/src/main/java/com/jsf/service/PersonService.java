package com.jsf.service;

import java.util.List;

import com.jsf.model.Person;

public interface PersonService {

	public void addPerson(Person p);

	public List<Person> listPersons();
	
	public void removePerson(Person p);

}
