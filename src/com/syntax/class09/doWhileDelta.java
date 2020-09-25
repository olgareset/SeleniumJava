package com.syntax.class09;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class doWhileDelta {
	
public static String url = "http://delta.com";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	WebElement calendar = driver.findElement(By.id("input_departureDate_1"));	
	calendar.click();
	
	WebElement dMonth = driver.findElement(By.className("dl-datepicker-month-0"));
	String departMonth = dMonth.getText();
	
	do {
		WebElement next = driver.findElement(By.xpath("//span[text() = 'Next']"));
		next.click();
		departMonth =dMonth.getText();
	}while(!departMonth.equals("October"));
	List<WebElement>departDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-0']/tr/td"));
	
	for(WebElement departDate:departDates) {
		if(departDate.getText().equals("15")) {
			departDate.click();
			break;
		}
	}
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement rMonth = driver.findElement(By.className("dl-datepicker-month-1"));
	String returnMonth = rMonth.getText();
	do {
		WebElement next = driver.findElement(By.xpath("//span[text()='Next']"));
		next.click();
		returnMonth=rMonth.getText();
	}while(!returnMonth.equals("December"));
	
	List<WebElement>returnDates=driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-1']/tr/td"));
	for(WebElement returnDate:returnDates) {
		if(returnDate.getText().equals("20")){
			returnDate.click();
			break;
		}
	}
	WebElement done = driver.findElement(By.className("donebutton"));
	done.click();
	
	

}
}
