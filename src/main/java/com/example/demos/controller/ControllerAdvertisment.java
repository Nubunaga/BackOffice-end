package com.example.demos.controller;

import com.example.demos.repository.*;
import com.example.demos.model.Advertisement_video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

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
 * @version 0.0.3
 * 
 */

@Controller // This means that this class is a Controller
@RequestMapping(path="/advert") // This means URL's start with /demo (after Application path)
public class ControllerAdvertisment {

    @Autowired
    private AdvertismentRepository advertismentRepository;
    /**
     * This method handles the adding of a new advertisment by taking the Post data body
     * and apply the information from there
     * @return A string that informs the user that a new add is made 
     */
    @PostMapping(path="/add")
    @ResponseStatus(HttpStatus.CREATED)//201
    public @ResponseBody String addAdv(@RequestParam String url, @RequestParam String interest
    ,@RequestParam String time){
        try {
            Advertisement_video adv = new Advertisement_video();
            adv.addNewAdv(Integer.parseInt(interest), Integer.parseInt(time), url);
            advertismentRepository.save(adv);
            return "Saved";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * This method handles if the user wants to delete an advertisment from the database
     * @param id contains the id to be deleted.
     * @return A string that informs of this deletion
     */
    @GetMapping(path="/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)//204
    public @ResponseBody String deleteAdv(@RequestParam int id){
        try {
            advertismentRepository.deleteById(id);
            return "Video deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}