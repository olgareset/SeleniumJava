package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElements {

	public static void main(String[] args) throws InterruptedException {
  
System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.findElement(By.id("email")).sendKeys("syntax");
		driver.findElement(By.name("pass")).sendKeys("syntax123");
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(3000); // if next line 19 didn't work need to insert Thread.sleep bc page needs to 
		//be fully loaded, Selenium too fast.
	//	driver.findElement(By.linkText("Forgot Password?")).click();
		driver.findElement(By.partialLinkText("Forgot")).click();
		Thread.sleep(2000);
		driver.quit();
		
		
		
	}

}
