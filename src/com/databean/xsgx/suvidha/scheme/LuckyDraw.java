package com.databean.xsgx.suvidha.scheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="luckydraw")
@Proxy(lazy=false)
public class LuckyDraw {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="amount")
	private String amount;
	@Column(name="schemeId")
	private String schemeId;
	@Column(name="futurepayment")
	private String futurepayment;
	@Column(name="paymentMode")
	private String paymentMode;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}
	public String getFuturepayment() {
		return futurepayment;
	}
	public void setFuturepayment(String futurepayment) {
		this.futurepayment = futurepayment;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
	
}
