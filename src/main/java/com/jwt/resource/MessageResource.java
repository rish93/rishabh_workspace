package com.jwt.resource;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.jwt.dao.*;
import com.jwt.model.MessageModel;



@Path("/Messages")//it tells the class like this which handles rsource & register this class in wweb xml init param
public class MessageResource {

	 MessageDAO msgs = new MessageDAOImpl(); 
	
	 //jax B is require to convert to xmml, 
	 //but jax b need clue to convert to xml,
	 //first is annotation @xmlrootelement on model class bean...
	@GET
	@Produces(MediaType.TEXT_XML)/*TEXT_XML*///it need to know what format response should be in
     //using enumeration media type like (application xml, application json,text plain)
	 @Path("/getMsg")//this path will tell where to map hhtp request to which java method
	public List<MessageModel> getMessages()
	{
		
		 
         return msgs.getData();
		
		//	return Response.status(200).entity(msgs.getData().get(0)).build();
		
	
	}
	
	 
	@POST
	@Path("/setMsg")//this path will tell where to map hhtp request to which java method
	public String setMessages()
	{
		 Integer a = new Integer(1);
		System.out.println("in resource"); 
		msgs.setMessage(a, "msg", "author", new Date());
		return "message from messgaes resource";
	}
	
	//tool that let you send rest api request and get responses in return,
	//ie rest api client to send request and get response in detail hence use postman,
	//to get control on send request,
	
	@PUT
	@Path("/updateMsg/{id}")
	public void update(Long id,String msg)
	{
		
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/get/{id}")
	public List<MessageModel> getIdMsg(@PathParam("id") Integer id)
	{
		System.out.println("------------"+id);
		System.out.println(msgs.getParticularMsg(id));
    return	msgs.getParticularMsg(id);
		
	
	}
	
	@PUT
	@Path("/deleteMsg/{id}")
	public void deleteMsg(Long id)
	{
		
		
	}
	@PUT
	@Path("/deleteAllMsg")
	public void deleteAllMsg()
	{
		
		
	}
	
	
}
