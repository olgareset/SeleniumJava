package com.syntax.review;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


public class ScreenShotRecap extends CommonMethods{
	
	/*
	 * 1. Taking screen shots in Selenium 
	 * 2. Advanced Xpath 
	 * 3. Actions Class 
	 * 4. JavaScriptExecutor 
	 * 5. How to upload a file with selenium
	 */
	public static final String ORANGE_HRM_URL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";


	public static void main(String[] args) throws InterruptedException {

		/*
		 * 1. why do ve need to take ScreenShots --> verification 2. Why failures
		 * happens in our web application? - Difference in expected and actual values -
		 * NoSuchElementException - Unexpected alerts inside the application - Assertion
		 * issues
		 */

		/*
		 * How to take screenshots - TakeScrenshot interface - getScreenShotAs() -->
		 * 
		 * ChromeDriver extends RemoteWebDriver RemoteWebDriver implements
		 * TakeScreenshot interface
		 */

		setUp("chrome", ORANGE_HRM_URL);

		// Login to OrangeHrm and Take Screenshot for verification

		// 1. login OrangeHRM

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement logo=driver.findElement(By.xpath("//div[@id='branding']/a/img"));
		
		if(logo.isDisplayed()) {
			System.out.println("Login test pass");
		}else {
			System.out.println("Login Fail");
		}
		
		// 2. Take Screenshot for verification
		
			// 1. Create an object of TakesScrenshot interface indirectly by downcasting it to webdriver
		TakesScreenshot scrShot=(TakesScreenshot)driver;
			// 2. Create an object of File Class
		File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
			// 3. Save File as png or jpg type picture under requested folder
		try {
			FileUtils.copyFile(scrFile, new File("screenshot/OrangeHRM/LoginTest.png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Screenshot could not be SAVED");
		}
		
		Thread.sleep(3000);
		driver.quit();		
	}

}
