package com.wegift.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wegift.constants.ErrorReport;

/*
 * This Validator class is special to normal validator, 
 * granular checks has been done in this validations. 
 * So that easily we can distinguish the validation error perfectly
 * 
 * It expected to return the perfect outcome, depends on the input
 */
public class WeGiftPerfectValidator extends WeGiftValidator {

	public static String isOrganizationNamePerfect(String organizationName) {
		String status = ErrorReport.VALID;

		if (organizationName == null || organizationName.trim().length() <= 0) {
			status = ErrorReport.EMPTY;
		} else if (organizationName.trim().length() < 6) {
			status = ErrorReport.STRING_LESS_THAN_SIX;
		}
		return status;
	}

	public static String isBusinessTypePerfect(String businessType) {
		String status = ErrorReport.VALID;

		if (businessType == null || businessType.trim().length() <= 0) {
			status = ErrorReport.EMPTY;
		} else if (businessType.trim().length() < 6) {
			status = ErrorReport.STRING_LESS_THAN_SIX;
		}
		return status;
	}

	public static String isYearOfEstdPerfect(int year) {
		String status = ErrorReport.VALID;
		int length = String.valueOf(year).length();
		if (length < 4 || length > 4) {
			status = ErrorReport.INVALID_YEAR;
		}
		return status;
	}
	
	public static String isLoactionPerfect(String location){
		String status = ErrorReport.VALID;
		if(location == null || location.trim().length()<=0){
			status = ErrorReport.EMPTY;
		}
		return status;
	}

	public static String isContactPersonPerfect(String contactPerson) {
		String status = ErrorReport.VALID;

		if (contactPerson == null || contactPerson.trim().length() <= 0) {
			status = ErrorReport.EMPTY;
		} else if (contactPerson.trim().length() < 6) {
			status = ErrorReport.STRING_LESS_THAN_SIX;
		}
		return status;
	}

	public static String isFirstNamePerfect(String firstName) {
		String status = ErrorReport.VALID;

		if (firstName == null || firstName.trim().length() <= 0) {
			status = ErrorReport.EMPTY;
		} else if (firstName.trim().length() < 6) {
			status = ErrorReport.STRING_LESS_THAN_SIX;
		}
		return status;
	}

	public static String isLastNamePerfect(String lastName) {
		String status = ErrorReport.VALID;
		if (lastName == null || lastName.trim().length() <= 0) {
			status = ErrorReport.EMPTY;
		}
		return status;
	}

	// MerchantCommandValidator
	public static String isContactNOPerfect(String contactNo) {
		String status = ErrorReport.VALID;

		if (contactNo == null || contactNo.trim().length() <= 0) {
			return ErrorReport.EMPTY;
		} else if (contactNo.trim().length() < 10 || contactNo.trim().length() > 12) {
			return ErrorReport.MOBILE_CHECK;
		}

		String mobilePattern = "(0|91)?[0-9]{10}";
		Pattern mobileP = Pattern.compile(mobilePattern);

		Matcher mobileM = mobileP.matcher(contactNo);

		if (mobileM.matches()) {
			status = ErrorReport.VALID;
		} else {
			status = ErrorReport.MOBILE_INITIAL_NO;
		}

		return status;
	}

	public static String isAddressLine1Perfect(String addressLine1) {
		String status = ErrorReport.VALID;

		if (addressLine1 == null || addressLine1.trim().length() <= 0) {
			status = ErrorReport.EMPTY;
		}

		return status;
	}

	public static String isZipPerfect(int zip) {
		String status = ErrorReport.VALID;
		if (zip == 0) {
			status = ErrorReport.EMPTY;
		} else if (zip > 999999) {
			status = ErrorReport.ZIP_CHECK;
		}

		return status;
	}

	public static String isEmailPerfect(String mailAddress) {
		String status = ErrorReport.VALID;

		if (mailAddress == null || mailAddress.trim().length() <= 0) {
			return ErrorReport.EMPTY;
		}

		String mailPattern = "[a-zA-Z][a-zA-Z0-9$_.]+@[a-z.-]+[.][a-z]{2,5}";
		Pattern mailP = Pattern.compile(mailPattern,Pattern.CASE_INSENSITIVE);

		String gmailPattern = "[a-zA-Z][a-zA-Z0-9$_.]+@gmail[.]com";
		Pattern p = Pattern.compile(gmailPattern);

		String sForceMailPattern = "[a-zA-Z][a-zA-Z0-9$_.]+@s-force[.]org";
		Pattern p1 = Pattern.compile(sForceMailPattern);

		Matcher m = mailP.matcher(mailAddress);
		if (m.matches()) {
			status = ErrorReport.VALID;
			Matcher m1 = p.matcher(mailAddress);
			Matcher m2 = p1.matcher(mailAddress);

			if (m1.matches() || m2.matches()) {
				status = ErrorReport.VALID;
			} else {
				status = ErrorReport.GMAIL_CHECK_FAIL;
			}
			/*
			 * if (m2.find()) { status = ErrorReport.VALID; } else { status =
			 * ErrorReport.SFORCEMAIL_CHECK_FAIL; }
			 */
		} else {
			status = ErrorReport.NO_PROPER_MAIL;
		}

		return status;
	}

	public static String checkDescriptionPerefect(String description) {
		String status = ErrorReport.VALID;
		if (description == null || description.trim().length() <= 0) {
			status = ErrorReport.EMPTY;
		} else if (description.chars().count() < 20) {
			status = ErrorReport.LESS_THAN_20;
		}
		return status;
	}
	
	public static String isMerchantLocationPerfect(String merchantLocation) {
		String status = ErrorReport.VALID;

		if ( merchantLocation == null ||  merchantLocation.trim().length() <= 0) {
			status = ErrorReport.EMPTY;
		}
		return status;
	}

}
