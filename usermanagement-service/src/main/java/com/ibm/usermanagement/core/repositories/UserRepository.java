package com.ibm.usermanagement.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.usermanagement.core.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

	public long countByEmail(String email);

	@Query("select u.email from User u where u.username = ?1")
	String findEmailByUsername(String username);
}