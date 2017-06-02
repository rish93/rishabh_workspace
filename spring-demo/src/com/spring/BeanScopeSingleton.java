package com.spring;

public class BeanScopeSingleton {

	public void getMessage() {
		  System.out.println(": " + message  +" :");
	}

	public void setMessage(String message) {
		this.message = message;
	}

	String message;
	
	
}
