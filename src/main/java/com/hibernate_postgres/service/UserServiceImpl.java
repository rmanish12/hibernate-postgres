package com.hibernate_postgres.service;

import org.apache.log4j.Logger;

import com.hibernate_postgres.bean.UserBean;
import com.hibernate_postgres.dao.UsersDAO;
import com.hibernate_postgres.dao.UsersDAOImpl;

public class UserServiceImpl implements UserService{

	static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	UsersDAO userdao = new UsersDAOImpl();
	
	public void getUser(UserBean user){
		try {					
			userdao.getUser(user);			
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
	}

	public void createUser(UserBean user) {
		try {
			userdao.createUser(user);		
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}		
	}

	public void updateUser(UserBean user, String firstName) {
		try {
			userdao.updateUser(user, firstName);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
	}

	public void deleteUser(UserBean user) {
		try {
			userdao.deleteUser(user);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}		
	}
	
}
