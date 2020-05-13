/**
 * This file was created on date:
 * 2020-05-12
 */

package com.example.demos.model;
import com.example.demos.exceptions.NoVideoException;
import com.example.demos.repository.AdvertismentRepository;

import com.example.demos.repository.PlayedVideoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The class <em>PlayedVideo</em> is the service class that handles the lookup
 * for the played database and also modifies the data to be returned back to the
 * callé to use the <em>played video lists </em>. It has dependencies with the
 * Advertisment_video class,
 * 
 * @see com.example.demos.model.Advertisment_video.java. This class is used to
 *      display all the videos played as a list. This class also has
 *      dependencies with the class <em> <Instert repository here> </em>
 * @see com.example.demos.repository.<Instert repository here> that implements
 *      the crud repository and speciallised method to call for all the played
 *      video of a specific order.
 * 
 * 
 *      This class implements methods <code>{@link#<insert>}</code> to retrive
 *      the list from the database and with the help of helperclasses <insert
 *      here> transforms the data into a json format to add to the list and
 *      return to the caller. It will show if the video is playing live
 *      depending on if the epoch time is not outside the given second length
 *      that is provided with each video.
 * 
 * @author Netanel Avraham Eklind
 * @version 1.0.0
 */
@Service
public class PlayedVideo {

    @Autowired
    AdvertismentRepository advertismentRepository;

    @Autowired
    PlayedVideoRepository playedVideoRepository;

    /**
     * Counts the amount of time the video has been played on the display. 
     * Returns nothing if the video have not been played before.
     * @param videoID                   Integer value of the video id.
     * @return                      A Integer count of video.
     * @throws NoVideoException     If no video has been played before.
     */
    public Integer retriveVideoIsPlaying(Integer videoID) throws NoVideoException { 
        Integer count;
        count = playedVideoRepository.countVideo(videoID);
        if(count <= 0) throw new NoVideoException("There are no played videos for this id");
        return count;
    }
}

