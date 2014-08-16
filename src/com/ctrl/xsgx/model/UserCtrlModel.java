package com.ctrl.xsgx.model;

import java.util.List;
import java.util.Map;

import com.ctrl.xsgx.common.BaseModel;
import com.databean.xsgx.suvidha.commonmaster.User;

public class UserCtrlModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String userName;
	protected String loginID;
	protected String pwd;
	protected String userType;
	protected String userMob;
	protected List<User> userGridModel;
	protected int id;
	protected String oper;
	protected Map<Integer, String> userList;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserMob() {
		return userMob;
	}

	public void setUserMob(String userMob) {
		this.userMob = userMob;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public Map<Integer, String> getUserList() {
		return userList;
	}

	public void setUserList(Map<Integer, String> userList) {
		this.userList = userList;
	}

}
