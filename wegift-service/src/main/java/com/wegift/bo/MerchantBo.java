package com.wegift.bo;

import java.io.Serializable;
import java.util.Set;

public class MerchantBo implements Serializable {

	private static final long serialVersionUID = -6557146774769083004L;

	private String firstName;
	private String lastName;
	private String primaryContactNo;
	private String alternateContactNo;
	private String primaryEmailAddress;
	private String alternateEmailAddress;
	private String description;
	private String merchantLogoFileName;
	private String merchantLogoFileType;
	private byte[] merchantLogoFileBytes;

	private Set<AddressBo> addresses;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPrimaryContactNo() {
		return primaryContactNo;
	}

	public void setPrimaryContactNo(String primaryContactNo) {
		this.primaryContactNo = primaryContactNo;
	}

	public String getAlternateContactNo() {
		return alternateContactNo;
	}

	public void setAlternateContactNo(String alternateContactNo) {
		this.alternateContactNo = alternateContactNo;
	}

	public String getPrimaryEmailAddress() {
		return primaryEmailAddress;
	}

	public void setPrimaryEmailAddress(String primaryEmailAddress) {
		this.primaryEmailAddress = primaryEmailAddress;
	}

	public String getAlternateEmailAddress() {
		return alternateEmailAddress;
	}

	public void setAlternateEmailAddress(String alternateEmailAddress) {
		this.alternateEmailAddress = alternateEmailAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMerchantLogoFileName() {
		return merchantLogoFileName;
	}

	public void setMerchantLogoFileName(String merchantLogoFileName) {
		this.merchantLogoFileName = merchantLogoFileName;
	}

	public String getMerchantLogoFileType() {
		return merchantLogoFileType;
	}

	public void setMerchantLogoFileType(String merchantLogoFileType) {
		this.merchantLogoFileType = merchantLogoFileType;
	}

	public byte[] getMerchantLogoFileBytes() {
		return merchantLogoFileBytes;
	}

	public void setMerchantLogoFileBytes(byte[] merchantLogoFileBytes) {
		this.merchantLogoFileBytes = merchantLogoFileBytes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<AddressBo> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<AddressBo> addresses) {
		this.addresses = addresses;
	}

}
