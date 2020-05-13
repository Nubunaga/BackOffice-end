package com.example.demos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "played_video")
public class Played_video {

    @Id
    private Integer id;
    private Integer video;
    private Integer time_epoch;
    private String order;
    

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * @param time_epoch the time_epoch to set
     */
    public void setTime_epoch(Integer time_epoch) {
        this.time_epoch = time_epoch;
    }

    /**
     * @param video the video to set
     */
    public void setVideo(Integer video) {
        this.video = video;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @return the order
     */
    public String getOrder() {
        return order;
    }
    /**
     * @return the time_epoch
     */
    public Integer getTime_epoch() {
        return time_epoch;
    }
    /**
     * @return the video
     */
    public Integer getVideo() {
        return video;
    }
    
}