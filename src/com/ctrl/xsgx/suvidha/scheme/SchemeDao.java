package com.ctrl.xsgx.suvidha.scheme;

import hibernate.common.HibernateSessionFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.databean.xsgx.suvidha.scheme.SchemeWithdraw;

public class SchemeDao {

	public int getGraphDataCounter(String qury) {
		int i = 0;
		Session session = null;
		List dataList = null;
		try {
			session = HibernateSessionFactory.getSession();
			Query qry = session.createSQLQuery(qury);
			dataList = qry.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				session.flush();
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
			Object object = (Object) iterator.next();
			if (object != null) {
				i = Integer.parseInt(object.toString());
			}
		}
		return i;
	}

	public SchemePojo getSchemeDetails(int schemeId) {
		SchemePojo pojo = new SchemePojo();
		List dataList = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			Query qry = session
					.createSQLQuery("select schme.id ,schme.schemeName, schme.schemeDesc,schmType.frequency,schmType.minPeriod,schmType.amount,schmType.totalAmount,schmType.contri, schmType.maturityAmount,schmType.withdrawable,schmType.luckyDraw, schmType.incremntal from scheme as schme inner join schemetype as schmType where schmType.schemeId=schme.id and schme.id='"
							+ schemeId + "'");
			dataList = qry.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				session.flush();
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (dataList != null && dataList.size() > 0) {
			for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();

				if (object[0] != null) {
					pojo.setId(Integer.parseInt(object[0].toString()));
				}

				if (object[1] != null) {
					pojo.setSchemeName((object[1].toString()));
				}

				if (object[2] != null) {
					pojo.setSchemeDesc((object[2].toString()));
				}

				if (object[3] != null) {
					pojo.setSchemeFrequency((object[3].toString()));
				}

				if (object[4] != null) {
					pojo.setMinPeriod((object[4].toString()));
				}

				if (object[5] != null) {
					pojo.setAmount((object[5].toString()));
				}

				if (object[6] != null) {
					pojo.setTotalAmount((object[6].toString()));
				}

				if (object[7] != null) {
					pojo.setOurContri((object[7].toString()));
				}

				if (object[8] != null) {
					pojo.setNetMaturity((object[8].toString()));
				}

				if (object[9] != null) {
					pojo.setWithdrawable((object[9].toString()));
				}

				if (object[10] != null) {
					pojo.setLuckyDraw((object[10].toString()));
				}

				/*
				 * if (object[11] != null) { pojo.set((object[11].toString()));
				 * }
				 */

				pojo.setWthdrwCondtn("View Condition");
			}
		}
		return pojo;
	}

	public List<SchemeWithdraw> getWithdrawCondition(int schemeId) {
		List<SchemeWithdraw> tempList = new ArrayList<SchemeWithdraw>();
		Session session = null;
		List dataList = null;
		try {
			session = HibernateSessionFactory.getSession();
			Query qry = session
					.createSQLQuery("select id,maxPeriod,minPeriod,withType,widraw,paymentAfter from schemewithdraw where schemeId='"
							+ schemeId + "'");
			dataList = qry.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				session.flush();
				session.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (dataList != null && dataList.size() > 0) {
			for (Iterator iterator = dataList.iterator(); iterator.hasNext();) {
				SchemeWithdraw with = new SchemeWithdraw();
				Object[] object = (Object[]) iterator.next();

				if (object[0] != null) {
					with.setId(Integer.parseInt(object[0].toString()));
					with.setMaxPeriod(object[1].toString());
					with.setMinPeriod(object[2].toString());
					with.setWithType(object[3].toString());
					with.setWidraw(object[4].toString());
					with.setPaymentAfter(object[5].toString());
				}

				tempList.add(with);
			}
		}
		return tempList;
	}

	public String getSchemeType(String propName, String tableName,
			String searchColName, String searchValue) {
		List schemeList = new ArrayList();
		String resultVal = null;
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			String deptall = "select " + propName + " from " + tableName
					+ " where " + searchColName + "='" + searchValue + "'";
			Query query = session.createSQLQuery(deptall);
			schemeList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

		List<SchemePojo> allSchemeList = new ArrayList<SchemePojo>();
		if (schemeList != null && schemeList.size() > 0) {

			for (Iterator iterator = schemeList.iterator(); iterator.hasNext();) {
				Object object = (Object) iterator.next();
				if (object != null) {
					resultVal = object.toString();
				}
			}
		}
		return resultVal;
	}

	public List<SchemePojo> getSchemeAll(String columnName, String columnValue) {
		List schemeList = new ArrayList();
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			StringBuilder deptall = new StringBuilder(
					"select id, schemeName from scheme ORDER BY schemeName ASC");
			if (columnName != null && columnValue != null) {
				deptall.delete(0, deptall.length());
				deptall.append("select sch.id,sch.schemeName from scheme as sch left join schemetype as schtype on sch.id=schtype.schemeId "
						+ "where schtype." + columnName + "='Yes'");
			}
			Query query = session.createSQLQuery(deptall.toString());
			schemeList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

		List<SchemePojo> allSchemeList = new ArrayList<SchemePojo>();
		if (schemeList != null && schemeList.size() > 0) {

			for (Iterator iterator = schemeList.iterator(); iterator.hasNext();) {
				Object[] object = (Object[]) iterator.next();
				if (object[0] != null && object[1] != null) {
					SchemePojo schemebean = new SchemePojo();
					schemebean.setId(Integer.parseInt(object[0].toString()));
					schemebean.setSchemeName(object[1].toString().toString());
					allSchemeList.add(schemebean);
				}
			}
		}
		return allSchemeList;
	}

	public static void main(String args[]) {
		SchemeDao dao = new SchemeDao();
		System.out.println("<>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+ dao.getSchemeDetails(1));
	}

}