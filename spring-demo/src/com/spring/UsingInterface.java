package com.spring;

public class UsingInterface implements CodingToInterfaceDemo {

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType()
	{
		System.out.println("CODING TO INTERFACE 111111111"+message);
	return message;
	}
	
}
