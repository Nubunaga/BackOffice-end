package com.example.demos;

import com.example.demos.db.Users;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = Users.class)
@SpringBootTest
class UserTest {
	@Autowired
	private Users users = new Users();

	@Test
	public void contexLoads() throws Exception {
		assertThat(users).isNotNull();
	}

	@Test
	void nameTest() {
		users.setnewUser("Netanel", "mail@mail.com", "123");
		assertTrue("The name is not correct", "Netanel" == users.getName());
	}
	@Test
	void emailTest() {
		users.setnewUser("Netanel", "mail@mail.com", "123");
		assertTrue("The name is not correct", "mail@mail.com" == users.getEmail());
	}
	@Test
	void passTest() {
		users.setnewUser("Netanel", "mail@mail.com", "123");
		assertTrue("The name is not correct", "123" == users.getPassword());
	}
}
