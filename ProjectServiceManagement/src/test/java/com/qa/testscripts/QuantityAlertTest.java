package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.QuantityAlertPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class QuantityAlertTest extends Base{
	
	LoginPage loginpage;
	HomePage homepage;
	QuantityAlertPage quantityalertpage;
	@Test
	public void quantityAlert() throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage=new HomePage(driver);
		homepage.navigateToAlertPage();
		quantityalertpage=new QuantityAlertPage(driver);
		quantityalertpage.quantityAlertData();
	}

}
