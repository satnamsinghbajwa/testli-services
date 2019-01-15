package com.testli.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testli.aop.Loggable;
import com.testli.data.model.QuestionPaper;
import com.testli.services.QuestionPaperService;

@RestController
@Loggable
public class QuestionPaperController {

	@Autowired
	private QuestionPaperService questionPaperService;

	@RequestMapping(value = "/question-papers", method = POST, headers = { "Accept=application/json" })
	public QuestionPaper addQuestionPaper(@RequestBody QuestionPaper questionPaper) {
		return questionPaperService.addQuestionPaper(questionPaper);
	}

	@RequestMapping(value = "/question-papers/{id}", method = PUT, headers = { "Accept=application/json" })
	public QuestionPaper updateQuestionPaper(@PathVariable("id") String id, @RequestBody QuestionPaper questionPaper) {
		return questionPaperService.updateQuestionPaper(id, questionPaper);
	}

	@RequestMapping(value = "/question-papers/{id}", method = GET, headers = { "Accept=application/json" })
	public List<QuestionPaper> getQuestionPaper(@PathVariable("id") String id) {
		return questionPaperService.getQuestionPaper(id);
	}

	@RequestMapping(value = "/question-papers/{id}", method = DELETE, headers = { "Accept=application/json" })
	public void deleteQuestionPaper(@PathVariable("id") String id) {
		questionPaperService.deleteQuestionPaper(id);
	}

}
