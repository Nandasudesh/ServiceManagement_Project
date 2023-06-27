package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.FakerUtility;
import com.qa.utilities.PageUtility;

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
	@FindBy(id="category")
	WebElement category;
	@FindBy(xpath="(//span[@class='select2-selection select2-selection--single'])[6]")
	WebElement taxDropDown;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement taxTextBox;
	@FindBy(xpath="(//span[@class='select2-selection__placeholder'])[2]")
	WebElement assignToDropDown;
	@FindBy(xpath="(//input[@class='select2-search__field'])[2]")
	WebElement assignToTextBox;
	@FindBy(id="reparation_manufacturer")
	WebElement manufacturer;
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
	@FindBy(xpath="//button[@id='upload_modal_btn']")
	WebElement uploadButton;
	@FindBy(xpath="//input[@class='file-caption-name']")
	WebElement selectFile;
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
	
	
	
	public void addReparation() {
		
	}
	

}
