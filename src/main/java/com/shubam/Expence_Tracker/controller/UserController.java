package com.shubam.Expence_Tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubam.Expence_Tracker.entity.User;
import com.shubam.Expence_Tracker.exception.UserException;
import com.shubam.Expence_Tracker.model.UserInputModel;
import com.shubam.Expence_Tracker.model.UserLoginInputModel;
import com.shubam.Expence_Tracker.serviceInterfaceImplementation.UserServiceImplementation;

@RestController
public class UserController {

	@Autowired
	UserServiceImplementation userServiceImplementation;
	
	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody UserInputModel userInputModel) throws UserException{
		User user = userServiceImplementation.addUser(userInputModel);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PostMapping("/userlogin")
	public ResponseEntity<User> userLogin(@RequestBody UserLoginInputModel userLoginInputModel) throws UserException{
		User user = userServiceImplementation.userLogin(userLoginInputModel);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/getuserbyemailid/{emailId}")
	public ResponseEntity<User> getUserByEmailId(@PathVariable String emailId) throws UserException{
		User user = userServiceImplementation.getUserByEmailId(emailId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
