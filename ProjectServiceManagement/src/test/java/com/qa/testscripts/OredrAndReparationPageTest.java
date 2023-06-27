package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.OredrAndReparationPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class OredrAndReparationPageTest extends Base {
	LoginPage loginpage;
	HomePage homepage;
	OredrAndReparationPage orpage;

	@Test
	public void filterDetails() throws IOException {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		orpage = new OredrAndReparationPage(driver);

		loginpage = new LoginPage(driver);
		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();

		homepage.navigateToOrderandReparationPage();

		orpage.selectFilterIcon();
		orpage.mapkaSelect(ExcelUtility.getString(1, 26,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		orpage.selectHasWarranty(ExcelUtility.getString(1, 27,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		orpage.selectStatus(ExcelUtility.getString(1, 28,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));

	}

	public void closeFilterOption() {
		orpage.closeFilter();
	}

}
