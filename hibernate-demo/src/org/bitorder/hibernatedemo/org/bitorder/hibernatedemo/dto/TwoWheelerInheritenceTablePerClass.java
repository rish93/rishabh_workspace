package org.bitorder.hibernatedemo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	
	@Entity
	@Table(name="TWOWHEELERTABLEPERCLASS")
	public class TwoWheelerInheritenceTablePerClass  extends VehicleInheritenceTablePerClass{
	
//		@Id@GeneratedValue(strategy=GenerationType.AUTO)
//		private int id;
//		
//		
//		private String vehicleName;
//		public String getVehicleName() {
//			return vehicleName;
//		}
//
//		public void setVehicleName(String vehicleName) {
//			this.vehicleName = vehicleName;
//		}

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
