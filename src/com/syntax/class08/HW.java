package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW {
	//go to https://the-internet.herokuapp.com/dynamic_controls
	//click on checkbox and click on remove
	//verify the text
	//click on enable verify the textbox is enabled
	//enter text and click disable
	//verify the textbox is disabled
	
	public static String url = "https://the-internet.herokuapp.com/dynamic_controls";
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		// click on checkbox
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"checkbox\"]/input"));
		checkbox.click();
		
		// click on remove
		WebElement removeBtn = driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button"));
		removeBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));
        		
		// verify the text
		WebElement textIsGone = driver.findElement(By.xpath("//*[@id=\"message\"]"));
		String text = textIsGone.getText();
		System.out.println("Text displayed: "+ text);
	
		// click on enable
		WebElement enableBtn = driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		enableBtn.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver,20);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));
		
		// verify the textbox is enabled
		WebElement textIsEnabled = driver.findElement(By.xpath("//*[@id=\"message\"]"));
		String text1 = textIsEnabled.getText();
		System.out.println("Text dispayed: "+ text1);
		
		// enter text
		WebElement textbox = driver.findElement(By.xpath("//*[@id=\"input-example\"]/input"));
		textbox.sendKeys("Text Entered");
		
		WebDriverWait wait3 = new WebDriverWait(driver,20);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-example\"]/button")));
		
		// click disable btn
		WebElement disableBtn= driver.findElement(By.xpath("//*[@id=\"input-example\"]/button"));
		disableBtn.click();
		
		WebDriverWait wait4 = new WebDriverWait(driver, 20);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));
		
		// verify the textbox is disabled
		WebElement textBoxIsDisabled = driver.findElement(By.xpath("//*[@id=\"message\"]"));
		String text2 = textBoxIsDisabled.getText();
		System.out.println("Text displayed: "+ text2);
		
		driver.close();

}
}
