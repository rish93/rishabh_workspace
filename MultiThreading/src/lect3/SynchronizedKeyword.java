package lect3;

public class SynchronizedKeyword {

	int count=0;
	
	public synchronized void increment()
	{
	count++;
	//int count=0;
	}
	public static void main(String []args)
	{
		//System.out.println("hi");
		SynchronizedKeyword sk = new SynchronizedKeyword();//create an instance of this class,as we wang to give it to some intance variable
	    sk.doWork();
 	}
	
	//on making it synchronized it will be accessed by one thread at one time
	//when u dont make it synchronized it i not thread safe
	public  void doWork()
	{
		
		Thread t1= new Thread(new Runnable()
			{
    		@Override
				public void run() {
					// TODO Auto-generated method stub
					for(int i=0;i<10000;i++)
					{
						increment();
						//count++;
					}
					
				}
			});
	//thead 2
		Thread t2= new Thread(new Runnable()
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0;i<10000;i++)
				{
					increment();
					//count++;
				}
				
			}
		});
	
	t1.start();
	t2.start();
	try {
		t1.join();//used because we want our main thread to wait until t1 completes its process
		t2.join();//used because we want our main thread to wait until t2 completes its process else it will show 0
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}//now it just pauses his execution of thread
	//that its called in which is main threat here
	
	
	
	//mean while another thread is running and looping through it, main thread print 0 so use join method
	
	
	System.out.println("count is  "+count);//count will be zero as when contrlols comes to t1.start
	//it will always return immediately coz it spawns an extra thread
	//so without loop to get started this is getting count as 0 and printing 
	//so to fix that we ned those two thread to finish executing before we try to get value of 
	//count
	//so to wait for thread to finish we can use thread.join method

	//even after using join at some point both thread takes up the value at same time and increment 1,but that will increment one from both thread but not 2, ie one from each thread at same time,
	//hence on each run its value is different//both are fetching value at the sam e time and incrementing at same time// yence diff result
	
	
	
	
	}
	//this thing will work sometine ithe rtime hey dont
}
