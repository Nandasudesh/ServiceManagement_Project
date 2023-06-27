package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;

public class SendSMSPage {
	
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public SendSMSPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='client_id']")
	WebElement dropDown;
	@FindBy(xpath="(//textarea[@id='fastsms'])[3]")
	WebElement textArea;
	@FindBy(xpath="//button[@value='Submit']")
	WebElement sendButton;
	
	public void sendSMS() throws IOException {
		//String username=ExcelUtility.getString(1, 7, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet");
		page.selectDropDownbyText(dropDown, "Kiran");
		String textarea=ExcelUtility.getString(1, 8, System.getProperty("user.dir")+"constants.Constant.TESTDATAFILE", "testSheet");
		page.setValue(textArea, textarea);
		
		page.clickOnElement(sendButton);
		
		
	}

}
