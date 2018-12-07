package com.gg.voucher.service;

import com.gg.voucher.entity.User;
import com.gg.voucher.model.ResponseDTO;

public interface UserSevice {

	public ResponseDTO createUser(User user);
	public ResponseDTO login(User user);
}
