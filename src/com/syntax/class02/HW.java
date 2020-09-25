package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
//1. go to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
//2. Fill out the sign up form
//3. Click on register
//4. close the browser
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
		driver.findElement(By.id("customer.firstName")).sendKeys("Masha");
		driver.findElement(By.id("customer.lastName")).sendKeys("Ivanova");
		driver.findElement(By.id("customer.address.street")).sendKeys("456 Main Street");
		driver.findElement(By.id("customer.address.city")).sendKeys("Philadelphia");
		driver.findElement(By.name("customer.address.state")).sendKeys("PA");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("123-456-7898");
		driver.findElement(By.id("customer.ssn")).sendKeys("885-42-6582");
		driver.findElement(By.id("customer.username")).sendKeys("fokus");
		driver.findElement(By.id("customer.password")).sendKeys("abrakadabra");
		driver.findElement(By.id("repeatedPassword")).sendKeys("abrakadabra");
		driver.findElement(By.className("button")).click();
		Thread.sleep(2000);
		driver.quit();
		
		

	}

}
