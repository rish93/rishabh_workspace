package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
	   // Triangle triangle = new Triangle(); instantiate triangle object  using new operator 
	   
	    //instantiate using bean factory to do it
//	    BeanFactory factory= new  XmlBeanFactory(new FileSystemResource("spring.xml"));
//	    Triangle triangle1=(Triangle)factory.getBean("triangle");
	    //why to use this method but not new coz
	    //more complex the object becomes more details the blueprint(xml) becomes
	    // more advantage is seen by calling this way of object refeence
	    //once u ddefine in one place u can use object  refrence in app whereever required
//	    triangle1.draw();
	    
	 //xml file for configuration shld be in project path for Bean Factory class   
	    
	   
	   
	   ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");//ClassPathXmlApplicationContext(). This API loads beans configuration  
									      //file and eventually based on the provided API, it takes care of creating and initializing all the objects, i.e.
									      //beans mentioned in the configuration file.
     //to get completely prepared object set property in xml file is filled with value
	   BeanSimple objA = (BeanSimple) context.getBean("helloWorld"); /*get the required bean using getBean() method of the created context. 
															      This method uses bean ID to return a generic object, which finally can be casted to the	
															       actual object.
																	Once you have an object, you can use this object to call any class method */
 //calling class doesnt care if spring generate object using cosntructor or setter 
	  
	   System.out.println(objA);//com.spring.BeanSimple@731a74c
	   objA.setType("String");
	  objA.getType();//String
	   
	   objA.getMessage();//: Spring Test
 //System.out.println(objA);
   
 /////with singleton exmple
 

 BeanScopeSingleton objB = (BeanScopeSingleton) context.getBean("helloWorldSingleton");
 objB.setMessage("helloWorldSingleton");
 objB.getMessage();

 BeanScopeSingleton objC =(BeanScopeSingleton)context.getBean("helloWorldSingleton");
 objC.getMessage(); //Spring will call your getMessage() method multiple times to try to create a new object (since you want prototype scope), 
                    //the JVM will return the same String instance anyway. default scope is singleton   use the prototype scope for all state-full beans and the
  					//singleton scope for stateless beans.

 
//with prototype scope exmpl
 
 
 
 BeanScopePrototype objD=(BeanScopePrototype)context.getBean("helloWorldPrototype");
 objD.setMessage("helloWorldPrototype");
 objD.getMessage();

 BeanScopePrototype objE=(BeanScopePrototype)context.getBean("helloWorldPrototype");
 objE.getMessage();    //will get null coz its statefull bean creates new obj everytime
 
 
 
 
 
 AbstractApplicationContext absContext = new ClassPathXmlApplicationContext("Beans.xml");
 BeanInitDestroy objF = (BeanInitDestroy) context.getBean("helloWorld");
 objF.getMessage();
 ((AbstractApplicationContext) context).registerShutdownHook();
 
 
 
 
  
 
 /* ******with without spring********
"Design your objects so that they rely on an outside force to supply them with what they need, 
with the expectation that these dependencies are always injected before anybody asks them to start doing their usual jobs
Compare that against: "Each object is responsible for GOING out and finding everything and everybody it needs as it starts up."

*/
      
      
      
      
      
   /* 
With @Autowired annotation, you don't need a setter method. Once your bean's constructor is done with allocating/creating the object, 
Spring will scan for this annotation and would inject the object instances that you annotated.
While if you have setter and if you are still using xml config, you would explicitly set properties.
Having said that, You could annotate your constructor and setter method with autowired annotation which 
i would prefer as this would give me flexibility later on to move away from Spring (although i wont do it)./
   */
   }
}