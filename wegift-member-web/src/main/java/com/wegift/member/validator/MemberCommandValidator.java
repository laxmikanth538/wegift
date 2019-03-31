package com.wegift.member.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.wegift.member.command.MemberCommand;

@Component("memberCommandValidator")
public class MemberCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> classType) {
		return classType.isAssignableFrom(MemberCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		MemberCommand memberCommand = null;

		memberCommand = (MemberCommand) command;

		if (memberCommand.getFirstName() == null || memberCommand.getFirstName().trim().length() == 0) {
			errors.rejectValue("firstName", "firstName.blank");
		}
		if (memberCommand.getLastName() == null || memberCommand.getLastName().trim().length() == 0) {
			errors.rejectValue("lastName", "lastName.blank");
		}
		if (memberCommand.getGender() == null || memberCommand.getGender().trim().length() == 0) {
			errors.rejectValue("gender", "gender.blank");
		}
		if (memberCommand.getDob() == null) {
			errors.rejectValue("dob", "dob.blank");
		}
		if (memberCommand.getMobile() == null || memberCommand.getMobile().trim().length() < 10
				|| memberCommand.getMobile().trim().length() > 10) {
			errors.rejectValue("mobile", "mobile.blank");
		}
		if (memberCommand.getEmail() == null || memberCommand.getEmail().trim().length() == 0
		/*
		 * || ((memberCommand.getEmail().endsWith("@gmail.com")) == false) ||
		 * (memberCommand.getEmail().endsWith("@s-force.org")) == false)
		 */ ) {
			errors.rejectValue("email", "email.blank");
		}
		if (memberCommand.getAddressLine1() == null || memberCommand.getAddressLine1().trim().length() == 0) {
			errors.rejectValue("addressLine1", "addressLine2.blank");
		}
		if (memberCommand.getAddressLine2() == null || memberCommand.getAddressLine2().trim().length() == 0) {
			errors.rejectValue("addressLine2", "addressLine2.blank");
		}
		if (memberCommand.getCity() == null || memberCommand.getCity().trim().length() == 0) {
			errors.rejectValue("city", "city.blank");
		}
		if (memberCommand.getState() == null || memberCommand.getState().trim().length() == 0) {
			errors.rejectValue("state", "state.blank");
		}
		if (memberCommand.getZip() == null || memberCommand.getZip().trim().length() == 0) {
			errors.rejectValue("zip", "zip.blank");
		}
		if (memberCommand.getCountry() == null || memberCommand.getCountry().trim().length() == 0) {
			errors.rejectValue("country", "country.blank");
		}
	}
}
