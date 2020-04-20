package com.example.demos;

import com.example.demos.model.Advertisement_video;
import com.example.demos.utils.Config;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
public class AdverVideoTest {

    private Advertisement_video advertisement_video = new Advertisement_video();

    @Test
    public void contextLoad()throws Exception{
        assertTrue("advert video not made", advertisement_video != null);
    }
}