package com.spring;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent{

	public CustomEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
//will override toString so that custom msg can be passed
public String toString()
{
	
	return "CUSTOM MSG FROM EVENT";
	}












}
