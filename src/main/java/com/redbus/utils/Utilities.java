package com.redbus.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {
	private static Properties prop;

	public static Properties initProperties() {
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/configurationprop/config.properties");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

	public static String[] excelsheetsData(String Sheetname) throws IOException {
	
	FileInputStream read_file = new FileInputStream(System.getProperty("user.dir")+ prop.getProperty("testData_path"));						
	XSSFWorkbook workbook= new XSSFWorkbook(read_file);
	XSSFSheet worksheet = workbook.getSheet(Sheetname);
	
	int totalrows=worksheet.getLastRowNum();
	Row rowcells=worksheet.getRow(0);
	int totalcolumns=rowcells.getLastCellNum();
	
	DataFormatter format=new DataFormatter();// to display the content as exactly in excel sheet
	String[] testdata=new String[totalrows+1];
for(int i=0;i<=totalrows;i++) {
	testdata[i]=format.formatCellValue(worksheet.getRow(i).getCell(0));
//System.out.println(testdata[i]);
}
return testdata;
			}
	public static String[][] multidimenarrayexcelsheetdata(String Sheetname) throws IOException{
	prop=Utilities.initProperties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ prop.getProperty("testData_path"));
		XSSFWorkbook book=new XSSFWorkbook(fis);
		XSSFSheet sheet=book.getSheet(Sheetname);
		int totalrows=sheet.getLastRowNum();//calculating rows by index
		//System.out.println(totalrows);
		Row rowcells=sheet.getRow(0);
		int totalcolumns=rowcells.getLastCellNum();
		//System.out.println(totalcolumns);
		DataFormatter format=new DataFormatter();
		String [][]data=new String[totalrows+1][totalcolumns];
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcolumns;j++) {
				data[i][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
				//System.out.print(data[i][j]);
			}
			//System.out.println();

			}
		return data;
	}}
		
	
	

