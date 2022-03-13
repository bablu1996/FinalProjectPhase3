package com.example.SportyShoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SportyShoes.entities.User;
import com.example.SportyShoes.services.UserService;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	/*

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String welcomePage(ModelMap model) {
    	return showLogin(model);
    }
    */
    @RequestMapping(value="/mainpage", method = RequestMethod.GET)
    public String showLogin(ModelMap model)
    {
    	model.addAttribute("message", "Welcome!");
    	return("mainpage");
    }
    
    @RequestMapping(value="/mainpage", method = RequestMethod.POST)
    public String handleLogin(
    		@RequestParam(value = "username", required = true) String username,
    		

    		ModelMap model) { 
    	
    	User user;
    	try {
    	
    		
    		user = userService.GetUserByName(username);
    		
    		
    	}
    	catch(Exception ex) {
    		model.addAttribute("details", "ERROR 404");
    		model.addAttribute("message", "User Not found");
    		return("mainpage");
    	}
    	/*
    	
    	if (userService.ConfirmUserPassword(user, password)) {
    		//TODO: Check user and password
    		//model.addAttribute("user", user);
    		model.addAttribute("message", "Login Successful!");
    		return("mainpage");
    	}*/
    	
    		String userdetails = user.getName()+" "+user.getEmail();
    		
    		model.addAttribute("details", "The Users Name and Email of searched User is ");
    		model.addAttribute("message", userdetails);
    		return("mainpage");
    		
    		
    		
    	
    }

}
