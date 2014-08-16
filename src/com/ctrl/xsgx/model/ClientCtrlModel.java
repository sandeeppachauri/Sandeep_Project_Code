package com.ctrl.xsgx.model;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctrl.xsgx.common.BaseModel;
import com.ctrl.xsgx.suvidha.client.ClientSchemeSummerirzeReportPojo;
import com.databean.xsgx.suvidha.commonmaster.Client;
import com.databean.xsgx.suvidha.commonmaster.DailyCollectionDB;

public class ClientCtrlModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<Integer, String> sourceData;
	protected String referBy;
	protected String sourceName;
	protected String schemeName;
	protected String clientName;
	protected String clientMob;
	protected String clientPhoneno;
	protected String clientEmailId;
	protected String clientAddress;
	protected String doj_date;
	protected String dob_date;
	protected String doa_date;
	protected String areaName;
	protected File pic;
	protected String picContentType;
	protected String picFileName;
	protected File idProof;
	protected String idProofContentType;
	protected String idProofFileName;
	protected Map<Integer, String> areaList;
	protected Map<Integer, String> clientNameList = null;
	protected Map<Integer, String> refereNameList = null;
	protected boolean referScheme=true;
	protected Map<Integer, String> referCardNoList = null;
	protected Map<Integer, String> agentNameList = null;
	protected Map<Integer, String> schemeNameList = null;
	protected String referCardNo;
	protected int schemeId;
	protected List<Client> clientGridModel;
	protected int id;
	protected String oper;
	protected String clientsForCard;
	protected String cardNo;
	protected String schemeJoinDate;
	protected String agentName;
	protected List<ClientSchemeSummerirzeReportPojo> clientSummerizeReport;
	protected Map<String, Object> userdata = new HashMap<String, Object>();
	protected String status;
	protected List<DailyCollectionDB> clientWiseDailyCollectionHistory = null;
	protected int totalCollectionRecieve = 0;
	protected String amountSubmitDaily = null;
	protected String totalAmount = null;
	protected String periodOfScheme;
	protected String frequnecy;
	protected String joingDate;
	protected String schemeStatus;
	protected String schemeTypeRecvd;
	protected String moduleFalg;
	protected String headingName;
	protected String gridid;
	protected InputStream fileInputStream;
	protected String fileName;
	protected String path;
	protected Map<String, String> searchData = null;
	protected String surrenderRsn;

	public Map<Integer, String> getSourceData() {
		return sourceData;
	}

	public void setSourceData(Map<Integer, String> sourceData) {
		this.sourceData = sourceData;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
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

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	public File getIdProof() {
		return idProof;
	}

	public void setIdProof(File idProof) {
		this.idProof = idProof;
	}

	public String getIdProofContentType() {
		return idProofContentType;
	}

	public void setIdProofContentType(String idProofContentType) {
		this.idProofContentType = idProofContentType;
	}

	public String getIdProofFileName() {
		return idProofFileName;
	}

	public void setIdProofFileName(String idProofFileName) {
		this.idProofFileName = idProofFileName;
	}

	public Map<Integer, String> getClientNameList() {
		return clientNameList;
	}

	public void setClientNameList(Map<Integer, String> clientNameList) {
		this.clientNameList = clientNameList;
	}

	public String getClientsForCard() {
		return clientsForCard;
	}

	public void setClientsForCard(String clientsForCard) {
		this.clientsForCard = clientsForCard;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getSchemeJoinDate() {
		return schemeJoinDate;
	}

	public void setSchemeJoinDate(String schemeJoinDate) {
		this.schemeJoinDate = schemeJoinDate;
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

	public Map<Integer, String> getAgentNameList() {
		return agentNameList;
	}

	public void setAgentNameList(Map<Integer, String> agentNameList) {
		this.agentNameList = agentNameList;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public Map<Integer, String> getSchemeNameList() {
		return schemeNameList;
	}

	public void setSchemeNameList(Map<Integer, String> schemeNameList) {
		this.schemeNameList = schemeNameList;
	}

	public Map<String, Object> getUserdata() {
		return userdata;
	}

	public void setUserdata(Map<String, Object> userdata) {
		this.userdata = userdata;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalCollectionRecieve() {
		return totalCollectionRecieve;
	}

	public void setTotalCollectionRecieve(int totalCollectionRecieve) {
		this.totalCollectionRecieve = totalCollectionRecieve;
	}

	public String getAmountSubmitDaily() {
		return amountSubmitDaily;
	}

	public void setAmountSubmitDaily(String amountSubmitDaily) {
		this.amountSubmitDaily = amountSubmitDaily;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPeriodOfScheme() {
		return periodOfScheme;
	}

	public void setPeriodOfScheme(String periodOfScheme) {
		this.periodOfScheme = periodOfScheme;
	}

	public String getFrequnecy() {
		return frequnecy;
	}

	public void setFrequnecy(String frequnecy) {
		this.frequnecy = frequnecy;
	}

	public String getJoingDate() {
		return joingDate;
	}

	public void setJoingDate(String joingDate) {
		this.joingDate = joingDate;
	}

	public String getSchemeStatus() {
		return schemeStatus;
	}

	public void setSchemeStatus(String schemeStatus) {
		this.schemeStatus = schemeStatus;
	}

	public String getSurrenderRsn() {
		return surrenderRsn;
	}

	public void setSurrenderRsn(String surrenderRsn) {
		this.surrenderRsn = surrenderRsn;
	}

	public String getSchemeTypeRecvd() {
		return schemeTypeRecvd;
	}

	public void setSchemeTypeRecvd(String schemeTypeRecvd) {
		this.schemeTypeRecvd = schemeTypeRecvd;
	}

	public String getModuleFalg() {
		return moduleFalg;
	}

	public void setModuleFalg(String moduleFalg) {
		this.moduleFalg = moduleFalg;
	}

	public String getHeadingName() {
		return headingName;
	}

	public void setHeadingName(String headingName) {
		this.headingName = headingName;
	}

	public String getGridid() {
		return gridid;
	}

	public void setGridid(String gridid) {
		this.gridid = gridid;
	}

	public String getReferBy() {
		return referBy;
	}

	public void setReferBy(String referBy) {
		this.referBy = referBy;
	}

	public Map<Integer, String> getAreaList() {
		return areaList;
	}

	public void setAreaList(Map<Integer, String> areaList) {
		this.areaList = areaList;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public InputStream getFileInputStream() {
		return fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, String> getSearchData() {
		return searchData;
	}

	public void setSearchData(Map<String, String> searchData) {
		this.searchData = searchData;
	}

	public Map<Integer, String> getRefereNameList() {
		return refereNameList;
	}

	public void setRefereNameList(Map<Integer, String> refereNameList) {
		this.refereNameList = refereNameList;
	}

	public Map<Integer, String> getReferCardNoList() {
		return referCardNoList;
	}

	public void setReferCardNoList(Map<Integer, String> referCardNoList) {
		this.referCardNoList = referCardNoList;
	}

	public List<Client> getClientGridModel() {
		return clientGridModel;
	}

	public void setClientGridModel(List<Client> clientGridModel) {
		this.clientGridModel = clientGridModel;
	}

	public List<ClientSchemeSummerirzeReportPojo> getClientSummerizeReport() {
		return clientSummerizeReport;
	}

	public void setClientSummerizeReport(
			List<ClientSchemeSummerirzeReportPojo> clientSummerizeReport) {
		this.clientSummerizeReport = clientSummerizeReport;
	}

	public String getReferCardNo() {
		return referCardNo;
	}

	public void setReferCardNo(String referCardNo) {
		this.referCardNo = referCardNo;
	}

	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}

	
}
