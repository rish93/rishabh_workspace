package org.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*Comparable

A comparable object is capable of comparing itself with another object. The class itself must implements
 the java.lang.Comparable interface in order to be able to compare its instances.*/


/*
 * Comparator

A comparator object is capable of comparing two different objects. The class is not comparing its instances, but some 
other class’s instances. This comparator class must implement the java.util.Comparator interface.*/

  class person2 implements Comparable<person2> {//to verify natural order we declare another class
	  //having implemented comparable interface
	private static String name;
	
	public person2(String name){
	this.name=name;
	}
//we also need to set hashcode and equals for unique object return 
	//hashcode will return an id thats diffferent if names are different
	//in this case
	
//equals will return true only if names are equal in this cases
	
	
	@Override
	public int compareTo(person2 p) {
		// TODO Auto-generated method stub
		
		//return +1 if object is greater than person 2object p2
	//else -1
	//if equals return 0
		
		/*for ascending*/
		//return name.compareTo(person2.name);//can access person coz it is private
		//and in the same class we are accessing it
		
		/*for based on length*/
		
		int len1= name.length();
		int len2= person2.name.length();
		if(len1>len2)
		{
			return 1;
		}
		else if(len1<len2)//but if their is conflict b/w the notion equality in a tree set
			//(name of the same length will be mssing while sorting based on length)
			//coz compare to will return  0 for same length and equal will return true  for equal and tree set will keep only one output thinking it is repeatable
			//hence one is missing
		{
			return -1;
		}
		
		
		return name.compareTo(person2.name);
		
		//else return 0;
		//return 0;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		person2 other = (person2) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
  }



//to verify if we put customize object how sort will worl
 class NaturalOrderingComparableInterface {
//natural order for arraylist,tree set, treemap and we can also define natural order of our own classes
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		List<String> list = new ArrayList<String>();
		
		//Set<String> set = new TreeSet<>();//it store in natural orders
        //we can also use SortedSet
		SortedSet<String> set = new TreeSet<String>();//it store in natural orders

	
		/*if made afunction add element but didnt know what type of 
		 * collection it accept as paarameter,
		 * we can use vaariable of collection type which is super type interace
		 * for all interfaces
		 */
List<person2> listpers= new ArrayList<person2>();
	addElementsPerson(listpers);
	addElements(list);
	addElements(set);

	
	//addaddElementsPerson(listpers);
	//it will sj=how compile time error od addaddElementsPerson(List<person2>) is undefined for the type NaturalOrderingComparableInterface
	//also when collection.sort is used coz it doesnt have define natural ordering
	
	
	//set will maintain natural order coz treeset is used, list can folllow order by using
	Collections.sort(list);
	
	showElements(list);
	System.out.println("--------------------------");
	showElements(set);
showElementsPers(listpers);
	
	
	}
	
	private static void addElementsPerson(Collection<person2> col)
	{
		col.add(new person2("joe"));
		col.add(new person2("chandler"));
		col.add(new person2("walter"));
		col.add(new person2("jane"));
		col.add(new person2("jesse"));
	
		
	}
	
	
	private static void addElements(Collection<String> col)
	{
		col.add("joe");
		col.add("jesse");
		col.add("chandler");
		col.add("walter");
		col.add("skyler");
		col.add("jane");
		col.add("tyrion");
		
	}
	
	public static void showElements(Collection<String> col)
	{
		for(String s:col)
		{
			System.out.println(s);
		}
	}
	
	
	public static void showElementsPers(Collection<person2> col)
	{
			System.out.println("=======================================");
			for(person2 s:col)
			{
				System.out.println(s);
			}
	}
}
