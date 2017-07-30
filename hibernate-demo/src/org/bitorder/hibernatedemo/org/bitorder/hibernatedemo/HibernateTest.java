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
	//	 user.setAddress("lko");
		 
		 
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
	
//	user2.setAddress("sfss");
	 user2.setDate(new Date());
	 user2.setUsername("fdsgs");
	
	
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
	adrs.setState("chk");
	user2.setAdress(adrs);

	
	//there is one implication of embedded member variable 
		//for normal member we can configure each columna name use column annotation
		//but for object type memebr we can change example city under address object how can we do using column annotation
		//we can do it directly goint to city and use column annotationthere or
		//we can use Annotation @ATTRIBUTEOVERRIDE(name="street",column=column(name="HOME_STREETNAME") to specify name change in column
		//this could be done when we have two instance of same class like homeadress and oficeadresss and column name we have to make 
		//different for each
	session.save(user2);
	session.getTransaction().commit();
	session.close();
	
	
	///////////////////////////////////////////////////////////
	////////sving collection///////////////////////////////////
	////////////////////////////////////////////////////////////
	session = sessionFactory.openSession();
    session.beginTransaction();
    //what if we dont know how many address object we need when collection is a member variable
	//scenario is we want all the places person lived to that address having list of address(no idea how many address expected)
    //if there are fixed no of object we can make fix no of columns like if we have home addres office adress we can make seperate column for each
    //but how many address object we aare having is not known
   //how wee  willl design table---> we will create different table for the address data
    //and will get reference to the users id eg we have user id 1 and have ffive address to that 
   // thn will insert 5 records in seperate table called address table and each of the 5 table willl have user id one associated with it as foreign key
  //  we know user 1 has 5 address associated with it.
    //WEE WILL CREATE COLLECTION OF ADDRESS IN USER DETAILS ENTITY CLASS
//INSTANTIATE IT    
	
    user.getListofAddresses().add(adrs);
    session.save(user);
    session.getTransaction().commit();
	session.close();
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////CONFIGURING COLLECTION AND ADDING KEYS//////////////////////////////
	///////////////////////////////////////////////////////////////LECT 11//////////////////////////////////////////////////////////

	
	
	
	
	}
}
