package com.gg.voucher.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Meta {
	
	private String description;
	private String status;
	private String tpStatusCode;
	public Meta() {
		super();
	}
	
	
	public Meta(String status, String code, String description) {
		super();
		this.status = status;
		this.description = description;
	}


	@Override
	public String toString() {
		return "Meta [status=" + status  + ", description=" + description + "]";
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getTpStatusCode() {
		return tpStatusCode;
	}


	public void setTpStatusCode(String tpStatusCode) {
		this.tpStatusCode = tpStatusCode;
	}
	
}
