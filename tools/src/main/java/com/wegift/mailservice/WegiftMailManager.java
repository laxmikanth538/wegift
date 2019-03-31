package com.wegift.mailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wegift.constants.WeGiftConstants;
import com.wegift.exceptions.MailSendingFailedException;
import com.wegift.mail.bo.MailMessageSkeleton;

@Service("wegiftMailManager")
public class WegiftMailManager {

	@Autowired
	@Qualifier("gmailSender")
	private JavaMailSender gMailSender;

	@Autowired
	@Qualifier("sForceMailSender")
	private JavaMailSender sforceMailSender;

	public void notifyMailer(MailMessageSkeleton content) {

		String[] toMails = null;

		try {
			toMails = content.getToMailer();

			for (String toMail : toMails) {
				if (toMail.endsWith("@gmail.com")) {
					sendGmail(content);
				} else if (toMail.endsWith("@s-force.org")) {
					sendSForceMail(content);
				}
			}
		} catch (Exception e) {
			throw new MailSendingFailedException("WGERR-0310", "mail can't be sent", e);
		}
	}

	private void sendGmail(MailMessageSkeleton content) {
		SimpleMailMessage message = null;

		message = new SimpleMailMessage();

		message.setTo(content.getToMailer());
		message.setFrom(WeGiftConstants.GMAIL_USERNAME);
		message.setSubject(content.getSubject());
		message.setText(content.getMessageBody());

		gMailSender.send(message);
	}

	private void sendSForceMail(MailMessageSkeleton content) {
		SimpleMailMessage message = null;

		message = new SimpleMailMessage();

		message.setTo(content.getToMailer());
		message.setFrom(WeGiftConstants.SFORCE_USERNAME);
		message.setSubject(content.getSubject());
		message.setText(content.getMessageBody());

		sforceMailSender.send(message);

	}
}
