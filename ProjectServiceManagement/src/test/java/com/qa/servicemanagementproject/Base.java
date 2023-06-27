package com.qa.servicemanagementproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.utilities.ScreenshotUtility;

public class Base {

	public WebDriver driver;
	public Properties prop1, prop2;
	public FileInputStream fs1, fs2;
	public ScreenshotUtility screenShot1;
	ChromeOptions ops = new ChromeOptions();

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		prop1 = new Properties();
		prop2 = new Properties();
		// path of congi.properties
		try {
			fs1 = new FileInputStream(System.getProperty("user.dir") + constants.Constant.CONFIGfILE);
		} catch (Exception e) {

		}
		// loading config.properties
		try {
			prop1.load(fs1);//loads data from reader obj
		} catch (Exception e) {

		}

		try {
			fs1 = new FileInputStream(System.getProperty("user.dir") + constants.Constant.TESTDATAFILE);
		} catch (Exception e) {

		}
		try {
			prop2.load(fs1);
		} catch (Exception e) {

		}

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			ops.addArguments("--remote-allow-origins=*");//?
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + constants.Constant.CHROME);
			driver = (WebDriver) new ChromeDriver(ops);
		} else if (browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + constants.Constant.EDGE);
			driver = new EdgeDriver();
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.get(prop1.getProperty("url"));
	}
//ITestResult is a testNG listener. listeners are testng annotations, based on instructions, it will do accordingly. used for report generating
	//enhancing reports
	@AfterMethod
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			screenShot1 = new ScreenshotUtility();
			screenShot1.getScreenshot(driver, iTestResult.getName());
			ScreenshotUtility.getScreenshot(driver, iTestResult.getName());
		}
		driver.quit();
	}

}