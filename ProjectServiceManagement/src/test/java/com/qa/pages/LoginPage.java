package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitUtility;

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
		String title= page.getTitile(driver);
		System.out.println(title);
		return title;
	}
	


	
	
	
	
	

	


}
