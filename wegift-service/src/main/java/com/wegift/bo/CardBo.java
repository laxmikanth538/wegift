package com.wegift.bo;

import java.io.Serializable;
import java.util.Date;

public class CardBo implements Serializable {

	private static final long serialVersionUID = 7292590283250108049L;
	private String card_No;
	private Date card_issued_Date;
	private int points;
	private String status;

	public String getCard_No() {
		return card_No;
	}

	public void setCard_No(String card_No) {
		this.card_No = card_No;
	}

	public Date getCard_issued_Date() {
		return card_issued_Date;
	}

	public void setCard_issued_Date(Date card_issued_Date) {
		this.card_issued_Date = card_issued_Date;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
