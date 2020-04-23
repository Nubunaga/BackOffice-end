package com.example.demos;

import com.example.demos.controller.ControllerOrder;
import com.example.demos.model.JsonHandler;
import com.example.demos.model.OrderHistory;
import com.example.demos.repository.OrderRepository;
import com.example.demos.utils.Config;

import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
@WebMvcTest(controllers = ControllerOrder.class)
public class ControllerOrderTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderRepository orderrep;
    @MockBean
    private JsonHandler jsonHandler;
    @MockBean
    private OrderHistory orderHistory;



    @Test
    public void addOrderTest()throws Exception{

    }
}