package com.hib.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		sessionExample();
	}
	
	/**
	 * Transient, persistent and detatched objects
	 */
	public static void sessionExample(){
		// Transient
		UserDetails user = new UserDetails();
		user.setUserName("Test User");
		

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// begin db operation
		session.beginTransaction();
		
		session.save(user);// now it becomed persistent
		
		// this will automatically trigger the update
		user.setUserName("updated user");
		
		// hibernate watches what is the least changes that need to be made.
		user.setUserName("updated user Again");// this will only be called.
		
		session.getTransaction().commit();
		session.close();// now the object is detached
		
		
		user.setUserName("This will not trigger update");
	}
	
}
