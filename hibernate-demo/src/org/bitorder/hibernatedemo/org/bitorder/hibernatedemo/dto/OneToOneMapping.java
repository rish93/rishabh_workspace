package org.bitorder.hibernatedemo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="OneToOne")
public class OneToOneMapping {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	
	//we could have embedded and embeddable to make vehicp;e column come isnide 
	//this entity but here vehicle is seperate entity needing seperate table
	//after adding annotation associate vehicle with its other class
	
	@JoinColumn(name="JoinedName")
	@OneToOne
	private OneToOneVehicle ot;
	

	public OneToOneVehicle getOt() {
		return ot;
	}
	public void setOt(OneToOneVehicle ot) {
		this.ot = ot;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
