package org.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

	public static void main(String []args)
	{
		
		//hashmap 
		HashMap <Integer,String>map = new HashMap<Integer,String>();//can also have custom  key
		map.put(5, "FIVE");//java will convert this primitive type tto non primitive type
		map.put(6, "SIX");
		map.put(7, "SEVEN");
		map.put(8, "EIGHT");
		map.put(8, "HELLO");
		
      String text=map.get(8);
		//can also addd duplicate key that wil override previous key
   
      //if key entered that doesnt exist will retun null
		System.out.println(text);
		//for the same key new value will override previous
	
	
	//to iterate over all the keys using for each
		for(Map.Entry<Integer, String> entry:map.entrySet())
		{
			int key=entry.getKey();
			String value= entry.getValue();
			System.out.println("key :"+key + " value :"+value);
			
		}	
	}
	//about hash map it is not sorted in any way
	//we might not  get the same ordered out put for multiple run
	//it randomly chenges order
}
