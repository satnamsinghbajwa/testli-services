package com.testli.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testli.data.model.QuestionPaper;

public interface QuestionPaperRepository extends MongoRepository<QuestionPaper, String> {

}
