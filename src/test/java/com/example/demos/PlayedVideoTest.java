package com.example.demos;

import com.example.demos.model.PlayedVideo;
import com.example.demos.repository.PlayedVideoRepository;
import com.example.demos.utils.Config;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
@SpringBootTest
public class PlayedVideoTest {
    @MockBean
    PlayedVideoRepository playedVideoRepository;
    
    @Autowired
    PlayedVideo playedVideo;



    @Test
    public void contextLoad() throws Exception{
        assertTrue("The played test class is not created", playedVideo != null);
    }


}