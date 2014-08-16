package com.databean.xsgx.suvidha.commonmaster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "dailycollectiondb")
@Proxy(lazy = false)
public class DailyCollectionDB {

	/*
	 * Reciept No Collect Amount A/C No( Card No) Client Name A/C Type Cheque No
	 * Collect Date Bank/Cash Ag_Code
	 */

	private int id;
	private String user;
	private String entryDate;
	private String recieptNo;
	private String ammount;
	private String cardNo;
	private String clientName;
	private String accountType;
	private String chequeNo;
	private String collectionDate;
	private String bankCash;
	private String agentCode;
	private String mode = "Machine";

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "user")
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "entryDate")
	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	@Column(name = "recieptNo")
	public String getRecieptNo() {
		return recieptNo;
	}

	public void setRecieptNo(String recieptNo) {
		this.recieptNo = recieptNo;
	}

	@Column(name = "ammount")
	public String getAmmount() {
		return ammount;
	}

	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}

	@Column(name = "cardNo")
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Column(name = "clientName")
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Column(name = "accountType")
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Column(name = "chequeNo")
	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	@Column(name = "collectionDate")
	public String getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}

	@Column(name = "bankCash")
	public String getBankCash() {
		return bankCash;
	}

	public void setBankCash(String bankCash) {
		this.bankCash = bankCash;
	}

	@Column(name = "agentCode")
	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	@Column(name = "mode")
	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
