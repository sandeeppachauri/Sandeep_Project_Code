package com.ctrl.xsgx.suvidha.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.data.entity.layer.ClientCtrlDao;
import com.ctrl.xsgx.data.entity.layerimpl.ClientCtrlDaoImpl;
import com.ctrl.xsgx.model.ClientSchemeCloseCtrlModel;
import com.databean.xsgx.suvidha.commonmaster.ClientScheme;
import com.databean.xsgx.suvidha.commonmaster.ClientSchemeSurrenderReward;
import com.databean.xsgx.suvidha.commonmaster.DailyCollectionDB;
import com.databean.xsgx.suvidha.commonmaster.SchemeActionHistory;
import com.databean.xsgx.suvidha.commonmaster.SchemeRewardData;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateHelper;
import com.suvidha.common.DateUtil;

@SuppressWarnings("rawtypes")
public class ClientSchemeCloseCtrl extends ClientSchemeCloseCtrlModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Log log = LogFactory.getLog(ClientSchemeCloseCtrl.class);

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

	public String beforeClientClose() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			clientNameList = clientCtrlDao.getClientNameList(eventDao);

		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method beforeClientClose of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String clientOpneSchemes() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			schemeNameList = clientCtrlDao.getOpenScheme(eventDao, getId());

		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientOpneSchemes of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String clientOpenSchemeStatus() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			setModule(getModule());
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

			query.append("select withdrawable,frequency,amount,minPeriod,totalAmount,maturityAmount from schemetype where schemeId="
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
					if (obdata[5] != null)
						matryAmmount = obdata[5].toString();
				}
			}
			query.delete(0, query.length());
			String date = null;
			query.append("select schemeJoinDate,cardno,schemeStatus from clientscheme where id="
					+ getId());
			List dataTemp = eventDao.executeAllSelectQuery(query.toString());
			if (dataTemp != null) {
				for (Iterator it1 = dataTemp.iterator(); it1.hasNext();) {
					Object[] obdata = (Object[]) it1.next();
					date = obdata[0].toString();
					joingDate = DateUtil.convertDateToIndianFormat(date);
					clientCardNo = obdata[1].toString();
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
					// for setting the finish date of scheme
					int noOfDays = 0;
					if (frequnecy.equalsIgnoreCase(Constant.DAILY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme);
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil.getNextDateAfter(
										noOfDays,
										DateUtil.convertDateToIndianFormat(date)));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.WEEKLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 7;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil.getNextDateAfter(
										noOfDays,
										DateUtil.convertDateToIndianFormat(date)));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.MONTHLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme);
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.QUATERLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 3;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.HALF_YEARLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 6;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.YEARLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 12;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					}
				}
			}
			long diff = DateHelper
					.getNoOfDaysWeekMonthQuaterHalfYearFromCurrentDate(date,
							frequnecy);
			query.delete(0, query.length());
			query.append("select widraw from schemewithdraw where schemeId="
					+ tempSchemeId + " and minPeriod<=" + diff
					+ " and maxPeriod>=" + diff);
			dataTemp = eventDao.executeAllSelectQuery(query.toString());
			if (dataTemp != null) {
				for (Iterator it1 = dataTemp.iterator(); it1.hasNext();) {
					Object obdata = (Object) it1.next();
					status = obdata.toString();
				}
			}

			clientWiseDailyCollectionHistory = new ArrayList<DailyCollectionDB>();
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
							.convertDateToIndianFormat(obdata[4].toString()));
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
			if (!DateUtil.comparetwoDates(cmpltnTime,
					DateUtil.getCurrentDateUSFormat()))
				status = Constant.ELIGIBLE;
			else
				status = Constant.ELIGIBLE_NOT;
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method getClientSchemeStatus of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String clientSchemeClose() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			SchemeActionHistory scheme = new SchemeActionHistory();
			scheme.setActionDesc(getCloseRemark());
			scheme.setSchemeAction(Constant.CLOSING_SCHEME_ACTION_STATUS);
			scheme.setSchemeId(getId());
			scheme.setDate(DateUtil.getCurrentDateUSFormat());
			scheme.setTime(DateUtil.getCurrentTime());
			scheme.setUser(userName);
			eventDao.addDetails(scheme);
			ClientScheme cscheme = (ClientScheme) eventDao.findRecordForPk(
					Integer.parseInt(getId()), ClientScheme.class);
			cscheme.setSchemeStatus(Constant.CLIENT_SCHEME_COMPLETED_WITHOUTPAY);
			boolean status = eventDao.UpdateDetails(cscheme);
			if (status)
				addActionMessage("Scheme Closed Successfully!!!");
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

	public String clientCloseSchemes() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			setId(getId());
			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			schemeNameList = clientCtrlDao.getCleintCloseScheme(eventDao,
					getId());

		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientCloseSchemes of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String clientCloseSchemeStatusForReward() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			setId(getId());
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
					tempSchemeId = obdata.toString();
				}
			}

			query.delete(0, query.length());
			query.append("select frequency,amount,minPeriod,totalAmount,maturityAmount from schemetype where schemeId="
					+ tempSchemeId);
			data = eventDao.executeAllSelectQuery(query.toString());
			String frequnecy = null;
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					frequnecy = obdata[0].toString();
					amountSubmitDaily = obdata[1].toString();
					periodOfScheme = obdata[2].toString();
					totalAmount = obdata[3].toString();
					matryAmmount = obdata[4].toString();
				}
			}
			query.delete(0, query.length());
			String date = null;
			query.append("select schemeJoinDate,cardno,schemeStatus,id from clientscheme where id="
					+ getId());
			List dataTemp = eventDao.executeAllSelectQuery(query.toString());
			if (dataTemp != null) {
				for (Iterator it1 = dataTemp.iterator(); it1.hasNext();) {
					Object[] obdata = (Object[]) it1.next();
					/*
					 * if(obdata[3]!=null) {
					 * setId(Integer.toString((Integer)obdata[3])); }
					 */
					date = obdata[0].toString();
					joingDate = DateUtil.convertDateToIndianFormat(date);
					clientCardNo = obdata[1].toString();
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

					// for setting the finish date of scheme
					int noOfDays = 0;

					if (frequnecy.equalsIgnoreCase(Constant.DAILY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme);
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil.getNextDateAfter(
										noOfDays,
										DateUtil.convertDateToIndianFormat(date)));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.WEEKLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 7;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil.getNextDateAfter(
										noOfDays,
										DateUtil.convertDateToIndianFormat(date)));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.MONTHLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme);
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.QUATERLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 3;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.HALF_YEARLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 6;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.YEARLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 12;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					}

				}
			}
			query.delete(0, query.length());
			query.append("select sum(ammount),count(*) from dailycollectiondb where cardNo='"
					+ clientCardNo + "'");
			dataTemp = eventDao.executeAllSelectQuery(query.toString());
			if (dataTemp != null) {
				for (Iterator it1 = dataTemp.iterator(); it1.hasNext();) {
					Object[] obdata = (Object[]) it1.next();
					totalAmmountDeposite = obdata[0].toString();
					totalInst = obdata[1].toString();
				}
			}

			/**
			 * Get extra loailty
			 */

			query.delete(0, query.length());
			query.append("select loyalityGms from extraloyality where schemeId="
					+ tempSchemeId);
			dataTemp = eventDao.executeAllSelectQuery(query.toString());
			if (dataTemp != null && dataTemp.size() > 0) {
				for (Iterator it1 = dataTemp.iterator(); it1.hasNext();) {
					Object obdata = (Object) it1.next();
					extraLoyalty = obdata.toString() + " "
							+ Constant.GOLD_IN_GMS;
				}
			}
			this.amountSubmitDaily = amountSubmitDaily;
			this.totalAmount = totalAmount;
			this.periodOfScheme = periodOfScheme;
			this.frequnecy = frequnecy;
			if (!DateUtil.comparetwoDates(cmpltnTime,
					DateUtil.getCurrentDateUSFormat()))
				status = Constant.ELIGIBLE;
			else
				status = Constant.ELIGIBLE_NOT;
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in method clientCloseSchemeStatusForReward of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String todayGoldDetails() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();

			goldDetails = new LinkedHashMap<Object, Object>();
			/**
			 * 14K is 14 / 24 = .583 x 100 = 58.3% gold which is $583/ounce or
			 * $18.75/gram 18K is 18 / 24 = .750 x 100 = 75.0% gold which is
			 * $750/ounce or $24.12/gram 22K is 22 / 24 = .916 x 100 = 91.6%
			 * gold which is $916/ounce or $29.45/gram
			 * value=totalgold*%value/100;
			 */
			StringBuilder query = new StringBuilder(
					"select goldRate,goldRateDate from goldrate order by goldRateDate desc limit 0,1");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null && data.size() > 0) {
				String goldPrice = null;
				for (Iterator it1 = data.iterator(); it1.hasNext();) {
					Object[] obdata = (Object[]) it1.next();
					goldPrice = obdata[0].toString();
					goldDate = DateUtil.convertDateToIndianFormat(obdata[1]
							.toString());
				}
				if (goldPrice != null) {
					Double value = Integer.parseInt(goldPrice) * 91.6 / 100;
					goldDetails.put(value, Constant._22_GOLD_TYPE);

					value = Integer.parseInt(goldPrice) * 75.0 / 100;
					goldDetails.put(value, Constant._18_GOLD_TYPE);

					value = Integer.parseInt(goldPrice) * 58.3 / 100;
					goldDetails.put(value, Constant._14_GOLD_TYPE);
				}
			}
			if (getModule() != null && getModule().equalsIgnoreCase("1")) {
				String tempSchemeId = null;
				query.delete(0, query.length());
				query.append("select schemeId from clientscheme where id="
						+ getId());
				data = eventDao.executeAllSelectQuery(query.toString());
				if (data != null) {
					for (Iterator it = data.iterator(); it.hasNext();) {
						Object obdata = (Object) it.next();
						if (obdata != null)
							tempSchemeId = obdata.toString();
					}
				}

				query.delete(0, query.length());
				query.append("select amount from luckydraw where paymentMode='1' and schemeId="
						+ tempSchemeId);
				data = eventDao.executeAllSelectQuery(query.toString());
				if (data != null) {
					for (Iterator it = data.iterator(); it.hasNext();) {
						Object obdata = (Object) it.next();
						if (obdata != null)
							goldOfrs = obdata.toString();
					}
				}
			}
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method todayGoldDetails of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String cashPrizeLuckyDraw() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			String tempSchemeId = null;
			StringBuilder query = new StringBuilder("");
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

			query.delete(0, query.length());
			query.append("select amount from luckydraw where paymentMode='2' and schemeId="
					+ tempSchemeId);
			data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object obdata = (Object) it.next();
					if (obdata != null)
						cashInHand = obdata.toString();
				}
			}
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method cashPrizeLuckyDraw of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 
	 * for allotting reward to client when his scheme will complete
	 * 
	 * *************************************************************************
	 * ********************* clientId schemeid joingDate cmpltnTime
	 * periodOfScheme totalInst totalAmount totalAmmountDeposite matryAmmount
	 * schemeStatus rewardType cashInHand goldTypeCart goldTypePrice goldDate
	 * goldingm
	 * 
	 * @return
	 */

	public String clientSchemeCloseReward() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			SchemeActionHistory scheme = new SchemeActionHistory();
			scheme.setActionDesc(getCloseRemark());
			scheme.setSchemeAction(Constant.CLOSED_SCHEME_REWARD_ALLOTMENT);
			scheme.setSchemeId(getId());
			scheme.setDate(DateUtil.getCurrentDateUSFormat());
			scheme.setTime(DateUtil.getCurrentTime());
			scheme.setUser(userName);
			eventDao.addDetails(scheme);
			SchemeRewardData schemeReward = new SchemeRewardData();
			schemeReward.setTotalPurchaseOf(getTotalPurchaseOf());
			schemeReward.setAdjstmntVlue(getAdjstmntVlue());
			schemeReward.setCashRtrn(getCashRtrn());
			schemeReward.setJwlryType(getJwlryType());
			schemeReward.setDmnndGoldType(getDmnndGoldType());
			schemeReward.setPureGoldType(getPureGoldType());
			schemeReward.setSilverWght(getSilverWght());
			schemeReward.setStoneName(getStoneName());
			schemeReward.setDmndWght(getDmndWght());
			schemeReward.setDmdnRate(getDmdnRate());
			schemeReward.setDmndValue(getDmndValue());
			schemeReward.setGoldValue(getGoldValue());
			schemeReward.setGoldWght(getGoldWght());
			schemeReward.setStoneWght(getStoneWght());
			schemeReward.setDate(DateUtil.getCurrentDateUSFormat());
			schemeReward.setTime(DateUtil.getCurrentTime());
			schemeReward.setUser(userName);
			schemeReward.setClientId(getClientId());
			schemeReward.setSchemeId(getSchemeName());
			schemeReward.setJoingDate(DateUtil
					.convertDateToUSFormat(getJoingDate()));
			schemeReward.setCmpltnTime(DateUtil
					.convertDateToUSFormat(getCmpltnTime()));
			schemeReward.setPeriodOfScheme(getPeriodOfScheme());
			schemeReward.setTotalInst(getTotalInst());
			schemeReward.setTotalAmount(getTotalAmount());
			schemeReward.setTotalAmmountDeposite(getTotalAmmountDeposite());
			schemeReward.setMatryAmmount(getMatryAmmount());
			schemeReward.setSchemeStatus(getSchemeStatus());
			schemeReward.setRewardType(getRewardType());
			schemeReward.setCashInHand(getCashInHand());
			schemeReward.setGoldTypeCart(getGoldTypeCart());
			schemeReward.setGoldTypePrice(getGoldTypePrice());
			schemeReward.setGoldDate(DateUtil
					.convertDateToUSFormat(getGoldDate()));
			schemeReward.setGoldingm(getGoldingm());
			schemeReward.setExtraLoyalty(getExtraLoyalty());
			boolean status = eventDao.addDetails(schemeReward);
			ClientScheme cscheme = (ClientScheme) eventDao.findRecordForPk(
					Integer.parseInt(getSchemeName()), ClientScheme.class);
			cscheme.setSchemeStatus(Constant.CLIENT_SCHEME_COMPLETED_WITHPAY);
			eventDao.UpdateDetails(cscheme);
			if (status)
				addActionMessage("Scheme Reward Submitted Successfully!!!");
			else
				addActionError("There is some data problem");
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientSchemeCloseReward of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 
	 * Scheme surrender reward works from here
	 * 
	 * @param clientNameList
	 */

	public String clientSchemeSurrender() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			schemeNameList = clientCtrlDao.getClientSchemeSurrender(eventDao,
					getId());

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

	public String clientSchemeSurrenderDetail() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
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

			query.append("select frequency,amount,minPeriod,totalAmount,maturityAmount,withdrawable from schemetype where schemeId="
					+ tempSchemeId);
			data = eventDao.executeAllSelectQuery(query.toString());
			String frequnecy = null;
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					frequnecy = obdata[0].toString();
					amountSubmitDaily = obdata[1].toString();
					periodOfScheme = obdata[2].toString();
					totalAmount = obdata[3].toString();
					matryAmmount = obdata[4].toString();
					status = obdata[5].toString();
				}
			}
			query.delete(0, query.length());
			String date = null;
			query.append("select schemeJoinDate,cardno,schemeStatus,id from clientscheme where id="
					+ getId());
			List dataTemp = eventDao.executeAllSelectQuery(query.toString());
			if (dataTemp != null) {
				for (Iterator it1 = dataTemp.iterator(); it1.hasNext();) {
					Object[] obdata = (Object[]) it1.next();
					if (obdata[3] != null) {
						setId(Integer.toString((Integer) obdata[3]));
					}
					date = obdata[0].toString();
					joingDate = DateUtil.convertDateToIndianFormat(date);
					clientCardNo = obdata[1].toString();
					schemeStatus = obdata[2].toString();
					/*
					 * if(schemeStatus.equalsIgnoreCase("0")) {
					 * schemeStatus="Active"; } else
					 * if(schemeStatus.equalsIgnoreCase("1") ||
					 * schemeStatus.equalsIgnoreCase("3")) {
					 * schemeStatus="Completed"; } else
					 * if(schemeStatus.equalsIgnoreCase("2")) {
					 * schemeStatus="Surrendered"; }
					 */
					// for setting the finish date of scheme
					int noOfDays = 0;
					if (frequnecy.equalsIgnoreCase(Constant.DAILY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme);
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil.getNextDateAfter(
										noOfDays,
										DateUtil.convertDateToIndianFormat(date)));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.WEEKLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 7;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil.getNextDateAfter(
										noOfDays,
										DateUtil.convertDateToIndianFormat(date)));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.MONTHLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme);
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.QUATERLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 3;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.HALF_YEARLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 6;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					} else if (frequnecy
							.equalsIgnoreCase(Constant.YEARLY_FREQUENCY)) {
						noOfDays = Integer.parseInt(periodOfScheme) * 12;
						cmpltnTime = DateUtil
								.convertDateToIndianFormat(DateUtil
										.getMonthAfterNoOfMonths(date, noOfDays));
					}
				}
			}
			query.delete(0, query.length());
			query.append("select sum(ammount),count(*) from dailycollectiondb where cardNo='"
					+ clientCardNo + "'");
			dataTemp = eventDao.executeAllSelectQuery(query.toString());
			if (dataTemp != null) {
				for (Iterator it1 = dataTemp.iterator(); it1.hasNext();) {
					Object[] obdata = (Object[]) it1.next();
					totalAmmountDeposite = obdata[0].toString();
					totalInst = obdata[1].toString();
				}
			}
			this.amountSubmitDaily = amountSubmitDaily;
			this.totalAmount = totalAmount;
			this.periodOfScheme = periodOfScheme;
			this.frequnecy = frequnecy;
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method clientSchemeSurrenderDetail of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 
	 * for allotting reward to client when his scheme will complete
	 * 
	 * *************************************************************************
	 * ********************* clientId clientSchemeId joingDate cmpltnTime
	 * periodOfScheme----Total Installment totalInst-----Installment Deposit
	 * totalAmount-----Total Collection totalAmmountDeposite-----Receive
	 * Collection matryAmmount------Maturity Amount withdrawStatus----Withdraw
	 * Status rewardType rewardCash-----Reward Cash cashInHand---Cash In Hand
	 * goldingmPrcs---Gold Price GM's goldTypeCart goldTypePrice goldDate
	 * goldingm---Gold In GM's
	 * 
	 * @return
	 */

	public String clientSchemeSurrenderReward() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientSchemeSurrenderReward schemeReward = new ClientSchemeSurrenderReward();

			schemeReward.setTotalPurchaseOf(getTotalPurchaseOf());
			schemeReward.setAdjstmntVlue(getAdjstmntVlue());
			schemeReward.setCashRtrn(getCashRtrn());
			schemeReward.setJwlryType(getJwlryType());
			schemeReward.setDmnndGoldType(getDmnndGoldType());
			schemeReward.setPureGoldType(getPureGoldType());
			schemeReward.setSilverWght(getSilverWght());
			schemeReward.setStoneName(getStoneName());
			schemeReward.setDmndWght(getDmndWght());
			schemeReward.setDmdnRate(getDmdnRate());
			schemeReward.setDmndValue(getDmndValue());
			schemeReward.setGoldValue(getGoldValue());
			schemeReward.setGoldWght(getGoldWght());
			schemeReward.setStoneWght(getStoneWght());

			schemeReward.setDate(DateUtil.getCurrentDateUSFormat());
			schemeReward.setTime(DateUtil.getCurrentTime());
			schemeReward.setUser(userName);
			schemeReward.setClientId(getClientId());
			schemeReward.setClientSchemeId(getClientSchemeId());
			schemeReward.setJoingDate(DateUtil
					.convertDateToUSFormat(getJoingDate()));
			schemeReward.setCmpltnTime(DateUtil
					.convertDateToUSFormat(getCmpltnTime()));
			schemeReward.setPeriodOfScheme(getPeriodOfScheme());
			schemeReward.setTotalInst(getTotalInst());
			schemeReward.setTotalAmount(getTotalAmount());
			schemeReward.setTotalAmmountDeposite(getTotalAmmountDeposite());
			schemeReward.setMatryAmmount(getMatryAmmount());
			schemeReward.setWithdrawStatus(getWithdrawStatus());
			schemeReward.setRewardType(getRewardType());
			schemeReward.setCashInHand(getCashInHand());
			schemeReward.setGoldTypeCart(getGoldTypeCart());
			schemeReward.setGoldIngmPrcs(getGoldingmPrcs());
			schemeReward.setGoldTypePrice(getGoldTypePrice());
			schemeReward.setGoldDate(DateUtil
					.convertDateToUSFormat(getGoldDate()));
			schemeReward.setGoldingm(getGoldingm());
			schemeReward.setRewardCash(getRewardCash());
			boolean status = eventDao.addDetails(schemeReward);

			SchemeActionHistory scheme = new SchemeActionHistory();
			scheme.setActionDesc(getCloseRemark());
			scheme.setSchemeAction(Constant.CLOSED_SCHEME_SURRENDERED_REWARD_ALLOTMENT);
			scheme.setSchemeId(getId());
			scheme.setDate(DateUtil.getCurrentDateUSFormat());
			scheme.setTime(DateUtil.getCurrentTime());
			scheme.setUser(userName);
			eventDao.addDetails(scheme);

			ClientScheme cscheme = (ClientScheme) eventDao.findRecordForPk(
					Integer.parseInt(getClientSchemeId()), ClientScheme.class);
			cscheme.setSchemeStatus(Constant.CLIENT_SCHEME_SURRENDERED_WITHPAY);
			eventDao.UpdateDetails(cscheme);
			if (status)
				addActionMessage("Scheme Surrender Reward Submitted Successfully!!!");
			else
				addActionError("There is some data problem");
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientSchemeSurrenderReward of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
