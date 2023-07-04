package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.utilities.ExcelUtility;
import com.qa.utilities.FakerUtility;
import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitUtility;

public class AddClientPage {

	public WebDriver driver;
	PageUtility page=new PageUtility();
	FakerUtility faker=new FakerUtility();

	public AddClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='name1']")
	WebElement cname;
	@FindBy(xpath = "//input[@id='company1']")
	WebElement compname;
	@FindBy(xpath = "//input[@id='autocomplete']")
	WebElement location;
	@FindBy(xpath = "//input[@id='route']")
	WebElement addresS;
	@FindBy(xpath = "//input[@id='locality']")
	WebElement city;
	@FindBy(xpath = "//input[@id='postal_code']")
	WebElement pinCode;
	@FindBy(xpath = "//input[@id='telephone']")
	WebElement telephone;
	@FindBy(xpath = "//input[@id='email1']")
	WebElement email;
	@FindBy(xpath = "//input[@id='vat1']")
	WebElement vatno;
	@FindBy(xpath = "//input[@id='cf1']")
	WebElement ssnno;
	@FindBy(xpath = "//input[@id='image']")
	WebElement file;
	@FindBy(xpath = "//textarea[@id='comment1']")
	WebElement comment;
	@FindBy(xpath="//input[@placeholder='Select file...']")
	WebElement uploadFile;
	@FindBy(xpath="//button[@id='submit']")
	WebElement addClientButton;
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement goBackButton;
	@FindBy(xpath="//button[@id='modify_client']")
	WebElement modifyButton;
	@FindBy(xpath="//button[@id='delete_client']")
	WebElement deleteButton;
	@FindBy(xpath="//button[@id='submit']")
	WebElement saveChangesButton;
	@FindBy(xpath="//div[@id='dynamic-table_filter']//label//input")
	WebElement searchClient;
	@FindBy(xpath="(//a[text()='More Info '])[2]")
	WebElement clientMoreInfo;
	@FindBy(xpath="//li[text()='This value is required.']")
	WebElement alertMsgWithoutClient;
	@FindBy(xpath="//div[@id='titoloclienti']")
	WebElement clientIDAdded;
	

	public void addClientName() {
		String name=FakerUtility.clientName();
		page.setValue(cname, name);
		
		
	}
	
	public void addCompanyName() {
		String compName=FakerUtility.companyname();
		page.setValue(compname, compName);
	
	}
	
	public void addGeolocation() {
		String geoLocat=FakerUtility.location();
		page.setValue(location, geoLocat);
		
	}
	
	public void addAddress() {
		String address=FakerUtility.address();
		page.setValue(addresS,address);
		
	}
	
	public void addCity() {
		String cityy=FakerUtility.city();
		page.setValue(city,cityy);
		
	}
	
	public void addPincode() {
		String code=FakerUtility.postalCode();
		page.setValue(pinCode,code);
	
	}
	
	public void addPhoneNo() {
		String phone=FakerUtility.telephone();
		page.setValue(telephone,phone);

	}
	
	public void addEmail() {
		String mail=FakerUtility.email();
		page.setValue(email,mail);

	}
	
	
	public void addSSNo() {
		String ssno=FakerUtility.ssN();
		page.setValue(ssnno,ssno);
 
	}
	
	public void addComment(String commnt) {
		
		page.setValue(comment, commnt);
	}
	
	public void uploadFile() {
		page.setValue(uploadFile, "\\src\\main\\java\\Resources\\branches-1842554_960_720-1.jpg");
	}
	
	public void addClient() {
		page.clickOnElement(addClientButton);
	}
	
	

	
	public String getAlertMsg() {
		return page.getElementText(alertMsgWithoutClient);
	}
	
	
	

	
	

	public void addClientData() throws IOException{
		
		String clientname = ExcelUtility.getString(1, 8, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		String companyname = ExcelUtility.getString(1, 9, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		String locate = ExcelUtility.getString(1, 10, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE", "testSheet");
		String addresss = ExcelUtility.getString(1, 11, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE","testSheet");
		String City = ExcelUtility.getString(1, 12, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE","testSheet");
		String pincode = ExcelUtility.getNumeric(1, 13, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE","testSheet");
		String phone = ExcelUtility.getNumeric(1, 14, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE","testSheet");
		String Email = ExcelUtility.getString(1, 15, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE","testSheet");
		String vatNo = ExcelUtility.getString(1, 16, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE","testSheet");
		String SSNo = ExcelUtility.getString(1, 17, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE","testSheet");
		String cmnt = ExcelUtility.getString(1, 18, System.getProperty("user.dir") + "constants.Constant.TESTDATAFILE","testSheet");

		page.setValue(cname, clientname);
		page.setValue(compname, companyname);
		page.setValue(location, locate);
		page.setValue(addresS, addresss);
		page.setValue(city, City);
		page.setValue(pinCode, pincode);
		page.setValue(telephone, phone);
		page.setValue(email, Email);
		page.setValue(vatno, vatNo);
		page.setValue(ssnno, SSNo);
		page.setValue(comment, cmnt);
		page.setValue(uploadFile, "\\src\\main\\java\\Resources\\branches-1842554_960_720-1.jpg");
		page.clickOnElement(addClientButton);
		
	}
	
	public String getClientAddedMessage(){
		WaitUtility.waitForElement(driver, clientIDAdded);
		return page.getElementText(clientIDAdded);
	}
	
	
	

}
