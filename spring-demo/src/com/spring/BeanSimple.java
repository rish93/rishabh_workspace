package com.spring;


public class BeanSimple {
	   private String message;// member variable
	    private String type;

	   //constructor injection //initialize using property xml to inject in constructor
	    //when it is constructing its object
//use 	<constructor-arg  value = "Value for cosntructor" />  inunder bean tag to initialize using constructore
	
	    
	    public BeanSimple(String type)
	   {
		   this.type=type;
	   }
	     public String getType() {
		  System.out.println(type);
	    	 return type;
		}

//		public void setType(String type) {
//			this.type = type;
//		}



	   
	   
	   
	  public void setMessage(String message){
	      this.message  = message;// spring uses setter to initialize 
	      //member when property value is set this is setter injection
	   }
	  
	    
	    
	    public void getMessage(){
	      System.out.println(": " + message  +"");
	       }
	}



