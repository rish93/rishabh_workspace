package com.exception.handling;

import java.io.IOException;

//public class OverridingException {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub

		
/*
If the superclass method does not declare an exception,
subclass overridden method cannot declare the checked exception
 but it can declare unchecked exception.

If the superclass method declares an exception, 
subclass overridden method can declare same, 
subclass exception or no exception but cannot 
declare parent exception.*/
		
		
		
		
		//===========for rule 1
	
	
			
//	}
//
//}
//
//

//class Parent{  
//	  void msg(){System.out.println("parent");}  
//	}  
//	class OverridingException extends Parent{    //compile time error coz itoverriding method was inheriting checked exception as parent was not having exception declared
//	  void msg()throws ArithmeticException/*throws IOException*/{  
//	    System.out.println("TestExceptionChild");  
//	  }  
//	  public static void main(String args[]){  
//	   Parent p=new OverridingException();  
//	   p.msg();  
//	  }}




/*case when super class has no throws declared and sub class tries
to declare its parent exception*/
//class Parent{  
//	  void msg()throws ArithmeticException{System.out.println("parent");}  
//	}  
//	  
//	class TestExceptionChild2 extends Parent{  
//	  void msg()throws Exception{System.out.println("child");}  //compile time eror non ompatible
//	  
//	  public static void main(String args[]){  
//	   Parent p=new TestExceptionChild2();  
//	   try{  
//	   p.msg();  
//	   }catch(Exception e){}  
//	  }  
//	}  