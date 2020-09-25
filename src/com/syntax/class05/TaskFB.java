package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Facebook dropdown verification
//Open chrome browser. Go to “https://www.facebook.com”. Verify:
//month dd has 12 month options
//day dd has 31 day options
//year dd has 115 year options
//Select your date of birth	
//Quit browser

public class TaskFB {
	public static String url = "https://www.facebook.com/r.php";
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		WebElement monthDD = driver.findElement(By.id("month"));
		Select selectMonth = new Select(monthDD);
		
		List<WebElement> optionsMonth = selectMonth.getOptions();
		if (optionsMonth.size() - 1 == 12) {
			System.out.println("Options of month size is correct");
		} else {
			System.out.println("Options of month size is NOT correct");
		}
		WebElement dayDD = driver.findElement(By.id("day"));		
		Select selectDay = new Select(dayDD);		
		List<WebElement> optionsDay = selectDay.getOptions();
		if (optionsDay.size() - 1 == 31) {
			System.out.println("Options of day size is correct");
		} else {
			System.out.println("Options of day size is NOT correct");
		}
		WebElement yearDD = driver.findElement(By.id("year"));		
		Select selectYear = new Select(yearDD);		
		List<WebElement> optionsYear = selectYear.getOptions();
		if (optionsYear.size() - 1 == 115) {
			System.out.println("Options of year size is correct");
		} else {
			System.out.println("Options of year size is NOT correct");
		}
		System.out.println(optionsYear.size());		
		driver.close();	
		}

}
