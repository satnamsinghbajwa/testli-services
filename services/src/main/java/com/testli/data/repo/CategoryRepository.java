package com.testli.data.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.testli.data.model.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {

}
