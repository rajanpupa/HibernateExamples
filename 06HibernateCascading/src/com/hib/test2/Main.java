package com.hib.test2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("first User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("jeep");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		//session.save(user);
		session.persist(user);
		session.getTransaction().commit();
		
	}
}
