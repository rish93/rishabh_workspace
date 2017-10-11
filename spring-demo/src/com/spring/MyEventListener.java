package com.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;



//defining bean like in bean xml
@Component
public class MyEventListener implements ApplicationListener{

	
	//this method is called by spring when any application event is published taking event object
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		
		System.out.println(event.toString());
		
	//it will print context refreshed event and that event is published by spring which this bean has listened and executed	
	}

}
