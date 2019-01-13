package com.testli.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testli.data.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

}
