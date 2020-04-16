package com.example.demos.repository;

import com.example.demos.model.Advertisement_video;

import org.springframework.data.repository.CrudRepository;

/** 
 * This will be AUTO IMPLEMENTED by Spring into a Bean called 
 * Advertisment_videoCRUD refers Create, Read, Update, Delete
 */
public interface AdvertismentRepository extends CrudRepository<Advertisement_video,Integer>{

}