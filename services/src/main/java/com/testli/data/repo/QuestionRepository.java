package com.testli.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testli.data.model.Question;

public interface QuestionRepository extends MongoRepository<Question, String>{

}