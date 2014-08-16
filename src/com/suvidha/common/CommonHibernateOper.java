package com.suvidha.common;

import hibernate.common.HibernateSessionFactory;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.SQLGrammarException;

public class CommonHibernateOper {

	static final Log log = LogFactory.getLog(CommonHibernateOper.class);

	public boolean addDetails(Object objct) {
		Session session = null;
		boolean flag = true;
		try {
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			session.save(objct);
			tx.commit();
		} catch (Exception e) {
			flag = false;
			log.error(
					"ActionDAO::AbstractCommonOperation && Method:addDetails()",
					e);
		} finally {
			session.flush();
			session.close();
		}
		return flag;
	}

	public boolean UpdateDetails(Object UpdateObject) {
		Session session = null;
		boolean flag = true;
		try {
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			session.update(UpdateObject);
			tx.commit();
		} catch (Exception e) {
			flag = false;
			log.error(
					"ActionDAO::AbstractCommonOperation && Method:UpdateDetails()",
					e);
		} finally {

			session.flush();
			session.close();
		}
		return flag;
	}

	public boolean DeleteRecord(Object ObjectOfRecord, Class cCls) {
		Session session = null;
		boolean flag = true;
		try {
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(cCls);
			session.delete(ObjectOfRecord);
			tx.commit();
		} catch (Exception e) {
			flag = false;
			log.error(
					"ActionDAO::AbstractCommonOperation && Method:DeleteRecord()",
					e);
		} finally {
			session.flush();
			session.close();
		}
		return flag;

	}

	public int getRecordStatus(Class cCls) {
		Session GVCSess = null;
		Criteria GVCCriteria = null;
		List GVCList = null;
		int rowCount = 0;
		try {
			GVCSess = HibernateSessionFactory.getSession();
			GVCCriteria = GVCSess.createCriteria(cCls.getName());
			GVCCriteria.setProjection(Projections.rowCount());
			GVCList = GVCCriteria.list();
			if (GVCList != null && GVCList.size() > 0)
				rowCount = Integer.parseInt(GVCList.get(0).toString());
		} catch (Exception e) {
			log.error(
					"AbstractCommonOperation::AssetsDaoImpl && Method:getRecordStatus()",
					e);
		} finally {
			try {
				HibernateSessionFactory.closeSession();
			} catch (Exception e2) {
				log.error(
						"AbstractCommonOperation::AssetsDaoImpl && Method_Finally_Block:getRecordStatus()",
						e2);
			}
		}
		return rowCount;
	}

	public List ServicesviewData(int to, int from, String SearchField,
			String SearchString, String SearchOperation, String SortType,
			String GetRowTypeSorting, Class cCls) {
		final Log log = LogFactory.getLog(cCls.getName());
		List Servicesobjects = null;
		Criteria criteria = null;
		try {
			Session session = HibernateSessionFactory.getSession();
			criteria = session.createCriteria(cCls.getName());
			if (!GetRowTypeSorting.equals("")) {
				if (SortType.equals("asc")) {
					criteria.addOrder(Order.asc(GetRowTypeSorting));
				}
				if (SortType.equals("desc")) {
					criteria.addOrder(Order.desc(GetRowTypeSorting));
				}
			}
			if (SearchOperation != null && !SearchOperation.equals("")) {
				if (SearchOperation.equals("eq")) {
					criteria.add(Restrictions.eq(SearchField, SearchString));
				}
				if (SearchOperation.equals("cn")) {
					criteria.add(Restrictions.ilike(SearchField, "%"
							+ SearchString + "%"));
				}
				if (SearchOperation.equals("bw")) {
					criteria.add(Restrictions.ilike(SearchField, SearchString
							+ "%"));
				}
				if (SearchOperation.equals("ne")) {
					criteria.add(Restrictions.ne(SearchField, SearchString));
				}
				if (SearchOperation.equals("ew")) {
					criteria.add(Restrictions.ilike(SearchField, "%"
							+ SearchString));
				}
			}
			criteria.setFirstResult(to);
			criteria.setFirstResult(from);
			Servicesobjects = criteria.list();
		} catch (Exception e) {
			log.error(
					"ActionDAO::AbstractCommonOperation && Method:ServicesviewData()Class Dyanmic:::"
							+ cCls + ":::", e);
		} finally {
			try {
				HibernateSessionFactory.closeSession();
			} catch (Exception e2) {
				log.error(
						"@ERP::>> ActionDAO::AssetsDaoImpl && Method_Finally_Block:ServicesviewData()"
								+ cCls + ":::", e2);
			}
		}
		return Servicesobjects;
	}

	public Object findRecordForPk(int id, Class cCls) {
		SessionFactory sf = null;
		Session ses = null;
		Object obj = null;
		try {
			ses = HibernateSessionFactory.getSession();
			// here we are using load method of hibernate for Lazy loading
			obj = ses.load(cCls.getName(), id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ses.flush();
				ses.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return obj;
	}

	public List getDropdownvalueEKAName(String ParameterPass, Object ID,
			Class cCls) {
		Session session = null;
		List tempList = null;
		try {
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(cCls.getName());
			criteria.add(Restrictions.eq(ParameterPass, ID));
			tempList = criteria.list();
			tx.commit();
		} catch (Exception e) {
			log.error(
					" ActionDAO::AbstractCommonOperation && Method:getDropdownvalue()",
					e);
		} finally {
			session.flush();
			session.close();
		}
		return tempList;
	}

	public List getDropdownvalue(String ParameterPass, Class cCls) {
		Session session = null;
		List tempList = null;
		try {
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(cCls.getName());
			criteria.addOrder(Order.asc(ParameterPass));
			// criteria.add(Restrictions.eq("User",User));
			tempList = criteria.list();
			tx.commit();
		} catch (Exception e) {
			log.error(
					"ActionDAO::AbstractCommonOperation && Method:getDropdownvalue()",
					e);
		} finally {
			session.flush();
			session.close();
		}
		return tempList;
	}

	public List executeAllSelectQuery(String query) {
		List Data = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			Data = session.createSQLQuery(query).list();
			transaction.commit();
			session.close();
		} catch (SQLGrammarException ex) {
			// ex.printStackTrace();
			transaction.rollback();
			session.close();
		} catch (Exception ex) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in  method executeAllSelectQuery() of class "
					+ getClass(), ex);
			// ex.printStackTrace();
			transaction.rollback();
		}
		return Data;
	}

	public void executeTrans(String query) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.createSQLQuery(query).executeUpdate();
			transaction.commit();
			session.close();
		} catch (SQLGrammarException ex) {
			// ex.printStackTrace();
			transaction.rollback();
			session.close();
		} catch (Exception ex) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in  method executeAllSelectQuery() of class "
					+ getClass(), ex);
			// ex.printStackTrace();
			transaction.rollback();
		}
	}

	public List getDropdownvalue(String ParameterPass, String ID, Class cCls) {
		Session session = null;
		List tempList = null;
		try {
			session = HibernateSessionFactory.getSession();
			Transaction tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(cCls.getName());
			criteria.add(Restrictions.eq(ParameterPass, ID));
			tempList = criteria.list();
			tx.commit();
		} catch (Exception e) {
			log.error(
					"@ERP::>> ActionDAO::AbstractCommonOperation && Method:getDropdownvalue()",
					e);
		} finally {
			session.flush();
			session.close();
		}
		return tempList;
	}
}
