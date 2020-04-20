package com.example.demos;

import com.example.demos.model.*;
import com.example.demos.utils.Config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class) 
class UserTest {
	
	
	private Users users = new Users();

	@Test
	public void contexLoads() throws Exception {
		assertThat(this.users).isNotNull();
	}

	@Test
	void nameTest() {
		this.users.setnewUser("Netanel", "mail@mail.com", "123");
		assertTrue("The name is not correct", "Netanel" == this.users.getName());
	}
	@Test
	void emailTest() {
		this.users.setnewUser("Netanel", "mail@mail.com", "123");
		assertTrue("The name is not correct", "mail@mail.com" == this.users.getEmail());
	}
	@Test
	void passTest() {
		this.users.setnewUser("Netanel", "mail@mail.com", "123");
		assertTrue("The name is not correct", "123" == users.getPassword());
	}

	@Test
	void setnewUserTest(){
		this.users.setnewUser("name", "mail", "pass");
		assertTrue("Not adding correct", testName(this.users.getName()) && testMail(this.users.getEmail()) && testPass(this.users.getPassword()));
	}


	@Test
	void illegalArguemntTest(){
		try {
			this.users.setnewUser(null, "mail", "pass");
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
