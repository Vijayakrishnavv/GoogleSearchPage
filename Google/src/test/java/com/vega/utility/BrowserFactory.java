package com.vega.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class BrowserFactory 
{
	@Parameters(value= {"browser","appURL"})
	public static WebDriver startApplication(WebDriver driver, String browser, 	String appURL) {
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		//	driver.get("chrome://settings/clearBrowserData");
		//	driver.findElement(By.id("clearBrowsingDataConfirm")).click();

		} else if (browser.equals("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			System.out.println("We do not support this browser");

		}

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Get the URL or hit the URL
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;

	}
	
	
	public static void closeBrowser(WebDriver driver) {

		driver.close();

	}

}
