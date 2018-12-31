package com.testli.services;

import java.util.List;
import java.util.Optional;

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

	public Optional<Question> getQuestion(String id) {
		return questionRepository.findById(id);
	}

	public List<Question> searchQuestion(String author, String category) {
		Question question = new Question();
		question.setAuthor(author);
		question.setCategory(category);

		//ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues().withIgnoreCase();

		//Example<Question> example = Example.of(question, matcher);
		Example<Question> example = Example.of(question);
		return questionRepository.findAll(example);
	}
}
