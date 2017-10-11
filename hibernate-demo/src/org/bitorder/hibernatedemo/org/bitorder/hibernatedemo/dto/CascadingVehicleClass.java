package org.bitorder.hibernatedemo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="cascadingvehicle")
public class CascadingVehicleClass {

	
	private String vehiclename;

	public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	
	
	//private  CascadingUserClass user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public CascadingUserClass getUser() {
//		return user;
//	}
//
//	public void setUser(CascadingUserClass user) {
//		this.user = user;
//	}
	
}
