package com.ctrl.xsgx.suvidha.client;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.data.entity.layer.ClientCtrlDao;
import com.ctrl.xsgx.data.entity.layerimpl.ClientCtrlDaoImpl;
import com.ctrl.xsgx.model.LuckyDrawSchemeModel;
import com.databean.xsgx.suvidha.commonmaster.ClientScheme;
import com.databean.xsgx.suvidha.commonmaster.ClientSchemeLuckyDraw;
import com.databean.xsgx.suvidha.commonmaster.SchemeActionHistory;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateUtil;

@SuppressWarnings("rawtypes")
public class LuckyDrawScheme extends LuckyDrawSchemeModel {

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

	public String beforeLuckyDrawScheme() {
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
							+ "Problem in Over2Cloud  method beforeLuckyDrawScheme of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String clientOpneSchemesForLuckDraw() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder("");
			schemeNameList = new LinkedHashMap<Integer, String>();
			query.append("select cscheme.id,schem.schemeName  from scheme as schem inner join clientscheme as cscheme on cscheme.schemeId=schem.id  "
					+ "where cscheme.clientId="
					+ getId()
					+ " and cscheme.schemeStatus="
					+ getFlag()
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
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientOpneSchemesForLuckDraw of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String clientSchemeLuckDraw() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			SchemeActionHistory scheme = new SchemeActionHistory();
			scheme.setActionDesc(getCloseRemark());
			scheme.setSchemeAction(Constant.LUCKY_DRAW_SCHEME_CLOSE_MSG);
			scheme.setSchemeId(getSchemeName());
			scheme.setDate(DateUtil.getCurrentDateUSFormat());
			scheme.setTime(DateUtil.getCurrentTime());
			scheme.setUser(userName);
			eventDao.addDetails(scheme);
			ClientScheme cscheme = (ClientScheme) eventDao.findRecordForPk(
					Integer.parseInt(getId()), ClientScheme.class);
			cscheme.setSchemeStatus(Constant.CLIENT_SCHEME_LUCKDRAW_WITHOUTPAY);
			boolean status = eventDao.UpdateDetails(cscheme);
			if (status)
				addActionMessage("Scheme Submitted Successfully For Luck Draw Process!!!");
			else
				addActionError("There is some data problem");
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientSchemeLuckDraw of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String clientCloseSchemeDetail() {
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

			rewardTypeLst = new HashMap<String, String>();
			query.delete(0, query.length());
			query.append("select futurepayment,paymentMode from luckydraw where schemeId="
					+ tempSchemeId);
			dataTemp = eventDao.executeAllSelectQuery(query.toString());
			if (dataTemp != null) {
				for (Iterator it1 = dataTemp.iterator(); it1.hasNext();) {
					Object[] obdata = (Object[]) it1.next();
					if (obdata != null
							&& obdata[0].toString().equalsIgnoreCase(
									Constant.ELIGIBLE)) {
						int tempremainInsta = Integer.parseInt(periodOfScheme)
								- Integer.parseInt(totalInst);
						remainInsta = Integer.toString(tempremainInsta);
						if (tempremainInsta != 0)
							futureDeposit = Constant.ELIGIBLE;
						else
							futureDeposit = Constant.ELIGIBLE_NOT;

						if (obdata[1].toString().equalsIgnoreCase("1")) {
							rewardTypeLst.put("Gold", "Gold");
						} else {
							rewardTypeLst.put("Cash", "Cash");
						}
					} else {
						remainInsta = "0";
						futureDeposit = Constant.ELIGIBLE_NOT;
					}

				}
			}

			this.amountSubmitDaily = amountSubmitDaily;
			this.totalAmount = totalAmount;
			this.periodOfScheme = periodOfScheme;
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in method clientCloseSchemeDetail of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 
	 * private String clientName; private String schemeName; private String
	 * joingDate; private String cmpltnTime; private String periodOfScheme;
	 * private String totalInst; private String remainInsta; private String
	 * futureDeposit; private String totalAmount; private String
	 * totalAmmountDeposite; private String matryAmmount; private String
	 * schemeStatus; private String rewardType; private String cashInHand;
	 * private String goldDate; private String goldTypePrice; private String
	 * goldOfrs; private String goldingm;
	 * 
	 * @return
	 */
	public String clientLuckDrawReward() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientSchemeLuckyDraw clucky = new ClientSchemeLuckyDraw();

			clucky.setTotalPurchaseOf(getTotalPurchaseOf());
			clucky.setAdjstmntVlue(getAdjstmntVlue());
			clucky.setCashRtrn(getCashRtrn());
			clucky.setJwlryType(getJwlryType());
			clucky.setDmnndGoldType(getDmnndGoldType());
			clucky.setPureGoldType(getPureGoldType());
			clucky.setSilverWght(getSilverWght());
			clucky.setStoneName(getStoneName());
			clucky.setDmndWght(getDmndWght());
			clucky.setDmdnRate(getDmdnRate());
			clucky.setDmndValue(getDmndValue());
			clucky.setGoldValue(getGoldValue());
			clucky.setGoldWght(getGoldWght());
			clucky.setStoneWght(getStoneWght());
			clucky.setClientName(getClientName());
			clucky.setSchemeName(getSchemeName());
			clucky.setJoingDate(getJoingDate());
			clucky.setCmpltnTime(getCmpltnTime());
			clucky.setPeriodOfScheme(getPeriodOfScheme());
			clucky.setTotalInst(getTotalInst());
			clucky.setRemainInsta(getRemainInsta());
			clucky.setFutureDeposit(getFutureDeposit());
			clucky.setTotalAmount(getTotalAmount());
			clucky.setTotalAmmountDeposite(getTotalAmmountDeposite());
			clucky.setMatryAmmount(getMatryAmmount());
			clucky.setSchemeStatus(getSchemeStatus());
			clucky.setRewardType(getRewardType());
			clucky.setCashInHand(getCashInHand());
			clucky.setGoldDate(getGoldDate());
			clucky.setGoldTypePrice(getGoldTypePrice());
			clucky.setGoldOfrs(getGoldOfrs());
			clucky.setGoldingm(getGoldingm());
			clucky.setUser(userName);
			boolean status = eventDao.addDetails(clucky);

			SchemeActionHistory scheme = new SchemeActionHistory();
			scheme.setActionDesc(getCloseRemark());
			scheme.setSchemeAction(Constant.LUCKY_DRAW_SCHEME_CLOSE_REWARD_MSG);
			scheme.setSchemeId(getId());
			scheme.setDate(DateUtil.getCurrentDateUSFormat());
			scheme.setTime(DateUtil.getCurrentTime());
			scheme.setUser(userName);
			eventDao.addDetails(scheme);

			ClientScheme cscheme = (ClientScheme) eventDao.findRecordForPk(
					Integer.parseInt(getSchemeName()), ClientScheme.class);
			cscheme.setSchemeStatus(Constant.CLIENT_SCHEME_LUCKDRAW_WITHPAY);
			eventDao.UpdateDetails(cscheme);
			if (status)
				addActionMessage("Scheme Lucky Draw Reward Submitted Successfully!!!");
			else
				addActionError("There is some data problem");
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientLuckDrawReward of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
