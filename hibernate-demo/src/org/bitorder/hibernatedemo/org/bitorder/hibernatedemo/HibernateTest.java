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
		UserDetails user = new UserDetails(); 
		user.setUserId(4);
		user.setUsername("fourth user");
	//tp get the session factory we need to get configuration
	//open up already made configuration file by calling Configuration()
	//configure() reads up the xml file	
    //call build session factoy method that return session factory
		//=========================================
		SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();
	
	
	//open session of session factoory object'
	//session objetc can be used to save model object here it is user
	//=========================================
	Session session = sessionFactory.openSession();
	
	
	//before saving we need to open transaction
	//(in a single transaction we can save as many model object)
	//its a unit of work
	//=========================================
	session.beginTransaction();
	session.save(user);
	session.getTransaction().commit();
	//to end the transaction first get the transaction then commit it
	
	//(for error handling put everything in try block and in catch put rollback)
	}
	
}
