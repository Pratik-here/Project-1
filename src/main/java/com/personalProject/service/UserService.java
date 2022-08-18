package com.personalProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalProject.entities.User;
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
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	//get user by id
	public Optional<User> getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		
		return user;
	}
	
	//get user by username
		public Optional<User> getUserByUsername(String username) {
			Optional<User> user = userRepository.findByUsername(username);
			
			return user;
		}
		
	
	//delete user by id
	public void deleteUserById(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}

	}
	
	//update user by id
	public User updateUserById(Long id, User newUser) {
		newUser.setId(id);
		return userRepository.save(newUser);
	}
}
