package com.databean.xsgx.suvidha.commonmaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.suvidha.common.DateUtil;

@Entity
@Table(name = "login")
@Proxy(lazy = false)
public class Login {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "date")
	private String date = DateUtil.getCurrentDateUSFormat();
	@Column(name = "time")
	private String time = DateUtil.getCurrentTime();
	@Column(name = "userName")
	private String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
