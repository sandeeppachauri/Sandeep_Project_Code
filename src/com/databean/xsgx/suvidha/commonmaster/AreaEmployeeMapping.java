package com.databean.xsgx.suvidha.commonmaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "areaemployeemapping")
@Proxy(lazy = false)
public class AreaEmployeeMapping {

	private String empID;
	private String aeaID;
	private String user;
	private String date;
	private String time;
	private int id;

	@Column(name = "empID")
	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	@Column(name = "aeaID")
	public String getAeaID() {
		return aeaID;
	}

	public void setAeaID(String aeaID) {
		this.aeaID = aeaID;
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

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
