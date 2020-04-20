package com.example.demos;

import com.example.demos.model.*;
import com.example.demos.utils.Config;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class) 
@SpringBootTest
public class JsonHandlerTest {
    @Autowired
    JsonHandler jsonHandler;
    
    String json = "{\"id\":9999,\"user\":\"Netanel\",\"credits\":10,\"video\":" + "[{\"interest\":9999,\"length\":9999,\"url\":\"URL\"}],"
            + "\"Startdate\":\"2020-04-17T00:03:14.100z\"," + "\"Enddate\":\"2020-06-17T00:03:14.100z\"}";

    String jsonNoVideo = "{\"id\":9999,\"user\":\"Netanel\",\"credits\":10,\"video\":" + "[],"
            + "\"Startdate\":\"2020-04-17T00:03:14.100z\"," + "\"Enddate\":\"2020-06-17T00:03:14.100z\"}";

    
    @Test
    public void contextLoad() throws Exception {
        assertTrue("Jsonhandler object is not made", jsonHandler != null);
    }

    @Test
    public void newOrderTest() {
        try {
            assertTrue("An order is not returned", jsonHandler.newOrder(json) != null);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void voidCorrectInfoTest(){
        try {
            Order order =jsonHandler.newOrder(json);
            assertEquals("Order: [ OrderId: 9999, credits: 10, user: Netanel ]", order.toString());
        } catch (Exception e) {
            System.out.print(e);
            assertFalse("Something went wrong", true);
        }
    }

    @Test
    public void newOrderNullTest(){
        try {
            assertTrue("An order is not returned", jsonHandler.newOrder(json) != null);
        } catch (Exception e) {
            assertTrue("There is not a correct exception thrown", e instanceof IllegalArgumentException);
        }
    }

    @Test
    public void newOrderNoVideo(){
        try {
            assertTrue("An order is not returned", jsonHandler.newOrder(json) != null);
        } catch (Exception e) {
            assertFalse("Something went wrong", true);
        }
    }



}