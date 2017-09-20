package demo3;

public class ThreadSameClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread t1= new Thread(new Runnable()
		{

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				for(int i=0;i<10;i++)
				{
			
					System.out.println("Hello"+i);
					try{
					Thread.sleep(1000);	
						
					}catch(InterruptedException e)
					{
						e.printStackTrace();
						
					}
					
				}
				
			}
				
				
				
				
				
		});
		
		t1.start();
		//now code will run in its own thread
		
	}
//if u wnat thread to be in thread pool u can create thread using executor services
}
