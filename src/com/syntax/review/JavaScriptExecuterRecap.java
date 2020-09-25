package com.syntax.review;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;



public class JavaScriptExecuterRecap extends CommonMethods {

	/*
	 * JavaScript? Piece of code which makes web appications interactive and dynamic
	 * We may not be able to use Locators JavaScriptExecuter --> It helps us to run
	 * JS codes inside Selenium
	 */
	public static final String ORANGE_HRM_URL="https://opensource-demo.orangehrmlive.com/index.php/auth/login";


	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", ORANGE_HRM_URL);

		// Login OrangeHRM
		// Navigate to Leave List menu by using JavaScriptExecutor

		// 1. login OrangeHRM

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(2000);
		
		WebElement leaveBtn=driver.findElement(By.linkText("Leave"));
		
		// JavaScript Click
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", leaveBtn);
		
		Thread.sleep(2000);
		
		WebElement leaveListBtn=driver.findElement(By.linkText("Leave List"));
		js.executeScript("arguments[0].click();", leaveListBtn);
		

		Thread.sleep(2000);
		
		// JavaScript ScrollDown
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,150)");
		
		
		driver.quit();	
		
	}
}
