package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;

	/*public static ArrayList<String> getString(String file_path, String sheet) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testData.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		ArrayList<String> ExcelRows = new ArrayList<String>();
		int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
		for (int i = 0; i <= rowCount; i++) {
			Row row = sh.getRow(i);
			int cellCount = row.getLastCellNum();
			for (int j = 0; j < cellCount; j++) {
				ExcelRows.add(row.getCell(j).getStringCellValue());
			}
		}
		return ExcelRows;

	}*/

	public static ArrayList<String> getRow(String file_path, String sheet, int rownum) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testData.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		ArrayList<String> ExcelRows = new ArrayList<String>();

		Row row = sh.getRow(rownum);
		int cellCount = row.getLastCellNum();
		for (int j = 0; j < cellCount; j++) {
			ExcelRows.add(row.getCell(j).getStringCellValue());

		}

		return ExcelRows;

	}

	public static String getString(int i, int j, String file_path, String sheet) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testData.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();

	}

	public static String getNumeric(int i, int j, String file_path, String sheet) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\testData.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		int value = (int) c.getNumericCellValue();
		return String.valueOf(value);

	}
	

	/*
	 * @DataProvider(name = "getData") public String[][] getData(int i, int j,
	 * String sheet1) throws IOException {
	 * 
	 * File excelFile = new File("./src/main/java/Resources/testdata.xlsx");
	 * FileInputStream fis = new FileInputStream(excelFile); XSSFWorkbook workbook =
	 * new XSSFWorkbook(fis); XSSFSheet sheet = workbook.getSheet(sheet1);
	 * 
	 * int rows = sheet.getPhysicalNumberOfRows(); int cols =
	 * sheet.getRow(0).getLastCellNum();
	 * 
	 * String[][] data = new String[rows - 1][cols]; for (i = 0; i < rows - 1; i++)
	 * { for (j = 0; j < cols; j++) {
	 * 
	 * DataFormatter df = new DataFormatter(); data[i][j] =
	 * df.formatCellValue(sheet.getRow(i + 1).getCell(j)); //
	 * System.out.println(df.formatCellValue(sheet.getRow(i+1).getCell(j))); } }
	 * 
	 * workbook.close(); fis.close(); return data; }
	 */
}
