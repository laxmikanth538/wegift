package com.wegift.entities;

import java.io.Serializable;
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
@Table(name = "WG_ONLINE_USERS")
public class OnlineUser implements Serializable {

	private static final long serialVersionUID = 1055658842634339195L;
	
	@Id
	@Column(name = "ONLINE_USER_ID")
	@GeneratedValue(generator = "idGen")
	@GenericGenerator(name = "idGen", strategy = "increment")
	protected int onlineUserId;
	@Column(name = "USER_NAME")
	protected String userName;
	@Column(name = "PASSWORD")
	protected String password;
	@Column(name = "ACTIVATED_DATE")
	protected Date activatedDate;
	@Column(name = "ACTIVATION_CODE")
	protected String activationCode;
	@Column(name = "TERMINATION_DATE")
	protected Date terminationDate;
	@Column(name = "STATUS")
	protected String status;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MEMBER_ID", nullable = false)
	private Member member;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MERCHANT_ID", nullable = false)
	private Merchant merchant;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	private UserRole role;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getOnlineUserId() {
		return onlineUserId;
	}

	public void setOnlineUserId(int onlineUserId) {
		this.onlineUserId = onlineUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getActivatedDate() {
		return activatedDate;
	}

	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
}
