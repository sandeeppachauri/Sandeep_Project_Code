package com.databean.xsgx.suvidha.scheme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


@Entity
@Table(name="extraLoyality")
@Proxy(lazy=false)
public class ExtraLoyality {
private int id;
private String schemeId;
private String loyalityAmount;
private String loyalityGms;

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
public String getSchemeId() {
	return schemeId;
}
public void setSchemeId(String schemeId) {
	this.schemeId = schemeId;
}
@Column(name="loyalityAmount")
public String getLoyalityAmount() {
	return loyalityAmount;
}
public void setLoyalityAmount(String loyalityAmount) {
	this.loyalityAmount = loyalityAmount;
}
@Column(name="loyalityGms")
public String getLoyalityGms() {
	return loyalityGms;
}
public void setLoyalityGms(String loyalityGms) {
	this.loyalityGms = loyalityGms;
}


}
