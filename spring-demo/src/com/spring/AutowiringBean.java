package com.spring;

public class AutowiringBean {

	private autowiringData autoVal1;//same name as bean id for whic autowiring is done

	
	public autowiringData getAutoVal1() {
		return autoVal1;
	}

	public void setAutoVal1(autowiringData autoVal1) {
		this.autoVal1 = autoVal1;
	}

		
	
}
