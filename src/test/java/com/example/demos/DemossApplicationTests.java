package com.example.demos;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class DemossApplicationTests {

	@Test
	void contextLoads() {
		final User n = new User();
		n.setName("netanel");
		n.setEmail("test@test.com");
		assertEquals("The message is not the same", "netanel", n.getName());
		assertEquals("The message is not the same", "test@test.com", n.getEmail());
	}

}
