package com.qa.testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ReparationPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;
import com.qa.utilities.WaitUtility;

public class ReparationTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ReparationPage rPage;

	@Test
	public void addReparationTest() throws IOException, AWTException, InterruptedException {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		rPage = new ReparationPage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.navigateToReparartionPage();
		rPage.addClient(ExcelUtility.getString(4, 3, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE",
				"testSheet"));
		rPage.addIMEI(ExcelUtility.getString(4, 2, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE",
				"testSheet"));
		rPage.addTax(ExcelUtility.getString(4, 4, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE",
				"testSheet"));
		rPage.setAssignedTo(ExcelUtility.getString(4, 5,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		rPage.addCategory(ExcelUtility.getString(4, 6,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		rPage.setDefect(ExcelUtility.getString(4, 7, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE",
				"testSheet"));
		rPage.setManufacturer(ExcelUtility.getString(4, 8,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		rPage.setModel(ExcelUtility.getString(4, 9, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE",
				"testSheet"));
		rPage.setServiceCharge(ExcelUtility.getNumeric(4, 10,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));

		rPage.uploadImageFile();
		WaitUtility.waitForElementLocated(driver,
				By.xpath("//div[@class='progress-bar bg-success progress-bar-success']"));
		boolean isCompleted = rPage.isUploadcompleted();
		Assert.assertTrue(isCompleted);

	}


}
