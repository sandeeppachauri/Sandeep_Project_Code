package com.ctrl.xsgx.model;

import java.util.List;
import java.util.Map;

import com.ctrl.xsgx.common.BaseModel;
import com.ctrl.xsgx.suvidha.client.ClientReportPojo;
import com.databean.xsgx.suvidha.commonmaster.ClientSchemeLuckyDraw;

public class ClientSchemeReportModel extends BaseModel {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected Map<Integer, String> clientNameList;
	protected Map<Integer, String> schemeList;
	protected List<ClientReportPojo> clientSearchData = null;
	protected String schemeName;
	protected String client;
	protected String dateFrom;
	protected String dateTo;
	protected String schemeStatus;
	protected Map<String, String> cardNoCollectionDetails;
	protected String cardNo;
	protected List<ClientSchemeLuckyDraw> fullActionHistory;

	public Map<Integer, String> getClientNameList() {
		return clientNameList;
	}

	public void setClientNameList(Map<Integer, String> clientNameList) {
		this.clientNameList = clientNameList;
	}

	public Map<Integer, String> getSchemeList() {
		return schemeList;
	}

	public void setSchemeList(Map<Integer, String> schemeList) {
		this.schemeList = schemeList;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public String getSchemeStatus() {
		return schemeStatus;
	}

	public void setSchemeStatus(String schemeStatus) {
		this.schemeStatus = schemeStatus;
	}

	public Map<String, String> getCardNoCollectionDetails() {
		return cardNoCollectionDetails;
	}

	public void setCardNoCollectionDetails(
			Map<String, String> cardNoCollectionDetails) {
		this.cardNoCollectionDetails = cardNoCollectionDetails;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public List<ClientSchemeLuckyDraw> getFullActionHistory() {
		return fullActionHistory;
	}

	public void setFullActionHistory(
			List<ClientSchemeLuckyDraw> fullActionHistory) {
		this.fullActionHistory = fullActionHistory;
	}

}
