package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
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
	    
	   
	   ConfigurableApplicationContext con =new ClassPathXmlApplicationContext("Beans.xml");
	/*That means that when you use an application context, i.e. get beans from it you only use it as an ApplicationContext but when you manage its life cycle (initialization and
	 *  destruction) you use methods from ConfigurableApplicationContext*/
	   //application context is read only
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
	//   objA.setType("String");
	  objA.getType();//String  //output constructorINIT when constructor ibitialization takes palec
	   
	   objA.getMessage();//: Spring Test
 //System.out.println(objA);
   
 /////with singleton exmple
 

 BeanScopeSingleton objB = (BeanScopeSingleton) context.getBean("helloWorldSingleton");
 objB.setMessage("helloWorldSingleton");
 objB.getMessage();

 BeanScopeSingleton objC =(BeanScopeSingleton)context.getBean("helloWorldSingleton");
 objC.getMessage(); //Spring will call your getMessage() method multiple times to try to create a new object (since you want prototype scope), 
   System.out.println("``````````````");                 //the JVM will return the same String instance anyway. default scope is singleton   use the prototype scope for all state-full beans and the
  					//singleton scope for stateless beans.

 
//with prototype scope exmpl
 
 
 
 BeanScopePrototype objD1=(BeanScopePrototype)context.getBean("helloWorldPrototype");
 objD1.setMessage("helloWorldPrototype");
 objD1.getMessage();
 BeanScopePrototype objD2=(BeanScopePrototype)context.getBean("helloWorldPrototype");

 objD2.getMessage();//will get null coz its statefull bean creates new obj everytime
 
 System.out.println("--------------end bean scope test---------------");
 
 BeanScopePrototype objE=(BeanScopePrototype)context.getBean("helloWorldPrototype");
objE.setMessage("try!!");
 objE.getMessage();    
 
 
 
 
 
 //AbstractApplicationContext absContext = new ClassPathXmlApplicationContext("Beans.xml");
 BeanInitDestroy objF = (BeanInitDestroy) context.getBean("BeanInit");
 objF.destroy();
 //objF.getMessage();

 objF.init();
 objF.getMessage();
 
 con.close();

 BeanConstructorOverloading bcoObj=(BeanConstructorOverloading)context.getBean("constructorOverloading");
 System.out.println(bcoObj.getMsg());
 System.out.println("______________________________");
 BeanConstructorOverloading bcOBJ1=(BeanConstructorOverloading)context.getBean("constructorOverloading2");
 
 System.out.println(bcOBJ1.getMsg());
 System.out.println( bcOBJ1.toString());
 
 
 
 BeanConstructorOverloading bc3=(BeanConstructorOverloading)context.getBean("constructorOverloading3");
 System.out.println("bc3 output\t"+bc3.getMsg());
 //----------------------------------------------------------------------------------
 
 //for injecting object
 //when a bean is returning an object having reference with another bean having value use 'ref'
 //attribute in config file
 ObjectInjection ObjI=(ObjectInjection)context.getBean("InjectObject");
 System.out.println(ObjI.getVal().getName()+ObjI.getVal().getContact());
 
 //dont have to do  get bean of each object we are looking for
 //just get the first level obj we need and we can get nested bean from that
 //spring bean create bean in order and returns
 
 //----------------------------------------------------------------------------------

 //inner bean aliases and idref
 
 //inner bean defined inside the property of already existing bean
 //and we isolate the bean only here it is required
 System.out.println("---------------------inner bean-----------------------------------");
 InnerBean ib= (InnerBean)context.getBean("innerbean");
 System.out.println(ib.getInnerbeanval1());
 System.out.println(ib.getInnerbeanval2());
 System.out.println(ib.getInnerbeanval3());
  
 //----------------------------------------------------------------------------------

 //aliases
 //aliases is a name that we give  to same bean
 //can give reference using aliases <alias> tag in xml
 
 //test by calling single ton bean using its alias name
 //can give as many aliases for a bean
 //can also give alias attribute during bean definition using name definition
//goood practise is to call using id but not name or alias coz id is uniques
 
 BeanScopeSingleton obAlias =(BeanScopeSingleton)context.getBean("helloWorldSingletonALIASNAME");
 System.out.println("``````calling singleton using alias name````````");   
 obAlias.getMessage(); //Spring will call your getMessage() method multiple times to try to create a new object (since you want prototype scope), 
   System.out.println("``````````````");   
 
 //----------------------------------------------------------------------------------
//IDREF 
 //an alternative to ref as ref can be for any bean's ID,Name or Alias
   //idref is only for depicting that bean is referenced from id
   //kind of restriction in referencing it has to be withing property tag
   //<property>
   //<idref="">
   //</property>
   
//----------------------------------------------------------------------------------
//initialization collection
   //to initialize member variable which is a collection
   //core interface lIST set ad map core interfaces for collection are 
   //provided as tag for spring xml 
   
   CollectionBean cb=(CollectionBean)context.getBean("collectionbean");
   System.out.println(cb.getNames());
//----------------------------------------------------------------------------------
//AUTOWIRING
  //autowiring a feature provided by spring framework
   //that help skip/reducing some of the configurtion of refrences
   
   //if name of the beans is same as member variables then we can make spring framework to
   //autowire bean based on names by using attribute autowire="byname"
   //or bytype (bean of one bean type of one particular class for which is bean is defined)
   //bytype is done only when single bean of one type class is defined in xml
   //autowire="constructor" same as byname instead of setter injection it does constructor injectiion
   //but should have one bean per type in constructor injetcion
   //without autowirng we need to manually to referencing of each mem ber variable 
   //using property tag 
   
   //less bean can use autowired efficiently for more bean prefer manual property referencing
   AutowiringBean ab =(AutowiringBean)context.getBean("autowire");
   System.out.println(ab.getAutoVal1().getAutoName());//rishabh autowired
   System.out.println(ab.getAutoVal1().getAutoContact());//74654616 1 autowired
   
   //----------------------------------------------------------------------------------

  
  
   //----------------------------------------------------------------------------------

 
   
   
   
   //----------------------------------------------------------------------------------
   
   //usinG APPLICATION CONTEXT AWARE?????????????
//   ApplicationContextAwareBean awreObj =(ApplicationContextAwareBean)context.getBean("");
//  System.out.print( awreObj.getPobj());
   //bad practise as it bind it to spring 
   //maybe if we need context in bean itself case1(for bean we need singleton context 
  //but dependent (eg point a b c)in that bean if they happen to be prototype  that will not work
   /*) since triangle is singleton point a b c will also be cretaed when container loads
    even to though point a b c are prototype but since parent triangle is initialized once points will also be initialized only once
     *
     */
   
   //BEAN NAME AWARE
   /*Spring provides BeanNameAware interface which allows us to have
   access to name of the bean defined in bean definition.
   */
   
   
   //----------------------------------------------------------------------------------

   
   //bean defn inhritence
   /* if we have many bean definition in xml and have common set of values 
    * defined cross many of the beans then we can have one bean having common definitions4
    * then we can inherit it across other beans
    * parent Bean which have common definition can be a bean in itself
    *  or abstract bean definitionwhich mean there is no bean created for it it has templating for ither beans
    *  
    * */
 /*  You can define any number of beans and extend them by using the parent  
  * attribute in the bean element. Child bean can inherit all the values, properties, methods, etc.
  *  from the parent beans. If you define the same method in the child bean, it simply overrides them
  *   in the child bean.
  */
   BeanDefinitionInheritence bdInhertObj=(BeanDefinitionInheritence)context.getBean("parent");
   System.out.println(bdInhertObj.getName());
   System.out.println(bdInhertObj.getSurname());
   System.out.println(bdInhertObj.getCountry());
   
   
   ChildBeanInheritence childObj =(ChildBeanInheritence)context.getBean("child1");
   System.out.println(childObj.getName());
   System.out.println(childObj.getSurname());

   System.out.println(childObj.getCountry());// country is not initialize in property for child bean in xml still
   //it got its valye from parent bean

   
   
   //-------------------------------------------
   //MERGING USiNG MERGE +TRUE IN CHILD INHERITED BEAN HAVING PARENT ATTRIBUTE
   //same property shld be there in child and parent
   BeanListMerge mergeListObj=(BeanListMerge)context.getBean("mergelist");
   
   System.out.println(mergeListObj.getMergeVal());
   //---------------------------------------

   //IF WE USE abstract=true; In PARENT THEN NO BEAN IS CREATED FOR 
   //parent but only it is used as a template for other bean
   //’ bean is a pure template, for bean to inherit it only, if you try to instantiate it, you will encounter the following error message.

  // BeanListMerge mergeObjAbstract=(BeanListMerge)context.getBean("merge");
   //{{{{{{Error creating bean with name 'merge': Bean definition is abstract}}}}}}}}
//abtsract exception
   
   
   //---------------------------------------
  // ABSTRACTAPPLICATIONCONTEXT
   
   AbstractApplicationContext context2=new ClassPathXmlApplicationContext("Beans.xml"); 
 //make a call to register hook o that shutdownhook is registered and when application stops
  //spring know that it is time close and destroy all the beans
   context2.registerShutdownHook();
AbstractApplicationContextBean Abstractob= (AbstractApplicationContextBean)context2.getBean("abstractapplicationcontext");

System.out.println(Abstractob.getName());
   //now we can configure init and destroy method for all the beans 
   //to initialize the bean or to destroy bean for cleanup
  //
   /*for that use abstract application context that registers javahooks 
    * for java program so that whhen main method ends then hook is called and context shutdown
    * spring container
    * 
    * we register the hook and demonstrate callback method
    * */
   
   /*In spring, 
 registerShutdownHook() method is used to shut down IoC container in non-web
 applications. It shuts down IoC container gracefully. 
 In non web based application like desk top application it is required to call 
 registerShutdownHook. In our desktop application we need to release all resources
  used by our spring application. So we need to ensure that after application is 
  finished, destroy method on our beans should be called. In web-based application 
  ApplicationContext already implements code to shut down the IoC container properly
  . But in desktop application we need to call registerShutdownHook to shutdown IoC 
  container properly.
 */
 
 
 
  
 
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