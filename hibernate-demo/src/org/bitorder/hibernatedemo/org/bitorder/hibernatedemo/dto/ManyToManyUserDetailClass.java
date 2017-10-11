package org.bitorder.hibernatedemo.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name="A")
public class ManyToManyUserDetailClass {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	private String username;
	
	@ManyToMany
	 private Collection<ManyToManyVehicleListClass> vehicle= new ArrayList/*<ManyToManyVehicleListClass>*/();

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@ManyToMany
	public Collection<ManyToManyVehicleListClass> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<ManyToManyVehicleListClass> vehicle) {
		this.vehicle = vehicle;
	}
	
}
