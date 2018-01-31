package com.rocky.book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/book")
public class Book {
	
/*	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHello()
	{
		String response = "<?xml version='1.0'?>" + 
							"<hello>Hello XML</hello>";
		return response;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHeloHTML()
	{
		String response = "<h1>Hello HTML</h1>";
		return response;
	}
	
	// now if i execute this program then output of HTML will be shown ,because browser always try to process html first
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJSON()
	{
		String response = "write a json dude";
		return response;
	}
	*/
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("{name}")
	public String sayHelloXML( @PathParam("name") String name )
	{
		String response = "<?xml version='1.0'?>" + 
				"<hello>Hello " + name + "</hello>";
		return response;
	}

}
