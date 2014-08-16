package com.ctrl.xsgx.suvidha.dailycollection;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.ctrl.xsgx.common.Constant;
import com.ctrl.xsgx.data.entity.layer.ClientCtrlDao;
import com.ctrl.xsgx.data.entity.layerimpl.ClientCtrlDaoImpl;
import com.ctrl.xsgx.model.DailyCollectionUploadModel;
import com.databean.xsgx.suvidha.commonmaster.DailyCollectionDB;
import com.suvidha.common.CommonHibernateOper;
import com.suvidha.common.DateUtil;
import com.suvidha.common.GenericReadBinaryExcel;
import com.suvidha.common.GenericReadExcel7;

public class DailyCollectionUpload extends DailyCollectionUploadModel {

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

	public String beforeUploadCollection() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			clientNameList = clientCtrlDao.getClientNameList(eventDao);

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method beforeUploadCollection of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String schemeMappedWithClient() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			ClientCtrlDao clientCtrlDao = new ClientCtrlDaoImpl();
			schemeNameList = clientCtrlDao.getSchemeMappedWithClientActiveLuckyDraw(eventDao, getId());
			
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method schemeMappedWithClient of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String dailyCollectionMannual() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}
			CommonHibernateOper eventDao = new CommonHibernateOper();
			int highRecord = eventDao.getRecordStatus(DailyCollectionDB.class);
			DailyCollectionDB dbc = new DailyCollectionDB();
			dbc.setAccountType(Constant.DEPOSTE_TYPE_ADVANCE);
			dbc.setAgentCode(getAgentName());
			dbc.setAmmount(getSubmitAmmount());
			dbc.setBankCash(getColctnMode());
			dbc.setCardNo(getCardNo());
			dbc.setChequeNo(getChequeNo());
			dbc.setClientName(getClientName());
			dbc.setCollectionDate(DateUtil
					.convertDateToUSFormat(getColelctionDate()));
			dbc.setEntryDate(DateUtil.getCurrentDateUSFormat());
			dbc.setMode(Constant.DEPOSITE_MODE_AT_SHOPE);
			dbc.setRecieptNo(Integer.toString(highRecord));
			dbc.setUser(userName);
			boolean status = eventDao.addDetails(dbc);
			if (status) {

				addActionMessage("Collection Submitted!!!");
			} else {
				addActionError("Oops there is some problem in collection!");
				return ERROR;

			}
		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method dailyCollectionMannual of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String uploadDailyCollection() {
		try {
			if (!Constant.VALID_USER.equalsIgnoreCase(checkUser())) {
				return LOGIN;
			}

			if (excel != null) {
				CommonHibernateOper eventDao = new CommonHibernateOper();
				InputStream inputStream = new FileInputStream(excel);
				if (excelFileName.contains(".xlsx")) {
					GenericReadExcel7 GRE7 = new GenericReadExcel7();
					// call method for getting excel sheet
					XSSFSheet excelSheet = GRE7.readExcel(inputStream);
					for (int rowIndex = 1; rowIndex < excelSheet
							.getPhysicalNumberOfRows(); rowIndex++) {
						XSSFRow row = excelSheet.getRow(rowIndex);
						int cellNo = row.getLastCellNum();
						DailyCollectionDB dailyCollection = new DailyCollectionDB();
						// Reciept No Collect Amount A/C No( Card No) Client
						// Name A/C Type Cheque No Collect Date Bank/Cash
						// Ag_Code
						if (cellNo > 0) {
							boolean status = true;
							for (int cellIndex = 0; cellIndex < cellNo; cellIndex++) {

								switch (cellIndex) {

								case 0:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setRecieptNo(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										status = false;
										break;
									}

								case 1:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setAmmount(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										status = false;
										break;
									}

								case 2:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setCardNo(GRE7.readExcelSheet(
														row, cellIndex));
										break;
									} else {
										status = false;
										break;
									}

								case 3:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setClientName(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										status = false;
										break;
									}
								case 4:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setAccountType(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										status = false;
										break;
									}

								case 5:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setChequeNo(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										dailyCollection
												.setChequeNo(Constant.NO_DATA_AVAILABLE);
										break;
									}

								case 6:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setCollectionDate(DateUtil
														.convertSQLDateInUsFormat(GRE7
																.readExcelSheet(
																		row,
																		cellIndex)));
										break;
									} else {
										status = false;
										break;
									}
								case 7:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setBankCash(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										dailyCollection
												.setBankCash(Constant.NO_DATA_AVAILABLE);
										break;
									}

								case 8:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setAgentCode(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										status = false;
										break;
									}

								}
							}

							// save here object
							if (status) {
								dailyCollection.setUser(userName);
								dailyCollection.setEntryDate(DateUtil
										.getCurrentDateUSFormat());
								eventDao.addDetails(dailyCollection);
							}
						}
					}
				}

				else if (excelFileName.contains(".xls")) {
					GenericReadBinaryExcel GRE7 = new GenericReadBinaryExcel();
					HSSFSheet excelSheet = GRE7.readExcel(inputStream);
					for (int rowIndex = 1; rowIndex <= excelSheet
							.getLastRowNum(); rowIndex++) {

						HSSFRow row = excelSheet.getRow(rowIndex);
						DailyCollectionDB dailyCollection = new DailyCollectionDB();
						int cellNo = row.getLastCellNum();
						if (cellNo > 0) {
							boolean status = true;
							// Reciept No Collect Amount A/C No( Card No) Client
							// Name A/C Type Cheque No Collect Date Bank/Cash
							// Ag_Code
							for (int cellIndex = 0; cellIndex < cellNo; cellIndex++) {
								// System.out.println(">>>>>"+GRE7.readExcelSheet(row,
								// cellIndex));
								switch (cellIndex) {

								case 0:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setRecieptNo(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										status = false;
										break;
									}

								case 1:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setAmmount(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										status = false;
										break;
									}

								case 2:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setCardNo(GRE7.readExcelSheet(
														row, cellIndex));
										break;
									} else {
										status = false;
										break;
									}

								case 3:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setClientName(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										status = false;
										break;
									}
								case 4:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setAccountType(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										status = false;
										break;
									}

								case 5:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setChequeNo(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										dailyCollection
												.setChequeNo(Constant.NO_DATA_AVAILABLE);
										break;
									}

								case 6:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setCollectionDate(DateUtil
														.convertSQLDateInUsFormat(GRE7
																.readExcelSheet(
																		row,
																		cellIndex)));
										break;
									} else {
										status = false;
										break;
									}
								case 7:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setBankCash(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										dailyCollection
												.setBankCash(Constant.NO_DATA_AVAILABLE);
										break;
									}

								case 8:
									if (GRE7.readExcelSheet(row, cellIndex) != null
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.NO_DATA_AVAILABLE)
											&& !GRE7.readExcelSheet(row,
													cellIndex)
													.equalsIgnoreCase(
															Constant.EMPTY_STRING)) {
										dailyCollection
												.setAgentCode(GRE7
														.readExcelSheet(row,
																cellIndex));
										break;
									} else {
										status = false;
										break;
									}

								}
							}
							if (status) {
								dailyCollection.setUser(userName);
								dailyCollection.setEntryDate(DateUtil
										.getCurrentDateUSFormat());
								eventDao.addDetails(dailyCollection);
							}
						}
					}
				}
				addActionMessage("Excel uploaded!!!");
			} else {
				addActionError("Oops there is some problem in excel upload");
				return ERROR;

			}

		} catch (Exception e) {
			log.error("Date : " + DateUtil.getCurrentDateIndianFormat()
					+ " Time: " + DateUtil.getCurrentTime() + " "
					+ "Problem in   method uploadDailyCollection of class "
					+ getClass(), e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
