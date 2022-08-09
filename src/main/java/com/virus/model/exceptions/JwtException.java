package com.virus.model.exceptions;

import com.virus.model.enumerateds.ErrorCode;

/* This class is a custom exception to return errors related to JWT code. custom error codes are obtained from the BodyErrorCode enumeration.
 * 
 * @see BodyErrorCode
 * 
 * @author J. Rubén Daza
 */
public class JwtException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final ErrorCode code;

	public JwtException(ErrorCode code) {
		super();
		this.code = code;
	}
	
	public ErrorCode getCode() {
		return this.code;
	}
}
