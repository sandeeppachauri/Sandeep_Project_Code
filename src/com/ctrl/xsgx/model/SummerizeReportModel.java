package com.ctrl.xsgx.model;

import java.util.List;
import java.util.Map;

import com.ctrl.xsgx.common.BaseModel;
import com.ctrl.xsgx.suvidha.client.ClientReportPojo;
import com.ctrl.xsgx.suvidha.dailycollection.SummerizePojo;

public class SummerizeReportModel extends BaseModel {

	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected Map<Integer, String> agentNameList = null;
	protected Map<Integer, String> schemeNameList = null;
	protected List<SummerizePojo> summerizeData;
	protected String totalAccountTillYesterday = "0";
	protected String totalAccountCollectionTillYesterday = "0";
	protected String totalAccountTillToday = "0";
	protected String totalAccountCollectionTillToday = "0";
	protected String newMembersToday = "0";
	protected String newMemberCollection = "0";
	protected String deadMembersToday = "0";
	protected String deadMemberCollection = "0";
	protected String activeMembersToday = "0";
	protected String activeMemberCollection = "0";
	protected String totalCollectionTillYstrday = "0";
	protected String totalCollectionOfToday = "0";
	protected String totalCollectionOfAll = "0";
	protected List<SummerizePojo> summerizeDataOfNewMembers;
	protected String schemeName;
	protected List<SummerizePojo> clientWiseSchemeReport;
	protected String scheme;
	protected String dateTo;
	protected Map<String, String> schemeStatusList = null;
	protected String schemeStatus;
	protected List<ClientReportPojo> clientSearchFullViewData;
	protected int schemeId;
	
	public Map<Integer, String> getAgentNameList() {
		return agentNameList;
	}

	public void setAgentNameList(Map<Integer, String> agentNameList) {
		this.agentNameList = agentNameList;
	}

	public Map<Integer, String> getSchemeNameList() {
		return schemeNameList;
	}

	public void setSchemeNameList(Map<Integer, String> schemeNameList) {
		this.schemeNameList = schemeNameList;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getDateTo() {
		return dateTo;
	}

	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}

	public List<SummerizePojo> getSummerizeData() {
		return summerizeData;
	}

	public void setSummerizeData(List<SummerizePojo> summerizeData) {
		this.summerizeData = summerizeData;
	}

	public String getTotalAccountTillYesterday() {
		return totalAccountTillYesterday;
	}

	public void setTotalAccountTillYesterday(String totalAccountTillYesterday) {
		this.totalAccountTillYesterday = totalAccountTillYesterday;
	}

	public String getTotalAccountCollectionTillYesterday() {
		return totalAccountCollectionTillYesterday;
	}

	public void setTotalAccountCollectionTillYesterday(
			String totalAccountCollectionTillYesterday) {
		this.totalAccountCollectionTillYesterday = totalAccountCollectionTillYesterday;
	}

	public String getTotalAccountTillToday() {
		return totalAccountTillToday;
	}

	public void setTotalAccountTillToday(String totalAccountTillToday) {
		this.totalAccountTillToday = totalAccountTillToday;
	}

	public String getTotalAccountCollectionTillToday() {
		return totalAccountCollectionTillToday;
	}

	public void setTotalAccountCollectionTillToday(
			String totalAccountCollectionTillToday) {
		this.totalAccountCollectionTillToday = totalAccountCollectionTillToday;
	}

	public String getNewMembersToday() {
		return newMembersToday;
	}

	public void setNewMembersToday(String newMembersToday) {
		this.newMembersToday = newMembersToday;
	}

	public String getNewMemberCollection() {
		return newMemberCollection;
	}

	public void setNewMemberCollection(String newMemberCollection) {
		this.newMemberCollection = newMemberCollection;
	}

	public String getDeadMembersToday() {
		return deadMembersToday;
	}

	public void setDeadMembersToday(String deadMembersToday) {
		this.deadMembersToday = deadMembersToday;
	}

	public String getDeadMemberCollection() {
		return deadMemberCollection;
	}

	public void setDeadMemberCollection(String deadMemberCollection) {
		this.deadMemberCollection = deadMemberCollection;
	}

	public String getActiveMembersToday() {
		return activeMembersToday;
	}

	public void setActiveMembersToday(String activeMembersToday) {
		this.activeMembersToday = activeMembersToday;
	}

	public String getActiveMemberCollection() {
		return activeMemberCollection;
	}

	public void setActiveMemberCollection(String activeMemberCollection) {
		this.activeMemberCollection = activeMemberCollection;
	}

	public List<SummerizePojo> getSummerizeDataOfNewMembers() {
		return summerizeDataOfNewMembers;
	}

	public void setSummerizeDataOfNewMembers(
			List<SummerizePojo> summerizeDataOfNewMembers) {
		this.summerizeDataOfNewMembers = summerizeDataOfNewMembers;
	}

	public String getTotalCollectionTillYstrday() {
		return totalCollectionTillYstrday;
	}

	public void setTotalCollectionTillYstrday(String totalCollectionTillYstrday) {
		this.totalCollectionTillYstrday = totalCollectionTillYstrday;
	}

	public String getTotalCollectionOfToday() {
		return totalCollectionOfToday;
	}

	public void setTotalCollectionOfToday(String totalCollectionOfToday) {
		this.totalCollectionOfToday = totalCollectionOfToday;
	}

	public String getTotalCollectionOfAll() {
		return totalCollectionOfAll;
	}

	public void setTotalCollectionOfAll(String totalCollectionOfAll) {
		this.totalCollectionOfAll = totalCollectionOfAll;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public List<SummerizePojo> getClientWiseSchemeReport() {
		return clientWiseSchemeReport;
	}

	public void setClientWiseSchemeReport(
			List<SummerizePojo> clientWiseSchemeReport) {
		this.clientWiseSchemeReport = clientWiseSchemeReport;
	}

	public Map<String, String> getSchemeStatusList() {
		return schemeStatusList;
	}

	public void setSchemeStatusList(Map<String, String> schemeStatusList) {
		this.schemeStatusList = schemeStatusList;
	}

	public String getSchemeStatus() {
		return schemeStatus;
	}

	public void setSchemeStatus(String schemeStatus) {
		this.schemeStatus = schemeStatus;
	}

	public List<ClientReportPojo> getClientSearchFullViewData() {
		return clientSearchFullViewData;
	}

	public void setClientSearchFullViewData(
			List<ClientReportPojo> clientSearchFullViewData) {
		this.clientSearchFullViewData = clientSearchFullViewData;
	}

	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}

}
