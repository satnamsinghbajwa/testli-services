package com.testli.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testli.data.model.Question;

public interface QuestionRepository extends MongoRepository<Question, String>{

}
