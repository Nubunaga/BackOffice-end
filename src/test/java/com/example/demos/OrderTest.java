package com.example.demos;

import static org.junit.Assert.*;

import java.util.UUID;

import com.example.demos.model.Order;
import com.example.demos.utils.Config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class) 
class OrderTest {

    private Order order = new Order();

    @Test
    public void contextLoad()throws Exception{
        assertTrue("this.order is not made",this.order != null);
    }

    @Test
    public void addOrderTest(){
        int testCedits = 12;
        String testUser = "user";
        String id = (String) UUID.randomUUID().toString();
        this.order.addNewOrder(id, testCedits, testUser);
        assertTrue("Credits is incorrect",this.order.getCredits() == testCedits);
        assertTrue("User is incorrect",this.order.getUser() == testUser);
    }

    @Test
    public void addOrderIllegalArgumentTest(){
        String id = (String) UUID.randomUUID().toString();
        int testCedits = 12;
        String testUser = null;
        try {
            this.order.addNewOrder(id, testCedits, testUser);
        } catch (Exception e) {
            assertTrue("Wrong exception caught", e instanceof IllegalArgumentException);
        }
    }
 
}