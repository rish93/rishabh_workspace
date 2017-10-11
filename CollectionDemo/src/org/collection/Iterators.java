package org.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Iterators {
	public static void main(String []args)
	{
		List<String> codingterms= new LinkedList<String>();
		codingterms.add("Enum");
		codingterms.add("Arrays");
		codingterms.add("Block");
		codingterms.add("Class");
		codingterms.add("Deserialization");
		
		
		//post java 5 itration  got introduced
		//iterator is actually a template type so if place it.next in string it will not convert object type to string
		//so we gave to mention type of iterator for it
	Iterator<String> it=	codingterms.iterator(); //this will return object of type iterator
		//since list implement lot of collection interace in general,
	//implement the iterable interface
	String st=it.next();  //1st value
	System.out.println("@ "+st);
/*before next() is called it is pointing to before the first value in list
 * calling list two times will lead to second value */
	while(it.hasNext())
	{System.out.println("-------------------");
		System.out.println(it.next());//will start from second value in list
	}
	System.out.println("-------------------");
	
	Iterator it1=codingterms.iterator();
	//we can also remove items using iterator
	while(it1.hasNext())//for(;it.hasNext();)
	{
		if(it1.next().equals("Deserialization"))
//		{System.out.println("--"+it1.next());
			it1.remove();
			
//		}
	}
	//if we try to remove element in foreach loop using list name .remove 
	//method we will get concurent modification exception
		
	/////////////////////////////////////////////////////////
	//if we try to remove add item while iterating, instead of using iteratoor
	//use list iterator
	
	
	
	
	
	
	
	
	
	
	
	for (String s:codingterms)
		{
		//codingterms.remove(2);rate and remove at same time from list 
		//use iterator instead
			System.out.println(s);
		}
	
	}
	
}
