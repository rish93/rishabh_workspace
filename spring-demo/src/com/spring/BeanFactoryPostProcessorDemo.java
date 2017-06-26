package com.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPostProcessorDemo implements BeanFactoryPostProcessor{

	//sequesnce in which spring calls is
	//first beanfactroy post processor>bean factory> init bean
	private String valueFromProperty;
	
	public String getValueFromProperty() {
		return valueFromProperty;
	}

	public void setValueFromProperty(String valueFromProperty) {
		this.valueFromProperty = valueFromProperty;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanfactory)
			throws BeansException {
		// TODO Auto-generated method stub
		//it will be executed before the bean factory is initialized
		//to plugin some extrac functionality to override default feature of beanfactory use this function
				//to override some of the default functionality when bean factory is initializaed 
		System.out.println("my bean factory "+beanfactory);
		System.out.println("this method can be used to change some configuration before bean factory initialization");

		
		
		
		System.out.println("example of bean factory post processor is property place holder configurer");
		//if we want to have some placeholder for the configuration in xml 
		/*
		 * ie. we can have property file having actual value 
		 * and instead of bean having property it will have placeholder referring to 
		 * property file
		 * 
		 * */
		
		
	}

}
