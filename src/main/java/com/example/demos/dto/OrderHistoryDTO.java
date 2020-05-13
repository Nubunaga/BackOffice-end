package com.example.demos.dto;

/**
 * This class is the DTO for the orderhistory and will be the one sent to the calle
 * to show all of the history.
 * 
 * @author Netanel Avraham Eklind
 * @version 0.0.1
 */

import com.example.demos.model.Advertisement_video;
import com.example.demos.model.OrderHistory.Played;

import java.util.*;

public class OrderHistoryDTO {

    private String orderId;
    private String user;
    private Integer credits;
    private List<Played> advertisement_videos;
    private String startDate;
    private String endDate;
    private boolean played;
    private Integer count;

    /**
     * @param count the count to set
     */
    public void setCount(Integer count) {
        this.count = count;
    }/**
     * @param played the played to set
     */
    public void setPlayed(boolean played) {
        this.played = played;
    }
    /**
     * @return the count
     */
    public Integer getCount() {
        return count;
    }

    public boolean getPlayed(){
        return played;
    }

    /**
     * @param list the advertisement_videos to set
     */
    public void setAdvertisement_videos(List<Played> list) {
        this.advertisement_videos = list;
    }
    /**
     * @param credits the credits to set
     */
    public void setCredits(Integer credits) {
        this.credits = credits;
    }
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the advertisement_videos
     */
    public List<Optional<Advertisement_video>> getAdvertisement_videos() {
        return advertisement_videos;
    }
    /**
     * @return the credits
     */
    public Integer getCredits() {
        return credits;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }
    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }
    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }


}