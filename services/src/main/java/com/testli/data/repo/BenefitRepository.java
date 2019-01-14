package com.testli.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testli.data.model.Benefit;

public interface BenefitRepository extends MongoRepository<Benefit, String> {

}
