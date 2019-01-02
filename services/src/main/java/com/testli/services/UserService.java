package com.testli.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.testli.data.User;
import com.testli.data.UserQuestionSet;
import com.testli.data.UserRepository;

@Service
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
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			List<UserQuestionSet> existingQuestionSets = user.getQuestionSets();
			existingQuestionSets = existingQuestionSets != null ? existingQuestionSets : new ArrayList<>();
			existingQuestionSets.add(userQuestionSet);
			userRepository.save(user);
			return user;
		}
		return null;
	}

	public User updateUserQuestionSet(String userId, String questionSetId, UserQuestionSet userQuestionSet) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			List<UserQuestionSet> existingQuestionSets = user.getQuestionSets();
			existingQuestionSets = existingQuestionSets != null ? existingQuestionSets : new ArrayList<>();
			removeExistingQuestionSet(questionSetId, existingQuestionSets);
			existingQuestionSets.add(userQuestionSet);
			userRepository.save(user);
			return user;
		}
		return null;
	}

	private void removeExistingQuestionSet(String questionSetId, List<UserQuestionSet> existingQuestionSets) {
		for (UserQuestionSet existingQuestionSet : existingQuestionSets) {
			if (questionSetId.equalsIgnoreCase(existingQuestionSet.getId())) {
				existingQuestionSets.remove(existingQuestionSet);
			}
		}
	}

	public User deleteUserQuestionSet(String userId, String questionSetId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			List<UserQuestionSet> existingQuestionSets = user.getQuestionSets();
			existingQuestionSets = existingQuestionSets != null ? existingQuestionSets : new ArrayList<>();
			removeExistingQuestionSet(questionSetId, existingQuestionSets);
			userRepository.save(user);
			return user;
		}
		return null;
	}
}
