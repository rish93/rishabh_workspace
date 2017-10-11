package org.bitorder.hibernatedemo.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@Entity
//two change discriminatore content make changes in chlld cllass
@DiscriminatorValue("2wheeler")
public class TwoWheelerInheritenceClass extends VehicleInheritenceClass{

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
