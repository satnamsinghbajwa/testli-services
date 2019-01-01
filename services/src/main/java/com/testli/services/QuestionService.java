package com.testli.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.testli.data.Question;
import com.testli.data.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	public Question addQuestion(Question question) {
		return questionRepository.insert(question);
	}

	public Question updateQuestion(String id, Question question) {
		question.setId(id);
		return questionRepository.save(question);
	}

	public void deleteQuestion(String id) {
		questionRepository.deleteById(id);
	}

	public List<Question> getQuestion(String ids) {
		List<Question> questions = new ArrayList<>();
		if (ids != null) {
			List<String> items = Stream.of(ids.split("\\s*,\\s*")).map(element -> new String(element))
					.collect(Collectors.toList());
			Iterable<Question> findAllById = questionRepository.findAllById(items);
			for (Question question : findAllById) {
				questions.add(question);
			}
		}
		return questions;
	}

	public List<Question> searchQuestion(String author, String category) {
		Question question = new Question();
		question.setAuthor(author);
		question.setCategory(category);

		ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase()
				.withMatcher("author", matcher -> matcher.ignoreCase())
				.withMatcher("author", matcher -> matcher.contains())
				.withMatcher("category", matcher -> matcher.ignoreCase())
				.withMatcher("category", matcher -> matcher.contains());
		Example<Question> example = Example.of(question, exampleMatcher);
		// Example<Question> example = Example.of(question);
		return questionRepository.findAll(example);
	}
}
