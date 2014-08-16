package com.suvidha.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.databean.xsgx.suvidha.commonmaster.DailyCollectionDB;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadReport extends ActionSupport {

	private String downloadType;
	private String downloadFile;
	private String[] titles;
	private InputStream excelStream;
	Map session = ActionContext.getContext().getSession();
	private String mapName;

	public String downloadReport() {
		String returnResult = SUCCESS;
		try {
			if (getMapName() != null
					&& getMapName().trim().equalsIgnoreCase("dailySales"))// for
																			// daily
																			// collection
			{
				List<DailyCollectionDB> downloadAbleData = (List<DailyCollectionDB>) session
						.get("searchReportView");
				if (downloadAbleData != null && downloadAbleData.size() > 0) {

					/* Create Excel Code */
					if (downloadType != null
							&& downloadType.equals("downloadExcel")) {
						String storeFilePathPic = new CreateFolderOs()
								.createUserDir("excel");
						GenericWriteExcel writeExcel = new GenericWriteExcel();
						downloadFile = writeExcel.createExcel(
								getText("downloadSheet"), downloadAbleData,
								titles, "dailySales", storeFilePathPic,
								"DailyCollectionReport");
					}

					excelStream = new FileInputStream(downloadFile);
				}
			}

			if (downloadFile != null && !downloadFile.equals("")) {
				downloadFile = downloadFile.substring(downloadFile
						.lastIndexOf(File.separator));
				returnResult = SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return returnResult;
	}

	public String getDownloadType() {
		return downloadType;
	}

	public void setDownloadType(String downloadType) {
		this.downloadType = downloadType;
	}

	public String getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(String downloadFile) {
		this.downloadFile = downloadFile;
	}

	public String[] getTitles() {
		return titles;
	}

	public void setTitles(String[] titles) {
		this.titles = titles;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

}
