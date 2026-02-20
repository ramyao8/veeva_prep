package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvider_login {
	@DataProvider(name="LoginData")
	public String [][]getData() throws IOException
	{
		String path=".\\testData\\TestData2.xlsx";
		ExcelUtilities util=new ExcelUtilities(path);
		int rows=util.getRowsCount("Sheet1");
		int columns=util.getColumnsCount("Sheet1");
		String logindata[][]=new String[rows][columns];
		for(int i=1;i<=rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				logindata[i-1][j]=util.getCellValue("Sheet1", i,j);
			}
		}
		return logindata;
	}
}
