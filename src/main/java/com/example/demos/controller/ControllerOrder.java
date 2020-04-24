/*
      * JSON Structure:
     * { OrderId: "1",
     *   UserName: "SolStrom"
     *   Credits: 100 //Kronor
     *   video: [{interest:3,length:13 URL: "URL1"}
     *           ,{interest:3,length:13 URL: "URL1"}
     *   ]
     *   Startdate: "YYYY-MM-DD" //Convert to epoch
     *   Enddate: "YYYY-MM-DD"  //Convert to epoch
     * }
 */

package com.example.demos.controller;

import java.text.ParseException;
import java.util.List;
import org.springframework.http.HttpStatus;


import com.example.demos.dto.OrderHistoryDTO;
import com.example.demos.model.JsonHandler;
import com.example.demos.model.Order;
import com.example.demos.model.OrderHistory;
import com.example.demos.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * This is the class handles the order path according to the spring mcv
 * architecture. This class is accessed through the url <em> "http://app/order"
 * </em>. This class is defined as a controller acording to the spring
 * architecture by assigning the class <code> @Controller </code> anotation. By
 * then assigning the anotation <code> @RequestMapping </code> to assign the url
 * to this class. Once it detects the <em> "/order" </em> url they will transfer
 * it to this class. This class will contain the following paths: ##add
 * more#//#endregion
 * 
 * @author Netanel Avraham Eklind
 * @version 0.0.1
 * 
 * TODO: Implementing a JWT checker!
 */

@Controller
@RequestMapping(path = "/order")
@CrossOrigin(origins = "http://localhost:3000")
public class ControllerOrder {

    @Autowired
    private OrderRepository orderrep;

    @Autowired
    private JsonHandler jsonHandler;
    
    @Autowired
    private OrderHistory orderHistory;

    /**
     * This method handles the handling of a new order that is sent, it is a post
     * mapping thus the order can be found as a json object in the data part of the
     * request query.
     * 
     * @param order contains the JSON object that contains all the nessecary
     *              information
     * @return A string to inform a new order is made
     * @throws ParseException
     */
    @PostMapping(path = "/add")
    @ResponseStatus(HttpStatus.CREATED) // 201 if created correctly
    public @ResponseBody String newOrder(@RequestBody String orderJson) throws ParseException {
        try {       
            Order order =jsonHandler.newOrder(orderJson);
            orderrep.save(order);
            return "New order saved";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * This methods deals with mapping of history where the caller can retrive orderhistory from the 
     * database using the userName.
     * @param userName
     * @return returns an array of orders showing orderId, videos reported on it that order.
     */
    @GetMapping(path = "/history")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<OrderHistoryDTO> getHistory(@RequestParam String userName)
    {   
        try {     
            List<OrderHistoryDTO> list = orderHistory.getHistory(userName);
            return list;
        } catch (Exception e) {
            System.out.print("Not a valid user");
            return null;
        }
    }
}