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
import com.ctrl.xsgx.model.ClientSchemeReportModel;
import com.databean.xsgx.suvidha.commonmaster.ClientSchemeLuckyDraw;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateUtil;

@SuppressWarnings("rawtypes")
public class ClientSchemeReport extends ClientSchemeReportModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Log log = LogFactory.getLog(ClientSchemeReport.class);

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

	public String beforeClientReport() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			clientNameList = clientCtrlDao.getClientNameList(eventDao);
			schemeList = clientCtrlDao.getScheme(eventDao);

		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method beforeClientReport of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	// {"schemeName":schemeName,"client":client,"dateFrom":dateFrom,"dateTo":dateTo,"schemeStatus":schemeStatus};

	public String clientReportSearchResult() {
		try {

			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			clientSearchData = new ArrayList<ClientReportPojo>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder(
					"select distinct client.clientname,client.clientmob,schm.schemeName,cscheme.cardno,sum(dcb.ammount),"
							+ "cscheme.schemeJoinDate,client.id from clientmaster as client left join clientscheme as cscheme on cscheme.clientId=client.id "
							+ "left join scheme as schm on schm.id=cscheme.schemeId left join dailycollectiondb as dcb "
							+ "on dcb.cardNo=cscheme.cardno where 1=1");

			if (getCardNo() != null
					&& !getCardNo().equalsIgnoreCase("")
					&& !getCardNo().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)) {
				query.append(" and cscheme.cardno='" + getCardNo() + "'");
			}

			if (getSchemeName() != null
					&& !getSchemeName().equalsIgnoreCase("")
					&& !getSchemeName().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)) {
				query.append(" and cscheme.schemeId='" + getSchemeName() + "'");
			}

			if (getClient() != null
					&& !getClient().equalsIgnoreCase("")
					&& !getClient().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)) {
				query.append(" and client.id=" + getClient() + "");
			}
			if (getSchemeStatus() != null
					&& !getSchemeStatus().equalsIgnoreCase("")
					&& !getSchemeStatus().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)) {
				if (getSchemeStatus()
						.equalsIgnoreCase(Constant.ACTIVATE_SCHEME)) {

					// 0 flag
					query.append(" and cscheme.schemeStatus in('"
							+ Constant.CLIENT_SCHEME_ACTIVE + "')");

				} else if (getSchemeStatus().equalsIgnoreCase(
						Constant.COMPLETED_SCHEME)) {

					// 1,3
					query.append(" and cscheme.schemeStatus in('"
							+ Constant.CLIENT_SCHEME_COMPLETED_WITHOUTPAY
							+ "','" + Constant.CLIENT_SCHEME_COMPLETED_WITHPAY
							+ "')");

				} else if (getSchemeStatus().equalsIgnoreCase(
						Constant.SURRENDERED_SCHEME)) {

					// 2,4
					query.append(" and cscheme.schemeStatus in('"
							+ Constant.CLIENT_SCHEME_SURRENDERED_WITHOUTPAY
							+ "','"
							+ Constant.CLIENT_SCHEME_SURRENDERED_WITHPAY + "')");

				} else if (getSchemeStatus().equalsIgnoreCase(
						Constant.LUCKYDRAW_SCHEME)) {

					// 5,6
					query.append(" and cscheme.schemeStatus in('"
							+ Constant.CLIENT_SCHEME_LUCKDRAW_WITHOUTPAY
							+ "','" + Constant.CLIENT_SCHEME_LUCKDRAW_WITHPAY
							+ "')");

				}
			}
			if (getDateFrom() != null && !getDateFrom().equalsIgnoreCase("")
					&& getDateTo() != null && !getDateTo().equalsIgnoreCase("")) {
				query.append(" and dcb.collectionDate between '"
						+ DateUtil.convertDateToUSFormat(getDateFrom())
						+ "' and '"
						+ DateUtil.convertDateToUSFormat(getDateTo()) + "'");
			}
			query.append(" group by cscheme.cardno order by client.clientname");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					ClientReportPojo cmp = new ClientReportPojo();
					cmp.setClientName(obdata[0].toString());
					if (obdata[1] != null)
						cmp.setClientMob(obdata[1].toString());
					else
						cmp.setClientMob(Constant.NO_DATA_AVAILABLE);
					if (obdata[2] != null)
						cmp.setSchemeName(obdata[2].toString());
					else
						cmp.setSchemeName(Constant.NO_DATA_AVAILABLE);
					if (obdata[3] != null)
						cmp.setCardNo(obdata[3].toString());
					else
						cmp.setCardNo(Constant.NO_DATA_AVAILABLE);
					if (obdata[4] != null)
						cmp.setTotalCollection(obdata[4].toString());
					else
						cmp.setTotalCollection(Constant.NO_DATA_AVAILABLE);
					if (obdata[5] != null)
						cmp.setJoinDate(DateUtil
								.convertDateToIndianFormat(obdata[5].toString()));
					else
						cmp.setJoinDate(Constant.NO_DATA_AVAILABLE);
					cmp.setClientId((Integer) obdata[6]);
					clientSearchData.add(cmp);
				}
			}
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in Over2Cloud  method clientReportSearchResult of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String schemeFullDetail() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			cardNoCollectionDetails = new LinkedHashMap<String, String>();
			StringBuilder query = new StringBuilder(
					"select collectionDate,ammount from dailycollectiondb where cardNo='"
							+ getCardNo() + "'");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null && obdata[0] != null
							&& obdata[1] != null) {
						cardNoCollectionDetails.put(obdata[0].toString(),
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
							+ "Problem in Over2Cloud  method schemeFullDetail of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String beforeActionFullDetail() {
		if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
			return LOGIN;
		}
		setCardNo(getCardNo());
		return SUCCESS;
	}

	public String actionFullDetail() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			fullActionHistory = new ArrayList<ClientSchemeLuckyDraw>();
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder(
					"select id,schemeStatus from clientscheme where cardno='"
							+ getCardNo() + "'");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null) {

						if (obdata[1].toString().equalsIgnoreCase(
								Constant.CLIENT_SCHEME_ACTIVE)) {
							return SUCCESS;
						} else if (obdata[1].toString().equalsIgnoreCase(
								Constant.CLIENT_SCHEME_COMPLETED_WITHOUTPAY)
								|| obdata[1]
										.toString()
										.equalsIgnoreCase(
												Constant.CLIENT_SCHEME_COMPLETED_WITHPAY)) {
							query.delete(0, query.length());
							query.append("select totalPurchaseOf,joingDate,matryAmmount,periodOfScheme,totalAmmountDeposite,totalAmount,"
									+ "totalInst,rewardType,cashInHand,jwlryType,adjstmntVlue,cashRtrn,cmpltnTime,dmdnRate,dmndValue,dmndWght,dmnndGoldType,"
									+ "goldValue,goldWght,pureGoldType,silverWght,stoneName,stoneWght,date,time from schemecompletereward where schemeId="
									+ (Integer) obdata[0] + "");

							List dataTemp = eventDao
									.executeAllSelectQuery(query.toString());
							if (dataTemp != null) {
								for (Iterator itTemp = dataTemp.iterator(); itTemp
										.hasNext();) {
									Object[] obdataTemp = (Object[]) itTemp
											.next();
									if (obdataTemp != null) {
										ClientSchemeLuckyDraw cndt = new ClientSchemeLuckyDraw();
										cndt.setTotalPurchaseOf(obdataTemp[0]
												.toString());
										cndt.setJoingDate(DateUtil
												.convertDateToIndianFormat(obdataTemp[1]
														.toString()));
										cndt.setMatryAmmount(obdataTemp[2]
												.toString());
										cndt.setPeriodOfScheme(obdataTemp[3]
												.toString());
										cndt.setTotalAmmountDeposite(obdataTemp[4]
												.toString());
										cndt.setTotalAmount(obdataTemp[5]
												.toString());
										cndt.setTotalInst(obdataTemp[6]
												.toString());
										cndt.setRewardType(obdataTemp[7]
												.toString());
										if (obdataTemp[8] != null
												&& !obdataTemp[8].toString()
														.equalsIgnoreCase(""))
											cndt.setCashInHand(obdataTemp[8]
													.toString());
										else
											cndt.setCashInHand(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[9] != null
												&& !obdataTemp[16]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[9]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setJwlryType(obdataTemp[9]
													.toString());
										else
											cndt.setJwlryType(Constant.NO_DATA_AVAILABLE);
										if (obdataTemp[10] != null
												&& !obdataTemp[10]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setAdjstmntVlue(obdataTemp[10]
													.toString());
										else
											cndt.setAdjstmntVlue(Constant.NO_DATA_AVAILABLE);
										if (obdataTemp[11] != null
												&& !obdataTemp[11]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setCashRtrn(obdataTemp[11]
													.toString());
										else
											cndt.setCashRtrn(Constant.NO_DATA_AVAILABLE);
										cndt.setCmpltnTime(DateUtil
												.convertDateToIndianFormat(obdataTemp[12]
														.toString()));

										if (obdataTemp[13] != null
												&& !obdataTemp[13]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setDmdnRate(obdataTemp[13]
													.toString());
										else
											cndt.setDmdnRate(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[14] != null
												&& !obdataTemp[14]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setDmndValue(obdataTemp[14]
													.toString());
										else
											cndt.setDmndValue(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[15] != null
												&& !obdataTemp[15]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setDmndWght(obdataTemp[15]
													.toString());
										else
											cndt.setDmndWght(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[16] != null
												&& !obdataTemp[16]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[16]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setDmnndGoldType(obdataTemp[16]
													.toString());
										else
											cndt.setDmnndGoldType(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[17] != null
												&& !obdataTemp[17]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[17]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setGoldValue(obdataTemp[17]
													.toString());
										else
											cndt.setGoldValue(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[18] != null
												&& !obdataTemp[18]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[18]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setGoldWght(obdataTemp[18]
													.toString());
										else
											cndt.setGoldWght(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[19] != null
												&& !obdataTemp[19]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[19]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setPureGoldType(obdataTemp[19]
													.toString());
										else
											cndt.setPureGoldType(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[20] != null
												&& !obdataTemp[20]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[20]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setSilverWght(obdataTemp[20]
													.toString());
										else
											cndt.setSilverWght(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[21] != null
												&& !obdataTemp[21]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[21]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setStoneName(obdataTemp[21]
													.toString());
										else
											cndt.setStoneName(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[22] != null
												&& !obdataTemp[22]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[22]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setStoneWght(obdataTemp[22]
													.toString());
										else
											cndt.setStoneWght(Constant.NO_DATA_AVAILABLE);
										cndt.setDate(DateUtil
												.convertDateToIndianFormat(obdataTemp[23]
														.toString()));
										cndt.setTime(DateUtil
												.convertDateToIndianFormat(obdataTemp[24]
														.toString()));
										cndt.setSchemeStatus(Constant.SCHEME_COMPLETED_MSG);
										fullActionHistory.add(cndt);
									}
								}
							}
						} else if (obdata[1].toString().equalsIgnoreCase(
								Constant.CLIENT_SCHEME_SURRENDERED_WITHOUTPAY)
								|| obdata[1]
										.toString()
										.equalsIgnoreCase(
												Constant.CLIENT_SCHEME_SURRENDERED_WITHPAY)) {
							query.delete(0, query.length());
							query.append("select totalPurchaseOf,joingDate,matryAmmount,periodOfScheme,totalAmmountDeposite,totalAmount,totalInst,rewardType,cashInHand,jwlryType,"
									+ "adjstmntVlue,cashRtrn,cmpltnTime,dmdnRate,dmndValue,dmndWght,dmnndGoldType,goldValue,"
									+ "goldWght,pureGoldType,silverWght,stoneName,stoneWght,date,time from schemesurrenderedcompletereward where schemeId="
									+ (Integer) obdata[0] + "");
							List dataTemp = eventDao
									.executeAllSelectQuery(query.toString());
							if (dataTemp != null) {
								for (Iterator itTemp = dataTemp.iterator(); itTemp
										.hasNext();) {
									Object[] obdataTemp = (Object[]) itTemp
											.next();
									if (obdataTemp != null) {
										ClientSchemeLuckyDraw cndt = new ClientSchemeLuckyDraw();
										cndt.setTotalPurchaseOf(obdataTemp[0]
												.toString());
										cndt.setJoingDate(DateUtil
												.convertDateToIndianFormat(obdataTemp[1]
														.toString()));
										cndt.setMatryAmmount(obdataTemp[2]
												.toString());
										cndt.setPeriodOfScheme(obdataTemp[3]
												.toString());
										cndt.setTotalAmmountDeposite(obdataTemp[4]
												.toString());
										cndt.setTotalAmount(obdataTemp[5]
												.toString());
										cndt.setTotalInst(obdataTemp[6]
												.toString());
										cndt.setRewardType(obdataTemp[7]
												.toString());
										if (obdataTemp[8] != null
												&& !obdataTemp[8]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setCashInHand(obdataTemp[8]
													.toString());
										else
											cndt.setCashInHand(Constant.NO_DATA_AVAILABLE);
										if (obdataTemp[9] != null
												&& !obdataTemp[16]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[9]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setJwlryType(obdataTemp[9]
													.toString());
										else
											cndt.setJwlryType(Constant.NO_DATA_AVAILABLE);
										if (obdataTemp[10] != null
												&& !obdataTemp[10]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setAdjstmntVlue(obdataTemp[10]
													.toString());
										else
											cndt.setAdjstmntVlue(Constant.NO_DATA_AVAILABLE);
										if (obdataTemp[11] != null
												&& !obdataTemp[11]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setCashRtrn(obdataTemp[11]
													.toString());
										else
											cndt.setCashRtrn(Constant.NO_DATA_AVAILABLE);
										cndt.setCmpltnTime(DateUtil
												.convertDateToIndianFormat(obdataTemp[12]
														.toString()));

										if (obdataTemp[13] != null
												&& !obdataTemp[13]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setDmdnRate(obdataTemp[13]
													.toString());
										else
											cndt.setDmdnRate(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[14] != null
												&& !obdataTemp[14]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setDmndValue(obdataTemp[14]
													.toString());
										else
											cndt.setDmndValue(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[15] != null
												&& !obdataTemp[15]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setDmndWght(obdataTemp[15]
													.toString());
										else
											cndt.setDmndWght(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[16] != null
												&& !obdataTemp[16]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[16]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setDmnndGoldType(obdataTemp[16]
													.toString());
										else
											cndt.setDmnndGoldType(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[17] != null
												&& !obdataTemp[17]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[17]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setGoldValue(obdataTemp[17]
													.toString());
										else
											cndt.setGoldValue(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[18] != null
												&& !obdataTemp[18]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[18]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setGoldWght(obdataTemp[18]
													.toString());
										else
											cndt.setGoldWght(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[19] != null
												&& !obdataTemp[19]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[19]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setPureGoldType(obdataTemp[19]
													.toString());
										else
											cndt.setPureGoldType(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[20] != null
												&& !obdataTemp[20]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[20]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setSilverWght(obdataTemp[20]
													.toString());
										else
											cndt.setSilverWght(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[21] != null
												&& !obdataTemp[21]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[21]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setStoneName(obdataTemp[21]
													.toString());
										else
											cndt.setStoneName(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[22] != null
												&& !obdataTemp[22]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[22]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setStoneWght(obdataTemp[22]
													.toString());
										else
											cndt.setStoneWght(Constant.NO_DATA_AVAILABLE);
										cndt.setDate(DateUtil
												.convertDateToIndianFormat(obdataTemp[23]
														.toString()));
										cndt.setTime(DateUtil
												.convertDateToIndianFormat(obdataTemp[24]
														.toString()));
										cndt.setSchemeStatus(Constant.SCHEME_COMPLETED_WITH_SURRENDER);

										fullActionHistory.add(cndt);
									}
								}
							}
						} else if (obdata[1].toString().equalsIgnoreCase(
								Constant.CLIENT_SCHEME_LUCKDRAW_WITHOUTPAY)
								|| obdata[1]
										.toString()
										.equalsIgnoreCase(
												Constant.CLIENT_SCHEME_LUCKDRAW_WITHPAY)) {
							query.delete(0, query.length());
							query.append("select totalPurchaseOf,joingDate,matryAmmount,periodOfScheme,totalAmmountDeposite,totalAmount,totalInst,rewardType,"
									+ "cashInHand,jwlryType,adjstmntVlue,cashRtrn,cmpltnTime,dmdnRate,dmndValue,dmndWght,dmnndGoldType,goldValue,"
									+ "goldWght,pureGoldType,silverWght,stoneName,stoneWght,date,time from clientschemeluckydraw where schemeName="
									+ (Integer) obdata[0] + "");
							List dataTemp = eventDao
									.executeAllSelectQuery(query.toString());
							if (dataTemp != null) {
								for (Iterator itTemp = dataTemp.iterator(); itTemp
										.hasNext();) {
									Object[] obdataTemp = (Object[]) itTemp
											.next();
									if (obdataTemp != null) {
										ClientSchemeLuckyDraw cndt = new ClientSchemeLuckyDraw();
										cndt.setTotalPurchaseOf(obdataTemp[0]
												.toString());
										cndt.setJoingDate(DateUtil
												.convertDateToIndianFormat(obdataTemp[1]
														.toString()));
										cndt.setMatryAmmount(obdataTemp[2]
												.toString());
										cndt.setPeriodOfScheme(obdataTemp[3]
												.toString());
										cndt.setTotalAmmountDeposite(obdataTemp[4]
												.toString());
										cndt.setTotalAmount(obdataTemp[5]
												.toString());
										cndt.setTotalInst(obdataTemp[6]
												.toString());
										cndt.setRewardType(obdataTemp[7]
												.toString());
										if (obdataTemp[8] != null
												&& !obdataTemp[8]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setCashInHand(obdataTemp[8]
													.toString());
										else
											cndt.setCashInHand(Constant.NO_DATA_AVAILABLE);
										if (obdataTemp[9] != null
												&& !obdataTemp[16]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[9]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setJwlryType(obdataTemp[9]
													.toString());
										else
											cndt.setJwlryType(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[10] != null
												&& !obdataTemp[10]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setAdjstmntVlue(obdataTemp[10]
													.toString());
										else
											cndt.setAdjstmntVlue(Constant.NO_DATA_AVAILABLE);
										if (obdataTemp[11] != null
												&& !obdataTemp[11]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setCashRtrn(obdataTemp[11]
													.toString());
										else
											cndt.setCashRtrn(Constant.NO_DATA_AVAILABLE);
										cndt.setCmpltnTime(DateUtil
												.convertDateToIndianFormat(obdataTemp[12]
														.toString()));

										if (obdataTemp[13] != null
												&& !obdataTemp[13]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setDmdnRate(obdataTemp[13]
													.toString());
										else
											cndt.setDmdnRate(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[14] != null
												&& !obdataTemp[14]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setDmndValue(obdataTemp[14]
													.toString());
										else
											cndt.setDmndValue(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[15] != null
												&& !obdataTemp[15]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING))
											cndt.setDmndWght(obdataTemp[15]
													.toString());
										else
											cndt.setDmndWght(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[16] != null
												&& !obdataTemp[16]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[16]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setDmnndGoldType(obdataTemp[16]
													.toString());
										else
											cndt.setDmnndGoldType(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[17] != null
												&& !obdataTemp[17]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[17]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setGoldValue(obdataTemp[17]
													.toString());
										else
											cndt.setGoldValue(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[18] != null
												&& !obdataTemp[18]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[18]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setGoldWght(obdataTemp[18]
													.toString());
										else
											cndt.setGoldWght(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[19] != null
												&& !obdataTemp[19]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[19]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setPureGoldType(obdataTemp[19]
													.toString());
										else
											cndt.setPureGoldType(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[20] != null
												&& !obdataTemp[20]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[20]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setSilverWght(obdataTemp[20]
													.toString());
										else
											cndt.setSilverWght(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[21] != null
												&& !obdataTemp[21]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[21]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setStoneName(obdataTemp[21]
													.toString());
										else
											cndt.setStoneName(Constant.NO_DATA_AVAILABLE);

										if (obdataTemp[22] != null
												&& !obdataTemp[22]
														.toString()
														.equalsIgnoreCase(
																Constant.EMPTY_STRING)
												&& !obdataTemp[22]
														.toString()
														.equalsIgnoreCase(
																Constant.UI_DEFAULT_DROP_DOWN))
											cndt.setStoneWght(obdataTemp[22]
													.toString());
										else
											cndt.setStoneWght(Constant.NO_DATA_AVAILABLE);
										cndt.setDate(DateUtil
												.convertDateToIndianFormat(obdataTemp[23]
														.toString()));
										cndt.setTime(DateUtil
												.convertDateToIndianFormat(obdataTemp[24]
														.toString()));
										cndt.setSchemeStatus(Constant.SCHEME_COMPLETED_WITH_LUCKY_DRAW);

										fullActionHistory.add(cndt);
									}
								}
							}
						}
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
							+ "Problem in Over2Cloud  method actionFullDetail of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * As per BaseModel comments
	 * 
	 * @return
	 */
	public List<ClientReportPojo> getClientSearchData() {
		return clientSearchData;
	}

	public void setClientSearchData(List<ClientReportPojo> clientSearchData) {
		this.clientSearchData = clientSearchData;
	}

}
