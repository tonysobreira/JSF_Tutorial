package com.jsf.bean;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.h2.tools.RunScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jsf.model.Person;
import com.jsf.service.PersonService;

@ManagedBean(name = "personBean")
@SessionScoped
@Controller
public class PersonBean {

	private Person person;
	
	@Autowired
	private PersonService personService;
	
	public PersonBean() {
		person = new Person();
		
		//Test
		String url = "jdbc:h2:~/test";
		String username = "sa";
		String password = "";
		
		try {
			Connection connect = DriverManager.getConnection(url, username, password);
			
			StringBuilder sb = new StringBuilder();
			
			//sb = new StringBuilder("DROP TABLE PERSON;");
			//RunScript.execute(connect, new StringReader(sb.toString()));
			
			sb = new StringBuilder("CREATE TABLE PERSON (\r\n" + 
					"  id int(11) unsigned NOT NULL AUTO_INCREMENT,\r\n" + 
					"  name varchar(20) NOT NULL DEFAULT '',\r\n" + 
					"  country varchar(20) DEFAULT NULL,\r\n" + 
					"  PRIMARY KEY (`id`)\r\n" + 
					") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;");
			RunScript.execute(connect, new StringReader(sb.toString()));
			
		} catch (SQLException ex) {
			System.out.println("in exec");
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void addPerson() {
		this.personService.addPerson(this.person);
		this.person = new Person();
	}
	
	public void removePerson(Person p) {
		this.personService.removePerson(p);
	}
	
	public List<Person> listPersons() {
		return this.personService.listPersons();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
