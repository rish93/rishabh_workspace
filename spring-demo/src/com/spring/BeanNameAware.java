package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanNameAware implements ApplicationContextAware
{
private ApplicationContext context= null;
	
	
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		// TODO Auto-generated method stub
		
		this.context=context;
		
		
		System.out.println(context+"application CONTEXT AWARE");
	}

}
