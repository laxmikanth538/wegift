package com.wegift.bo;

import java.io.Serializable;
import java.util.Date;

import com.wegift.entities.Member;
import com.wegift.entities.Merchant;
import com.wegift.entities.UserRole;

public class OnlineUsersBo implements Serializable{

	private static final long serialVersionUID = -333682866339948734L;
	
	protected int onlineUserId;
	protected String userName;
	protected String password;
	protected Date activatedDate;
	protected String activationCode;
	protected Date terminationDate;
	protected String status;

	protected Merchant onlineMerchant;
	protected Member onlineMember;
	protected UserRole role;

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

	public Merchant getOnlineMerchant() {
		return onlineMerchant;
	}

	public void setOnlineMerchant(Merchant onlineMerchant) {
		this.onlineMerchant = onlineMerchant;
	}

	public Member getOnlineMember() {
		return onlineMember;
	}

	public void setOnlineMember(Member onlineMember) {
		this.onlineMember = onlineMember;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

}