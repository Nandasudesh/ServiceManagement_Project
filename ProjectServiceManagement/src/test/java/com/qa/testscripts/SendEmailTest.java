package com.qa.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.SendEmailPage;
import com.qa.servicemanagementproject.Base;
import com.qa.utilities.ExcelUtility;
import com.qa.utilities.WaitUtility;

public class SendEmailTest extends Base {
	HomePage homepage;
	LoginPage loginpage;
	SendEmailPage sendemail;
	
	@Test
	public void sendMailText() throws IOException, InterruptedException {
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
		sendemail=new SendEmailPage(driver);
		
		loginpage.setUsername(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.setPassword(ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet"));
		loginpage.clickSubmit();
		homepage.navigateToSendmailPage();
		sendemail.getSubject();
		sendemail.getMessage();
		sendemail.sendMail();
		
		
	}

}
