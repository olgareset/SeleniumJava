package com.syntax.class07;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
	//Go to https://demoqa.com/browser-windows
	//click on New Tab and print the text from new tab in the console
	//click on New Window and print the text from new window in the console
	//click on New Window Message and print the text from new window in the console
	//Verify the title is displayed
	//Print out the title of the main page
	
	public static String url = "https://demoqa.com/browser-windows";
	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		// First: New Tab		
		String mainPageHandle = driver.getWindowHandle();	
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		WebElement newTab = driver.findElement(By.cssSelector("button[id='tabButton']"));
		newTab.click();
		
		Set<String>allWindowHandles1 = driver.getWindowHandles();
		for(String currentWindow1:allWindowHandles1) {
			driver.switchTo().window(currentWindow1);			
		}
		WebElement textNewTab = driver.findElement(By.id("sampleHeading"));
		System.out.println("1. Text from New Tab: "+textNewTab.getText());
		driver.close();	
		
		//for(String first:allWindowHandles) {
	//	if(!first.equals(mainPageHandle)) {
	//		driver.switchTo().window(first);
	//		WebElement text1 = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
	//		System.out.println(text1.getText());
	//		driver.close();
	//	}
		
		//Second: New Window
		
		driver.switchTo().window(mainPageHandle);
		
		WebElement newWindow = driver.findElement(By.id("windowButton"));
		newWindow.click();
		Set<String>allWindowHandles2 = driver.getWindowHandles();
		for(String currentWindow2:allWindowHandles2) {
			driver.switchTo().window(currentWindow2);						
		}
		WebElement textNewWindow = driver.findElement(By.id("sampleHeading"));
		System.out.println("2. Text from New Window: "+textNewWindow.getText());
		driver.close();	
		
		// Third: New Window Message
		
	//	driver.switchTo().window(mainPageHandle);
	//	WebElement newWindowMessage = driver.findElement(By.id("messageWindowButton"));
	//	newWindowMessage.click();
	//	Set<String>allWindowHandles3 = driver.getWindowHandles();
	//	for(String currentWindow3 :allWindowHandles3) {				
	//		driver.switchTo().window(currentWindow3);
	//	}
	//	WebElement textNewWindowMessage = driver.findElement(By.partialLinkText("increases"));
	//	System.out.println("3. Text from New Window Message: "+ textNewWindowMessage.getText());
	//.	driver.close();
		
		driver.switchTo().window(mainPageHandle);
		
	//	String title=driver.getTitle();
	//    if("ToolsQA".equals(title)){
	//      System.out.println("Verification is success" );	
	//       System.out.println("page title is:" + title );
	//    }
	//    else{
	//   	System.out.println("Verification is failed ");
	//    }
	//    driver.close();
		
		WebElement title  = driver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']"));
		boolean isDisplayed = title.isDisplayed();
		System.out.println("Title is displayed: "+ isDisplayed );
		System.out.println("Title is: "+driver.getTitle());
		driver.quit();
		
	}
		
}
