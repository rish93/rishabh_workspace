package org.bitorder.hibernatedemo.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="OTM_MappingClass")
public class OneToManyMapping {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	/*@JoinTable(name="USER_VEHICLE",joinColumns=@JoinColumn(name="USER_ID"),
	inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))//inverse join column overrides other id that is getting embedded in table
*/
	@OneToMany(mappedBy="user")//where u want tomapping to happen in another table as seperate column
    private Collection <OneToManyVehicle>	otom = new ArrayList<OneToManyVehicle>();  //initialize as arraly list so that value is nnot null
    //on first addition	
	private String LectNameOnetomany;
	

	public String getLectNameOnetomany() {
		return LectNameOnetomany;
	}

	public void setLectNameOnetomany(String lectNameOnetomany) {
		LectNameOnetomany = lectNameOnetomany;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<OneToManyVehicle> getOtom() {
		return otom;
	}

	public void setOtom(Collection<OneToManyVehicle> otom) {
		this.otom = otom;
	}

//	public Collection<OneToManyVehicle> getOtom() {
//		return otom;
//	}
//
//	public void setOtom(Collection<OneToManyVehicle> otom) {
//		this.otom = otom;
//	}

}
