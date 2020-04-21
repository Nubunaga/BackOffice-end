package com.example.demos;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

import com.example.demos.dto.OrderHistoryDTO;
import com.example.demos.exceptions.NoUserFoundException;
import com.example.demos.model.OrderHistory;
import com.example.demos.utils.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
@SpringBootTest
public class OrderHistoryTest {

    @Autowired
    OrderHistory orderHistory;

    @Test
    public void contextLoad() throws Exception {
        assertTrue("OrderHistory is not created correctly", orderHistory != null);
    }

    @Test
    public void getOrderHistoryTest() {
        try {
            assertTrue("There is no orderhistory returning", orderHistory.getHistory("Netanel") != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getOrderHistoryNoUserTest() {
        try {
            assertTrue("There is no orderhistory returning", orderHistory.getHistory("Netanel1234") == null);
        } catch (Exception e) {
            assertTrue("Not correct exception",e instanceof NoUserFoundException);
            assertTrue("Right userName", e.getMessage().contains("Netanel1234"));
        }
    }

    @Test
    public void orderHistoryInformationTest() {
        OrderHistoryDTO oDTO;
        try {
            oDTO = orderHistory.getHistory("Netanel").get(1);
            assertTrue("information is not found!", oDTO.getUser().contains("Netanel"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void orderHistoryDateTest() {

        OrderHistoryDTO oDTO;
        try {
            oDTO = orderHistory.getHistory("Netanel").get(1);
            assertTrue("A orderHistory is not in epoch time", oDTO.getStartDate().contains("-") && oDTO.getEndDate().contains("-"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
