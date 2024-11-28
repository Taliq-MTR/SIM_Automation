package browserSetup;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserOpen {

	protected static WebDriver driver;

	@BeforeTest
	public boolean browserOpen() throws InterruptedException {
		driver = new DriverManager().initializeDriver();

		// URL is hardcoded and the same for both browsers
		String url = "https://www.simpleinvoiceweb.com/#/home";

		// Open the URL in the specified browser
		driver.get(url);
		driver.manage().window().maximize();
		log().info("Browser Opened and maximized with URL: " + url);

		Thread.sleep(5000);

		return false;
	}

//	LogOut and Browser Closed.

	@AfterTest
	public void logout() throws InterruptedException {

		driver.quit();
		log().info("Browser Closed");
		ExtentManager.test.log(Status.PASS, "Browser Closed");

	}

	@BeforeSuite
	public void reportGenerate() throws IOException {
		ExtentManager.setExtent();
	}

	@AfterSuite
	public void endReport() {
		ExtentManager.endReport();
	}

//	To generate Logs
	public static Logger log() {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}

//	

}
