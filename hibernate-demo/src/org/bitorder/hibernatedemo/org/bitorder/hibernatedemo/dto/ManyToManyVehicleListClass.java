package org.bitorder.hibernatedemo.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="B")
public class ManyToManyVehicleListClass {

	@Id @GeneratedValue
	private int vehicleid;
	private String vehicleName;
	
	@ManyToMany(mappedBy="vehicle")
	private Collection<ManyToManyUserDetailClass> userList = new ArrayList();

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public Collection<ManyToManyUserDetailClass> getUserList() {
		return userList;
	}

	public void setUserList(Collection<ManyToManyUserDetailClass> userList) {
		this.userList = userList;
	}

	
	
	
	
	
	
}
