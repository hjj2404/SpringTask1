package com.example.HelloWorld.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.HelloWorld.controllers.bean.User;
import com.example.HelloWorld.service.UserService;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	
	@Autowired
	UserService userService;
/*
	@RequestMapping("/welcome.html")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	*/
	
  @RequestMapping(value="/welcome", method = RequestMethod.GET)
//	@RequestMapping("/welcome")
		public String WelcomePage() {
			return "welcome";
		}
	
	
	
	@RequestMapping(value="/welcome", method = RequestMethod.POST)
	public String loginPage(ModelMap model,@RequestParam String userid, @RequestParam String password) {
		User user=userService.getUserByUserId(userid);
		System.out.print(user);
	
		if(user.getPassword().equals(password)) {
			model.put("userid",userid);
			return "success";
		}
		//model.put("errorMsg", "Please provide correct credentials");
		return "welcome";
	}
}
