package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;

public class SendEmailPage {
	
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public SendEmailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='email_to[]']")
	WebElement selectBox;
	@FindBy(xpath="(//input[@name='subject'])[2]")
	WebElement subjectTextBox;
	@FindBy(id="sms_body")
	WebElement messageTextBox;
	@FindBy(xpath="//button[@form='sendEmail']")
	WebElement sendMailButton;
	@FindBy(xpath="(//button[text()='Close'])[2]")
	WebElement closemailButton;
	
	public void getRecepientName() {
		page.selectDropDownbyValue(selectBox, "7");
	}
	
	public void getSubject() throws IOException {
		String mailSubject = ExcelUtility.getString(1, 22,System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		page.setValue(subjectTextBox, mailSubject);
	}
	
	public void getMessage() throws IOException {
		String mailMessage = ExcelUtility.getString(1, 23,System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		page.setValue(messageTextBox, mailMessage);
	}
	
	public void sendMail() {
		page.clickOnElement(sendMailButton);
	}
	
	public void closeMail() {
		page.clickOnElement(closemailButton);
	}

}
