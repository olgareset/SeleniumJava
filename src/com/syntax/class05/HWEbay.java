package com.syntax.class05;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//Go to ebay.com
//get all the categories and print them in the console
//select Computers/Tables & Networking
//click on search
//verify the header

public class HWEbay {
	public static String url = "https://www.ebay.com";
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement categories = driver.findElement(By.id("gh-cat"));
		Select select = new Select(categories);
		
		List<WebElement>options = select.getOptions();
		
		for(WebElement option:options) {
			String text = option.getText();
			System.out.println(text);
			
			//select computers/tables&networking
			select.selectByVisibleText("Computers/Tablets & Networking");
			
			//click on search
			driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
			
			//verify the header
			String textExpect = "Computers, Tablets & Network Hardware";
			String textActual = driver.findElement(By.xpath("//span[@class='b-pageheader__text']")).getText();
			if(textActual.equals(textExpect)) {
				System.out.println("The text is correct");
			}else {
				System.out.println("The text is incorrect");
			}
			Thread.sleep(1000);
			driver.quit();
			
		}
		

}
}