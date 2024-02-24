package com.shubam.Expence_Tracker.serviceInterfaceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubam.Expence_Tracker.entity.User;
import com.shubam.Expence_Tracker.exception.UserException;
import com.shubam.Expence_Tracker.model.UserInputModel;
import com.shubam.Expence_Tracker.model.UserLoginInputModel;
import com.shubam.Expence_Tracker.repository.UserRepository;
import com.shubam.Expence_Tracker.serviceInterface.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	UserRepository userRepository;

	
	@Transactional
	public User addUser(UserInputModel userInputModel) throws UserException {
		if(userRepository.findByEmailId(userInputModel.getEmailId())) {
			throw new UserException("This EmailId is already used");
		}
		if(userRepository.findByPhoneNumber(userInputModel.getPhoneNumber())) {
			throw new UserException("This Phone Number is already used");
		}
		else {
			User user = new User();
			user.setEmailId(userInputModel.getEmailId());
			user.setExpenseLimit(userInputModel.getExpenseLimit());
			user.setName(userInputModel.getName());
			user.setPassword(userInputModel.getPassword());
			user.setPhoneNumber(userInputModel.getPhoneNumber());
			
			userRepository.save(user);
			return user;
		}
		
	}

	@Transactional
	public User userLogin(UserLoginInputModel userLoginInputModel) throws UserException {
		String emailId = userLoginInputModel.getEmailId();
		String password = userLoginInputModel.getPassword();
		User user = userRepository.userLogin(emailId, password);
		if(user!=null) {
			return user;
		}
		throw new UserException("Invalid EmailId or Password");
	}

	@Transactional
	public User getUserByEmailId(String emailId) throws UserException {
		User user = userRepository.findById(emailId).orElse(null);
		if(user!=null) {
			return user;
		}
		throw new UserException("User Not Found");
	}

	@Override
	@Transactional
	public Double getUserExpenseLimitByEmailId(String emailId) throws UserException {
		User user = getUserByEmailId(emailId);
		return user.getExpenseLimit();
	}
	
	

}
