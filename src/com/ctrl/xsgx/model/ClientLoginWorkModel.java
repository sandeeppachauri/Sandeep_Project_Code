package com.ctrl.xsgx.model;

import com.ctrl.xsgx.common.BaseModel;

public class ClientLoginWorkModel extends BaseModel {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected String clientId = (String) session.get("clientId");
	protected String clientName;
	protected String clientMob;
	protected String clientPhoneno;
	protected String clientEmailId;
	protected String clientAddress;
	protected String doj_date;
	protected String dob_date;
	protected String doa_date;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientMob() {
		return clientMob;
	}

	public void setClientMob(String clientMob) {
		this.clientMob = clientMob;
	}

	public String getClientPhoneno() {
		return clientPhoneno;
	}

	public void setClientPhoneno(String clientPhoneno) {
		this.clientPhoneno = clientPhoneno;
	}

	public String getClientEmailId() {
		return clientEmailId;
	}

	public void setClientEmailId(String clientEmailId) {
		this.clientEmailId = clientEmailId;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public String getDoj_date() {
		return doj_date;
	}

	public void setDoj_date(String doj_date) {
		this.doj_date = doj_date;
	}

	public String getDob_date() {
		return dob_date;
	}

	public void setDob_date(String dob_date) {
		this.dob_date = dob_date;
	}

	public String getDoa_date() {
		return doa_date;
	}

	public void setDoa_date(String doa_date) {
		this.doa_date = doa_date;
	}
}
