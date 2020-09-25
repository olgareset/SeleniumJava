package com.syntax.class03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW {

	public static void main(String[] args)throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a#btn_basic_example")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a#btn_inter_example")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Input Form with Validations']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Masha");
		driver.findElement(By.cssSelector("input[name*='last_name']")).sendKeys("Ivanova");
		driver.findElement(By.cssSelector("input[name^='email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("123-456-7898");
		driver.findElement(By.xpath("//input[@name = 'address']")).sendKeys("456 Post Rd.");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Norwalk");
		
		WebElement dropDown = driver.findElement(By.name("state"));
		Select dd = new Select(dropDown);
		dd.selectByVisibleText("Vermont");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name = 'zip']")).sendKeys("12345");
		driver.findElement(By.cssSelector("input[name = 'website']")).sendKeys("www.abc.com");
		
		List<WebElement>radio = driver.findElements(By.name("hosting"));
		for(WebElement host:radio) {
			String str = host.getAttribute("value");
			if(str.equalsIgnoreCase("yes")) {
				host.click();
				break;
			}
		}
		driver.findElement(By.cssSelector("textarea[name='comment']")).sendKeys("description");
		driver.findElement(By.cssSelector("button[class = 'btn btn-default']")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		
		
	}

}
