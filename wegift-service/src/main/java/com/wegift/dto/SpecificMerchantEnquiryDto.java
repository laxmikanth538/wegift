package com.wegift.dto;

import java.io.Serializable;

public class SpecificMerchantEnquiryDto implements Serializable {

	private static final long serialVersionUID = 2848560562492868481L;

	protected int merchantEnquiryId;
	protected String organizationName;
	protected String businessType;
	protected int estdYear;
	protected String merchantLocation;
	protected String contactPerson;
	protected String contactNo;
	protected String contactMail;
	protected String description;
	protected String status;

	public SpecificMerchantEnquiryDto(int merchantEnquiryId, String organizationName, String businessType, int estdYear,
			String merchantLocation, String contactPerson, String contactNo, String contactMail, String description,
			String status) {
		super();
		this.merchantEnquiryId = merchantEnquiryId;
		this.organizationName = organizationName;
		this.businessType = businessType;
		this.estdYear = estdYear;
		this.merchantLocation = merchantLocation;
		this.contactPerson = contactPerson;
		this.contactNo = contactNo;
		this.contactMail = contactMail;
		this.description = description;
		this.status = status;
	}

	public int getMerchantEnquiryId() {
		return merchantEnquiryId;
	}

	public void setMerchantEnquiryId(int merchantEnquiryId) {
		this.merchantEnquiryId = merchantEnquiryId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public int getEstdYear() {
		return estdYear;
	}

	public void setEstdYear(int estdYear) {
		this.estdYear = estdYear;
	}

	public String getMerchantLocation() {
		return merchantLocation;
	}

	public void setMerchantLocation(String merchantLocation) {
		this.merchantLocation = merchantLocation;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getContactMail() {
		return contactMail;
	}

	public void setContactMail(String contactMail) {
		this.contactMail = contactMail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {

		this.status = status;
	}
}
