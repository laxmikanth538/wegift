package com.wegift.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.wegift.bo.AddressBo;
import com.wegift.bo.MerchantBo;
import com.wegift.bo.MerchantEnquiryBo;
import com.wegift.bo.MerchantLocationBo;
import com.wegift.bo.OnlineUsersBo;
import com.wegift.bo.RegCriteriaBo;
import com.wegift.bo.UserCredBo;
import com.wegift.constants.WeGiftConstants;
import com.wegift.dto.MerchantEnquiryDto;
import com.wegift.dto.SpecificMerchantEnquiryDto;
import com.wegift.entities.Address;
import com.wegift.entities.Merchant;
import com.wegift.entities.MerchantEnquiryEntity;
import com.wegift.entities.MerchantLocation;
import com.wegift.entities.MerchantTermsAndAgreement;
import com.wegift.entities.OnlineUser;
import com.wegift.entities.RegUnique;
import com.wegift.entities.UserRole;
import com.wegift.util.MerchantRegUniqueForUpdate;

@Repository
public class MerchantDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	private final String GET_ONLINE_USER_SQL = "select ou.onlineUserId from OnlineUser AS ou inner join ou.merchant AS mr where mr.merchantId=:merchantId";
	private final String GET_CITIES = "select CITY_NAME from WG_CITIES";
	private final String GET_STATES = "select STATE_NAME from WG_STATES";

	public int saveMerchantEnquiry(MerchantEnquiryBo merchantEnquiryBo) {
		MerchantEnquiryEntity enquiryEntity = null;
		int merchantEnqReff = 0;

		enquiryEntity = new MerchantEnquiryEntity();

		enquiryEntity.setOrganizationName(merchantEnquiryBo.getOrganizationName());
		enquiryEntity.setBusinessType(merchantEnquiryBo.getBusinessType());
		enquiryEntity.setYearOfEstd(merchantEnquiryBo.getYearOfEstd());
		enquiryEntity.setMerchantLocation(merchantEnquiryBo.getMerchantLocation());
		enquiryEntity.setContactPerson(merchantEnquiryBo.getContactPerson());
		enquiryEntity.setContactNo(merchantEnquiryBo.getContactNo());
		enquiryEntity.setContactEmail(merchantEnquiryBo.getContactEmail());
		enquiryEntity.setDescription(merchantEnquiryBo.getDescription());
		enquiryEntity.setStatus(WeGiftConstants.STATUS_PENDING);
		// Storing in DB
		merchantEnqReff = (int) hibernateTemplate.save(enquiryEntity);

		return merchantEnqReff;
	}

	@SuppressWarnings("unchecked")
	public boolean findMerEnqOrgName(String orgName) {
		boolean flag = true;
		String SQL_FIND_QUERY = "select count(me) from MerchantEnquiryEntity as me where me.organizationName = :orgName";
		Query<Integer> findOrg = hibernateTemplate.getSessionFactory().openSession().createQuery(SQL_FIND_QUERY);
		findOrg.setParameter("orgName", orgName);

		List<Integer> merchantCount = findOrg.list();
		int count = merchantCount.size();

		if (count == 1) {
			if (String.valueOf(merchantCount.get(0)).equals("0")) {
				return false;
			}
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public boolean findMerEnqContact(String contact) {
		boolean flag = true;
		String SQL_FIND_QUERY = "select count(me) from MerchantEnquiryEntity as me where me.contactNo = :contact";
		Query<Integer> findContact = hibernateTemplate.getSessionFactory().openSession().createQuery(SQL_FIND_QUERY);
		findContact.setParameter("contact", contact);

		List<Integer> merchantCount = findContact.list();
		// if mobile NO is already exist in the database then it return true;
		// otherwise returns false

		int count = merchantCount.size();

		if (count == 1) {
			if (String.valueOf(merchantCount.get(0)).equals("0")) {
				return false;
			}
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public int findCountOfEnuiries(String status){
		String SQL_FIND_QUERY = "select count(me) from MerchantEnquiryEntity as me where me.status = :status";
		Query<Integer> query = hibernateTemplate.getSessionFactory().openSession().createQuery(SQL_FIND_QUERY);
		query.setParameter("status", status);
		return query.list().size();
	}
	@SuppressWarnings("unchecked")
	public boolean findMerEnqMail(String mail) {
		boolean flag = true;
		String SQL_FIND_QUERY = "select count(me) from MerchantEnquiryEntity as me where me.contactEmail = :email";
		Query<Integer> findMail = hibernateTemplate.getSessionFactory().openSession().createQuery(SQL_FIND_QUERY);
		findMail.setParameter("email", mail);

		List<Integer> merchantCount = findMail.list();

		int count = merchantCount.size();

		if (count == 1) {
			if (String.valueOf(merchantCount.get(0)).equals("0")) {
				return false;
			}
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantEnquiryDto> getMerchantEnquiries(String status, int startIndex, int pageSize) {
		String SQL_GET_ENQUIRIES = "select new com.wegift.dto.MerchantEnquiryDto(me.merchantEnquiryId, me.organizationName, me.merchantLocation,me.contactPerson, me.contactNo, me.status) from MerchantEnquiryEntity as me where me.status = :status";
		Query<MerchantEnquiryDto> query = hibernateTemplate.getSessionFactory().openSession()
				.createQuery(SQL_GET_ENQUIRIES);
		query.setParameter("status", status);
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		List<MerchantEnquiryDto> enquiries = query.list();
		return enquiries;
	}

	@SuppressWarnings("unchecked")
	public SpecificMerchantEnquiryDto getMerchantEnquiry(String orgName) {
		String SQL_GET_ENQUIRY = "select new com.wegift.dto.SpecificMerchantEnquiryDto(me.merchantEnquiryId, me.organizationName, me.businessType, me.yearOfEstd, me.merchantLocation, me.contactPerson, me.contactNo, me.contactEmail, me.description, me.status) from MerchantEnquiryEntity as me where me.organizationName = :orgName";
		Query<SpecificMerchantEnquiryDto> query = hibernateTemplate.getSessionFactory().openSession()
				.createQuery(SQL_GET_ENQUIRY);
		query.setParameter("orgName", orgName);
		List<SpecificMerchantEnquiryDto> enquiry = query.list();

		return enquiry.get(0);
	}

	@SuppressWarnings("unchecked")
	public void updateMerchantEnquiryStatus(int enquiryId, String update) {
		String SQL_UPDATE_ENQUIRY = "update MerchantEnquiryEntity set status=:status where merchantEnquiryId=:enquiryId";
		Session session = null;
		Transaction tx = null;
		Query<Integer> query = null;
		boolean flag = false;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			tx = session.beginTransaction();
			query = session.createQuery(SQL_UPDATE_ENQUIRY);
			query.setParameter("status", update);
			query.setParameter("enquiryId", enquiryId);
			query.executeUpdate();

			flag = true;
		} finally {
			if (tx != null) {
				if (flag) {
					tx.commit();
				} else {
					tx.rollback();
				}
			}

		}
	}

	public int saveMerchant(MerchantBo merchantBo) {
		Merchant merchant = null;
		int merchantId = 0;
		UserRole role;

		try {

			merchant = new Merchant();
			merchant.setFirstName(merchantBo.getFirstName());
			merchant.setLastName(merchantBo.getLastName());
			merchant.setDescription(merchantBo.getDescription());
			merchant.setaContactNo(merchantBo.getAlternateContactNo());
			merchant.setpContactNo(merchantBo.getPrimaryContactNo());
			merchant.setpEmailAddress(merchantBo.getPrimaryEmailAddress());
			merchant.setaEmailAddress(merchantBo.getAlternateEmailAddress());
			merchant.setMerchantAddressFileBytes(merchantBo.getMerchantLogoFileBytes());
			merchant.setMerchantLogoFileName(merchantBo.getMerchantLogoFileName());
			merchant.setMerchantLogoFileType(merchantBo.getMerchantLogoFileType());
			// P = pending
			merchant.setStatus("P");

			// persisting the merchant info
			merchantId = (Integer) hibernateTemplate.save(merchant);
			// persisting the merchant related addresses
			saveAddress(merchantBo.getAddresses(), merchant);
			// persisting merchant related terms and conditions
			saveTermsAndConditions(merchant);
			// extracting the role for merchant from database
			role = hibernateTemplate.load(UserRole.class, WeGiftConstants.MERCHANT_ROLE);
			// storing the partial data into the database as online user
			saveOnlineUserData(role, merchant);

			getOnlineUserId(5);

		} catch (Exception e) {
			System.out.println("here the MERCHANT_ID");
			e.printStackTrace();
		}
		return merchantId;
	}

	private void saveAddress(Set<AddressBo> addresses, Merchant merchant) {
		Address address = null;
		for (AddressBo addr : addresses) {
			address = new Address();
			address.setAddressLine1(addr.getAddressLine1());
			address.setAddressLine2(addr.getAddressLine2());
			address.setCity(addr.getCity());
			address.setState(addr.getState());
			address.setZip(addr.getZip());
			address.setCountry(addr.getCountry());

			address.setMerchant(merchant);

			hibernateTemplate.save(address);
		}
	}

	private void saveTermsAndConditions(Merchant merchant) {
		MerchantTermsAndAgreement termsAndConditions = null;

		termsAndConditions = new MerchantTermsAndAgreement();

		termsAndConditions.setTermsAndConditionsEffectiveDate(new Date());
		termsAndConditions.setTermsAndConditionsEndDate(new Date());
		termsAndConditions.setSettlementPeriod(6);
		termsAndConditions.setRewardCharges(0.05f);
		termsAndConditions.setRedeemCharges(0.10f);
		termsAndConditions.setStatus("ONBOARDED");
		termsAndConditions.setAnnualMaintainanceCharge(50000.0f);
		termsAndConditions.setMerchant(merchant);

		hibernateTemplate.save(termsAndConditions);

	}

	private void saveOnlineUserData(UserRole role, Merchant merchant) {
		OnlineUser onlineUser = null;

		onlineUser = new OnlineUser();

		onlineUser.setUserName(null);
		onlineUser.setPassword(null);
		onlineUser.setActivatedDate(new Date());
		onlineUser.setTerminationDate(new Date());
		onlineUser.setActivationCode(WeGiftConstants.ACTIVATION_CODE + 1099);
		onlineUser.setStatus(WeGiftConstants.STATUS_PENDING);
		onlineUser.setMerchant(merchant);
		onlineUser.setRole(role);
		onlineUser.setStatus(WeGiftConstants.STATUS_PENDING);

		hibernateTemplate.save(onlineUser);

	}

	@SuppressWarnings("unchecked")
	public void updateMerchantOnlineInfo(OnlineUsersBo userBo) {

		boolean flag = false;
		Transaction tx = null;
		String uniqueId = null;
		Session session = null;
		Query<OnlineUser> onlineUserQuery = null;
		Query<Integer> merchantIdRetrievalQuery = null;
		Query<Merchant> merchantStatusUpdateQuery = null;
		MerchantRegUniqueForUpdate uniquePerformer = null;

		final String HQL_ONLINE_USER_UPDATE = "update OnlineUser set userName=:username,password=:password,status=:status where onlineUserId=:onlineUserId";
		final String HQL_MERCHANT_STATUS_UPDATE = "update Merchant set status=:status where merchantId=:merchantId";
		final String HQL_MERCHANT_ID_RETRIVAL = "select MERCHANT_ID from WG_ONLINE_USERS where ONLINE_USER_ID=:onlineUserId";

		try {

			uniquePerformer = MerchantRegUniqueForUpdate.getInstance();

			session = hibernateTemplate.getSessionFactory().openSession();
			tx = session.beginTransaction();

			onlineUserQuery = session.createQuery(HQL_ONLINE_USER_UPDATE);

			onlineUserQuery.setParameter("username", userBo.getUserName());
			onlineUserQuery.setParameter("password", userBo.getPassword());
			onlineUserQuery.setParameter("status", userBo.getStatus());
			onlineUserQuery.setParameter("onlineUserId", userBo.getOnlineUserId());

			onlineUserQuery.executeUpdate();

			merchantIdRetrievalQuery = session.createNativeQuery(HQL_MERCHANT_ID_RETRIVAL);
			merchantIdRetrievalQuery.setParameter("onlineUserId", userBo.getOnlineUserId());

			List<Integer> merchantIds = merchantIdRetrievalQuery.list();

			int merchantId = 0;
			for (Integer mr : merchantIds) {
				merchantId = mr;
			}

			merchantStatusUpdateQuery = session.createQuery(HQL_MERCHANT_STATUS_UPDATE);
			merchantStatusUpdateQuery.setParameter("status", WeGiftConstants.STATUS_ACTIVE);
			merchantStatusUpdateQuery.setParameter("merchantId", merchantId);

			merchantStatusUpdateQuery.executeUpdate();

			uniqueId = uniquePerformer.getKeyByValue(merchantId);

			flag = true;
		} finally {
			if (tx != null) {
				if (flag) {
					tx.commit();
					boolean outcome = uniquePerformer.discard(uniqueId);
					if (outcome) {
						remove(uniqueId);
					}
				} else {
					tx.rollback();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public UserCredBo findUserByUsername(String username) {

		UserCredBo usercredbo = null;
		try {
			Session session = hibernateTemplate.getSessionFactory().openSession();
			@SuppressWarnings("deprecation")
			List<Object[]> userinfo = session.createCriteria(OnlineUser.class, "ou")
					.add(Restrictions.eq("ou.userName", username)).createCriteria("role","ur")
					.setProjection(Projections.projectionList().add(Projections.property("ou.userName"))
							.add(Projections.property("ou.password")).add(Projections.property("ur.roleCode")))
					.list();

			for (Object[] obj : userinfo) {
				usercredbo = new UserCredBo();
				if (obj[0] == null) {
					throw new UsernameNotFoundException("username not found");
				}
				usercredbo.setUsername(obj[0].toString());
				usercredbo.setPassword(obj[1].toString());
				usercredbo.setRole("ROLE_" + obj[2].toString());
			}
		}

		catch (Exception e) {
			throw new UsernameNotFoundException("Username Not Found");

		}
		return usercredbo;

	}

	@SuppressWarnings({ "unchecked" })
	public int getOnlineUserId(int merchantId) {

		Session session = hibernateTemplate.getSessionFactory().openSession();

		Query<Integer> query = session.createQuery(GET_ONLINE_USER_SQL);
		query.setParameter("merchantId", merchantId);
		List<Integer> values = query.list();
		int onlineUserId = 0;

		for (Integer val : values) {
			onlineUserId = val;
		}
		session.close();
		return onlineUserId;
	}

	@SuppressWarnings({ "unchecked" })
	public List<String> getCitites() {

		Session session = hibernateTemplate.getSessionFactory().openSession();

		Query<String> query = session.createNativeQuery(GET_CITIES);

		List<String> cities = query.list();

		return cities;
	}

	@SuppressWarnings({ "unchecked" })
	public List<String> getStates() {
		Session session = hibernateTemplate.getSessionFactory().openSession();

		Query<String> query = session.createNativeQuery(GET_STATES);

		List<String> states = query.list();

		return states;

	}

	public void saveRegUniqueData(RegCriteriaBo info) {
		RegUnique unique = null;

		unique = new RegUnique();

		unique.setMerchantId(info.getMerchantId());
		unique.setRegUniqueNo(info.getRegUniqueNo());

		hibernateTemplate.save(unique);
	}

	@SuppressWarnings("unchecked")
	public List<RegCriteriaBo> getRegUniqueDetails() {
		List<RegCriteriaBo> details = null;
		final String HQL_REG_DETAILS = "select new com.wegift.bo.RegCriteriaBo(ru.merchantId,ru.regUniqueNo) from RegUnique AS ru";

		Query<RegCriteriaBo> query = hibernateTemplate.getSessionFactory().openSession().createQuery(HQL_REG_DETAILS);

		details = query.list();

		return details;
	}

	public void remove(String uniqueId) {

		Session session = null;
		Transaction tx = null;
		boolean flag = false;

		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			;
			tx = session.beginTransaction();
			Query<?> deleteQuery = session.createQuery("delete from RegUnique where regUniqueNo=:uniqueNo");

			deleteQuery.setParameter("uniqueNo", uniqueId);

			deleteQuery.executeUpdate();

			flag = true;

		} finally {
			if (tx != null) {
				if (flag) {
					tx.commit();
				} else {
					tx.rollback();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public boolean findEmailAddress(String email) {
		final String HQL_EMAIL_SEARCH = "select count(mr) from Merchant AS mr where mr.pEmailAddress=:email";

		boolean flag = true;
		Query<Integer> emailSearchQuery = hibernateTemplate.getSessionFactory().openSession()
				.createQuery(HQL_EMAIL_SEARCH);
		emailSearchQuery.setParameter("email", email);

		List<Integer> merchantCount = emailSearchQuery.list();
		// if email id already exist in the database then it return
		// true;otherwise returns false

		int countMails = merchantCount.size();

		if (countMails == 1) {
			if (String.valueOf(merchantCount.get(0)).equals("0")) {
				return false;
			}
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public boolean findContactNo(String contactNo) {

		final String HQL_CONTACTNO_SEARCH = "select count(mr) from Merchant AS mr where mr.pContactNo=:contactNo";

		boolean flag = true;
		Query<Integer> emailSearchQuery = hibernateTemplate.getSessionFactory().openSession()
				.createQuery(HQL_CONTACTNO_SEARCH);
		emailSearchQuery.setParameter("contactNo", contactNo);

		List<Integer> merchantCount = emailSearchQuery.list();
		// if mobile NO is already exist in the database then it return
		// true;otherwise returns false

		int countMails = merchantCount.size();

		if (countMails == 1) {
			if (String.valueOf(merchantCount.get(0)).equals("0")) {
				return false;
			}
		}
		return flag;
	}
	
	//Add merchant location
	public int addMerchantLocation(MerchantLocationBo merchantLocationBo){

		Address address=null;
		MerchantLocation mlocation=null;
		
		address=new Address();
		
		address.setAddressLine1(merchantLocationBo.getMerchantLocationAddress().getAddressLine1());
		address.setAddressLine2(merchantLocationBo.getMerchantLocationAddress().getAddressLine2());
		address.setCity(merchantLocationBo.getMerchantLocationAddress().getCity());
		address.setState(merchantLocationBo.getMerchantLocationAddress().getState());
		address.setZip(merchantLocationBo.getMerchantLocationAddress().getZip());
		address.setCountry(merchantLocationBo.getMerchantLocationAddress().getCountry());
		
		hibernateTemplate.save(address);
		
		mlocation=new MerchantLocation();
		
		mlocation.setMerchantLocationName(merchantLocationBo.getMerchantLocationName());
		mlocation.setLocationManagerName(merchantLocationBo.getLocationManagerName());
		mlocation.setLocationEmailAddress(merchantLocationBo.getLocationEmailAddress());
		mlocation.setLocationContactNo(merchantLocationBo.getLocationContactNo());
		mlocation.setMerchantLocationImageBytes(merchantLocationBo.getMerchantLocationImageBytes());
		mlocation.setMerchantLocationImageFileName(merchantLocationBo.getMerchantLocationImageFileName());
		mlocation.setMerchantLocationImageType(merchantLocationBo.getMerchantLocationImageType());
		
		hibernateTemplate.save(mlocation);
		
		
		
		return mlocation.getMerchantLocationId();
		
		}
	/**
	 * shelly
	 */
	@SuppressWarnings("unchecked")
	public boolean findMerlocationMail(String mail) {
		boolean flag = true;
		String SQL_FIND_MAIL_QUERY = "select count(me) from MerchantLocation as ml where ml.contactEmail = :email";
		Query<Integer> findMail = hibernateTemplate.getSessionFactory().openSession().createQuery(SQL_FIND_MAIL_QUERY);
		findMail.setParameter("email", mail);

		List<Integer> merchantCount = findMail.list();

		int count = merchantCount.size();

		if (count == 1) {
			if (String.valueOf(merchantCount.get(0)).equals("0")) {
				return false;
			}
		}

		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public boolean findLocationContactNo(String contactNo) {

		final String HQL_CONTACTNO_SEARCH = "select count(mr) from MerchantLocation AS ml where ml.contactNo=:contactNo";

		boolean flag = true;
		Query<Integer> mobileSearchQuery = hibernateTemplate.getSessionFactory().openSession()
				.createQuery(HQL_CONTACTNO_SEARCH);
		mobileSearchQuery.setParameter("contactNo", contactNo);

		List<Integer> merchantCount = mobileSearchQuery.list();
		// if mobile NO is already exist in the database then it return
		// true;otherwise returns false

		int countMails = merchantCount.size();

		if (countMails == 1) {
			if (String.valueOf(merchantCount.get(0)).equals("0")) {
				return false;
			}
		}
		return flag;
	}
	
}
