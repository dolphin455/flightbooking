package com.flight.booking.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flight.booking.user.entity.User;
import com.flight.booking.user.service.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl service;


	@RequestMapping("/addUser")
	public String showRegistrationPage() {
		return "userReg";
	}

	@RequestMapping(value ="save-user", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, ModelMap model) {
		user.setTypeId(2);
		int result=service.save(user);
		model.addAttribute("result","user created with ID:"+result);
		return "userReg";
	}
	
	@RequestMapping("/getUsers")
	public String getUsers(ModelMap model) {
		List<User> users = service.getUsers();
		model.addAttribute("userList", users);
		return "displayUsers";
	}

}
