package com.databean.xsgx.suvidha.scheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.suvidha.common.DateUtil;



@Entity
@Table(name="incrmtnlscheme")
@Proxy(lazy=false)
public class IncermentalBean {

	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="schemeId")
	private String schemId;
	@Column(name="value")
	private String values;
	@Column(name="user")
	private String user;
	@Column(name="date")
	private String date=DateUtil.getCurrentDateUSFormat();
	@Column(name="time")
	private String time=DateUtil.getCurrentTime();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchemId() {
		return schemId;
	}
	public void setSchemId(String schemId) {
		this.schemId = schemId;
	}
	public String getValues() {
		return values;
	}
	public void setValues(String values) {
		this.values = values;
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
