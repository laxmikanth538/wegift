package com.wegift.bo;

public class RegCriteriaBo {

	private int merchantId;
	private String regUniqueNo;

	public RegCriteriaBo(int merchantId, String regUniqueNo) {
		this.merchantId = merchantId;
		this.regUniqueNo = regUniqueNo;
	}

	public RegCriteriaBo() {
	}

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public String getRegUniqueNo() {
		return regUniqueNo;
	}

	public void setRegUniqueNo(String regUniqueNo) {
		this.regUniqueNo = regUniqueNo;
	}

}
