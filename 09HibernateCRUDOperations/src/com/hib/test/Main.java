package com.hib.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		//createExample();
		
		// change hibernate settings to update before running it.
		//readExample();
		
		// change hibernate settings to update before running it.
		//deleteExample();
		
		// change hibernate settings to update before running it.
		updateExample();
	}
	
	public static void createExample(){

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// begin db operation
		session.beginTransaction();
		
		for(int i=0; i<10; i++){
			UserDetails user = new UserDetails();
			user.setUserName("User_" + i);
			
			session.save(user);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	public static void readExample(){

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// begin db operation
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		//System.out.println("User name " + user.getUserName());
		
		session.getTransaction().commit();
		session.close();
		
		// works fine here as well, for eager fetch fields
		System.out.println("User name " + user.getUserName());
	}
	
	public static void deleteExample(){

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// begin db operation
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
		session.delete(user);
		//System.out.println("User name " + user.getUserName());
		
		session.getTransaction().commit();
		session.close();
		
		// works fine here as well, for eager fetch fields
		System.out.println("User name " + user.getUserName());
	}
	
	public static void updateExample(){

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// begin db operation
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
		user.setUserName("Updated user");
		
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
		
		// works fine here as well, for eager fetch fields
		System.out.println("User name " + user.getUserName());
	}
}
