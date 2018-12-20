package com.qa.repository.domain;

import java.util.ArrayList;
import java.util.List;

public class UsersList {
	
	private List<Users> allUsers;
		
	public List<Users> getAllUsers() {
			return allUsers;
	}

	public void setAllUsers(List<Users> allUsers) {
			this.allUsers = allUsers;
	}

	public UsersList() {
		allUsers = new ArrayList<>(); 
	}

}
