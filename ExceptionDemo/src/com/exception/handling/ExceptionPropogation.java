package com.exception.handling;

import java.io.IOException;

public class ExceptionPropogation {
/*
 * exception is first thrown from the top of the stack
 *  and if it is not caught, it drops
 *  down the call stack to the previous 
 * method,If not caught there, the 
 * exception again drops down to the previous method, 
 * and so on until they are caught or until
 *  they reach the very bottom of the call stack*/
	
	
	///By default Unchecked Exceptions are forwarded 
	//in calling chain (propagated). checked will throw compilation error
		  void m(){  
		    int data=50/0;  
		  }  
		  void n(){  
		 
			 
			m();
			
		  }  
		  void p(){  
		   try{  
		    n();  
		   throw new Exception();
		   }catch(Exception e){e.printStackTrace();
		   System.out.println("exception handled");}  
		  }  
		  public static void main(String args[]){  
		ExceptionPropogation obj=new ExceptionPropogation();  
		   obj.p();  
		   System.out.println("normal flow...");  
		  }  

		  //======verifying checked exceptiion
		  
		  
}
//class efef{
//	
//	
//	 static void m1() throws IOException{  
//		    throw new java.io.IOException("device error");//checked exception  
//		  }  
//		 static void n1() throws IOException{  
//		    m1();  
//		  }  
//		 static void p1(){  
//		   try{  
//		    n1();  
//		   }catch(Exception e){System.out.println("exception handeled");}  
//		  }  
//		  public static void main(String args[]){  
//			  efef obj=new efef();  
//		   obj.p1();  
//		   System.out.println("normal flow");  
//		  }  
//		}  
	  
//	checked exception cant be propogated will throw compile error


/*	throw	                                                             throws
1)	Java throw keyword is used to explicitly throw an exception.	  Java throws keyword is used to declare an exception.
2)	Checked exception cannot be propagated using throw only.          Checked exception can be propagated with throws.
3)	Throw is followed by an instance.	                              Throws is followed by class.
4)	Throw is used within the method.	                              Throws is used with the method signature.
5)	You cannot throw multiple exceptions.	                          You can declare multiple exceptions e.g.
                                                                      public void method()throws IOException,SQLException.*/

