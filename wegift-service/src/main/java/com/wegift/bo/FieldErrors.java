package com.wegift.bo;

import java.util.ArrayList;
import java.util.List;

public class FieldErrors {

	List<FieldError> errors = null;

	public FieldErrors() {
		errors = new ArrayList<FieldError>();
	}

	public void addError(String errorCode, String errorMessage) {
		errors.add(new FieldError(errorCode, errorMessage));
	}

	public List<FieldError> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldError> errors) {
		this.errors = errors;
	}

}
