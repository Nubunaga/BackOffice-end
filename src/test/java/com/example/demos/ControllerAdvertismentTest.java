package com.example.demos;

import com.example.demos.Security.JWTDecoder;
import com.example.demos.model.JsonHandler;
import com.example.demos.repository.AdvertismentRepository;
import com.example.demos.utils.Config;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ContextConfiguration(classes = Config.class)
@AutoConfigureMockMvc
public class ControllerAdvertismentTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdvertismentRepository advertismentRepository;

    @MockBean
    private JsonHandler jsonHandler;

    @MockBean
    private JWTDecoder jwtDecoder;


    @Test
    public void addVideoTest() throws Exception{
        ResultMatcher code = MockMvcResultMatchers.status().isCreated();
        String json = "{\"id\":9999,\"user\":\"Netanel\",\"credits\":10,\"video\":" + "[{\"interest\":9999,\"length\":9999,\"url\":\"URL\"}],"
        + "\"Startdate\":\"2020-04-17T00:03:14.100z\"," + "\"Enddate\":\"2020-06-17T00:03:14.100z\"}";
        
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/advert/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json)
        .header("Auth-Token", "Testing");

        this.mockMvc.perform(builder)
        .andExpect(code);
    }


    @Test
    public void removeAddTest() throws Exception{
        ResultMatcher code = MockMvcResultMatchers.status().isNoContent();
        ResultMatcher returnRes = MockMvcResultMatchers.content().string("Video deleted");

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/advert/delete")
        .param("id", "6")
        .header("Auth-Token", "Testing");

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