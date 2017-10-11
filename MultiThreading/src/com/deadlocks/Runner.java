
package com.deadlocks;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//if we change the lock order ie 1st thread{lock1, then lock2}
//and in thread 2(lock2 then lock1)
//deadlock will occur coz , thread 1 will have lock 1 thread has lock 2, thn when thread two needs
//lock 1 it is already acquired


class Runner
{
	
/*alomg with aquirelock we have to use TriLock
method of reentrant lock that return immediately and it returns	true
if it gotten lock or false if it doesnt*/	
	private Lock lock1= new ReentrantLock();
	private Lock lock2= new ReentrantLock();

	private static void acquireLocks(Lock firstLock,Lock secondLock) throws InterruptedException
	{
		while (true)
		{
			// we need to put sleep as one of the thread might unlock, the locks
			//that it might try to unlock
			
			boolean gotFirstLock=false;
			boolean gotSecondLock=false;
			
			try{
				gotFirstLock=firstLock.tryLock();
				gotSecondLock=secondLock.tryLock();
			}
			finally{
				if(gotFirstLock && gotSecondLock)
				{
					return;
				}
			//if havent got one of the locks make sure that you unlock it
				
				if(gotFirstLock)
				{
					firstLock.unlock();
				}
				if(gotSecondLock)//give chance to anoother thread to acquire it
				{
					secondLock.unlock();
				}
				
			
			
			
			
			}
			
			Thread.sleep(1);	
		}
		
	}
	//two way to prevent deadlock lock the locks of both thread in smae order
    //we can pass the lock which we want to acquire locks
	private Account acc1 = new Account();
	private Account acc2= new Account();
	
	public void firstThread() throws InterruptedException
	{
		Random random = new Random();
		//loop to make bunch of transfer from 1st account to second account
		for(int i =0;i<10000;i++)
		{
//			lock1.lock();
//			lock2.lock();
//		instead of using lock use that method in which order you want it to get acquired
			
			acquireLocks(lock1,lock2);
			try{
			//so before transfer we need the locks associated with both accounts
			Account.transfer(acc1, acc2, random.nextInt(100));
			}
			finally{
				lock1.unlock();
				lock2.unlock();
			}
			
		}
		
		
	}
	
	public void secondThread() throws InterruptedException
	{
		
		Random random = new Random();
		//loop to make bunch of transfer from 1st account to second account
		for(int i =0;i<10000;i++)
		{
//			lock2.lock();
//			lock1.lock();
//			
			acquireLocks(lock2,lock1);
			try{
			Account.transfer(acc2, acc1, random.nextInt(100));
			}
			finally{
				
				lock1.unlock();
				lock2.unlock();
			}
		}
		
		
		
		
	}
	public void finished()
	{
		System.out.println("account 1 balance "+acc1.getBalance());
		System.out.println("account 2 balance "+acc2.getBalance());
		System.out.println("total balance "+(acc1.getBalance()+acc2.getBalance()));
	}



}
