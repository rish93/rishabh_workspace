package com.multithread.demo;



 class Runn implements Runnable
{

	// private boolean running =true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++)
		{
			//we will get interleaved output ie hello 0 hello 0 hello 1...
			System.out.println("hello " +i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//thread  sleep  throws Interrupted exception  
		}
		}

	
	
	
}

	
	public class RunnableThread {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Thread t1 = new Thread(new Runn());//dd runnable interface
		//pass instance of runnable thread in constructor
			//eclare instance of thread class,pass instance of runn class,clas sthat has implemente
			Thread t2 = new Thread(new Runn());

			t1.start();
			t2.start();
			
		}
	
		
		
	}