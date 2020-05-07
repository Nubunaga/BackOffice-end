package com.example.demos.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demos.model.Interests;

public interface InterestsRepository extends CrudRepository<Interests, Integer> {
}