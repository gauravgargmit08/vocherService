package com.gg.voucher.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {
	
	@Autowired
	private MessageSource msgSource;
	
	public String getMessage(String errorCode) {
		String message = null;
		try {
			message = msgSource.getMessage("error." + errorCode, null, null);
		} catch (NoSuchMessageException nm) {
			message = "Something went wrong. Please try again later.";
		}
		return message;
	}
}
