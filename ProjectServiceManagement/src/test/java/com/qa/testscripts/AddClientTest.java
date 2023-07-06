package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.AddClientPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;

public class AddClientTest extends Base{
	PageUtility page=new PageUtility();
	LoginPage loginpage;
	HomePage homepage;
	AddClientPage addclientpage;
	@Test
	public void addClientTest() throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage=new HomePage(driver);
		homepage.navigateToAddClientPage();
		addclientpage=new AddClientPage(driver);
		
		addclientpage.addCity();
		addclientpage.addAddress();
		addclientpage.addClientName();
		addclientpage.addCompanyName();
		addclientpage.addEmail();
		addclientpage.addGeolocation();
		addclientpage.addPhoneNo();
		addclientpage.addPincode();
		addclientpage.addSSNo();
		addclientpage.uploadFile();
		addclientpage.addComment(ExcelUtility.getString(1, 29, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		addclientpage.addClient();
		
		
		
	}
	

	@Test
	public void verifyAlertMsgWithoutClient() throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage=new HomePage(driver);
		
		addclientpage=new AddClientPage(driver);
		
		addclientpage.addCity();
		addclientpage.addAddress();
		addclientpage.addCompanyName();
		addclientpage.addEmail();
		addclientpage.addGeolocation();
		addclientpage.addPhoneNo();
		addclientpage.addPincode();
		addclientpage.addSSNo();
		addclientpage.uploadFile();
		addclientpage.addComment(ExcelUtility.getString(1, 29, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		addclientpage.addClient();
		
		String actualMsg=addclientpage.getAlertMsg();
		String expectedMsg=ExcelUtility.getString(1, 30, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualMsg, expectedMsg, "Test Failed");
	}
	
	
	@Test
	public void verifyAddClient() throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage=new HomePage(driver);
		homepage.navigateToAddClientPage();
		addclientpage=new AddClientPage(driver);
		addclientpage.addClientData();
		String actualMessage =addclientpage.getClientAddedMessage();
		String expectedMessage=ExcelUtility.getString(7, 1, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE","testSheet");
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
	}


}
