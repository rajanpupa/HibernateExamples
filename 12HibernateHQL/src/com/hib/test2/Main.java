package com.hib.test2;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hib.test.UserDetails;

public class Main {

	public static void main(String[] args) {
		// general way of doing
		// generalExample(); // all results pulled.
		
		// what if i am just interested in the username only and not userId.
//		certainFieldsOnlyExample();
		
		
		// pagination
//		paginationExample(); // starts from offset and get 4 records at a time.
	
		
		
	}
	
	public static void certainFieldsOnlyExample(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		// returns list of strings(userNames) not objects.
		Query query = session.createQuery("select userName from UserDetails");
		
		// pagination methods
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<String> users = (List<String>) query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(String userName: users){
			System.out.println(userName);
		}
	}
	
	public static void paginationExample(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails");
		
		// pagination methods
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<UserDetails> users = (List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails u: users){
			System.out.println(u.getUserName());
		}
	}
	
	public static void generalExample (){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails");
		List<UserDetails> users = (List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails u: users){
			System.out.println(u.getUserName());
		}
	}
}
