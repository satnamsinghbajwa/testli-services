package com.testli.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testli.data.Question;
import com.testli.services.QuestionService;

@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/questions", method = GET, headers = "Accept=application/json")
	public List<Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	@RequestMapping(value = "/questions", method = POST, headers = { "Accept=application/json" })
	public Question addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}

	@RequestMapping(value = "/questions/{id}", method = PUT, headers = "Accept=application/json")
	public Question updateQuestion(@PathVariable("id") String id, @RequestBody Question question) {
		return questionService.updateQuestion(id, question);
	}

	@RequestMapping(value = "/questions/{id}", method = DELETE, headers = "Accept=application/json")
	public void deleteQuestion(@PathVariable("id") String id) {
		questionService.deleteQuestion(id);
	}

}
