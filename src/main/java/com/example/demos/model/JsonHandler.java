package com.example.demos.model;

import java.text.ParseException;
import java.time.Instant;

import com.example.demos.repository.AdvertismentOrderRepository;
import com.example.demos.repository.AdvertismentRepository;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class will be the mediator of the JSON object thus allowing only JSON
 * object to be opend in the model part of the MVC structure.
 * 
 * This class handles the JSON object with GSON <a href=https://github.
 * com/google/gson/blob/master/UserGuide.md#TOC-Gson-With-Maven>GSON with
 * maven2</a> and thus allows the user to booth create and take information with
 * JSON objects. This class implements the code {@link #newOrder(String)} that
 * deals with a new order that comes in the form of JSON string.
 * {@link #addVideo(JsonArray)} that takes a Json array and adds the videos
 * inside of it to the advertisment database. {@link #openJson(JsonObject)} That
 * takes a JSON Object and retrives the values inside of it.
 * 
 * This class is the main handler of the order and will be used to call the
 * other classes inorder to save and handle the buissnes logic of this service.
 * 
 * @author Netanel Avraham Eklind
 * @version 0.0.2
 * 
 */
@Service
public class JsonHandler {
    @Autowired
    private AdvertismentRepository advertismentRepository;

    @Autowired
    private AdvertismentOrderRepository advertismentOrderRepository;

    private Integer orderid;
    private String startTime, endTime;

    /**
     * This class handles the initial calls for a new order. Takes the Json string
     * and takes all the information from it to be used.
     * 
     * @param orderJson Contains the order in JSON string format.
     * @return The order to be saved into the database.
     * @throws ParseException
     */
    public Order newOrder(String orderJson) throws ParseException {
        JsonObject jsonObject = JsonParser.parseString(orderJson).getAsJsonObject();
        int credits;
        String userName;
        JsonArray jsonarray = jsonObject.get("video").getAsJsonArray();

        this.orderid = jsonObject.get("id").getAsInt();
        credits = jsonObject.get("credits").getAsInt();
        userName = jsonObject.get("user").getAsString();
        this.startTime = jsonObject.get("Startdate").getAsString();
        this.endTime = jsonObject.get("Enddate").getAsString();

        Order order = new Order();
        order.addNewOrder(this.orderid, credits, userName);
        addVideo(jsonarray);
        return order;
    }

    /**
     * This method adds a new video of there is one!
     * 
     * @param jsonArray contains the JSON array
     * @throws ParseException
     */
    private void addVideo(JsonArray jsonArray) throws ParseException {
        for (int i = 0; i < jsonArray.size(); i++) {
            Advertisement_video aVideo = new Advertisement_video();
            String[] array = openJson((JsonObject) jsonArray.get(i));
            aVideo.addNewAdv(Integer.parseInt(array[1]), Integer.parseInt(array[2]), array[0]);
            advertismentRepository.save(aVideo);
            advOrder(aVideo);
        }
    }

    private void advOrder(Advertisement_video aVideo) throws ParseException {
        Advertisement_order advOrder = new Advertisement_order();
        advOrder.newAdvOrder(aVideo.getID(), this.orderid, epochConv(this.startTime), epochConv(this.endTime));
        advertismentOrderRepository.save(advOrder);
    }

    private long epochConv(String time) throws ParseException {
        long epoch = Instant.parse(time).toEpochMilli();
        return epoch;
    }

    /**
     * Takes the individual object and divides into the different parts needed.
     * 
     * @param jsonElement contains the initial Object
     * @return Returns the array of Strings.
     */
    private String[] openJson(JsonObject jsonElement) {
        String[] array = new String[3];
       array[0] = jsonElement.get("url").getAsString();
       array[1] = jsonElement.get("interest").getAsString();
       array[2] = jsonElement.get("length").getAsString();
       return array;
    }


}