package com.example.demos;

import com.example.demos.controller.ControllerAdvertisment;
import com.example.demos.repository.AdvertismentRepository;
import com.example.demos.utils.Config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
@WebMvcTest(controllers = ControllerAdvertisment.class)
public class ControllerAdvertismentTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdvertismentRepository advertismentRepository;


    @Test
    public void addVideoTest() throws Exception{
        ResultMatcher code = MockMvcResultMatchers.status().isCreated();
        ResultMatcher returnRes = MockMvcResultMatchers.content().string("Saved");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/advert/add")
        .param("url", "Url")
        .param("interest","10")
        .param("time", "1");

        this.mockMvc.perform(builder)
        .andExpect(code)
        .andExpect(returnRes);
    }


    @Test
    public void removeAddTest() throws Exception{
        ResultMatcher code = MockMvcResultMatchers.status().isNoContent();
        ResultMatcher returnRes = MockMvcResultMatchers.content().string("Video deleted");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/advert/delete")
        .param("id", "6");

        this.mockMvc.perform(builder)
        .andExpect(code)
        .andExpect(returnRes);
    }


    @Test
    public void invalidInputTest() throws Exception{
        ResultMatcher code = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher code2 = MockMvcResultMatchers.status().isMethodNotAllowed();


        MockHttpServletRequestBuilder builder1 = MockMvcRequestBuilders.get("/advert/delete");
        MockHttpServletRequestBuilder builder2 = MockMvcRequestBuilders.put("/advert/add");


        this.mockMvc.perform(builder1)
        .andExpect(code);

        this.mockMvc.perform(builder2)
        .andExpect(code2);
    }

}