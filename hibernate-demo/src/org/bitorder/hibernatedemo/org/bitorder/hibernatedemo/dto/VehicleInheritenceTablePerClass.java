package org.bitorder.hibernatedemo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


	
	@Entity
	@Table(name="VEHICLETABLEPERCLASS")
	@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
	public class VehicleInheritenceTablePerClass {
	
		@Id@GeneratedValue(strategy=GenerationType.TABLE)
		private int id;
		
		private String vehicleName;

		public String getVehicleName() {
			return vehicleName;
		}

		public void setVehicleName(String vehicleName) {
			this.vehicleName = vehicleName;
		}

		
	}
