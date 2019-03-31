package com.wegift.member.command;

import java.io.Serializable;

public class MemberUpdateForm implements Serializable {

	private static final long serialVersionUID = 6479381823386941882L;

	protected String OnlineUserId;
	protected String userName;
	protected String password;
	protected String rePassword;

	public String getOnlineUserId() {
		return OnlineUserId;
	}

	public void setOnlineUserId(String onlineUserId) {
		OnlineUserId = onlineUserId;
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

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}