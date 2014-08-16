package com.suvidha.common;

import java.io.InputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class GenericReadBinaryExcel {

	private static final Log log = LogFactory
			.getLog(GenericReadBinaryExcel.class);
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public String readExcelSheet(HSSFRow row, int cellIndex) {

		String cellValue = "NA";
		try {

			HSSFCell cell = row.getCell((short) cellIndex);
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_STRING:
				cellValue = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				cellValue = "NA";
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					String time = TIME_FORMAT.format(cell.getDateCellValue())
							.substring(11);
					if (time != null && time.equals("00:00:00"))
						cellValue = DATE_FORMAT.format(cell.getDateCellValue());
					else
						cellValue = time;

				} else
					cellValue = new Double(cell.getNumericCellValue())
							.longValue() + "";

			}
		} catch (Exception e) {
			log.error(
					"@ERP::>> Problem in GenericReadBinaryExcel at method readExcelSheet()",
					e);
		}
		return cellValue;
	}

	public HSSFSheet readExcel(InputStream excelStream) {
		POIFSFileSystem POIFS = null;
		HSSFWorkbook workBook = null;
		HSSFSheet sheet = null;

		try {
			POIFS = new POIFSFileSystem(excelStream);
			workBook = new HSSFWorkbook(POIFS);
			sheet = workBook.getSheetAt(0);

		} catch (Exception e) {
			log.error(
					"@ERP::>> Problem in GenericReadBinaryExcel at method readExcel()",
					e);
			// e.printStackTrace();
		}

		return sheet;
	}

}
