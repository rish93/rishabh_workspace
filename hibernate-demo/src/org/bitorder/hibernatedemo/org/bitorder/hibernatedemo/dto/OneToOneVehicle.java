package org.bitorder.hibernatedemo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//model class
import javax.persistence.Id;


@Entity
public class OneToOneVehicle {

	
	
	@Id @GeneratedValue/*(strategy=GenerationType.AUTO)*/
	private int vehicleId;
	private String vehiclename;
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehiclename() {
		return vehiclename;
	}
	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}
	
	
	
}
