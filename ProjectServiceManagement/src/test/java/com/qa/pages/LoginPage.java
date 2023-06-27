package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;

public class LoginPage {
	public WebDriver driver;
	PageUtility page = new PageUtility();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "identity")
	WebElement userName; // WebElement userName=driver.findElement(By.name="userName")
	@FindBy(name = "password")
	WebElement passWord;
	@FindBy(name = "submit")
	WebElement submit;
	@FindBy(xpath = "//ins[@class='iCheck-helper']")
	WebElement rememberMeBox;
	@FindBy(linkText = "Back to home page")
	WebElement backToHomeLink;
	@FindBy(xpath = "//p[text()='Logged In Successfully']")
	WebElement alertMessage;
	
	

	public void setUsername(String uName) {
		page.setValue(userName, uName);
	}

	public void setPassword(String pwrd) {
		page.setValue(passWord, pwrd);
	}

	public void clickSubmit() {
		page.clickOnElement(submit);
	}

	public String getAlertMessage() {
		return page.getElementText(alertMessage);
	}
	
	public String getPageTitle() {
		return page.getTitile(driver);
	}
	
	

//	public void validLogin() throws IOException {
//		String username=ExcelUtility.getString(1, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet");
//		String password=ExcelUtility.getString(1, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet");
//		String expectedMessage=ExcelUtility.getString(1, 2, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet");
//		PageUtility.setValue(userName,username);
//		PageUtility.setValue(passWord, password);
//		PageUtility.isElementDisplayed(submit);
//		PageUtility.clickOnElement(submit);
//		String actualMessage=page.getElementText(alertMessage);
//
//		Assert.assertEquals(actualMessage, expectedMessage, "Login Failed");
//		
//		
//	}
//	
//	public void invalidLogin() throws IOException {
//		String username=ExcelUtility.getString(2, 0, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet");
//		String password=ExcelUtility.getString(2, 1, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet");
//		PageUtility.setValue(userName,username);
//		PageUtility.setValue(passWord, password);
//		PageUtility.isElementDisplayed(submit);
//		PageUtility.clickOnElement(submit);
//		String actualTitle=PageUtility.getTitile(driver);
//		String expectedTitle=ExcelUtility.getString(1, 20, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet");
//		Assert.assertEquals(actualTitle, expectedTitle,"Login Failed, Test success");
//	}
//	
	
	
	
	
	

	


}
