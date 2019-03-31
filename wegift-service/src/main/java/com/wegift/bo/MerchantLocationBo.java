package com.wegift.bo;



public class MerchantLocationBo {
	
	
	protected String merchantLocationName;
	protected String locationManagerName;
	protected String locationContactNo;
	protected String locationEmailAddress;
	protected byte[] merchantLocationImageBytes;
	protected String merchantLocationImageFileName;
	protected String merchantLocationImageType;
	protected AddressBo merchantLocationAddress;

	
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
	public void setLocationContactNo(String string) {
		this.locationContactNo = string;
	}
	
	public String getLocationEmailAddress() {
		return locationEmailAddress;
	}
	public void setLocationEmailAddress(String locationEmailAddress) {
		this.locationEmailAddress = locationEmailAddress;
	}
	
	public AddressBo getMerchantLocationAddress() {
		return merchantLocationAddress;
	}
	public void setMerchantLocationAddress(AddressBo merchantLocationAddress) {
		this.merchantLocationAddress = merchantLocationAddress;
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
	public byte[] getMerchantLocationImageBytes() {
		return merchantLocationImageBytes;
	}
	public void setMerchantLocationImageBytes(byte[] merchantLocationImageBytes) {
		this.merchantLocationImageBytes = merchantLocationImageBytes;
	}
	
	
	
	

}
