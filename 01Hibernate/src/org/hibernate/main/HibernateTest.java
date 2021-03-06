package org.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.kaushik.dto.Address;
import org.javabrains.kaushik.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		//create and set the model
		UserDetails user = new UserDetails();
		Address addr = new Address();
		
		//user.setUserId(1);
		user.setUserName("first user");
		user.setJoinedDate(new Date());
		user.setFlag(true);
		user.setFullName("rajan upadhyay");
		
		addr.setStreet("1000N 4th street");
		addr.setCity("fairfield");
		addr.setState("IA");
		addr.setZip("52556");
		
		user.setHomeAddress(addr);
		
		//get the session factory
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//create session
		Session session = sessionFactory.openSession();

		//transaction when saving sessioin
		session.beginTransaction();
		session.save(user);
		
		// if name is updated before commit, it is updated in the db as well
		user.setUserName("rajan upadhyay");
		
		session.getTransaction().commit();
		
		// normally , should be in a finally block
		session.close();
		
		user = null;
		
		UserDetails user2 = new UserDetails();
		user2.setFullName("sajan ");
		
		// start a second session.
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user2);
		user = session.get(UserDetails.class, 1);
		System.out.println("user name retrived is : " + user.getUserName());
		
		session.close();
	}
}
