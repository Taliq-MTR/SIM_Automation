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
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;



public class BrowserOpen {

	public static WebDriver driver;

	@BeforeTest
	public boolean browserOpen() throws InterruptedException {
		// TODO Auto-generated method st0ub
		driver = new ChromeDriver();
//		System.out.println("The method call");

		//	Here we can add any test url for smoke and regression Testing	
//			driver.get("http://188.166.6.8/sim-live-2/#/home/login");
		
		// This is the main app url		
		driver.get("https://www.simpleinvoiceweb.com/#/home");
		driver.manage().window().maximize();
		log().info("Browser Open and maximized");
//		ExtentManager.test.log(Status.PASS, "Browser Open and maximized");

		Thread.sleep(500);
//		Login method
//		WebElement email= driver.findElement(By.name("email"));
//		email.sendKeys("mtr@maildrop.cc");
//		WebElement password= driver.findElement(By.name("password"));
//		password.sendKeys("1234");
//		WebElement loginButton= driver.findElement(By.xpath("//*[@id=\"home-section\"]/section/div/div/div/div[2]/app-login/div/div/div/div/form/div[4]/div[1]/button"));
//		loginButton.click();
		
		
     return false;
		
	}

	
//	LogOut and Browser Closed.

	
	@AfterTest
	public void logout () throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement dropDown= driver.findElement(By.xpath("//a[@id='dropdownMenuButton1']"));
		dropDown.click();
		Thread.sleep(200);

		
		WebElement logoutButton= driver.findElement(By.xpath("//ul[@class='dropdown-menu me-2 dropdown-menu-end show']/li[4]"));
		logoutButton.click();
		log().info("App Logout Successfully");
		ExtentManager.test.log(Status.PASS, "App Logout Successfully");
		
		Thread.sleep(200);
		
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
