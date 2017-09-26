package com.deadlocks;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



class deadlocks {
/*A lock is a tool for controlling access to a shared resource by multiple threads.
 *  Commonly, a lock 
 * provides exclusive access to a shared resource: 
 * only one thread at a time can acquire the lock and all
 *  access to the shared resource requires that the lock be acquired first*/
	//now will try using Lock to oreent interleving effect
//	private Lock lock1= new ReentrantLock();
//	private Lock lock2= new ReentrantLock();
//	
	public static void main(String []ags) throws InterruptedException
	{
		//on simply running totla amount should be 2000 but is not ddue to interleaving thread effect
	
		final Runner runner= new Runner();
		Thread t1= new Thread (new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
				runner.firstThread();	
				}catch(InterruptedException e)
				{
			e.printStackTrace();		
					
				}
				
			}
		});
		
		

		Thread t2= new Thread (new Runnable(){
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					runner.firstThread();	
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		});
		
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		runner.finished();
		
		
		
	}
}



