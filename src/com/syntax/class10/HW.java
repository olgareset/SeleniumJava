package com.syntax.class10;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HW {
	
	public static String url = "https://artoftesting.com/samplesiteforselenium";
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement mainPageText = driver.findElement(By.id("idOfDiv"));
		System.out.println("Text on the main page: "+mainPageText.getText());
		
		WebElement clickLink = driver.findElement(By.linkText("This is a link"));
		clickLink.click();
		
		// window handling
		String windowMainPage = driver.getWindowHandle(); // main Page window
		Set<String>allWindows = driver.getWindowHandles(); // all windows
		
		Iterator<String> it = allWindows.iterator();
		while(it.hasNext()) {
			String currentWindow = it.next();
			if(!currentWindow.equals(windowMainPage)) {

				String currentWindowText = driver.switchTo().window(currentWindow).getTitle();
				System.out.println("Child Window: "+currentWindowText);
				System.out.println("Child Window URL: "+ driver.getCurrentUrl());
				driver.close();
		
				driver.switchTo().window(windowMainPage); // go back to main page
				
				// textBox with single click
				driver.findElement(By.id("fname")).sendKeys("Greetings", Keys.TAB);
				driver.findElement(By.id("idOfButton")).click();
				
				//doubleClick
				Actions action = new Actions(driver);
				
				WebElement dClick = driver.findElement(By.id("dblClkBtn"));
				action.doubleClick(dClick).perform();
				
		//handling Alert
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
				
		//RadioButton
		List<WebElement>radioButtons = driver.findElements(By.name("gender"));
		for(WebElement rButton : radioButtons) {
			String value = rButton.getAttribute("value");
			if(value.equalsIgnoreCase("female")) {
				rButton.click();
				break;	
			}
		}
		// Check Boxes
		List<WebElement>checkBoxBtns = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for(WebElement checkBtn : checkBoxBtns) {
			String value = checkBtn.getAttribute("value");
			if(value.equalsIgnoreCase("Automation")) {
				checkBtn.click();
				Thread.sleep(2000);
				break;
			}
		}
	// Drop Down
	WebElement DD = driver.findElement(By.id("testingDropdown"));
	Select select = new Select(DD);
	select.selectByVisibleText("Manual Testing");
	
	// Alert Box
	WebElement alertBox = driver.findElement(By.xpath("//*[@id=\"AlertBox\"]/button"));
	alertBox.click();
	Thread.sleep(2000);
	System.out.println("Alert text is: "+alert.getText());
	alert.accept();
				
	// Confirm Box
	WebElement confirmBox = driver.findElement(By.xpath("//*[@id=\"ConfirmBox\"]/button"));
	confirmBox.click();
	System.out.println("Confim Box text is: "+ alert.getText());
	alert.dismiss();
	
	// Drag and Drop
	WebElement drag = driver.findElement(By.id("sourceImage"));
	WebElement drop = driver.findElement(By.id("targetDiv"));
	Thread.sleep(2000);
//	action.dragAndDrop(drag, drop).perform();
	action.clickAndHold(drag).moveToElement(drop).release().build().perform();
	Thread.sleep(3000);
	driver.navigate().refresh();
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File sourceFile = ts.getScreenshotAs(OutputType.FILE);
	
	try {
		FileUtils.copyFile(sourceFile, new File("./screenshots/ArtOfTest.png"));
	} catch (IOException e) {			
		e.printStackTrace();
	}
							
							
							
						
}
			
}
}		
}

