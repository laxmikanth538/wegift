package com.wegift.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.wegift.bo.MemberBo;
import com.wegift.bo.OnlineUsersBo;
import com.wegift.bo.UserCredBo;
import com.wegift.constants.WeGiftConstants;
import com.wegift.entities.Address;
import com.wegift.entities.Card;
import com.wegift.entities.Member;
import com.wegift.entities.OnlineUser;
import com.wegift.entities.UserRole;

@Repository
public class MemberDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	String SQL = "select WG_ONLINE_USERS.ONLINE_USER_ID from WG_MEMBER inner join WG_ONLINE_USERS on WG_MEMBER.MEMBER_ID=WG_ONLINE_USERS.ONLINE_USER_ID where WG_MEMBER.MEMBER_ID=:memberId";
	private final String GET_CITIES = "select CITY_NAME from WG_CITIES";
	private final String GET_STATES = "select STATE_NAME from WG_STATES";
	private final String UPDATE_ONLINE_USER_BY_ONLINE_USER_ID = "update OnlineUser set userName=:username, password=:password, activatedDate=:activatedDate, terminationDate=:terminationDate, status=:status where onlineUserId=:onlineUserId";
	private final String UPDATE_CARD_BY_CARD_ID = "update Card set status=:status, points=:points where cardId=:cardId";

	public int saveMember(MemberBo memberBo) {
		Member member = null;
		Address address = null;
		Card card = null;

		OnlineUser onlineUser;
		UserRole role;
		int memberId = 0;
		try {
			member = new Member();
			member.setFirstName(memberBo.getFirstName());
			member.setLastName(memberBo.getLastName());
			member.setGender(memberBo.getGender());
			member.setDob(memberBo.getDob());
			member.setMobile(memberBo.getMobile());
			member.setEmail(memberBo.getEmail());
			member.setStatus("Registered");

			card = new Card();
			CharSequence cardNo = String.valueOf(UUID.randomUUID().getMostSignificantBits()).subSequence(1, 10);
			card.setCardNo(cardNo.toString());
			card.setCardIssuedDate(new Date());
			card.setStatus(WeGiftConstants.STATUS_PENDING);
			card.setPoints(0);

			hibernateTemplate.save(card);

			role = hibernateTemplate.load(UserRole.class, 3);

			onlineUser = new OnlineUser();
			onlineUser.setUserName(null);
			onlineUser.setPassword(null);
			onlineUser.setActivatedDate(new Date());
			onlineUser.setTerminationDate(new Date());
			onlineUser.setActivationCode(WeGiftConstants.ACTIVATION_CODE + 888);
			onlineUser.setStatus(WeGiftConstants.STATUS_PENDING);

			onlineUser.setMember(member);

			onlineUser.setRole(role);

			hibernateTemplate.save(onlineUser);

			address = new Address();
			address.setAddressLine1(memberBo.getAddressBo().getAddressLine1());
			address.setAddressLine2(memberBo.getAddressBo().getAddressLine2());
			address.setCity(memberBo.getAddressBo().getCity());
			address.setState(memberBo.getAddressBo().getState());
			address.setCountry(memberBo.getAddressBo().getCountry());
			address.setZip(memberBo.getAddressBo().getZip());

			address.setMember(member);

			member.setCard(card);

			memberId = (int) hibernateTemplate.save(member);

			hibernateTemplate.save(address);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberId;
	}

	public int getOnlineUserId(int memberId) {

		Session session = hibernateTemplate.getSessionFactory().openSession();

		@SuppressWarnings("unchecked")
		Query<Integer> query = session.createNativeQuery(SQL);
		query.setParameter("memberId", memberId);
		List<Integer> values = query.list();

		int onlineUserId = 0;

		for (Integer val : values) {
			onlineUserId = val;
		}
		return onlineUserId;
	}

	@SuppressWarnings("deprecation")
	public void updateMemberOnlineInfo(OnlineUsersBo userBo) {

		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		@SuppressWarnings("rawtypes")
		Query update_OnlineUser = session.createQuery(UPDATE_ONLINE_USER_BY_ONLINE_USER_ID);

		update_OnlineUser.setParameter("onlineUserId", userBo.getOnlineUserId());
		update_OnlineUser.setParameter("username", userBo.getUserName());
		update_OnlineUser.setParameter("password", userBo.getPassword());
		update_OnlineUser.setParameter("activatedDate", new Date());
		Date date = new Date();
		date.setMonth(date.getMonth() + 12);
		update_OnlineUser.setParameter("terminationDate", date);
		update_OnlineUser.setParameter("status", WeGiftConstants.STATUS_ACTIVE);

		update_OnlineUser.executeUpdate();

		@SuppressWarnings("rawtypes")
		Query update_Card = session.createQuery(UPDATE_CARD_BY_CARD_ID);
		update_Card.setParameter("cardId", userBo.getOnlineUserId());
		update_Card.setParameter("status", WeGiftConstants.STATUS_ACTIVE);
		update_Card.setParameter("points", 50);

		update_Card.executeUpdate();

		tx.commit();
		session.close();
	}

	public List<String> getCities() {

		Session session = hibernateTemplate.getSessionFactory().openSession();

		// Query Building
		@SuppressWarnings("unchecked")
		Query<String> query = session.createNativeQuery(GET_CITIES);

		// converting the query list into our own list format
		List<String> cities = query.list();

		return cities;
	}

	public List<String> getStates() {
		Session session = hibernateTemplate.getSessionFactory().openSession();

		// Query Building
		@SuppressWarnings("unchecked")
		Query<String> query = session.createNativeQuery(GET_STATES);

		// converting from query list to custom string list
		List<String> states = query.list();

		return states;
	}

	@SuppressWarnings("unchecked")
	public UserCredBo findUserByUsername(String username) {

		UserCredBo usercredbo = null;
		try {
			Session session = hibernateTemplate.getSessionFactory().openSession();
			@SuppressWarnings("deprecation")
			List<Object[]> userinfo = session.createCriteria(OnlineUser.class, "ou")
					.add(Restrictions.eq("ou.userName", username)).createCriteria("role", "ur")
					.setProjection(Projections.projectionList().add(Projections.property("ou.userName"))
							.add(Projections.property("ou.password")).add(Projections.property("ur.roleCode")))
					.list();

			for (Object[] obj : userinfo) {
				usercredbo = new UserCredBo();
				usercredbo.setUsername(obj[0].toString());
				usercredbo.setPassword(obj[1].toString());
				usercredbo.setRole("ROLE_" + obj[2].toString());
			}

		} catch (Exception e) {
			throw new UsernameNotFoundException("Username Not Found");
		}
		return usercredbo;
	}
}
