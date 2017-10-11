package org.bitorder.hibernatedemo.dto;

import javax.persistence.Entity;



@Entity
public class TwoWheelerInheritenceJoined extends VehicleInheritenceJoined{

	
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String SteeringHandle;

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}

}
