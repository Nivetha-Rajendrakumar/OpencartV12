package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Logindata")
	public String[][] getData() throws IOException{
		String path = ".//testData//Opencart_Logindata.xlsx";//system.getproperty(user.dir) == . //both denotes current project
		ExcelUtilities xlutil = new ExcelUtilities(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcell = xlutil.getcellCount("Sheet1", totalrows);
		String loginData[][] = new String[totalrows][totalcell];
		for(int i=1;i<totalrows;i++)
			for(int j=0;j<totalcell;j++) {
				loginData[i-1][j] = xlutil.getcellData("Sheet1", i, j);
			}
		return loginData;
		
	}
}

