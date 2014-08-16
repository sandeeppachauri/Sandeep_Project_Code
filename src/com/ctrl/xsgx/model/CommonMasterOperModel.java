package com.ctrl.xsgx.model;

import java.util.List;
import java.util.Map;

import com.ctrl.xsgx.common.BaseModel;
import com.databean.xsgx.suvidha.commonmaster.AreaDB;
import com.databean.xsgx.suvidha.commonmaster.GoldPrice;
import com.databean.xsgx.suvidha.commonmaster.Smtp;
import com.databean.xsgx.suvidha.commonmaster.SourceDB;

public class CommonMasterOperModel extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String areaName;
	protected String areaCode;
	protected String areaDesc;
	protected List<AreaDB> areaGridModel;
	protected List<SourceDB> sourceGridModel;
	protected List<GoldPrice> goldGridModel;
	protected List<Smtp> smtpGridModel;
	protected int id;
	protected String oper;
	protected String name;
	protected String code;
	protected String desc;
	protected String sourceName;
	protected String sourceCode;
	protected String sourceDesc;
	protected String server;
	protected String port;
	protected String emailid;
	protected String pwd;
	protected String goldPrice;
	protected String dateOfGold;
	protected String goldRate;
	protected Map<String, Object> goldDetails = null;
	protected Map<String, Object> bday = null;
	protected Map<String, Object> anvrsy = null;
	protected String flag;
	protected String mobNo;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaDesc() {
		return areaDesc;
	}

	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceDesc() {
		return sourceDesc;
	}

	public void setSourceDesc(String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGoldPrice() {
		return goldPrice;
	}

	public void setGoldPrice(String goldPrice) {
		this.goldPrice = goldPrice;
	}

	public String getDateOfGold() {
		return dateOfGold;
	}

	public void setDateOfGold(String dateOfGold) {
		this.dateOfGold = dateOfGold;
	}

	public String getGoldRate() {
		return goldRate;
	}

	public void setGoldRate(String goldRate) {
		this.goldRate = goldRate;
	}

	public Map<String, Object> getGoldDetails() {
		return goldDetails;
	}

	public void setGoldDetails(Map<String, Object> goldDetails) {
		this.goldDetails = goldDetails;
	}

	public Map<String, Object> getBday() {
		return bday;
	}

	public void setBday(Map<String, Object> bday) {
		this.bday = bday;
	}

	public Map<String, Object> getAnvrsy() {
		return anvrsy;
	}

	public void setAnvrsy(Map<String, Object> anvrsy) {
		this.anvrsy = anvrsy;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
}
