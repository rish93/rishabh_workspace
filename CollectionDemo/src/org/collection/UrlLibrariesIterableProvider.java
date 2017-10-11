package org.collection;

import java.util.Iterator;
import java.util.LinkedList;

public class UrlLibrariesIterableProvider implements Iterable<String>{

	private LinkedList<String> urls= new LinkedList<String>();
	
	
	public UrlLibrariesIterableProvider()
	{   urls.add("http://www.demorishabh.com");
		urls.add("http://www.news.bbc.co.uk");
		urls.add("http://www.audiomedy.com");
		urls.add("http://www.linkedin.com");
		}

	
	
	

//	@Override
//	public Iterator<String> iterator() {
//		// TODO Auto-generated method stub
//		
//		return urls.iterator();//will return and iterator object of this linke dlist
//		//		return null;
//	}
//	
	
//	private class UrlIterator implements Iterator<String>{
//
//		private int index=0;
//		
//		@Override
//		public boolean hasNext() {
//			// TODO Auto-generated method stub
//			return false;
//		}
//
//		@Override
//		public String next() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//		
//		@Override
//		public void remove()//this will remove the url iterator is currenlty pointing at
//		{//
//			urls.remove(index);
//		}
//	}
	
	//sample where we are
	//fetching the object we want  to iterate 
//creating ur own iterator
	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		
		return urls.iterator();//will return and iterator object of this linke dlist
		//		return null;
	}
	
	
}
