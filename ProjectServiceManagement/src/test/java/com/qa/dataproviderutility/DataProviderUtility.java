package com.qa.dataproviderutility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	
	@DataProvider(name="getdataFromDataProvider")
	public Object[][]getdataFromDataProvider(){
		return new Object[][] {{"admin@admin.com","password"}};
	
	}
	@DataProvider(name="getInvalidLoginData")
	public Object[][]getInvalidLoginData(){
		return new Object[][] {
			new Object[]{"admin.com","password"},
			new Object[]{"adminqw","pwd"},
			new Object[] {"admin@admin.com","pword"}};	

}
}
