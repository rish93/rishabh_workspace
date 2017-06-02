package org.bitorder.hibernatedemo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//model cLASS
@Entity  //name attribute will not make table from clss name instead will consider attribute name specified

@Table(name="userdetails")
public class UserDetails {
	//member variable
	
	// can also put annotation above getter 
	private int userId;

	private String username;
	@Id
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
