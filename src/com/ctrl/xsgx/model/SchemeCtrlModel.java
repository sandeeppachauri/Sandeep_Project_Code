package com.ctrl.xsgx.model;

import java.util.List;
import java.util.Map;

import com.ctrl.xsgx.common.BaseModel;
import com.ctrl.xsgx.suvidha.client.ClientReportPojo;
import com.ctrl.xsgx.suvidha.client.GroupBasedCollectionReportPojo;
import com.ctrl.xsgx.suvidha.scheme.SchemePojo;
import com.databean.xsgx.suvidha.scheme.GroupMaster;
import com.databean.xsgx.suvidha.scheme.SchemeWithdraw;

public class SchemeCtrlModel extends BaseModel {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	// Instance Variables for Scheme Name
	protected int id;
	protected String schemeName;
	protected String schemeDesc;
	protected String schemeStartDate;
	protected String schemeEndDate;
	protected String groupAble;
	protected List<SchemePojo> schemeList;
	protected List<SchemePojo> luckySchemeList;
	protected List<SchemePojo> withSchemeList;
	protected List<SchemePojo> schemeWithList;

	// Instance Variables for SchemeType
	protected String scheme1;
	protected String multiTimeValue;
	protected String amount;
	protected String minPeriod;
	protected String contr;
	protected String maxAmount;
	protected String withdrw;
	protected String totalAmount;
	protected String luckyDraw;
	protected String incremntal;

	// Instance Variables For SchemeBonus
	protected String scheme2;
	protected String schemeBonusDate;
	protected String bonusAmount;

	// Instance Variables For Scheme Withdraw
	protected String scheme3;
	protected String withAmount;
	protected String frequency;
	protected String minWeek;
	protected String maxWeek;
	protected String widraw;
	protected String paymentAfter;
	// Instance Variables for Lucky Draw
	protected String scheme4;
	protected String luckyDrawAmt;
	protected String luckyPay;
	protected String paymentMode;

	// Instance Variables for Extra Loyality
	protected String scheme5;
	protected String loyalityAmount;
	protected String loyalityGms;

	// Group Management

	protected String groupName;
	protected String groupCustomerNumber;
	protected String groupStartDate;

	// Group Mapping with customer

	// Group Configuration
	protected Map<Integer, String> clientNameList = null;
	protected Map<Integer, String> groupNameList = null;
	protected String schemeID;
	protected String minInstPay;
	protected String maxMonth;
	protected String rewardAmount;
	protected String futurPay;
	protected String orgnzrAmount;
	protected String groupId;
	protected String clientId;
	protected Map<Integer, String> clientGroupSchemeDetails;
	protected String gid;

	// Instance Variables to show Scheme In Grid
	// Instance Variables to Show Scheme Details
	protected List<SchemePojo> schemeGridModel;
	protected List<SchemeWithdraw> condList;
	protected List<GroupMaster> groupGridModel;
	protected Map<String, String> mappedClientWithGroup;
	protected Map<Integer, String> schemeNameList = null;
	protected Map<Integer, String> totalTextBox = null;
	protected String schemeId;
	protected String incrmtnValue;
	protected final String FREQUENCY = "frequency";
	protected final String SCHEME_TYPE = "schemetype";
	protected final String SCHEME_ID = "schemeId";

	protected String clientName;
	protected String clientMobileNumber;
	protected int refrncCountFrom;
	protected int refrncCountTo;
	protected List<ClientReportPojo> clientSearchData;
	protected List<ClientReportPojo> clientSearchFullViewData;
	protected List<GroupBasedCollectionReportPojo> clientGroupFullReport;
	protected int totalCollection=0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getSchemeDesc() {
		return schemeDesc;
	}

	public void setSchemeDesc(String schemeDesc) {
		this.schemeDesc = schemeDesc;
	}

	public String getSchemeStartDate() {
		return schemeStartDate;
	}

	public void setSchemeStartDate(String schemeStartDate) {
		this.schemeStartDate = schemeStartDate;
	}

	public String getSchemeEndDate() {
		return schemeEndDate;
	}

	public void setSchemeEndDate(String schemeEndDate) {
		this.schemeEndDate = schemeEndDate;
	}

	public List<SchemePojo> getSchemeList() {
		return schemeList;
	}

	public void setSchemeList(List<SchemePojo> schemeList) {
		this.schemeList = schemeList;
	}

	public String getScheme1() {
		return scheme1;
	}

	public void setScheme1(String scheme1) {
		this.scheme1 = scheme1;
	}

	public String getMultiTimeValue() {
		return multiTimeValue;
	}

	public void setMultiTimeValue(String multiTimeValue) {
		this.multiTimeValue = multiTimeValue;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getMinPeriod() {
		return minPeriod;
	}

	public void setMinPeriod(String minPeriod) {
		this.minPeriod = minPeriod;
	}

	public String getContr() {
		return contr;
	}

	public void setContr(String contr) {
		this.contr = contr;
	}

	public String getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(String maxAmount) {
		this.maxAmount = maxAmount;
	}

	public String getWithdrw() {
		return withdrw;
	}

	public void setWithdrw(String withdrw) {
		this.withdrw = withdrw;
	}

	public String getScheme2() {
		return scheme2;
	}

	public void setScheme2(String scheme2) {
		this.scheme2 = scheme2;
	}

	public String getSchemeBonusDate() {
		return schemeBonusDate;
	}

	public void setSchemeBonusDate(String schemeBonusDate) {
		this.schemeBonusDate = schemeBonusDate;
	}

	public String getBonusAmount() {
		return bonusAmount;
	}

	public void setBonusAmount(String bonusAmount) {
		this.bonusAmount = bonusAmount;
	}

	public String getScheme3() {
		return scheme3;
	}

	public void setScheme3(String scheme3) {
		this.scheme3 = scheme3;
	}

	public String getWithAmount() {
		return withAmount;
	}

	public void setWithAmount(String withAmount) {
		this.withAmount = withAmount;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getMinWeek() {
		return minWeek;
	}

	public void setMinWeek(String minWeek) {
		this.minWeek = minWeek;
	}

	public String getMaxWeek() {
		return maxWeek;
	}

	public void setMaxWeek(String maxWeek) {
		this.maxWeek = maxWeek;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getLuckyDraw() {
		return luckyDraw;
	}

	public void setLuckyDraw(String luckyDraw) {
		this.luckyDraw = luckyDraw;
	}

	public List<SchemePojo> getLuckySchemeList() {
		return luckySchemeList;
	}

	public void setLuckySchemeList(List<SchemePojo> luckySchemeList) {
		this.luckySchemeList = luckySchemeList;
	}

	public List<SchemePojo> getWithSchemeList() {
		return withSchemeList;
	}

	public void setWithSchemeList(List<SchemePojo> withSchemeList) {
		this.withSchemeList = withSchemeList;
	}

	public List<SchemePojo> getSchemeWithList() {
		return schemeWithList;
	}

	public void setSchemeWithList(List<SchemePojo> schemeWithList) {
		this.schemeWithList = schemeWithList;
	}

	public String getScheme4() {
		return scheme4;
	}

	public void setScheme4(String scheme4) {
		this.scheme4 = scheme4;
	}

	public String getLuckyDrawAmt() {
		return luckyDrawAmt;
	}

	public void setLuckyDrawAmt(String luckyDrawAmt) {
		this.luckyDrawAmt = luckyDrawAmt;
	}

	public String getLuckyPay() {
		return luckyPay;
	}

	public void setLuckyPay(String luckyPay) {
		this.luckyPay = luckyPay;
	}

	public String getScheme5() {
		return scheme5;
	}

	public void setScheme5(String scheme5) {
		this.scheme5 = scheme5;
	}

	public String getLoyalityAmount() {
		return loyalityAmount;
	}

	public void setLoyalityAmount(String loyalityAmount) {
		this.loyalityAmount = loyalityAmount;
	}

	public String getLoyalityGms() {
		return loyalityGms;
	}

	public void setLoyalityGms(String loyalityGms) {
		this.loyalityGms = loyalityGms;
	}

	public String getWidraw() {
		return widraw;
	}

	public void setWidraw(String widraw) {
		this.widraw = widraw;
	}

	public String getPaymentAfter() {
		return paymentAfter;
	}

	public void setPaymentAfter(String paymentAfter) {
		this.paymentAfter = paymentAfter;
	}

	public String getIncremntal() {
		return incremntal;
	}

	public void setIncremntal(String incremntal) {
		this.incremntal = incremntal;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public List<SchemeWithdraw> getCondList() {
		return condList;
	}

	public void setCondList(List<SchemeWithdraw> condList) {
		this.condList = condList;
	}


	public Map<Integer, String> getSchemeNameList() {
		return schemeNameList;
	}

	public void setSchemeNameList(Map<Integer, String> schemeNameList) {
		this.schemeNameList = schemeNameList;
	}

	public Map<Integer, String> getTotalTextBox() {
		return totalTextBox;
	}

	public void setTotalTextBox(Map<Integer, String> totalTextBox) {
		this.totalTextBox = totalTextBox;
	}

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public String getIncrmtnValue() {
		return incrmtnValue;
	}

	public void setIncrmtnValue(String incrmtnValue) {
		this.incrmtnValue = incrmtnValue;
	}

	public String getGroupAble() {
		return groupAble;
	}

	public void setGroupAble(String groupAble) {
		this.groupAble = groupAble;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupCustomerNumber() {
		return groupCustomerNumber;
	}

	public void setGroupCustomerNumber(String groupCustomerNumber) {
		this.groupCustomerNumber = groupCustomerNumber;
	}

	public String getGroupStartDate() {
		return groupStartDate;
	}

	public void setGroupStartDate(String groupStartDate) {
		this.groupStartDate = groupStartDate;
	}

	public Map<Integer, String> getClientNameList() {
		return clientNameList;
	}

	public void setClientNameList(Map<Integer, String> clientNameList) {
		this.clientNameList = clientNameList;
	}

	public String getSchemeID() {
		return schemeID;
	}

	public void setSchemeID(String schemeID) {
		this.schemeID = schemeID;
	}

	public String getMinInstPay() {
		return minInstPay;
	}

	public void setMinInstPay(String minInstPay) {
		this.minInstPay = minInstPay;
	}

	public String getMaxMonth() {
		return maxMonth;
	}

	public void setMaxMonth(String maxMonth) {
		this.maxMonth = maxMonth;
	}

	public String getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(String rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public List<SchemePojo> getSchemeGridModel() {
		return schemeGridModel;
	}

	public void setSchemeGridModel(List<SchemePojo> schemeGridModel) {
		this.schemeGridModel = schemeGridModel;
	}

	public String getFREQUENCY() {
		return FREQUENCY;
	}

	public String getSCHEME_TYPE() {
		return SCHEME_TYPE;
	}

	public String getSCHEME_ID() {
		return SCHEME_ID;
	}

	public String getFuturPay() {
		return futurPay;
	}

	public void setFuturPay(String futurPay) {
		this.futurPay = futurPay;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public Map<Integer, String> getGroupNameList() {
		return groupNameList;
	}

	public void setGroupNameList(Map<Integer, String> groupNameList) {
		this.groupNameList = groupNameList;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Map<Integer, String> getClientGroupSchemeDetails() {
		return clientGroupSchemeDetails;
	}

	public void setClientGroupSchemeDetails(
			Map<Integer, String> clientGroupSchemeDetails) {
		this.clientGroupSchemeDetails = clientGroupSchemeDetails;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getOrgnzrAmount() {
		return orgnzrAmount;
	}

	public void setOrgnzrAmount(String orgnzrAmount) {
		this.orgnzrAmount = orgnzrAmount;
	}

	public List<GroupMaster> getGroupGridModel() {
		return groupGridModel;
	}

	public void setGroupGridModel(List<GroupMaster> groupGridModel) {
		this.groupGridModel = groupGridModel;
	}

	public Map<String, String> getMappedClientWithGroup() {
		return mappedClientWithGroup;
	}

	public void setMappedClientWithGroup(
			Map<String, String> mappedClientWithGroup) {
		this.mappedClientWithGroup = mappedClientWithGroup;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientMobileNumber() {
		return clientMobileNumber;
	}

	public void setClientMobileNumber(String clientMobileNumber) {
		this.clientMobileNumber = clientMobileNumber;
	}

	public int getRefrncCountFrom() {
		return refrncCountFrom;
	}

	public void setRefrncCountFrom(int refrncCountFrom) {
		this.refrncCountFrom = refrncCountFrom;
	}

	public int getRefrncCountTo() {
		return refrncCountTo;
	}

	public void setRefrncCountTo(int refrncCountTo) {
		this.refrncCountTo = refrncCountTo;
	}

	public List<ClientReportPojo> getClientSearchData() {
		return clientSearchData;
	}

	public void setClientSearchData(List<ClientReportPojo> clientSearchData) {
		this.clientSearchData = clientSearchData;
	}

	public List<ClientReportPojo> getClientSearchFullViewData() {
		return clientSearchFullViewData;
	}

	public void setClientSearchFullViewData(
			List<ClientReportPojo> clientSearchFullViewData) {
		this.clientSearchFullViewData = clientSearchFullViewData;
	}

	public List<GroupBasedCollectionReportPojo> getClientGroupFullReport() {
		return clientGroupFullReport;
	}

	public void setClientGroupFullReport(
			List<GroupBasedCollectionReportPojo> clientGroupFullReport) {
		this.clientGroupFullReport = clientGroupFullReport;
	}

	public int getTotalCollection() {
		return totalCollection;
	}

	public void setTotalCollection(int totalCollection) {
		this.totalCollection = totalCollection;
	}
	

}
