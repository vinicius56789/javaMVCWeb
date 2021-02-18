package com.everis.mvc.bmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.mvc.bmt.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	User findByUsername(String username);

}
