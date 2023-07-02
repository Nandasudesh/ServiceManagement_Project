package com.qa.pages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.FakerUtility;
import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitUtility;

public class ReparationPage {
	public WebDriver driver;
	PageUtility page=new PageUtility();
	FakerUtility faker=new FakerUtility();
	
	public ReparationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="imei")
	WebElement imei;
	@FindBy(id="select2-client_name-container")
	WebElement clientDropDown;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement clienttextBox;
	@FindBy(xpath="//li[@id='select2-client_name-result-sg7v-4']")
	WebElement clientName;//kiran1
	@FindBy(id="category")
	WebElement category;
	@FindBy(xpath="(//span[@class='select2-selection select2-selection--single'])[6]")
	WebElement taxDropDown;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement taxTextBox;
	@FindBy(xpath="//li[@id='select2-potax2-result-t7qu-2']")
	WebElement vAT;//VAT
	@FindBy(xpath="(//span[@class='select2-selection__placeholder'])[2]")
	WebElement assignToDropDown;
	@FindBy(xpath="(//input[@class='select2-search__field'])[2]")
	WebElement assignToTextBox;
	@FindBy(xpath="//li[@id='select2-assigned_to-result-4nj2-1']")
	WebElement assignToJoeJacob;//Joe Jacob
	@FindBy(id="reparation_manufacturer")
	WebElement manufacturer;
	@FindBy(xpath="//input[@name='service_charges']")
	WebElement serviceChargeTextbox;
	@FindBy(id="reparation_model")
	WebElement model;
	@FindBy(id="add_item")
	WebElement addItem;
	@FindBy(id="defect")
	WebElement defect;
	@FindBy(xpath="warranty_card_number")
	WebElement warrantyCardNo;
	@FindBy(xpath="//span[@id='select2-warranty-container']")
	WebElement warranty;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement warrantyTextBox;
	@FindBy(xpath="//input[@id='repair_type']")
	WebElement repairTypeTextBox;
	@FindBy(xpath="//textarea[@id='accessories']")
	WebElement accessoriesTextArea;
	@FindBy(xpath="//textarea[@id='comment']")
	WebElement commentTextArea;
	@FindBy(xpath="//textarea[@id='diagnostics']")
	WebElement diagnosticsTextArea;
	@FindBy(xpath="//button[@class='pull-left btn btn-default']")
	WebElement gobackButton;
	@FindBy(xpath="//span[@id='select2-status_edit-container']")
	WebElement statusDropDown;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement statusTextBox;
	@FindBy(xpath="//div[@class='btn btn-primary btn-file']")
	WebElement browse;
	@FindBy(xpath="//button[@id='upload_modal_btn']")
	WebElement uploadButton;
	@FindBy(xpath="//input[@class='file-caption-name']")
	WebElement selectFile;
	@FindBy(xpath="//span[text()='Upload']")
	WebElement uploadFinal;
	@FindBy(xpath="(//div[@class='progress'])[3]")
	WebElement uploadCompleteMessage;
	@FindBy(xpath="(//button[@class='close'])[4]")
	WebElement closeUpload;
	@FindBy(xpath="//input[@id='repair_sms']")
	WebElement automaticTextCheckBox;
	@FindBy(xpath="//input[@id='repair_email']")
	WebElement sendmailCheckBox;
	@FindBy(xpath="//button[@id='sign_repair']")
	WebElement signRepairButton;
	@FindBy(xpath="//button[@class='prerepair_show btn btn-primary']")
	WebElement preRepairCheckListButton;
	@FindBy(xpath="//button[@id='repair_submit']")
	WebElement addReparation;
	
	public void addIMEI(String text) {
		page.setValue(imei, text);
	}
	
	public void addClient(String client) {
		page.clickOnElement(clientDropDown);
		page.setValue(clienttextBox, client);
		page.clickOnElement(clientName);
	}
	
	public void addCategory(String cat) {
		page.setValue(category, cat);
	}
	
	public void addTax(String tax) {
		page.clickOnElement(taxDropDown);
		page.setValue(taxTextBox, tax);
		page.clickOnElement(vAT);//VAT

	}
	
	public void setServiceCharge(String charge) {
		page.setValue(serviceChargeTextbox, charge);
	}
	
	//assigned to
	//manuacturer
	//model
	//defect
	
	public void setAssignedTo(String asignee) {
		page.clickOnElement(assignToDropDown);
		page.clickOnElement(assignToTextBox);
		page.clickOnElement(assignToJoeJacob);
	}
	
	public void setManufacturer(String manfct) {
		page.setValue(manufacturer, manfct);
	}
	
	public void setModel(String modell) {
		page.setValue(model, modell);
		
	}
	
	public void setDefect(String defectt) {
		page.setValue(defect, defectt);
	}
	
	
	
	
	public void uploadImage() throws AWTException, InterruptedException {
		WaitUtility.waitForElement(driver, uploadButton);
		page.clickOnElement(uploadButton);
		WaitUtility.waitForelementClickable(driver, browse);
		page.fileUpload(driver, browse, "\"C:\\Users\\nanda\\Pictures\\Screenshots\\Screenshot 2023-03-04 191015.png\"");
		//WaitUtility.waitForElement(driver, uploadFinal);
		page.clickOnElement(uploadFinal);
		String message=page.getElementText(uploadCompleteMessage);
		WaitUtility.waitForElementLocated(driver, By.xpath("//div[@class='progress-bar bg-success progress-bar-success']"));
		//WaitUtility.waitForTextToBePresent(driver, By.xpath("//div[@class='progress-bar bg-success progress-bar-success']"), message);		
		System.out.println(message);
		page.clickOnElement(closeUpload);
	
	}

	

}
