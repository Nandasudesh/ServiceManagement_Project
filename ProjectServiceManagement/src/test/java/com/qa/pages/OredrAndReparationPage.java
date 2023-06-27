package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.PageUtility;

public class OredrAndReparationPage {
	
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public OredrAndReparationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	WebElement filterIcon;
	@FindBy(xpath="//input[@name='date']")
	WebElement date;
	@FindBy(xpath="//select[@name='manufacturer']")
	WebElement mapkaDropDown;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement mapkaTextBox;
	@FindBy(xpath="//li[@class='select2-results__option select2-results__option--highlighted']")
	WebElement textSecond;
	@FindBy(xpath="(//select[@name='has_warranty'])[1]")
	WebElement hasWarrantyDropDown;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement hasWarrantyTestBox;
	@FindBy(xpath="//li[@id='select2-has_warranty-4b-result-8ga7-1']")
	WebElement inWarantty;
	@FindBy(xpath="//select[@name='status']")
	WebElement statusDropDown;
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement statusTextBox;
	@FindBy(xpath="//input[@value='Filter result']")
	WebElement filterButton;
	@FindBy(xpath="//li[@id='select2-has_warranty-30-result-c5om-1']")
	WebElement inWarranty;
	@FindBy(xpath="//li[@id='select2-status-we-result-jig6-1']")
	WebElement inProgressStatus;
	
	
	public void selectFilterIcon() {
		page.clickOnElement(filterIcon);
	}
//	public void selectTimePeriod() {
//		String text=
//		page.selectDropDownbyText(date, null);
//	}
	
	public void mapkaSelect(String value) {
		page.clickOnElement(mapkaDropDown);
		page.setValue(mapkaTextBox, value);
		page.clickOnElement(textSecond);
		
	}
	
	public void selectHasWarranty(String value) {
		page.clickOnElement(hasWarrantyDropDown);
		page.setValue(hasWarrantyTestBox, value);
		page.clickOnElement(inWarranty);
	}
	
	public void selectStatus(String value) {
		page.clickOnElement(statusDropDown);
		page.setValue(statusTextBox, value);
		page.clickOnElement(inProgressStatus);
		
	}
	
	public void closeFilter() {
		page.clickOnElement(filterIcon);
	}

}
