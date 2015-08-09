package com.hib.test;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		//createExample();
		
//		hqlExample();
//		hqlExample2();
		
		// not working properly
		hqlExample3();
	}
	
	public static void hqlExample(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from UserDetails");
		//Query query = session.createQuery("select userName from UserDetails");// this will return list of String not userDetails
		query.setFirstResult(2);
		query.setMaxResults(3);
		
		List<UserDetails> users =(List<UserDetails>) query.list();
		
		session.getTransaction().commit();
		session.close();

		for(UserDetails u : users){
			System.out.println(u.getUserName());
			
		}
	}
	
	public static void hqlExample2 (){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Query query = session.createQuery("from UserDetails");
		// this will return list of String not userDetails
		Query query = session.createQuery("select userName from UserDetails");
		query.setFirstResult(2);
		query.setMaxResults(3);
		
		List<String> users =(List<String>) query.list();
		
		session.getTransaction().commit();
		session.close();

		for(String u : users){
			System.out.println(u);
			
		}
	}
	
	public static void hqlExample3 (){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Query query = session.createQuery("from UserDetails");
		// this will return list of String not userDetails
		Query query = session.createQuery("select new map(userId, userName) from UserDetails");
		query.setFirstResult(2);
		query.setMaxResults(3);
		
		List<Map<Integer, String>> users = query.list();
		
		session.getTransaction().commit();
		session.close();

		for(Map<String, String> u : users){
			for(String i : u.keySet()){
				System.out.println(i + "=> " 
						+ u.get(Integer.parseInt(i) ));
			}
			
		}
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
