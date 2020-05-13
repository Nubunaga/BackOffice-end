package com.example.demos.controller;

import java.text.ParseException;
import java.util.List;
import org.springframework.http.HttpStatus;

import com.example.demos.Security.JWTDecoder;
import com.example.demos.dto.OrderHistoryDTO;
import com.example.demos.exceptions.NoUserFoundException;
import com.example.demos.exceptions.NoVideoException;
import com.example.demos.exceptions.WrongAuthLevelException;
import com.example.demos.exceptions.WrongJsonFormatException;
import com.example.demos.model.Interest;
import com.example.demos.model.JsonHandler;
import com.example.demos.model.OrderHistory;
import com.example.demos.repository.InterestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

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
 */

@Controller
@RequestMapping(path = "/order")
@CrossOrigin(origins = "*")
public class ControllerOrder {

    @Autowired
    private JsonHandler jsonHandler;

    @Autowired
    private OrderHistory orderHistory;

    @Autowired
    private JWTDecoder jwtDecoder;

    @Autowired 
    private InterestRepository interestsRepository;

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
    public @ResponseBody String newOrder(@RequestBody String orderJson,@RequestHeader(value = "Auth-Token", required = false) String authorization)
            throws Exception {
        try {      
            jwtDecoder.jwtDecode(authorization);
            return jsonHandler.newOrder(orderJson);
        }
        catch(WrongJsonFormatException wJFE){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, wJFE.getMessage());
        }
        catch(NoVideoException nVE){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, nVE.getMessage());
        }
        catch(WrongAuthLevelException wALE){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, wALE.getMessage());
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
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
    public @ResponseBody List<OrderHistoryDTO> getHistory(@RequestParam String userName, @RequestHeader(value = "Auth-Token", required = false)  String authorization)
    {   
        try {
            if(userName == null) throw new IllegalArgumentException("Username is null");
            jwtDecoder.jwtDecode(authorization);
            List<OrderHistoryDTO> list = orderHistory.getHistory(userName);
            return list;
        } catch(NoUserFoundException nUFE) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No history is found for user " +userName);
        }
         catch(IllegalArgumentException iAE){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"UserName can not be null");
         }
        
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    /**
     * Returns the current active intresst known in the database by communication
     * with hybernate.
     * @param authorization         JWT-token used to authorize the user calling
     * @return                      A list of interrest.
     */
    @GetMapping(path ="/intrests")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Iterable<Interest> getInterest( @RequestHeader(value = "Auth-Token", required = false)  String authorization){

        try {
            jwtDecoder.jwtDecode(authorization);
            Iterable<Interest> interests = interestsRepository.findAll();
            return interests;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No interest found at the moment");
        }
    }
}