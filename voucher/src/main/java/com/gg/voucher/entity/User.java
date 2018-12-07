package com.gg.voucher.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private String userId;
	private String name;
	public String getEmail() {
		return email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getPassword() {
		return password;
	}


	public String getDob() {
		return dob;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	private String email;
	private String mobileNo;
	private String password;
	private String dob;
	private Date creationDate = new Date();
	private Date modifiedDate = new Date();
	private Map<String, String> userSettings = new HashMap<>();

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Map<String, String> getUserSettings() {
		return userSettings;
	}

	public void setUserSettings(Map<String, String> userSettings) {
		this.userSettings = userSettings;
	}
}
