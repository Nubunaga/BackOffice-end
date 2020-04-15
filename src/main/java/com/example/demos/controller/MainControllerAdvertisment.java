package com.example.demos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * This class is the Main controller for the Advertisment <code> /advert </code> pathing.
 * When this is called the api mapping knows that the caller is looking to use the 
 * advertisment system in some way.
 * The advertisment path allows the user to do the following:
 * {@link #addAdv()} that is pathed with the rest query <em> POST </em> allows
 * the user to add a new advertisment video and parameters to the database.
 * {@link #deleteAdv()} that is pather with the rest query <em> GET </em> allows the 
 * user to delete a advertisment row in the database. 
 * ### more will come ###
 * 
 * 
 * @author Netanel Avraham Eklind
 * @version 0.0.1
 * TODO: add video, delete video
 */

@Controller // This means that this class is a Controller
@RequestMapping(path="/advert") // This means URL's start with /demo (after Application path)
public class MainControllerAdvertisment {

    /**
     * This method handles the adding of a new advertisment by taking the Post data body
     * and apply the information from there
     * @return A string that informs the user that a new add is made 
     * TODO: add this!!!
     */
    @PostMapping(path="/add")
    public @ResponseBody String addAdv(){
        return "This is the add page!";
    }

    /**
     * This method handles if the user wants to delete an advertisment from the database
     * @return A string that informs of this deletion
     * TODO: add this!!!
     */
    @GetMapping(path="/delete")
    public @ResponseBody String deleteAdv(){
        return "This is the delete page!";
    }

}