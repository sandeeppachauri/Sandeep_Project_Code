package com.ctrl.xsgx.suvidha.employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.data.entity.layer.ClientCtrlDao;
import com.ctrl.xsgx.data.entity.layerimpl.ClientCtrlDaoImpl;
import com.ctrl.xsgx.model.EmployeeCtrlModel;
import com.databean.xsgx.suvidha.commonmaster.AreaEmployeeMapping;
import com.databean.xsgx.suvidha.commonmaster.EmpGroupMapping;
import com.databean.xsgx.suvidha.commonmaster.Employee;
import com.databean.xsgx.suvidha.commonmaster.KittyManagment;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateUtil;

@SuppressWarnings("rawtypes")
public class EmployeeCtrl extends EmployeeCtrlModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Log log = LogFactory.getLog(EmployeeCtrl.class);
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
					+ "Problem in method execute of class " + getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String employeeAdd() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			Employee eb = new Employee();
			eb.setEmpName(getEmpName());
			eb.setEmpMob(getEmpMob());
			eb.setEmpPhoneNo(getEmpPhoneNo());
			eb.setEmpEmailId(getEmpEmailId());
			eb.setEmpAddress(getEmpAddress());
			eb.setDoj_date(getDoj_date());
			eb.setEmpId(getEmpId());
			eb.setEntryDate(DateUtil.getCurrentDateUSFormat());
			eb.setEntryTime(DateUtil.getCurrentTime());
			eb.setEntryUser(userName);
			boolean status = eventDao.addDetails(eb);
			if (status)
				addActionMessage("Employee added!!!");
			else
				addActionError("There is some error in data!!!");

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method employeeAdd of class " + getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String viewEmp() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			setRecords(eventDao.getRecordStatus(Employee.class));
			int to = (getRows() * getPage());
			int from = to - getRows();
			if (to > getRecords())
				to = getRecords();
			empGridModel = eventDao.ServicesviewData(to, from,
					getSearchField(), getSearchString(), getSearchOper(),
					getSord(), getSidx(), Employee.class);
			setEmpGridModel(empGridModel);
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

	public String editEmp() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			if (oper.equalsIgnoreCase(Constant.EDIT_GRID_DATA)) {
				CommonHibernateOper eventDao = new CommonHibernateOper();
				Employee eb = (Employee) eventDao.findRecordForPk(getId(),
						Employee.class);
				eb.setEmpName(getEmpName());
				eb.setEmpMob(getEmpMob());
				eb.setEmpPhoneNo(getEmpPhoneNo());
				eb.setEmpEmailId(getEmpEmailId());
				eb.setEmpAddress(getEmpAddress());
				eb.setDoj_date(getDoj_date());
				eb.setEmpId(getEmpId());
				eventDao.UpdateDetails(eb);
			} else if (oper.equalsIgnoreCase(Constant.DELETE_GRID_DATA)) {

			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method editEmp of class " + getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeEmployeeAreaMap() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			empList = new LinkedHashMap<Integer, String>();
			areaList = new LinkedHashMap<Integer, String>();
			StringBuilder query = new StringBuilder(
					"select id,empname from emploee  order by empname");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null && obdata[0] != null
							&& obdata[1] != null) {
						empList.put((Integer) obdata[0], obdata[1].toString());
					}
				}
			}
			query.delete(0, query.length());
			query.append("select id,areaname from areamaster order by areaname");
			data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null && obdata[0] != null
							&& obdata[1] != null) {
						areaList.put((Integer) obdata[0], obdata[1].toString());
					}
				}
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method employeeMapArea of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String employeeAreaMapping() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			if (getSchemeName() != null && getClientName() != null) {
				CommonHibernateOper eventDao = new CommonHibernateOper();
				AreaEmployeeMapping are = new AreaEmployeeMapping();
				are.setEmpID(getClientName());
				are.setDate(DateUtil.getCurrentDateUSFormat());
				are.setTime(DateUtil.getCurrentTime());
				are.setUser(userName);

				String split[] = getSchemeName().split(", ");
				for (String H : split) {
					if (!H.equalsIgnoreCase("") && H != null) {
						List<AreaEmployeeMapping> tempMappingCheck = eventDao
								.getDropdownvalue("aeaID", H,
										AreaEmployeeMapping.class);
						if (tempMappingCheck != null
								&& tempMappingCheck.size() == 0) {
							are.setAeaID(H);
							eventDao.addDetails(are);
						} else {
							for (AreaEmployeeMapping ah : tempMappingCheck) {
								ah.setEmpID(getClientName());
								eventDao.UpdateDetails(ah);
							}
						}
					}
				}

				addActionMessage("Employee mapped with area!!!");
			} else {
				addActionError("There is some error in data!!!");
				return ERROR;
			}

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method employeeAreaMapping of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String fullDetailOfEmployeeArea() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			empList = new LinkedHashMap<Integer, String>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder(
					""
							+ "select cmapp.id,client.clientname from clientagentmapping as cmapp left join clientmaster as client on cmapp.clientId=client.id "
							+ "where cmapp.agentId='" + getId() + "'");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null && obdata[0] != null
							&& obdata[1] != null) {
						empList.put((Integer) obdata[0], obdata[1].toString());
					}
				}
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method fullDetailOfEmployeeArea of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String deleteEmpFromArea() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			AreaEmployeeMapping ahm = (AreaEmployeeMapping) eventDao
					.findRecordForPk(getId(), AreaEmployeeMapping.class);
			if (ahm != null) {
				eventDao.DeleteRecord(ahm, AreaEmployeeMapping.class);
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method deleteEmpFromArea of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeKittyManager() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			empNameList = clientCtrlDao.getAgentList(eventDao);
			groupNameList = clientCtrlDao.getGroupNames(eventDao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String mapOrganizerWithGroup() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			EmpGroupMapping eb = new EmpGroupMapping();
			eb.setEmpName(getEmpName());
			eb.setGroupName(getGroupName());
			eb.setEntryDate(DateUtil.getCurrentDateUSFormat());
			eb.setEntryTime(DateUtil.getCurrentTime());
			eb.setEntryUser(userName);
			boolean status = eventDao.addDetails(eb);

			/*
			 * Update flag of old group mapping, so new updated mapping will be
			 * used
			 */
			StringBuilder query = new StringBuilder(
					"update empgroupmapping set activeStatus='0' where empName!='"
							+ getEmpName() + "' and groupName='"
							+ getGroupName() + "'");
			eventDao.executeTrans(query.toString());
			if (status)
				addActionMessage("Organizer Mapped !!!");
			else
				addActionError("There is some error in data!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getMapGroup() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			mappedGroupNameList = new LinkedHashMap<Integer, String>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder(
					"select gm.id,gm.groupName from groupmaster as gm "
							+ "inner join empgroupmapping as egm on egm.groupName=gm.id where egm.empName='"
							+ getId() + "' and egm.activeStatus='1'");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null && obdata[0] != null
							&& obdata[1] != null) {
						mappedGroupNameList.put((Integer) obdata[0],
								obdata[1].toString());
					}
				}
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method fullDetailOfEmployeeArea of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getMapGroupDetail() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder(
					"select orgznRewardAmount from groupconfiguration where groupId='"
							+ getId() + "'");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object obdata = (Object) it.next();
					if (obdata != null) {
						rewardAmount = obdata.toString();
					} else {
						return ERROR;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String kittyOrganizationDone() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			KittyManagment eb = new KittyManagment();
			eb.setEmpName(getEmpIdkitty());
			eb.setGroupName(getMappedGroupName());
			if (getKittyDate() == null) {
				eb.setEntryDate(DateUtil.getCurrentDateUSFormat());
			} else {
				eb.setEntryDate(DateUtil.convertDateToUSFormat(getKittyDate()));
			}
			eb.setEntryTime(DateUtil.getCurrentTime());
			eb.setEntryUser(userName);
			eb.setRewardAmount(getRewardAmount());
			boolean status = eventDao.addDetails(eb);
			if (status)
				addActionMessage("Added !!!");
			else
				addActionError("There is some error in data!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeViewKittyManager() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			empNameList = clientCtrlDao.getAgentList(eventDao);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String viewReport() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			kittyData = new ArrayList<KittyManagment>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder(
					"select ktm.entryDate,ktm.entryTime,ktm.entryUser,gm.groupName,ktm.rewardAmount from kittymanagment as ktm "
							+ "left join groupmaster as gm on ktm.groupName=gm.id where ktm.empName='"
							+ getId() + "'");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null) {
						KittyManagment kittyManagment = new KittyManagment();
						if (obdata[0] != null) {
							kittyManagment.setEntryDate(obdata[0].toString());
						}
						if (obdata[1] != null) {
							kittyManagment.setEntryTime(obdata[1].toString());
						}
						if (obdata[2] != null) {
							kittyManagment.setEntryUser(obdata[2].toString());
						}
						if (obdata[3] != null) {
							kittyManagment.setGroupName(obdata[3].toString());
						}
						if (obdata[4] != null) {
							kittyManagment
									.setRewardAmount(obdata[4].toString());
						}
						kittyData.add(kittyManagment);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * As per BaseModel Comments
	 */

	public List<Employee> getEmpGridModel() {
		return empGridModel;
	}

	public void setEmpGridModel(List<Employee> empGridModel) {
		this.empGridModel = empGridModel;
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
