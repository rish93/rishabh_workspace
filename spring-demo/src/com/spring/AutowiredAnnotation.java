package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

public class AutowiredAnnotation implements ApplicationEventPublisherAware {
	private String message;
	//will autowire by type
	@Autowired//there is one bean of type resurcebundle msg source and one bean member variable of type msg source so do dependency injection using @Autowired
	private MessageSource messagesource;//make getter setter sio that instance of message source bean to be available here

	
	//create a member variable applicationEVENT PUblisher  to publish custom event
	private ApplicationEventPublisher publisher;
	
	public MessageSource getMessagesource() {
		return messagesource;
	}

	public void setMessagesource(MessageSource messagesource) {
		this.messagesource = messagesource;
	}

	public String getMessage() {
		System.out.println("MESSAGE FROM PROPERTY"+this.messagesource.getMessage("greeting",null,"default msg2 FROM PROPERTY FIILE",null));
		
		//we can also pass dynamic value to property message efile
		System.out.println(this.messagesource.getMessage("dynamic",new Object[]{message,message},"default msg",null));
		
		//creating event object
		CustomEvent customEve= new CustomEvent(this);
		//publish this event to publisher to publish it
		publisher.publishEvent(customEve);
		//publish event is also part of application context but we preferec=d calling through interface as best practise
		
		
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}

	
	
	//to get the handler on the publisher object implements Application EVENt publisher
	@Override
	public void setApplicationEventPublisher(
			ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		this.publisher=publisher;
	}
}
