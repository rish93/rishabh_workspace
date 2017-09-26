package com.spring;

import java.util.List;

public class CollectionBean {

	private List<ObjectInjectionProvider> names;

	public List<ObjectInjectionProvider> getNames() {
	System.out.println("inside collction getter bean");
		return names;
	}

	public void setNames(List<ObjectInjectionProvider> names) {
	
		
		//this.names.set(0, names.get(0));
		this.names = names;
	}
	
}
