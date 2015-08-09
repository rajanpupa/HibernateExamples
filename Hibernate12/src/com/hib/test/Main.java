package com.hib.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		//createExample();
		
		hqlExample();
	}
	
	public static void hqlExample(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Query query = session.createQuery("from UserDetails");
		Query query = session.createQuery("from UserDetails where userId > 5");
		
		List users = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println("size of the list result is : " + users.size());
	}
	
	// helper method
	public static void createExample(){

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// begin db operation
		session.beginTransaction();
		
		for(int i=1; i<=10; i++){
			UserDetails user = new UserDetails();
			user.setUserName("User " + i);
			
			session.save(user);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
}
