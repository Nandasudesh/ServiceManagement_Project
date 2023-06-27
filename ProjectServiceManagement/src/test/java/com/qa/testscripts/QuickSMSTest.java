package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.QuickSMSPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class QuickSMSTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	QuickSMSPage quickSMS;
	
	@Test
	public void verifySendSMS() throws IOException {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		quickSMS=new QuickSMSPage(driver);
		
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		
		quickSMS.setNumber();
		quickSMS.setText(ExcelUtility.getString(1, 32, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		quickSMS.sendSMS();
	}
	@Test
	public void  verifySMSwithoutNo() throws IOException {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		quickSMS=new QuickSMSPage(driver);
		
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		
		quickSMS.setText(ExcelUtility.getString(1, 32, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		quickSMS.sendSMS();
		String actualMessage=quickSMS.getAlertMsg();
		String expectedMessage=ExcelUtility.getString(1, 30, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualMessage, expectedMessage, "Failed test");
		
		
		
	}
	}


