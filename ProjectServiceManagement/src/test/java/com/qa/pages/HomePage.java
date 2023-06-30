package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	PageUtility page = new PageUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='alert alert-success']")
	WebElement loginMessage;
	@FindBy(xpath = "//i[@class='fa fa-plus-circle']")
	WebElement addIcon;
	@FindBy(xpath = "//span[@class='fa fa-user-plus icon']")
	WebElement addClient;
	@FindBy(xpath = "//h4[text()='Add Client']")
	WebElement message;
	@FindBy(xpath = "//span[@class='fa fa-list-alt icon']")
	WebElement addReparation;
	@FindBy(xpath = "//h4[text()='Add Reparation']")
	WebElement addReparationMsg;
	@FindBy(xpath = "//span[@class='fa fa-comment icon']")
	WebElement sendSMS;
	@FindBy(id = "exampleModalLabel")
	WebElement sendSMSmsg;
	@FindBy(xpath = "//i[@class='fa fa-exclamation-triangle']")
	WebElement alertIcon;
	@FindBy(xpath = "//ul[@class='dropdown-menu pull-right']")
	WebElement alertDrop;
	@FindBy(xpath = "//h1[text()='Quantity Alerts']")
	WebElement alertMessage;
	@FindBy(xpath = "//span[@class='fa fa-paper-plane icon']")
	WebElement sendMailicon;
	@FindBy(xpath = "(//h5[@class='modal-title'])[2]")
	WebElement sendMailText;
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]")
	WebElement reparation;
	@FindBy(xpath="//h1[text()='Order & Reparations']")
	WebElement reparationHeadingMessage;
	@FindBy(xpath="//h3[text()='Quick SMS']")
	WebElement quickSMS;
	@FindBy(xpath="//label[text()='IMEI']")
	WebElement labelIMEI;
	
	public void clickOnAddIcon() {
		page.clickOnElement(addIcon);
	}
	
	public void clickOnAddClient() {
		page.clickOnElement(addClient);
	}
	
	public void getActualMessage() {
		WaitUtility.waitForElement(driver, message);
		String actualMessage = page.getElementText(message);
	}
	

	public void verifyNavigateClientPage() throws IOException {
		page.clickOnElement(addIcon);
		WaitUtility.waitForElementLocated(driver, By.xpath("//i[@class='fa fa-plus-circle']"));
		page.clickOnElement(addClient);
		String expectedMessage = ExcelUtility.getString(1, 4,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		WaitUtility.waitForElement(driver, message);
		String actualMessage = page.getElementText(message);

		Assert.assertEquals(actualMessage, expectedMessage, "Failed test");

	}
	
	public void navigateToReparartionPage() {
		page.clickOnElement(addIcon);
		page.clickOnElement(addReparation);
	}
	
//	public String getReparationPageMessage() throws InterruptedException {
//		
//		WaitUtility.waitForElement(driver, labelIMEI);
//		return page.getElementText(labelIMEI);
//	}
	
	public Boolean isIMEILabelPresent() {
		WaitUtility.waitForElement(driver, labelIMEI);
		return labelIMEI.isDisplayed();
		
	}



	public void verifyNavigateSendSMSPage() throws IOException {
		page.clickOnElement(addIcon);
		page.clickOnElement(sendSMS);
		String expectedMessage = ExcelUtility.getString(1, 6,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		WaitUtility.waitForElement(driver, sendSMSmsg);
		String actualMessage = page.getElementText(sendSMSmsg);
		Assert.assertEquals(actualMessage, expectedMessage, "Failed test");

	}

	public void verfiyNavigateToAlertPage() throws IOException {
		page.clickOnElement(alertIcon);
		page.clickOnElement(alertDrop);
		String expectedMessage = ExcelUtility.getString(1, 19,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		WaitUtility.waitForElement(driver, alertMessage);
		String actualMessage = page.getElementText(alertMessage);
		Assert.assertEquals(actualMessage, expectedMessage, "Failed test");

	}

	public void navigateToSendmailPage() {
		page.clickOnElement(addIcon);
		page.clickOnElement(sendMailicon);
	}

	public String actualSendMailMessageText() {
		
		WaitUtility.waitForElement(driver, sendMailText);
		return page.getElementText(sendMailText);
		
	
	}

	public String expectedSendMailText() throws IOException {
		String expectedMessage = ExcelUtility.getString(1, 21,
				System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		return expectedMessage;
	}
	
	public void navigateToOrderandReparationPage() {
		page.clickOnElement(reparation);
	}
	
	public String getReparartionHeading() {
		return page.getElementText(reparationHeadingMessage);
		
	}
	
	public String getMsgOfQuickSMS() {
		return page.getElementText(quickSMS);
		
	}

//	  public void SendmailText() throws IOException { String
//	  actualMessage=PageUtility.getElementText(sendMailText); 
//	  String
//	  expectedMessage = ExcelUtility.getString(1, 21,
//	  System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE",
//	  "testSheet"); 
//	  Assert.assertEquals(actualMessage, expectedMessage,"Test Pass"); }


}
