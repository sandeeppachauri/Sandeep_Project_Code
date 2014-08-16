package com.ctrl.xsgx.data.entity.layer;

/**
 * @author Sandeep
 * 
 */
import java.util.Map;

import com.suvidha.common.CommonHibernateOper;

public interface ClientCtrlDao {

	/**
	 * 
	 * @param eventDao
	 * @return
	 */
	Map<Integer, String> getSourceData(CommonHibernateOper eventDao);

	/**
	 * 
	 * @param eventDao
	 * @return
	 */
	Map<Integer, String> getClientNameList(CommonHibernateOper eventDao);

	/**
	 * 
	 * @param eventDao
	 * @return
	 */
	Map<Integer, String> getAreaList(CommonHibernateOper eventDao);

	/**
	 * 
	 * @param eventDao
	 * @return
	 */
	Map<Integer, String> getScheme(CommonHibernateOper eventDao);

	/**
	 * 
	 * @param eventDao
	 * @return
	 */
	Map<Integer, String> getAgentList(CommonHibernateOper eventDao);

	/**
	 * 
	 * @param eventDao
	 * @param id
	 * @return
	 */
	Map<Integer, String> getOpenScheme(CommonHibernateOper eventDao, String id);

	/**
	 * 
	 * @param eventDao
	 * @param id
	 * @return
	 */
	Map<Integer, String> getCleintCloseScheme(CommonHibernateOper eventDao,
			String id);

	/**
	 * 
	 * @param eventDao
	 * @param id
	 * @return
	 */
	Map<Integer, String> getClientSchemeSurrender(CommonHibernateOper eventDao,
			String id);
	
	Map<String, String> getSchemeMappedWithClient(CommonHibernateOper eventDao,
			String id);
	
	/**
	 * 
	 * @param eventDao
	 * @return
	 */
	Map<Integer, String> getGroupScheme(CommonHibernateOper eventDao);
	
	Map<Integer, String> getGroupNames(CommonHibernateOper eventDao);

	Map<Integer, String> getOpenSchemeWithCardNumber(CommonHibernateOper eventDao, String id);
	
	Map<String, String> getSchemeMappedWithClientActiveLuckyDraw(CommonHibernateOper eventDao,
			String id);
}
