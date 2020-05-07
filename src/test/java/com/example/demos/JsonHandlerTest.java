package com.example.demos;

import com.example.demos.Security.JWTDecoder;
import com.example.demos.exceptions.NoVideoException;
import com.example.demos.model.*;
import com.example.demos.utils.Config;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;



@ContextConfiguration(classes = Config.class) 
@SpringBootTest
public class JsonHandlerTest {
    @Autowired
    JsonHandler jsonHandler;

    @MockBean
    private JWTDecoder jwtDecoder;
    
    String json = "{\"id\":9999,\"user\":\"Netanel\",\"credits\":10,\"video\":" + "[{\"interest\":Sport,\"length\":9999,\"url\":\"URL\"}],"
            + "\"Startdate\":\"2020-04-17T00:03:14.100z\"," + "\"Enddate\":\"2020-06-17T00:03:14.100z\"}";

    String jsonNoVideo = "{\"id\":9999,\"user\":\"Netanel\",\"credits\":10,\"video\":" + "[],"
            + "\"Startdate\":\"2020-04-17T00:03:14.100z\"," + "\"Enddate\":\"2020-06-17T00:03:14.100z\"}";

    
    @Test
    public void contextLoad() throws Exception {
        assertTrue("Jsonhandler object is not made", jsonHandler != null);
    }


    @Test
    public void newVideoAddTest(){
        try {
            assertTrue("A new video order does not work on standalone", jsonHandler.addNewVideo(json).contains("Saved"));
        } catch (Exception e) {
            assertFalse("Something went wrong", true);
        }
    }


    @Test
    public void newVideoNoVideoTest(){
        try {
            jsonHandler.addNewVideo(jsonNoVideo);
        } catch (Exception e) {
            assertTrue("It does not work", e instanceof NoVideoException);
        }
    }



}