package com.syntax.review;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonMethods {	

	public static WebDriver driver;

	public static final String HMRS_URL="http://166.62.36.207/humanresources/symfony/web"
			+ "/index.php/auth/login";
	public static final String SyntaxPrctice_URL="http://jiravm.centralus.cloudapp.azure."
			+ "com:8081/index.html";
	public static final String Facebook_URL="https://www.facebook.com/";
	public static final String Ebay_URL="https://www.ebay.com/";
	public static final String CHROME_DRIVER_FILEPATH="/SeleniumReviewBatch7/drivers/"
			+ "chromedriver.exe";	

	/**
	 * Use this method in need of opening browser and target url
	 * @param browser The desired browser
	 * @param url	 The desired url
	 */

	public static void setUp(String browser, String url){

		if(browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\hvanl\\eclipse-workspace\\"
					+ "SeleniumReviewBatch7\\drivers\\geckodriver.exe");
			
        // I need to install Firefox
			
			driver=new FirefoxDriver();
		}else {
			System.err.println("Browser not supported");
		}
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(40,  TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);

		driver.get(url);
	}
	public static void acceptAlert() {
		try {
			Alert alert=driver.switchTo().alert();

			alert.accept();

		}catch(NoAlertPresentException e) {

			System.out.println("No Alert is present");
		}
	}
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();

			alert.dismiss();

		}catch(NoAlertPresentException e) {

			System.out.println("No Alert is present");
		}
	}
	public static String getAlertText() {

		String alertText=null;
		try {
			Alert alert=driver.switchTo().alert();

			alertText=alert.getText();

		}catch(NoAlertPresentException e) {

			System.out.println("No Alert is present");
		}
		return alertText;
	}
	public static void switchToFrame(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);

		}catch(NoSuchFrameException e){

			System.out.println("Frame is not present");
		}
	}	
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);

		}catch(NoSuchFrameException e){

			System.out.println("Frame is not present");
		}
	}
	public static void switchToFrame(int index) {
		try {

			driver.switchTo().frame(index);

		}catch(NoSuchFrameException e){

			System.out.println("Frame is not present");
		}
	}	
	public static void jsClick(WebElement element) {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	public static void scrollIntoElement(WebElement element) {

		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public static void scrollDown(WebElement element, int pixel ) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+pixel+")");
	}
	public static void scrollUp(WebElement element, int pixel ) {

		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("window.scrollBy(0,-"+pixel+")");
	}
	public static void takeScreenShot(String filePath, String fileName) {

		TakesScreenshot ts=(TakesScreenshot)driver;

		File screen=ts.getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(screen, new File(filePath+"/"+fileName));

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}

