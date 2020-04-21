package com.example.demos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

import com.example.demos.dto.OrderHistoryDTO;
import com.example.demos.model.OrderHistory;
import com.example.demos.utils.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class) 
@SpringBootTest
public class OrderHistoryTest {

    @Autowired
    OrderHistory orderHistory;
    
    @Test
    public void contextLoad()throws Exception{
        assertTrue("OrderHistory is not created correctly",orderHistory != null);
    }


    @Test
    public void getOrderHistoryTest(){
        assertTrue("There is no orderhistory returning", orderHistory.getHistory("Netanel") != null);
    }

    @Test
    public void getOrderHistoryNoUserTest(){
        assertTrue("There is no orderhistory returning", orderHistory.getHistory("Netanel1234") == null);
    }


    @Test
    public void orderHistoryInformationTest(){
        OrderHistoryDTO oDTO = orderHistory.getHistory("Netanel").get(0);
        assertTrue("All information is found!", oDTO.getUser() == "Netanel");
    }


    @Test
    public void orderHistoryDateTest(){
        
        OrderHistoryDTO oDTO = orderHistory.getHistory("Netanel").get(0);
        assertTrue("A orderHistory is not in epoch time", oDTO.getStartDate().contains("-") && oDTO.getEndDate().contains("-"));
    }

}
