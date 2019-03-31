package com.wegift.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "WG_MERCHANT_ENQUIRY")
public class MerchantEnquiryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MERCHANT_ENQUIRY_ID")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	protected int merchantEnquiryId;
	@Column(name = "MERCHANT_NAME")
	protected String organizationName;
	@Column(name = "BUSINESS_TYPE")
	protected String businessType;
	@Column(name = "ESTD_YEAR")
	protected int yearOfEstd;
	@Column(name = "CONTACT_PERSON_NAME")
	protected String contactPerson;
	@Column(name = "MERCHANT_LOCATION")
	protected String merchantLocation;
	@Column(name = "CONTACT_NO")
	protected String contactNo;
	@Column(name = "CONTACT_EMAIL")
	protected String contactEmail;
	@Column(name = "DESCRIPTION")
	protected String description;
	protected String status;

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

	public int getYearOfEstd() {
		return yearOfEstd;
	}

	public void setYearOfEstd(int yearOfEstd) {
		this.yearOfEstd = yearOfEstd;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getMerchantLocation() {
		return merchantLocation;
	}

	public void setMerchantLocation(String merchantLocation) {
		this.merchantLocation = merchantLocation;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
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
