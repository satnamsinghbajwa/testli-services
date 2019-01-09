package com.testli.controller;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.testli.aop.Loggable;
import com.testli.data.model.User;
import com.testli.data.model.UserQuestionSet;
import com.testli.services.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@Loggable
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = POST, headers = { "Accept=application/json" })
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@RequestMapping(value = "/users/{id}", method = PUT, headers = { "Accept=application/json" })
	public User updateUser(@PathVariable("id") String id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	@RequestMapping(value = "/users/{id}", method = GET, headers = { "Accept=application/json" })
	public User getUser(@PathVariable("id") String id) {
		Optional<User> user = userService.getUser(id);
		return checkOptionalUserExistence(user);
	}

	@RequestMapping(value = "/users/{id}", method = DELETE, headers = { "Accept=application/json" })
	public User deleteUser(@PathVariable("id") String id) {
		User deleteUser = userService.deleteUser(id);
		return checkUserExistence(deleteUser);
	}

	@RequestMapping(value = "/users/emailid/{emailId}", method = GET, headers = { "Accept=application/json" })
	public User getUserByEmailId(@PathVariable("emailId") String emailId) {
		Optional<User> userByEmailId = userService.getUserByEmailId(emailId);
		return checkOptionalUserExistence(userByEmailId);
	}

	@RequestMapping(value = "/users/{userId}/question-set", method = POST, headers = { "Accept=application/json" })
	public User addUserQuestionSet(@PathVariable("userId") String userId,
			@RequestBody UserQuestionSet userQuestionSet) {
		User user = userService.addUserQuestionSet(userId, userQuestionSet);
		return checkUserExistence(user);
	}

	@RequestMapping(value = "/users/{userId}/question-set/{questionSetId}", method = PUT, headers = {
			"Accept=application/json" })
	public User updateUserQuestionSet(@PathVariable("userId") String userId,
			@PathVariable("questionSetId") String questionSetId, @RequestBody UserQuestionSet userQuestionSet) {
		User user = userService.updateUserQuestionSet(userId, questionSetId, userQuestionSet);
		return checkUserExistence(user);
	}

	@RequestMapping(value = "/users/{userId}/question-set/{questionSetId}", method = DELETE, headers = {
			"Accept=application/json" })
	public User deleteUserQuestionSet(@PathVariable("userId") String userId,
			@PathVariable("questionSetId") String questionSetId) {
		User user = userService.deleteUserQuestionSet(userId, questionSetId);
		return checkUserExistence(user);
	}

	private User checkOptionalUserExistence(Optional<User> userByEmailId) {
		if (userByEmailId.isPresent()) {
			return userByEmailId.get();
		}
		// log.debug("No user found for emailId : " + userByEmailId);
		throw new ResponseStatusException(NOT_FOUND, "User not found");
	}

	private User checkUserExistence(User user) {
		if (user != null) {
			return user;
		} else {
			// log.debug("No user found");
			throw new ResponseStatusException(NOT_FOUND, "User not found");
		}
	}

}
