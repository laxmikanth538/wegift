package com.wegift.dto;

import java.io.Serializable;

public class MerchantEnquiryDto implements Serializable {
	
	private static final long serialVersionUID = -4466909287797390688L;
	
	protected int merchantEnquiryId;
	protected String organizationName;
	protected String merchantLocation;
	protected String contactPerson;
	protected String contactNo;
	protected String status;
	public MerchantEnquiryDto(int merchantEnquiryId, String organizationName, String merchantLocation,
			String contactPerson, String contactNo, String status) {
		super();
		this.merchantEnquiryId = merchantEnquiryId;
		this.organizationName = organizationName;
		this.merchantLocation = merchantLocation;
		this.contactPerson = contactPerson;
		this.contactNo = contactNo;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
