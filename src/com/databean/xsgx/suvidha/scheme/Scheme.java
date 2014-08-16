package com.databean.xsgx.suvidha.scheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name="scheme")
@Proxy(lazy=false)
public class Scheme {

	private int id;
	private String schemeName;
	private String schemeDesc;
	private String schemeStartDate;
	private String schemeEndDate;
	private String schemeFrequency;
	private String groupAble="No";
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="schemeName")
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	@Column(name="schemeDesc")
	public String getSchemeDesc() {
		return schemeDesc;
	}
	public void setSchemeDesc(String schemeDesc) {
		this.schemeDesc = schemeDesc;
	}
	@Column(name="schemeStartDate")
	public String getSchemeStartDate() {
		return schemeStartDate;
	}
	public void setSchemeStartDate(String schemeStartDate) {
		this.schemeStartDate = schemeStartDate;
	}
	@Column(name="schemeEndDate")
	public String getSchemeEndDate() {
		return schemeEndDate;
	}
	public void setSchemeEndDate(String schemeEndDate) {
		this.schemeEndDate = schemeEndDate;
	}
	
	@Column(name="groupAble")
	public String getGroupAble() {
		return groupAble;
	}
	public void setGroupAble(String groupAble) {
		this.groupAble = groupAble;
	}
	
	
}
