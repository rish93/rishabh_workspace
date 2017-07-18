package org.bitorder.hibernatedemo.dto;

import javax.persistence.Embeddable;

///to tell hibernate not to create seperate table of it but instead it is value type object associated to some entity type use 
//annotation embedded

@Embeddable
public class Address {

	
	private String street;
	private String city;
	private String pincode;
	private String state;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
}
