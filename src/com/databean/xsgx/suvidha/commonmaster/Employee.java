package com.databean.xsgx.suvidha.commonmaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "emploee")
@Proxy(lazy = false)
public class Employee {

	private String empName;
	private String empMob;
	private String empPhoneNo;
	private String empEmailId;
	private String empAddress;
	private String doj_date;
	private String empId;
	private String entryUser;
	private String entryDate;
	private String entryTime;
	private int id;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "empname")
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Column(name = "empmob")
	public String getEmpMob() {
		return empMob;
	}

	public void setEmpMob(String empMob) {
		this.empMob = empMob;
	}

	@Column(name = "empphoneno")
	public String getEmpPhoneNo() {
		return empPhoneNo;
	}

	public void setEmpPhoneNo(String empPhoneNo) {
		this.empPhoneNo = empPhoneNo;
	}

	@Column(name = "empemailid")
	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	@Column(name = "empaddress")
	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	@Column(name = "doj_date")
	public String getDoj_date() {
		return doj_date;
	}

	public void setDoj_date(String doj_date) {
		this.doj_date = doj_date;
	}

	@Column(name = "empid")
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Column(name = "entryuser")
	public String getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(String entryUser) {
		this.entryUser = entryUser;
	}

	@Column(name = "entrydate")
	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	@Column(name = "entrytime")
	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

}
