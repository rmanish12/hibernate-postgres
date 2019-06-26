package com.hibernate_postgres.dao;

import com.hibernate_postgres.bean.UserBean;

public interface UsersDAO {
	
	public void getUser(UserBean user) throws Exception;
	public void createUser(UserBean user) throws Exception;
	public void updateUser(UserBean user, String firstName) throws Exception;
	public void deleteUser(UserBean user) throws Exception;
	
}
