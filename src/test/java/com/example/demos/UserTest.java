package com.example.demos;


import com.example.demos.model.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;

class UserTest {
	@Autowired
	//private MainControllerUser main = new MainControllerUser();
	private Users users;

	@Before
	void setup(){
		users = new Users();
	}
	
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

	@Test
	void setnewUserTest(){
		users.setnewUser("name", "mail", "pass");
		assertTrue("Not adding correct", testName(users.getName()) && testMail(users.getEmail()) && testPass(users.getPassword()));
	}


	@Test
	void illegalArguemntTest(){
		try {
			users.setnewUser(null, "mail", "pass");
		} catch (Exception e) {
			assertTrue("Not correct", e instanceof IllegalArgumentException);
		}
	}

	private boolean testName(String name){
		return name == "name";
	}

	private boolean testMail(String mail){
		return mail == "mail";
	}

	private boolean testPass(String pass){
		return pass == "pass";
	}

}
