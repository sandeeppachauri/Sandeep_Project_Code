package com.ctrl.xsgx.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctrl.xsgx.common.BaseModel;
import com.databean.xsgx.suvidha.commonmaster.DailyCollectionDB;

public class DailyCollectionUploadReportModel extends BaseModel{

	
	/**
	 * 
	 */
	protected static final long serialVersionUID = 1L;
	protected Map<String, String>agentNames;
	protected Map<String, String>clientsNames;
	protected Integer rows = 0;
	// Get the requested page. By default grid sets this to 1.
	protected Integer page = 0;
	// sorting order - asc or desc
	protected String sord = "";
	// get index row - i.e. user click to sort.
	protected String sidx = "";
	// Search Field
	protected String searchField = "";
	// The Search String
	protected String searchString = "";
	// The Search Operation
	// ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	protected String searchOper = "";
	// Your Total Pages
	protected Integer total = 0;
	// All Record
	protected Integer records = 0;
	protected boolean loadonce = false;
	//Grid colomn view
	protected String oper;
	protected int id;
	protected List<DailyCollectionDB> searchReportView;
	protected String agent;
	protected String client;
	protected String cardNo;
	protected String collectionType;
	protected String dateFrom;
	protected String dateTo;
	protected String recieptNo;
	protected Map<String, Object> userdata = new HashMap<String, Object>();
	protected Map<String, Integer>  pieDataMap;
	protected String graphHeader;
	
	
	public Map<String, String> getAgentNames() {
		return agentNames;
	}

	public void setAgentNames(Map<String, String> agentNames) {
		this.agentNames = agentNames;
	}

	public Map<String, String> getClientsNames() {
		return clientsNames;
	}

	public void setClientsNames(Map<String, String> clientsNames) {
		this.clientsNames = clientsNames;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
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

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
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

	public String getRecieptNo() {
		return recieptNo;
	}

	public void setRecieptNo(String recieptNo) {
		this.recieptNo = recieptNo;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public boolean isLoadonce() {
		return loadonce;
	}

	public void setLoadonce(boolean loadonce) {
		this.loadonce = loadonce;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, Object> getUserdata() {
		return userdata;
	}

	public void setUserdata(Map<String, Object> userdata) {
		this.userdata = userdata;
	}

	public Map<String, Integer> getPieDataMap() {
		return pieDataMap;
	}

	public void setPieDataMap(Map<String, Integer> pieDataMap) {
		this.pieDataMap = pieDataMap;
	}

	public String getGraphHeader() {
		return graphHeader;
	}

	public void setGraphHeader(String graphHeader) {
		this.graphHeader = graphHeader;
	}
	
	

}
