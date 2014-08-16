package com.ctrl.xsgx.suvidha.user;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.model.UserCtrlModel;
import com.ctrl.xsgx.suvidha.client.ClientCtrl;
import com.databean.xsgx.suvidha.commonmaster.User;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateUtil;

@SuppressWarnings("rawtypes")
public class UserCtrl extends UserCtrlModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Log log = LogFactory.getLog(ClientCtrl.class);
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
					+ "Problem in Over2Cloud  method execute of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String createUser() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			List<User> tempMappingCheck = eventDao.getDropdownvalue("userId",
					getLoginID(), User.class);
			if (tempMappingCheck.size() > 0) {
				addActionMessage("User Id already exist, Please fill with new details");
				return SUCCESS;
			}
			User user = new User();
			user.setMobNo(getUserMob());
			user.setPassword(getPwd());
			user.setUser(userName);
			user.setUserId(getLoginID());
			user.setUserName(getUserName());
			user.setUserType(getUserType());
			boolean status = eventDao.addDetails(user);
			if (status)
				addActionMessage("User added!!!");
			else {
				addActionError("There is some error in data!!!");
				return ERROR;
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method createUser of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String viewUserData() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			setRecords(eventDao.getRecordStatus(User.class));
			int to = (getRows() * getPage());
			int from = to - getRows();
			if (to > getRecords())
				to = getRecords();
			userGridModel = eventDao.ServicesviewData(to, from,
					getSearchField(), getSearchString(), getSearchOper(),
					getSord(), getSidx(), User.class);
			setUserGridModel(userGridModel);
			setTotal((int) Math
					.ceil((double) getRecords() / (double) getRows()));
			for (User user : userGridModel) {
				if (user.getUserType().equalsIgnoreCase(
						Constant.ADMIN_USER_TYPE)) {
					user.setUserType("Admin");
				} else if (user.getUserType().equalsIgnoreCase(
						Constant.EMPLOYEE_USER_TYPE)) {
					user.setUserType("Employee");
				} else {
					user.setUserType("Client");
				}
			}
			setUserGridModel(userGridModel);
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method viewUserData of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings("rawtypes")
	public String beforePwdReset() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			userList = new HashMap<Integer, String>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder(
					"select id,userId from user order by userId");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null && obdata[0] != null
							&& obdata[1] != null) {
						userList.put((Integer) obdata[0], obdata[1].toString());
					}
				}
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method beforePwdReset of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String pwdReset() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			User user = (User) eventDao.findRecordForPk(
					Integer.parseInt(getLoginID()), User.class);
			user.setPassword(getPwd());
			boolean status = eventDao.UpdateDetails(user);
			if (status)
				addActionMessage("Password changed succesfully!!!");
			else {
				addActionError("There is some error in data!!!");
				return ERROR;
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method pwdReset of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * As per BaseModel Comments
	 */

	public List<User> getUserGridModel() {
		return userGridModel;
	}

	public void setUserGridModel(List<User> userGridModel) {
		this.userGridModel = userGridModel;
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
