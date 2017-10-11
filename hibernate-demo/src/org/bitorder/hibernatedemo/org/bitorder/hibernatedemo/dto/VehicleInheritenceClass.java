package org.bitorder.hibernatedemo.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="Vehicle")

/*we can also set DTYPE column name using annotatiion @DiscriminatorColumn*/
@DiscriminatorColumn(
	name="VEHICLE_TYPE",
	discriminatorType=DiscriminatorType.STRING//we can have character,no,string
	)
public class VehicleInheritenceClass {

	@Id@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String vehicleName;

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
	
}
