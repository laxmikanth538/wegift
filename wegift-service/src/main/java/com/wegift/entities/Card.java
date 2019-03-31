package com.wegift.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "WG_CARD")
public class Card {

	@Id
	@Column(name = "CARD_ID")
	@GenericGenerator(name = "cardgen", strategy = "increment")
	@GeneratedValue(generator = "cardgen")
	protected int cardId;
	@Column(name = "CARD_NO")
	protected String cardNo;
	@Column(name = "CARD_ISSUED_DATE")
	protected Date cardIssuedDate;
	@Column(name = "STATUS")
	protected String status;
	@Column(name = "POINTS")
	protected int points;

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Date getCardIssuedDate() {
		return cardIssuedDate;
	}

	public void setCardIssuedDate(Date cardIssuedDate) {
		this.cardIssuedDate = cardIssuedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

}
