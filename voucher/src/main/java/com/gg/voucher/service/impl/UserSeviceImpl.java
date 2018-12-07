package com.gg.voucher.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gg.voucher.constant.Constants;
import com.gg.voucher.constant.ErrorCode;
import com.gg.voucher.entity.User;
import com.gg.voucher.model.Meta;
import com.gg.voucher.model.ResponseDTO;
import com.gg.voucher.repo.UserRepository;
import com.gg.voucher.service.UserSevice;
import com.gg.voucher.utility.MessageUtil;
import com.gg.voucher.utility.Security;

@Component
public class UserSeviceImpl implements UserSevice {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	MessageUtil messageUtil;

	@Autowired
	private Security security;

	@Override
	public ResponseDTO createUser(User user) {
		ResponseDTO responseDTO = new ResponseDTO();
		Meta meta = new Meta();
		User existUser = userRepository.findByEmail(user.getEmail());
		boolean userExist = null != existUser ? true : false;
		if (userExist) {
			meta.setStatus(ErrorCode.USER_ALREADY_EXISTS);
			meta.setDescription(messageUtil
					.getMessage(ErrorCode.USER_ALREADY_EXISTS));
			responseDTO.setMeta(meta);
			return responseDTO;
		} else {
			user.setPassword(security.encrypt(user.getPassword()));
			userRepository.save(user);
			meta.setStatus(Constants.SUCCESS_CODE);
			meta.setDescription(messageUtil.getMessage(Constants.SUCCESS_CODE));
			responseDTO.setMeta(meta);
		}
		return null;
	}

	@Override
	public ResponseDTO login(User user) {
		String email = user.getEmail();
		String password = user.getPassword();
		User existUser = userRepository.findByEmail(user.getEmail());
		ResponseDTO responseDTO = new ResponseDTO();
		Meta meta = new Meta();

		boolean userExist = null != existUser ? true : false;
		if (!userExist) {
			meta.setStatus(ErrorCode.USER_NOT_FOUND);
			meta.setDescription(messageUtil
					.getMessage(ErrorCode.USER_NOT_FOUND));
			responseDTO.setMeta(meta);
			return responseDTO;
		} else {
			String dbPassword = existUser.getPassword();
			if (dbPassword.equalsIgnoreCase(password)) {
				meta.setStatus(Constants.SUCCESS_CODE);
				meta.setDescription(messageUtil
						.getMessage(Constants.SUCCESS_CODE));
				responseDTO.setMeta(meta);
				return responseDTO;
			} else {
				meta.setStatus(ErrorCode.INCORRECT_PASSWORD);
				meta.setDescription(messageUtil
						.getMessage(ErrorCode.INCORRECT_PASSWORD));
				responseDTO.setMeta(meta);
				return responseDTO;
			}
		}
	}

}
