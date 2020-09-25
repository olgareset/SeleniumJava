package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handleWindows {
	
	public static String url = "http://accounts.google.com/signup";
	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		String mainPageHandle = driver.getWindowHandle();
		System.out.println(mainPageHandle); // printed main page
		
		WebElement helpLink = driver.findElement(By.linkText("Help"));
		helpLink.click();
		
		Set<String>allWindowHandles = driver.getWindowHandles(); // returns Set bc set- no duplicates
		System.out.println(allWindowHandles.size());
		
		Iterator<String>it = allWindowHandles.iterator();
		mainPageHandle = it.next();
		String childHandle = it.next();
		System.out.println(childHandle); // printed second page
		
		Thread.sleep(2000);
		driver.switchTo().window(mainPageHandle); // go back to main page

}
}
