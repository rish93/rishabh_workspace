package org.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//its not mandatory to have seperate clss  imolementing comparator
//we can have anoymous ly defined comparatorinstance with overriding  compare method in it..

class compareLengthWise implements Comparator<String>{//comparator is template type we need to put type value to sort ie String,integer in angular bracker=t
@Override
	public int compare(String s1, String s2) {//compare is supplied by objects of list to be sorted two at the time
		// TODO Auto-generated method stub
		//if 1st argument is less than second argument then it should sort earlier in the list ,then it shold return -1
		//it has to say which one is greater in each case
		//case ::  if s1 == s2 then retturn 0
		//case 2:: if s1>s2 then return 1
		//case 3:if s2<s1 the retrun -1
		
		int len1=s1.length();
		int len2=s2.length();
		
		if(len1>len2)
		{
			return 1;
		}
		
		else	if(len1<len2)
		{
			return -1;
		}
		
		else return 0;
	}	
}


class compareAlphabetically implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {

		return s1.compareTo(s2);//compare to is metod of comparable interface
		//will return +1 if s1 is greater than s2
		//will return -1 if s1 is less than s2
		//will return 0 if equal

	}

	
	
	
}


 class ComparatorSortingList {

	//to sort the value other than natural order we need to make class 
	//that impleements comparator interface
	
	public static void main(String[] args)
	{
	List<String> animals= new ArrayList<String>();

	animals.add("anim");
	
	animals.add("animal3");
	animals.add("an");
	animals.add("animal5");
	animals.add("animal4");
	animals.add("animal2");
	animals.add("anima");
	System.out.println(animals);

	
	//to sort we can use static method sort of collection class
	Collections.sort(animals);
	for(String animal:animals)
		System.out.println(animal+ "  }}not sorted");
		
	
	//******************************
	//to sort based on lenth pass string length comparator's class instance
	Collections.sort(animals, new compareLengthWise());
	for(String animal:animals)
	System.out.println(animal+ "  }}sorted based on length");
	
	
	//******************************
	
	List<String> check= new ArrayList<String>();
	check.add("z");
	check.add("e");
	check.add("w");
	Collections.sort(check, new compareAlphabetically());
	for(String checkorder:check)
	System.out.println(checkorder+ "  }}sorted alphabetically");
	
	
	//==============================

	
	///sorting list of integers
	
	List<Integer> numbers = new ArrayList<Integer>();
	numbers.add(1);
	numbers.add(34);
	numbers.add(-1);
	numbers.add(0);
	numbers.add(99);
	Collections.sort(numbers);
	for(Integer number:numbers)
	{
		
		System.out.println(number+ "  sorted numbers");//this sorting is natural order
	}//natural order is used by map to sort its keys and tree set to sort its value
	
	//****************************************************************
	//sorting without making another implemented class
	List<Integer> arbitraryClassList= new ArrayList<Integer>(); 
	
	arbitraryClassList.add(979);
	arbitraryClassList.add(97);
	arbitraryClassList.add(9);
	arbitraryClassList.add(99);
	arbitraryClassList.add(129);
	arbitraryClassList.add(239);
	
	
	Collections.sort(arbitraryClassList, new Comparator<Integer>()
			{
		@Override
				public int compare(Integer n1, Integer n2) {
					
					return n1.compareTo(n2);
					// TODO Auto-generated method stub
					//return 0;
				}
			}
				);
	for(Integer i:arbitraryClassList)
	System.out.println(i);
	//////////////////////////////////////////////////////////////////////////////
	
	
	//SORTING ARBITRARY OBJECTS
	
	//make a class and constructor to initilize its value
	person1 p1= new person1(4,"justin");
	person1 p2= new person1(66,"drake");	
	person1 p3= new person1(3,"gioden");
	person1 p4= new person1(2,"remmy");
	//now making list of type person having  people as member variable
	List<person1> people = new ArrayList<person1>();
	people.add(p1);
	people.add(p2);
	people.add(p3);
	people.add(p4);
	people.add(new person1(5,"albert"));
	
	//now collection sort will not woork for peorple
	//Collections.sort(people);
	//because person doesnt have any natural order
	//it doesnt implement any comparable interface
	//so.......
	Collections.sort(people, new Comparator<person1>(){

	
		@Override
		public int compare(person1 p1, person1 p2) {
			// TODO Auto-generated method stub
			//return 0;
			//to sort on tehe basis of name use p1.getName.compareTo(p2.getName)
			
			
	//now if we want sort on the base of id
		if(p1.getId()>p2.getId())
		{	return 1;
		}
		else if(p1.getId()<p2.getId())
		{
			return -1;
		}
		else 
			return 0;
		}
	});
	for(int i=0;i< people.size();i++)
	System.out.println(people.get(i).id +"  "+people.get(i).name+  " person class");
}
		
	
}
 
  class person1
 {
	 
	 String name;
	 int id;
	 public person1(int id, String name)
	 {
		 this.id=id;
		 this.name=name;
	 }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	 
 }
 
