package org.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class OwnObjectInSetMap {

	public static void main(String []args)
	{
		
		Map<String,Integer> map= new LinkedHashMap<String,Integer>();
		//map keys are unique
		map.put("one", 1);
		map.put("two", 1);
		map.put("three", 1);
		map.put("four", 1);
		map.put("one", 1);
	//System.out.println(map);
		
		for(String key: map.keySet())//get key from key set then use it 
			//for getting value
		{
			System.out.println(key);
			System.out.println(map.get(key));
		}
		
		 HashSet<String> hs= new  HashSet<String>();
		Set<String> set1= new  HashSet<String>();
	
		hs.add("1");
		hs.add("2");
		hs.add("3");
		System.out.println(hs);
		
		set1.add("one");
		set1.add("two");
		set1.add("three");
		set1.add("one");
		System.out.println(set1);//unique
		
		//////////////////////////custom key value///////////////////
		person p1 = new person(5, "name5");
		person p2 = new person(2, "name2");
		person p3 = new person(3, "name3");
		person p4 = new person(4, "name4");
		person p5 = new person(5, "name5");
		
		Map<person,String> custommap= new HashMap<person,String>();
		custommap.put(p1, "FIRST PERSON");
		custommap.put(p2, "SECOND PERSON");
		custommap.put(p3, "THIRD PERSON");
		custommap.put(p4, "FOURTH PERSON");
		custommap.put(p5, "FIRST PERSON");		
		
		
		
		Set<person> customset= new HashSet<person>();
		customset.add(p1);
		customset.add(p2);
		customset.add(p3);
		customset.add(p4);
		customset.add(p5);
		System.out.println("=========================================================");
		for (person pkey:custommap.keySet())
		{
			System.out.println(pkey.toString());
			
//out put coming is two times first person which is opposite to set rules(uniquensess)
			//out put for map is also repeatable key ie name5 opposite to map rul(uniqueness)
		}
		System.out.println(customset+"  _setval__ ");
	
	}
}

class person
{
	private String name;
	private int id;
public person(int id,String name)
{
	this.name=name;
	this.id=id;
}

@Override
public String toString()
{
return "name is "+name + "id is "+id +"\n";	
}
//if we want to use custom object in set or customobject in key for map,
//we n eed to implement hashCode to get unique object of it 

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	person other = (person) obj;
	if (id != other.id)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}
}
