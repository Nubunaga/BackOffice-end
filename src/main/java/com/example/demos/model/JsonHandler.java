package com.example.demos.model;

import java.text.ParseException;
import java.time.Instant;
import java.util.HashMap;
import java.util.UUID;

import com.example.demos.exceptions.NoVideoException;
import com.example.demos.repository.AdvertismentOrderRepository;
import com.example.demos.repository.AdvertismentRepository;
import com.example.demos.repository.InterestRepository;
import com.example.demos.repository.OrderRepository;
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
    private OrderRepository orderrep;

    @Autowired
    private AdvertismentRepository advertismentRepository;

    @Autowired
    private AdvertismentOrderRepository advertismentOrderRepository;

    @Autowired 
    private InterestRepository interestsRepository;

    private String  orderid;
    private String startTime, endTime;
    private HashMap<String,Integer>  map = new HashMap<>();

    /**
     * This class handles the initial calls for a new order. Takes the Json string
     * and takes all the information from it to be used.
     * 
     * @param orderJson Contains the order in JSON string format.
     * @param flag Is there if there is a need to test the method.
     * @return The order to be saved into the database.
     * @throws ParseException if the convertion does not contain integer.
     */
    public String newOrder(String orderJson) throws ParseException {
        if(orderJson == null) throw new IllegalArgumentException();
        JsonObject jsonObject = JsonParser.parseString(orderJson).getAsJsonObject();
        int credits;
        String userName;
        JsonArray jsonarray = jsonObject.get("video").getAsJsonArray();
        Order order = new Order();

        createHashMap();

        this.orderid = UUID.randomUUID().toString();
        credits = jsonObject.get("credits").getAsInt();
        userName = jsonObject.get("user").getAsString();
        this.startTime = jsonObject.get("Startdate").getAsString();
        this.endTime = jsonObject.get("Enddate").getAsString();

        order.addNewOrder(this.orderid, credits, userName);
        orderrep.save(order);
        if(jsonarray.size() != 0) addVideo(jsonarray);
        return order.getID();
    }

    
    public String addNewVideo(String Json) throws Exception {
        createHashMap();

        try {
            JsonObject jsonObject = JsonParser.parseString(Json).getAsJsonObject();
            this.orderid = jsonObject.get("id").getAsString();
            this.startTime = jsonObject.get("Startdate").getAsString();
            this.endTime = jsonObject.get("Enddate").getAsString();
            JsonArray jsonarray = jsonObject.get("video").getAsJsonArray();
            if(jsonarray.size() == 0) throw new NoVideoException("no video found");
            addVideo(jsonarray);
            return "Saved";
        } catch (Exception e) {
            return e.getMessage();
        }
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
            System.out.print(this.map.get(array[1]));
            aVideo.addNewAdv(this.map.get(array[1]), Integer.parseInt(array[2]), array[0]);
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
        long epoch = Instant.parse(time).toEpochMilli()/1000;
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
    
    private void createHashMap() {
        Iterable<Interest> list = interestsRepository.findAll();
        for(Interest l:list){
           this.map.put(l.getString(),l.getId());
        }
    }
    
}