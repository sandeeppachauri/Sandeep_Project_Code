package com.ctrl.xsgx.suvidha.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.data.entity.layer.ClientCtrlDao;
import com.ctrl.xsgx.data.entity.layerimpl.ClientCtrlDaoImpl;
import com.ctrl.xsgx.model.ClientCtrlModel;
import com.databean.xsgx.suvidha.commonmaster.Client;
import com.databean.xsgx.suvidha.commonmaster.ClientAgentMapping;
import com.databean.xsgx.suvidha.commonmaster.ClientScheme;
import com.databean.xsgx.suvidha.commonmaster.DailyCollectionDB;
import com.databean.xsgx.suvidha.commonmaster.SchemeActionHistory;
import com.databean.xsgx.suvidha.commonmaster.UploadedDocument;
import com.databean.xsgx.suvidha.commonmaster.User;
import com.opensymphony.xwork2.Action;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.CreateFolderOs;
import com.suvidha.common.DateHelper;
import com.suvidha.common.DateUtil;

@SuppressWarnings("serial")
public class ClientCtrl extends ClientCtrlModel implements Action {

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

	static final Log log = LogFactory.getLog(ClientCtrl.class);

	public String execute() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			setId(getId());
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method execute of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeClientAdd() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			sourceData = clientCtrlDao.getSourceData(eventDao);
			clientNameList = clientCtrlDao.getClientNameList(eventDao);
			areaList = clientCtrlDao.getAreaList(eventDao);

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method beforeClientAdd of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String addClient() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			boolean status = false;
			String storeFilePathPic = null;
			String storeFilePathIDProof = null;
			if (pic != null) {
				storeFilePathPic = new CreateFolderOs()
						.createUserDir(Constant.CLIENT_PIC_UPLOAD_FOLDER)
						+ "//" + getPicFileName();
				File theFile = new File(storeFilePathPic);
				try {
					FileUtils.copyFile(pic, theFile);
				} catch (IOException e) {
					addActionMessage("OOpss there is a error please try again with correct data format!!!!!!!!!!");
				}
			}

			if (idProof != null) {
				storeFilePathIDProof = new CreateFolderOs()
						.createUserDir(Constant.CLIENT_DOC_UPLOAD_FOLDER)
						+ "//" + getIdProofFileName();
				File theFile = new File(storeFilePathIDProof);
				try {
					FileUtils.copyFile(idProof, theFile);
				} catch (IOException e) {
					addActionMessage("OOpss there is a error please try again with correct data format!!!!!!!!!!");
				}
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			Client client = new Client();
			client.setClientAddress(getClientAddress());
			client.setClientEmailId(getClientEmailId());
			client.setClientMob(getClientMob());
			client.setClientName(getClientName());
			client.setClientPhoneno(getClientPhoneno());
			client.setDoa_date(DateUtil.convertDateToUSFormat(getDoa_date()));
			client.setDob_date(DateUtil.convertDateToUSFormat(getDob_date()));
			client.setDoj_date(DateUtil.convertDateToUSFormat(getDoj_date()));
			client.setSourceName(getSourceName());
			client.setUser(userName);
			client.setTime(DateUtil.getCurrentTime());
			client.setDate(DateUtil.getCurrentDateUSFormat());
			client.setAreaName(getAreaName());
			if (getReferBy() != null
					&& getReferBy().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN))
				setReferBy(null);
			client.setReferBy(getReferBy());
			status = eventDao.addDetails(client);

			if (storeFilePathPic != null
					&& !storeFilePathPic
							.equalsIgnoreCase(Constant.EMPTY_STRING)) {
				UploadedDocument up = new UploadedDocument();
				up.setClientId(Integer.toString(client.getId()));
				up.setDocumentPath(storeFilePathPic);
				up.setUser(userName);
				up.setTime(DateUtil.getCurrentTime());
				up.setDate(DateUtil.getCurrentDateUSFormat());
				eventDao.addDetails(up);
			}

			if (storeFilePathIDProof != null
					&& !storeFilePathIDProof
							.equalsIgnoreCase(Constant.EMPTY_STRING)) {
				UploadedDocument up = new UploadedDocument();
				up.setClientId(Integer.toString(client.getId()));
				up.setDocumentPath(storeFilePathIDProof);
				up.setUser(userName);
				up.setTime(DateUtil.getCurrentTime());
				up.setDate(DateUtil.getCurrentDateUSFormat());
				eventDao.addDetails(up);
			}

			if (status)
				addActionMessage("Client added!!!");
			else
				addActionError("There is some error in data!!!");

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method addClient of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings("rawtypes")
	public String viewClient() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			clientGridModel = new ArrayList<Client>();
			StringBuilder query = new StringBuilder("");
			CommonHibernateOper eventDao = new CommonHibernateOper();
			query.append("select count(*) from clientmaster where activeStatus=1");
			List data = eventDao.executeAllSelectQuery(query.toString());
			BigInteger count=new BigInteger("0");
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object obdata = (Object) it.next();
					count=(BigInteger)obdata;
				}
			}
			setRecords(count.intValue());
			int to = (getRows() * getPage());
			int from = to - getRows();
			if (to > getRecords())
				to = getRecords();

			query.delete(0, query.length());
			query.append("select client.id,client.clientaddress,client.clientemailid,client.clientmob,client.clientname,client.clientphoneno,client.date"
					+ ",client.doa_date,client.dob_date,client.doj_date,client.time,client.user,source.sourcename from clientmaster as client"
					+ " left join sourcemaster as source on source.id=client.sourcename");

			query.append(" where client.activeStatus=1");

			if (getSearchField() != null && getSearchString() != null
					&& !getSearchField().equalsIgnoreCase("")
					&& !getSearchString().equalsIgnoreCase("")) {
				query.append(" and ");
				// add search query based on the search operation
				if (getSearchOper().equalsIgnoreCase("eq")) {
					query.append(" client." + getSearchField() + " = '"
							+ getSearchString() + "'");
				} else if (getSearchOper().equalsIgnoreCase("cn")) {
					query.append(" client." + getSearchField() + " like '%"
							+ getSearchString() + "%'");
				} else if (getSearchOper().equalsIgnoreCase("bw")) {
					query.append(" client." + getSearchField() + " like '"
							+ getSearchString() + "%'");
				} else if (getSearchOper().equalsIgnoreCase("ne")) {
					query.append(" client." + getSearchField() + " <> '"
							+ getSearchString() + "'");
				} else if (getSearchOper().equalsIgnoreCase("ew")) {
					query.append(" client." + getSearchField() + " like '%"
							+ getSearchString() + "'");
				}

			}
			if (getSord() != null && !getSord().equalsIgnoreCase("")) {
				if (getSord().equals(Constant.ASC_ORDER) && getSidx() != null
						&& !getSidx().equals("")) {
					query.append(" order by client." + getSidx());
				}
				if (getSord().equals(Constant.DESC_ORDER) && getSidx() != null
						&& !getSidx().equals("")) {
					query.append(" order by client." + getSidx()
							+ Constant.DESC_ORDER);
				}
			}
			query.append(" limit " + from + "," + to);

			data = eventDao.executeAllSelectQuery(query.toString());

			if (data != null) {
				// level1Data
				for (Iterator it = data.iterator(); it.hasNext();) {
					/*
					 * 
					 * client.id,client.clientaddress,client.clientemailid,client
					 * .
					 * clientmob,client.clientname,client.clientphoneno,client.
					 * date ,
					 * client.doa_date,client.dob_date,client.doj_date,client
					 * .time ,client.user,source.sourcename
					 */
					Object[] obdata = (Object[]) it.next();
					Client client = new Client();
					if (obdata[0] != null)
						client.setId((Integer) obdata[0]);
					if (obdata[1] != null)
						client.setClientAddress(obdata[1].toString());
					if (obdata[2] != null)
						client.setClientEmailId(obdata[2].toString());
					if (obdata[3] != null)
						client.setClientMob(obdata[3].toString());
					if (obdata[4] != null)
						client.setClientName(obdata[4].toString());
					if (obdata[5] != null)
						client.setClientPhoneno(obdata[5].toString());
					if (obdata[6] != null)
						client.setDate(obdata[6].toString());
					if (obdata[7] != null)
						client.setDoa_date(DateUtil
								.convertDateToIndianFormat(obdata[7].toString()));
					if (obdata[8] != null)
						client.setDob_date(DateUtil
								.convertDateToIndianFormat(obdata[8].toString()));
					if (obdata[9] != null)
						client.setDoj_date(DateUtil
								.convertDateToIndianFormat(obdata[9].toString()));
					if (obdata[10] != null)
						client.setTime(obdata[10].toString());
					if (obdata[11] != null)
						client.setUser(obdata[11].toString());
					if (obdata[12] != null)
						client.setSourceName(obdata[12].toString());

					clientGridModel.add(client);
				}
			}
			setClientGridModel(clientGridModel);
			setTotal((int) Math
					.ceil((double) getRecords() / (double) getRows()));
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method viewClient of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeMapCardsWithClient() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			clientNameList = clientCtrlDao.getClientNameList(eventDao);
			schemeNameList = clientCtrlDao.getScheme(eventDao);

		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method beforeMapCardsWithClient of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getCardReferringDetails() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			StringBuilder query = new StringBuilder(
					"select groupAble from scheme where id=" + getSchemeId());
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object obdata = (Object) it.next();
					if (obdata != null) {
						if (obdata.toString().equalsIgnoreCase(
								Constant.ELIGIBLE_NOT)) {
							referScheme = false;
							return ERROR;
						} else {
							refereNameList = clientCtrlDao
									.getClientNameList(eventDao);
							referScheme = true;
							return SUCCESS;
						}
					} else {
						referScheme = false;
						return ERROR;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getMappedSchemes() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			referCardNoList = clientCtrlDao.getOpenSchemeWithCardNumber(
					eventDao, getStatus());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String mapCardWithClient() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();

			if (getReferCardNo() == null && referScheme == true) {
				addActionError("Select card number for reference!!!");
				return ERROR;
			}

			boolean status = false;
			if (getSchemeName() != null
					&& !getSchemeName().equalsIgnoreCase(Constant.EMPTY_STRING)
					&& !getSchemeName().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)) {
				ClientScheme clientsc = new ClientScheme();
				clientsc.setSchemeJoinDate(DateUtil
						.convertDateToUSFormat(getSchemeJoinDate()));
				clientsc.setClientId(getClientsForCard());
				clientsc.setUser(userName);
				clientsc.setTime(DateUtil.getCurrentTime());
				clientsc.setDate(DateUtil.getCurrentDateUSFormat());
				clientsc.setSchemeId(getSchemeName());
				clientsc.setCardNo(getCardNo());
				clientsc.setReferCardNo(getReferCardNo());
				status = eventDao.addDetails(clientsc);
			}

			if (status)
				addActionMessage("Card mapped successfully!!!");
			else
				addActionError("There is some error in data!!!");

			/**
			 * Client auto login creation based on card no, default login and
			 * pwd will be card no which is alloting to the client
			 */
			Client clint = (Client) eventDao.findRecordForPk(
					Integer.parseInt(getClientsForCard()), Client.class);

			User user = new User();
			user.setMobNo(clint.getClientMob());
			user.setPassword(getCardNo());
			user.setUser(userName);
			user.setUserId(getCardNo());
			user.setUserName(clint.getClientName());
			user.setUserType(Constant.CLIENT_TYPE_USER);
			eventDao.addDetails(user);
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method mapCardWithClient of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings({ "rawtypes" })
	public String beforeClientMapAgent() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			setId(getId());

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			clientNameList = clientCtrlDao.getClientNameList(eventDao);
			agentNameList = clientCtrlDao.getAgentList(eventDao);

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method beforeClientMapAgent of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings({ "unchecked" })
	public String clientAgentMapping() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			boolean status = false;
			CommonHibernateOper eventDao = new CommonHibernateOper();
			List<ClientAgentMapping> tempMappingCheck = eventDao
					.getDropdownvalue("clientId", getClientName(),
							ClientAgentMapping.class);
			if (tempMappingCheck != null && tempMappingCheck.size() > 0) {
				for (ClientAgentMapping ah : tempMappingCheck) {
					ah.setAgentId(getAgentName());
					status = eventDao.UpdateDetails(ah);
				}
			} else {
				ClientAgentMapping client = new ClientAgentMapping();
				client.setClientId(getClientName());
				client.setAgentId(getAgentName());
				client.setUser(userName);
				client.setTime(DateUtil.getCurrentTime());
				client.setDate(DateUtil.getCurrentDateUSFormat());
				status = eventDao.addDetails(client);
			}

			if (status)
				addActionMessage("Client mapped with agent successfully!!!");
			else
				addActionError("There is some error in data!!!");
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method clientAgentMapping of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeClientSurrender() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			setSchemeTypeRecvd(getSchemeTypeRecvd());
			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			clientNameList = clientCtrlDao.getClientNameList(eventDao);

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method beforeClientSurrender of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings({ "rawtypes" })
	public String clientMapSchemes() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			setId(getId());
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder("");
			schemeNameList = new LinkedHashMap<Integer, String>();
			query = new StringBuilder(
					"select cscheme.id,schem.schemeName  from scheme as schem inner join clientscheme as cscheme on cscheme.schemeId=schem.id  "
							+ "where cscheme.clientId="
							+ getId()
							+ " and cscheme.schemeStatus="
							+ getSchemeTypeRecvd()
							+ " order by schem.schemeName");
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
					+ "Problem in method getClientMapSchemes of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings({ "rawtypes" })
	public String clientSchemeStatus() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			setSchemeTypeRecvd(getSchemeTypeRecvd());
			setId(getId());
			int totalCollectionRecieve = 0;
			String amountSubmitDaily = null;
			String periodOfScheme = null;
			String totalAmount = null;
			String clientCardNo = null;
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder("");
			schemeNameList = new LinkedHashMap<Integer, String>();
			String tempSchemeId = null;
			query.append("select schemeId from clientscheme where id="
					+ getId());
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object obdata = (Object) it.next();
					if (obdata != null)
						tempSchemeId = obdata.toString();
				}
			}

			// System.out.println("tempSchemeId  "+tempSchemeId);
			query.delete(0, query.length());
			query.append("select withdrawable,frequency,amount,minPeriod,totalAmount from schemetype where schemeId="
					+ tempSchemeId);
			data = eventDao.executeAllSelectQuery(query.toString());
			String withDrawStats = null;
			String frequnecy = null;
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata[0] != null)
						withDrawStats = obdata[0].toString();
					if (obdata[1] != null)
						frequnecy = obdata[1].toString();
					if (obdata[2] != null)
						amountSubmitDaily = obdata[2].toString();
					if (obdata[3] != null)
						periodOfScheme = obdata[3].toString();
					if (obdata[4] != null)
						totalAmount = obdata[4].toString();
				}
			}

			// make it no
			if (withDrawStats != null && withDrawStats.equalsIgnoreCase("yes")) {
				// eligble for withdraw
				// System.out.println("getId()  "+getId());
				query.delete(0, query.length());
				String date = null;
				query.append("select schemeJoinDate,cardno,schemeStatus from clientscheme where id="
						+ getId());
				// System.out.println("query.toString()  "+query.toString());
				List dataTemp = eventDao
						.executeAllSelectQuery(query.toString());
				if (dataTemp != null) {
					for (Iterator it1 = dataTemp.iterator(); it1.hasNext();) {
						Object[] obdata = (Object[]) it1.next();
						if (obdata[0] != null)
							date = obdata[0].toString();
						joingDate = DateUtil.convertDateToIndianFormat(date);
						if (obdata[1] != null)
							clientCardNo = obdata[1].toString();
						if (obdata[2] != null)
							schemeStatus = obdata[2].toString();
						if (schemeStatus
								.equalsIgnoreCase(Constant.CLIENT_SCHEME_ACTIVE)) {
							schemeStatus = Constant.ACTIVATE_SCHEME;
						} else if (schemeStatus
								.equalsIgnoreCase(Constant.CLIENT_SCHEME_COMPLETED_WITHOUTPAY)
								|| schemeStatus
										.equalsIgnoreCase(Constant.CLIENT_SCHEME_COMPLETED_WITHPAY)) {
							schemeStatus = Constant.COMPLETED_SCHEME;
						} else if (schemeStatus
								.equalsIgnoreCase(Constant.CLIENT_SCHEME_SURRENDERED_WITHOUTPAY)
								|| schemeStatus
										.equalsIgnoreCase(Constant.CLIENT_SCHEME_SURRENDERED_WITHPAY)) {
							schemeStatus = Constant.SURRENDERED_SCHEME;
						} else if (schemeStatus
								.equalsIgnoreCase(Constant.CLIENT_SCHEME_LUCKDRAW_WITHOUTPAY)
								|| schemeStatus
										.equalsIgnoreCase(Constant.CLIENT_SCHEME_LUCKDRAW_WITHPAY)) {
							schemeStatus = Constant.LUCKYDRAW_SCHEME;
						}
					}
				}
				long diff = DateHelper
						.getNoOfDaysWeekMonthQuaterHalfYearFromCurrentDate(
								date, frequnecy);
				query.delete(0, query.length());
				query.append("select widraw from schemewithdraw where schemeId="
						+ tempSchemeId
						+ " and minPeriod<="
						+ diff
						+ " and maxPeriod>=" + diff);
				dataTemp = eventDao.executeAllSelectQuery(query.toString());
				if (dataTemp != null) {
					for (Iterator it1 = dataTemp.iterator(); it1.hasNext();) {
						Object obdata = (Object) it1.next();
						if (obdata != null)
							status = obdata.toString();
					}
				}

				clientWiseDailyCollectionHistory = new ArrayList<DailyCollectionDB>();
				// if scheme is coming in criteria of surrender
				if (status != null
						&& status
								.equalsIgnoreCase(Constant.SCHEME_SURRENDER_CRITERIA)) {
					query.delete(0, query.length());
					query.append("select ammount,bankCash,chequeNo,accountType,collectionDate from dailycollectiondb where cardNo='"
							+ clientCardNo + "'");
					dataTemp = eventDao.executeAllSelectQuery(query.toString());
					if (dataTemp != null) {
						for (Iterator it1 = dataTemp.iterator(); it1.hasNext();) {
							Object[] obdata = (Object[]) it1.next();
							DailyCollectionDB dcb = new DailyCollectionDB();
							dcb.setAmmount(obdata[0].toString());
							if (obdata[1] != null)
								dcb.setBankCash(obdata[1].toString());
							else
								dcb.setBankCash(Constant.SCHEME_DEPOSITE_TYPE);
							dcb.setChequeNo(obdata[2].toString());
							dcb.setAccountType(obdata[3].toString());
							dcb.setEntryDate(DateUtil
									.convertDateToIndianFormat(obdata[4]
											.toString()));
							clientWiseDailyCollectionHistory.add(dcb);
							totalCollectionRecieve = totalCollectionRecieve
									+ Integer.parseInt(obdata[0].toString());
						}
					}
					this.totalCollectionRecieve = totalCollectionRecieve;
					this.amountSubmitDaily = amountSubmitDaily;
					this.totalAmount = totalAmount;
					this.periodOfScheme = periodOfScheme;
					this.frequnecy = frequnecy;
				}
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method getClientSchemeStatus of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String clientSchemeSurrender() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			SchemeActionHistory scheme = new SchemeActionHistory();
			scheme.setActionDesc(getSurrenderRsn());
			scheme.setSchemeAction(Constant.SURRENDERING_SCHEME_ACTION_STATUS);
			scheme.setSchemeId(Integer.toString(getId()));
			scheme.setDate(DateUtil.getCurrentDateUSFormat());
			scheme.setTime(DateUtil.getCurrentTime());
			scheme.setUser(userName);
			eventDao.addDetails(scheme);
			ClientScheme cscheme = (ClientScheme) eventDao.findRecordForPk(
					getId(), ClientScheme.class);
			cscheme.setSchemeStatus(Constant.CLIENT_SCHEME_SURRENDERED_WITHOUTPAY);
			boolean status = eventDao.UpdateDetails(cscheme);
			if (status)
				addActionMessage("Scheme Surrended Successfully!!!");
			else
				addActionError("There is some data problem");
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientSchemeSurrender of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String clientSchemeReopen() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			SchemeActionHistory scheme = new SchemeActionHistory();
			scheme.setActionDesc(getSurrenderRsn());
			scheme.setSchemeAction(Constant.REOPENING_SCHEME_ACTION_STATUS);
			scheme.setSchemeId(Integer.toString(getId()));
			scheme.setDate(DateUtil.getCurrentDateUSFormat());
			scheme.setTime(DateUtil.getCurrentTime());
			scheme.setUser(userName);
			eventDao.addDetails(scheme);
			ClientScheme cscheme = (ClientScheme) eventDao.findRecordForPk(
					getId(), ClientScheme.class);
			cscheme.setSchemeStatus(Constant.CLIENT_SCHEME_ACTIVE);
			boolean status = eventDao.UpdateDetails(cscheme);
			if (status)
				addActionMessage("Scheme Re-opened Successfully!!!");
			else
				addActionError("There is some data problem");
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientSchemeReopen of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String clientBasicDetailsView() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			Client client = (Client) eventDao.findRecordForPk(getId(),
					Client.class);
			setClientName(client.getClientName());
			setClientMob(client.getClientMob());
			setClientPhoneno(client.getClientPhoneno());
			setClientEmailId(client.getClientEmailId());
			setClientAddress(client.getClientAddress());
			setDoj_date(client.getDoj_date());
			setDob_date(client.getDob_date());
			setDoa_date(client.getDoa_date());
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientBasicDetailsView of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeclientSchemeSummirizeReport() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			setId(getId());
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method beforeclientSchemeSummirizeReport of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings({ "rawtypes" })
	public String clientSchemeSummirizeReport() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			clientSummerizeReport = new ArrayList<ClientSchemeSummerirzeReportPojo>();
			List<ClientSchemeSummerirzeReportPojo> tempclientSummerizeReport = new ArrayList<ClientSchemeSummerirzeReportPojo>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder(
					"select clientt.clientname,clientcadr.cardno,sum(daily.ammount),count(daily.ammount),clientcadr.date,clientcadr.schemeStatus "
							+ "from clientmaster as clientt left join clientscheme as clientcadr on clientt.id=clientcadr.clientid "
							+ "left join dailycollectiondb as daily on daily.cardNo=clientcadr.cardno "
							+ "where clientt.id="
							+ getId()
							+ " group by clientcadr.cardno");
			// System.out.println(query.toString());
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null) {
						ClientSchemeSummerirzeReportPojo csm = new ClientSchemeSummerirzeReportPojo();
						if (obdata[0] != null)
							csm.setClientName(obdata[0].toString());
						if (obdata[1] != null)
							csm.setCardNo(obdata[1].toString());
						if (obdata[2] != null
								&& !obdata[2].toString().equalsIgnoreCase(
										Constant.NULL_STRING))
							csm.setTotalCollectionTillNow(Double
									.parseDouble(obdata[2].toString()));
						else
							csm.setTotalCollectionTillNow(0.0);

						if (obdata[3] != null)
							csm.setTotalCollectionCounter(obdata[3].toString());
						if (obdata[4] != null)
							csm.setSchemePurchaseDate(obdata[4].toString());

						if (obdata[5] != null) {
							if (obdata[0] != null
									&& obdata[5] != null
									&& obdata[5].toString().equalsIgnoreCase(
											Constant.CLIENT_SCHEME_ACTIVE)) {
								csm.setSchemeStatus(Constant.ACTIVATE_SCHEME);
							} else if (obdata[0] != null
									&& obdata[5] != null
									&& obdata[5]
											.toString()
											.equalsIgnoreCase(
													Constant.CLIENT_SCHEME_COMPLETED_WITHOUTPAY)
									|| obdata[5]
											.toString()
											.equalsIgnoreCase(
													Constant.CLIENT_SCHEME_COMPLETED_WITHPAY)) {
								csm.setSchemeStatus(Constant.COMPLETED_SCHEME);
							} else if (obdata[0] != null
									&& obdata[5] != null
									&& obdata[5]
											.toString()
											.equalsIgnoreCase(
													Constant.CLIENT_SCHEME_SURRENDERED_WITHOUTPAY)
									|| obdata[5]
											.toString()
											.equalsIgnoreCase(
													Constant.CLIENT_SCHEME_SURRENDERED_WITHPAY)) {
								csm.setSchemeStatus(Constant.SURRENDERED_SCHEME);
							} else if (obdata[0] != null
									&& obdata[5] != null
									&& obdata[5]
											.toString()
											.equalsIgnoreCase(
													Constant.CLIENT_SCHEME_LUCKDRAW_WITHOUTPAY)) {
								csm.setSchemeStatus(Constant.LUCKYDRAW_SCHEME);
							}
						} else {
							csm.setSchemeStatus("No match found");
						}
						tempclientSummerizeReport.add(csm);
					}
				}
			}
			query.delete(0, query.length());
			query.append("select schem.schemeName,schemetype.amount,schemetype.contri,schemetype.frequency,schemetype.maturityAmount,"
					+ "schemetype.minPeriod,"
					+ "schemetype.totalAmount from scheme as schem left join schemetype as schemetype on schem.id=schemetype.schemeId "
					+ "left join clientscheme as cscheme on cscheme.schemeId=schem.id where cscheme.clientId="
					+ getId());
			data = eventDao.executeAllSelectQuery(query.toString());

			if (data != null) {
				int i = 0;
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null) {
						ClientSchemeSummerirzeReportPojo csm = null;
						if (tempclientSummerizeReport.size() == 1) {
							csm = tempclientSummerizeReport.get(0);
						} else {
							csm = tempclientSummerizeReport.get(i);
						}
						if (obdata[0] != null)
							csm.setSchemeName(obdata[0].toString());
						if (obdata[1] != null)
							csm.setSchemeAmmount(obdata[1].toString());
						if (obdata[2] != null)
							csm.setSchemeOurContree(obdata[2].toString());
						if (obdata[3] != null)
							csm.setSchemeFrequency(obdata[3].toString());
						if (obdata[4] != null)
							csm.setSchemeMaturtyAmmount(obdata[4].toString());
						if (obdata[5] != null)
							csm.setSchemePeriod(obdata[5].toString());
						if (obdata[6] != null)
							csm.setSchemeTotalAmmount(obdata[6].toString());
						clientSummerizeReport.add(csm);
					}
					i++;
				}
			}
			int totalCollectionTemp = 0;
			int schemeAmmountTemp = 0;
			int schemeMaturtyAmmountTemp = 0;

			if (clientSummerizeReport != null) {
				for (ClientSchemeSummerirzeReportPojo cs : clientSummerizeReport) {
					totalCollectionTemp = totalCollectionTemp
							+ (int) cs.getTotalCollectionTillNow();
					schemeAmmountTemp = schemeAmmountTemp
							+ Integer.parseInt(cs.getSchemeAmmount());
					schemeMaturtyAmmountTemp = schemeMaturtyAmmountTemp
							+ Integer.parseInt(cs.getSchemeMaturtyAmmount());
				}
			}

			userdata.put("cardNo", "Total Collection:");
			userdata.put("totalCollectionTillNow", totalCollectionTemp);
			userdata.put("schemeName", "Total:");
			userdata.put("schemeAmmount", schemeAmmountTemp);
			userdata.put("schemeFrequency", "Total Maturity:");
			userdata.put("schemeMaturtyAmmount", schemeMaturtyAmmountTemp);
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientSchemeSummirizeReport of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeclientSchemeWiseReport() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			setId(getId());
			setModuleFalg(getModuleFalg());
			if (getModuleFalg() != null
					&& getModuleFalg().equalsIgnoreCase(
							Constant.CLIENT_SCHEME_ACTIVE)) {
				gridid = "griddd1";
				headingName = "Client Active Scheme Wise Collection Report";
			} else if (getModuleFalg() != null
					&& getModuleFalg().equalsIgnoreCase(
							Constant.CLIENT_SCHEME_COMPLETED)) {
				gridid = "griddd2";
				headingName = "Client Completed Scheme Wise Collection Report";
			} else if (getModuleFalg() != null
					&& getModuleFalg().equalsIgnoreCase(
							Constant.CLIENT_SCHEME_SURRENDERED)) {
				gridid = "griddd3";
				headingName = "Client Surrended Scheme Wise Collection Report";
			} else if (getModuleFalg() != null
					&& getModuleFalg().equalsIgnoreCase(
							Constant.CLIENT_SCHEME_ALL_COLLECTION)) {
				gridid = "griddd4";
				headingName = "Client Scheme Wise Collection Report";
			}
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method beforeclientSchemeWiseReport of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings({ "rawtypes" })
	public String clientSchemesReport() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			setModuleFalg(getModuleFalg());
			CommonHibernateOper eventDao = new CommonHibernateOper();
			setRecords(eventDao.getRecordStatus(DailyCollectionDB.class));
			int to = (getRows() * getPage());
			int from = to - getRows();
			if (to > getRecords())
				to = getRecords();
			clientSummerizeReport = new ArrayList<ClientSchemeSummerirzeReportPojo>();
			StringBuilder query = new StringBuilder(
					"select distinct cscheme.cardNo, db.collectionDate,db.ammount,cmaster.clientname,schtype.amount,"
							+ "schtype.contri,schtype.frequency,schtype.maturityAmount,schtype.totalAmount,schm.schemeName,schtype.schemeId,schtype.incremntal "
							+ " from clientmaster as cmaster "
							+ " inner join  clientscheme as cscheme on cmaster.id=cscheme.clientId "
							+ " left join dailycollectiondb  as db on db.cardNo=cscheme.cardNo "
							+ " left join schemetype as schtype on schtype.schemeId=cscheme.schemeId "
							+ " left join scheme as schm on schtype.schemeId=schm.id where cmaster.id="
							+ getId() + "");
			if (getModuleFalg() != null
					&& getModuleFalg() != null
					&& getModuleFalg().equalsIgnoreCase(
							Constant.CLIENT_SCHEME_ACTIVE)) {
				query.append(" and cscheme.schemeStatus='"
						+ Constant.CLIENT_SCHEME_ACTIVE + "'");// active
			} else if (getModuleFalg() != null
					&& getModuleFalg() != null
					&& getModuleFalg().equalsIgnoreCase(
							Constant.CLIENT_SCHEME_COMPLETED)) {

				query.append(" and cscheme.schemeStatus in('"
						+ Constant.CLIENT_SCHEME_COMPLETED_WITHOUTPAY + "','"
						+ Constant.CLIENT_SCHEME_COMPLETED_WITHPAY + "','"
						+ Constant.CLIENT_SCHEME_LUCKDRAW_WITHOUTPAY + "','"
						+ Constant.CLIENT_SCHEME_LUCKDRAW_WITHPAY + "')");// completed

			} else if (getModuleFalg() != null
					&& getModuleFalg() != null
					&& getModuleFalg().equalsIgnoreCase(
							Constant.CLIENT_SCHEME_SURRENDERED)) {

				query.append(" and cscheme.schemeStatus in('"
						+ Constant.CLIENT_SCHEME_SURRENDERED_WITHOUTPAY + "','"
						+ Constant.CLIENT_SCHEME_SURRENDERED_WITHPAY + "')");// surrended

			}
			query.append(" order by cscheme.cardNo " + Constant.DESC_ORDER);
			query.append(" limit " + from + "," + to);
			// System.out.println("query.toString()  "+query.toString());
			List data = eventDao.executeAllSelectQuery(query.toString());
			double totalCollectionOfAllScheme = 0;
			if (data != null) {
				boolean status = true;
				String tempCardNo = null;
				int i = 0;
				String inctlmentData = null;
				String tempResul[] = null;
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					ClientSchemeSummerirzeReportPojo csm = new ClientSchemeSummerirzeReportPojo();
					csm.setCardNo(obdata[0].toString());
					if (status
							&& obdata[11] != null
							&& obdata[10] != null
							&& obdata[11].toString().equalsIgnoreCase(
									Constant.IS_INCREMENTAL_SCHEME)) {
						i = 0;
						tempCardNo = obdata[0].toString();
						status = false;
						String userSchemeId = obdata[10].toString();
						tempCardNo = obdata[0].toString();
						query.delete(0, query.length());
						query.append("select value from incrmtnlscheme where schemeId="
								+ userSchemeId);
						List dataTemp = eventDao.executeAllSelectQuery(query
								.toString());
						if (dataTemp != null) {
							for (Iterator itTemp = dataTemp.iterator(); itTemp
									.hasNext();) {
								Object obdataTemp = (Object) itTemp.next();
								inctlmentData = obdataTemp.toString();
								tempResul = inctlmentData.split(", ");
							}
						}
					}
					if (tempCardNo != null
							&& !tempCardNo.equalsIgnoreCase(obdata[0]
									.toString())
							&& obdata[10] != null
							&& obdata[11] != null
							&& obdata[11].toString().equalsIgnoreCase(
									Constant.IS_INCREMENTAL_SCHEME)) {
						String userSchemeId = obdata[10].toString();
						tempCardNo = obdata[0].toString();
						query.delete(0, query.length());
						query.append("select value from incrmtnlscheme where schemeId="
								+ userSchemeId);
						List dataTemp = eventDao.executeAllSelectQuery(query
								.toString());
						if (dataTemp != null) {
							for (Iterator itTemp = dataTemp.iterator(); itTemp
									.hasNext();) {
								Object obdataTemp = (Object) itTemp.next();
								inctlmentData = obdataTemp.toString();
								tempResul = inctlmentData.split(", ");
							}
						}

					}
					if (obdata[1] != null
							&& !obdata[1].toString().equalsIgnoreCase(
									Constant.NULL_STRING))
						csm.setCollectionDate(DateUtil
								.convertDateToIndianFormat(obdata[1].toString()));
					else
						csm.setCollectionDate("No Data");

					if (obdata[2] != null
							&& !obdata[2].toString().equalsIgnoreCase(
									Constant.NULL_STRING))
						csm.setTotalCollectionTillNow(Double
								.parseDouble(obdata[2].toString()));
					else
						csm.setTotalCollectionTillNow(0.0);
					if (obdata[3] != null
							&& !obdata[3].toString().equalsIgnoreCase(
									Constant.NULL_STRING))
						csm.setClientName(obdata[3].toString());

					if (obdata[11] != null
							&& !obdata[11].toString().equalsIgnoreCase(
									Constant.NULL_STRING)
							&& obdata[11].toString().equalsIgnoreCase(
									Constant.IS_INCREMENTAL_SCHEME)) {
						csm.setTotalCollectionCounter(tempResul[i]);
						i++;
					} else {
						// for scheme collection rs
						if (obdata[4] != null
								&& !obdata[4].toString().equalsIgnoreCase(
										Constant.NULL_STRING))
							csm.setTotalCollectionCounter(obdata[4].toString());
					}

					if (obdata[5] != null
							&& !obdata[5].toString().equalsIgnoreCase(
									Constant.NULL_STRING))
						csm.setSchemeOurContree(obdata[5].toString());
					if (obdata[6] != null
							&& !obdata[6].toString().equalsIgnoreCase(
									Constant.NULL_STRING))
						csm.setSchemeFrequency(obdata[6].toString());
					if (obdata[7] != null
							&& !obdata[7].toString().equalsIgnoreCase(
									Constant.NULL_STRING))
						csm.setSchemeMaturtyAmmount(obdata[7].toString());
					if (obdata[8] != null
							&& !obdata[8].toString().equalsIgnoreCase(
									Constant.NULL_STRING))
						csm.setSchemeTotalAmmount(obdata[8].toString());
					if (obdata[9] != null
							&& !obdata[9].toString().equalsIgnoreCase(
									Constant.NULL_STRING))
						csm.setSchemeName(obdata[9].toString());
					totalCollectionOfAllScheme = totalCollectionOfAllScheme
							+ (double) csm.getTotalCollectionTillNow();
					clientSummerizeReport.add(csm);
				}
			}
			userdata.put("totalCollectionCounter", "Total Collection:");
			userdata.put("totalCollectionTillNow", totalCollectionOfAllScheme);

			setTotal((int) Math
					.ceil((double) getRecords() / (double) getRows()));

		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientSchemeWiseReport of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@SuppressWarnings({ "rawtypes" })
	public String clientDocuments() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			searchData = new HashMap<String, String>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder(
					"select documentPath from uploadeddocument where clientId="
							+ getId());
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object obdata = (Object) it.next();
					if (obdata != null) {
						searchData.put(obdata.toString(), obdata.toString());
					}
				}
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method clientDocuments of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String download() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			fileName = getPath();
			File file = new File(fileName);
			if (file.exists()) {
				fileInputStream = new FileInputStream(file);
				return Constant.FILE_DOWNLODED_RESULT;
			} else {
				addActionError("File dose not exist");
				return ERROR;
			}
		} catch (Exception e) {
			return ERROR;
		}

	}

	public String editClient() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			if (oper.equalsIgnoreCase(Constant.EDIT_GRID_DATA)) {
				CommonHibernateOper eventDao = new CommonHibernateOper();
				Client pcmBeanId = (Client) eventDao.findRecordForPk(getId(),
						Client.class);
				pcmBeanId.setClientName(getClientName());
				pcmBeanId.setClientMob(getClientMob());
				pcmBeanId.setClientPhoneno(getClientPhoneno());
				pcmBeanId.setClientEmailId(getClientEmailId());
				pcmBeanId.setClientAddress(getClientAddress());
				eventDao.UpdateDetails(pcmBeanId);
			} else if (oper.equalsIgnoreCase(Constant.DELETE_GRID_DATA)) {
				CommonHibernateOper eventDao = new CommonHibernateOper();
				Client pcmBeanId = (Client) eventDao.findRecordForPk(getId(),
						Client.class);
				pcmBeanId.setActiveStatus(0);
				eventDao.UpdateDetails(pcmBeanId);
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
	 * As per BaseModel comments
	 * 
	 * @return
	 */
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

	public List<DailyCollectionDB> getClientWiseDailyCollectionHistory() {
		return clientWiseDailyCollectionHistory;
	}

	public void setClientWiseDailyCollectionHistory(
			List<DailyCollectionDB> clientWiseDailyCollectionHistory) {
		this.clientWiseDailyCollectionHistory = clientWiseDailyCollectionHistory;
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

	public static Log getLog() {
		return log;
	}

}
