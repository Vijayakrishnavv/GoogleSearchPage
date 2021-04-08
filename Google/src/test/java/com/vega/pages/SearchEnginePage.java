package com.vega.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class SearchEnginePage{

	WebDriver driver;

	public SearchEnginePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@title='Search']") WebElement searchBox;
	@FindBy(xpath="//img[@src='/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png']") WebElement googleIcon;
	@FindBy(xpath="//div[@class='FPdoLc tfB0Bf']//following::input[@class='gNO89b']") WebElement searchBtn;
	@FindBy(xpath="//div[@class='FPdoLc tfB0Bf']//following::input[@class='RNmpXc']") WebElement feelingLuckyBtn;
	@FindBy(xpath="//a[@href='https://en.wikipedia.org/wiki/Tiger']//following::h3[contains(text(),'Tiger - Wikipedia')]") WebElement searchedKey;
	


	public void getTitleOfPage() {
		driver.getTitle();
	}
	
	public void check_for_icon_Button() {
		googleIcon.isDisplayed(); 
		feelingLuckyBtn.isDisplayed();
	}
	
	public void searchButton_click() {
		searchBtn.click();
	}
	
	public void searchData(String searchData) {
		searchBox.clear();
		searchBox.sendKeys(searchData);
		searchBox.sendKeys(Keys.ENTER);
	}
}

