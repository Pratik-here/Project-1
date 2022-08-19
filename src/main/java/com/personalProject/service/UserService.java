package com.personalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalProject.entities.User;
import com.personalProject.exceptions.UserExistsException;
import com.personalProject.exceptions.UserNotFoundException;
import com.personalProject.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepository;
	
	//get all users
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//create user
	public User createUser(User user) throws UserExistsException{
		//if user exists using username
		Optional<User> existingUser =  userRepository.findByUsername(user.getUsername());
		
		if(existingUser.isPresent()) {
			throw new UserExistsException("User with username : "+ user.getUsername() + " already exists in database, Choose a different username");
		}
		return userRepository.save(user);
	}
	
	//get user by id
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("No User exists for id : " + id + " in Database");
		}
		
		return user;
	}
	
	//get user by username
		public Optional<User> getUserByUsername(String username) {
			Optional<User> user = userRepository.findByUsername(username);
			
			return user;
		}
		
	
	//delete user by id
	public void deleteUserById(Long id) throws UserNotFoundException {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}else {
			throw new UserNotFoundException("No User exists for id : " + id + " in Database, Provide correct id for deletion");
		}

	}
	
	//update user by id
	public User updateUserById(Long id, User newUser) throws UserNotFoundException {
		
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("No User exists for id : " + id + " in Database, Provide correct id for updation");
		}
		
		
		newUser.setId(id);
		return userRepository.save(newUser);
	}
}
