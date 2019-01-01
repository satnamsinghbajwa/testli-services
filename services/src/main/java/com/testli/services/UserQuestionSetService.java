package com.testli.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testli.data.UserQuestionSet;
import com.testli.data.UserQuestionSetRepository;

@Service
public class UserQuestionSetService {

	@Autowired
	private UserQuestionSetRepository userQuestionSetRepository;

	public UserQuestionSet createUserQuestionSet(UserQuestionSet userQuestionSet) {
		return userQuestionSetRepository.insert(userQuestionSet);
	}
}
