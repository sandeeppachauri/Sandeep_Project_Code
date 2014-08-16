package com.ctrl.xsgx.model;

import java.util.List;
import java.util.Map;

import com.ctrl.xsgx.common.BaseModel;
import com.databean.xsgx.suvidha.commonmaster.DailyCollectionDB;

public class ClientSchemeCloseCtrlModel extends BaseModel {

	
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected Map<Integer, String>clientNameList=null;
	protected Map<Integer, String>schemeNameList=null;
	protected String schemeName;
	protected String id;
	protected String status;
	protected List<DailyCollectionDB>clientWiseDailyCollectionHistory=null;
	protected int totalCollectionRecieve=0;
	protected String amountSubmitDaily=null;
	protected String totalAmount=null;
	protected String periodOfScheme;
	protected String frequnecy;
	protected String joingDate;
	protected String schemeStatus;
	protected String schemeTypeRecvd;
	protected String matryAmmount;
	protected String cmpltnTime;
	protected String closeRemark;
	protected String totalInst;
	protected String totalAmmountDeposite;
	protected Map<Object, Object>goldDetails=null;
	protected String goldDate=null;
	protected String module;
	/**
	 * for scheme close reward
	 */
	
	protected String clientId;
	protected String schemeid;
	protected String rewardType;
	protected String cashInHand;
	protected String goldTypeCart;
	protected String goldTypePrice;
	protected String goldingm;
	protected String goldOfrs;

	
	
	protected String clientSchemeId;
	protected String rewardCash;
	protected String withdrawStatus;
	protected String goldingmPrcs;
	/**
	 * new modified variables added
	 * @return
	 */
	protected String totalPurchaseOf;
	protected String adjstmntVlue;
	protected String cashRtrn;
	protected String jwlryType;
	protected String dmnndGoldType;
	protected String pureGoldType;
	protected String silverWght;
	protected String stoneName;
	protected String dmndWght;
	protected String dmdnRate;
	protected String dmndValue;
	protected String goldValue;
	protected String goldWght;
	protected String stoneWght;
	protected String extraLoyalty;
	
	
	public void setClientNameList(Map<Integer, String> clientNameList) {
		this.clientNameList = clientNameList;
	}


	public Map<Integer, String> getSchemeNameList() {
		return schemeNameList;
	}


	public void setSchemeNameList(Map<Integer, String> schemeNameList) {
		this.schemeNameList = schemeNameList;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<DailyCollectionDB> getClientWiseDailyCollectionHistory() {
		return clientWiseDailyCollectionHistory;
	}


	public void setClientWiseDailyCollectionHistory(
			List<DailyCollectionDB> clientWiseDailyCollectionHistory) {
		this.clientWiseDailyCollectionHistory = clientWiseDailyCollectionHistory;
	}


	public int getTotalCollectionRecieve() {
		return totalCollectionRecieve;
	}


	public void setTotalCollectionRecieve(int totalCollectionRecieve) {
		this.totalCollectionRecieve = totalCollectionRecieve;
	}


	public String getAmountSubmitDaily() {
		return amountSubmitDaily;
	}


	public void setAmountSubmitDaily(String amountSubmitDaily) {
		this.amountSubmitDaily = amountSubmitDaily;
	}


	public String getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getPeriodOfScheme() {
		return periodOfScheme;
	}


	public void setPeriodOfScheme(String periodOfScheme) {
		this.periodOfScheme = periodOfScheme;
	}


	public String getFrequnecy() {
		return frequnecy;
	}


	public void setFrequnecy(String frequnecy) {
		this.frequnecy = frequnecy;
	}


	public String getJoingDate() {
		return joingDate;
	}


	public void setJoingDate(String joingDate) {
		this.joingDate = joingDate;
	}


	public String getSchemeStatus() {
		return schemeStatus;
	}


	public void setSchemeStatus(String schemeStatus) {
		this.schemeStatus = schemeStatus;
	}


	public String getSchemeTypeRecvd() {
		return schemeTypeRecvd;
	}


	public void setSchemeTypeRecvd(String schemeTypeRecvd) {
		this.schemeTypeRecvd = schemeTypeRecvd;
	}


	public String getMatryAmmount() {
		return matryAmmount;
	}


	public void setMatryAmmount(String matryAmmount) {
		this.matryAmmount = matryAmmount;
	}


	public String getCmpltnTime() {
		return cmpltnTime;
	}


	public void setCmpltnTime(String cmpltnTime) {
		this.cmpltnTime = cmpltnTime;
	}


	public String getCloseRemark() {
		return closeRemark;
	}


	public void setCloseRemark(String closeRemark) {
		this.closeRemark = closeRemark;
	}


	public String getTotalInst() {
		return totalInst;
	}


	public void setTotalInst(String totalInst) {
		this.totalInst = totalInst;
	}


	public String getTotalAmmountDeposite() {
		return totalAmmountDeposite;
	}


	public void setTotalAmmountDeposite(String totalAmmountDeposite) {
		this.totalAmmountDeposite = totalAmmountDeposite;
	}


	public Map<Object, Object> getGoldDetails() {
		return goldDetails;
	}


	public void setGoldDetails(Map<Object, Object> goldDetails) {
		this.goldDetails = goldDetails;
	}


	public String getGoldDate() {
		return goldDate;
	}


	public void setGoldDate(String goldDate) {
		this.goldDate = goldDate;
	}


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public String getSchemeid() {
		return schemeid;
	}


	public void setSchemeid(String schemeid) {
		this.schemeid = schemeid;
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


	public String getClientSchemeId() {
		return clientSchemeId;
	}


	public void setClientSchemeId(String clientSchemeId) {
		this.clientSchemeId = clientSchemeId;
	}


	public String getRewardCash() {
		return rewardCash;
	}


	public void setRewardCash(String rewardCash) {
		this.rewardCash = rewardCash;
	}


	public String getWithdrawStatus() {
		return withdrawStatus;
	}


	public void setWithdrawStatus(String withdrawStatus) {
		this.withdrawStatus = withdrawStatus;
	}


	public String getGoldingmPrcs() {
		return goldingmPrcs;
	}


	public void setGoldingmPrcs(String goldingmPrcs) {
		this.goldingmPrcs = goldingmPrcs;
	}


	public String getModule() {
		return module;
	}


	public void setModule(String module) {
		this.module = module;
	}


	public String getGoldOfrs() {
		return goldOfrs;
	}


	public void setGoldOfrs(String goldOfrs) {
		this.goldOfrs = goldOfrs;
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


	public String getSchemeName() {
		return schemeName;
	}


	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public Map<Integer, String> getClientNameList() {
		return clientNameList;
	}
	
}
