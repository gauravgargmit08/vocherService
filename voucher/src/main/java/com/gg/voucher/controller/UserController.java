package com.gg.voucher.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gg.voucher.entity.User;
import com.gg.voucher.model.ResponseDTO;
import com.gg.voucher.service.UserSevice;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserSevice sevice;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseDTO addNewUsers(@RequestBody User user) {
		log.info("Saving user.");
		return sevice.createUser(user);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseDTO login(@RequestBody User user) {
		log.info("Saving user.");
		return sevice.login(user);
	}

}