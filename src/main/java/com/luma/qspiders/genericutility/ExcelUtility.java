package com.luma.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * the Excel utility class will be used to manage the test case Specific Data from the excel workbook. 
 * @author JAYANTH
 *
 */

public class ExcelUtility {
	/**
	 * This method is used to read the String data from Excel Workbook.
	 * @param sheetname
	 * @param rowiIndex
	 * @param cellIndex
	 * @return StringData
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readStringData(String sheetname,int rowiIndex,int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String data = workbook.getSheet(sheetname).getRow(rowiIndex).getCell(cellIndex).getStringCellValue();
		return data;
		
	}
	
	/**
	 * This method is used to read the Numeric data from the Excel Workbook.
	 * @param sheetname
	 * @param rowIndex
	 * @param cellIndex
	 * @return NumericData
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public double readNumericData(String sheetname,int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		double data = workbook.getSheet(sheetname).getRow(rowIndex).getCell(cellIndex).getNumericCellValue();
		
		return data;
	}

}
