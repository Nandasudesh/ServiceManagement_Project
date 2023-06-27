package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.AddClientPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class AddClientTest extends Base{
	
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
		homepage.verifyNavigateClientPage();
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
		
		//addclientpage.verifyIfClientAdded();
		
		
	}
	@Test
	public void verifyAlertMsgWithoutClient() throws IOException {
		loginpage=new LoginPage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage=new HomePage(driver);
		homepage.verifyNavigateClientPage();
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
	
	
	

}
