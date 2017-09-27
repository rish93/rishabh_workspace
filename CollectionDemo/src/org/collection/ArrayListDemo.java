package org.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	//array list implements a concept of  array that is expandable
	
	
		public static void main(String[] args)
			{
			//after specifying class of collection to be 
			//used specify type of data u want to store
			
			
			ArrayList<Integer>	no= new ArrayList<Integer>();//we can only declare non primitive type for the data value t be stored
			no.add(10);
			no.add(100);
			no.add(500);
			
			//retrieving
			System.out.println(" 1st "+no.get(0)+" 2nd "+no.get(1)+" 3rd "+no.get(2));
			
				//index loop iterator
				for(int i=0;i<no.size();i++)
				{
					System.out.println(" Array list value looping "+no.get(i));
             	}
		
			
			//using for each loop
				for(Integer value:no)
				{
					System.out.println(" Array list for each "+value);
             	}
	
				
				///removing
				
				//removing from back is fast 
				no.remove(no.size()-1);
				
				
				//removing from front is slow,coz it if 1st item is removed 
				//all the subsequent value will shift one index back to fill it up
				//also from middle removing is slow use linked list instead
				no.remove(0);
				for(Integer value:no)
				{
					System.out.println(" after deletion "+value);
             	}
				
				
				
				//collection classses are grouped by interfaces
				//so all the list objects for instance implements
			
				//interface
				//we can also declare  collection object with respetc to interfaces
				
				List <String>values = new ArrayList<String>();//we have to define template type on both sides  in angular bracket ie generic
				//we cant do new List coz it is interface new to be done for classes
				
				values.add("as");
				System.out.println(values);
			}
	}
