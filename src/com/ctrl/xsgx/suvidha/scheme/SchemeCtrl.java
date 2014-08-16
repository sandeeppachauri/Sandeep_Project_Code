package com.ctrl.xsgx.suvidha.scheme;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.data.entity.layer.ClientCtrlDao;
import com.ctrl.xsgx.data.entity.layerimpl.ClientCtrlDaoImpl;
import com.ctrl.xsgx.model.SchemeCtrlModel;
import com.ctrl.xsgx.suvidha.client.ClientReportPojo;
import com.ctrl.xsgx.suvidha.client.GroupBasedCollectionReportPojo;
import com.databean.xsgx.suvidha.commonmaster.ClientScheme;
import com.databean.xsgx.suvidha.scheme.ExtraLoyality;
import com.databean.xsgx.suvidha.scheme.GroupClientMapping;
import com.databean.xsgx.suvidha.scheme.GroupConfiguration;
import com.databean.xsgx.suvidha.scheme.GroupMaster;
import com.databean.xsgx.suvidha.scheme.IncermentalBean;
import com.databean.xsgx.suvidha.scheme.LuckyDraw;
import com.databean.xsgx.suvidha.scheme.Scheme;
import com.databean.xsgx.suvidha.scheme.SchemeBonus;
import com.databean.xsgx.suvidha.scheme.SchemeType;
import com.databean.xsgx.suvidha.scheme.SchemeWithdraw;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateUtil;

/**
 * @author AVINASH
 * 
 */
@SuppressWarnings("rawtypes")
public class SchemeCtrl extends SchemeCtrlModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Log log = LogFactory.getLog(SchemeCtrl.class);
	// Instance Varibles for Grid
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
	protected String oper;

	public String getSchemeDetails() {
		if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
			return LOGIN;
		}
		SchemeDao dao = new SchemeDao();
		frequency = dao.getSchemeType(FREQUENCY, SCHEME_TYPE, SCHEME_ID,
				getScheme1());
		return SUCCESS;
	}

	public String viewSchemeDetails() {
		if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
			return LOGIN;
		}
		return SUCCESS;
	}

	public String beforeMapWithGroup() {
		if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
			return LOGIN;
		}
		return SUCCESS;
	}

	public String viewSchemeCondDetails() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			if (getId() != 0) {

				SchemeDao dao = new SchemeDao();

				setCondList(dao.getWithdrawCondition(getId()));
				return SUCCESS;
			} else {
				return INPUT;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(
					"Exception in method viewSchemeConditionDetails() of class "
							+ getClass(), e);
			return ERROR;
		}
	}

	public String viewSchemeConditionDetails() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			log.error(
					"Exception in method viewSchemeConditionDetails() of class "
							+ getClass(), e);
			return ERROR;
		}
	}

	public String viewSchemeFullDetails() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			setRecords(eventDao.getRecordStatus(Scheme.class));
			int to = (getRows() * getPage());
			int from = to - getRows();
			if (to > getRecords())
				to = getRecords();
			List<SchemePojo> tempList = new ArrayList<SchemePojo>();
			List<Scheme> schm = eventDao.ServicesviewData(to, from,
					getSearchField(), getSearchString(), getSearchOper(),
					getSord(), getSidx(), Scheme.class);
			for (Scheme s : schm) {/*
									 * SchemePojo pojo=new SchemePojo();
									 * pojo.setId(s.getId());
									 * pojo.setSchemeName(s.getSchemeName());
									 * pojo.setSchemeDesc(s.getSchemeDesc());
									 * 
									 * String typeId=new
									 * SchemeDao().getSchemeType
									 * ("id","schemetype",
									 * "schemeId",String.valueOf(s.getId()));
									 * 
									 * if(typeId!=null) { SchemeType
									 * type=(SchemeType
									 * )eventDao.findRecordForPk(
									 * Integer.parseInt(typeId),
									 * SchemeType.class);
									 * if(type.getFrequency()!=null) {
									 * pojo.setSchemeFrequency
									 * (type.getFrequency()); } else {
									 * pojo.setSchemeFrequency("NA"); }
									 * 
									 * if(type.getMinPeriod()!=null) {
									 * if(type.getFrequency
									 * ().equalsIgnoreCase("daily")) {
									 * pojo.setMinPeriod
									 * (type.getMinPeriod()+" days"); } else
									 * if(type
									 * .getFrequency().equalsIgnoreCase("weekly"
									 * )) {
									 * pojo.setMinPeriod(type.getMinPeriod()
									 * +" weeks"); } else
									 * if(type.getFrequency().
									 * equalsIgnoreCase("monthly")) {
									 * pojo.setMinPeriod
									 * (type.getMinPeriod()+" months"); }
									 * 
									 * } else { pojo.setMinPeriod("NA"); }
									 * 
									 * if(type.getAmount()!=null) {
									 * if(type.getFrequency
									 * ().equalsIgnoreCase("daily")) {
									 * pojo.setAmount(type.getAmount()+" /day");
									 * } else
									 * if(type.getFrequency().equalsIgnoreCase
									 * ("weekly")) {
									 * pojo.setAmount(type.getAmount
									 * ()+" /week"); } else
									 * if(type.getFrequency(
									 * ).equalsIgnoreCase("monthly")) {
									 * pojo.setAmount
									 * (type.getAmount()+" /month"); }
									 * 
									 * } else { pojo.setAmount("NA"); }
									 * 
									 * 
									 * if(type.getTotalAmount()!=null) {
									 * pojo.setTotalAmount
									 * (type.getTotalAmount()); } else {
									 * pojo.setTotalAmount("NA"); }
									 * 
									 * if(type.getContribution()!=null) {
									 * pojo.setOurContri
									 * (type.getContribution()); } else {
									 * pojo.setOurContri("NA"); }
									 * 
									 * if(type.getMaturityAmount()!=null) {
									 * pojo.
									 * setNetMaturity(type.getMaturityAmount());
									 * } else { pojo.setNetMaturity("NA"); }
									 * 
									 * if(type.getWithdrawable()!=null) {
									 * pojo.setWithdrawable
									 * (type.getWithdrawable()); } else {
									 * pojo.setWithdrawable("NA"); }
									 * 
									 * if(type.getLuckyDraw()!=null) {
									 * pojo.setLuckyDraw(type.getLuckyDraw()); }
									 * else { pojo.setLuckyDraw("NA"); }
									 * pojo.setWithdrawable("View Condition"); }
									 */
				SchemePojo pojo = new SchemeDao().getSchemeDetails(s.getId());
				tempList.add(pojo);
			}
			setSchemeGridModel(tempList);
			setTotal((int) Math
					.ceil((double) getRecords() / (double) getRows()));
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method viewSchemeFullDetails of Class "
					+ getClass(), e);
			return ERROR;
		}
	}

	public String initilize() {
		if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
			return LOGIN;
		}
		List<SchemePojo> tempList = new SchemeDao().getSchemeAll(null, null);
		if (tempList != null) {
			setSchemeList(tempList);
		}

		tempList = new SchemeDao().getSchemeAll("luckyDraw", Constant.ELIGIBLE);
		if (tempList != null) {
			setLuckySchemeList(tempList);
		}

		tempList = new SchemeDao().getSchemeAll("withdrawable",
				Constant.ELIGIBLE);
		if (tempList != null) {
			setSchemeWithList(tempList);
		}

		return SUCCESS;
	}

	public String addExtraLoyality() {

		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			ExtraLoyality loyality = new ExtraLoyality();
			loyality.setLoyalityAmount(getLoyalityAmount());
			loyality.setLoyalityGms(getLoyalityGms());
			loyality.setSchemeId(getScheme5());
			boolean status = eventDao.addDetails(loyality);
			if (status)
				addActionMessage("Extra Loyality added!!!");
			else {
				addActionError("There is some error in data!!!");
				return ERROR;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String addLuckyDraw() {

		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			LuckyDraw lucky = new LuckyDraw();
			lucky.setSchemeId(getScheme4());
			lucky.setAmount(getLuckyDrawAmt());
			lucky.setFuturepayment(getLuckyPay());
			lucky.setPaymentMode(getPaymentMode());
			boolean status = eventDao.addDetails(lucky);
			if (status)
				addActionMessage("Luck Draw added!!!");
			else {
				addActionError("There is some error in data!!!");
				return ERROR;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String addWithdrawCondition() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			SchemeWithdraw withdrawCond = new SchemeWithdraw();
			withdrawCond.setSchemeId(Integer.parseInt(getScheme3()));
			withdrawCond.setWithType(getFrequency());
			withdrawCond.setMinPeriod(getMinWeek());
			withdrawCond.setMaxPeriod(getMaxWeek());
			withdrawCond.setWidraw(getWidraw());
			withdrawCond.setPaymentAfter(getPaymentAfter());
			// withdrawCond.setWithdrawDate(getWithdrawDate());
			boolean status = eventDao.addDetails(withdrawCond);
			if (status)
				addActionMessage("Scheme Withdraw added!!!");
			else {
				addActionError("There is some error in data!!!");
				return ERROR;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String addSchemeBonus() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			SchemeBonus bonus = new SchemeBonus();
			bonus.setSchemeId(Integer.parseInt(getScheme2()));
			bonus.setMinDate(getSchemeBonusDate());
			bonus.setBonusAmount(getBonusAmount());

			boolean status = eventDao.addDetails(bonus);

			if (status)
				addActionMessage("Scheme bonus added!!!");
			else
				addActionError("There is some error in data!!!");
			return SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String addSchemeType() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			if (getScheme1() != null
					&& !getScheme1().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				CommonHibernateOper eventDao = new CommonHibernateOper();
				try {
					SchemeType schemeType = new SchemeType();
					schemeType.setSchemeId(Integer.parseInt(getScheme1()));
					schemeType.setFrequency(getMultiTimeValue());
					schemeType.setMinPeriod(getMinPeriod());
					schemeType.setAmount(getAmount());
					schemeType.setTotalAmount(getTotalAmount());
					schemeType.setContribution(getContr());
					schemeType.setMaturityAmount(getMaxAmount());
					schemeType.setWithdrawable(getWithdrw());
					schemeType.setLuckyDraw(getLuckyDraw());
					schemeType.setIncremntal(getIncremntal());
					boolean status = eventDao.addDetails(schemeType);

					if (status)
						addActionMessage("Scheme Type added!!!");
					else {
						addActionError("There is some error in data!!!");
						return ERROR;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Problem In Method addNewScheme of class " + getClass()
					+ " on " + DateUtil.getCurrentDateIndianFormat() + " at "
					+ DateUtil.getCurrentTimewithSeconds(), e);
			return ERROR;
		}
	}

	public String addNewScheme() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			Scheme scheme = new Scheme();
			scheme.setSchemeName(getSchemeName());
			scheme.setSchemeDesc(getSchemeDesc());
			scheme.setSchemeStartDate(getSchemeStartDate());
			scheme.setSchemeEndDate(getSchemeEndDate());
			if (getGroupAble() != null) {
				scheme.setGroupAble(getGroupAble());
			}
			boolean status = eventDao.addDetails(scheme);
			if (status)
				addActionMessage("Scheme added!!!");
			else {
				addActionError("There is some error in data!!!");
				return ERROR;
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Problem In Method addNewScheme of class " + getClass()
					+ " on " + DateUtil.getCurrentDateIndianFormat() + " at "
					+ DateUtil.getCurrentTimewithSeconds(), e);
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * Incremetal scheme works form here by sandeep
	 * 
	 * @return
	 */

	public String allIncrmtnlSchemes() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			/*
			 * if(userName==null || userName.equalsIgnoreCase("")) return LOGIN;
			 */
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder("");
			schemeNameList = new LinkedHashMap<Integer, String>();
			query = new StringBuilder(
					"select schem.id,schem.schemeName from scheme as schem inner join schemetype as cshtype on "
							+ "schem.id=cshtype.schemeId where cshtype.incremntal='Yes' "
							+ "order by schem.schemeName");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null && obdata[0] != null
							&& obdata[1] != null) {
						schemeNameList.put((Integer) obdata[0],
								obdata[1].toString());
					}
				}
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method allIncrmtnlSchemes of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String drawIncrtmntText() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			/*
			 * if(userName==null || userName.equalsIgnoreCase("")) return LOGIN;
			 */
			CommonHibernateOper eventDao = new CommonHibernateOper();
			totalTextBox = new LinkedHashMap<Integer, String>();
			StringBuilder query = new StringBuilder("");
			query = new StringBuilder(
					"select minPeriod from schemetype where schemeId="
							+ getSchemeId());
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				String totalCont = null;
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object obdata = (Object) it.next();
					if (obdata != null) {
						totalCont = obdata.toString();
					}
				}
				if (totalCont != null) {
					int cont = Integer.parseInt(totalCont);
					for (int i = 1; i <= cont; i++)
						totalTextBox.put(i, "Installment " + i);
				}

			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method drawIncrtmntText of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String incrmtnlSchemeAdd() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			/*
			 * if(userName==null || userName.equalsIgnoreCase("")) return LOGIN;
			 */
			CommonHibernateOper eventDao = new CommonHibernateOper();
			List<IncermentalBean> checkExy = eventDao.getDropdownvalue(
					"schemId", getSchemeName(), IncermentalBean.class);
			if (checkExy != null && checkExy.size() == 0) {
				IncermentalBean inc = new IncermentalBean();
				inc.setSchemId(getSchemeName());
				inc.setValues(getIncrmtnValue());
				inc.setUser(userName);
				boolean status = eventDao.addDetails(inc);
				if (status)
					addActionMessage("Data added successfully");
				else
					addActionError("there is some data problem, Please check your data");
			} else {
				for (IncermentalBean ic : checkExy) {
					ic.setValues(getIncrmtnValue());
					boolean status = eventDao.UpdateDetails(ic);
					if (status)
						addActionMessage("Data updated successfully");
					else
						addActionError("there is some data problem, Please check your data");
				}
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method incrmtnlSchemeAdd of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String createGroup() {

		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			GroupMaster groupMaster = new GroupMaster();
			groupMaster.setGroupName(getGroupName());
			groupMaster.setGroupCustomerNumber(getGroupCustomerNumber());
			groupMaster.setGroupStartDate(getGroupStartDate());
			groupMaster.setUser(userName);
			groupMaster.setTime(DateUtil.getCurrentTime());
			groupMaster.setDate(DateUtil.getCurrentDateUSFormat());
			boolean status = eventDao.addDetails(groupMaster);
			if (status)
				addActionMessage("Group Created!!!");
			else {
				addActionError("There is some error in data!!!");
				return ERROR;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String beforeMapGroupWithClient() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			schemeNameList = clientCtrlDao.getGroupScheme(eventDao);
			groupNameList = clientCtrlDao.getGroupNames(eventDao);

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method beforeClientAdd of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String mapGroupWithClient() {

		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();

			int existStaus = 0;
			StringBuilder query = new StringBuilder(
					"select id from groupconfiguration where groupId='"
							+ getGroupId() + "'");
			List dataTemp = eventDao.executeAllSelectQuery(query.toString());
			if (dataTemp != null) {
				for (Iterator it = dataTemp.iterator(); it.hasNext();) {
					Object obdata = (Object) it.next();
					if (obdata != null) {
						existStaus = (Integer) obdata;
					}
				}
			}
			if (existStaus == 0) {
				GroupConfiguration groupClientMapping = new GroupConfiguration();
				groupClientMapping.setUser(userName);
				groupClientMapping.setTime(DateUtil.getCurrentTime());
				groupClientMapping.setDate(DateUtil.getCurrentDateUSFormat());
				groupClientMapping.setSchemeID(getSchemeID());
				groupClientMapping.setMinInstPay(getMinInstPay());
				groupClientMapping.setMaxMonth(getMaxMonth());
				groupClientMapping.setRewardAmount(getRewardAmount());
				groupClientMapping.setFuturPay(getFuturPay());
				groupClientMapping.setOrgznRewardAmount(getOrgnzrAmount());
				groupClientMapping.setGroupId(getGroupId());
				boolean status = eventDao.addDetails(groupClientMapping);
				if (status)
					addActionMessage("Group Configuration Done!!!");
				else {
					addActionError("There is some error in data!!!");
					return ERROR;
				}
			} else {
				GroupConfiguration groupConfiguration = (GroupConfiguration) eventDao
						.findRecordForPk(existStaus, GroupConfiguration.class);
				groupConfiguration.setTime(DateUtil.getCurrentTime());
				groupConfiguration.setDate(DateUtil.getCurrentDateUSFormat());
				groupConfiguration.setMinInstPay(getMinInstPay());
				groupConfiguration.setMaxMonth(getMaxMonth());
				groupConfiguration.setRewardAmount(getRewardAmount());
				groupConfiguration.setFuturPay(getFuturPay());
				groupConfiguration.setOrgznRewardAmount(getOrgnzrAmount());
				boolean status = eventDao.UpdateDetails(groupConfiguration);
				if (status)
					addActionMessage("Group Configuration Done!!!");
				else {
					addActionError("There is some error in data!!!");
					return ERROR;
				}
			}

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String beforeMappingGroupWithClientScheme() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			clientNameList = clientCtrlDao.getClientNameList(eventDao);
			groupNameList = clientCtrlDao.getGroupNames(eventDao);

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method beforeClientAdd of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String checkGroupMembers() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder("");
			query = new StringBuilder(
					"select gcm.clientId,gc.groupCustomerNumber from groupclientmapping as gcm inner join groupmaster as gc on gc.id=gcm.groupId group by gcm.groupId='1"
							+ getGroupId() + "'");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				String numOfCustomerAllowed = null;
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null) {
						numOfCustomerAllowed = obdata[1].toString();
						break;
					}
				}
				if (numOfCustomerAllowed != null
						&& !numOfCustomerAllowed.equalsIgnoreCase("")) {
					if (Integer.parseInt(numOfCustomerAllowed) >= data.size())
						return ERROR;
					else
						return SUCCESS;
				}
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method beforeClientAdd of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getClientGroupableSchemes() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			clientGroupSchemeDetails = new LinkedHashMap<Integer, String>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder("");
			query = new StringBuilder(
					"select csm.id, sc.schemeName from clientscheme as csm inner join "
							+ "scheme as sc on sc.id=csm.schemeId where "
							+ "sc.groupAble='" + Constant.IS_GROUPABLE_SCHEME
							+ "' and csm.clientId='" + getClientId() + "' "
							+ "and csm.groupMapped='0'");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null) {
						clientGroupSchemeDetails.put((Integer) obdata[0],
								obdata[1].toString());
					}
				}
			}

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method beforeClientAdd of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String mapGroup() {

		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			if (gid != null && !getGid().equalsIgnoreCase("false")) {
				CommonHibernateOper eventDao = new CommonHibernateOper();
				System.out.println("getGid()  " + getGid());
				String mapGroupids[] = getGid().split(", ");
				boolean status = false;
				for (String H : mapGroupids) {
					if (!H.equalsIgnoreCase("")) {
						GroupClientMapping groupClientMapping = new GroupClientMapping();
						groupClientMapping.setUser(userName);
						groupClientMapping.setTime(DateUtil.getCurrentTime());
						groupClientMapping.setDate(DateUtil
								.getCurrentDateUSFormat());
						groupClientMapping.setGroupId(getGroupId());
						groupClientMapping.setClientId(getClientId());
						groupClientMapping.setClientSchemeId(H);
						ClientScheme clientScheme = (ClientScheme) eventDao
								.findRecordForPk(Integer.parseInt(H),
										ClientScheme.class);
						clientScheme.setGroupMapped("1");
						eventDao.UpdateDetails(clientScheme);
						status = eventDao.addDetails(groupClientMapping);
					}
				}

				if (status)
					addActionMessage("Group Mapping Done!!!");
				else {
					addActionError("There is some error!!!");
					return ERROR;
				}
			} else {
				addActionError("There is some error, please select atleast one scheme!!!");
				return ERROR;
			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}

	}

	public String viewGroup() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			setRecords(eventDao.getRecordStatus(GroupMaster.class));
			int to = (getRows() * getPage());
			int from = to - getRows();
			if (to > getRecords())
				to = getRecords();
			List<GroupMaster> schm = eventDao.ServicesviewData(to, from,
					getSearchField(), getSearchString(), getSearchOper(),
					getSord(), getSidx(), GroupMaster.class);
			setGroupGridModel(schm);
			setTotal((int) Math
					.ceil((double) getRecords() / (double) getRows()));
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in method viewSchemeFullDetails of Class "
					+ getClass(), e);
			return ERROR;
		}
	}

	public String editGroup() {
		if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
			return LOGIN;
		}
		if (oper.equalsIgnoreCase(Constant.EDIT_GRID_DATA)) {
			CommonHibernateOper eventDao = new CommonHibernateOper();
			GroupMaster groupMaster = (GroupMaster) eventDao.findRecordForPk(
					getId(), GroupMaster.class);
			groupMaster.setGroupName(getGroupName());
			groupMaster.setGroupCustomerNumber(getGroupCustomerNumber());
			eventDao.UpdateDetails(groupMaster);
		}
		return SUCCESS;
	}

	public String groupFullDetail() {
		if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
			return LOGIN;
		}
		mappedClientWithGroup = new LinkedHashMap<String, String>();
		CommonHibernateOper eventDao = new CommonHibernateOper();
		StringBuilder query = new StringBuilder("");
		query = new StringBuilder(
				"select clientname,clientmob,id from clientmaster where id in(select clientId from groupclientmapping where groupId="
						+ getId() + ")");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null) {
					String mobNo = null;
					if (obdata[0] != null) {
						mobNo = obdata[0].toString();
					}
					mappedClientWithGroup.put(obdata[2].toString() + "-"
							+ mobNo, obdata[1].toString());
				}
			}
		}
		return SUCCESS;
	}

	public String viewGroupReport() {
		if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
			return LOGIN;
		}

		CommonHibernateOper eventDao = new CommonHibernateOper();
		StringBuilder query = new StringBuilder("");
		query = new StringBuilder(
				"select count(referCardNo),referCardNo from clientscheme where referCardNo!='null' group by referCardNo");
		StringBuilder clientSchemeIdInCriterai = new StringBuilder("");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			boolean comma = false;
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null) {
					if (obdata[0] != null && obdata[1] != null) {
						BigInteger count = (BigInteger) obdata[0];
						if (count.intValue() >= getRefrncCountFrom()
								&& count.intValue() <= getRefrncCountTo()) {
							String cid = obdata[1].toString();
							if (!comma) {
								clientSchemeIdInCriterai.append(cid);
								comma = true;
							} else {
								clientSchemeIdInCriterai.append("," + cid);
							}
						}
					}
				}
			}
			query.delete(0, query.length());
			query.append("select id,clientname,clientmob from clientmaster where id in(select clientId from clientscheme where id in("
					+ clientSchemeIdInCriterai.toString() + "))");
			data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				clientSearchData = new ArrayList<ClientReportPojo>();
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null) {
						ClientReportPojo clientReportPojo = new ClientReportPojo();
						if (obdata[0] != null) {
							clientReportPojo.setClientId(Integer
									.parseInt(obdata[0].toString()));
						}
						if (obdata[1] != null) {
							clientReportPojo
									.setClientName(obdata[1].toString());
						}
						if (obdata[2] != null) {
							clientReportPojo.setClientMob(obdata[2].toString());
						}
						clientSearchData.add(clientReportPojo);
					}
				}
			}
		}
		return SUCCESS;
	}

	public String fullReferenceDetails() {
		if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
			return LOGIN;
		}
		CommonHibernateOper eventDao = new CommonHibernateOper();
		StringBuilder query = new StringBuilder("");
		query = new StringBuilder(
				"select sc.schemeName,csm.schemeJoinDate,csm.cardno,cm.clientname,cm.clientmob from scheme as sc "
						+ "inner join clientscheme as csm on csm.schemeId=sc.id inner join clientmaster as cm on cm.id=csm.clientId "
						+ "where csm.referCardNo in (select id from clientscheme where clientId="
						+ getClientId() + ")");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			clientSearchFullViewData = new ArrayList<ClientReportPojo>();
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null) {
					ClientReportPojo clientReportPojo = new ClientReportPojo();
					if (obdata[0] != null) {
						clientReportPojo.setSchemeName(obdata[0].toString());
					}
					if (obdata[1] != null) {
						clientReportPojo.setJoinDate(obdata[1].toString());
					}
					if (obdata[2] != null) {
						clientReportPojo.setCardNo(obdata[2].toString());
					}
					if (obdata[3] != null) {
						clientReportPojo.setClientName(obdata[3].toString());
					}
					if (obdata[4] != null) {
						clientReportPojo.setClientMob(obdata[4].toString());
					}

					clientSearchFullViewData.add(clientReportPojo);
				}
			}
		}
		return SUCCESS;
	}

	public String viewGroupMemberCollectionDetail() {
		if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
			return LOGIN;
		}
		CommonHibernateOper eventDao = new CommonHibernateOper();
		StringBuilder query = new StringBuilder("");
		if (getClientId() != null) {
			String id[] = getClientId().split("-");
			setClientId(id[0]);
		}
		query = new StringBuilder(
				"select dcb.recieptNo,csm.cardno,dcb.entryDate,dcb.collectionDate,dcb.ammount,cm.clientname,"
						+ "cm.clientmob,csm.schemeJoinDate from clientmaster as cm inner join clientscheme as csm "
						+ "on cm.id=csm.clientId inner join dailycollectiondb as dcb on csm.cardno=dcb.cardNo "
						+ "where csm.clientId="
						+ getClientId()
						+ " and csm.groupMapped=" + Constant.IS_GROUP_MAPPED);
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			clientGroupFullReport = new ArrayList<GroupBasedCollectionReportPojo>();
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null) {
					GroupBasedCollectionReportPojo groupBasedCollectionReportPojo = new GroupBasedCollectionReportPojo();
					if (obdata[0] != null) {
						groupBasedCollectionReportPojo.setRecieptNo(obdata[0]
								.toString());
					}
					if (obdata[1] != null) {
						groupBasedCollectionReportPojo.setCardNo(obdata[1]
								.toString());
					}
					if (obdata[2] != null) {
						groupBasedCollectionReportPojo.setEntryDate(obdata[2]
								.toString());
					}
					if (obdata[3] != null) {
						groupBasedCollectionReportPojo
								.setCollectionDate(obdata[3].toString());
					}
					if (obdata[4] != null) {
						groupBasedCollectionReportPojo.setAmmount(obdata[4]
								.toString());
						totalCollection = totalCollection
								+ Integer.parseInt(obdata[4].toString());
					}

					if (obdata[5] != null) {
						groupBasedCollectionReportPojo.setClientName(obdata[5]
								.toString());
					}

					if (obdata[6] != null) {
						groupBasedCollectionReportPojo.setClientMob(obdata[6]
								.toString());
					}

					if (obdata[7] != null) {
						groupBasedCollectionReportPojo
								.setSchemeJoinDate(obdata[7].toString());
					}

					clientGroupFullReport.add(groupBasedCollectionReportPojo);

				}
			}
		}
		return SUCCESS;
	}

	/**
	 * As per BaseModel Comments
	 */
	public List<SchemePojo> getSchemeGridModel() {
		return schemeGridModel;
	}

	public void setSchemeGridModel(List<SchemePojo> schemeGridModel) {
		this.schemeGridModel = schemeGridModel;
	}

	public List<GroupMaster> getGroupGridModel() {
		return groupGridModel;
	}

	public void setGroupGridModel(List<GroupMaster> groupGridModel) {
		this.groupGridModel = groupGridModel;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static Log getLog() {
		return log;
	}

}