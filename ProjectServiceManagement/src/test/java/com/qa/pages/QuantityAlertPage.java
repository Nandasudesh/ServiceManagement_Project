package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utilities.PageUtility;

public class QuantityAlertPage {
	
	public WebDriver driver;
	PageUtility page=new PageUtility();
	
	public QuantityAlertPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='dynamic-table_length']")
	WebElement count;
	@FindBy(xpath="//input[@class='form-control input-sm input-xs']")
	WebElement searchBox;
	@FindBy(id="dynamic-table_info")
	WebElement entryText;
	
	public void quantityAlertData() {
		String text=page.getElementText(entryText);
		String data=text.substring(text.indexOf("f")+ 2, text.indexOf("e")-1);
		System.out.println("No of entries: "+data);
	}
}
