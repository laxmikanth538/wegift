package com.wegift.merchant.registration.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.wegift.admin.validator.MessageCommandValidator;
import com.wegift.bo.FieldErrors;
import com.wegift.command.MessageCommand;

@Controller
@EnableWebMvc
public class ContactMessageController {

	@Autowired
	MessageCommandValidator validator;

	@Autowired
	MessageSource messageSource;

	List<FieldError> springErrors;
	FieldErrors formErrors;

	@RequestMapping(value = "/message.json", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public ResponseEntity<?> validate(Model model, @RequestBody MessageCommand message, BindingResult errors) {

		if (validator.supports(message.getClass())) {
			validator.validate(message, errors);

			formErrors = new FieldErrors();

			if (errors.hasErrors()) {
				springErrors = errors.getFieldErrors();

				for (FieldError error : springErrors) {
					formErrors.addError(error.getField(),
							messageSource.getMessage(error.getCode(), null, Locale.getDefault()));
				}
				return new ResponseEntity(formErrors, HttpStatus.BAD_REQUEST);
			}
		}
		 
		return new ResponseEntity("Your message has been received successfully", HttpStatus.OK);
	}

}
