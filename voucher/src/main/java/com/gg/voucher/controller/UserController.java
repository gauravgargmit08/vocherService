package com.gg.voucher.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gg.voucher.entity.User;
import com.gg.voucher.repo.UserRepository;


@RestController
@RequestMapping(value = "/user")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private  UserRepository userRepository;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		log.info("Saving user.");
		return userRepository.save(user);
	}

}