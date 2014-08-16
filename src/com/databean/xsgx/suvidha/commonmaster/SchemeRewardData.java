package com.databean.xsgx.suvidha.commonmaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "schemecompletereward")
@Proxy(lazy = false)
public class SchemeRewardData {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "user")
	private String user;
	@Column(name = "date")
	private String date;
	@Column(name = "time")
	private String time;
	@Column(name = "clientId")
	private String clientId;
	@Column(name = "schemeId")
	private String schemeId;
	@Column(name = "joingDate")
	private String joingDate;
	@Column(name = "cmpltnTime")
	private String cmpltnTime;
	@Column(name = "periodOfScheme")
	private String periodOfScheme;
	@Column(name = "totalInst")
	private String totalInst;
	@Column(name = "totalAmount")
	private String totalAmount;
	@Column(name = "totalAmmountDeposite")
	private String totalAmmountDeposite;
	@Column(name = "matryAmmount")
	private String matryAmmount;
	@Column(name = "schemeStatus")
	private String schemeStatus;
	@Column(name = "rewardType")
	private String rewardType;
	@Column(name = "cashInHand")
	private String cashInHand;
	@Column(name = "goldTypeCart")
	private String goldTypeCart;
	@Column(name = "goldTypePrice")
	private String goldTypePrice;
	@Column(name = "goldDate")
	private String goldDate;
	@Column(name = "goldingm")
	private String goldingm;
	@Column(name = "extraLoyalty")
	private String extraLoyalty;
	@Column(name = "totalPurchaseOf")
	private String totalPurchaseOf;
	@Column(name = "adjstmntVlue")
	private String adjstmntVlue;
	@Column(name = "cashRtrn")
	private String cashRtrn;
	@Column(name = "jwlryType")
	private String jwlryType;
	@Column(name = "dmnndGoldType")
	private String dmnndGoldType;
	@Column(name = "pureGoldType")
	private String pureGoldType;
	@Column(name = "silverWght")
	private String silverWght;

	@Column(name = "stoneName")
	private String stoneName;

	@Column(name = "dmndWght")
	private String dmndWght;

	@Column(name = "dmdnRate")
	private String dmdnRate;

	@Column(name = "dmndValue")
	private String dmndValue;

	@Column(name = "goldValue")
	private String goldValue;

	@Column(name = "goldWght")
	private String goldWght;

	@Column(name = "stoneWght")
	private String stoneWght;

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

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public String getJoingDate() {
		return joingDate;
	}

	public void setJoingDate(String joingDate) {
		this.joingDate = joingDate;
	}

	public String getCmpltnTime() {
		return cmpltnTime;
	}

	public void setCmpltnTime(String cmpltnTime) {
		this.cmpltnTime = cmpltnTime;
	}

	public String getPeriodOfScheme() {
		return periodOfScheme;
	}

	public void setPeriodOfScheme(String periodOfScheme) {
		this.periodOfScheme = periodOfScheme;
	}

	public String getTotalInst() {
		return totalInst;
	}

	public void setTotalInst(String totalInst) {
		this.totalInst = totalInst;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTotalAmmountDeposite() {
		return totalAmmountDeposite;
	}

	public void setTotalAmmountDeposite(String totalAmmountDeposite) {
		this.totalAmmountDeposite = totalAmmountDeposite;
	}

	public String getMatryAmmount() {
		return matryAmmount;
	}

	public void setMatryAmmount(String matryAmmount) {
		this.matryAmmount = matryAmmount;
	}

	public String getSchemeStatus() {
		return schemeStatus;
	}

	public void setSchemeStatus(String schemeStatus) {
		this.schemeStatus = schemeStatus;
	}

	public String getRewardType() {
		return rewardType;
	}

	public void setRewardType(String rewardType) {
		this.rewardType = rewardType;
	}

	public String getCashInHand() {
		return cashInHand;
	}

	public void setCashInHand(String cashInHand) {
		this.cashInHand = cashInHand;
	}

	public String getGoldTypeCart() {
		return goldTypeCart;
	}

	public void setGoldTypeCart(String goldTypeCart) {
		this.goldTypeCart = goldTypeCart;
	}

	public String getGoldTypePrice() {
		return goldTypePrice;
	}

	public void setGoldTypePrice(String goldTypePrice) {
		this.goldTypePrice = goldTypePrice;
	}

	public String getGoldDate() {
		return goldDate;
	}

	public void setGoldDate(String goldDate) {
		this.goldDate = goldDate;
	}

	public String getGoldingm() {
		return goldingm;
	}

	public void setGoldingm(String goldingm) {
		this.goldingm = goldingm;
	}

	public String getExtraLoyalty() {
		return extraLoyalty;
	}

	public void setExtraLoyalty(String extraLoyalty) {
		this.extraLoyalty = extraLoyalty;
	}

	public String getTotalPurchaseOf() {
		return totalPurchaseOf;
	}

	public void setTotalPurchaseOf(String totalPurchaseOf) {
		this.totalPurchaseOf = totalPurchaseOf;
	}

	public String getAdjstmntVlue() {
		return adjstmntVlue;
	}

	public void setAdjstmntVlue(String adjstmntVlue) {
		this.adjstmntVlue = adjstmntVlue;
	}

	public String getCashRtrn() {
		return cashRtrn;
	}

	public void setCashRtrn(String cashRtrn) {
		this.cashRtrn = cashRtrn;
	}

	public String getJwlryType() {
		return jwlryType;
	}

	public void setJwlryType(String jwlryType) {
		this.jwlryType = jwlryType;
	}

	public String getDmnndGoldType() {
		return dmnndGoldType;
	}

	public void setDmnndGoldType(String dmnndGoldType) {
		this.dmnndGoldType = dmnndGoldType;
	}

	public String getPureGoldType() {
		return pureGoldType;
	}

	public void setPureGoldType(String pureGoldType) {
		this.pureGoldType = pureGoldType;
	}

	public String getSilverWght() {
		return silverWght;
	}

	public void setSilverWght(String silverWght) {
		this.silverWght = silverWght;
	}

	public String getStoneName() {
		return stoneName;
	}

	public void setStoneName(String stoneName) {
		this.stoneName = stoneName;
	}

	public String getDmndWght() {
		return dmndWght;
	}

	public void setDmndWght(String dmndWght) {
		this.dmndWght = dmndWght;
	}

	public String getDmdnRate() {
		return dmdnRate;
	}

	public void setDmdnRate(String dmdnRate) {
		this.dmdnRate = dmdnRate;
	}

	public String getDmndValue() {
		return dmndValue;
	}

	public void setDmndValue(String dmndValue) {
		this.dmndValue = dmndValue;
	}

	public String getGoldValue() {
		return goldValue;
	}

	public void setGoldValue(String goldValue) {
		this.goldValue = goldValue;
	}

	public String getGoldWght() {
		return goldWght;
	}

	public void setGoldWght(String goldWght) {
		this.goldWght = goldWght;
	}

	public String getStoneWght() {
		return stoneWght;
	}

	public void setStoneWght(String stoneWght) {
		this.stoneWght = stoneWght;
	}

}
