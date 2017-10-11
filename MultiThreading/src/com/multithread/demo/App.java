package com.multithread.demo;

class Runner extends Thread
{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

	for(int i=0;i<10;i++)
	{
		//we will get interleaved output ie hello 0 hello 0 hello 1...
		System.out.println("hello +" +i);
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




public class App {

	public static void main(String[] args) {

//thread is like seperate operating system process
	//which can run concurently with other threads
		
		
		Runner runner1 = new Runner();
		runner1.start();
		//we can directly call run method
		//using object but it will run it in main thread of application
		//when we use start we tell to look for
		//runn method and run it in speacial thread
		
		
		Runner runner2 = new Runner();
		runner2.start();
	
		
	}

}
