package browserSetup_Login;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.time.Duration;


import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;



public class BrowserOpen {

	public static WebDriver driver;

	@BeforeTest
	public boolean browserOpen() throws InterruptedException {
		// TODO Auto-generated method st0ub
		driver = new ChromeDriver();
//		System.out.println("The method call");
		
		driver.get("https://www.simpleinvoiceweb.com/#/home");
		driver.manage().window().maximize();
		log().info("Browser Open and maximized");
//		ExtentManager.test.log(Status.PASS, "Browser Open and maximized");

		Thread.sleep(500);
		
//		Login
		try {
			WebElement username = driver.findElement(By.name("email"));
			WebElement password = driver.findElement(By.name("password"));
			WebElement loginButton = driver.findElement(By.cssSelector("button.public-btn"));

			username.sendKeys("mtr@maildrop.cc");

			password.sendKeys("1234");

			loginButton.click();

			Duration duration = Duration.ofSeconds(50l, 50);
			WebDriverWait waitforDashboard = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			waitforDashboard.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//h4[contains(@class, 'page-title') and contains(text(), 'Dashboard')]")));
			String dashboardUrl = driver.getCurrentUrl();
//			System.out.println("The Dashboard url:" + dashboardUrl);
			log().info("The Dashboard url:" + dashboardUrl);
//			ExtentManager.test.log(Status.PASS, "The Dashboard url:" + dashboardUrl);

			return true;

		} catch (Exception e) {
			
//			System.out.println("User Login Failed");
			log().error("User Login Failed" + e);
//			ExtentManager.test.log(Status.PASS, "User Login Failed" + e);
		}
		return false;
		
	}

	
//	Login

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);

		driver.quit();
		log().info("Browser Closed");
		ExtentManager.test.log(Status.PASS, "Browser Closed");

	}
	
	@BeforeSuite
	public void reportGenerate() throws IOException
	{
		ExtentManager.setExtent();
	}
	
	@AfterSuite
	public void endReport()
	{
		ExtentManager.endReport();
}
	
//	To generate Logs
	public static Logger log()
	{
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
	
//	
	
}
