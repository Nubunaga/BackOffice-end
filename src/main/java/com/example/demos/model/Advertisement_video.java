package com.example.demos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class will be the advertisment @Entity class that will allow hibernate
 * to access this table in the database and show the result.
 * 
 * @author Netanel Avraham Eklind
 * @version 0.0.1
 */

 @Entity
public class Advertisement_video {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private int interest;

    private int length_sec;
    
    private String url;

    /**
     * This method adds a new advertisment video to the databas
     * @param interest              contains a integer number to associate to intresst.
     * @param length_sec            contains the given length of the video.
     * @param url                   is the url link to the video.
     */
    public void addNewAdv(int interest, int length_sec,String url){
        if( interest <= 0  || length_sec <= 0 || url == null) throw new IllegalArgumentException();
        setInterest(interest);
        setLength(length_sec);
        setURL(url);
    }
    private void setInterest(int interest){
        this.interest = interest;
    }
    private void setLength(int length){
        this.length_sec = length;
    }
    private void setURL(String URL){
        this.url = URL;
    }

    public Integer getID(){
        return id;
    }

    public int getInterest(){
        return interest;
    }

    public int getLengthSec(){
        return length_sec;
    }

    public String getUrl(){
        return url;
    }
}