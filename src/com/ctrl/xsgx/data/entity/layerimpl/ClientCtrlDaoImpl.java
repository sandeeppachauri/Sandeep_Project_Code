package com.ctrl.xsgx.data.entity.layerimpl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.data.entity.layer.ClientCtrlDao;
import com.databean.xsgx.suvidha.commonmaster.SourceDB;
import com.suvidha.common.CommonHibernateOper;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ClientCtrlDaoImpl implements ClientCtrlDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ctrl.xsgx.data.entity.layer.ClientCtrlDao#getSourceData(com.suvidha
	 * .common.CommonHibernateOper)
	 */
	public Map<Integer, String> getSourceData(CommonHibernateOper eventDao) {
		Map<Integer, String> sourceData = new HashMap<Integer, String>();
		List<SourceDB> sourceDataTemp = (List<SourceDB>) eventDao
				.getDropdownvalue("sourceName", SourceDB.class);
		if (sourceDataTemp != null) {
			for (SourceDB sd : sourceDataTemp) {
				sourceData.put(sd.getId(), sd.getSourceName());
			}
		}

		return sourceData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ctrl.xsgx.data.entity.layer.ClientCtrlDao#getClientNameList(com.suvidha
	 * .common.CommonHibernateOper)
	 */
	public Map<Integer, String> getClientNameList(CommonHibernateOper eventDao) {
		Map<Integer, String> clientNameList = new LinkedHashMap<Integer, String>();
		StringBuilder query = new StringBuilder(
				"select id,clientname from clientmaster where activeStatus=1 order by clientname");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					clientNameList.put((Integer) obdata[0],
							obdata[1].toString());
				}
			}
		}
		return clientNameList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ctrl.xsgx.data.entity.layer.ClientCtrlDao#getAreaList(com.suvidha
	 * .common.CommonHibernateOper)
	 */
	public Map<Integer, String> getAreaList(CommonHibernateOper eventDao) {
		Map<Integer, String> areaList = new LinkedHashMap<Integer, String>();
		StringBuilder query = new StringBuilder(
				"select id,areaname from areamaster order by areaname");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					areaList.put((Integer) obdata[0], obdata[1].toString());
				}
			}
		}

		return areaList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ctrl.xsgx.data.entity.layer.ClientCtrlDao#getScheme(com.suvidha.common
	 * .CommonHibernateOper)
	 */
	@Override
	public Map<Integer, String> getScheme(CommonHibernateOper eventDao) {
		Map<Integer, String> schemeNameList = new LinkedHashMap<Integer, String>();
		StringBuilder query = new StringBuilder(
				"select id,schemeName from scheme order by schemeName");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					schemeNameList.put((Integer) obdata[0],
							obdata[1].toString());
				}
			}
		}
		return schemeNameList;
	}

	@Override
	public Map<Integer, String> getAgentList(CommonHibernateOper eventDao) {
		Map<Integer, String> agentNameList = new LinkedHashMap<Integer, String>();
		StringBuilder query = new StringBuilder(
				"select id,empname from emploee  order by empname");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					agentNameList
							.put((Integer) obdata[0], obdata[1].toString());
				}
			}
		}
		return agentNameList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ctrl.xsgx.data.entity.layer.ClientCtrlDao#getOpenScheme(com.suvidha
	 * .common.CommonHibernateOper)
	 */
	@Override
	public Map<Integer, String> getOpenScheme(CommonHibernateOper eventDao,
			String id) {
		StringBuilder query = new StringBuilder("");
		Map<Integer, String> schemeNameList = new LinkedHashMap<Integer, String>();
		query.append("select cscheme.id,schem.schemeName  from scheme as schem inner join clientscheme as cscheme on cscheme.schemeId=schem.id  "
				+ "where cscheme.clientId="
				+ id
				+ " and cscheme.schemeStatus="
				+ Constant.CLIENT_SCHEME_ACTIVE + " order by schem.schemeName");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					schemeNameList.put((Integer) obdata[0],
							obdata[1].toString());
				}
			}
		}
		return schemeNameList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ctrl.xsgx.data.entity.layer.ClientCtrlDao#getCleintCloseScheme(com
	 * .suvidha.common.CommonHibernateOper, java.lang.String)
	 */
	@Override
	public Map<Integer, String> getCleintCloseScheme(
			CommonHibernateOper eventDao, String id) {
		StringBuilder query = new StringBuilder("");
		Map<Integer, String> schemeNameList = new LinkedHashMap<Integer, String>();
		query.append("select cscheme.id,schem.schemeName  from scheme as schem inner join clientscheme as cscheme on cscheme.schemeId=schem.id  "
				+ "where cscheme.clientId="
				+ id
				+ " and cscheme.schemeStatus="
				+ Constant.CLIENT_SCHEME_COMPLETED_WITHOUTPAY
				+ " order by schem.schemeName");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					schemeNameList.put((Integer) obdata[0],
							obdata[1].toString());
				}
			}
		}
		return schemeNameList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ctrl.xsgx.data.entity.layer.ClientCtrlDao#getClientSchemeSurrender
	 * (com.suvidha.common.CommonHibernateOper, java.lang.String)
	 */
	@Override
	public Map<Integer, String> getClientSchemeSurrender(
			CommonHibernateOper eventDao, String id) {
		Map<Integer, String> schemeNameList = new LinkedHashMap<Integer, String>();
		StringBuilder query = new StringBuilder("");
		schemeNameList = new LinkedHashMap<Integer, String>();
		query.append("select cscheme.id,schem.schemeName  from scheme as schem inner join clientscheme as cscheme on cscheme.schemeId=schem.id  "
				+ "where cscheme.clientId="
				+ id
				+ " and cscheme.schemeStatus="
				+ Constant.CLIENT_SCHEME_SURRENDERED_WITHOUTPAY
				+ " order by schem.schemeName");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					schemeNameList.put((Integer) obdata[0],
							obdata[1].toString());
				}
			}
		}
		return schemeNameList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ctrl.xsgx.data.entity.layer.ClientCtrlDao#getSchemeMappedWithClient
	 * (com.suvidha.common.CommonHibernateOper, java.lang.String)
	 */
	@Override
	public Map<String, String> getSchemeMappedWithClient(
			CommonHibernateOper eventDao, String id) {
		Map<String, String> schemeNameList = new LinkedHashMap<String, String>();
		StringBuilder query = new StringBuilder(
				"select cscheme.cardNo,schem.schemeName,cmaster.clientname,emp.empname,cstype.amount  from scheme as"
						+ " schem inner join clientscheme as cscheme on cscheme.schemeId=schem.id  "
						+ "inner join clientmaster as cmaster on cmaster.id=cscheme.clientId "
						+ "inner join clientagentmapping as cmapping on  cmapping.clientId=cscheme.clientId "
						+ "inner join emploee as emp on emp.id=cmapping.agentId  "
						+ "inner join schemetype as cstype on cstype.schemeId=cscheme.schemeId "
						+ "where cscheme.clientId="
						+ id
						+ " and cscheme.schemeStatus="
						+ Constant.CLIENT_SCHEME_ACTIVE
						+ " order by schem.schemeName");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					schemeNameList.put(
							obdata[0].toString() + "#" + obdata[2].toString()
									+ "#" + obdata[3].toString() + "#"
									+ obdata[4].toString(),
							obdata[1].toString());
				}
			}
		}
		return schemeNameList;
	}

	@Override
	public Map<Integer, String> getGroupScheme(CommonHibernateOper eventDao) {
		Map<Integer, String> schemeNameList = new LinkedHashMap<Integer, String>();
		StringBuilder query = new StringBuilder(
				"select id,schemeName from scheme where groupAble='"
						+ Constant.IS_GROUPABLE_SCHEME
						+ "' order by schemeName");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					schemeNameList.put((Integer) obdata[0],
							obdata[1].toString());
				}
			}
		}
		return schemeNameList;
	}

	@Override
	public Map<Integer, String> getGroupNames(CommonHibernateOper eventDao) {
		Map<Integer, String> schemeNameList = new LinkedHashMap<Integer, String>();
		StringBuilder query = new StringBuilder(
				"select id,groupName from groupmaster order by groupName");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					schemeNameList.put((Integer) obdata[0],
							obdata[1].toString());
				}
			}
		}
		return schemeNameList;
	}

	@Override
	public Map<Integer, String> getOpenSchemeWithCardNumber(
			CommonHibernateOper eventDao, String id) {
		StringBuilder query = new StringBuilder("");
		Map<Integer, String> schemeNameList = new LinkedHashMap<Integer, String>();
		query.append("select id,cardno from clientscheme where schemeStatus="
				+ Constant.CLIENT_SCHEME_ACTIVE + " and clientId =" + id
				+ " order by id");
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					schemeNameList.put((Integer) obdata[0],
							obdata[1].toString());
				}
			}
		}
		return schemeNameList;
	}
	
	public Map<String, String> getSchemeMappedWithClientActiveLuckyDraw(
			CommonHibernateOper eventDao, String id) {
		Map<String, String> schemeNameList = new LinkedHashMap<String, String>();
		StringBuilder query = new StringBuilder(
				"select cscheme.cardNo,schem.schemeName,cmaster.clientname,emp.empname,cstype.amount  from scheme as"
						+ " schem inner join clientscheme as cscheme on cscheme.schemeId=schem.id  "
						+ "inner join clientmaster as cmaster on cmaster.id=cscheme.clientId "
						+ "inner join clientagentmapping as cmapping on  cmapping.clientId=cscheme.clientId "
						+ "inner join emploee as emp on emp.id=cmapping.agentId  "
						+ "inner join schemetype as cstype on cstype.schemeId=cscheme.schemeId "
						+ "where cscheme.clientId="
						+ id
						+ " and cscheme.schemeStatus="
						+ Constant.CLIENT_SCHEME_ACTIVE
						+ " or cscheme.schemeStatus="
						+ Constant.CLIENT_SCHEME_LUCKDRAW_WITHOUTPAY
						+ " order by schem.schemeName");
		System.out.println(query.toString());
		List data = eventDao.executeAllSelectQuery(query.toString());
		if (data != null) {
			for (Iterator it = data.iterator(); it.hasNext();) {
				Object[] obdata = (Object[]) it.next();
				if (obdata != null && obdata[0] != null && obdata[1] != null) {
					schemeNameList.put(
							obdata[0].toString() + "#" + obdata[2].toString()
									+ "#" + obdata[3].toString() + "#"
									+ obdata[4].toString(),
							obdata[1].toString());
				}
			}
		}
		return schemeNameList;
	}
}
