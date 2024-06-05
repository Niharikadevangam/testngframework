package com.tutorialsninja.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	public static final int IMPLICIT_WAIT_TIME = 15;
	public static final int PAGE_LOAD_TIME = 20;

	public static String generatetimestamp() {
		Date date = new Date();
		String mail = date.toString().replace(" ", "_").replace(":", "_");
		return "nihar" + mail + "@gmail.com";

	}

	public static Object[][] readdatafromexcel(String sheetname) throws IOException {
		File fi = new File(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\com\\tutorialsninja\\qa\\testdata\\Testdata.xlsx");
		FileInputStream fisexcel = new FileInputStream(fi);
		XSSFWorkbook wib = new XSSFWorkbook(fisexcel);
		XSSFSheet sheet = wib.getSheet(sheetname);
		//System.out.println(sheetname);
		int row = sheet.getLastRowNum();
		//System.out.println(row);
		int col = sheet.getRow(1).getLastCellNum();
	//	System.out.println(col);
		Object[][] data = new Object[row][col];
		for (int i = 0; i < row; i++) {
			XSSFRow row1 = sheet.getRow(i+1);
		//	System.out.println(row1);
			for (int j = 0; j < col; j++) {

				XSSFCell col1 = row1.getCell(j);
				CellType celltype = col1.getCellType();
				switch (celltype) {
				case STRING:
					data[i][j] = col1.getStringCellValue();
					break;
				case NUMERIC:
					data[i][j] = Integer.toString((int) col1.getNumericCellValue());
					break;
				case BOOLEAN:
					data[i][j] = col1.getBooleanCellValue();
					break;
				}
			}

		}
		return data;
	}
}
