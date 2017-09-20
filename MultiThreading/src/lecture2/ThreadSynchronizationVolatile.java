package lecture2;

import java.util.Scanner;

class Processor extends Thread
{
private volatile boolean running=true;	//we use volatile to prevent it from caching so that 
//it will change from another preventing infinite while loop
//or u can use rthread synchronization
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
int count =1;
  while(running)
  {
	  //here problem occurs when u want  to terminate process gracefully
	  System.out.println("Hello"+(count=count+1));
	  try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}

	public void shutdown()
	{
		running=false;
		System.out.println("stopped"
				+ ""
				+ "");
	}
	//we are accessing shutdown from another thread,
	//ie main thread	
	//other thread cant expects to modify its data
}


public class ThreadSynchronizationVolatile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//problem occur for more than one thread showing te same data
		/*1) DATA being cached*/
		/*2) Thread interleaving*/
		//if u have more than one data
	
	
	Processor proc1 = new Processor();
	proc1.start();//start will tell to run the code in run method
	
	System.out.println("press return to stop");
	Scanner scanner = new Scanner(System.in);//scan inout strem
	scanner.nextLine();
	
	
	proc1.shutdown();//this shut down may not work in some implemenrtation of java
	//or or in some OS coz variable  running can get cched in single thread and value may not change to false
	}

}
