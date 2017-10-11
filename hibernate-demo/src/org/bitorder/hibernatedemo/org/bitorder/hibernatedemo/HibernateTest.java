package org.bitorder.hibernatedemo;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.bitorder.hibernatedemo.dto.Address;
import org.bitorder.hibernatedemo.dto.CascadingUserClass;
import org.bitorder.hibernatedemo.dto.CascadingVehicleClass;
import org.bitorder.hibernatedemo.dto.CrudOperationClass;
import org.bitorder.hibernatedemo.dto.FourWheelerInheritenceClass;
import org.bitorder.hibernatedemo.dto.FourWheelerInheritenceJoined;
import org.bitorder.hibernatedemo.dto.ManyToManyUserDetailClass;
import org.bitorder.hibernatedemo.dto.ManyToManyVehicleListClass;
import org.bitorder.hibernatedemo.dto.OneToManyMapping;
import org.bitorder.hibernatedemo.dto.OneToManyVehicle;
import org.bitorder.hibernatedemo.dto.OneToOneMapping;
import org.bitorder.hibernatedemo.dto.OneToOneVehicle;
import org.bitorder.hibernatedemo.dto.TransientPersistenceDetachedUserDetailsClass;
import org.bitorder.hibernatedemo.dto.TwoWheelerInheritenceClass;
import org.bitorder.hibernatedemo.dto.TwoWheelerInheritenceJoined;
import org.bitorder.hibernatedemo.dto.TwoWheelerInheritenceTablePerClass;
import org.bitorder.hibernatedemo.dto.UserDetails;
import org.bitorder.hibernatedemo.dto.VehicleInheritenceClass;
import org.bitorder.hibernatedemo.dto.VehicleInheritenceJoined;
import org.bitorder.hibernatedemo.dto.VehicleInheritenceTablePerClass;
import org.hibernate.Query;
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

	/*to define an id for collection whci is inside an entity class*/
/*	ie index to column we need to have data type that supports indes we caannot
	use HashSet for it*/

	session = sessionFactory.openSession();
    session.beginTransaction();
	Address adrs3 = new Address();
	UserDetails usr4=new UserDetails();
	adrs3.setStreet("up");
	adrs3.setCity("lko");
	adrs3.setPincode("226003");
	adrs3.setState("chk");
	usr4.setDescription("CONFIGURING COLLECTION ADDING KEY");
	usr4.setDate(new Date());
	usr4.setUsername("Lect11");
	usr4.getArrayListAddress().add(adrs3);
	
	
	session.save(usr4);
    session.getTransaction().commit();
	session.close();
	
	
	///////////////////////////////////////////////////////////////LECT 11//////////////////////////////////////////////////////////

	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////PROXY OBJECT AND EAGER AND LAZY FETCH TYPE 12////////////////////////////////
	
	//if we want to get user details
	session=sessionFactory.openSession();
	//this used=r object has array list
	user=(UserDetails)	session.get(UserDetails.class, 4);
	//when we are doinf session get we are getting user object, user object has array list of addresses
	//then does whole loist of addresses get pulled up, if yes then if there are 100 addresses of user if all 
	//gte pulled up then what is cost and perfoemance impact 
	session.close();
	//hence hibernate doesnt load all we can also configur it expplicitly
	user.getArrayListAddress();
	System.out.println(user.getArrayListAddress().size());
	
	//when we do getList OF address then comlplete list is fetched
	/*{this kind of sstrategy is called lazy initialization}
	 * LAZY INITIALIZATION- depicts you do not initialize entire objects u only initialize first level variabled
	 * (first level memeber variable of the objefts)then u initializa the list when u access it
	 * defualt is lazy initialization
	 * EAGER initialization states when object uses this initialization method gets all the related data corrs to this object
	 *///it uses lot of resources and time
	 /*
	  * how getlist of address ret7rn every detail in object ei(user class{getID,getNAme,getListofAddress})
	  * 
	  * how it worksie when we call get lis of adress---{hibernate instead of getting
	  * actual object u are looking for gets u the proxy for the first tuime }---
	  *its the dynamiz sub class of your actual objetc we are looking for 
	  * --we do session get of user classhibernate insread of giving user class directly ie getting all the value and packaging it into user class
	   *proxy is a class that has same methods as user class
	   *
	   *--->it will also give inner method getid(),getname(),getlistofaddress() of proxy user class
	   *----> each of the method will get called of user class method through proxy user class
	   *--->we are handed over proxy user class, s when making call we will get method of getListOfAddress() of proxy object
	   *,which will not have all the detial 
	   */
	//to check it is proxy objetc not actual user object before we get th list of addresses, or proxy object gets the list of data and saves to
	//member variable, do a session close() before proxy object gets a chance to get the list of addresses
	//the proxy object will not have session to get list of addresses
	
	//in lazy it will wait for fist accesss to fetch it while 
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////PROXY OBJECT AND EAGER AND LAZY FETCH TYPE////////////////////////////////
	
	
	//////////////////////////////////////////////////////////
	///one to one mapping   lect 13
	//////////////////////////////////////////////////////////
	
	/* looking at entity within anothe rentity*/

	OneToOneMapping oto = new OneToOneMapping();
	 
	OneToOneVehicle oto2= new OneToOneVehicle();
	oto.setName("1to1 mapping eg");
	
	oto2.setVehiclename("car");
	
	oto.setOt(oto2);
	session= sessionFactory.openSession();
	session.beginTransaction();
	
	
	//currently independent entities with no relation to have relation put one entities instance in another
	//oto.setOt(oto2);//by doing this new column will come in onetoonemapping pointing to
	//onetoonemappingvehicle id
	
	
	session.save(oto2);
	session.save(oto);
    session.getTransaction().commit();
	session.close();
	
	//////////////////////////////////////////////////////////
	///one to one mapping   lect 13
	//////////////////////////////////////////////////////////
	
	//////////////////////////////////////////////////////////
	///one to many mapping   lect 14
	//////////////////////////////////////////////////////////
	//now single user boject with multiple vehicle object will lead to one to many mappiing
	//depending on how we arfe looking at it it can be many to one from vehicle to user
	//or one to many from user to vehicle
	
	//join column is optional just like in one to one 
	
	

	
	
	OneToManyMapping otm = new OneToManyMapping(); 
	OneToManyVehicle otv = new OneToManyVehicle(); 
	OneToManyVehicle otv2 = new OneToManyVehicle();
	System.out.println("opening");

	otv.setName("bus");
	otv2.setName("car");
	
	otm.getOtom().add(otv);//here we added vehicle to user
	otm.getOtom().add(otv2);
	otm.setLectNameOnetomany("Lect 14 one to many");
	
	//in reverse r/n we can add user to ehicle as well
	otv.setUser(otm);//setting bydirectional r/n
	otv2.setUser(otm);//so in real world app we can get one from another 
	//like user.getvehicle() or vehicle.getuser()
	/*or we can have convenoience methos in any of the 
	 * bean class
	 * and do user.getvehicle.add(vehicle)
	 * and also vehicle.setuser(user)
	 * and can pass both user and vehicle iibject in convenience method to link both of them */
	
	session = sessionFactory.openSession();
	
	
	session.beginTransaction();
	session.save(otm);
	session.save(otv2);
	session.save(otv);
	session.getTransaction().commit();
	System.out.println("closing");
	session.close();
	
    /*
     *select * from otm_mappingclass;
+----+---------------------+
| id | LectNameOnetomany   |
+----+---------------------+
|  1 | Lect 14 one to many |
|  2 | Lect 14 one to many |
+----+---------------------+
     * 
     * 
     * select * from otm_vehicleclass;
+-----------+------+
| vehicleid | name |
+-----------+------+
|         1 | car  |
|         2 | bus  |
+-----------+------+
     * 
     * 
     * 
     *  otm_mappingclass_otm_vehicleclass;
+---------------------+----------------+
| OTM_MappingClass_id | otom_vehicleid |
+---------------------+----------------+
|                   2 |              1 |
|                   2 |              2 |
+---------------------+----------------+
     * third table will have primary id of both 
     * */
	
	//////////////////////////////////////////////////////////
	///one to many mapping   lect 14
	//////////////////////////////////////////////////////////

	
	
//////////////////////////////////////////////////////////
///many to many mapping  &Mapped by lect 15
//////////////////////////////////////////////////////////

	/*there is one other way to represent one to many or many to one 
	object relation apartc from letting hibernate to create seperate table of both id's
	instead we can have user id column in vehcile (object on many side  should have reference to other side)
	
	*
	**as one user can hva emultiple vehicle but vehicle has one user
	*putting vehicle id for user table may repeat user entry rows
	*so put user in vehiclel **
	*hence put user id in vehicle table itself  ??use mapped by in one to many annotation where u will write where u want mapping to happen
	*ie object of user we want??
	*
	*
	*/
	
	ManyToManyUserDetailClass mtmuser = new ManyToManyUserDetailClass(); 
	ManyToManyUserDetailClass mtmuser2= new ManyToManyUserDetailClass();
	
	ManyToManyVehicleListClass mtmvehicle = new ManyToManyVehicleListClass(); 
	ManyToManyVehicleListClass mtmvehicle2 = new ManyToManyVehicleListClass();
	System.out.println("opening many to many");

    session = sessionFactory.openSession();
	
    mtmuser.setUsername("first user");
    mtmuser2.setUsername("second  user");
    
    
    mtmvehicle.setVehicleName("first vehicle");
    mtmvehicle2.setVehicleName("second vehicle");
	//mtmuser.getVehicle().add("sdf");
	session.beginTransaction();
	
	mtmuser.getVehicle().add(mtmvehicle);
	mtmuser2.getVehicle().add(mtmvehicle);
	mtmvehicle2.getUserList().add(mtmuser);
	mtmvehicle.getUserList().add(mtmuser);
	
	session.save(mtmuser);
	session.save(mtmuser2);
	session.save(mtmvehicle);
	session.save(mtmvehicle2);
	session.getTransaction().commit();
	System.out.println("closing many to many");
	session.close();
	//here hibernate does not know it hasto do one mappping so it create two 
	//relation table  so tell hibernate by going to one of the bean class and tell 
	//the other one for ehich it is mapped to ie if in table b we did mapped by object in a,,,then 
	//only r/n table a_b will be created
	
	
	//previously it was a_b and b_a
	
	/*

mysql> select * from a;
+--------+--------------+
| userid | username     |
+--------+--------------+
|      1 | first user   |
|      2 | second  user |
+--------+--------------+
2 rows in set (0.01 sec)

mysql> select * from b;
+-----------+----------------+
| vehicleid | vehicleName    |
+-----------+----------------+
|         1 | first vehicle  |
|         2 | second vehicle |
+-----------+----------------+
2 rows in set (0.00 sec)

mysql> select * from a_b;
+-----------------+-------------------+
| userList_userid | vehicle_vehicleid |
+-----------------+-------------------+
|               1 |                 1 |
|               2 |                 1 |
+-----------------+-------------------+
2 rows in set (0.00 sec)
	
	*/
//////////////////////////////////////////////////////////
///many  to many mapping and mapped by  lect 15
//////////////////////////////////////////////////////////

	
	
	
//////////////////////////////////////////////////////////
///cascading and other things  lect 16
//////////////////////////////////////////////////////////

//in manytoone if there is a vehicle not linked to any user,
	//and in later code we try to get vehicle and assign user but 
	//there is no user for associatiion for it
	
	//then hibernate will throw exception, we can suppres this exception using @NotNull
/*u can say in not found annotation to what to do if user is not found*/
	/*this can be used if we have legacy data and dont want to lose but want to manitain 
	 * relation ship between table use NOTFOUND*/
	
	//------------------------------------------------------------
	/*collection object that hbernate sopports
	>hibernate has intrnal data type to ehich it maps to
	for collection object that your'e creating
	>thre are few semantics for collection that are available in
	hibernate

	1st seamntic is bag semantic-List/ArrayList we can implement bag semantic using list or arraylist

	2nd is bag semantic with id--List/ArrayList
	list and arraylist will have index property

	3rd is List semantic -List/arraylist it is same as bag semantic but is ordered

	4th is set semantic-- having set
	5th is map semantic -having map similar to map datatype of java

	*/
	
	//cascading
	/*if we have 10 vehicle associated with user then will have to do 10 times save of that 
	 * vehcile for that user same has to be done for delete and save*/
	//there is a way to avoid this
	CascadingUserClass cuser= new CascadingUserClass();
	CascadingVehicleClass cvehicle = new CascadingVehicleClass();
	CascadingVehicleClass cvehicle1 = new CascadingVehicleClass();
	System.out.println("opening cascading");
	cuser.setUsername("A");
	cvehicle.setVehiclename("MICRA");
	cvehicle1.setVehiclename("BRIO");
	
	session=sessionFactory.openSession();
	session.beginTransaction();
	
	
	
	//what happen if we save only user where user 
	//only has reltion with bith vehicle ,we are not explicitly saving them
	//it will throw exception saying " object references unsaved transient instances "
	//ie obejct u ares aving is referencing another object
	//which is not saved why hibernate is not automatically sving
	//coz sometimes u donot want to save them co they represent 
	//seperate entites hibernate gives benefit of this doubt
  
	//session.save(cuser); change save to persist whenerve persiste happend cascade need to happen
	//which will do persist this collectio  whne you are persisting this entity
	cuser.getVehicleList().add(cvehicle);
	cuser.getVehicleList().add(cvehicle1);
	
	
	//session.save(cuser);
	session.persist(cuser); //use persist with cascading

//	session.save(cvehicle);
//	session.save(cvehicle1);
	
	
	
	/*use cascade attribute in annotation many to one so that
	 * it will tell if one objec is save then mutltiple object assoociated with it will also be save
	 * 
	 * 
	 * do cascade type dellet during deletion operatiom
	 * do cascade type merger when handling lifecylce of entity objectss*/
	System.out.println("closing cascading");
	//	
	
	
	
	
	session.getTransaction().commit();
	
	session.close();
	//////////////////////////////////////////////////////////
///cascading and other things   lect 16
//////////////////////////////////////////////////////////

	
	//////////////////////////////////////////////////////////
	///implementing inheritence   lect 17
	//////////////////////////////////////////////////////////
	session=sessionFactory.openSession();
//there is no equivalent of inheritence in relational model which is common in object orientation
	//so how??
	//now we will try to extend vehicle class to make two wheeler and four wheeler vehicle class
	
	//why we need inheritence, we can save them seperately tha will worlk,they are seperate entiyty
	/*
	 *               /two wheeler class
	 * vehicl class<
	 *               \  4 wheeler class
	 * 
	 * if there is user class that uses inheritence feature polymorphism
	 * ie it instantiate at run time that what sub class it wants for references, without knowing it 
	 * which class how can we set primary and foreign key in user and subcass of vehicle
	 * userclass will have {id name,vehcile} during initialization
	
	 * */
	
	 VehicleInheritenceClass vehicle = new  VehicleInheritenceClass();
	 TwoWheelerInheritenceClass twowheeler= new TwoWheelerInheritenceClass();
	FourWheelerInheritenceClass fourwheeler= new FourWheelerInheritenceClass();
	 
	//we will explicitly not tell hibernate that we are inheritening, but just used inheritence of java

	vehicle.setVehicleName("Car");
	
	
	twowheeler.setVehicleName("DUCATI");
	twowheeler.setSteeringHandle("BIKE HANDLE");
	twowheeler.setName("SUB TABLE A");
	


	fourwheeler.setVehicleName("PORCHE");
	fourwheeler.setSteeringWheel("CAR STEERING WHEEL");
	fourwheeler.setName("SUB TABLE A");
	
	
	session.beginTransaction();
	
	session.save(twowheeler);
	session.save(fourwheeler);
	session.save(vehicle);
	
	session.getTransaction().commit();
	session.close();
	//it will create same table  insert dtype,id and name and will mappe everything to its own table
	//hibernate implemeted single table strategy, how many sub class u have it will crete common table for all the objects
	//will create DTYPE column whucih is class name inherited
	//DTYOPE is also called discriminator
	//to find what type of object we are savonnig,we have seperate column which tells what class it is
	///DTYPE helps us to tracke at what row wehave our particular object store
	/*without using @Inheritence in parent class also hibernate implement single table starategy
	 * for iother strategy,
	 * 
	 * 
	 * */
	
	//////////////////////////////////////////////////////////
	///implmenting inheritence lect 17 single table
	//////////////////////////////////////////////////////////

	
	
	//////////////////////////////////////////////////////////
///implmenting inheritence lect 17 table per class strategy
//////////////////////////////////////////////////////////

	//we need to isolate each object for which table has to be created
	//ie obj of vehicle,twowheele,fourwheer
	//hence no requirement of Discriminator as seperate table is there we can direclty go that table if we want
	
	session=sessionFactory.openSession();
	
	 VehicleInheritenceTablePerClass vehicleperClass = new  VehicleInheritenceTablePerClass();
	 TwoWheelerInheritenceTablePerClass twowheelerperclass= new TwoWheelerInheritenceTablePerClass();
	 FourWheelerInheritenceClass fourwheelerperclass= new FourWheelerInheritenceClass();
	session.beginTransaction();
	vehicleperClass.setVehicleName("Car");
	
	
	twowheelerperclass.setVehicleName("DUCATI");
	twowheelerperclass.setSteeringHandle("BIKE HANDLE");
	twowheelerperclass.setName("SUB TABLE A");
	


	fourwheelerperclass.setVehicleName("PORCHE");
	fourwheelerperclass.setSteeringWheel("CAR STEERING WHEEL");
	fourwheelerperclass.setName("SUB TABLE A");
	
	
	
	session.save(vehicleperClass);
	session.save(twowheelerperclass);
	session.save(fourwheelerperclass);

	
	session.getTransaction().commit();
	session.close();
	
	/*parent class property are inherited
	 * and form seperate colun
	 * in child table
	 * 
	 * -->parent membe rvariable are formed as seperate column in child tables
	 * -->Generated Value ie id used in parent class wiwll also be used in child class table
	 * (its advantage is that we dont need discriminator to identify what type of object it is)
	 *
	 * 
	 * it is also in normalizaed forom that is do not have extra column*/
	
	
//////////////////////////////////////////////////////////
///implmenting inheritence lect 17 table per class
//////////////////////////////////////////////////////////

	
	
	
//////////////////////////////////////////////////////////
///implmenting inheritence lect 22 JOINED COLUMN
//////////////////////////////////////////////////////////
/*previous ly in table per classs sub class were having column from parent class,making it repeatable
 * this one is more normalized
	
	*
	*
	*
	*
	*
	*/
	session=sessionFactory.openSession();
	
	 VehicleInheritenceJoined vehiclejoined = new  VehicleInheritenceJoined();
	 TwoWheelerInheritenceJoined twowheelerjoined= new TwoWheelerInheritenceJoined();
	 FourWheelerInheritenceJoined fourwheelerjoined= new FourWheelerInheritenceJoined();
	session.beginTransaction();
	
	vehiclejoined.setVehicleName("Car");
	
	
	twowheelerjoined.setVehicleName("DUCATI");
	twowheelerjoined.setSteeringHandle("BIKE HANDLE");
	twowheelerjoined.setName("SUB TABLE A");
	


	fourwheelerjoined.setVehicleName("PORCHE");
	fourwheelerjoined.setSteeringWheel("CAR STEERING WHEEL");
	fourwheelerjoined.setName("SUB TABLE A");
	
	
	
	session.save(vehiclejoined);
	session.save(twowheelerjoined);
	session.save(fourwheelerjoined);

	
	session.getTransaction().commit();
	session.close();
	
/*what will happen is two whheeler name and four wheeler nam ewil also
 * be inserted in vehicle tavke*/
	/*ie
	vehicleid   vehiclename
	1            Car
	2            Bike
	3            Porche
	
	
	two wheeler table will hav e propert y that is pecific to two wheeler
	
	steeringhandle   vehicleid
	Bikesteering     2
	
	
	four wheeler table will hav e propert y that is pecific to four wheeler
	
	steeringhandle   vehicleid
	steering     3
	
	
	
	hence to get complete data  we will use join query
	select * from vehicle join FourWheeler on Vehicle.vehicleId=FourWheeler.VehiclId
	
	
	it is more normalized data from parent table remain in parenty doot goyo child table
	*/
//////////////////////////////////////////////////////////
	///implmenting inheritence lect 22 JOINED COLUMN
//////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////
///implmenting CRUD lect 23
//////////////////////////////////////////////////////////

	
	session=sessionFactory.openSession();
	session.beginTransaction();
	//create
/*	for(int i=0;i<10;i++){
	CrudOperationClass crud = new CrudOperationClass();
	
	crud.setName("USER"+i);
	session.save(crud);
	}
	*/
	//fetch
	
/*CrudOperationClass crud=	(CrudOperationClass)session.get(CrudOperationClass.class, 6);//(classs of object we going to get,primary key)
	System.out.println("user name 6th is"+crud.getName());
	session.getTransaction().commit();
	session.close();
*/

	//delete
	
	//1st pull up object
//	CrudOperationClass crud=	(CrudOperationClass)session.get(CrudOperationClass.class, 6);//(classs of object we going to get,primary key)
//	System.out.println("user name 6th is"+crud.getName());
//	//2nd delete it
//	session.delete(crud);
//	
//	session.getTransaction().commit();
//	session.close();

	
	//update
	
//	CrudOperationClass crud=	(CrudOperationClass)session.get(CrudOperationClass.class, 5);//(classs of object we going to get,primary key)
//	System.out.println("user name 6th is"+crud.getName());
//	crud.setName("updated name");
//	
//	session.update(crud);
//	
//	session.getTransaction().commit();
//	session.close();
	
//////////////////////////////////////////////////////////
///implmenting              CRUD lect 23 
//////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////
///implmenting             24 Transient persitent object
//////////////////////////////////////////////////////////

	TransientPersistenceDetachedUserDetailsClass   transuser= new TransientPersistenceDetachedUserDetailsClass();
	
	transuser.setName("transdemo");
	
	
	session=sessionFactory.openSession();
	session.beginTransaction();
	
	session.save(transuser);
	
	//saving in db is two step process first is to instantiate
	//and then pass it to save method to save it too db
	//so objet initializaeed without makin  it to save is called is transient objetc or object not persisted
	//when it is save it is called persistent and hibernate can track that object
	
	
	//if we try to set user after save
	transuser.setName("user updated");
	//value will reflect change in database
	//hence any change nade after save will go as update statement in database
	//ie last state of object will be reflected in database
	transuser.setName("user updated again");
	//not every change u make triggers an update query
	/*hibernate figure out what is least no of update
	 * that need to be made
	 * whyen u make a save
	 * hibernate watch that object for any changes made
	no matter what change u make hibernate fire update query
	*{before an ovbject is handed over to hobernate it is transient obhect
	*after handling it tto save we are giving hibernate to mtake control 
	*to make objetc state matches database state
	*}
	*/
	

	
	session.getTransaction().commit();
	session.close();
//once we make session close it forms detached object	
	//detached object is like transient object in a sense that hibenrate is not going to track 
	//the changes,changes made will not going to be persisted in database
	//detahced mean it was trackd before and waas persisted by hibernate befores
	
	//transient stae hibernate has not even looked at that objext
//////////////////////////////////////////////////////////
///implmenting              Transient persitent object 24 
//////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////
///implmenting            State changes  25
//////////////////////////////////////////////////////////

	
	//----for create operation
	//4after new() it is transient
	//after session.save() it will be in persistent state
	//after session.close() it will be detached
	
	//------for Read operation
	//session.get() persistence by   default we get it as persistent but can change it to trabsient
	//session.close  detahced
	
	//-------update -can happe  in both of the ways in
	//ie can be done in trad or create operatiom 
	//means we can make changes in persisted dtate any time 
	
	//--------Delete
	//mean ehen we deleye something from dataabse, nothing to save or update hence it goes back to trabsient
	//by saving it again it goes back  to persitent
	
	
	
//////////////////////////////////////////////////////////
///implmenting             state changes24 
//////////////////////////////////////////////////////////

	
//////////////////////////////////////////////////////////
///implmenting           Persisting detached object 25
//////////////////////////////////////////////////////////
	//@org.hibernate.annotations.Entity(selectBeforeUpdate=true:)
	
	
	
	/*if we fetch something from db, then do some user input to it
	 * then again do that DB update we persiste it ti databse*/
	
	/*so showing it to user ,user may take some time to update
	 * so iit will take time to get persisted
	 * dont know how longneed it will take to wait for update to make*/
	//it is not good idea to have all get and update in same transaction
	
	//so we can make one session and get the object ,
	//then open another session when update is don e by user and persist it to datatbsse
	
	//so there is problem in this apprioach when we gett the databse value and and close 1st session to open another for 
	//update it will get detached,
	//so how can we move this object from detahced to persistent state
	
	session=sessionFactory.openSession();
	session.beginTransaction();
	
	
	TransientPersistenceDetachedUserDetailsClass trans =(TransientPersistenceDetachedUserDetailsClass)session.get(TransientPersistenceDetachedUserDetailsClass.class, 1);
	//now trans object can be used to render the view
	
	session.getTransaction().commit();
	session.close();
	
	///////////////////////
	//here we will have updated value
	//so
	//trans.setName("updating after session close");
	//it will not update in databse as it is doen after session close
	//hibernate has figured out what row to update after sessionsave
	
	
	
	//there must be a method by whic we can make object persistent again
	
	session= sessionFactory.openSession();
	session.beginTransaction();
	//trans.setName("after update");
	session.update(trans);
	
	//if we do set after update
	
	
	session.getTransaction().commit();
	session.close();

	
	
	//if we do not set anything between both transaction and run still it will update 4
//	coz hibernte not know about changes
	//henche in entitty class use another annotation
	//@org.hibernate.annotations.Entity(selectBeforeUpdate=true:)
	//on doing this entiyy attache itself to persistent state
	//it will runn select and get current state of data
	//when it will see state is same it will not going to fire update quesry
	//////////////////////////////////////////////////////////
	///implmenting           Persisting detached object 25 
	//////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////
	///implmenting          selct and pagination in hibernateobject 25 
	//////////////////////////////////////////////////////////

	
	session=sessionFactory.openSession();
	session.beginTransaction();
	Query query=session.createQuery("from TransientPersistenceDetachedUserDetailsClass ");/*where id > 2*/
	query.setFirstResult(3);
	
	//this will make sure ex we make select* and have 10 recrods, it will go five result below the that willl be the first result
	//use query .setfirst result to get start of my results we are interested in
	List<TransientPersistenceDetachedUserDetailsClass> name=(List<TransientPersistenceDetachedUserDetailsClass>) query.list();
	session.getTransaction().commit();
	//hibernate uses pagination by configuring object
	session.close();
	for(TransientPersistenceDetachedUserDetailsClass u: name)
	{
	System.out.println(u.getName());	
		
	}
	
	
	//////////////////////////////////////////////////////////
	///implmenting       selct and pagination in hibernateobject 25
	//////////////////////////////////////////////////////////

		
	
	 
	}
}
