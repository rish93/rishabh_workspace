package com.jwt.dao;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jwt.model.MessageModel;


public class MessageDAOImpl implements MessageDAO{
	SessionFactory sessionFactory =new Configuration().configure().buildSessionFactory();

	
	public void setMessage(Integer id,String msg,String author,java.util.Date created)
	{
		Session session = sessionFactory.openSession();
		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		//String sss=df.format(dateobj);
		System.out.println(df.format(dateobj));
		
		
		System.out.println("in DAO"); 
		MessageModel msg1= new MessageModel();
		msg1.setMessage("msg 1");
		msg1.setCreated(df.format(dateobj));
		
		session.beginTransaction();
		session.save(msg1);
		session.getTransaction().commit();
		System.out.println("saved");
	}
	
	
	
	public List<MessageModel> getData()
	{
		Session session = sessionFactory.openSession();
		//DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		//Date dateobj = new Date();
		
//		MessageModel msg= new MessageModel();
//		msg.setMessage("msg 1");
//		msg.setAuthor("rishabh");
//		msg.setCreated(df.format(dateobj));
		session.beginTransaction();
		
		MessageModel msg2= new MessageModel();
		msg2=(MessageModel)	session.get(MessageModel.class, 1);
		System.out.println(msg2.getMessage().toString()+"###############");
		
				
		
		
		Query query=session.createQuery("from MessageModel");/*where id > 2*/
		//query.setsetFirstResult(3);
		
		//this will make sure ex we make select* and have 10 recrods, it will go five result below the that willl be the first result
		//use query .setfirst result to get start of my results we are interested in
		List<MessageModel> name=(List<MessageModel>) query.list();
	
		
		System.out.println(name.get(0).getAuthor()  );
		
		session.getTransaction().commit();
session.close();
		
//		
//		List<MessageModel> arrList= new ArrayList<MessageModel>();
//		
//		arrList.addAll(name);
//		System.out.println(arrList);
		
	
		return name;
		
	}



	public void updateMsg(Integer id, String msg) {
		// TODO Auto-generated method stub
		
	}



	public List<MessageModel> getParticularMsg(Integer id) {
		// TODO Auto-generated method stub
		
	Session session = sessionFactory.openSession();
		
	System.out.println("for id"+id);
		Query query= session.createQuery("from MessageModel where id =:id");
		
		query.setInteger("id", id);
		List name = query.list();
		
		//if there is nothing to save,no need to commit
		
		//List<MessageModel> name=(List<MessageModel>) query.list();
	//	session.getTransaction().commit();
	session.close();
		System.out.println(name+"for id"+id);
		return name;
		
	}



	public MessageModel deleteMsg(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		
		Query query=session.createQuery("from MessageModel");/*where id > 2*/

		
		
		return new MessageModel();
			}



	public void deleteAllMsg() {
		// TODO Auto-generated method stub
		
	}



}
