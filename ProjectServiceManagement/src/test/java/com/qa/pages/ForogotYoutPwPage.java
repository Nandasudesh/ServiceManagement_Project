package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.PageUtility;

public class ForogotYoutPwPage {
	
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public ForogotYoutPwPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPasswordLink;
	@FindBy(xpath="//input[@id='identity']")
	WebElement emailForForgotPw;
	@FindBy(xpath="//input[@name='submit']")
	WebElement submitButtonForgotPw;
	
	public void clickOnForgetPassword() {
		page.clickOnElement(forgotPasswordLink);
	}
	
	public String getActualTitle() {
		return page.getTitile(driver);
	}
	public void setEmail(String email) {
		page.setValue(emailForForgotPw, email);
	}
	
	public void submitEmail() {
		page.clickOnElement(submitButtonForgotPw);
	}
	
	public  String actualURL() {
		return page.getURL(driver);
	}

}
