package com.wegift.validation;

/*
 * One can use this validator in an simple manner, it just results an true or false outcomes
 * 
 * All method in this class are static and we provided an high level validation
 */
public class WeGiftValidator {

	public static boolean isFirstNameValid(String firstName) {

		if (firstName == null || firstName.trim().length() < 0) {
			return false;
		} else if (firstName.trim().length() < 6) {
			return false;
		}
		return true;
	}

	public static boolean isLastNameValid(String lastName) {
		if (lastName == null || lastName.trim().length() < 0) {
			return false;
		}
		return true;
	}

	public static boolean isContactNOValid(String contactNo) {
		if (contactNo == null || contactNo.trim().length() < 0) {
			return false;
		} else if (contactNo.trim().length() < 10) {
			return false;
		}

		return true;
	}

	public static boolean isAddressLine1Valid(String addressLine1) {

		if (addressLine1 == null || addressLine1.trim().length() < 0) {
			return false;
		}

		return true;
	}

	public static boolean isZipValid(Integer zip) {
		if (zip == 0) {
			return false;
		} else if (zip < 999999) {
			return false;
		}

		return true;
	}

	public static boolean isEmailValid(String emailAddress) {

		if (emailAddress == null || emailAddress.trim().length() < 0) {
			return false;
		} else if (emailAddress.endsWith("@gmail.com")) {
			return false;
		}/* else if (emailAddress.matches("{[a-zA-Z0-9]*@[a-z].com}")) {
			return false;
		}*/
		return true;
	}

	public static boolean checkDescription(String description) {
		if (description == null || description.trim().length() < 0) {
			return false;
		} else if (description.chars().count() < 20) {
			return false;
		}
		return true;
	}

}
