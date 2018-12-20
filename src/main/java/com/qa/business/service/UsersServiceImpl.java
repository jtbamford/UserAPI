package com.qa.business.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.qa.repository.domain.Users;
import com.qa.repository.persistence.UsersRepository;
import com.qa.util.Constants;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository repo;

	@Override
	public String addUser(Users user, String role) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(role);
		repo.save(user);
		return user.toString();
	}

	@Override
	public String deleteUser(String username) {
		if (userExists(username)) {
			repo.deleteById(username);
			return Constants.ACCOUNT_DELETED_SUCCESSFULLY;
		}
		return Constants.ACCOUNT_NOT_FOUND;
	}

	@Override
	public String updateUser(Users user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (userExists(user.getUsername())) {
			Users userInDb = repo.findById(user.getUsername()).get();
			userInDb.setUsername(user.getUsername());
			userInDb.setPassword(passwordEncoder.encode(user.getPassword()));
			userInDb.setEnabled(user.getEnabled());
			userInDb.setRole(user.getRole());
			repo.save(userInDb);
			return user.toString();
		}
		return Constants.ACCOUNT_NOT_FOUND;
	}

	private boolean userExists(String username) {
		Optional<Users> userOptional = repo.findById(username);
		return userOptional.isPresent();
	}

	@Override
	public List<Users> getAllUsers() {
		return repo.findAll();
	}

	@Override
	public String getPasswordByUsername(String username) {
		return repo.findById(username).get().getPassword();
	}

}
