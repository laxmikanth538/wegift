package com.wegift.admin.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.wegift.command.MerchantCommand;
import com.wegift.constants.ErrorReport;
import com.wegift.service.ManageMerchantService;
import com.wegift.validation.WeGiftPerfectValidator;

@Component("merchantCommandValidator")
public class MerchantCommandValidator implements Validator {

	@Autowired
	ManageMerchantService manageMerchantService;
	
	@Override
	public boolean supports(Class<?> classType) {
		return classType.isAssignableFrom(MerchantCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		MerchantCommand merchantCommand = null;

		merchantCommand = (MerchantCommand) command;

		String firstNameStatus = WeGiftPerfectValidator.isFirstNamePerfect(merchantCommand.getFirstName());
		if (firstNameStatus.equals(ErrorReport.EMPTY)) {
			errors.rejectValue("firstName", "firstName.empty");
		} else if (firstNameStatus.equals(ErrorReport.STRING_LESS_THAN_SIX)) {
			errors.rejectValue("firstName", "firstName.shortString");
		}

		String lastNameStatus = WeGiftPerfectValidator.isLastNamePerfect(merchantCommand.getLastName());
		if (lastNameStatus.equals(ErrorReport.EMPTY)) {
			errors.rejectValue("lastName", "lastName.empty");
		}

		String pContactNo = WeGiftPerfectValidator.isContactNOPerfect(merchantCommand.getPrimaryContactNo());
		if (pContactNo.equals(ErrorReport.EMPTY)) {
			errors.rejectValue("primaryContactNo", "primaryContactNo.empty");
		} else if (pContactNo.equals(ErrorReport.MOBILE_CHECK)) {
			errors.rejectValue("primaryContactNo", "primaryContactNo.lessThan10Digits");
		}else if(pContactNo.equals(ErrorReport.MOBILE_INITIAL_NO)){
			errors.rejectValue("primaryContactNo", "primaryContactNo.NoSpecialChar");
		}
		
		if(manageMerchantService.mobileCheckInMerchantDB(merchantCommand.getPrimaryContactNo()) == true){
			errors.rejectValue("primaryContactNo", "mobile.exists");
		}

		String sContactNo = WeGiftPerfectValidator.isContactNOPerfect(merchantCommand.getAlternateContactNo());
		if (sContactNo.equals(ErrorReport.MOBILE_CHECK)) {
			errors.rejectValue("alternateContactNo", "alternateContactNo.lessThan10Digits");
		}

		String pEmailStatus = WeGiftPerfectValidator.isEmailPerfect(merchantCommand.getPrimaryEmailAddress());
		if (pEmailStatus.equals(ErrorReport.EMPTY)) {
			errors.rejectValue("primaryEmailAddress", "primaryEmail.empty");
		} else if (pEmailStatus.equals(ErrorReport.NO_PROPER_MAIL)) {
			errors.rejectValue("primaryEmailAddress", "primaryEmail.noProperMail");
		}else if(pEmailStatus.equals(ErrorReport.GMAIL_CHECK_FAIL)){
			errors.rejectValue("primaryEmailAddress", "mail.acceptingFormat");
		}
		
		if(manageMerchantService.mailCheckInMerchantDB(merchantCommand.getPrimaryEmailAddress()) == true){
			errors.rejectValue("primaryEmailAddress", "mail.exists");
		}

		String aEmailStatus = WeGiftPerfectValidator.isEmailPerfect(merchantCommand.getAlternateEmailAddress());
		if (aEmailStatus.equals(ErrorReport.NO_PROPER_MAIL)) {
			errors.rejectValue("alternateEmailAddress", "alternateEmail.noProperMail");
		}

		String descriptionStatus = WeGiftPerfectValidator.checkDescriptionPerefect(merchantCommand.getDescription());
		if (descriptionStatus.equals(ErrorReport.EMPTY)) {
			errors.rejectValue("description", "description.empty");
		} else if (descriptionStatus.equals(ErrorReport.LESS_THAN_20)) {
			errors.rejectValue("description", "description.lessThan20");
		}

		String addressLine1Status = WeGiftPerfectValidator.isAddressLine1Perfect(merchantCommand.getAddressLine1());
		if (addressLine1Status.equals(ErrorReport.EMPTY)) {
			errors.rejectValue("addressLine1", "primaryAddressLine1.empty");
		}

		String pPinStatus = WeGiftPerfectValidator.isZipPerfect(merchantCommand.getZip());
		if (pPinStatus.equals(ErrorReport.ZERO)) {
			errors.rejectValue("zip", "primaryAddressPin.invalid");
		} else if (pPinStatus.equals(ErrorReport.ZIP_CHECK)) {
			errors.rejectValue("zip", "primaryAddressPin.notProper");
		}

		if (merchantCommand.getMerchantLogo().isEmpty()) {
			errors.rejectValue("merchantLogo", "merchantLogo.notSelected");
		} /*
			 * else if (merchantCommand.getMerchantLogo().getSize() > (1024 *
			 * 5)) { errors.rejectValue("merchantLogo",
			 * "merchantLogo.sizeExceeds5MB"); }
			 */

	}

}
