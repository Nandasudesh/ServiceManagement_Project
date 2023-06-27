package com.qa.utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public static String getElementText(WebElement element) {
		return element.getText();
		
	}

	public void setValue(WebElement element, String value) {
		element.sendKeys(value);
		

	}
	
	public String getURL(WebDriver driver) {
		return driver.getCurrentUrl();
		
	}

	public void selectDropDownbyText(WebElement element, String text) {
		Select selectObj = new Select(element);
		selectObj.selectByVisibleText(text);
	}

	public static void selectDropDownbyValue(WebElement element, String value) {
		Select selectObj = new Select(element);
		selectObj.selectByValue(value);
	}

	public static boolean isElementDisplayed(WebElement element) {

		return element.isDisplayed();
	}

	public static boolean isElementEnabled(WebElement element) {

		return element.isEnabled();
	}

	public static boolean isElementSelected(WebElement element) {

		return element.isSelected();
	}

	public static void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

	}

	public static void clickAndHoldOnElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(element).perform();
	}

	public static int getElementRowSize(List<WebElement> element) {
		return element.size();

	}

	public static int getElementColumnSize(List<WebElement> element) {
		return element.size();
	}

	public static void stopPageRefresh(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.stop();");
	}
	
	public String getTitile(WebDriver driver) {
		return driver.getTitle();
	}

}
