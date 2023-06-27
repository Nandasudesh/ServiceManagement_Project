package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.LoginPage;
import com.qa.pages.LogoutPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class LogoutTest extends Base {
	LoginPage loginpage;
	LogoutPage logoutpage;

	@Test
	public void logoutAppTest() throws IOException {
		loginpage = new LoginPage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();

		logoutpage.logOutApp();
	}

	@Test
	public void verifyLogoutTest() throws IOException {
		String actualMessage = logoutpage.logoutMessage();
		String expectedMessage = ExcelUtility.getString(1, 3,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualMessage, expectedMessage, "Logout Failed");
	}

}
