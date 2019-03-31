package com.wegift.bo;

public class FieldError {

	private String fieldName;
	private String errorMessage;

	public FieldError(String fieldName, String errorMessage) {
		this.fieldName = fieldName;
		this.errorMessage = errorMessage;
	}

	public String getfieldName() {
		return fieldName;
	}

	public void setfieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
