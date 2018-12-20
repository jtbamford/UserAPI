package com.qa.business.service;

import java.util.List;

import com.qa.repository.domain.Users;

public interface UsersService {

	String addUser(Users user, String role);

    String deleteUser(String username);

    String updateUser(Users user);

	List<Users> getAllUsers();

	String getPasswordByUsername(String username);
   
}
