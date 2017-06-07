package com.spring;

public class BeanConstructorOverloading {

	private String msg;
private String  stringVal;
private int integerVal;	
public BeanConstructorOverloading(String msg)
	{
		this.msg=msg;
		System.out.println(" valued constructor"+msg);
	}
	
	public BeanConstructorOverloading(int integerVal)
	{
	
	this.integerVal=integerVal;
		System.out.println(" valued constructor"+integerVal);
	}
	public String toString() {
        return this.msg + "," + this.integerVal;
    }
	public BeanConstructorOverloading(String stringVal,int integerVal)
	{
		this.stringVal=stringVal;
		this.integerVal=integerVal;
	System.out.println(stringVal+"string value from constructor is"+stringVal);
	System.out.println(integerVal+"integer value from constructor is "+integerVal);
	
	
	}
	
	public String getMsg() {
		return stringVal+ msg + integerVal;
	}
//
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}
//	
	
	
}
