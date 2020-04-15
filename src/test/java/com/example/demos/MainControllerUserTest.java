package com.example.demos;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import static org.junit.Assert.assertTrue;
import com.example.demos.controller.MainControllerUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demos.model.*;

@SpringBootTest
public class MainControllerUserTest {

    @Autowired
    private MainControllerUser main = new MainControllerUser();

    @Test
    public void contextLoads() throws Exception{
        assertThat(main).isNotNull();
    }

    @Test
    public void addTest(){
       String response = main.addNewUser("name", "email", "password");
       assertTrue("Add is not working", response == "Saved");
    }

    @Test
    public void removeTest(){
       String response = main.removeUser("name");
       assertTrue("Add is not working", response == "Saved");
    }


    @Test
    public void findUser(){
       Optional<Users> response = main.getUser("name");
       assertTrue("Not a valied class is returned", response != null);
    }



}