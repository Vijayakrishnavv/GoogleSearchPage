package com.vega.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vega.utility.BrowserFactory;
import com.vega.utility.ConfigDataProvider;
import com.vega.utility.ExcelDataProvider;
import com.vega.utility.Helper;




public class BaseTest {
	
	public WebDriver driver ;
	public ConfigDataProvider config;
	public ExcelDataProvider excel;
	
	@BeforeSuite
	public void setUp() {
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
	}
	
	@BeforeClass
	@Parameters(value = {"browser","appURL"})
	public void BrowserStart(String browser , String appURL) {
		
		driver = BrowserFactory.startApplication(driver, browser ,  appURL);
		
		
		
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshotOnFailure(driver);
		}
	}

	@AfterMethod
	public void screenOnSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			Helper.captureScreenshotOnSuccess(driver);
		}
	}
}
