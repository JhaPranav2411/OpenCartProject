package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider (name = "LoginData")
	
	public String [][] getDATA() throws IOException {
		
		String path = ".\\TestData\\OpenCart_LoginData.xlsx";  
		
		Excelutility  xlutil = new Excelutility(path);  
		
		int totalrows = xlutil.getRowCount("sheet1");
		
		int totalcols = xlutil.getCellCount("sheet1", 1);
		
		String LoginData[] [] = new String[totalrows][totalcols] ;
		
		
		
		for ( int i=1; i<= totalrows ; i ++) {
			
			for ( int j = 0; j < totalcols ; j++) {
				
				LoginData[i -1][j] = xlutil.getCellData("Sheet1", i,j);	
				
			}
		}
		
		return LoginData;
		
		
	}
	
	
	
	
}
