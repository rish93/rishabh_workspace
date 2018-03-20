package com.exception.handling;

 class HandleThrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 validate(13);  
	      System.out.println("rest of the code...");  
	}

	
	//throw is used too rethrow exception explicitly 
	//we can either throw checked or unchekced exception
	
	//The throw keyword is mainly used to throw custom exception
	
	 static void validate(int age){  
	     if(age<18)  
	      throw new ArithmeticException("not valid age");  
	     else  
	      System.out.println("welcome to vote");  
	  
	 }  
	
}
