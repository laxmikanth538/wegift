package com.wegift.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.wegift.bo.MemberBo;
import com.wegift.bo.OnlineUsersBo;
import com.wegift.constants.WeGiftConstants;
import com.wegift.dao.MemberDao;
import com.wegift.mail.bo.MailMessageSkeleton;
import com.wegift.mailservice.WegiftMailManager;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class ManageMemberService {
	@Autowired
	private MemberDao memberDao;

	@Autowired
	private WegiftMailManager weGiftMailManager;

	@Transactional(readOnly = false)
	public int saveMember(MemberBo memberBo) {
		StringBuffer buffer = null;
		int memberId = memberDao.saveMember(memberBo);

		if (memberId > 0) {
			MailMessageSkeleton message = new MailMessageSkeleton();
			message.setToMailer(new String[] { memberBo.getEmail() });
			message.setSubject("Regarding Registration Process");

			buffer = new StringBuffer();
			buffer.append("Your Registration has been done successfully");
			buffer.append("\n\n\n");
			buffer.append("Click below link to activate your account");
			buffer.append("\n\n");
			buffer.append("http://").append(WeGiftConstants.WEGIFT_SERVER_HOST).append(":")
					.append(WeGiftConstants.WEGIFT_SERVER_PORT).append(WeGiftConstants.WEGIFT_CONTEXT_ROOT)
					.append("/").append("activate-member.htm").append("?").append("memberId=").append(memberId);

			message.setMessageBody(buffer.toString());

			weGiftMailManager.notifyMailer(message);
		}

		return memberId;
	}

	@Transactional(readOnly = false)
	public int getOnlineUserId(int memberId) {
		return memberDao.getOnlineUserId(memberId);
	}

	@Transactional(readOnly = false)
	public void updateUserInfo(OnlineUsersBo userBo) {
		memberDao.updateMemberOnlineInfo(userBo);
	}

	public List<String> getCities() {
		List<String> cities = null;
		cities = memberDao.getCities();

		return cities;
	}

	public List<String> getStates() {
		List<String> states = null;
		states = memberDao.getStates();
		return states;

	}
}
