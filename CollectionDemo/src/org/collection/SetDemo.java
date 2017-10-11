package org.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class SetDemo {
//set is a kind of collection that stores only unique element
	public static void main(String []args)
	{
				
		
		
		//defining variable of Setinterface type
		Set<String> set1 = new HashSet<String>();//set is interface hashset is class
		if(set1.isEmpty())
		{
			System.out.println("set1 is empty at beginning");
		}

		System.out.println("***//hash set doesnt maintain order in which it is entered");
		set1.add("RISHABH");
		set1.add("PRATEEK");
		set1.add("PIYUSH");
		set1.add("PRANAV");
		set1.add("DHAWAL");
		set1.add("RITVIK");
		//adding duplicate item will not effect
        set1.add("RISHABH");
		System.out.println(set1);
		
		//to maintain order use linked hash set
Set<String> set2 = new LinkedHashSet<String>();//set is interface hashset is class
		
		System.out.println("***//linked hash set maintain order in which it is entered");
		set2.add("RISHABH");//it is like doubly linked list running through your items 
		set2.add("PRATEEK");//hence maintaining order
		set2.add("PIYUSH");
		set2.add("PRANAV");
		set2.add("DHAWAL");
		set2.add("RITVIK");
		//adding duplicate item will not effect
        set1.add("RISHABH");
		System.out.println(set2);
		
		
		
Set<String> set3 = new TreeSet<String>();//set is interface hashset is class
		
		System.out.println("***//tree set maintain natural order in which it is entered");
		set3.add("RISHABH");//it is like doubly linked list running through your items 
		set3.add("PRATEEK");//hence maintaining order
		set3.add("PIYUSH");
		set3.add("PRANAV");
		set3.add("DHAWAL");
		set3.add("RITVIK");
		//adding duplicate item will not effect
        set1.add("RISHABH");
		System.out.println(set3);
	
	
	
	
		//iteration on set
		for(String element:set1)
		{
			System.out.println(element+"from set1");
		}
		
	
	//////to find set contain any item
	if(set1.contains("RISHABH"))
	{System.out.println("contains rishabh");}
	
	
	//to find if it is empty
	if(!set1.isEmpty())
	{
		System.out.println("set1 is not empty");
	}
	
	
	//intersection in set
	//first create a copy of set then compare
	
	Set<String> set4= new LinkedHashSet<String>();
	set4.add("RISHABH");
	set4.add("BOT");
	set4.add("FPSS");
	
	Set<String > intersectionSet= new HashSet<String>(set1);
	
	System.out.println("*****"+intersectionSet);
	System.out.println("*****"+set4);
	intersectionSet.retainAll(set4);//it will get common element in both set
	System.out.println(intersectionSet);
	////////////////intersection//////////////////////////
	
	
	
	
	////differences////////////////
	//to find element in set 1 but not in set2
	
	Set<String >difference = new HashSet<String >(set1);
	
	difference.removeAll(set4);//get element not in set4
	System.out.println(difference);
	
	}
	
	
}
