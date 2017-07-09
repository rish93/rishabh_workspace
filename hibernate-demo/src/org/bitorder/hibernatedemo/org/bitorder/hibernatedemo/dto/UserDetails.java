package org.bitorder.hibernatedemo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//model cLASS dto//can have as many model class by using Entity and id it amodel class
/*have another class taht instantiate model class and will pass it to hibernate to save it
 * here main class */


@Entity  
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

@Table(name="userdetails")
public class UserDetails {
	//member variable
	
	// can also put annotation above getter 
	private int userId;

	private String username;
	@Id        //to make primary key//treat value of this field as primary key
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
	
}
