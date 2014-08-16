package com.ctrl.xsgx.model;

import java.util.List;
import java.util.Map;

import com.ctrl.xsgx.common.BaseModel;
import com.databean.xsgx.suvidha.commonmaster.Employee;
import com.databean.xsgx.suvidha.commonmaster.KittyManagment;

public class EmployeeCtrlModel extends BaseModel {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected String empName;
	protected String empMob;
	protected String empPhoneNo;
	protected String empEmailId;
	protected String empAddress;
	protected String doj_date;
	protected String empId;
	protected List<Employee> empGridModel;
	protected int id;
	protected String oper;
	protected Map<Integer, String> empList;
	protected Map<Integer, String> areaList;
	protected String clientName;
	protected String schemeName;

	// Kitty management

	protected Map<Integer, String> empNameList = null;
	protected Map<Integer, String> groupNameList = null;
	protected String groupName;
	protected Map<Integer, String> mappedGroupNameList=null;
	protected String groupId;
	protected String empIdkitty;
	protected String rewardAmount;
	protected String mappedGroupName;
	protected String kittyDate;
	protected List<KittyManagment> kittyData;
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpMob() {
		return empMob;
	}

	public void setEmpMob(String empMob) {
		this.empMob = empMob;
	}

	public String getEmpPhoneNo() {
		return empPhoneNo;
	}

	public void setEmpPhoneNo(String empPhoneNo) {
		this.empPhoneNo = empPhoneNo;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getDoj_date() {
		return doj_date;
	}

	public void setDoj_date(String doj_date) {
		this.doj_date = doj_date;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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

	public Map<Integer, String> getEmpList() {
		return empList;
	}

	public void setEmpList(Map<Integer, String> empList) {
		this.empList = empList;
	}

	public Map<Integer, String> getAreaList() {
		return areaList;
	}

	public void setAreaList(Map<Integer, String> areaList) {
		this.areaList = areaList;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public List<Employee> getEmpGridModel() {
		return empGridModel;
	}

	public void setEmpGridModel(List<Employee> empGridModel) {
		this.empGridModel = empGridModel;
	}

	public Map<Integer, String> getEmpNameList() {
		return empNameList;
	}

	public void setEmpNameList(Map<Integer, String> empNameList) {
		this.empNameList = empNameList;
	}

	public Map<Integer, String> getGroupNameList() {
		return groupNameList;
	}

	public void setGroupNameList(Map<Integer, String> groupNameList) {
		this.groupNameList = groupNameList;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getEmpIdkitty() {
		return empIdkitty;
	}

	public void setEmpIdkitty(String empIdkitty) {
		this.empIdkitty = empIdkitty;
	}

	public String getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(String rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public Map<Integer, String> getMappedGroupNameList() {
		return mappedGroupNameList;
	}

	public void setMappedGroupNameList(Map<Integer, String> mappedGroupNameList) {
		this.mappedGroupNameList = mappedGroupNameList;
	}

	public String getMappedGroupName() {
		return mappedGroupName;
	}

	public void setMappedGroupName(String mappedGroupName) {
		this.mappedGroupName = mappedGroupName;
	}

	public String getKittyDate() {
		return kittyDate;
	}

	public void setKittyDate(String kittyDate) {
		this.kittyDate = kittyDate;
	}

	public List<KittyManagment> getKittyData() {
		return kittyData;
	}

	public void setKittyData(List<KittyManagment> kittyData) {
		this.kittyData = kittyData;
	}

}
