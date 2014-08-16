package com.ctrl.xsgx.suvidha.backup;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ctrl.xsgx.common.BaseModel;
import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.suvidha.commonmaster.CommonMasterOper;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.CreateFolderOs;
import com.suvidha.common.DateUtil;

public class BackupProcess extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Log log = LogFactory.getLog(CommonMasterOper.class);

	/**
	 * 
	 */
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

	/**
	 * 
	 * @return
	 */
	public String takeBackup() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			StringBuilder query = new StringBuilder("show tables");
			List data = eventDao.executeAllSelectQuery(query.toString());
			CreateFolderOs cot = new CreateFolderOs();
			String folderName = cot.createUserDirBackup("");
			String sec = DateUtil.getCurrentDateIndianFormat().replaceAll("-",
					"_")
					+ DateUtil.getCurrentTime().replaceAll(":", "_");
			if (data != null) {
				for (Iterator it = data.iterator(); it.hasNext();) {
					Object obdata = (Object) it.next();
					if (obdata != null) {
						query.delete(0, query.length());
						String fileName = folderName + "\\" + obdata.toString()
								+ "___" + sec + ".csv";
						query.append("SELECT * INTO OUTFILE '" + fileName
								+ "' FIELDS TERMINATED BY ',' FROM "
								+ obdata.toString());
						String tempString = query.toString();
						List temp = eventDao.executeAllSelectQuery(tempString);

					}
				}
			}
			addActionMessage("Backup Downloaded at "
					+ folderName
					+ ", Kindly go there and collect them in a folder and delete all files.");
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method takeBackup of class " + getClass(),
					e);
			// e.printStackTrace();
			addActionError("Oops there is some problem in backup download, Contact Mr.Sandeep for problem fixing");
			return ERROR;
		}
		return SUCCESS;
	}

	public static void main(String[] args) {
		String executeCmd = "mysqldump -u suvidha_suvidha -psuvidha_suvidha --add-drop-database -B suvidha -r d:\backup.sql";
		Process runtimeProcess;
		try {

			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();

			if (processComplete == 0) {
				System.out.println("Backup created successfully");
			} else {
				System.out.println("Could not create the backup");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
