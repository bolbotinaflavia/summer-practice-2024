package com.example.haufe_app.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, Integer> {


    Optional<User> findByEmail(String email);
}

