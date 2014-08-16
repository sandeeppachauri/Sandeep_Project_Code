package com.ctrl.xsgx.common;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.suvidha.common.DateUtil;

/**
 * Extending any class with this BaseModel and seprating data variable in model
 * class, needs to put all setter/getter of return type="JSON" to be in the
 * action class, if this will not it will notr return any data to json result
 * set.
 * 
 * @author Sandy
 * 
 */
public class BaseModel extends ActionSupport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 10024545454L;
	public Map session = ActionContext.getContext().getSession();
	public String userName = (String) session.get("userId");
	static final Log log = LogFactory.getLog(BaseModel.class);

	public String execute() {
		try {
			if (userName == null || userName.equalsIgnoreCase(""))
				return LOGIN;
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method execute of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String checkUser() {
		if (userName == null || userName.equalsIgnoreCase("")) {
			return LOGIN;
		} else {
			return Constant.VALID_USER;
		}
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
