package browserSetup_Login;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.Status;



public class BrowserOpen {

	public static WebDriver driver;

	@BeforeTest
	public void browserOpen() throws InterruptedException {
		// TODO Auto-generated method st0ub
		driver = new ChromeDriver();
//		System.out.println("The method call");
		
		driver.get("https://www.simpleinvoiceweb.com/#/home");
		driver.manage().window().maximize();
		log().info("Browser Open and maximized");
//		ExtentManager.test.log(Status.PASS, "Browser Open and maximized");

		Thread.sleep(500);
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
