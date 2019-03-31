package com.wegift.mailservice;

import com.wegift.mail.bo.MailMessageSkeleton;

import junit.framework.TestCase;

public class WeGiftMailManagerTest extends TestCase {

	private WegiftMailManager mailManager;
	private MailMessageSkeleton message;
	
	@Override
	protected void setUp() throws Exception {
		mailManager = new WegiftMailManager();
	}

	public void testMailer() {
		try {
			message = new MailMessageSkeleton();
			message.setToMailer(new String[] { "yellaiah.mekala@s-force.org" });
			message.setSubject("Mail Testing");
			message.setMessageBody("Hello messsage from no-reply@wegift.com");

			mailManager.notifyMailer(message);

		} catch (Exception e) {
			System.out.println("Mail not sent ");
			e.printStackTrace();
		}
	}

	@Override
	protected void tearDown() throws Exception {
		mailManager = null;
		message = null;
	}

}
