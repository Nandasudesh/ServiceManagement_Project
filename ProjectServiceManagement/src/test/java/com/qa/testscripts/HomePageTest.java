package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;
import com.qa.utilities.WaitUtility;

public class HomePageTest extends Base {

	HomePage homepage;
	LoginPage loginpage;

	@Test(groups = "Sanity")
	public void verifyAddClientNavigation() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.navigateToAddClientPage();
		String expectedMessage=ExcelUtility.getString(1, 4,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		String actualMessage=homepage.getActualMessageforAddClient();
		Assert.assertEquals(actualMessage, expectedMessage, "Failed navigation to add client");

	}

	@Test(groups = "Regression")
	public void verifyNavigateToReparartionPage() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();

		homepage.navigateToReparartionPage();
		boolean checkLabel = homepage.isIMEILabelPresent();
		Assert.assertTrue(checkLabel);

	}

	@Test(groups = "Sanity")
	public void verifyNavigationToSendSMS() throws IOException, InterruptedException {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.navigateToSendSMSPage();
		String actualMessage=homepage.getActualSendSMSMessage();
		String expectedMessage=ExcelUtility.getString(1, 6,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualMessage, expectedMessage, "Failed navigation to Send SMS Page");
	}

	@Test(groups = "Regression")
	public void verifyNavigationToAlertTest() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.navigateToAlertPage();
		String actualMessage=homepage.getAlertPageActualMessage();
		String expectedMessage=ExcelUtility.getString(1, 19,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualMessage, expectedMessage, "Navigation to alert page failed");

	}

	@Test
	public void verifyNavigateToSendMail() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.navigateToSendmailPage();
		String actualMessage = homepage.actualSendMailMessageText();
		System.out.println(actualMessage);
		String expectedMessage = "Send Email";
		Assert.assertEquals(actualMessage, expectedMessage);

	}

	@Test
	public void verifyOrderandReparartionsPage() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.navigateToOrderandReparationPage();
		String actualMessage = homepage.getReparartionHeading();
		String expectedMessage = ExcelUtility.getString(1, 24,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualMessage, expectedMessage);
	}

	@Test
	public void verifyPresenceOfQuickSMSFunction() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();

		String actualMessage = homepage.getMsgOfQuickSMS();
		String expectedMessage = ExcelUtility.getString(1, 31,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualMessage, expectedMessage, "Test Failed");
	}

}
