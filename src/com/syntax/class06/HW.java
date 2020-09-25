package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {

	//Go to http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html
	//click on each button and handle the alert accordingly
	
	public static String url = "http://166.62.36.207/syntaxpractice/javascript-alert-box-demo.html";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement alertBox = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
		alertBox.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		WebElement confirmBox = driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']"));
		confirmBox.click();
		Thread.sleep(2000);
		alert.dismiss();
		
		WebElement promptBox = driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']"));
		promptBox.click();
		Thread.sleep(2000);
		
		alert.sendKeys("EnterWord");
		alert.accept();
		driver.quit();		

	}

}
