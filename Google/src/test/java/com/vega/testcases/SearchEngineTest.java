package com.vega.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.vega.pages.BaseTest;
import com.vega.pages.SearchEnginePage;




public class SearchEngineTest extends BaseTest{

	WebDriverWait wait ;

	SoftAssert softassert = new SoftAssert();

	//Verify Title of google search engine
	@Test(priority = 1, retryAnalyzer = com.vega.listners.RetryAnalyzer.class)
	public void verifySeachEngineTitle(){
		SearchEnginePage spage = PageFactory.initElements(driver, SearchEnginePage.class);
		spage.getTitleOfPage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		softassert.assertEquals(driver.getTitle(), "Google");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		softassert.assertAll();
	}

	//Verify google icon, search button and feeling lucky button
	@Test(priority = 2, retryAnalyzer = com.vega.listners.RetryAnalyzer.class)
	public void verifySeachEngineIcon(){
		SearchEnginePage spage = PageFactory.initElements(driver, SearchEnginePage.class);
		spage.check_for_icon_Button();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		boolean verifyFeelingBtn = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//following::input[@class='RNmpXc']")).isDisplayed();
		boolean verifySearchBtn = driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//following::input[@class='gNO89b']")).isDisplayed();
		softassert.assertEquals(verifyFeelingBtn, true);
		softassert.assertEquals(verifySearchBtn, true);
		softassert.assertAll();
	}

	//Search for the key word and verify the result
	@Test(priority = 3, retryAnalyzer = com.vega.listners.RetryAnalyzer.class)
	public void search_KeyWord(){
		SearchEnginePage spage = PageFactory.initElements(driver, SearchEnginePage.class);
		spage.searchData(excel.getStringData("SearchSheet", 1, 0));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,20);
		WebElement tigerSearch = driver.findElement(By.xpath("//a[@href='https://en.wikipedia.org/wiki/Tiger']//following::h3[contains(text(),'Tiger - Wikipedia')]"));
		wait.until(ExpectedConditions.visibilityOf(tigerSearch));
		String verifyTigerSearch = tigerSearch.getText();
		softassert.assertEquals(verifyTigerSearch, excel.getStringData("SearchSheet", 1, 1));
		softassert.assertAll();
	}
}
