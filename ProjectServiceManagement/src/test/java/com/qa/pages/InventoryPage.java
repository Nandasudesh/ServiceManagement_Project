package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.PageUtility;
import com.qa.utilities.WaitUtility;

public class InventoryPage {
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public InventoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='More Info '])[3]")
	WebElement inventoryProductInfo;
	@FindBy(xpath="(//input[@type='search'])[1]")
	WebElement searchTextBox;
	@FindBy(xpath="//tr[@class='product_link']")
	List <WebElement> rowNo;
	@FindBy(xpath="(//div[@class='btn-group'])[3]")
	WebElement delete;
	@FindBy(xpath="//a[@class='btn btn-danger']")
	WebElement yesDelete;
	@FindBy(xpath="//p[text()='Inventory Products']//preceding-sibling::h3")
	WebElement inventoryCount;
	
	
	
	public void clickonInventoryInfo() {
		page.clickOnElement(inventoryProductInfo);
	}//65685862, 49928179 id-183
	
	public void clickonSearch(String code) {
		page.setValue(searchTextBox, code);
	}
	
	public String getAttibute(String attribute) {
		return attribute;
	}
	public void getdata(String attribute, String values) {
		page.selectElementFromListUsingGetAttribute(rowNo, attribute, values);
	}
	
	public String getInventoryCount() {
		return page.getElementText(inventoryCount);
		
	}
	//new
	public int getExpectedInventoryCount() {
		String count=page.getElementText(inventoryCount);
		int value=Integer.parseInt(count);
	int expectedcount=value-1;
	
	
		return expectedcount;
	}
	
	public int getAfterDeleteionCount() {
		String count=page.getElementText(inventoryCount);
		int value=Integer.parseInt(count);
		int afterDeleteCount=value-1;
		return afterDeleteCount;
	}
	
	public void clickOndelete() {
		WaitUtility.waitForElement(driver, delete);
		page.clickOnElement(delete);
		System.out.println("Delete");
	}
	
	public void selectYes() {
		page.clickOnElement(yesDelete);
		System.out.println("confirm delete");
	}
	
	
	
	
	
	

}
