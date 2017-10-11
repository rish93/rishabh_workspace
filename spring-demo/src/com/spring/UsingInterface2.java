package com.spring;

public class UsingInterface2 implements CodingToInterfaceDemo{

private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		System.out.println("CODING TO INTERFACE  22222222"+message);
		return message;
	}
}
