package com.testli.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.testli.aop.Loggable;
import com.testli.data.model.User;
import com.testli.data.model.UserQuestionSet;
import com.testli.data.repository.UserRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Loggable
@Log4j2
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.insert(user);
	}

	public User updateUser(String id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}

	public Optional<User> getUser(String id) {
		return userRepository.findById(id);
	}

	public User deleteUser(String id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setStatus("inactive");
			userRepository.save(user);
			return user;
		}
		return null;
	}

	public Optional<User> getUserByEmailId(String emailId) {
		User user = new User();
		user.setEmailId(emailId);
		Example<User> example = Example.of(user);
		return userRepository.findOne(example);
	}

	public User addUserQuestionSet(String userId, UserQuestionSet userQuestionSet) {
		userQuestionSet.setId(UUID.randomUUID().toString());
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			List<UserQuestionSet> existingQuestionSets = user.getListOfUserQuestionSet();
			existingQuestionSets = existingQuestionSets != null ? existingQuestionSets : new ArrayList<>();
			existingQuestionSets.add(userQuestionSet);
			user.setListOfUserQuestionSet(existingQuestionSets);
			userRepository.save(user);
			return user;
		}
		return null;
	}

	public User updateUserQuestionSet(String userId, String questionSetId, UserQuestionSet userQuestionSet) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			List<UserQuestionSet> existingQuestionSets = user.getListOfUserQuestionSet();
			existingQuestionSets = existingQuestionSets != null ? existingQuestionSets : new ArrayList<>();
			removeExistingQuestionSet(questionSetId, existingQuestionSets);
			userQuestionSet.setId(questionSetId);
			existingQuestionSets.add(userQuestionSet);
			user.setListOfUserQuestionSet(existingQuestionSets);
			userRepository.save(user);
			return user;
		}
		return null;
	}

	private void removeExistingQuestionSet(String questionSetId, List<UserQuestionSet> existingQuestionSets) {
		for (Iterator<UserQuestionSet> iterator = existingQuestionSets.iterator(); iterator.hasNext();) {
			UserQuestionSet existingQuestionSet = iterator.next();
			if (questionSetId.equalsIgnoreCase(existingQuestionSet.getId())) {
				// log.debug("removing question set for QuestionSet : " +
				// existingQuestionSet.getId());
				iterator.remove();
			}
		}
	}

	public User deleteUserQuestionSet(String userId, String questionSetId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			List<UserQuestionSet> existingQuestionSets = user.getListOfUserQuestionSet();
			existingQuestionSets = existingQuestionSets != null ? existingQuestionSets : new ArrayList<>();
			removeExistingQuestionSet(questionSetId, existingQuestionSets);
			user.setListOfUserQuestionSet(existingQuestionSets);
			userRepository.save(user);
			return user;
		}
		return null;
	}
}
