package com.example.demos.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demos.model.*;

public interface OrderRepository extends CrudRepository<Users, String> {

}