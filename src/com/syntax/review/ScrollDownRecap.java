package com.syntax.review;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollDownRecap extends CommonMethods{
	
public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "https://www.cnn.com/");
		
		// Perform Scroll on application using Selenium for ceration amaount of pixels
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,800)");
		
		Thread.sleep(3000);
		
		// Scroll down to a WebElement
		
		// Perform Scroll on application using Selenium
		
		WebElement searchBar=driver.findElement(By.id("footer-search-bar"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", searchBar);
				
		Thread.sleep(3000);
//		driver.quit();
	}

}
