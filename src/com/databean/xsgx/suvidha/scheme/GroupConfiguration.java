package com.databean.xsgx.suvidha.scheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "groupConfiguration")
@Proxy(lazy = false)
public class GroupConfiguration {

	private int id;
	@Column(name = "user")
	private String user;
	@Column(name = "date")
	private String date;
	@Column(name = "time")
	private String time;
	@Column(name = "groupId")
	private String groupId;
	@Column(name = "schemeID")
	private String schemeID;

	@Column(name = "minInstPay")
	private String minInstPay;

	@Column(name = "maxMonth")
	private String maxMonth;

	@Column(name = "rewardAmount")
	private String rewardAmount;

	@Column(name = "futurPay")
	private String futurPay;

	@Column(name = "orgznRewardAmount")
	private String orgznRewardAmount;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchemeID() {
		return schemeID;
	}

	public void setSchemeID(String schemeID) {
		this.schemeID = schemeID;
	}

	public String getMinInstPay() {
		return minInstPay;
	}

	public void setMinInstPay(String minInstPay) {
		this.minInstPay = minInstPay;
	}

	public String getMaxMonth() {
		return maxMonth;
	}

	public void setMaxMonth(String maxMonth) {
		this.maxMonth = maxMonth;
	}

	public String getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(String rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getFuturPay() {
		return futurPay;
	}

	public void setFuturPay(String futurPay) {
		this.futurPay = futurPay;
	}

	public String getOrgznRewardAmount() {
		return orgznRewardAmount;
	}

	public void setOrgznRewardAmount(String orgznRewardAmount) {
		this.orgznRewardAmount = orgznRewardAmount;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
