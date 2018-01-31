package com.rocky.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rocky.model.Person;
import com.rocky.model.Response;

@Path("/person")      //   @Path annotation specify the URL path on which this method will be invoked
@Consumes(MediaType.APPLICATION_XML)     //  The @Consumes annotation is used to specify the MIME media types a REST resource can consume.
@Produces(MediaType.APPLICATION_XML)    // @Produces annotation specifies the type of output this method (or web service) will produce
public class PersonServiceImpl implements PersonService {
	
	private static Map<Integer,Person> persons = new HashMap<Integer, Person>();

	@Override
	@POST
	@Path("/add")
	public Response addPerson(Person p) {
		
		Response response = new Response();
		if( persons.get( p.getId() )    !=    null )
		{
			response.setStatus(false);
			response.setMessage("Person already exist");
			return response;
		}
		
		persons.put(p.getId(), p);
		response.setStatus(true);
		response.setMessage("Person Created successfully");
		return response;
	}

	@Override
	@GET
	@Path("/{id}/delete")
	public Response deletePerson( @PathParam("id") int id)  // We can bind REST-style URL parameters to method arguments using @PathParam annotation
	{
			Response response = new Response();
			if( persons.get(id) == null )
			{
				response.setStatus(false);
				response.setMessage("person do not exist, i repeat.... Abe person nahi hai, samaj aaya");
				return response;
			}
			
			persons.remove(id);
			response.setStatus(true);
			response.setMessage("Person deleted successfully.... i repeat....person ko nikla diya");
			return response;
	}

	@Override
	@GET
	@Path("/{id}/getDummy")
	public Person getPerson( @PathParam("id") int id) 
	{
		Person p = new Person();
		p.setAge(100);
		p.setName("Navami Bekal");
		p.setId(id);
		return p;
	}

	@Override
	@GET
	@Path("/getAll")
	public Person[] getAllPersons() 
	{
		Set<Integer> ids = persons.keySet();
		Person[] p = new Person[ids.size()];
		int i = 0;
		
		for (Integer id : ids)
		{
			p[i] = persons.get(id);
			i++;
		}
		
		return p;
	}
	
	

}
