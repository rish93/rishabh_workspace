package com.exception.handling;

public class FinallyBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{  
			   int data=25/5;  
			   System.out.println(data);  
			  }  
			  catch(NullPointerException e){System.out.println(e);}  
			  finally{System.out.println("finally block is always executed");}  
			  System.out.println("rest of the code...");  
			    
		
		
	//Finally block in java can be used to put "cleanup" code
	//such as closing a file, closing connection etc

	
	
	
	//finally when exception occure and not handled
	  try{  
		   int data=25/0;  
		   System.out.println(data);  
		  }  
		  catch(NullPointerException e){System.out.println(e);}  
		  finally{System.out.println("finally block is always executed");}  
		  System.out.println("rest of the code...");  
		    
}
	
	
	
}
