package com.ctrl.xsgx.suvidha.clientlogin;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.model.ClientLoginWorkModel;
import com.ctrl.xsgx.suvidha.client.ClientCtrl;
import com.databean.xsgx.suvidha.commonmaster.Client;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateUtil;

public class ClientLoginWork extends ClientLoginWorkModel {

	static final Log log = LogFactory.getLog(ClientCtrl.class);

	public String execute() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method execute of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeMyInfo() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			Client client = (Client) eventDao.findRecordForPk(
					Integer.parseInt(clientId), Client.class);
			clientName = client.getClientName();
			clientMob = client.getClientMob();
			clientPhoneno = client.getClientPhoneno();
			clientEmailId = client.getClientEmailId();
			clientAddress = client.getClientAddress();
			doj_date = client.getDoj_date();
			dob_date = client.getDob_date();
			doa_date = client.getDoa_date();
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method beforeMyInfo of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String updateClientInfo() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			Client client = (Client) eventDao.findRecordForPk(
					Integer.parseInt(clientId), Client.class);
			client.setClientName(getClientName());
			client.setClientMob(getClientMob());
			client.setClientPhoneno(getClientPhoneno());
			client.setClientEmailId(getClientEmailId());
			client.setClientAddress(getClientAddress());
			client.setDoj_date(getDoj_date());
			client.setDob_date(getDob_date());
			client.setDoa_date(getDoa_date());
			eventDao.UpdateDetails(client);
			addActionMessage("Your Information Updated Successfully!!!");
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method updateClientInfo of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeMySchemes() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method beforeMySchemes of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeMyContactUs() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method beforeMyContactUs of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforePayUs() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method beforePayUs of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
