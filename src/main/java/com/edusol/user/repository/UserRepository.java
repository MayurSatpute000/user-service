package com.edusol.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusol.user.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByCity(String city);
	List<User> findByEmail(String email);
	long deleteAllByCity(String city);
	
	
}
