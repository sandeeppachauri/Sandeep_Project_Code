package com.ctrl.xsgx.model;

import java.io.File;
import java.util.Map;

import com.ctrl.xsgx.common.BaseModel;

public class DailyCollectionUploadModel extends BaseModel{

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected File excel;
	protected String excelContentType;
	protected String excelFileName;
	protected Map<Integer, String>clientNameList=null;
	protected Map<String, String>schemeNameList=null;
	protected String id;
	protected String client;
	protected String cardNo;
	protected String clientName;
	protected String agentName;
	protected String submitAmmount;
	protected String colelctionDate;
	protected String colctnMode;
	protected String chequeNo;

	public File getExcel() {
		return excel;
	}


	public void setExcel(File excel) {
		this.excel = excel;
	}


	public String getExcelContentType() {
		return excelContentType;
	}


	public void setExcelContentType(String excelContentType) {
		this.excelContentType = excelContentType;
	}


	public String getExcelFileName() {
		return excelFileName;
	}


	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}

	public Map<Integer, String> getClientNameList() {
		return clientNameList;
	}

	public void setClientNameList(Map<Integer, String> clientNameList) {
		this.clientNameList = clientNameList;
	}

	public Map<String, String> getSchemeNameList() {
		return schemeNameList;
	}

	public void setSchemeNameList(Map<String, String> schemeNameList) {
		this.schemeNameList = schemeNameList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getSubmitAmmount() {
		return submitAmmount;
	}

	public void setSubmitAmmount(String submitAmmount) {
		this.submitAmmount = submitAmmount;
	}

	public String getColelctionDate() {
		return colelctionDate;
	}

	public void setColelctionDate(String colelctionDate) {
		this.colelctionDate = colelctionDate;
	}

	public String getColctnMode() {
		return colctnMode;
	}

	public void setColctnMode(String colctnMode) {
		this.colctnMode = colctnMode;
	}

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

}
