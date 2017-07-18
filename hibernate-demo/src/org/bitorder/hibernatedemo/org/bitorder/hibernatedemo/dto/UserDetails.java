package org.bitorder.hibernatedemo.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
//model cLASS dto//can have as many model class by using Entity and id it amodel class
/*have another class taht instantiate model class and will pass it to hibernate to save it
 * here main class */


@Entity (name="USER_DETAIL") 
/*An Entity is roughly the same thing as an instance of a class
 *  when you are thinking from a code perspective or a row in a
 *   table (basically) when you are thinking from a database
 *    perspective.
So, it's essentially a persisted / persistable instance
 of a class. Changing values on it works just like
  changing values on any other class instance.
   The difference is that you can persist those 
   changes and, in general, the current state of the class
    instance (entity) will overwrite the values the row
     for that instance (entity) had in the database, based on
      the primary key in the database matching the "id" or 
      similar
 field in the class instance (entity).*/


//name attribute will not make table from clss 
//name instead will consider attribute name specified
//treat this class as entity need to save this , in xml name class is also give in then y need here coz there are other ways these object can be annotatesd without having to be entity
//hibernate look at those classes where entity or annotation belongs


//now have a class that nstantiate these objects

@Table(name="userdetails")//name for entity is name of entire entity while table name is name of table under that entity
//entity name would be default class name when not set
public class UserDetails {
//if class naem would have been user hibernate would crete table
//with user but in some db user is restricted keyword so hibernate would not allow


	@Lob    //large object whcih will escape varchar limitiation of 255 character
	private String description;
	
	
	//member variable
	
	// can also put annotation above getter 
	@Column(name="USER_ID")
	private int userId;
    
	//to override column naem or change the default anme on top of field mention @column
	@Column(name="USER_NAME")
	private String username;
	 
	//@Basic(fetch)  /*basic also used for fetch attribute Using optional = false however also allows for Hibernate (and I suppose other implementations) to perform a check and throw an exception prior to flushing to the database if the non-optional field is null. Without this you would only get
	          /*an Exception thrown after the attempt to insert*/
	 //if want a column nt to be persisted mark column as transient or staticCox statci will be commomn across classes and make no sense to be saved
	@Transient
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(Address adrs) {
		this.address = adrs;
	}
	
	//if we have propeerty in our class and dont want to save it
	  //will not be save or could have made it static
	
	@Temporal(TemporalType.DATE)//if u want to save only date use enumeration withing annotation
	private Date date;//data type is alutomaticalyy adjusted in database but we can set it manualy also
	 
	    public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	//to make primary key//treat value of this field as primary key
	@Id  @GeneratedValue(strategy=GenerationType.AUTO)//auto mean we will let hibernate make decision whtat strategy to use give value generated
	/*Identity mean hi/*bernsate will use identitybcolumn(feature provided in some d/b)
	//crreated a column and made it primay key 
	 * 
	 * *sequence -use to maintain sequesnce in d/b
	 * table option  create seperate table will maintain last used  primary key so that u can increment it and get next value
	 * AUTO IS RCOMENDED OPTION that depend on specific DATABASE
	 * */
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username +"from getter";
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	/////////////////////////////////////////////
	/*create a member variabe for address
	*/
	
	
	@Embedded  //not manadatory but can be sue d to clue hibernate this memebr variable shlf not have seperate table
	
	private Address adress;

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	
	
	
	
}




/*hibernate takes some defaults like class name as  table name
 * using nae attribbute in entity 
 * 
 * we can also put annotation on top of getter*/
 