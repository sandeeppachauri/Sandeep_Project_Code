package com.ctrl.xsgx.suvidha.dailycollection;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.model.DailyCollectionUploadReportModel;
import com.ctrl.xsgx.suvidha.scheme.SchemeDao;
import com.databean.xsgx.suvidha.commonmaster.DailyCollectionDB;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateUtil;

@SuppressWarnings("rawtypes")
public class DailyCollectionUploadReport extends
		DailyCollectionUploadReportModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Log log = LogFactory.getLog(DailyCollectionUpload.class);

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

	public String fullDetailGoldPrice() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			clientsNames = new LinkedHashMap<String, String>();
			StringBuilder query = new StringBuilder(
					"select id,clientname from clientmaster order by clientname");
			List data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null && obdata[0] != null
							&& obdata[1] != null) {
						clientsNames.put(obdata[1].toString(),
								obdata[1].toString());
					}
				}
			}

			agentNames = new LinkedHashMap<String, String>();
			query.delete(0, query.length());
			query.append("select id,empname from emploee  order by empname");
			data = eventDao.executeAllSelectQuery(query.toString());
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					if (obdata != null && obdata[0] != null
							&& obdata[1] != null) {
						agentNames.put(obdata[1].toString(),
								obdata[1].toString());
					}
				}
			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method fullDetailGoldPrice of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String searchCollectionReport() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			setAgent(getAgent());
			setClient(getClient());
			setCardNo(getCardNo());
			setCollectionType(getCollectionType());
			setDateFrom(getDateFrom());
			setDateTo(getDateTo());
			setRecieptNo(getRecieptNo());
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method searchCollectionReport of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String searchCollectionReportView() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			List<String> fieldNames = new ArrayList<String>();
			fieldNames.add("id");
			fieldNames.add("accountType");
			fieldNames.add("agentCode");
			fieldNames.add("ammount");
			fieldNames.add("bankCash");
			fieldNames.add("cardNo");
			fieldNames.add("chequeNo");
			fieldNames.add("clientName");
			fieldNames.add("collectionDate");
			fieldNames.add("entryDate");
			fieldNames.add("recieptNo");

			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder("");
			query.append("select count(*) from dailycollectiondb where 1=1 ");

			if (getClient() != null
					&& !getClient().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getClient().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				query.append(" and clientName like '%" + getClient() + "%' ");
			}
			if (getAgent() != null
					&& !getAgent().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getAgent().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				query.append(" and agentCode like '%" + getAgent() + "%' ");
			}
			if (getCardNo() != null
					&& !getCardNo().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getCardNo().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				query.append(" and cardNo like '%" + getCardNo() + "%' ");
			}
			if (getCollectionType() != null
					&& !getCollectionType().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getCollectionType().equalsIgnoreCase(
							Constant.EMPTY_STRING)) {
				query.append(" and accountType like '%" + getCollectionType()
						+ "%' ");
			}
			if (getRecieptNo() != null
					&& !getRecieptNo().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getRecieptNo().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				query.append(" and recieptNo='" + getRecieptNo() + "' ");
			}

			if (getDateFrom() != null
					&& getDateTo() != null
					&& !getDateFrom().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getDateFrom().equalsIgnoreCase(Constant.EMPTY_STRING)
					&& !getDateTo().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getDateTo().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				query.append(" and collectionDate between '"
						+ DateUtil.convertDateToUSFormat(getDateFrom())
						+ "' and '"
						+ DateUtil.convertDateToUSFormat(getDateTo()) + "'");
			}
			List dataCount = eventDao.executeAllSelectQuery(query.toString());
			if (dataCount != null) {
				BigInteger count = new BigInteger("3");
				for (Iterator it = dataCount.iterator(); it.hasNext();) {
					Object obdata = (Object) it.next();
					count = (BigInteger) obdata;
				}
				setRecords(count.intValue());
			}
			int to = (getRows() * getPage());
			int from = to - getRows();
			if (to > getRecords())
				to = getRecords();

			query.delete(0, query.length());
			query.append("select * from dailycollectiondb where 1=1 ");

			if (getClient() != null
					&& !getClient().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getClient().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				query.append(" and clientName like '%" + getClient() + "%' ");
			}
			if (getAgent() != null
					&& !getAgent().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getAgent().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				query.append(" and agentCode like '%" + getAgent() + "%' ");
			}
			if (getCardNo() != null
					&& !getCardNo().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getCardNo().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				query.append(" and cardNo like '%" + getCardNo() + "%' ");
			}
			if (getCollectionType() != null
					&& !getCollectionType().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getCollectionType().equalsIgnoreCase(
							Constant.EMPTY_STRING)) {
				query.append(" and accountType like '%" + getCollectionType()
						+ "%' ");
			}
			if (getRecieptNo() != null
					&& !getRecieptNo().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getRecieptNo().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				query.append(" and recieptNo='" + getRecieptNo() + "' ");
			}

			if (getDateFrom() != null
					&& getDateTo() != null
					&& !getDateFrom().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getDateFrom().equalsIgnoreCase(Constant.EMPTY_STRING)
					&& !getDateTo().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& !getDateTo().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				query.append(" and collectionDate between '"
						+ DateUtil.convertDateToUSFormat(getDateFrom())
						+ "' and '"
						+ DateUtil.convertDateToUSFormat(getDateTo()) + "'");
			}

			if (getSord() != null
					&& !getSord().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				if (getSord().equals(Constant.ASC_ORDER) && getSidx() != null
						&& !getSidx().equals(Constant.EMPTY_STRING)) {
					query.append(" order by " + getSidx());
				}
				if (getSord().equals(Constant.DESC_ORDER) && getSidx() != null
						&& !getSidx().equals(Constant.EMPTY_STRING)) {
					query.append(" order by " + getSidx() + Constant.DESC_ORDER);
				}
			}
			query.append(" limit " + from + "," + to);

			userdata.put("agentCode", "Total Collection:");

			List data = eventDao.executeAllSelectQuery(query.toString());
			searchReportView = new ArrayList<DailyCollectionDB>();
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object[] obdata = (Object[]) it.next();
					DailyCollectionDB one = new DailyCollectionDB();
					// id,accountType,agentCode,ammount,bankCash,cardNo,chequeNo,clientName,collectionDate,entryDate,recieptNo,user
					one.setId((Integer) obdata[0]);
					if (obdata[1] != null)
						one.setAccountType(obdata[1].toString());
					else
						one.setAccountType(Constant.NO_DATA_AVAILABLE);
					if (obdata[2] != null)
						one.setAgentCode(obdata[2].toString());
					else
						one.setAgentCode(Constant.NO_DATA_AVAILABLE);
					if (obdata[3] != null)
						one.setAmmount(obdata[3].toString());
					else
						one.setAmmount(Constant.NO_DATA_AVAILABLE);
					if (obdata[4] != null)
						one.setBankCash(obdata[4].toString());
					else
						one.setBankCash(Constant.NO_DATA_AVAILABLE);
					if (obdata[5] != null)
						one.setCardNo(obdata[5].toString());
					else
						one.setCardNo(Constant.NO_DATA_AVAILABLE);
					if (obdata[6] != null)
						one.setChequeNo(obdata[6].toString());
					else
						one.setChequeNo(Constant.NO_DATA_AVAILABLE);
					if (obdata[7] != null)
						one.setClientName(obdata[7].toString());
					else
						one.setClientName(Constant.NO_DATA_AVAILABLE);
					if (obdata[8] != null)
						one.setCollectionDate(DateUtil
								.convertDateToIndianFormat(obdata[8].toString()));
					else
						one.setCollectionDate(Constant.NO_DATA_AVAILABLE);
					if (obdata[9] != null)
						one.setEntryDate(DateUtil
								.convertDateToIndianFormat(obdata[9].toString()));
					else
						one.setEntryDate(Constant.NO_DATA_AVAILABLE);
					if (obdata[10] != null)
						one.setRecieptNo(obdata[10].toString());
					else
						one.setRecieptNo(Constant.NO_DATA_AVAILABLE);

					if (obdata[12] != null)
						one.setMode(obdata[12].toString());
					else
						one.setMode(Constant.NO_DATA_AVAILABLE);
					searchReportView.add(one);
				}

				setTotal((int) Math.ceil((double) getRecords()
						/ (double) getRows()));
				query.delete(0, query.length());
				query.append("select sum(ammount) from dailycollectiondb  where 1=1 ");
				if (getClient() != null
						&& !getClient().equalsIgnoreCase(
								Constant.UI_DEFAULT_DROP_DOWN)
						&& !getClient().equalsIgnoreCase(Constant.EMPTY_STRING)) {
					query.append(" and clientName like '%" + getClient()
							+ "%' ");
				}
				if (getAgent() != null
						&& !getAgent().equalsIgnoreCase(
								Constant.UI_DEFAULT_DROP_DOWN)
						&& !getAgent().equalsIgnoreCase(Constant.EMPTY_STRING)) {
					query.append(" and agentCode like '%" + getAgent() + "%' ");
				}
				if (getCardNo() != null
						&& !getCardNo().equalsIgnoreCase(
								Constant.UI_DEFAULT_DROP_DOWN)
						&& !getCardNo().equalsIgnoreCase(Constant.EMPTY_STRING)) {
					query.append(" and cardNo like '%" + getCardNo() + "%' ");
				}
				if (getCollectionType() != null
						&& !getCollectionType().equalsIgnoreCase(
								Constant.UI_DEFAULT_DROP_DOWN)
						&& !getCollectionType().equalsIgnoreCase(
								Constant.EMPTY_STRING)) {
					query.append(" and accountType like '%"
							+ getCollectionType() + "%' ");
				}
				if (getRecieptNo() != null
						&& !getRecieptNo().equalsIgnoreCase(
								Constant.UI_DEFAULT_DROP_DOWN)
						&& !getRecieptNo().equalsIgnoreCase(
								Constant.EMPTY_STRING)) {
					query.append(" and recieptNo='" + getRecieptNo() + "' ");
				}

				if (getDateFrom() != null
						&& getDateTo() != null
						&& !getDateFrom().equalsIgnoreCase(
								Constant.UI_DEFAULT_DROP_DOWN)
						&& !getDateFrom().equalsIgnoreCase(
								Constant.EMPTY_STRING)
						&& !getDateTo().equalsIgnoreCase(
								Constant.UI_DEFAULT_DROP_DOWN)
						&& !getDateTo().equalsIgnoreCase(Constant.EMPTY_STRING)) {
					query.append(" and collectionDate between '"
							+ DateUtil.convertDateToUSFormat(getDateFrom())
							+ "' and '"
							+ DateUtil.convertDateToUSFormat(getDateTo()) + "'");
				}
				data = eventDao.executeAllSelectQuery(query.toString());
				if (data != null) {
					for (Iterator it = data.iterator(); it.hasNext();) {
						Object obdata = (Object) it.next();
						if (obdata != null)
							userdata.put("ammount", obdata.toString());
						else
							userdata.put("ammount", "0");
					}
				}
			}
			session.put("searchReportView", searchReportView);
			session.put("userdata", userdata);
			setTotal((int) Math
					.ceil((double) getRecords() / (double) getRows()));
		} catch (Exception e) {
			log.error(
					"Date : "
							+ DateUtil.getCurrentDateIndianFormat()
							+ " Time: "
							+ DateUtil.getCurrentTime()
							+ " "
							+ "Problem in   method searchCollectionReportView of class "
							+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String searchCollectionReportGraph() {
		try {

			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			if (getAgent().equalsIgnoreCase(Constant.UI_DEFAULT_DROP_DOWN)
					&& getClient().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& getDateFrom().equalsIgnoreCase(Constant.EMPTY_STRING)
					&& getDateTo().equalsIgnoreCase(Constant.EMPTY_STRING)) {

				pieDataMap = new TreeMap<String, Integer>();
				List cardDatList = new CommonHibernateOper()
						.executeAllSelectQuery("select distinct ammount from dailycollectiondb");
				if (cardDatList != null && cardDatList.size() > 0) {
					for (Iterator iterator = cardDatList.iterator(); iterator
							.hasNext();) {
						Object object = (Object) iterator.next();
						int i = 0;
						if (object != null) {
							i = new SchemeDao()
									.getGraphDataCounter("select count(*) from dailycollectiondb where ammount='"
											+ object.toString() + "'");
							pieDataMap.put("Rs:" + object.toString() + "(" + i
									+ ")", i);
							setGraphHeader("Pie Chart Showing Collection Order By Rs.");
						}
					}
				}
			} else if (getAgent().equalsIgnoreCase(
					Constant.UI_DEFAULT_DROP_DOWN)
					&& getClient().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)
					&& getDateFrom() != null
					&& !getDateFrom().equalsIgnoreCase(Constant.EMPTY_STRING)
					&& getDateTo() != null
					&& !getDateTo().equalsIgnoreCase(Constant.EMPTY_STRING)) {
				pieDataMap = new TreeMap<String, Integer>();
				List cardDatList = new CommonHibernateOper()
						.executeAllSelectQuery("select cardno from clientscheme");
				if (cardDatList != null && cardDatList.size() > 0) {
					for (Iterator iterator = cardDatList.iterator(); iterator
							.hasNext();) {
						Object object = (Object) iterator.next();
						int i = 0;
						if (object != null) {
							i = new SchemeDao()
									.getGraphDataCounter("select count(*) from dailycollectiondb where collectionDate between '"
											+ DateUtil
													.convertDateToUSFormat(getDateFrom())
											+ "' and '"
											+ DateUtil
													.convertDateToUSFormat(getDateTo())
											+ "' and cardNo='"
											+ object.toString() + "'");
							pieDataMap.put("Card No:" + object.toString() + "("
									+ i + ")", i);
							setGraphHeader("Pie Chart Showing Collection From "
									+ getDateFrom() + " To " + getDateTo()
									+ " Order By Card Numbers");
						}
					}
				}
			} else if (getClient() != null
					&& !getClient().equalsIgnoreCase(
							Constant.UI_DEFAULT_DROP_DOWN)) {
				pieDataMap = new TreeMap<String, Integer>();
				List cardDatList = new CommonHibernateOper()
						.executeAllSelectQuery("select * from clientcardmaster");
				if (cardDatList != null && cardDatList.size() > 0) {
					for (Iterator iterator = cardDatList.iterator(); iterator
							.hasNext();) {
						Object[] object = (Object[]) iterator.next();
						int i = 0;
						if (object != null) {
							i = new SchemeDao()
									.getGraphDataCounter("select count(*) from dailycollectiondb where clientName ='"
											+ getClient() + "'");
							pieDataMap.put("Card No:" + object[1].toString()
									+ "(" + i + ")", i);
							setGraphHeader("Pie Chart Showing Collection Done From Client "
									+ getClient());
						}
					}
				}

			}
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * As per BaseModel Comments
	 */

	public List<DailyCollectionDB> getSearchReportView() {
		return searchReportView;
	}

	public void setSearchReportView(List<DailyCollectionDB> searchReportView) {
		this.searchReportView = searchReportView;
	}

}
