package com.qa.util;

public class Constants {

	private Constants() {

	}

	public static final String ACCOUNT_DELETED_SUCCESSFULLY = "User successfully deleted";
	public static final String ACCOUNT_NOT_FOUND = "User not found";

	public static final String URL_BASE = "/users";
	public static final String DELETE_URL = "/deleteUser/{username}";
	public static final String UPDATE_URL = "/updateUser";
	public static final String CREATE_BASE = "/createUser/";
	public static final String GET_ALL_URL = "/getAllUsers";
	public static final String GET_PASSWORD_URL = "/getPassword/{username}";
	public static final String _TRAINEE = "ROLE_TRAINEE";
	public static final String _TRAINER = "ROLE_TRAINER";
	public static final String _TRAINING_MANAGER = "ROLE_TRAINING_MANAGER";

	// Testing
	public static final String EXAMPLE_USERNAME = "user1";
	public static final String NONEXISTANT_USERNAME = "user2";
	public static final String EXAMPLE_PASSWORD = "password";
	public static final String EXAMPLE_ROLE = "ROLE_ADMIN";

}
