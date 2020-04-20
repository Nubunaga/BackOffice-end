package com.example.demos;

import com.example.demos.model.JsonHandler;
import com.example.demos.utils.Config;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
public class JsonHandlerTest {
    JsonHandler jsonHandler = new JsonHandler(); 

    @Test
    public void contextLoad()throws Exception{
        assertTrue("Jsonhandler object is not made", jsonHandler != null);
    }


    @Test
    public void newOrderTest(){
    
    }
}