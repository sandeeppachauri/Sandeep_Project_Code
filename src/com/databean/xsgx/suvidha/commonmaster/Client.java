package com.databean.xsgx.suvidha.commonmaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "clientmaster")
@Proxy(lazy = false)
public class Client {

	private int id;
	private String date;
	private String time;
	private String user;
	private String sourceName;
	private String clientName;
	private String clientMob;
	private String clientPhoneno;
	private String clientEmailId;
	private String clientAddress;
	private String doj_date;
	private String dob_date;
	private String doa_date;
	private String referBy;
	@Column(name = "areaName")
	private String areaName;
	
	@Column(name = "activeStatus")
	private int activeStatus=1;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Column(name = "user")
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "sourcename")
	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	@Column(name = "clientname")
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Column(name = "clientmob")
	public String getClientMob() {
		return clientMob;
	}

	public void setClientMob(String clientMob) {
		this.clientMob = clientMob;
	}

	@Column(name = "clientphoneno")
	public String getClientPhoneno() {
		return clientPhoneno;
	}

	public void setClientPhoneno(String clientPhoneno) {
		this.clientPhoneno = clientPhoneno;
	}

	@Column(name = "clientemailid")
	public String getClientEmailId() {
		return clientEmailId;
	}

	public void setClientEmailId(String clientEmailId) {
		this.clientEmailId = clientEmailId;
	}

	@Column(name = "clientaddress")
	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	@Column(name = "doj_date")
	public String getDoj_date() {
		return doj_date;
	}

	public void setDoj_date(String doj_date) {
		this.doj_date = doj_date;
	}

	@Column(name = "dob_date")
	public String getDob_date() {
		return dob_date;
	}

	public void setDob_date(String dob_date) {
		this.dob_date = dob_date;
	}

	@Column(name = "doa_date")
	public String getDoa_date() {
		return doa_date;
	}

	public void setDoa_date(String doa_date) {
		this.doa_date = doa_date;
	}

	@Column(name = "referBy")
	public String getReferBy() {
		return referBy;
	}

	public void setReferBy(String referBy) {
		this.referBy = referBy;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	
}
