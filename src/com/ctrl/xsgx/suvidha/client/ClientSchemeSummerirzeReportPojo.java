package com.ctrl.xsgx.suvidha.client;

public class ClientSchemeSummerirzeReportPojo {

	//from first join query for getting daily colletion report n summerization
	private String clientName;
	private String cardNo;
	private double totalCollectionTillNow;
	private String totalCollectionCounter;
	private String schemePurchaseDate;
	private String collectionDate;
	//from joing query second from scheme and scheme type
	private String schemeName;
	private String schemeAmmount;
	private String schemeOurContree;
	private String schemeFrequency;
	private String schemeMaturtyAmmount;
	private String schemePeriod;
	private String schemeTotalAmmount;
	private String schemeStatus="Active";
	
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public double getTotalCollectionTillNow() {
		return totalCollectionTillNow;
	}
	public void setTotalCollectionTillNow(double totalCollectionTillNow) {
		this.totalCollectionTillNow = totalCollectionTillNow;
	}
	public String getTotalCollectionCounter() {
		return totalCollectionCounter;
	}
	public void setTotalCollectionCounter(String totalCollectionCounter) {
		this.totalCollectionCounter = totalCollectionCounter;
	}
	public String getSchemePurchaseDate() {
		return schemePurchaseDate;
	}
	public void setSchemePurchaseDate(String schemePurchaseDate) {
		this.schemePurchaseDate = schemePurchaseDate;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getSchemeAmmount() {
		return schemeAmmount;
	}
	public void setSchemeAmmount(String schemeAmmount) {
		this.schemeAmmount = schemeAmmount;
	}
	public String getSchemeOurContree() {
		return schemeOurContree;
	}
	public void setSchemeOurContree(String schemeOurContree) {
		this.schemeOurContree = schemeOurContree;
	}
	public String getSchemeFrequency() {
		return schemeFrequency;
	}
	public void setSchemeFrequency(String schemeFrequency) {
		this.schemeFrequency = schemeFrequency;
	}
	public String getSchemeMaturtyAmmount() {
		return schemeMaturtyAmmount;
	}
	public void setSchemeMaturtyAmmount(String schemeMaturtyAmmount) {
		this.schemeMaturtyAmmount = schemeMaturtyAmmount;
	}
	public String getSchemePeriod() {
		return schemePeriod;
	}
	public void setSchemePeriod(String schemePeriod) {
		this.schemePeriod = schemePeriod;
	}
	public String getSchemeTotalAmmount() {
		return schemeTotalAmmount;
	}
	public void setSchemeTotalAmmount(String schemeTotalAmmount) {
		this.schemeTotalAmmount = schemeTotalAmmount;
	}
	public String getCollectionDate() {
		return collectionDate;
	}
	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}
	public String getSchemeStatus() {
		return schemeStatus;
	}
	public void setSchemeStatus(String schemeStatus) {
		this.schemeStatus = schemeStatus;
	}
	
	
}
