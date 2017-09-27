package org.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	
	public static void main(String []args)
	{
		//to add or remove item at end of your list use array listthats a frequent case
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		//if want  to add or remove itemr from any where begining or middle us elinked list
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
	
	doTimings("ArrayList",arrayList);
	doTimings("LinkedList",linkedList);
	}

	
	//since parameter is list, we can pass any class that implemented this interface
	private static void doTimings(String type,List<Integer> list)
	{
		for(int i=0;i<1e5;i++)//1e5 mean 1o^5
		{
			list.add(i);
		}
		
		
		long start =System.currentTimeMillis();
		
		//add items at end of list
//		for(int i=0;i<1e5;i++)
//		{
//			list.add(i);
//			//time taken will be longer to +-4 seconf for linked list in adding 13 17
//		}
		
		
		//add item elsewhere in list
		for(int i=0;i<1e5;i++)
			{
			
			list.add(list.size()-100,i);//adding smewhere middle
			//array lis is faster 37 ms
			//linked list is 107
			
			
				//list.add(0, i);//add at beining so put index =0
				//time taken will be longer to +-4 seconf for linked list in adding
			
				/*actually linked list doesnt care where u add the item avg time is same*/
			//hence to add item in end or middle use linked list
				
				//9001 ms for array list to add in begining
				//14 ms to add in linked list
			}
		
		
		long end= System.currentTimeMillis();
		System.out.println("TimeTaken "+( end-start)+" for type "+type);
	}
	
	/*ABOUT LINKED LIST*/
	//use linked list to add items when u are adding anywhere other than very close to end
  //Linked list consist of elemnets where each element
	//has a reference to the previous and next element
	/*so traversing LL is slower to arraylist to get item at particular pooint
	 * */
	
	
	/*ABOUT ARRAY LIST*/
	//for array list adding/removing item from end is very fast
	//getting particular item is very fast
	// we can specify legth of arraylist if nnot specified it will take 10 by default, then as we enter the 11th element
	//it will create ne object with copying old elements, of size just double of previous

	//similarly adding item in middle will move remaining item to left
	
	
	
	//===========
	/*use array list normally 
	 * but if we want to add or remove item in middle
	 *  or beginning of list anywhere
	 * other than end use linked list*/
//arrraylist end faster  beginning middle slower
	//linked list end slowwer  beginning middle faster
	
	
}
