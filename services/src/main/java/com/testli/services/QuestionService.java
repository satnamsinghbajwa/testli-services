package com.testli.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		return questionRepository.insert(question);
	}

	public void deleteQuestion(String id) {
		questionRepository.deleteById(id);
	}
}
