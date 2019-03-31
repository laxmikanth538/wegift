package com.wegift.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.wegift.bo.MerchantBo;
import com.wegift.bo.MerchantEnquiryBo;
import com.wegift.bo.MerchantLocationBo;
import com.wegift.bo.OnlineUsersBo;
import com.wegift.bo.RegCriteriaBo;
import com.wegift.constants.WeGiftConstants;
import com.wegift.dao.MerchantDao;
import com.wegift.dto.MerchantEnquiryDto;
import com.wegift.dto.SpecificMerchantEnquiryDto;
import com.wegift.mail.bo.MailMessageSkeleton;
import com.wegift.mailservice.WegiftMailManager;
import com.wegift.util.MerchantRegUniqueForUpdate;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class ManageMerchantService {

	@Autowired
	private MerchantDao merchantDao;
	@Autowired
	WegiftMailManager weGiftMailManager;

	MerchantRegUniqueForUpdate uniquePerformer = null;

	@Transactional(readOnly = false)
	public int doMerchantEnquiry(MerchantEnquiryBo enquiryBo) {
		int merchantRefNo = merchantDao.saveMerchantEnquiry(enquiryBo);

		// Sending Enq Ref to Merchant through mail
		MailMessageSkeleton skeleton = new MailMessageSkeleton();
		skeleton.setToMailer(new String[] { enquiryBo.getContactEmail() });
		skeleton.setSubject("WeGift Enquiry Success");
		skeleton.setMessageBody("Congratulations we  got you with Ref ID : " + merchantRefNo
				+ ".  Our Support team will reach you in next 48 hours. \n\n\n Thank you");

		weGiftMailManager.notifyMailer(skeleton);
		return merchantRefNo;
	}

	@Transactional(readOnly = true)
	public List<MerchantEnquiryDto> findMerchantEnquiries(String status,int pageNo, int pageSize) {
		
		int startIndex = (pageSize*pageNo);
		
		List<MerchantEnquiryDto> enquiries = merchantDao.getMerchantEnquiries(status, startIndex, pageSize);
		for(MerchantEnquiryDto enquiry : enquiries){
			String status1 = enquiry.getStatus();
			if (status1.equalsIgnoreCase("p")) {
				status1 = "Pending";
				enquiry.setStatus(status1);
			} else if (status1.equalsIgnoreCase("a")) {
				status1 = "Approved";
				enquiry.setStatus(status1);
			}
			if (status1.equalsIgnoreCase("r")) {
				status1 = "Rejected";
				enquiry.setStatus(status1);
			} 
		}
		return enquiries;
	}

	@Transactional(readOnly = true)
	public SpecificMerchantEnquiryDto getSpecificEnquiry(String orgName) {

		SpecificMerchantEnquiryDto enquiry = merchantDao.getMerchantEnquiry(orgName);
		String status = enquiry.getStatus();
		if (status.equalsIgnoreCase("p")) {
			status = "Pending";
			enquiry.setStatus(status);
		} else if (status.equalsIgnoreCase("a")) {
			status = "Approved";
			enquiry.setStatus(status);
		}
		if (status.equalsIgnoreCase("r")) {
			status = "Rejected";
			enquiry.setStatus(status);
		} 
		return enquiry;
	}
	
	@Transactional(readOnly=false)
	public void updateMerchantEnquiryStatus(int enquiryId, String update){
		merchantDao.updateMerchantEnquiryStatus(enquiryId, update);
	}

	@Transactional(readOnly=true)
	public int findCountOfEnquiries(String status){
		
		return merchantDao.findCountOfEnuiries(status);
	}
	
	@Transactional(readOnly = false)
	public int saveMerchant(MerchantBo merchantBo) {
		StringBuffer buffer = null;
		RegCriteriaBo info = null;

		int merchantId = merchantDao.saveMerchant(merchantBo);

		String uniqueId = UUID.randomUUID().toString();

		uniquePerformer = MerchantRegUniqueForUpdate.getInstance();
		if (uniquePerformer != null) {
			uniquePerformer.keepIntoMap(uniqueId, merchantId);
			info = new RegCriteriaBo();

			info.setMerchantId(merchantId);
			info.setRegUniqueNo(uniqueId);

			merchantDao.saveRegUniqueData(info);
		}

		if (merchantId > 0) {

			MailMessageSkeleton message = new MailMessageSkeleton();
			message.setToMailer(new String[] { merchantBo.getPrimaryEmailAddress() });
			message.setSubject("Regarding Registration Process");

			buffer = new StringBuffer();
			buffer.append("Your Registration has been done successfully");
			buffer.append("\n\n\n");
			buffer.append("Please click the below link to update or complete your registration process completely");
			buffer.append("\n\n");
			buffer.append("http://").append(WeGiftConstants.WEGIFT_SERVER_HOST).append(":")
					.append(WeGiftConstants.WEGIFT_SERVER_PORT).append(WeGiftConstants.WEGIFT_CONTEXT_ROOT).append("/")
					.append("edit-mechant-form-for-complete-registration.htm").append("?")
					.append("merchantUniqueReference=").append(uniqueId);
			// change from merchantID to onlineUserId
			message.setMessageBody(buffer.toString());

			weGiftMailManager.notifyMailer(message);
		}

		return merchantId;

	}

	/**
	 * 
	 * Shelly
	 */
	@Transactional(readOnly = false)
	public int saveMerchantLocation(MerchantLocationBo merchantLocationBo) {

		int merchantLocId = merchantDao.addMerchantLocation(merchantLocationBo);
		System.out.println(merchantLocId);
		return merchantLocId;

	}

	@Transactional(readOnly = false)
	public int getOnlineUserId(int merchantId) {
		return merchantDao.getOnlineUserId(merchantId);
	}

	@Transactional(readOnly = false)
	public void update(OnlineUsersBo userBo) {
		merchantDao.updateMerchantOnlineInfo(userBo);
	}

	@Transactional(readOnly = true)
	public List<String> getCities() {
		return merchantDao.getCitites();
	}

	@Transactional(readOnly = true)
	public List<String> getStates() {
		return merchantDao.getStates();
	}

	@Transactional(readOnly = true)
	public void refresh() {
		List<RegCriteriaBo> regDetails = null;
		MerchantRegUniqueForUpdate uniquePerformer = null;

		regDetails = merchantDao.getRegUniqueDetails();
		uniquePerformer = MerchantRegUniqueForUpdate.getInstance();

		for (RegCriteriaBo bo : regDetails) {
			uniquePerformer.keepIntoMap(bo.getRegUniqueNo(), bo.getMerchantId());
		}

	}

	// Merchant Enquiry check
	@Transactional(readOnly = true)
	public boolean merchantEnqOrgCheckDB(String orgName) {
		return merchantDao.findMerEnqOrgName(orgName);
	}

	@Transactional(readOnly = true)
	public boolean merchantEnqMailCheckInDB(String mail) {
		// if found returns true
		return merchantDao.findMerEnqMail(mail);
	}

	@Transactional(readOnly = true)
	public boolean merchantEnqContactCheckInDB(String contact) {
		return merchantDao.findMerEnqContact(contact);
	}

	// Merchant Registration Check
	@Transactional(readOnly = true)
	public boolean mailCheckInMerchantDB(String email) {

		return merchantDao.findEmailAddress(email);
	}

/*	@Transactional(readOnly = true)
	public boolean mobileCheckInMerchantDB(String contactNo) {
		return merchantDao.findContactNo(contactNo);
	}
		return merchantDao.findEmailAddress(email);
	}
*/
	@Transactional(readOnly = true)
	public boolean mobileCheckInMerchantDB(String contactNo) {
		return merchantDao.findContactNo(contactNo);
	}

	/**
	 *shelly
	 */
	@Transactional(readOnly = true)
	public boolean merchantLocationMailCheckInDB(String mail) {
		// if found returns true
		return merchantDao.findMerlocationMail(mail);
	}

	public boolean merchantLocationContactCheckInDB(String contactNo) {
		return merchantDao.findLocationContactNo(contactNo);

	}

}
