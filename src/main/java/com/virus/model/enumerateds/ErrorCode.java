package com.virus.model.enumerateds;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode implements Serializable {

	/*
	 * Specials Errors
	 */
	NO_ERROR(0, "OK"),
	INDETERMINATE_ERROR(-1, "Unknown error. Contact an administrator"),
	
	
	/*
	 * General Errors
	 */
	FIELD_IS_MISSING(0001,"Some required field is missing"),
	
	
	/*
	 * User Management
	 */
	INCORRECT_LOGIN(1001, "Incorrect username or password"),
	USERNAME_ALREADY_EXISTS(1002, "Username already exist"),
	USER_NOT_EXIST(1002, "User does not exist"),
	EMAIL_ALREADY_EXISTS(1003, "Email already exists"),
	
	/*
	 * JWT Related 
	 */
	TOKEN_NOT_VALID(2001, "TOKEN_NOT_VALID"),
	TOKEN_EXPIRED(2002, "TOKEN_EXPIRED");

	
	private final Integer code;
	private final String message;

	private ErrorCode(Integer code, String message) {
		this.message = message;
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Integer getCode() {
		return code;
	}
}
