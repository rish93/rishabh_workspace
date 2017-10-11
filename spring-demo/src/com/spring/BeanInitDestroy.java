package com.spring;

public class BeanInitDestroy {
	 private String message;

	   public void setMessage(String message){
	      this.message = message;
	   }
	   public void getMessage(){
	      System.out.println("Your Message : " + message);
	   }
	   public void init(){
	      System.out.println("Bean is going through init.");
	   }
	   public void destroy() {
	      System.out.println("Bean will destroy now.");
	   }
	//   The initIt() method is called, after the message property is set, and the
	  // destroy() method is called after the context.close();

}
