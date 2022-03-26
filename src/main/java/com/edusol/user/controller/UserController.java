package com.edusol.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edusol.user.model.User;
import com.edusol.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		
		return new ResponseEntity<User> (userService.addUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		
		return new ResponseEntity<List<User>> ( userService.getUsers(), HttpStatus.OK);
		
	}
	
	
	@PutMapping
	public String updateUser(@RequestBody User user) {
		
		return userService.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) {
		
		return userService.deleteUser(id);
		
	}
	
	
	
	@GetMapping("/{city}")
	public List<User> getUsersByCity(@PathVariable String city){
		
		return userService.getUsersByCity(city);
		
	}
	
	@GetMapping("/id/{id}")
	public Optional<User> getUsersById(@PathVariable int id){
		
		return userService.getUsersById(id);
		
	}
	
	
	@GetMapping("/email/{email}")
	public List<User> getUsersByEmail(@PathVariable String email){
		
		return userService.getUsersByEmail(email);
		
	}
	
	@DeleteMapping("/delete-city/{city}")
	public ResponseEntity<String> deleteUserByCity(@PathVariable String city) {
		
		return userService.deleteUserByCity(city);
	}
	
}
	
