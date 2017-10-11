package org.bitorder.hibernatedemo.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="cascadinguser")
public class CascadingUserClass {

	/**
	 * 
	 */
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Collection<CascadingVehicleClass> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(Collection<CascadingVehicleClass> vehicleList) {
		this.vehicleList = vehicleList;
	}

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany(cascade=CascadeType.PERSIST)
	private Collection<CascadingVehicleClass> vehicleList = new ArrayList();
}
