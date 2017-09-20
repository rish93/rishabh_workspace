package multiplelocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainClass {
private List<Integer> list1 = new ArrayList<Integer>();
private List<Integer> list2 = new ArrayList<Integer>();
	
private Random random = new Random();

private Object lock1= new Object();
private Object lock2= new Object();

//public synchronized void stage1()
//{
//	
//	try {
//		Thread.sleep(1);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	list1.add(random.nextInt(100));
//}






//public synchronized void stage2()
//{
//
//	try {
//		Thread.sleep(1);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//list2.add(random.nextInt(100));	
//}




//==================================method 2======================
public void stage1()
{
synchronized(lock1){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   list1.add(random.nextInt(100));	
	
	}
	
}
public  void stage2()
{
 synchronized(lock2)
 {
	 try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	list2.add(random.nextInt(100));
	 
 }
		
}


public void process()
{
	for(int i=0;i<1000;i++)
	{
		stage1();
		stage2();
	}
}

//before thread take acess of resource it take monitor lock of the object of that class to which that resource beling
public static void main(String []args)
	{
	MainClass mc= new MainClass();	
	System.out.println("Starting...");
//		
//		long start =System.currentTimeMillis();
//		mc.process();
//		long end= System.currentTimeMillis();
//		System.out.println("time taken: "+(end-start));
//		System.out.println("List1: " +mc.list1.size()+""
//				+ "List2: "+mc.list2.size());

	
	
	long start =System.currentTimeMillis();
	
	Thread t1= new Thread(new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			mc.process();	
		}
	});
	

	Thread t2= new Thread(new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			mc.process();
		}
		
	});	
	
	t1.start();
	t2.start();
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
	long end= System.currentTimeMillis();
	System.out.println("time taken: "+(end-start));
	System.out.println("List1: " +mc.list1.size()+""
			+ "List2: "+mc.list2.size());
	
	
		
		
		//running it without thread ie using object.process() it would take approx 2.5 seconds, coz sleep is 1 mili second
		//by using thread it would take about 2.5 second but may give wroong list data and also may give array index out of exception
	//coz we are trying to share data from pultiple threads,here process() due to thread interleaving coz writing to list is not single operation and durnng writing if thread interleave it will give unvene data result
	
	//hence we will try making method synchronized,then we will se list to have write number of items in them, but it ill take approx 6 seconds
	//reason is ynchronized method acquire the intrinsic lock/or monitor  lock of works objetc(in class which that syncronized methos is present),
	//so two synchronized method are there if one is running second will wait to accquire that lock
	//but problem here is there is one intrinsic lock,so no two thread can run stageone() at same time same  with stage2()
	//but one thread can run stage1() and another can run stage2()
	
	/*so we can create two locks, and synchronizing to lock seperately
	 * create lock1 of object class,and use it in synchronize block for each stage 1 and two
	 * synchronized block run the same way synchronized access modifier
	 * excpt for now two threads  can run the method at same time, but if one thread has already entered the synchronized block, second will have t wait untill it can
	 * run the syncronized code block,untill first thread release lock1 by exitng block, since we using disffrent lock so one thread can stp stage 1 and another can stage2
	 * since used locks different lock1/lock2 so no two thread can run one block at same time,another thread can run lock 2 tread at same time
	 * now it will take 2.5 second approx with ful 1000 list each
	 * 
	 * */
	
	}
}
