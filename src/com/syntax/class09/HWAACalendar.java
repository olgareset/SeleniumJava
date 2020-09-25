package com.syntax.class09;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWAACalendar {

public static String url = "http://aa.com/homepage.do";
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	//FROM
	WebElement origAirport = driver.findElement(By.name("originAirport"));
	origAirport.clear();
	Thread.sleep(2000);
	origAirport.sendKeys("DCA");
	
	//TO
	WebElement destAirport = driver.findElement(By.name("destinationAirport"));
	destAirport.sendKeys("JFK");
	
	//Open Depart Table
	WebElement calendarDepart = driver.findElement(By.id("aa-leavingOn"));
	calendarDepart.click();
	
	//Picking Depart Month While Loop
	WebElement departureMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month'])[1]"));
	String departMonth = departureMonth.getText();
	while(!departMonth.equals("November")) {
		WebElement next = driver.findElement(By.xpath("//a[@title = 'Next']"));
        next.click();
        departureMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month'])[1]"));
        departMonth = departureMonth.getText();
				
	}
	//Picking Depart Day List + For Loop
	List<WebElement>departDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
	for(WebElement departDate : departDates) {
		if(departDate.getText().equals("5")) {
			departDate.click();
			break;
		}
	}
	
}
}
