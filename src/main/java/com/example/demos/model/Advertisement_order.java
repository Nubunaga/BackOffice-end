package com.example.demos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="advertisement_order")
public class Advertisement_order {
 @Id
 private Integer video;
 private Integer orders;
 private long start_time_epoch;
 private long end_time_epoch;

public void newAdvOrder(Integer video, int orders,long start_time_epoch,
long end_time_epoch)
{
 setVideo(video);
 setOrders(orders); 
 setStart_time_epoch(start_time_epoch);
 setEnd_time_epoch(end_time_epoch);  
}


/**
 * @param end_time_epoch the end_time_epoch to set
 */
private void setEnd_time_epoch(long end_time_epoch) {
    this.end_time_epoch = end_time_epoch;
}
/**
 * @param orders the orders to set
 */
private void setOrders(Integer orders) {
    this.orders = orders;
}
/**
 * @param start_time_epoch the start_time_epoch to set
 */
private void setStart_time_epoch(long start_time_epoch) {
    this.start_time_epoch = start_time_epoch;
}
/**
 * @param video the video to set
 */
private void setVideo(Integer video) {
    this.video = video;
}


/**
 * @return the end_time_epoch
 */
public long getEnd_time_epoch() {
    return end_time_epoch;
}

/**
 * @return the orders
 */
public Integer getOrders() {
    return orders;
}
/**
 * @return the start_time_epoch
 */
public long getStart_time_epoch() {
    return start_time_epoch;
}
/**
 * @return the video
 */
public Integer getVideo() {
    return video;
}


}