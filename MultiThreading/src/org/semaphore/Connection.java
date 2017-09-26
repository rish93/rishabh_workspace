package org.semaphore;

import java.util.concurrent.Semaphore;

public class Connection {

	/*wil make private static connection instance variable whic will store connection singleton instance*/
	private static Connection instance = new Connection();
	
	private int connections=0;
	
	//to limit no of connections at givenr time using semaphore
	Semaphore sem= new Semaphore(10);
	
	
	private Connection(){ //will make it singleton by defining private constructor
		
	}
	

	public static Connection getInstance()//to get instance
	{
		return instance;
	}

public void connect() throws InterruptedException
{
	
	try{
		sem.acquire();
	}
	catch(InterruptedException e1)
	{
		e1.printStackTrace();
	}
	
	
	synchronized(this)
	{
		connections++;
		System.out.println("Current Connections: "+connections);
	}

	Thread.sleep(2000);

	synchronized(this)
	{
		connections--;
	}
sem.release();
}

}
