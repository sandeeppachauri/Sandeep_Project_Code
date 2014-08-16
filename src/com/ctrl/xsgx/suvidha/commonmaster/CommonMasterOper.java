package com.ctrl.xsgx.suvidha.commonmaster;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.model.CommonMasterOperModel;
import com.databean.xsgx.suvidha.commonmaster.AreaDB;
import com.databean.xsgx.suvidha.commonmaster.GoldPrice;
import com.databean.xsgx.suvidha.commonmaster.Smtp;
import com.databean.xsgx.suvidha.commonmaster.SourceDB;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateUtil;

@SuppressWarnings("rawtypes")
public class CommonMasterOper extends CommonMasterOperModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Log log = LogFactory.getLog(CommonMasterOper.class);
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
	
	public String execute() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method execute of class " + getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String areaMasterAdd() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			AreaDB ab = new AreaDB();
			ab.setName(getAreaName());
			ab.setCode(getAreaCode());
			ab.setDesc(getAreaDesc());
			ab.setDate(DateUtil.getCurrentDateUSFormat());
			ab.setTime(DateUtil.getCurrentTime());
			ab.setUser(userName);
			boolean status = eventDao.addDetails(ab);
			if (status)
				addActionMessage("Area added!!!");
			else
				addActionError("There is some error in data!!!");

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method areaMasterAdd of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String viewArea() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			setRecords(eventDao.getRecordStatus(AreaDB.class));
			int to = (getRows() * getPage());
			int from = to - getRows();
			if (to > getRecords())
				to = getRecords();
			areaGridModel = eventDao.ServicesviewData(to, from,
					getSearchField(), getSearchString(), getSearchOper(),
					getSord(), getSidx(), AreaDB.class);
			setAreaGridModel(areaGridModel);
			setTotal((int) Math
					.ceil((double) getRecords() / (double) getRows()));
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method viewArea of class " + getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String editArea() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			if (oper.equalsIgnoreCase(Constant.EDIT_GRID_DATA)) {
				CommonHibernateOper eventDao = new CommonHibernateOper();
				AreaDB pcmBeanId = (AreaDB) eventDao.findRecordForPk(getId(),
						AreaDB.class);
				pcmBeanId.setName(getName());
				pcmBeanId.setCode(getCode());
				pcmBeanId.setDesc(getDesc());
				eventDao.UpdateDetails(pcmBeanId);
			} else if (oper.equalsIgnoreCase(Constant.DELETE_GRID_DATA)) {

			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method editArea of class " + getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * Source master works start from here
	 * 
	 * @return
	 */

	public String sourceMasterAdd() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			SourceDB ab = new SourceDB();
			ab.setSourceCode(getSourceCode());
			ab.setSourceDesc(getSourceDesc());
			ab.setSourceName(getSourceName());
			ab.setDate(DateUtil.getCurrentDateUSFormat());
			ab.setTime(DateUtil.getCurrentTime());
			ab.setUser(userName);
			boolean status = eventDao.addDetails(ab);
			if (status)
				addActionMessage("Source added!!!");
			else
				addActionError("There is some error in data!!!");

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method sourceMasterAdd of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String viewSource() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			setRecords(eventDao.getRecordStatus(SourceDB.class));
			int to = (getRows() * getPage());
			int from = to - getRows();
			if (to > getRecords())
				to = getRecords();
			sourceGridModel = eventDao.ServicesviewData(to, from,
					getSearchField(), getSearchString(), getSearchOper(),
					getSord(), getSidx(), SourceDB.class);
			setSourceGridModel(sourceGridModel);
			setTotal((int) Math
					.ceil((double) getRecords() / (double) getRows()));
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method viewSource of class " + getClass(),
					e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String editSource() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			if (oper.equalsIgnoreCase(Constant.EDIT_GRID_DATA)) {
				CommonHibernateOper eventDao = new CommonHibernateOper();
				SourceDB pcmBeanId = (SourceDB) eventDao.findRecordForPk(
						getId(), SourceDB.class);
				pcmBeanId.setSourceCode(getSourceCode());
				pcmBeanId.setSourceDesc(getSourceDesc());
				pcmBeanId.setSourceName(getSourceName());
				eventDao.UpdateDetails(pcmBeanId);
			} else if (oper.equalsIgnoreCase(Constant.DELETE_GRID_DATA)) {

			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method editSource of class " + getClass(),
					e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * Smtp works here
	 * 
	 * @return
	 */

	public String smtpAdd() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			Smtp smtp = new Smtp();
			smtp.setServer(getServer());
			smtp.setPort(getPort());
			smtp.setEmailid(getEmailid());
			smtp.setPwd(getPwd());
			smtp.setDate(DateUtil.getCurrentDateUSFormat());
			smtp.setTime(DateUtil.getCurrentTime());
			smtp.setUser(userName);
			boolean status = eventDao.addDetails(smtp);
			if (status)
				addActionMessage("Email id added!!!");
			else
				addActionError("There is some error in data!!!");

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method smtpAdd of class " + getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String viewSmtp() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			setRecords(eventDao.getRecordStatus(Smtp.class));
			int to = (getRows() * getPage());
			int from = to - getRows();
			if (to > getRecords())
				to = getRecords();
			smtpGridModel = eventDao.ServicesviewData(to, from,
					getSearchField(), getSearchString(), getSearchOper(),
					getSord(), getSidx(), Smtp.class);
			setSmtpGridModel(smtpGridModel);
			setTotal((int) Math
					.ceil((double) getRecords() / (double) getRows()));
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method viewSmtp of class " + getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String editSmtp() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			if (oper.equalsIgnoreCase(Constant.EDIT_GRID_DATA)) {
				CommonHibernateOper eventDao = new CommonHibernateOper();
				Smtp smtp = (Smtp) eventDao
						.findRecordForPk(getId(), Smtp.class);
				smtp.setServer(getServer());
				smtp.setPort(getPort());
				smtp.setEmailid(getEmailid());
				smtp.setPwd(getPwd());
				eventDao.UpdateDetails(smtp);
			} else if (oper.equalsIgnoreCase(Constant.DELETE_GRID_DATA)) {

			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method editSmtp of class " + getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * Gold price setting on daily basis
	 * 
	 * @return
	 */

	public String addGoldRate() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			GoldPrice goldPrice = new GoldPrice();
			goldPrice.setGoldRate(getGoldPrice());
			goldPrice.setGoldRateDate(DateUtil
					.convertDateToUSFormat(getDateOfGold()));
			goldPrice.setDate(DateUtil.getCurrentDateUSFormat());
			goldPrice.setTime(DateUtil.getCurrentTime());
			goldPrice.setUser(userName);
			boolean status = eventDao.addDetails(goldPrice);
			if (status)
				addActionMessage("Gold price added!!!");
			else
				addActionError("There is some error in data!!!");

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method addGoldRate of class " + getClass(),
					e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String viewGoldRate() {
		try {
			if (userName == null || userName.equalsIgnoreCase(""))
				return LOGIN;
			CommonHibernateOper eventDao = new CommonHibernateOper();
			setRecords(eventDao.getRecordStatus(GoldPrice.class));
			int to = (getRows() * getPage());
			int from = to - getRows();
			if (to > getRecords())
				to = getRecords();
			goldGridModel = eventDao.ServicesviewData(to, from,
					getSearchField(), getSearchString(), getSearchOper(),
					getSord(), getSidx(), GoldPrice.class);
			setGoldGridModel(goldGridModel);
			for (GoldPrice gp : goldGridModel) {
				gp.setGoldRateDate(DateUtil.convertDateToIndianFormat(gp
						.getGoldRateDate()));
			}
			setGoldGridModel(goldGridModel);
			setTotal((int) Math
					.ceil((double) getRecords() / (double) getRows()));
		} catch (Exception e) {
			log.error(
					"Date : " + DateUtil.getCurrentDateIndianFormat()
							+ " Time: " + DateUtil.getCurrentTime() + " "
							+ "Problem in   method viewGoldRate of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String editGoldRate() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			if (oper.equalsIgnoreCase(Constant.EDIT_GRID_DATA)) {
				CommonHibernateOper eventDao = new CommonHibernateOper();
				GoldPrice gold = (GoldPrice) eventDao.findRecordForPk(getId(),
						GoldPrice.class);
				gold.setGoldRate(getGoldRate());
				eventDao.UpdateDetails(gold);
			} else if (oper.equalsIgnoreCase(Constant.DELETE_GRID_DATA)) {

			}
		} catch (Exception e) {
			log.error(
					"Date : " + DateUtil.getCurrentDateIndianFormat()
							+ " Time: " + DateUtil.getCurrentTime() + " "
							+ "Problem in   method editGoldRate of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String fullDetailGoldPrice() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			goldDetails = new LinkedHashMap<String, Object>();
			/**
			 * 14K is 14 / 24 = .583 x 100 = 58.3% gold which is $583/ounce or
			 * $18.75/gram 18K is 18 / 24 = .750 x 100 = 75.0% gold which is
			 * $750/ounce or $24.12/gram 22K is 22 / 24 = .916 x 100 = 91.6%
			 * gold which is $916/ounce or $29.45/gram
			 * value=totalgold*%value/100;
			 */
			Double value = Integer.parseInt(getGoldRate()) * 91.6 / 100;
			goldDetails.put(Constant._22_GOLD_TYPE, value);

			value = Integer.parseInt(getGoldRate()) * 75.0 / 100;
			goldDetails.put(Constant._18_GOLD_TYPE, value);

			value = Integer.parseInt(getGoldRate()) * 58.3 / 100;
			goldDetails.put(Constant._14_GOLD_TYPE, value);
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method fullDetailGoldPrice of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String bdayAndAnvrsyList() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			bday = new LinkedHashMap<String, Object>();
			anvrsy = new LinkedHashMap<String, Object>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder("");
			query.append("select clientname,dob_date,clientmob from clientmaster where dob_date>='"
					+ DateUtil.getCurrentDateUSFormat() + "' order by dob_date");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				// level1Data
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata[2] != null
							&& !obdata[2].toString().equalsIgnoreCase("")) {
						String mob = obdata[2].toString();
						bday.put(obdata[0].toString() + "," + mob,
								DateUtil.convertDateToIndianFormat(obdata[1]
										.toString()));
					} else {
						bday.put(obdata[0].toString() + ",0",
								DateUtil.convertDateToIndianFormat(obdata[1]
										.toString()));
					}
				}
			}

			query.delete(0, query.length());
			query.append("select clientname,doa_date,clientmob from clientmaster where doa_date>='"
					+ DateUtil.getCurrentDateUSFormat() + "' order by doa_date");
			data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				// level1Data
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata[2] != null
							&& !obdata[2].toString().equalsIgnoreCase("")) {
						String mob = obdata[2].toString();
						anvrsy.put(obdata[0].toString() + "," + mob,
								DateUtil.convertDateToIndianFormat(obdata[1]
										.toString()));
					} else {
						anvrsy.put(obdata[0].toString() + ",0",
								DateUtil.convertDateToIndianFormat(obdata[1]
										.toString()));
					}
				}
			}

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method bdayAndAnvrsyList of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeSendWishses() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			setMobNo(getMobNo());
			setFlag(getFlag());
			setName(getName());

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method beforeSendWishses of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * As per BaseModel Comments
	 */
	public List<AreaDB> getAreaGridModel() {
		return areaGridModel;
	}

	public void setAreaGridModel(List<AreaDB> areaGridModel) {
		this.areaGridModel = areaGridModel;
	}

	public List<SourceDB> getSourceGridModel() {
		return sourceGridModel;
	}

	public void setSourceGridModel(List<SourceDB> sourceGridModel) {
		this.sourceGridModel = sourceGridModel;
	}

	public List<Smtp> getSmtpGridModel() {
		return smtpGridModel;
	}

	public void setSmtpGridModel(List<Smtp> smtpGridModel) {
		this.smtpGridModel = smtpGridModel;
	}

	public List<GoldPrice> getGoldGridModel() {
		return goldGridModel;
	}

	public void setGoldGridModel(List<GoldPrice> goldGridModel) {
		this.goldGridModel = goldGridModel;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Log getLog() {
		return log;
	}
	
}
