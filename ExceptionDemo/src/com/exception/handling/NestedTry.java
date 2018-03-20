package com.exception.handling;

public class NestedTry {

	
	
	//when part of block gives one error & entire part gives another eror 
	//hence use try nested (for nested exception handler)
	
	public static void main(String []args)
	{
		 try{  
//		int i=	 39/0;
			    try{  
			     System.out.println("going to divide");  
			     int b =39/0;  
			    }catch(ArithmeticException e){System.out.println(e);}  
			   
			    try{  
			    int a[]=new int[5];  
			    a[5]=4;  
			    }catch(ArrayIndexOutOfBoundsException e){System.out.println(e);}  
			     
			    System.out.println("other statement");  
			  }
			 catch(Exception e){System.out.println("handeled");
			 e.printStackTrace();}  
				  
			  System.out.println("normal flow..");  
			 }  
			
		
		
	
}
