package com.testli.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testli.data.model.Membership;

public interface MembershipRepository extends MongoRepository<Membership, String> {

}
