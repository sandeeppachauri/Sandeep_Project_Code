package com.databean.xsgx.suvidha.scheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name="schemeWithdraw")
@Proxy(lazy=false)
public class SchemeWithdraw {

	private int id;
	private int schemeId;
	private String withType;
	private String minPeriod;
	private String maxPeriod;
	private String widraw="No";
	private String paymentAfter="0";
	
	@Id
	@GeneratedValue
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="schemeId")
	public int getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}
	@Column(name="withType")
	public String getWithType() {
		return withType;
	}
	public void setWithType(String withType) {
		this.withType = withType;
	}
	@Column(name="minPeriod")
	public String getMinPeriod() {
		return minPeriod;
	}
	public void setMinPeriod(String minPeriod) {
		this.minPeriod = minPeriod;
	}
	@Column(name="maxPeriod")
	public String getMaxPeriod() {
		return maxPeriod;
	}
	public void setMaxPeriod(String maxPeriod) {
		this.maxPeriod = maxPeriod;
	}
	@Column(name="widraw")
	public String getWidraw() {
		return widraw;
	}
	public void setWidraw(String widraw) {
		this.widraw = widraw;
	}
	@Column(name="paymentAfter")
	public String getPaymentAfter() {
		return paymentAfter;
	}
	public void setPaymentAfter(String paymentAfter) {
		this.paymentAfter = paymentAfter;
	}
	
	
}
