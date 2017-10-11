package com.spring;

import org.springframework.beans.factory.annotation.Required;

public class RequiredAnnotation {

	private String message;

	public String getMessage() {
		return message;
	}
	@Required
	public void setMessage(String message) {
		this.message = message;
	}
}
