package com.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class AutowiredAnnotation {
	private String message;

	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}
}
