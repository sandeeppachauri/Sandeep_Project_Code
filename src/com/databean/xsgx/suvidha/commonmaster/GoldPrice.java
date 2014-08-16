package com.databean.xsgx.suvidha.commonmaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "goldrate")
@Proxy(lazy = false)
public class GoldPrice {

	private int id;
	private String date;
	private String time;
	private String user;
	private String goldRate;
	private String goldRateDate;

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

	@Column(name = "goldRate")
	public String getGoldRate() {
		return goldRate;
	}

	public void setGoldRate(String goldRate) {
		this.goldRate = goldRate;
	}

	@Column(name = "goldRateDate")
	public String getGoldRateDate() {
		return goldRateDate;
	}

	public void setGoldRateDate(String goldRateDate) {
		this.goldRateDate = goldRateDate;
	}

}
