package com.shubam.Expence_Tracker.serviceInterface;

import org.springframework.stereotype.Service;

import com.shubam.Expence_Tracker.entity.User;
import com.shubam.Expence_Tracker.exception.UserException;
import com.shubam.Expence_Tracker.model.UserInputModel;
import com.shubam.Expence_Tracker.model.UserLoginInputModel;

@Service
public interface UserService {

	public User addUser(UserInputModel userInputModel) throws UserException;
	
	public User userLogin(UserLoginInputModel userLoginInputModel) throws UserException;
	
	public User getUserByEmailId(String emailId) throws UserException;
	
	public Double getUserExpenseLimitByEmailId(String emailId) throws UserException;
}
