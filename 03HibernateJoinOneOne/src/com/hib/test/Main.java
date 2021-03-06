package com.hib.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("first User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		
		user.setVehicle(vehicle);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		session.save(user);
	    session.save(vehicle);
		
		session.getTransaction().commit();
		
	}
}
