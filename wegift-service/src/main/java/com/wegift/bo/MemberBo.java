package com.wegift.bo;

import java.io.Serializable;
import java.util.Date;

public class MemberBo implements Serializable {

	private static final long serialVersionUID = -1726167745302455944L;

	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String mobile;
	private String email;

	AddressBo addressBo;

	CardBo cardBo;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AddressBo getAddressBo() {
		return addressBo;
	}

	public void setAddressBo(AddressBo addressBo) {
		this.addressBo = addressBo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CardBo getCardBo() {
		return cardBo;
	}

	public void setCardBo(CardBo cardBo) {
		this.cardBo = cardBo;
	}

}
