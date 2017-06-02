package com.spring;

public class BeanScopePrototype {
public void getMessage() {
	System.out.println(":"+message+":");	
	//return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

private String message;
}
