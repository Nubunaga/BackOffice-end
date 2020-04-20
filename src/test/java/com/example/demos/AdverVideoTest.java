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

    @Test
    public void addVideoTest(){
        int testInterest = 1;
        int testLength = 13;
        String testURL = "url";
        advertisement_video.addNewAdv(testInterest, testLength, testURL);

        assertTrue("Interest is not the same", testInterest == advertisement_video.getInterest());
        assertTrue("length is not the same",testLength == advertisement_video.getLengthSec());
        assertTrue("Url is not the same",testURL == advertisement_video.getUrl());
    }

    @Test
    public void addVideoIllegalArgumentTest(){
        int testInterest = 0;
        int testLength = 13;
        String testURL = "url";

        try {
            advertisement_video.addNewAdv(testInterest, testLength, testURL);
        } catch (Exception e) {
            assertTrue("Wrong Exception caught", e instanceof IllegalArgumentException);
        }
    }
}