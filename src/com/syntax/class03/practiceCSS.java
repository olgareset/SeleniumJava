package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practiceCSS {

		public static void main(String[] args) throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
					
			WebDriver driver = new ChromeDriver();
			driver.get("http://166.62.36.207/syntaxpractice/index.html");
			driver.findElement(By.cssSelector("a#btn_basic_example")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[text() = 'Simple Form Demo'])[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("input[placeholder^= 'Please enter']")).sendKeys("batch 7 rock!!!");
			driver.findElement(By.xpath("//button[contains(text(), 'Show Message')]")).click();
			driver.findElement(By.xpath("//input[@id='sum1']")).sendKeys("12365");
			driver.findElement(By.cssSelector("input[id = 'sum2']")).sendKeys("7896");
			driver.findElement(By.xpath("//button[contains(text(), 'Get Tota')]")).click();
			driver.quit();
			
	}

}
