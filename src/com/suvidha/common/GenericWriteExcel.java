package com.suvidha.common;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenericWriteExcel {

	public GenericWriteExcel() {
		// System.out.println("Inside Generic Write Excel File");
	}

	// Method For Creating an Excel File
	public String createExcel(String sheetString, List data,
			String[] headerTitles, String titleKey, String filePath,
			String excelName) {

		String file = null;
		Workbook wb;
		int col = 0;

		try {
			if (headerTitles != null && headerTitles.length > 0)
				col = headerTitles.length;

			wb = new HSSFWorkbook();

			Map<String, String> titleMap = new CommonPropertyMap()
					.getTitles(titleKey);

			Map<String, CellStyle> styles = createStyles(wb);
			Sheet sheet = wb.createSheet(sheetString);
			PrintSetup printSetup = sheet.getPrintSetup();
			printSetup.setLandscape(true);
			sheet.setFitToPage(true);
			sheet.setHorizontallyCenter(true);

			Header header = sheet.getHeader();
			header.setLeft("Left Header");
			header.setRight("Right Footer");
			header.setCenter("Center Header");

			Footer footer = sheet.getFooter();
			footer.setLeft("left footer");
			footer.setRight("right footer");
			footer.setCenter("center footer");

			// Title Row
			Row titleRow = sheet.createRow(0);
			titleRow.setHeightInPoints(20);
			Cell titleCell = titleRow.createCell(0);
			titleCell.setCellValue(excelName);
			titleCell.setCellStyle(styles.get("title"));
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, col - 1));

			// Sub Title Row
			/*
			 * Row subTitleRow = sheet.createRow(1);
			 * subTitleRow.setHeightInPoints(18); Cell subTitleCell =
			 * subTitleRow.createCell(0);
			 * subTitleCell.setCellValue(subTitleString);
			 * subTitleCell.setCellStyle(styles.get("subTitle"));
			 * sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, col - 1));
			 */

			//
			Row headerRow = sheet.createRow(2);
			headerRow.setHeightInPoints(15);
			Cell headerCell = null;
			if (headerTitles != null) {
				for (int titleIndex = 0; titleIndex < headerTitles.length; titleIndex++) {
					headerCell = headerRow.createCell(titleIndex);
					headerCell.setCellValue(titleMap
							.get(headerTitles[titleIndex]));
					headerCell.setCellStyle(styles.get("header"));

				}
			}
			Row dataRow = null;
			Cell dataCell = null;

			int rowIndex = 3;

			if (data != null && data.size() > 0) {
				for (Iterator iterator = data.iterator(); iterator.hasNext();) {
					Object classType = iterator.next();
					dataRow = sheet.createRow(rowIndex);

					for (int cellIndex = 0; cellIndex < headerTitles.length; cellIndex++) {
						dataCell = dataRow.createCell(cellIndex);

						if (PropertyUtils.getProperty(classType,
								headerTitles[cellIndex]) != null)
							dataCell.setCellValue(PropertyUtils.getProperty(
									classType, headerTitles[cellIndex])
									.toString());
						else
							dataCell.setCellValue("NA");
						dataCell.setCellStyle(styles.get("cell"));

					}
					rowIndex++;

				}
			}

			for (int titleIndex = 0; titleIndex < headerTitles.length; titleIndex++)
				sheet.autoSizeColumn(titleIndex); // adjust width of the column

			file = filePath + File.separator + excelName
					+ DateUtil.getCurrentDateIndianFormat()
					+ (DateUtil.getCurrentTime()).replaceAll(":", "-") + ".xls";

			if (wb instanceof XSSFWorkbook)
				file += "x";
			FileOutputStream out = new FileOutputStream(file);
			wb.write(out);
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return file;

	}

	public void getStatus() {
	}

	private Map<String, CellStyle> createStyles(Workbook wb) {
		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
		CellStyle style;

		// Title Style
		Font titleFont = wb.createFont();
		titleFont.setFontHeightInPoints((short) 16);
		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(titleFont);
		style.setWrapText(true);
		styles.put("title", style);

		// Sub Title Style
		Font subTitleFont = wb.createFont();
		subTitleFont.setFontHeightInPoints((short) 14);
		subTitleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.BLUE_GREY.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(subTitleFont);
		style.setWrapText(true);
		styles.put("subTitle", style);

		Font headerFont = wb.createFont();
		headerFont.setFontHeightInPoints((short) 11);
		headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setFont(headerFont);
		styles.put("header", style);

		style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setWrapText(true);
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		styles.put("cell", style);

		return styles;
	}

}
