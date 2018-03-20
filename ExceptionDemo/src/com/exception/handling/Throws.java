package com.exception.handling;

import java.io.IOException;

public class Throws {

	
	/* throws keyword is used
	 *  to declare an exception.
	 *  It gives an information to the programmer that there may occur an exception so it is better for the programmer to provide the exception
	 *  handling code so that normal flow can be maintained.*/
	/*
	 * Exception Handling is mainly used to handle the checked 
	 * exceptions. If there occurs any unchecked exception such as NullPointerException, it is programmers fault that he is
	 *  not performing check up before the code being used.
	 * 
	 */
	 void m()throws IOException{  
		    throw new IOException("device error");//checked exception  not will propogate
		  }  
		  void n()throws IOException{  
		    m();  
		  }  
		  void p(){  
		   try{  
		    n();  
		   }catch(Exception e){e.printStackTrace();
		   System.out.println("exception handled");}  
		  }  
		  public static void main(String args[]){  
		   Throws obj=new Throws();  
		   obj.p();  
		   System.out.println("normal flow...");  
		  }  
}

//class M{  
//	 void method()throws IOException{  
//	  throw new IOException("device error");  
//	 }  
//	}  
//	class Testthrows4{  
//	   public static void main(String args[])throws IOException{//declare exception  
//	     M m=new M();  
//	     m.method();  
//	  //throws for the last method in stack memory will throw exception at runtime
//	    System.out.println("normal flow...");  
//	  }  
//	}  
