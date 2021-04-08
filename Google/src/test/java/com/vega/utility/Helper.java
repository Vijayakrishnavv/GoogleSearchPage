package com.vega.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import net.bytebuddy.implementation.bind.annotation.TargetMethodAnnotationDrivenBinder;

public class Helper {
	
	public static void captureScreenshotOnFailure(WebDriver driver)
	{
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try 
		{
		//	FileUtils.copyFile(src, new File("./Screenshots/Portal" + this.getClass().getName() + ".png");
			
			org.openqa.selenium.io.FileHandler.copy(src, new File("./FailureScreenshots/Google" + getCurrentDateTime() + ".png"));
		} 
		catch (IOException e) 
		{
			
			System.out.println("Not able to take screenshot"+e.getMessage());
		}
	}
	
	public static void captureScreenshotOnSuccess(WebDriver driver)
	{
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try 
		{
		//	FileUtils.copyFile(src, new File("./Screenshots/Portal" + this.getClass().getName() + ".png");
			
			org.openqa.selenium.io.FileHandler.copy(src, new File("./SuccessScreenshots/Google" + getCurrentDateTime() + ".png"));

		} 
		catch (IOException e) 
		{
			
			System.out.println("Not able to take screenshot"+e.getMessage());
		}
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customDate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date date = new Date();
		
		return customDate.format(date);
		 
		
		
		
	}

}
