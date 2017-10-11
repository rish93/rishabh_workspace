package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;





class Processor implements Runnable{
	
	
	private int id;
	public Processor(int id)//makin constructor so that we can pass an id when creating processor
	{
		this.id=id;
	}	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println("Starting "+id);
	 try {
		  Thread.sleep(5000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
		System.out.println("Completed "+id);
		}
 	}






public class threadpool {
//thread pools is way managing threads at same time
	
	public static void main(String []args)

	{
		//if we want ro create 10 of these process and make them work
		//through 10 different tska
		
		//instead of using thread here we are using executor srvice
		
		
		//service will create thread pool for 2 threads
		//thread pool is like having no of workers in afactory, hre two
		//we cn assign task to them eg 5 task to eahc of the workers
		/*for instance now if we want after worker thread finshers processing task
		 * we wnat to start new task,
		 * (((like saying worker to work on these tak one at atime ,and when you
		 * finish on task start on new task)))*/
		ExecutorService executor =Executors.newFixedThreadPool(2);

		//now we can submit the task to xecutors
		//executor will handle this task managerially
		
		
		for(int i=0;i<5;i++)
		{
			executor.submit(new Processor(i));//processor the id,(loop variable)
		}
		//now we can make to stop accepting all the task after it is done
		executor.shutdown();//it will not shutdown completely but will wait for all the thread to be completed doing ehat they are doing 
		
	
		
		//lest suppose we want to wait for all the task to get completed
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);//setting it one day mean it will wait until task is finished,we set 10 seconds and so on
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	System.out.println("all task completed");
	//when one of the tasks completeednwhich happens to be task having id 1
	//it will start new task within same thrread
	
	//as soon as one thread is finished and its idle that same thread will now process a new task
	}
	
}
