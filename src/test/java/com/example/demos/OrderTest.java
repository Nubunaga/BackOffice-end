package com.example.demos;

import static org.junit.Assert.assertFalse;

import com.example.demos.model.Order;
import com.example.demos.utils.Config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@Import(Config.class)
public class OrderTest {

    private Order order = new Order();

    @Test
    public void load()throws Exception{
        assertFalse("Test", true);
    }
    
}