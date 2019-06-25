package com.hibernate_postgres;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
    										.addAnnotatedClass(Users.class). buildSessionFactory();
    	
    	Session session = sessionFactory.getCurrentSession();
    	
    	int id = 1;
    	
    	try {
			
    		session.beginTransaction();
    		Users user = session.get(Users.class, id);
    		session.getTransaction().commit();
    		
    		if(user!=null) {
    			System.out.println(user);
    		}
    		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
