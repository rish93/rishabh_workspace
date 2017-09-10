package org.bitorder.hibernatedemo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OTM_VehicleClass")
public class OneToManyVehicle {

	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleid;
	
	private String name;
	
	
	//creating reverse relation ship(every vehickel has owner where vehicle points to owner)
	@ManyToOne
	@JoinColumn(name="USER_ID")//instead of creating new table column will be created inside vehicle table
	private OneToManyMapping user;
	//by reverse r/n whether we have user or vehicleobject we cn get 
	//other object easily with corresponding getter
	
	public OneToManyMapping getUser() {
		return user;
	}

	public void setUser(OneToManyMapping user) {
		this.user = user;
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
