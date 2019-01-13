package com.testli.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testli.data.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
