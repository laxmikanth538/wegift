package com.wegift.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "WG_ADDRESS")
public class Address {

	@Id
	@Column(name = "ADDRESS_ID")
	@GenericGenerator(name = "incGen", strategy = "increment")
	@GeneratedValue(generator = "incGen")
	private int addressId;
	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;
	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	private int zip;
	private String country;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MERCHANT_ID", nullable = false)
	private Merchant merchant;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MEMBER_ID", nullable = false)
	private Member member;
	
/*	//For merchant location address
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="MERCHANT_LOCATION_ID",nullable=false)*/
	private MerchantLocation merchantLocation;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
    
	//For merchant location
	public MerchantLocation getMerchantLocation() {
		return merchantLocation;
	}

	public void setMerchantLocation(MerchantLocation merchantLocation) {
		this.merchantLocation = merchantLocation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

}
