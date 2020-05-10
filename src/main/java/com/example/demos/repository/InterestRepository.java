package com.example.demos.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demos.model.Interest;

public interface InterestRepository extends CrudRepository<Interest, Integer> {
}