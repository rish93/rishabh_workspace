package com.exception.handling;

public class TryBlock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//we can use try for the block of code, taht might throw exception
		//we can use multiple cathc with single try
	try{	
		int data=50/0;
		System.out.println("----End-----");
	
	 }catch(ArithmeticException e){e.printStackTrace();}  
	   System.out.println("rest of the code...");  
		//this part wouldnot have executed without use of  try
	}

}
