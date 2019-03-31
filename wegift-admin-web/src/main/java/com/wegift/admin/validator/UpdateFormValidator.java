package com.wegift.admin.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.wegift.command.MerchantUpdateForm;

public class UpdateFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(MerchantUpdateForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MerchantUpdateForm form = (MerchantUpdateForm) target;

		if (form.getUsername() == null || "".equals(form.getUsername())) {
			errors.rejectValue("username", "username.empty");
		} else if (form.getUsername().trim().length() < 6) {
			errors.rejectValue("username", "username.short");
		}

		if (form.getPassword() == null || "".equals(form.getPassword())) {
			errors.rejectValue("password", "password.empty");
		} else if (form.getPassword().trim().length() < 6) {
			errors.rejectValue("password", "password.short");
		}

		/*
		 * if(form.getPassword() == null || "".equals(form.getRePassword())){
		 * errors.rejectValue("rePassword", "rePassword.empty"); }else
		 * if(form.getPassword().trim().length() < 6){
		 * errors.rejectValue("rePassword", "rePassword.short"); }
		 */

		if (form.getPassword().equals(form.getRePassword()) == false) {
			errors.rejectValue("rePassword", "password.mismatch");
		}

	}

}
