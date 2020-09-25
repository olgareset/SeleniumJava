package com.syntax.class11;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class jsExecutorDemo2 {
	
	public static String url = "http://amazon.com";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -500)");
		
		WebElement backToTop = driver.findElement(By.xpath("//span[text() = 'Back to top']"));
		js.executeScript("arguments[0].scrollIntoView(true);", backToTop);

}
}
