package com.wegift.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WG_REG_UNIQUE")
public class RegUnique {

	@Id
	@Column(name = "SNO")
	private int sno;
	@Column(name = "MERCHANT_ID")
	private int merchantId;
	@Column(name = "REG_UNIQUE_NO")
	private String regUniqueNo;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
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
