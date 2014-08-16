package com.ctrl.xsgx.suvidha.dailycollection;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.data.entity.layer.ClientCtrlDao;
import com.ctrl.xsgx.data.entity.layerimpl.ClientCtrlDaoImpl;
import com.ctrl.xsgx.model.SummerizeReportModel;
import com.ctrl.xsgx.suvidha.client.ClientReportPojo;
import com.ctrl.xsgx.suvidha.employee.EmployeeCtrl;
import com.databean.xsgx.suvidha.commonmaster.Employee;
import com.databean.xsgx.suvidha.scheme.Scheme;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateUtil;

@SuppressWarnings("rawtypes")
public class SummerizeReport extends SummerizeReportModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Log log = LogFactory.getLog(EmployeeCtrl.class);

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

	public String beforeCollectionSummerizeReport() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			agentNameList = new HashMap<Integer, String>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			List<Employee> agents = (List<Employee>) eventDao.getDropdownvalue(
					"empName", Employee.class);
			if (agents != null) {
				for (Employee sd : agents) {
					agentNameList.put(sd.getId(), sd.getEmpName());
				}
			}

			schemeNameList = new LinkedHashMap<Integer, String>();

			List<Scheme> scheme = (List<Scheme>) eventDao.getDropdownvalue(
					"schemeName", Scheme.class);
			if (scheme != null) {
				for (Scheme sd : scheme) {
					schemeNameList.put(sd.getId(), sd.getSchemeName());
				}
			}

		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method beforeCollectionSummerizeReport of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String collectionReportSearch() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			summerizeData = new ArrayList<SummerizePojo>();
			summerizeDataOfNewMembers = new ArrayList<SummerizePojo>();
			setDateTo(getDateTo());
			StringBuilder query = new StringBuilder(
					"select distinct amaster.id,amaster.areaname,emp.empname from clientscheme as cscheme  "
							+ "left join clientmaster as cmaster  on cscheme.clientId=cmaster.id left join clientagentmapping as cmap on cmaster.id=cmap.clientId "
							+ "left join emploee as emp on cmap.agentId=emp.id left join areaemployeemapping as aempmap on emp.id=aempmap.empID "
							+ "left join areamaster as amaster on aempmap.aeaID=amaster.id where cscheme.schemeId="
							+ getScheme()
							+ " and cscheme.schemeStatus='"
							+ Constant.CLIENT_SCHEME_ACTIVE
							+ "' order by emp.empname");

			List data = eventDao.executeAllSelectQuery(query.toString());

			if (data != null) {
				String empName = null;
				for (Iterator it = data.iterator(); it.hasNext();) {

					Object[] obdata = (Object[]) it.next();
					if (obdata != null) {
						int areaId = 0;
						SummerizePojo smp = new SummerizePojo();
						if (obdata[1] != null)
							smp.setAreaName(obdata[1].toString());
						if (obdata[0] != null)
							areaId = (Integer) obdata[0];
						if (obdata[2] != null)
							empName = obdata[2].toString();
						smp.setEmpName(empName);

						if (areaId != 0) {
							query.delete(0, query.length());
							query.append("select count(*),sum(sctype.amount) from clientmaster  as cmaster inner join "
									+ "clientscheme as cscheme on cscheme.clientId=cmaster.id "
									+ "inner join schemetype as sctype on sctype.schemeId=cscheme.schemeId "
									+ "where cscheme.schemeId="
									+ getScheme()
									+ " and cscheme.schemeStatus='"
									+ Constant.CLIENT_SCHEME_ACTIVE
									+ "' and cmaster.areaName='"
									+ (Integer) obdata[0] + "'");
							List datatemp = eventDao
									.executeAllSelectQuery(query.toString());
							if (datatemp != null) {
								for (Iterator ittemp = datatemp.iterator(); ittemp
										.hasNext();) {
									Object[] obdataTemp = (Object[]) ittemp
											.next();
									smp.setTotalMembersInArea(obdataTemp[0]
											.toString());
									if (obdataTemp[1] != null)
										smp.setTotalCollectionAmmountFromArea(obdataTemp[1]
												.toString());
									else
										smp.setTotalCollectionAmmountFromArea("0");
								}
							}
							query.delete(0, query.length());
							query.append("select count(*),sum(dar.ammount) from dailycollectiondb as dar where dar.cardNo "
									+ "in(select cschem.cardno from clientscheme as cschem inner join clientmaster as cmaster on cschem.clientId=cmaster.id "
									+ "where cschem.schemeId='"
									+ getScheme()
									+ "' and cmaster.areaName='"
									+ (Integer) obdata[0]
									+ "') and dar.collectionDate='"
									+ DateUtil
											.convertDateToUSFormat(getDateTo())
									+ "'");
							datatemp = eventDao.executeAllSelectQuery(query
									.toString());
							if (datatemp != null) {
								for (Iterator ittemp = datatemp.iterator(); ittemp
										.hasNext();) {
									Object[] obdataTemp = (Object[]) ittemp
											.next();
									smp.setPaidMembersToday(obdataTemp[0]
											.toString());
									if (obdataTemp[1] != null)
										smp.setAmountRecvdToday(obdataTemp[1]
												.toString());
									else
										smp.setAmountRecvdToday("0");
								}
							}
						}
						try {
							int temp = Integer.parseInt(smp
									.getPaidMembersToday())
									* 100
									/ Integer.parseInt(smp
											.getTotalMembersInArea());
							smp.setInPer(Integer.toString(temp));
						} catch (Exception e) {

						}
						summerizeData.add(smp);
					}

				}
			}

			query.delete(0, query.length());
			query.append("select count(cscheme.id),sum(cschtype.amount) from schemetype as cschtype,clientscheme as cscheme "
					+ "where cscheme.schemeId=cschtype.schemeId and cscheme.schemeJoinDate<='"
					+ DateUtil.getPerviousDateAfter(getDateTo(), 1) + "'");
			List datatemp = eventDao.executeAllSelectQuery(query.toString());
			if (datatemp != null) {
				for (Iterator ittemp = datatemp.iterator(); ittemp.hasNext();) {
					Object[] obdataTemp = (Object[]) ittemp.next();
					totalAccountTillYesterday = obdataTemp[0].toString();
					if (obdataTemp[1] != null)
						totalAccountCollectionTillYesterday = obdataTemp[1]
								.toString();
				}
			}

			query.delete(0, query.length());
			query.append("select count(cscheme.id),sum(cschtype.amount) from schemetype as cschtype,clientscheme as cscheme where"
					+ " cscheme.schemeId=cschtype.schemeId "
					+ "and cscheme.schemeJoinDate='"
					+ DateUtil.convertDateToUSFormat(getDateTo()) + "'");
			datatemp = eventDao.executeAllSelectQuery(query.toString());
			if (datatemp != null) {
				for (Iterator ittemp = datatemp.iterator(); ittemp.hasNext();) {
					Object[] obdataTemp = (Object[]) ittemp.next();
					newMembersToday = obdataTemp[0].toString();
					if (obdataTemp[1] != null)
						newMemberCollection = obdataTemp[1].toString();
				}
			}

			query.delete(0, query.length());
			query.append("select count(cscheme.id),sum(cschtype.amount) from schemetype as cschtype,clientscheme as cscheme where "
					+ "cscheme.schemeId=cschtype.schemeId and not cscheme.schemeStatus='"
					+ Constant.CLIENT_SCHEME_ACTIVE
					+ "' and cscheme.schemeJoinDate<='"
					+ DateUtil.convertDateToUSFormat(getDateTo()) + "'");
			datatemp = eventDao.executeAllSelectQuery(query.toString());
			if (datatemp != null) {
				for (Iterator ittemp = datatemp.iterator(); ittemp.hasNext();) {
					Object[] obdataTemp = (Object[]) ittemp.next();
					deadMembersToday = obdataTemp[0].toString();
					if (obdataTemp[1] != null)
						deadMemberCollection = obdataTemp[1].toString();
				}
			}

			query.delete(0, query.length());
			query.append("select count(cscheme.id),sum(cschtype.amount) from schemetype as cschtype,clientscheme as cscheme where "
					+ "cscheme.schemeId=cschtype.schemeId and cscheme.schemeStatus='"
					+ Constant.CLIENT_SCHEME_ACTIVE
					+ "' and cscheme.schemeJoinDate<='"
					+ DateUtil.convertDateToUSFormat(getDateTo()) + "'");
			datatemp = eventDao.executeAllSelectQuery(query.toString());
			if (datatemp != null) {
				for (Iterator ittemp = datatemp.iterator(); ittemp.hasNext();) {
					Object[] obdataTemp = (Object[]) ittemp.next();
					activeMembersToday = obdataTemp[0].toString();
					if (obdataTemp[1] != null)
						activeMemberCollection = obdataTemp[1].toString();
				}
			}

			query.delete(0, query.length());
			query.append("select count(cscheme.id),sum(cschtype.amount) from schemetype as cschtype,clientscheme as cscheme where cscheme.schemeId=cschtype.schemeId"
					+ " and cscheme.schemeJoinDate<='"
					+ DateUtil.convertDateToUSFormat(getDateTo()) + "'");
			datatemp = eventDao.executeAllSelectQuery(query.toString());
			if (datatemp != null) {
				for (Iterator ittemp = datatemp.iterator(); ittemp.hasNext();) {
					Object[] obdataTemp = (Object[]) ittemp.next();
					totalAccountTillToday = obdataTemp[0].toString();
					if (obdataTemp[1] != null)
						totalAccountCollectionTillToday = obdataTemp[1]
								.toString();
				}
			}

			query.delete(0, query.length());
			query.append("select count(cmaster.id),sum(cschtype.amount),amaster.areaname from schemetype as cschtype,clientscheme as cscheme "
					+ "inner join clientmaster as cmaster on cscheme.clientId=cmaster.id inner join areamaster as amaster on "
					+ "cmaster.areaName=amaster.id where cscheme.schemeId=cschtype.schemeId and cscheme.schemeJoinDate='"
					+ DateUtil.convertDateToUSFormat(getDateTo())
					+ "' "
					+ "group by amaster.areaname");
			datatemp = eventDao.executeAllSelectQuery(query.toString());
			if (datatemp != null) {
				for (Iterator ittemp = datatemp.iterator(); ittemp.hasNext();) {
					SummerizePojo smp = new SummerizePojo();
					Object[] obdataTemp = (Object[]) ittemp.next();
					BigInteger temp = new BigInteger("3");
					temp = (BigInteger) obdataTemp[0];
					smp.setTotalMembersInArea(Integer.toString(temp.intValue()));
					if (obdataTemp[1] != null)
						smp.setTotalAmmout(obdataTemp[1].toString());
					smp.setAreaName(obdataTemp[2].toString());
					summerizeDataOfNewMembers.add(smp);
				}
			}

			query.delete(0, query.length());
			query.append("select sum(ammount) from dailycollectiondb where collectionDate <='"
					+ DateUtil.getPerviousDateAfter(getDateTo(), 1) + "'");
			datatemp = eventDao.executeAllSelectQuery(query.toString());
			if (datatemp != null) {
				for (Iterator ittemp = datatemp.iterator(); ittemp.hasNext();) {
					Object obdataTemp = (Object) ittemp.next();
					if (obdataTemp != null)
						totalCollectionTillYstrday = obdataTemp.toString();
				}
			}

			query.delete(0, query.length());
			query.append("select sum(ammount) from dailycollectiondb where collectionDate ='"
					+ DateUtil.convertDateToUSFormat(getDateTo()) + "'");
			datatemp = eventDao.executeAllSelectQuery(query.toString());
			if (datatemp != null) {
				for (Iterator ittemp = datatemp.iterator(); ittemp.hasNext();) {
					Object obdataTemp = (Object) ittemp.next();
					if (obdataTemp != null)
						totalCollectionOfToday = obdataTemp.toString();
				}
			}
			Double rslt = 0.0;
			if (totalCollectionTillYstrday.equalsIgnoreCase("0"))
				rslt = rslt + 0;
			else
				rslt = rslt + Double.parseDouble(totalCollectionTillYstrday);

			if (totalCollectionOfToday.equalsIgnoreCase("0"))
				rslt = rslt + 0;
			else
				rslt = rslt + Double.parseDouble(totalCollectionOfToday);

			totalCollectionOfAll = Double.toString(rslt);
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method collectionReportSearch of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String collectionReportSearchClientWise() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			setDateTo(getDateTo());
			setSchemeName(getSchemeName());
			clientWiseSchemeReport = new ArrayList<SummerizePojo>();
			StringBuilder query = new StringBuilder(
					"select cscheme.cardno,sum(dcb.ammount),cclient.clientname from clientscheme as cscheme inner join clientmaster as cclient on cclient.id=cscheme.clientId  "
							+ "inner join dailycollectiondb as dcb on cscheme.cardno=dcb.cardNo where cscheme.schemeId='"
							+ getScheme()
							+ "' "
							+ "  and dcb.collectionDate<='"
							+ DateUtil.convertDateToUSFormat(getDateTo())
							+ "' group by cscheme.cardno order by cscheme.cardno");

			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					SummerizePojo smp = new SummerizePojo();
					Object[] obdata = (Object[]) it.next();
					if (obdata != null) {

						smp.setTotalAmmout(obdata[1].toString());
						smp.setInPer(obdata[0].toString());
						smp.setEmpName(obdata[0].toString() + " , "
								+ obdata[2].toString());
						clientWiseSchemeReport.add(smp);
					}

				}
				query.delete(0, query.length());
				query.append("select cscheme.cardno,dcb.ammount from clientscheme as cscheme inner join "
						+ "clientmaster as cclient on cclient.id=cscheme.clientId inner join dailycollectiondb as dcb "
						+ "on cscheme.cardno=dcb.cardNo where cscheme.schemeId='"
						+ getScheme()
						+ "' and dcb.collectionDate in('"
						+ DateUtil.convertDateToUSFormat(getDateTo())
						+ "') "
						+ "order by cscheme.cardno");
				data = eventDao.executeAllSelectQuery(query.toString());
				if (data != null) {
					int i = 0;
					for (Iterator it = data.iterator(); it.hasNext();) {
						Object[] obdata = (Object[]) it.next();
						if (obdata != null) {
							if (clientWiseSchemeReport.get(i).getInPer()
									.equalsIgnoreCase(obdata[0].toString())) {
								clientWiseSchemeReport.get(i)
										.setAmountRecvdToday(
												obdata[1].toString());
							} else {
								clientWiseSchemeReport.get(i)
										.setAmountRecvdToday("0");
							}
						}
						i++;
					}
				}
				setClientWiseSchemeReport(clientWiseSchemeReport);
			}
			System.out.println("clientWiseSchemeReport   "
					+ clientWiseSchemeReport.size());
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in method collectionReportSearchClientWise of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeClientSchemeStatusReport() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			schemeStatusList = new LinkedHashMap<String, String>();
			schemeStatusList.put(Constant.CLIENT_SCHEME_ACTIVE,
					"CLIENT_SCHEME_ACTIVE");
			schemeStatusList.put(Constant.CLIENT_SCHEME_COMPLETED_WITHOUTPAY,
					"CLIENT_SCHEME_COMPLETED_WITHOUTPAY");
			schemeStatusList.put(Constant.CLIENT_SCHEME_COMPLETED_WITHPAY,
					"CLIENT_SCHEME_COMPLETED_WITHPAY");
			schemeStatusList.put(Constant.CLIENT_SCHEME_SURRENDERED_WITHOUTPAY,
					"CLIENT_SCHEME_SURRENDERED_WITHOUTPAY");
			schemeStatusList.put(Constant.CLIENT_SCHEME_SURRENDERED_WITHPAY,
					"CLIENT_SCHEME_SURRENDERED_WITHPAY");
			schemeStatusList.put(Constant.CLIENT_SCHEME_LUCKDRAW_WITHOUTPAY,
					"CLIENT_SCHEME_LUCKDRAW_WITHOUTPAY");
			schemeStatusList.put(Constant.CLIENT_SCHEME_LUCKDRAW_WITHPAY,
					"CLIENT_SCHEME_LUCKDRAW_WITHPAY");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String summerrizeStatusReport() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			clientSearchFullViewData = new ArrayList<ClientReportPojo>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder(
					"select cm.clientname,cm.clientmob,csm.cardno,csm.schemeJoinDate,sc.schemeName,scty.amount,scty.frequency "
							+ "from clientmaster as cm inner join clientscheme as csm on cm.id=csm.clientId "
							+ "inner join scheme as sc on sc.id=csm.schemeId "
							+ "inner join schemetype as scty on sc.id=scty.schemeId "
							+ "where csm.schemeStatus=" + getSchemeStatus());
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null) {
						ClientReportPojo clientReportPojo = new ClientReportPojo();
						if (obdata[0] != null) {
							clientReportPojo
									.setClientName(obdata[0].toString());
						}
						if (obdata[1] != null) {
							clientReportPojo.setClientMob(obdata[1].toString());
						}
						if (obdata[2] != null) {
							clientReportPojo.setCardNo(obdata[2].toString());
						}
						if (obdata[3] != null) {
							clientReportPojo.setJoinDate(obdata[3].toString());
						}
						if (obdata[4] != null) {
							clientReportPojo
									.setSchemeName(obdata[4].toString());
						}

						if (obdata[5] != null) {
							clientReportPojo.setTotalCollection(obdata[5]
									.toString());
						}

						if (obdata[6] != null) {
							clientReportPojo.setFrequency(obdata[6].toString());
						}

						clientSearchFullViewData.add(clientReportPojo);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforePaymentPandingReport() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			schemeNameList = new LinkedHashMap<Integer, String>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			schemeNameList = clientCtrlDao.getScheme(eventDao);

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in Over2Cloud  method beforeClientAdd of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String paymentPandingReportSearchResult() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			System.out.println("schemeId  " + getSchemeId());
			clientSearchFullViewData = new ArrayList<ClientReportPojo>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder(
					"select frequency from schemetype where schemeId="
							+ getSchemeId());
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null && data.size() > 0) {
				String frequencyOfScheme = null;
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object obdata = (Object) it.next();
					if (obdata != null) {
						frequencyOfScheme = obdata.toString();
						break;
					}
				}
				if (frequencyOfScheme != null) {
					query.delete(0, query.length());
					query.append("select cardNo,max(collectionDate),ammount,clientName "
							+ "from dailycollectiondb where cardNo in("
							+ "select cardno from clientscheme where schemeId="
							+ getSchemeId() + ") " + "group by cardNo");
					data = eventDao.executeAllSelectQuery(query.toString());
					if (data != null && data.size() > 0) {
						for (Iterator it = data.iterator(); it.hasNext();) {
							Object[] obdata = (Object[]) it.next();
							if (obdata != null) {
								ClientReportPojo clientReportPojo = new ClientReportPojo();
								if (obdata[1] != null) {
									String nextDate = null;
									int noOfDays = 0;
									if (frequencyOfScheme
											.equalsIgnoreCase(Constant.DAILY_FREQUENCY)) {
										noOfDays = 1;
										nextDate = DateUtil
												.getNextDateAfter(
														noOfDays,
														DateUtil.convertDateToIndianFormat(obdata[1]
																.toString()));
									} else if (frequencyOfScheme
											.equalsIgnoreCase(Constant.WEEKLY_FREQUENCY)) {
										noOfDays = 7;
										nextDate = DateUtil
												.getNextDateAfter(
														noOfDays,
														DateUtil.convertDateToIndianFormat(obdata[1]
																.toString()));
									} else if (frequencyOfScheme
											.equalsIgnoreCase(Constant.MONTHLY_FREQUENCY)) {
										noOfDays = 1;
										nextDate = DateUtil
												.getMonthAfterNoOfMonths(
														obdata[1].toString(),
														noOfDays);
									} else if (frequencyOfScheme
											.equalsIgnoreCase(Constant.QUATERLY_FREQUENCY)) {
										noOfDays = 1 * 3;
										nextDate = DateUtil
												.getMonthAfterNoOfMonths(
														obdata[1].toString(),
														noOfDays);
									} else if (frequencyOfScheme
											.equalsIgnoreCase(Constant.HALF_YEARLY_FREQUENCY)) {
										noOfDays = 1 * 6;
										nextDate = DateUtil
												.getMonthAfterNoOfMonths(
														obdata[1].toString(),
														noOfDays);
									} else if (frequencyOfScheme
											.equalsIgnoreCase(Constant.YEARLY_FREQUENCY)) {
										noOfDays = 1 * 12;
										nextDate = DateUtil
												.getMonthAfterNoOfMonths(
														obdata[1].toString(),
														noOfDays);
									}
									int daysDifference = DateUtil
											.compareTwoDate(
													new Date(),
													DateUtil.convertStringToDate(nextDate));
									if (daysDifference > 0) {
										// last collection date
										clientReportPojo
												.setJoinDate(DateUtil
														.convertDateToIndianFormat(obdata[1]
																.toString()));
										//next due date
										clientReportPojo
												.setClientMob(DateUtil
														.convertDateToIndianFormat(nextDate));
										if (obdata[0] != null) {
											clientReportPojo
													.setCardNo(obdata[0]
															.toString());
										}
										if (obdata[2] != null) {
											clientReportPojo
													.setTotalCollection(obdata[2]
															.toString());
										}
										if (obdata[3] != null) {
											clientReportPojo
													.setClientName(obdata[3]
															.toString());
										}
										clientReportPojo
												.setFrequency(frequencyOfScheme);
										clientSearchFullViewData
												.add(clientReportPojo);
									}
								}
							}
						}
					} else {
						addActionError("No data found for this scheme");
						return ERROR;
					}
				} else {
					addActionError("No data found for this scheme");
					return ERROR;
				}
			} else {
				addActionError("No data found for this scheme");
				return ERROR;
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
}
