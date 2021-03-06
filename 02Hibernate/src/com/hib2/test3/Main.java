package com.hib2.test3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// change the hibernate.cfg.xml before executing
public class Main {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		
		user.setUserName("first User");
		
		Address add1 = new Address("1000N 4th st", "fairfield", "IA", "52556");
		Address add2 = new Address("1000N 5th st", "fairfield", "IA", "52557");
		
		user.getListOfAddresses().add(add1);
		user.getListOfAddresses().add(add2);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		try{
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			
		}catch(Exception e){
			
		}finally{
			session.close();
		}
		
		user = null;
		// reading
		try{
			session = factory.openSession();
			user = session.get(UserDetails.class, 1);
			// does the whole list of addresses gets pulled up?, initialization = eager, lazy(default)
			session.close();
			System.out.println(user.getListOfAddresses().size() ); // hibernate fetches now
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//session.close();
		}
	}
}
