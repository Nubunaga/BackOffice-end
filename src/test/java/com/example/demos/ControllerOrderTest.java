package com.example.demos;

import com.example.demos.controller.ControllerOrder;
import com.example.demos.model.JsonHandler;
import com.example.demos.model.OrderHistory;
import com.example.demos.repository.OrderRepository;
import com.example.demos.utils.Config;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
@WebMvcTest(controllers = ControllerOrder.class)
@AutoConfigureMockMvc
public class ControllerOrderTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderRepository orderrep;
    @MockBean
    private JsonHandler jsonHandler;
    @MockBean
    private OrderHistory orderHistory;
    
    @Before
    public void setut(){
        this.mockMvc = standaloneSetup(new DemossApplication()).build();
    }


    @Test
    public void addOrderTest()throws Exception{
        ResultMatcher created = MockMvcResultMatchers.status().isCreated();

        String json = "{\"id\":9999,\"user\":\"Netanel\",\"credits\":10,\"video\":" + "[{\"interest\":9999,\"length\":9999,\"url\":\"URL\"}],"
        + "\"Startdate\":\"2020-04-17T00:03:14.100z\"," + "\"Enddate\":\"2020-06-17T00:03:14.100z\"}";

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/order/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json);

        this.mockMvc.perform(builder)
        .andExpect(created);
    }


    @Test
    public void addOrderFailTest()throws Exception{
        ResultMatcher created = MockMvcResultMatchers.status().isBadRequest();

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/order/add")
        .contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(builder)
        .andExpect(created);
    }


    @Test
    public void getHistoryTest() throws Exception {
        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
        ResultMatcher result = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);


        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/order/history")
        .param("userName", "Netanel");

        this.mockMvc.perform(builder)
        .andExpect(ok)
        .andExpect(result);
    }

}