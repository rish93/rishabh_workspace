package com.spring;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AbstractApplicationContextBean implements InitializingBean,DisposableBean
{
private String name;
//implement interface to make bean know when it is initialized or destroyed
//after implementing method of the bean needs to be called
//when bean is been initialized//InitializeBean is marker to know method of bean needs to be initialized
//when bean is initialized
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public void afterPropertiesSet() throws Exception// it will get executed when bean finishes initilization
{
	//write code u want to perform after property ser
	System.out.println("property set");

}
//before actualy destroying the bean it wil call destroy method of that bean when disposablebean intrface is implementred

@Override
public void destroy() throws Exception {
	// TODO Auto-generated method stub
	System.out.println("destroyedt");

}
  //ALTERNATE TO AFTERPROPERTYSET AND DESTROY
//by using these interface we are tying it to spring instead what we can do

//write method and make them to run during init and destroy
public void myInit()//this method is registered as initialization method in springXML
{//uing init-method attribute in bean tag
	System.out.println("property set from INIT");

}
public void cleanUp()//this method is registered as initialization method in springXML
{//uing init-method attribute in bean tag
	System.out.println("cleanup from CLEANUP ");

}




}

