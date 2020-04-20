package com.example.demos;

import static org.junit.Assert.*;

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
        int testId = 1;
        int testCedits = 12;
        String testUser = "user";

        this.order.addNewOrder(testId, testCedits, testUser);
        assertTrue("Id is incorrect",this.order.getID() == testId);
        assertTrue("Credits is incorrect",this.order.getCredits() == testCedits);
        assertTrue("User is incorrect",this.order.getUser() == testUser);
    }

    @Test
    public void addOrderIllegalArgumentTest(){
        int testId = 1;
        int testCedits = 12;
        String testUser = null;
        try {
            this.order.addNewOrder(testId, testCedits, testUser);
        } catch (Exception e) {
            assertTrue("Wrong exception caught", e instanceof IllegalArgumentException);
        }
    }
 
}