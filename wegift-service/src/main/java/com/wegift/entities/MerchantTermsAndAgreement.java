package com.wegift.entities;

import java.util.Date;

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
@Table(name = "WG_MERCHANT_TERMS_AND_AGREEMENTS")
public class MerchantTermsAndAgreement {

	@Id
	@Column(name = "MERCHANT_TERMS_AND_AGREEMENT_ID")
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	private int merchantTermsAndAgreementsId;
	@Column(name = "TERMS_AND_CONDITIONS_EFFECTIVE_DATE")
	private Date termsAndConditionsEffectiveDate;
	@Column(name = "TERMS_AND_CONDITIONS_END_DATE")
	private Date termsAndConditionsEndDate;
	@Column(name = "SETTLEMENT_PERIOD")
	private int settlementPeriod;
	@Column(name = "REWARD_CHARGES")
	private float rewardCharges;
	@Column(name = "REDEEM_CHARGES")
	private float redeemCharges;
	@Column(name = "ANNUAL_MAINTAINANCE_CHARGES")
	private float annualMaintainanceCharge;
	@Column(name = "STATUS")
	private String status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MERCHANT_ID", nullable = false)
	private Merchant merchant;

	public int getMerchantTermsAndAgreementsId() {
		return merchantTermsAndAgreementsId;
	}

	public void setMerchantTermsAndAgreementsId(int merchantTermsAndAgreementsId) {
		this.merchantTermsAndAgreementsId = merchantTermsAndAgreementsId;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Date getTermsAndConditionsEffectiveDate() {
		return termsAndConditionsEffectiveDate;
	}

	public void setTermsAndConditionsEffectiveDate(Date termsAndConditionsEffectiveDate) {
		this.termsAndConditionsEffectiveDate = termsAndConditionsEffectiveDate;
	}

	public Date getTermsAndConditionsEndDate() {
		return termsAndConditionsEndDate;
	}

	public void setTermsAndConditionsEndDate(Date termsAndConditionsEndDate) {
		this.termsAndConditionsEndDate = termsAndConditionsEndDate;
	}

	public int getSettlementPeriod() {
		return settlementPeriod;
	}

	public void setSettlementPeriod(int settlementPeriod) {
		this.settlementPeriod = settlementPeriod;
	}

	public float getRewardCharges() {
		return rewardCharges;
	}

	public void setRewardCharges(float rewardCharges) {
		this.rewardCharges = rewardCharges;
	}

	public float getRedeemCharges() {
		return redeemCharges;
	}

	public void setRedeemCharges(float redeemCharges) {
		this.redeemCharges = redeemCharges;
	}

	public float getAnnualMaintainanceCharge() {
		return annualMaintainanceCharge;
	}

	public void setAnnualMaintainanceCharge(float annualMaintainanceCharge) {
		this.annualMaintainanceCharge = annualMaintainanceCharge;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
