package com.syntax.review;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableBodyRecap {
	
	public static String url = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PIM")));
		driver.findElement(By.linkText("PIM")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Employee List")));
		driver.findElement(By.linkText("Employee List")).click();
		
		List<WebElement>idList = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
		
		List<WebElement>checkbox = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[1]"));
		
		for(int i = 1; i<idList.size(); i++) {
			String idText = idList.get(i).getText();
			if(idText.equals("0009")) {
				checkbox.get(i).click();
				
			}
		}		
	}
}
