package org.bitorder.hibernatedemo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



	@Entity
	@Table(name="FOURWHEELERTABLEPERCLASS")
	public class FourWheelerInheritenceTablePerClass extends VehicleInheritenceTablePerClass{
	
//		@Id@GeneratedValue(strategy=GenerationType.AUTO)
//		private int id;
//		
		
		private String name;
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	private	String SteeringWheel;

	public String getSteeringWheel() {
		return SteeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		SteeringWheel = steeringWheel;
	}
		
		
		
	}
