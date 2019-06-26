package com.hibernate_postgres.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate_postgres.bean.UserBean;
import com.hibernate_postgres.entity.UserEntity;
import com.hibernate_postgres.exceptions.UserAlreadyExists;
import com.hibernate_postgres.exceptions.UserNotFound;

public class UsersDAOImpl implements UsersDAO{

	public void getUser(UserBean user) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(UserEntity.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		UserBean userFetched = null;
		try {
			
			session.beginTransaction();
			
			UserEntity foundUser = session.get(UserEntity.class, user.getId());
			
			session.getTransaction().commit();
			
			if(foundUser!=null) {
				if(foundUser.getPassword().equals(user.getPassword())) {
					userFetched = new UserBean();
					
					userFetched.setId(foundUser.getId());
					userFetched.setPassword(foundUser.getPassword());
					userFetched.setUsername(foundUser.getUsername());
					userFetched.setFirstName(foundUser.getFirstName());
					userFetched.setLastName(foundUser.getLastName());
					userFetched.setGender(user.getGender());
					userFetched.setStatus(foundUser.getStatus());
					
					System.out.println(userFetched);
				} else {
					System.out.println("Password does not match");
				}
			} else {
				throw new UserNotFound("User does not exist");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void createUser(UserBean user) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(UserEntity.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		UserEntity userToCreate = null;
		
		try {
			
			session.beginTransaction();
			
			userToCreate = session.get(UserEntity.class, user.getId());
			
			if(userToCreate == null) {
				userToCreate = new UserEntity();
				userToCreate.setId(user.getId());
				userToCreate.setUsername(user.getUsername());
				userToCreate.setPassword(user.getPassword());
				userToCreate.setFirstName(user.getFirstName());
				userToCreate.setLastName(user.getLastName());
				userToCreate.setGender(user.getGender());
				userToCreate.setStatus(user.getStatus());

				session.save(userToCreate);
				session.getTransaction().commit();
				
				System.out.println("User saved successfully");
			} else {
				throw new UserAlreadyExists("User already exists");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void updateUser(UserBean user, String firstName) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(UserEntity.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		UserEntity userToUpdate = null;
		
		try {
			session.beginTransaction();
			
			userToUpdate = session.get(UserEntity.class, user.getId());
			
			if (userToUpdate != null) {
				userToUpdate.setFirstName(firstName);
				
				session.save(userToUpdate);			
				session.getTransaction().commit();
				
				System.out.println("User updated successfully");
			} else {
				throw new UserNotFound("User does not exists");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteUser(UserBean user) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
											.addAnnotatedClass(UserEntity.class).buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		UserEntity userToDelete = null;
		
		try {
			
			session.beginTransaction();
			
			userToDelete = session.get(UserEntity.class, user.getId());
			
			if(userToDelete != null) {
				session.delete(userToDelete);
				session.getTransaction().commit();
				
				System.out.println("User deleted successfully");
			} else {
				throw new UserNotFound("User does not exists");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
