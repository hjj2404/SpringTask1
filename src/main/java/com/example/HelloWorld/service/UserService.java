package com.example.HelloWorld.service;

import com.example.HelloWorld.controllers.bean.User;

public interface UserService {

	User getUserByUserId(String userId);
	
}
