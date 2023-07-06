package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitUtility;

public class LogoutPage {
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath = "(//span[text()='Joe Jacobs'])[1]")
//	WebElement name;
//	@FindBy(xpath="//span[@class='user-image']")
//	WebElement name;
	@FindBy(xpath="/html/body/div[2]/div/header/nav/div/ul/li[3]/a")
	WebElement name;
	@FindBy(xpath = "//a[text()='Sign out']")
	WebElement signOut;
	@FindBy(xpath = "//p[text()='Logged Out Successfully']")
	WebElement logoutMessage;
	
	public void logOutApp() {
		WaitUtility.waitForelementClickable(driver, name);
		page.clickOnElement(name);
		page.clickOnElement(signOut);
	}
	
	public String logoutMessage() {
		return page.getElementText(logoutMessage);
		
	}

}
