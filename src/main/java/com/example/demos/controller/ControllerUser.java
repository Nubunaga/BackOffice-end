package com.example.demos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.demos.model.*;
import com.example.demos.repository.*;


/**
 * This class is the main controller for the api handling the <em> "/user" </em>
 * api calls. With the help of the spring <code> @RequestMapping </code> we make sure
 * that all rest calls for the /user gets redirected to this class. Thus allowing us to 
 * handle all user requests by the backend.
 * This class contains the following <code> @PostMapping </code>to handle user requests:
 * {@link #addNewUser(String, String)} that uses mapping /add, is a <em> POST </em>
 * REST request thus taking the body data as 2 string to add a new user to the linked sql 
 * database.
 * {@link #getAllUsers()}Is called using /all to request all active users in the database.
 * {@link #getUser(int)}Is called using /user with a param id to check for a specific user using
 * the given id.
 * {@link}{@link #removeUser(int)} is called using /remove with a param id to remove a specfic user.
 * 
 * This class is dependent on the class {@link User} and {@link UserRepository} since they are the one 
 * whom handles the user creation and how to represent the user in json format using the spring bean.
 * 
 * TODO: Call auth from backend.
 * 
 * @author Netanel Avraham Eklind
 * @version 1.0.0
 */



@Controller // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class ControllerUser {
  
  @Autowired 
  private UserRepository userRepository;


  /**
   * This method handles the add user request when the path /add is called for. It creates a new user
   * from the {@link User} and uses that entity to apply it into the database using the class
   * {@link UserRepository}. Returns a 201 if new user is created correctly.
   * @param name is contained in the REST body, is the name of the user
   * @param email is contained in the REST body, is the email of the user.
   */
  @PostMapping(path="/add")
  @ResponseStatus(HttpStatus.CREATED) // 201 if created correctly
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email, @RequestParam String password){
        Users n = new Users();
        try {
          n.setnewUser(name,email,password);
          assert(n.getName()==name & n.getEmail() == email & n.getPassword() == password);
          userRepository.save(n);
          return "Saved";
        } catch (Exception e) {
          return e.getMessage();
        }
  }
  
  /**
   * This method removes a user if the /remove is used in the url, it requires a id to be passed to the database
   * so the user can be removed from ther.
   * Returns a 204 if the user has been removed correctly.
   * @param id is the <em> primary key </em> that will be used to delete the user.
   */
   @GetMapping(path="/remove")
   @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public @ResponseBody String removeUser(@RequestParam String id){
      try {
        if (userRepository.existsById(id) == false) throw new Exception();
        userRepository.deleteById(id);
        return "Removed";
      } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No user found",e);
      }
      }
  
  /**
   * Return a specific user using that users id. Return with a 200 ok with the user data in
   * body.
   * @param id is the specific user to look for
   * @return
   */
  @GetMapping(path="/user")
  @ResponseStatus(HttpStatus.OK) // 200
  public @ResponseBody String getUser(@RequestParam String id){
    try {
      System.out.println(userRepository.findById(id).get().getName());
      return userRepository.findById(id).get().getName();
    } catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No user found",e);
    }
  }
}