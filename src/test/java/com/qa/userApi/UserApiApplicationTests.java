package com.qa.userApi;

import static org.junit.Assert.assertEquals;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.business.service.UsersServiceImpl;
import com.qa.repository.domain.Users;
import com.qa.repository.persistence.UsersRepository;
import com.qa.util.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApiApplicationTests {

	@Test
	public void contextLoads() {
	}

	@InjectMocks
	private UsersServiceImpl service;

	@Mock
	private UsersRepository repo;

	private Users user1;
	private Users user2;

	@Before
	public void setUp() {
		user1 = new Users();
		user1.setUsername(Constants.EXAMPLE_USERNAME);
		user1.setPassword(Constants.EXAMPLE_PASSWORD);
		user2 = new Users();
	}

	@Test
	public void userTests() {
		Users user = new Users();
		assertEquals(null, user.getUsername());
		assertEquals(null, user.getPassword());
		assertEquals(false, user.getEnabled());
		assertEquals(null, user.getRole());

		user.setUsername(Constants.EXAMPLE_USERNAME);
		user.setPassword(Constants.EXAMPLE_PASSWORD);
		user.setEnabled(true);
		user.setRole(Constants.EXAMPLE_ROLE);

		assertEquals(Constants.EXAMPLE_USERNAME, user.getUsername());
		assertEquals(Constants.EXAMPLE_PASSWORD, user.getPassword());
		assertEquals(true, user.getEnabled());
		assertEquals(Constants.EXAMPLE_ROLE, user.getRole());
	}

	@Test
	public void testDelete() {
		Mockito.when(repo.findById(Constants.EXAMPLE_USERNAME)).thenReturn(Optional.of(user1));
		Mockito.when(repo.findById(Constants.NONEXISTANT_USERNAME)).thenReturn(Optional.empty());

		assertEquals(Constants.ACCOUNT_DELETED_SUCCESSFULLY, service.deleteUser(Constants.EXAMPLE_USERNAME));
		assertEquals(Constants.ACCOUNT_NOT_FOUND, service.deleteUser(Constants.NONEXISTANT_USERNAME));
	}

	@Test
	public void testUpdate() {
		Mockito.when(repo.findById(Constants.EXAMPLE_USERNAME)).thenReturn(Optional.of(user1));
		Mockito.when(repo.findById(Constants.NONEXISTANT_USERNAME)).thenReturn(Optional.empty());

		assertEquals(user1.toString(), service.updateUser(user1));
		assertEquals(Constants.ACCOUNT_NOT_FOUND, service.updateUser(user2));
	}

	@Test
	public void testAdd() {
		user1.setRole(Constants._TRAINEE);
		assertEquals(user1.toString(), service.addUser(user1, Constants._TRAINEE));
	}

}
