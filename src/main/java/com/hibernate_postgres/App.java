package com.hibernate_postgres;

import com.hibernate_postgres.bean.UserBean;
import com.hibernate_postgres.service.UserService;
import com.hibernate_postgres.service.UserServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
    	UserBean user = new UserBean();
    	UserService userService = new UserServiceImpl();
    	
    	//GET
    	user.setId(102);
    	user.setUsername("rogers63");
    	user.setPassword("e6a33eee180b07e563d74fee8c2c66b8");
    	
    	userService.getUser(user);
    	
    	//POST
//    	user.setId(101);
//    	user.setUsername("rogers63");
//    	user.setPassword("e6a33eee180b07e563d74fee8c2c66b8");
//    	user.setFirstName("David");
//    	user.setLastName("John");
//    	user.setGender("Female");
//    	user.setStatus(1);
//    	
//    	userService.createUser(user);
//    	
    	//UPDATE
//    	user.setId(101);
//    	String firstName = "Michael";
//    	userService.updateUser(user, firstName); 
    	
    	//DELETE
//    	user.setId(101);
//    	userService.deleteUser(user);
    }
}
