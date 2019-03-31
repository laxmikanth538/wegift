package com.wegift.exceptions;

public class WeGiftException extends RuntimeException {

	private static final long serialVersionUID = 698201494121566773L;
	String errorCode;

	public WeGiftException() {
	}

	public WeGiftException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeGiftException(String errorCode, String message, Throwable e) {
		super(message, e);
		this.errorCode = errorCode;
	}

	public WeGiftException(String message) {
		super(message);
	}

	public WeGiftException(Throwable cause) {
		super(cause);
	}

}
