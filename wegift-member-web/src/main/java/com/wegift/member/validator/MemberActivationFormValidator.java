package com.wegift.member.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.wegift.member.command.MemberUpdateForm;

@Component("memberActivationFormValidator")
public class MemberActivationFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> classType) {
		return classType.isAssignableFrom(MemberUpdateForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberUpdateForm memberUpdateForm = null;
		memberUpdateForm = (MemberUpdateForm) target;

		if (memberUpdateForm.getUserName() == null || memberUpdateForm.getUserName().trim().length() == 0) {
			errors.rejectValue("userName", "Enter User Name");
		}

		if (memberUpdateForm.getPassword() == null || memberUpdateForm.getPassword().trim().length() <= 6
				|| memberUpdateForm.getPassword().trim().length() >= 10) {
			errors.rejectValue("password", "password.invalid");
		}

		if (memberUpdateForm.getRePassword() == null
				|| (memberUpdateForm.getRePassword().equalsIgnoreCase(memberUpdateForm.getPassword())) == false) {
			errors.rejectValue("rePassword", "rePassword.invalid");
		}
	}

}
