package com.redbus.base;

import java.io.IOException;

import com.redbus.utils.Utilities;

public class tem {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
tem.dataprovider();
	}
	public static Object[][] dataprovider() throws IOException {
		String data[][]=Utilities.multidimenarrayexcelsheetdata("Sheet2");
		//System.out.println(data[2][1]);
		 Object[][] searchwords=new Object[5][2];
		 for(int i=1;i<5;i++) {
			 for(int j=0;j<2;j++) {
			searchwords[i][j]=data[i][j];
			System.out.println(searchwords[i][j]);
			 }}
			
			return searchwords;
			
			

	}
}
