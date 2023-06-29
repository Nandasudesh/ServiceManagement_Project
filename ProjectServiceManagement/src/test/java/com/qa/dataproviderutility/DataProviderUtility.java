package com.qa.dataproviderutility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
//	@DataProvider(name="getdataFromDataProvider")
//	public Object[][] getdataFromDataProvider() {
//		return new Object[][] {{"Nanda S","TVB","1234543","Address","TVM","695044","91876543","nan@gmail.com","123","1234","\\src\\main\\java\\Resources\\branches-1842554_960_720-1.jpg","comments"}};
//	}
	
	@DataProvider(name="getdataFromDataProvider")
	public Object[][]getdataFromDataProvider(){
		return new Object[][] {{"admin@admin.com","password"}
	};

}
}
