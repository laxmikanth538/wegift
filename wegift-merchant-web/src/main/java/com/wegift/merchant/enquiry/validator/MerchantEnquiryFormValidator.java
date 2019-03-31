package com.wegift.merchant.enquiry.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.wegift.constants.ErrorReport;
import com.wegift.merchant.enquiry.form.MerchantEnquiryForm;
import com.wegift.service.ManageMerchantService;
import com.wegift.validation.WeGiftPerfectValidator;

@Component("merchantEnquiryFormValidator")
public class MerchantEnquiryFormValidator implements Validator {
	
	@Autowired
	ManageMerchantService manageMerchantService;
	
	@Override
	public boolean supports(Class<?> classType) {
		return classType.isAssignableFrom(MerchantEnquiryForm.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		MerchantEnquiryForm form = null;

		form = (MerchantEnquiryForm) command;

		String orgNameStatus = WeGiftPerfectValidator.isOrganizationNamePerfect(form.getOrgName());
		if (orgNameStatus.equals(ErrorReport.EMPTY)) {
			errors.rejectValue("orgName", "organizationName.emty");
		}
		if (orgNameStatus.equals(ErrorReport.STRING_LESS_THAN_SIX)) {
			errors.rejectValue("orgName", "organizationName.shortString");
		}
		if(orgNameStatus.equals(ErrorReport.VALID)){
			if(manageMerchantService.merchantEnqOrgCheckDB(form.getOrgName())){
				errors.rejectValue("orgName", "organizationName.exist");
			}
		}

		String businessTypeStatus = WeGiftPerfectValidator.isBusinessTypePerfect(form.getBusinessType());
		if (businessTypeStatus.equals(ErrorReport.EMPTY)) {
			errors.rejectValue("businessType", "businessType.empty");
		}
		if (businessTypeStatus.equals(ErrorReport.STRING_LESS_THAN_SIX)) {
			errors.rejectValue("businessType", "businessType.shortString");
		}

		String yaerOfEstdStatus = WeGiftPerfectValidator.isYearOfEstdPerfect(form.getYearOfEstd());
		if (yaerOfEstdStatus.equals(ErrorReport.INVALID_YEAR)) {
			errors.rejectValue("yearOfEstd", "yearOfEstd.invalid");
		}
		
		String locationStatus = WeGiftPerfectValidator.isLoactionPerfect(form.getMerchantLocation());
		if(locationStatus.equals(ErrorReport.EMPTY)){
			errors.rejectValue("merchantLocation", "merchantLocation.empty");
		}
		
		String contactPersonStatus = WeGiftPerfectValidator.isContactPersonPerfect(form.getContactPerson());
		if (contactPersonStatus.equals(ErrorReport.EMPTY)) {
			errors.rejectValue("contactPerson", "contactPerson.empty");
		}
		if (contactPersonStatus.equals(ErrorReport.STRING_LESS_THAN_SIX)) {
			errors.rejectValue("contactPerson", "contactPerson.shortString");
		}

		String contactNoStatus = WeGiftPerfectValidator.isContactNOPerfect(form.getContactNo());
		if (contactNoStatus.equals(ErrorReport.EMPTY)) {
			errors.rejectValue("contactNo", "contactNo.empty");
		}
		if (contactNoStatus.equals(ErrorReport.MOBILE_CHECK)) {
			errors.rejectValue("contactNo", "contactNo.invalid");
		}
		if(contactNoStatus.equals(ErrorReport.MOBILE_INITIAL_NO)){
			errors.rejectValue("contactNo", "contactNo.noSpecialChar");
		}
		if(contactNoStatus.equals(ErrorReport.VALID)){
			if(manageMerchantService.merchantEnqContactCheckInDB(form.getContactNo())){
				errors.rejectValue("contactNo", "contactNo.exist");
			}
		}

		String contactEmailStatus = WeGiftPerfectValidator.isEmailPerfect(form.getContactEmail());
		if (contactEmailStatus.equals(ErrorReport.EMPTY)) {
			errors.rejectValue("contactEmail", "contactEmail.empty");
		}
		if (contactEmailStatus.equals(ErrorReport.NO_PROPER_MAIL)) {
			errors.rejectValue("contactEmail", "contactEmail.noProperMail");
		}
		if (contactEmailStatus.equals(ErrorReport.GMAIL_CHECK_FAIL)) {
			errors.rejectValue("contactEmail", "contactEmail.acceptingFormat");
		}
		if(contactEmailStatus.equals(ErrorReport.VALID)){
			if(manageMerchantService.merchantEnqMailCheckInDB(form.getContactEmail())){
				errors.rejectValue("contactEmail", "contactEmail.exist");
			}
		}
	}
}
