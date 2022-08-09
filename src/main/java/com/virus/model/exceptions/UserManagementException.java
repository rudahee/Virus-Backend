package com.virus.model.exceptions;

import com.virus.model.enumerateds.ErrorCode;

@SuppressWarnings("serial")
public class UserManagementException extends Exception {
	private final ErrorCode code;

	public UserManagementException(ErrorCode code) {
		super();
		this.code = code;
	}
	
	public ErrorCode getCode() {
		return this.code;
	}
}