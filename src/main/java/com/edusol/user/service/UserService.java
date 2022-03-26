package com.edusol.user.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edusol.user.model.User;
import com.edusol.user.repository.UserRepository;

@Service
public class UserService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
	
	userRepository.save(user);
	logger.info(user.toString());
	return user;
	
	}
	
	public List<User> getUsers(){
		List<User> users = userRepository.findAll();
		logger.info(users.toString());
		return users;
	}
	
	public String updateUser(User user) {
		
		logger.info(user.toString());
		userRepository.save(user);
		
		logger.info("Record Updated Successfully.");
		return "Record Updated Successfully.";
	}
	
	
	public ResponseEntity<String> deleteUser(int id) {
		
			logger.info("Deleting user by id :"+id);
			String message = "";
		try {
			User user = userRepository.getOne(id);
			userRepository.deleteById(id);
			message="Record deleted Successfully."+id;
			logger.info(message);
			
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}catch(Exception e){
			message = "record Not found"+id;
			logger.error("record Not found");
			
			return new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
		}
		
	}

	public List<User> getUsersByCity(String city){
		logger.info("Getting user details by:"+city);
		List<User> users = userRepository.findByCity(city);
		return users;
	}

	public Optional<User> getUsersById(int id) {
		
		return userRepository.findById(id);
		
	}


	public List<User> getUsersByEmail(String email){
		logger.info("Getting user details by:"+email);
		List<User> users = userRepository.findByEmail(email);
		return users;
	}

	

	public ResponseEntity<String> deleteUserByCity(String city) {
		
		logger.info("Deleting user by city :"+city);
		List result;
		String message = "";
		
	try {
		result =userRepository.findByCity(city);
		if (result.isEmpty()) {
				message = "record Not found "+city;
				logger.error("record Not found");
				return new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
				}
		else {
				userRepository.deleteAll(result);
				message="Record deleted Successfully. "+city;
				logger.info(message);
				}
		return new ResponseEntity<String>(message,HttpStatus.OK);	
	}
	catch(Exception e){
		
		message = "record Not found "+city;
		logger.error("record Not found");
		return new ResponseEntity<String>(message,HttpStatus.NOT_FOUND);
	}

	}

	
}
