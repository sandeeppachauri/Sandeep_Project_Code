package com.databean.xsgx.suvidha.commonmaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "schemehistory")
@Proxy(lazy = false)
public class SchemeActionHistory {

	@GeneratedValue
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "schemeId")
	private String schemeId;
	@Column(name = "schemeAction")
	private String schemeAction;
	@Column(name = "actionDesc")
	private String actionDesc;
	@Column(name = "user")
	private String user;
	@Column(name = "date")
	private String date;
	@Column(name = "time")
	private String time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public String getSchemeAction() {
		return schemeAction;
	}

	public void setSchemeAction(String schemeAction) {
		this.schemeAction = schemeAction;
	}

	public String getActionDesc() {
		return actionDesc;
	}

	public void setActionDesc(String actionDesc) {
		this.actionDesc = actionDesc;
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

}
