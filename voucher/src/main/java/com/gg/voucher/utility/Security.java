package com.gg.voucher.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Security {
	
	 @Value("${secretKey}")
	 private String secretKey;
	 
	 public String encrypt(String strToEncrypt)
	 {
	     return AES.encrypt(strToEncrypt, secretKey) ;
	 }
	 
	 public String decrypt(String strToDecrypt)
	 {
	     return AES.decrypt(strToDecrypt, secretKey) ;
	 }

}
