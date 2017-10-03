package org.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;



public class SortedMap {

	public static void main(String []args){

		//we can also create , using interface ie MAP<> m= new HASHMAP<>(), no we only care about impplementation not about functionality
	HashMap<Integer,String> hashmap= new HashMap<Integer,String>();
	
	LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<Integer,String>();//same as hash map but it will maintain the order in which it is inserted
	TreeMap<Integer, String> treeMap= new TreeMap<Integer,String>();//tree sorts the value in natural order,
	//natural for number  from 1, while for character from 'a'
	
	System.out.println("------------HASH MAP DOESNT MAINTAIN ORDER-----------------");
	testMap(hashmap);//donot rely on hash map, sometime it may come out in unexpected order
	System.out.println("----------LINKED HASH MAP MAINTAIN ORDER ORDER IT IS ENTERED-------------------");
	testMap(linkedHashMap);
	System.out.println("----------TREE MAP MAINTAINS  ORDER BASED ON KEY (NATURAL ORDER)-------------------");
	testMap(treeMap);
	System.out.println("-----------------------------");
	}
	public static void testMap(Map<Integer,String> map)
	{
		
		
		map.put(9,"RISHABH");
		map.put(2,"PRATEEK");
		map.put(1, "PIYUSH");
		map.put(6, "PRANAV");

		//we can iterate using entityset method like done before
		//or can use for each loop
		
		for(Integer key:map.keySet())//here we are getting key set(we can get value set,entryset or key set)
		{
		String value=	map.get(key);
			System.out.println(value+"  :value");
		}
		
	}
	
	
	
}
