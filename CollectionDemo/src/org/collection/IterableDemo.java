package org.collection;


//another class  URL librariesiterableProvider is made asssuming can store 
//urls
public class IterableDemo {

	public static void main(String[]args)
	{
		//how to iterate over collection of value in other class
		//make other class to implement iterable
		
		UrlLibrariesIterableProvider urls= new UrlLibrariesIterableProvider();
		
		//after implementing iterable interface and returning iterator object from that class
		//we can use
		
		for(String s:urls)
		{System.out.println(s);
		}
		
		
		//we can iterate over some custom order also
		
	}

}
