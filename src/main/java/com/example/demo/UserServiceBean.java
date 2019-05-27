package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceBean {

	private UserRepository userRepository;

	@Autowired
	public UserServiceBean(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public boolean userExists(User user) {
		if (userRepository.findById(user.Id) == null) {
			return false;
		}
		return true;
	}
}