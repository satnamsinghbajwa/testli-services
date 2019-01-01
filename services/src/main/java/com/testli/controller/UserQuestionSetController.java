package com.testli.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testli.data.UserQuestionSet;
import com.testli.services.UserQuestionSetService;

@RestController
public class UserQuestionSetController {

	@Autowired
	private UserQuestionSetService userQuestionSetService;

	@RequestMapping(value = "/users/{userId}/question-set", method = POST, headers = { "Accept=application/json" })
	public UserQuestionSet createUserQuestionSet(@PathVariable("userId") String userId, @RequestBody UserQuestionSet userQuestionSet) {
		return userQuestionSetService.createUserQuestionSet(userQuestionSet);
	}

}
