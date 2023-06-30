package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;
import com.qa.utilities.WaitUtility;

public class HomePageTest extends Base{
	
	HomePage homepage;
	LoginPage loginpage;
	

	
	@Test(groups="Sanity")
	public void addClient() throws IOException {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.verifyNavigateClientPage();
		
	}

	@Test(groups="Regression")
	public void verifyNavigateToReparartionPage() throws IOException, InterruptedException {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		
		homepage.navigateToReparartionPage();
		String actualMessage=homepage.getReparationPageMessage();
		String expectedMessage=ExcelUtility.getString(1, 5,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
		
	}
	
	
	
	@Test(groups="Sanity")
	public void sendSMS() throws IOException, InterruptedException {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.verifyNavigateSendSMSPage();
	}
	@Test(groups="Regression")
	public void alertTest() throws IOException {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.verfiyNavigateToAlertPage();
		
	}
	@Test
	public void verifyNavigateToSendMail() throws IOException {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.navigateToSendmailPage();
		String actualMessage=homepage.actualSendMailMessageText();
		System.out.println(actualMessage);
		String expectedMessage="Send Email";
		Assert.assertEquals(actualMessage, expectedMessage);

		
	}
	
	@Test
	public void verifyOrderandReparartionsPage() throws IOException {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.navigateToOrderandReparationPage();
		String actualMessage=homepage.getReparartionHeading();
		String expectedMessage=ExcelUtility.getString(1, 24,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	@Test
	public void verifyPresenceOfQuickSMSFunction() throws IOException {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		
		String actualMessage=homepage.getMsgOfQuickSMS();
		String expectedMessage=ExcelUtility.getString(1, 31, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
	}
	
	
	
	
	

}
