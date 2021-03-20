package com.crm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;

import com.crm.base.TestBase;

public class TestUtil extends TestBase {
public static long PAGELOADTIMEOUT=20;
public static long IMPLICITWAIT=10;
static Xls_Reader reader;


public static String TESTDATA_SHEET_PATH = "C:\\Users\\Chandru\\Desktop\\CRM.xlsx";

static Workbook book;
static Sheet sheet;


public void switchToFrame() {
	driver.switchTo().frame("mainpanel");
}

public static ArrayList<Object[]>getDataFromExcel() {
	ArrayList<Object[]> mydata= new ArrayList<Object[]> ();
	
	Xls_Reader reader= new Xls_Reader("C:\\Users\\Chandru\\Desktop\\CRM.xlsx");
	String sheetname="CRM Contacts";
	int rowcnt=reader.getRowCount(sheetname);
	
	for(int rowNum=2;rowNum<=rowcnt;rowNum++) {
		String firstname=reader.getCellData(sheetname, "firstname", rowNum);
		String lastname=reader.getCellData(sheetname, "lastname", rowNum);
		String title=reader.getCellData(sheetname, "title", rowNum);
		String company=reader.getCellData(sheetname, "company", rowNum);
		
		Object data[]= {title,firstname,lastname,company};
		
		mydata.add(data);
	}
	
	return mydata;
}

public static Object[][] getTestData(String sheetName) throws InvalidFormatException {
	FileInputStream file = null;
	try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		book = WorkbookFactory.create(file);
	} catch (IOException e) {
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetName);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for (int i = 0; i < sheet.getLastRowNum(); i++) {
		for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
			data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			// System.out.println(data[i][k]);
		}
	}
	return data;
}

}
