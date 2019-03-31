package com.wegift.mail.bo;

import java.io.Serializable;

public class MailMessageSkeleton implements Serializable {

	private static final long serialVersionUID = 450984054620423062L;

	private String[] toMailer;
	private String messageBody;
	private String subject;

	public String[] getToMailer() {
		return toMailer;
	}

	public void setToMailer(String[] toMailer) {
		this.toMailer = toMailer;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
