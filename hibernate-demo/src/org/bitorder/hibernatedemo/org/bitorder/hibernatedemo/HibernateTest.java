package org.bitorder.hibernatedemo;

import java.util.Date;

import org.bitorder.hibernatedemo.dto.Address;
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
		 user.setDate(new Date());
		 user.setAddress("lko");
		 
		 
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
	
	session.close();//ideally session close is in finally block and we catch any exception by transaction.rollback
	
	//using hibernatea api to fetch objecrt we inserted
	
	user=null;
	//second timee no need to create session factory objrct to get created (it is expensive oobj and require lot of resources to get created)
	
     session = sessionFactory.openSession();
     session.beginTransaction();
 	user=(UserDetails)	session.get(UserDetails.class, 1);//tell the class for which you want  to retrieve which tells model object u want to retrieve//now tell data u wan  to retrive by tellling waht is primary key
	//no need to tell key as already annotatted
	System.out.println("retrieved user is"+user.getUsername());
	
	UserDetails user2 = new UserDetails();
	user2.setUsername("rishabh2");
	
	user2.setAddress("sfss");
	 user.setDate(new Date());
	 user.setUsername("fdsgs");
	session.save(user2);
	
	//natural vs surrogate key
	//if in table we have column we know will have distinct value and also is mandatory 
	//exmpple user registration applcation where user giving first last name email (business rule dictates that every user has to provide distict user id for registring)
	//so we can have email adress as promary key, so sucg columns which are there fro business reason but then u assign one of them to be primary key
	//such keys are natural keys
	
	/*surrogate- we have no column to be marked as unique or we anticipate that column value can be changed in future
	 * in that case we add a new column act as a primary key alone it does not carry any business significance alone,we have column that only act as keyexmple serial no depicts each role for each row but have no busines use
	 * */
	/*we have to provide natural key by ourself but surrogate key can be provided by hibernate which can anything (adding onee to last entry)but unique not null mandatory*/
	
	
	///////////////////////////////////////////////////////
	//for the previous example we made sample that each memevr variable mamkes one colmn
//	but what if one of the memebr variable is an object instead of simple datatupe like data varchar integer
	/*and object has member variable inside of them what if one of them is an array list set how can w save thaat*/
	
	
	
	
	//example user class has adress object and adress object has memebr variable
	/*we will treat member variable of adress object same way we treat member varibale of user class this casse will work fine if inside user class there is value object*/

	/*object in hibernate is of two types one is value object other is entity object
entity .entity object are to be saved in dtaabase as seperate table	(or it is an entity mean it contains data and provide meaning to itself)
value object is also having data and also will be saved in database but does not have its meaning in independent it provide meaning to other object

example adress object having memebr variable zip  pin state city but adress object as of itself does no carry any meaning
(together it has meaning ex adrersss of this user class same as name,phone of this user class)

*/	
	
	
	Address adrs = new Address();
	
	adrs.setStreet("up");
	adrs.setCity("lko");
	
	
	adrs.setPincode("226003");
	adrs.setStreet("chk");
	user2.setAdress(adrs);
	
	
	
	
	
	
	
	
	
	}
	
}
