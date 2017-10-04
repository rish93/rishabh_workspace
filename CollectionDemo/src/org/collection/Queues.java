package org.collection;

import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Queues {

	
	
	public static void main(String []args)
	{
		//queue is fifo, item first added will be 
		//leaving first from head
		//adding from tail
		// (head)  <- 000000000000 <- (tail)
		
		
		//array blocking queue hs fixed size unlike linked list which has 
		//infinite size
	
		/*blocking queue is useful whne accesing queue from two threads at same time it will make
		 *  sure iretrieval insertion is don only when value is in there
		 //blocking queue makes sure if removal is done it is done when queue is non empty
		  * 
 * LinkedBlockingQueue — an optionally bounded FIFO blocking queue backed by linked nodes
ArrayBlockingQueue — a bounded FIFO blocking queue backed by an array
PriorityBlockingQueue — an unbounded blocking priority queue backed by a heap
DelayQueue — a time-based scheduling queue backed by a heap
SynchronousQueue — a simple rendezvous mechanism that uses the BlockingQueue interface*/
		
		Queue<Integer> q1= new ArrayBlockingQueue<Integer>(3);
		//size 3 trying to add four items 
		//will throw illegal state exception//add didnt force to put try catch block
		//it is an unchecked exception
		//we are not forced to handle it, but we can handle it 
		q1.add(10);
		q1.add(20);
		q1.add(30);
		
	try{	//we will not see this exception
		//with add to in linked list coz LL is not bounded
		//and can keep on adding 
		
		
		
		
		q1.add(10);
	}catch(IllegalStateException e)
	{
		System.out.println(e);
		//e.printStackTrace();
	}
	
	for(Integer value :q1)
	{
		System.out.println("value is "+ value);
	}
	
	Integer value= q1.remove();//remove will remove the head of the queue and will return it
	System.out.println(value);
	 q1.remove();
	 q1.remove();
	 System.out.println(q1 +" after removal");
	 
		 try{
		 q1.remove();//no such element exception
		//hence put in trycatch
		 }
		catch(NoSuchElementException e) 
		 {
			System.out.println("elment not presented to be removed");
		 }
		//======================================================================
		 System.out.println("=============================");
		 
		 Queue<Integer> q2= new ArrayBlockingQueue<Integer>(2);
      
		 //peek 
		  System.out.println(q2.peek()+" q2 peek");
		
		 
//		 q2.add(10);
//		 q2.add(20);
//		 q2.add(30); //size declared 2 and we enter 3 value it will show illegal state exception

		 q2.offer(10);/*Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions*/
		 q2.offer(20);//will return true if iserted else false
		 q2.offer(30);//but will not show error when offer () i used
		 //it will not add lasrt value
		 
		 
		 for(Integer v :q2)
			{
				System.out.println("value is "+ v);
			}
		 //using poll is same as offer, will not give error  for removing non existing no
		 q2.poll();
		 q2.poll();
		 q2.poll();
		 System.out.println(q2);
		 
		//offer poll peek 
	}
}
