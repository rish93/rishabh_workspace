package org.bitorder.hibernatedemo.dto;

import javax.persistence.Entity;


@Entity
public class FourWheelerInheritenceJoined extends VehicleInheritenceJoined{

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String SteeringWheel;

	public String getSteeringWheel() {
		return SteeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		SteeringWheel = steeringWheel;
	}
	

}
