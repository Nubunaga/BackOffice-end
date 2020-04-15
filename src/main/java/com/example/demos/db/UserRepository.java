package com.example.demos.db;

import org.springframework.data.repository.CrudRepository;
import com.example.demos.model.Users;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Users, String> {

}