package com.foodscribe.service.implementation;

import java.util.Set;

import com.foodscribe.domain.User;
import com.foodscribe.domain.security.UserRole;



public interface UserService {
	User createUser(User user, Set<UserRole> userRoles);

	User findByUsername(String username);

	User findByEmail(String userEmail);
	
	User save(User user);
	
	User findById(Long userId);
	
}
