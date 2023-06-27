package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.FakerUtility;
import com.qa.utilities.PageUtility;

public class QuickSMSPage {
	
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public QuickSMSPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='phone_number']")
	WebElement phoneNumber;
	@FindBy(xpath="//textarea[@placeholder='SMS Text']")
	WebElement smsText;
	@FindBy(xpath="//button[@form='send_quicksms']")
	WebElement sendButton;
	@FindBy(xpath="//li[text()='This value is required.']")
	WebElement alertMsg;
	
	public void setNumber() {
		String phoneNo=FakerUtility.telephone();
		page.setValue(phoneNumber, phoneNo);
	}
	
	public void setText(String text) {
		page.setValue(smsText, text);
	}
	
	public void sendSMS() {
		page.clickOnElement(sendButton);
	}
	
	public String getAlertMsg() {
		return page.getElementText(alertMsg);
	}
	
	

}
