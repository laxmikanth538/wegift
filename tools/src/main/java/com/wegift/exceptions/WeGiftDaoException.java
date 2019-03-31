package com.wegift.exceptions;

/*
 * Every DAO Component uses this exception, which are working with database
 */
public class WeGiftDaoException extends WeGiftException {
	private static final long serialVersionUID = 3625107729905622337L;

	public WeGiftDaoException(String errorCode, String message, Throwable e) {
		super(errorCode, message, e);
	}

	public WeGiftDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeGiftDaoException(String message) {
		super(message);
	}

}
