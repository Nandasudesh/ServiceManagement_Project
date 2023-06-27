package com.qa.dataproviderutility;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	@DataProvider(name="getdataFromDataProvider")
	public Object[][] getdataFromDataProvider() {
		return new Object[][] {{"test123","test2", "test3"}};
	}

}
