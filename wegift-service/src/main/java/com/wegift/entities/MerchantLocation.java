package com.wegift.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "WG_MERCHANT_LOCATION")
public class MerchantLocation implements Serializable {
	
	/**
	 * shelly
	 */
	private static final long serialVersionUID = 5494829132168035787L;


	@Id
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "increment")
	@Column(name = "MERCHANT_LOCATION_ID")
	protected int merchantLocationId;
	
	
	@Column(name = "MERCHANT_LOCATION_NAME")
    protected String merchantLocationName;
	@Column(name = "LOCATION_MANAGER_NAME")
	protected String locationManagerName;
	@Column(name = "LOCATION_CONTACT_NO")
	protected String locationContactNo;
	@Column(name = "MERCHANT_LOCATION_IMAGE_BYTES")
	protected byte[] merchantLocationImageBytes;
	@Column(name = "MERCHANT_LOCATION_IMAGE_FILE_NAME")
	protected String merchantLocationImageFileName;
	@Column(name = "MERCHANT_LOCATION_IMAGE_TYPE")
	protected String merchantLocationImageType;
	@Column(name = "LOCATION_EMAIL_ADDRESS")
	protected String locationEmailAddress;
	
	@Column(name = "MERCHANT_ID")
	protected String merchantId;
	
/*	@Column(name = "MERCHANT_ADD_LOATION_ID")
	@OneToMany(mappedBy = "MerchantLocation")*/
	protected Address merchantLocationAddressId;
	

	public int getMerchantLocationId() {
		return merchantLocationId;
	}

	public void setMerchantLocationId(int merchantLocationId) {
		this.merchantLocationId = merchantLocationId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}



	public Address getMerchantLocationAddressId() {
		return merchantLocationAddressId;
	}

	public void setMerchantLocationAddressId(Address merchantLocationAddressId) {
		this.merchantLocationAddressId = merchantLocationAddressId;
	}

	
	public String getMerchantLocationName() {
		return merchantLocationName;
	}

	public void setMerchantLocationName(String merchantLocationName) {
		this.merchantLocationName = merchantLocationName;
	}

	public String getLocationManagerName() {
		return locationManagerName;
	}

	public void setLocationManagerName(String locationManagerName) {
		this.locationManagerName = locationManagerName;
	}

	public String getLocationContactNo() {
		return locationContactNo;
	}

	public void setLocationContactNo(String locationContactNo ) {
		this.locationContactNo = locationContactNo;
	}

	public byte[] getMerchantLocationImageBytes() {
		return merchantLocationImageBytes;
	}

	public void setMerchantLocationImageBytes(byte[] bs) {
		this.merchantLocationImageBytes = bs;
	}

	public String getMerchantLocationImageFileName() {
		return merchantLocationImageFileName;
	}

	public void setMerchantLocationImageFileName(String merchantLocationImageFileName) {
		this.merchantLocationImageFileName = merchantLocationImageFileName;
	}

	public String getMerchantLocationImageType() {
		return merchantLocationImageType;
	}

	public void setMerchantLocationImageType(String merchantLocationImageType) {
		this.merchantLocationImageType = merchantLocationImageType;
	}

	public String getLocationEmailAddress() {
		return locationEmailAddress;
	}

	public void setLocationEmailAddress(String locationEmailAddress) {
		this.locationEmailAddress = locationEmailAddress;
	}
	
	

	
	
	
	
	

}
