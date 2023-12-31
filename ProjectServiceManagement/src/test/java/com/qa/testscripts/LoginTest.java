package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.dataproviderutility.DataProviderUtility;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;
import com.qa.utilities.RetryUtils;

public class LoginTest extends Base {
	LoginPage loginpage;

	@Test(retryAnalyzer=RetryUtils.class)
	public void verifyLoginWithValidCredentials() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();

		String expectedMessage = ExcelUtility.getString(1, 2,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		String actualMessage = loginpage.getAlertMessage();
		Assert.assertEquals(expectedMessage, actualMessage, "Test Failed");
	}

	
	@Test(dataProvider = "getdataFromDataProvider", dataProviderClass = DataProviderUtility.class)
	public void loginCredentialsTest(String uName, String pw) throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.setUsername(uName);
		loginpage.setPassword(pw);
		loginpage.clickSubmit();

	}
	
	@Test(dataProvider = "getInvalidLoginData", dataProviderClass = DataProviderUtility.class)
	public void invalidloginTest(String uName, String pw) throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.setUsername(uName);
		loginpage.setPassword(pw);
		loginpage.clickSubmit();

		String actualTitle = loginpage.getPageTitle();
		String expectedTitle = ExcelUtility.getString(1, 20,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualTitle, expectedTitle, "Test failed");

	}

}
