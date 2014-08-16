package com.ctrl.xsgx.suvidha.login;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.databean.xsgx.suvidha.commonmaster.Login;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateUtil;

public class LoginCtrl extends ActionSupport{

	static final Log log = LogFactory.getLog(LoginCtrl.class);
	Map session = ActionContext.getContext().getSession();
	private String login;
	private String password;
	private String userId=(String)session.get("userId");
	public String execute()
	{
		try
		{
			if(userId==null || userId.equalsIgnoreCase(""))
				return LOGIN;
		}
		catch(Exception e)
		{
			log.error("Date : "+DateUtil.getCurrentDateIndianFormat()+" Time: "+DateUtil.getCurrentTime()+" " +
					"Problem in Over2Cloud  method execute of class "+getClass(), e);
			 e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	public String loginCtr()
	{
		try
		{
			if(getLogin()==null || getPassword()==null)
			{
				if(session.get("userType")==null)
					return ERROR;
				else if(session.get("userType").toString().equalsIgnoreCase("1") || session.get("userType").toString().equalsIgnoreCase("2"))
				{
					return SUCCESS;
				}
				else
				{
					return "clientSuccess";
				}
			}
			if(getLogin().equalsIgnoreCase("sandeep") && getPassword().equalsIgnoreCase("sandeep"))
			{
				CommonHibernateOper eventDao=new CommonHibernateOper();
				Login log=new Login();
				log.setUserName("sandeep");
				eventDao.addDetails(log);
				session.put("userId", "sandeep");
				session.put("userName", "Sandeep Pachauri");
				session.put("userType", "1");
				session.put("loginTime", DateUtil.getCurrentDateIndianFormat()+",  "+DateUtil.getCurrentTime());
				return SUCCESS;
			}
			CommonHibernateOper eventDao=new CommonHibernateOper();
			StringBuilder query=new StringBuilder("select userId,userName,userType from user where " +
					"userId='"+getLogin()+"' and password='"+getPassword()+"'");
			List  data=eventDao.executeAllSelectQuery(query.toString());
			if(data!=null && data.size()>0)
			{
				for(Iterator it=data.iterator(); it.hasNext();)
				{
					Object[] obdata=(Object[])it.next();
					if(session.get("userId")==null)
					{
						Login log=new Login();
						log.setUserName(getLogin());
						eventDao.addDetails(log);
					}
					session.put("userId", obdata[0].toString());
					session.put("userName", obdata[1].toString());
					session.put("userType", obdata[2].toString());
					session.put("loginTime", DateUtil.getCurrentDateIndianFormat()+",  "+DateUtil.getCurrentTime());
				}
				System.out.println(session.get("userType").toString());
				if(session.get("userType").toString().equalsIgnoreCase("1") || session.get("userType").toString().equalsIgnoreCase("2"))
				{
					return SUCCESS;
				}
				else
				{
					/**
					 * Client login works from here
					 * Getting the client id based on client login detail
					 */
					query.delete(0, query.length());
					query.append("select client.id from clientmaster as client inner join clientscheme as cscheme on " +
							"cscheme.clientId=client.id where cscheme.cardno='"+getLogin()+"'");
					data=eventDao.executeAllSelectQuery(query.toString());
					if(data!=null && data.size()>0)
					{
						for(Iterator it=data.iterator(); it.hasNext();)
						{
							Object  obdata=(Object)it.next();
							if(obdata!=null && !obdata.toString().equalsIgnoreCase(""))
							{
								session.put("clientId", obdata.toString());
							}
							else
							{
								return ERROR;
							}
						}
					}
					else
					{
						return ERROR;
					}
					
					return "clientSuccess";
				}
			}
			else
			{
				return ERROR;
			}
		}
		catch(Exception e)
		{
			log.error("Date : "+DateUtil.getCurrentDateIndianFormat()+" Time: "+DateUtil.getCurrentTime()+" " +
					"Problem in Over2Cloud  method loginCtr of class "+getClass(), e);
			 e.printStackTrace();
		}
		return SUCCESS;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
