package com.rocky.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rocky.dao.PersonDao;
import com.rocky.model.Person;

@Path("/service")
public class Service {
	
	
	// Use the below commented code to use REST "without" database
	/*
	
	
	
	
	
	// to stimulate my database
	private static Map<Integer, Person> persons = new HashMap<Integer, Person>();
	
	// this is how i insert my data in database
	
	static
	{
		for(int i = 0; i < 10; i++)
		{
			Person person = new Person();
			int id = i + 1;
			person.setID(id);
			person.setFULL_NAME("The person with id " + id);
			person.setAGE(new Random().nextInt(40) + 1);
			
			persons.put(id, person);
		}
	}
	
	// this below method of mine will return a single person data in XML format
	@GET
	@Path("/getPersonByIdXML/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Person getPersonByIdXML( @PathParam("id") int id)
	{
		return persons.get(id);
	}
	
	
	// this belwo method of my will return single person data in JSON
	@GET
	@Path("/getPersonByIdJSON/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonByIdJSON( @PathParam("id") int id)
	{
		return persons.get(id);
	}
	
	// this method will return a list of all person in XML format
	@GET
	@Path("/getAllPersonsInXML")
	@Produces(MediaType.APPLICATION_XML)
	public List<Person> getAllPersonInXML()
	{
		return new ArrayList<Person>(persons.values());
	}
	
	@GET
	@Path("/getAllPersonsInJSON")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersonInJSON()
	{
		return new ArrayList<Person>(persons.values());
	}
	
	
	
	
	*/
	
	
	
	
	private PersonDao personDao = new PersonDao();
	
	@GET
	@Path("/getPersonByIdXML/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Person getPersonByIdXML(@PathParam("id") int id )
	{
		return personDao.getPersonById(id);
	}
	
	@GET
	@Path("/getPersonByIdJSON/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPersonByIdJSON( @PathParam("id") int id )
	{
		return personDao.getPersonById(id);
	}

	@GET
	@Path("/getAllPersonsInXML")
	@Produces(MediaType.APPLICATION_XML)
	public List<Person> getAllPersonsInXML()
	{
		return personDao.getAllPerson();
	}
	
	
	@GET
	@Path("/getAllPersonsInJSON")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getAllPersonsInJSON()
	{
		return personDao.getAllPerson();
	}
	
	@GET
	@Path("/rocky")
	public String check(){
		return "rocky";
	}
	
	// below is the code to insert new data in my database
	
	@GET
	@Path("/savePerson/{age}/{fullName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String saveNewPerson( @PathParam("age") int age, @PathParam("fullName") String fullName )
	{
		Person person = new Person();
		
		person.setAGE(28);
		person.setFULL_NAME("Shubham");
		
		if( !personDao.savePerson(person) )
		{
			return "{\"status\":\"OK\"}";
		}
		else
		{
			return "{\"status\":\"Not OK\"}";
		}
	}
	
	// below is the code for updating already existing data in database
	@GET
	@Path("/savePerson/{id}/{age}/{fullName}")
	@Produces(MediaType.APPLICATION_JSON)
	public String updatePerson( @PathParam("id") int id, @PathParam("age") int age, @PathParam("fullName") String fullName )
	{
		Person person =new Person();
		
		person.setID(id);
		person.setAGE(age);
		person.setFULL_NAME(fullName);
		
		if( !personDao.savePerson(person) )
		{
			return "{\"status\":\"OK\"}";
		}
		else
		{
			return "{\"status\":\" NOT OK\"}";
		}
	}
}
