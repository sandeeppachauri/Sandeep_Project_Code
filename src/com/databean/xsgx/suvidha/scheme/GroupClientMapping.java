package com.databean.xsgx.suvidha.scheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "groupClientMapping")
@Proxy(lazy = false)
public class GroupClientMapping {

	private int id;
	@Column(name = "user")
	private String user;
	@Column(name = "date")
	private String date;
	@Column(name = "time")
	private String time;
	@Column(name = "groupId")
	private String groupId;
	@Column(name = "clientId")
	private String clientId;
	@Column(name = "clientSchemeId")
	private String clientSchemeId;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSchemeId() {
		return clientSchemeId;
	}

	public void setClientSchemeId(String clientSchemeId) {
		this.clientSchemeId = clientSchemeId;
	}

}
