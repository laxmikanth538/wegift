package com.wegift.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "WG_MERCHANT")
public class Merchant {

	@Id
	@Column(name = "MERCHANT_ID")
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private int merchantId;
	@Column(name = "MERCHANT_FIRST_NAME")
	private String firstName;
	@Column(name = "MERCHANT_LAST_NAME")
	private String lastName;
	@Column(name = "PRIMARY_CONTACT_NO")
	private String pContactNo;
	@Column(name = "ALTERNATE_CONTACT_NO")
	private String aContactNo;
	@Column(name = "PRIMARY_EMAIL_ADDRESS")
	private String pEmailAddress;
	@Column(name = "ALTERNATE_EMAIL_ADDRESS")
	private String aEmailAddress;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "MERCHANT_LOGO_FILE_NAME")
	private String merchantLogoFileName;
	@Column(name = "MERCHANT_LOGO_FILE_TYPE")
	private String merchantLogoFileType;
	@Column(name = "MERCHANT_LOGO_BYTES")
	private byte[] merchantAddressFileBytes;
	@Column(name = "STATUS")
	private String status;

	@OneToMany(mappedBy="merchant")
	private Set<Address> addresses;

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

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

	public String getpContactNo() {
		return pContactNo;
	}

	public void setpContactNo(String pContactNo) {
		this.pContactNo = pContactNo;
	}

	public String getaContactNo() {
		return aContactNo;
	}

	public void setaContactNo(String aContactNo) {
		this.aContactNo = aContactNo;
	}

	public String getpEmailAddress() {
		return pEmailAddress;
	}

	public void setpEmailAddress(String pEmailAddress) {
		this.pEmailAddress = pEmailAddress;
	}

	public String getaEmailAddress() {
		return aEmailAddress;
	}

	public void setaEmailAddress(String aEmailAddress) {
		this.aEmailAddress = aEmailAddress;
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

	public byte[] getMerchantAddressFileBytes() {
		return merchantAddressFileBytes;
	}

	public void setMerchantAddressFileBytes(byte[] merchantAddressFileBytes) {
		this.merchantAddressFileBytes = merchantAddressFileBytes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
