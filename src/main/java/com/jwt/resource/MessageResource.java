package com.jwt.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




@Path("Messages")//it tells the class like this which handles rsource & register this class in wweb xml init param
public class MessageResource {

	 @GET
	@Produces(MediaType.TEXT_PLAIN)//it need to know what format response should be in
//using enumeration media type like (application xml, application json,text plain)
	 @Path("/getMsg")//this path will tell where to map hhtp request to which java method
	public String getMessages()
	{
		return "message from messgaes resource";
	}
	
}
