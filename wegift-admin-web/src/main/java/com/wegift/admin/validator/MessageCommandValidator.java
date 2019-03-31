package com.wegift.admin.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.wegift.command.MessageCommand;

@Component
public class MessageCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(MessageCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		MessageCommand messageCommand = (MessageCommand) command;

		if (isEmpty(messageCommand.getFirstName())) {
			errors.rejectValue("firstName", "firstName.blank");
		}
		if (isEmpty(messageCommand.getLastName())) {
			errors.rejectValue("lastName", "lastName.blank");
		}
		if (isEmpty(messageCommand.getEmail())) {
			errors.rejectValue("email", "email.blank");
		}
		if (isEmpty(messageCommand.getSubject())) {
			errors.rejectValue("subject", "subject.blank");
		}
		if (isEmpty(messageCommand.getMessage())) {
			errors.rejectValue("message", "message.blank");
		}

	}

	public boolean isEmpty(String value) {
		if (value == null || "".equals(value)) {
			return true;
		}
		return false;
	}

}
