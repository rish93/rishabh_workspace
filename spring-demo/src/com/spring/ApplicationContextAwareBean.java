package com.spring;

import javax.naming.Context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextAwareBean implements ApplicationContextAware,BeanNameAware {

//	private ApplicationContextAwareBean pobj;
//	public ApplicationContextAwareBean getPobj() {
//		return pobj;
//	}
//
//	public void setPobj(ApplicationContextAwareBean pobj) {
//		this.pobj = pobj;
//	}

	private ApplicationContext context =null;//member variable
	
	
	private ApplicationContexAwaretData pp;
	
	
	public ApplicationContexAwaretData getPp() {
		return pp;
	}

	public void setPp(ApplicationContexAwaretData pp) {
		this.pp = pp;
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		// TODO Auto-generated method stub
		this.context=context;
//		pobj=	(ApplicationContextAwareBean)context.getBean("contextaware");
	//	System.out.print( pobj.getPobj());
	System.out.println(context.getDisplayName()+"hiii");
	}

	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		System.out.println("bean name is "+beanName);
	}

	
	
	
}
//ApplicationContextAware 
/* give information of container to the bean
oveerridr the setter method and 



*/