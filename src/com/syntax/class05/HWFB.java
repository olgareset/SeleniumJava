package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HWFB {
	
//	Go to facebook sign up page
//	Fill out the whole form
//	Click signup
	
	public static String url = "https://www.facebook.com/r.php";
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		firstName.sendKeys("Lena");
		WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
		lastName.sendKeys("Petrova");
		WebElement email = driver.findElement(By.id("u_0_s"));
		email.sendKeys("abc@gmail.com");
		WebElement reEnterEmail = driver.findElement(By.id("u_0_v"));
		reEnterEmail.sendKeys("abc@gmail.com");
		WebElement pass = driver.findElement(By.cssSelector("input[name='reg_passwd__']"));
		pass.sendKeys("Abc@123");
		
		WebElement monthDD = driver.findElement(By.id("month"));
		
		Select selectMonth = new Select(monthDD);
		selectMonth.deselectByValue("9");
		
		Select selectDay = new Select(driver.findElement(By.id("day")));
		selectDay.selectByValue("20");
		
		WebElement yearDD = driver.findElement(By.id("year"));
		Select selectYear = new Select(yearDD);
		selectYear.selectByVisibleText("1990");
		Thread.sleep(1000);
		
	//	driver.findElement(By.id("u_0_6")).click();
		
		List<WebElement>gender = driver.findElements(By.name("sex"));
		
		for(WebElement sex: gender) {
			String value = sex.getAttribute("value");
			if(value.equals("1")) {
				sex.click();
				break;
			}
		}
		WebElement signUp = driver.findElement(By.name("websubmit"));
		signUp.click();
		Thread.sleep(1000);
		driver.close();
		
	}
}