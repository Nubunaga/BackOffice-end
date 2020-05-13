package com.example.demos.dto;

/**
 * This class is the DTO for the orderhistory and will be the one sent to the calle
 * to show all of the history.
 * 
 * @author Netanel Avraham Eklind
 * @version 0.0.1
 */

import java.util.*;

public class OrderHistoryDTO {

    private String orderId;
    private String user;
    private Integer credits;
    private List<PlayedDTO> advertisement_videos;
    private String startDate;
    private String endDate;

    /**
     * @param list the advertisement_videos to set
     */
    public void setAdvertisement_videos(List<PlayedDTO> list) {
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
    public List<PlayedDTO> getAdvertisement_videos() {
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