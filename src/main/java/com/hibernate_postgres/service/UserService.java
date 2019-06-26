package com.hibernate_postgres.service;

import com.hibernate_postgres.bean.UserBean;

public interface UserService {
	
	public void getUser(UserBean user);
	public void createUser(UserBean user);
	public void updateUser(UserBean user, String firstName);
	public void deleteUser(UserBean user);
	
}
