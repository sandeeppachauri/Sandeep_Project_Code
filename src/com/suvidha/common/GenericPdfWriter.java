package com.suvidha.common;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GenericPdfWriter {

	public String createPdf(List data, String[] headerTitles, String titleKey,
			String filePath) {
		int col = 0;
		String fileName = null;
		try {
			if (headerTitles != null && headerTitles.length > 0)
				col = headerTitles.length;

			Document document = new Document(PageSize.A4, 20, 20, 50, 50);
			fileName = filePath + File.separator + "feedback"
					+ DateUtil.getCurrentDateIndianFormat()
					+ (DateUtil.getCurrentTime()).replaceAll(":", "-") + ".pdf";
			PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();
			PdfPTable table = new PdfPTable(col);
			PdfPCell cell;
			Map<String, String> titleMap = new CommonPropertyMap()
					.getTitles(titleKey);
			table.setWidthPercentage(100f);

			float[] widths = new float[col];
			for (int wx = 0; wx < col; wx++)
				widths[wx] = 100f / col;

			table.setWidths(widths);
			table.setHeaderRows(2);
			if (headerTitles != null) {
				for (String title : headerTitles) {
					cell = new PdfPCell(new Paragraph(titleMap.get(title)));
					cell.setBackgroundColor(new BaseColor(204, 204, 204));
					cell.setBorderColor(new BaseColor(170, 170, 170));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

					table.addCell(cell);

				}

			}
			int altr = 1;
			String cellValue = "NA";

			if (data != null && data.size() > 0) {
				for (Iterator iterator = data.iterator(); iterator.hasNext();) {
					Object classType = iterator.next();

					for (String title : headerTitles) {

						if (PropertyUtils.getProperty(classType, title) != null)
							cellValue = PropertyUtils.getProperty(classType,
									title).toString();

						cell = new PdfPCell(new Paragraph(cellValue));
						if (altr % 2 == 0) {
							cell.setBackgroundColor(new BaseColor(240, 240, 240));
							cell.setBorderColor(new BaseColor(170, 170, 170));

						} else {
							cell.setBackgroundColor(new BaseColor(255, 255, 255));
							cell.setBorderColor(new BaseColor(170, 170, 170));

						}
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

						table.addCell(cell);
					}
					altr++;
				}
			}
			document.add(table);
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileName;
	}

}
