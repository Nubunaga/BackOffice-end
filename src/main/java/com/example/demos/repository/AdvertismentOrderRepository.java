package com.example.demos.repository;

import com.example.demos.model.Advertisement_order;

import org.springframework.data.repository.CrudRepository;

import java.util.*;

/** 
 * This will be AUTO IMPLEMENTED by Spring into a Bean called 
 * Advertisment_videoCRUD refers Create, Read, Update, Delete
 */
public interface AdvertismentOrderRepository extends CrudRepository<Advertisement_order, Integer> {
    List<Advertisement_order> findByOrders(Integer orders);
    List<Advertisement_order> findDistinctByOrders(Integer orders);
}