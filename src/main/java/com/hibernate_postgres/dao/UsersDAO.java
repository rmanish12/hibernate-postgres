package com.hibernate_postgres.dao;

import com.hibernate_postgres.bean.UserBean;

public interface UsersDAO {
	
	public void getUser(UserBean user);
	public void createUser(UserBean user);
	public void updateUser(UserBean user, String firstName);
	public void deleteUser(UserBean user);
	
}
