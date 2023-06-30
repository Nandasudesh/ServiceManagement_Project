package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SendSMSPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class SendSMSTest extends Base{
	HomePage homepage;
	LoginPage loginpage;
	SendSMSPage sendsmspage;
	
	@Test
	public void sendSMSTest() throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage=new HomePage(driver);
		homepage.navigateToSendSMSPage();
		sendsmspage=new SendSMSPage(driver);
		sendsmspage.enterMessage(ExcelUtility.getString(1, 8, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		sendsmspage.selectRecepient();
		sendsmspage.clickOnSendButton();

	}
	
}


