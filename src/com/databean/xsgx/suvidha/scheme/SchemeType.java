package com.databean.xsgx.suvidha.scheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name="schemetype")
@Proxy(lazy=false)
public class SchemeType {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	private int schemeId;
	private String frequency;
	private String minPeriod;
	private String amount;
	private String totalAmount;
	private String contribution;
	private String maturityAmount;
	private String withdrawable;
	private String luckyDraw;
	private String incremntal="No";
	
	
	
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
@Column(name="frequency")
public String getFrequency() {
	return frequency;
}
public void setFrequency(String frequency) {
	this.frequency = frequency;
}
@Column(name="minPeriod")
public String getMinPeriod() {
	return minPeriod;
}
public void setMinPeriod(String minPeriod) {
	this.minPeriod = minPeriod;
}
@Column(name="amount")
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
@Column(name="totalAmount")
public String getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(String totalAmount) {
	this.totalAmount = totalAmount;
}
@Column(name="contri")
public String getContribution() {
	return contribution;
}
public void setContribution(String contribution) {
	this.contribution = contribution;
}
@Column(name="maturityAmount")
public String getMaturityAmount() {
	return maturityAmount;
}
public void setMaturityAmount(String maturityAmount) {
	this.maturityAmount = maturityAmount;
}
@Column(name="withdrawable")
public String getWithdrawable() {
	return withdrawable;
}
public void setWithdrawable(String withdrawable) {
	this.withdrawable = withdrawable;
}

@Column(name="luckyDraw")
public String getLuckyDraw() {
	return luckyDraw;
}
public void setLuckyDraw(String luckyDraw) {
	this.luckyDraw = luckyDraw;
}

@Column(name="incremntal")
public String getIncremntal() {
	return incremntal;
}
public void setIncremntal(String incremntal) {
	this.incremntal = incremntal;
}


}
