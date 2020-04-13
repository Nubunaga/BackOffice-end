package com.example.demos;

import com.example.demos.db.Users;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
class DemossApplicationTests {
	private Users users;
	@Test
	void contextLoads() {
		users = new Users();
		users.setnewUser("Netanel", "mail@mail.com", "123");
		
		assertTrue("The name is not correct", "Netanel" == users.getName());
		assertTrue("The email is not correct", "mail@mail.com" ==users.getEmail());
		assertTrue("The pass is not correct", "123" == users.getPassword());
	}
}
