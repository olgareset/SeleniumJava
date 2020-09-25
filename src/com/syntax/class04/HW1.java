package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1 {

	public static String url = "http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html";
	public static void main(String[] args) throws InterruptedException {
		// Go to http://166.62.36.207/syntaxpractice/basic-radiobutton-demo.html
		//Select any radiobutton and the age group ---> use List and loop. Click on get values
		//Verify the text in the page -- do not hardcode the values and compare

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		List<WebElement>radio = driver.findElements(By.name("gender"));
		for(WebElement webElement:radio) {
			String value = webElement.getAttribute("value");
			if(value.equalsIgnoreCase("Female")) {
				webElement.click();
				break;
			}
		}
		WebElement ageRadBut = driver.findElement(By.xpath("//input[@value='0-5']"));
		System.out.println(ageRadBut.isSelected());
		ageRadBut.click();
		driver.findElement(By.xpath("//button[@onclick='getValues();']")).click();
		
		
		
	}

}
