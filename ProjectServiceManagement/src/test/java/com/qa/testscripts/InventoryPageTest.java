package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.InventoryPage;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;

public class InventoryPageTest extends Base {

	LoginPage loginpage;
	InventoryPage iPage;
	PageUtility page = new PageUtility();

	@Test
	public void deleteInventoryProductTest() throws IOException {
		loginpage = new LoginPage(driver);
		iPage = new InventoryPage(driver);

		loginpage.setUsername(ExcelUtility.getString(1, 0,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		int expectedCountAfterDelete = iPage.getExpectedInventoryCount();

		iPage.clickonInventoryInfo();

		iPage.getdata(
				ExcelUtility.getString(4, 0, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE",
						"testSheet"),
				ExcelUtility.getNumeric(4, 1, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE",
						"testSheet"));

		iPage.clickOndelete();
		iPage.selectYes();
		String countAfterDeletion = iPage.getInventoryCount();

		Assert.assertEquals(countAfterDeletion, expectedCountAfterDelete, "Test Failed");

	}

}
