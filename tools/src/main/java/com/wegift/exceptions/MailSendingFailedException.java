package com.wegift.exceptions;
/*
 * Exception for Mail Management
 */
public class MailSendingFailedException extends WeGiftException {

	private static final long serialVersionUID = -3470844912992345164L;

	public MailSendingFailedException(String errorCode, String message, Throwable e) {
		super(errorCode, message, e);
	}

	public MailSendingFailedException(String message) {
		super(message);
	}

}
