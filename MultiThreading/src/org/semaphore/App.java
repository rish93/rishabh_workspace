package org.semaphore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
public class App {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		//semaphore is an object that maintains the count, where count specifies 
		// the available permits of semaphore, we can get the no of permits by using
		//semaphore.availablePermits()
		
		Semaphore sem= new Semaphore(1);
		//if we try to acquire semaphore when it has set 0 in its constructor , then method
		//acwuire has to wait inefinitrly
		System.out.println("Available permits:  "+sem.availablePermits());
		//there is a method release which iwll increase the permits for semaphore by one 
		//there is also a method that decrements the available permits which is called
		//acquire()
		/*acquire will actuallfy,if there is no permits available*
	
	
//	**
 * acquiring semaphore is like acwuiring lock,
 * so whith the lock u have to unlock, 
 * semaphore are used to access to some resources
		 */ 
	
	
	
	ExecutorService executor =Executors.newCachedThreadPool();

	for(int i=0;i<200;i++)
	{
		executor.submit(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Connection.getInstance().connect();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
		});
	}
	
	executor.shutdown();
	executor.awaitTermination(1,TimeUnit.DAYS);
	}

}
