package org.bitorder.hibernatedemo;

import org.bitorder.hibernatedemo.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	
	public static void main(String []args)
	{
		
		//--- to use  hibernate api for storing obj in db
/*	1create session factory object which is one object per application 
		it create session according to requirement throughout execution period 
eg if we wnat to save something get the session  from session factory and save*/	
		
	//2 create session from session factory
	//3 use session to save model object
		//=========================================
		//changing value to different it will recreate schema as set to create in config file
		/*by reading into all model objectss and looking at class name and creating table ouut of it looking at id for properties and creating primary key out of it
		 *  and will recreate on startuop*/
		
		UserDetails user = new UserDetails(); 
		user.setUserId(1);
		user.setUsername("first user");
		//to persist this object use hibernate appi
		//normally if this was service method we would pass this objdect to dao
		//dao woul take care to save object using hibernate api
		/*but here we will use saving object using service method itselff*/
		
		
		
		/*USING HIBERNATE API  
		 * create session factory (session factory is only one object per application ) responsibility of this session is to
		 * create session depending on how many other sessions you want in your application throughout execution period
		 *-> session factory need to be created so that session object can be made which can further used in saving...by this sessu=ion factory get hold of session object 
		 * */
		
		
		
		
	//tp get the session factory we need to get configuration
	//open up already made configuration file by calling Configuration()
	//configure() reads up the xml file	//configure takes configuration file reads it for database configuration
    //call build session factoy method that return session factory
		//sessionFactory can be used to create new sessions
		//=========================================
		SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
	
	
	//open session of session factoory object'
	//session objetc can be used to save model object here it is user
	//=========================================
	Session session = sessionFactory.openSession();
	
	
	//before saving we need to open transaction
	//(in a single transaction we can save as many model object)
	//its a single unit of work
	//=========================================
	session.beginTransaction();
	session.save(user);
	session.getTransaction().commit();
	//to end the transaction first get the transaction then commit it
	
	//(for error handling put everything in try block and in catch put rollback)
	
	//===========================================================================================================================
	//===========================================================================================================================

	//hibernate is an ORM tool 
	
	
	
	
	
	
	
	
	
	}
	
}
