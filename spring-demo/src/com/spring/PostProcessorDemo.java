package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class PostProcessorDemo implements BeanPostProcessor {

	
	//there are the callbacks method called by spring when beans
	//are initialized
	//after intializing any bean this method is called after dependency injection
//it return object back to spring,spring expect returned object to cntinue its configuration
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("in after initalization BEAN NAME IS"+beanName);

		//we can make changes to bean object if want
		
		return bean;
	}

	
	//object(bean object itself) and name of the bean is passed
	//before intializing any bean this method is called
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		System.out.println("in before initalization BEAN NAME IS"+beanName);
		// TODO Auto-generated method stub
		return bean;
	}

}
