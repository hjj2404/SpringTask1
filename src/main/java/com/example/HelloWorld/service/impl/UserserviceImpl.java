package com.example.HelloWorld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HelloWorld.controllers.bean.User;
import com.example.HelloWorld.dao.UserDao;
import com.example.HelloWorld.service.UserService;

@Service
public class UserserviceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	
	@Override
	public User getUserByUserId(String userId) {
		User user= userDao.getUserById(userId);
		return user;
	}
	
	

}
