package com.hib.test;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		namedNativeQueryExample();
		
	}
	
	public static void namedNativeQueryExample(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		String minUserId = "5";
		String userName = "User 10";
		
		session.beginTransaction();
		
		// this may lead to sql query injection.
		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, userName);
		
		List<UserDetails> users = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user: users){
			System.out.println(user.getUserName());
		}
	}
	
	public static void namedQueryExample(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		String minUserId = "5";
		String userName = "User 10";
		
		session.beginTransaction();
		
		// this may lead to sql query injection.
		Query query = session.getNamedQuery("UserDetails.byId");
		query.setInteger(0, Integer.parseInt(minUserId));
		
		List<UserDetails> users = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user: users){
			System.out.println(user.getUserName());
		}
	}
	
}
