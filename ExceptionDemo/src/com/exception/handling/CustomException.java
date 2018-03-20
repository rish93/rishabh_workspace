package com.exception.handling;

class InvalidAgeException extends Exception{
//custom exceptions are used to customize the exception according to user need.
	
	InvalidAgeException(String s)
	{
		super (s);
	}
	
}
class CustomException{  
	  
	   static void validate(int age)throws InvalidAgeException{  
	     if(age<18)  
	      throw new InvalidAgeException("not valid");  
	     else  
	      System.out.println("welcome to vote");  
	   }  
	     
	   public static void main(String args[]){  
	      try{  
	      validate(13);  
	      }catch(Exception m){System.out.println("Exception occured: "+m);}  
	  
	      System.out.println("rest of the code...");  
	 
	   for(int i=0;i<3;i++){
	      int a = i;
	      switch( a ) {
	      case 0: 
	         Integer b = 1;
	          System.out.println("case 0: b = " + b);
	          break;
	      
	      case 1: 
	          // the following line does not compile: b may not have been initialized
	          // System.out.println("case 1 before: b = " + b);
	           b = 2;
	          System.out.println("case 1 after: b = " + b);
	          break;
	      
	      default: 
	           b = 7;
	          System.out.println("default: b = " + b);
	      
	      }
	   
	   }
	   
	   
	   
	   }  
	}  