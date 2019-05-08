package com.jsf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsf.dao.PersonDAO;
import com.jsf.model.Person;

//@ManagedBean(name = "personService")
//@SessionScoped
@Service("personServiceImpl")
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public PersonServiceImpl() {
		System.out.println(personDAO);
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public void removePerson(Person p) {
		this.personDAO.removePerson(p);
	}

}