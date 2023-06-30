package com.qa.testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ReparationPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class ReparationTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	ReparationPage rPage;
	@Test
	public void addReparation() throws IOException, AWTException, InterruptedException {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		rPage=new ReparationPage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.navigateToReparartionPage();
		rPage.uploadImage();
		
		
	}

}
