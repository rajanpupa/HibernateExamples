package com.hib.test;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		// sql injection may occur
		//sqlInjectibleExample();
		//sqlInjectibleExample2();
		
		// binding example
		//safeHqlExample();
		safeHqlExample2();
		
	}
	
	public static void safeHqlExample2(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		String minUserId = "5";
		String userName = "User 10";
		
		session.beginTransaction();
		
		// this may lead to sql query injection.
		Query query = session.createQuery("from UserDetails where userId > :userId and userName = :userName " );
		query.setInteger("userId", Integer.parseInt(minUserId));
		query.setString("userName", userName);
		
		List<UserDetails> users = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user: users){
			System.out.println(user.getUserName());
		}
	}
	public static void safeHqlExample(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		String minUserId = "5";
		String userName = "User 10";
		
		session.beginTransaction();
		
		// this may lead to sql query injection.
		Query query = session.createQuery("from UserDetails where userId > ? and userName = ?" );
		query.setInteger(0, Integer.parseInt(minUserId));
		query.setString(1, userName);
		
		List<UserDetails> users = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user: users){
			System.out.println(user.getUserName());
		}
	}
	
	public static void sqlInjectibleExample(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		int minUserId = 5;
		
		session.beginTransaction();
		
		// this may lead to sql query injection.
		Query query = session.createQuery("from UserDetails where userId > " + minUserId);
		
		List<UserDetails> users = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user: users){
			System.out.println(user.getUserName());
		}
	}
	
	public static void sqlInjectibleExample2(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		String minUserId = "5 or 1=1";
		
		session.beginTransaction();
		
		// this may lead to sql query injection.
		Query query = session.createQuery("from UserDetails where userId > " + minUserId);
		
		List<UserDetails> users = query.list();
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails user: users){
			System.out.println(user.getUserName());
		}
	}
	
}
