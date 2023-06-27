package com.qa.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.pages.ForogotYoutPwPage;
import com.qa.pages.LoginPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;

public class ForgotYourPwTest extends Base {
	
	LoginPage loginpage;
	ForogotYoutPwPage forogotPw;
	@Test
	public void verifyNavigateToforgotPwPage() throws IOException {
		loginpage=new LoginPage(driver);
		forogotPw=new ForogotYoutPwPage(driver);
		
		forogotPw.clickOnForgetPassword();
		String actualTitle=forogotPw.getActualTitle();
		String expectedTitle=ExcelUtility.getString(1, 34, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualTitle, expectedTitle, "navigation to forgot password failed");
		String email=ExcelUtility.getString(1, 0, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");		
		forogotPw.setEmail(email);
		forogotPw.submitEmail();
		String actualURL=forogotPw.actualURL();
		String expectedURL=ExcelUtility.getString(1, 33, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		Assert.assertEquals(actualURL, expectedURL, "Submit email for forogot password failed");
	}
	

	

}
