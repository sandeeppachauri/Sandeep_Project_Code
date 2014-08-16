package com.databean.xsgx.suvidha.scheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "groupMaster")
@Proxy(lazy = false)
public class GroupMaster {

	private int id;
	private String groupName;
	private String groupCustomerNumber;
	private String groupStartDate;
	private String user;
	private String date;
	private String time;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "groupName")
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name = "groupCustomerNumber")
	public String getGroupCustomerNumber() {
		return groupCustomerNumber;
	}

	public void setGroupCustomerNumber(String groupCustomerNumber) {
		this.groupCustomerNumber = groupCustomerNumber;
	}

	@Column(name = "groupStartDate")
	public String getGroupStartDate() {
		return groupStartDate;
	}

	public void setGroupStartDate(String groupStartDate) {
		this.groupStartDate = groupStartDate;
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

}
