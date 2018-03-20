package com.exception.handling;

public class finalfinallyfinalize {

	    @Override
		public void finalize(){System.out.println("finalize called");}  
		
	    
	    
	    public static void main(String[] args){  
			finalfinallyfinalize f1=new finalfinallyfinalize();  
			finalfinallyfinalize f2=new finalfinallyfinalize();  
			f1=null;  
			f2=null;  
			System.gc();  
		
		
		try{  
			int x=300/0;  
			}catch(Exception e){System.out.println(e);}  
			finally{System.out.println("finally block is executed");}  

//		final int x=100;  
//		x=200;//Compile Time Error  

      }  
}