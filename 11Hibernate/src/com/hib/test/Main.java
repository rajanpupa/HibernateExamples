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
		// run in updae mode with at least 1 record in the table.
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		// begin db operation
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		user.setUserName("Updated after session close");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
}
