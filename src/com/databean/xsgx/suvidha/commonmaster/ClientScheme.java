package com.databean.xsgx.suvidha.commonmaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "clientscheme")
@Proxy(lazy = false)
public class ClientScheme {

	private int id;
	private String user;
	private String date;
	private String time;
	private String schemeId;
	private String clientId;
	private String schemeJoinDate;
	private String cardNo;
	private String schemeStatus = "0";
	private String groupMapped="0";
	private String referCardNo;
	
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "cardno")
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Column(name = "user")
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "date")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "time")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name = "schemeId")
	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	@Column(name = "clientId")
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Column(name = "schemeJoinDate")
	public String getSchemeJoinDate() {
		return schemeJoinDate;
	}

	public void setSchemeJoinDate(String schemeJoinDate) {
		this.schemeJoinDate = schemeJoinDate;
	}

	@Column(name = "schemeStatus")
	public String getSchemeStatus() {
		return schemeStatus;
	}

	public void setSchemeStatus(String schemeStatus) {
		this.schemeStatus = schemeStatus;
	}

	@Column(name = "groupMapped")
	public String getGroupMapped() {
		return groupMapped;
	}

	public void setGroupMapped(String groupMapped) {
		this.groupMapped = groupMapped;
	}

	@Column(name = "referCardNo")
	public String getReferCardNo() {
		return referCardNo;
	}

	public void setReferCardNo(String referCardNo) {
		this.referCardNo = referCardNo;
	}

}
