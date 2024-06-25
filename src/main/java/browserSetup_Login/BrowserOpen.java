package browserSetup_Login;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class BrowserOpen {

	public static WebDriver driver;

	@BeforeTest
	public void browserOpen() throws InterruptedException {
		// TODO Auto-generated method st0ub
		driver = new ChromeDriver();
//		System.out.println("The method call");
		log().info("The method call");
		driver.get("https://www.simpleinvoiceweb.com/#/home");
		driver.manage().window().maximize();

		Thread.sleep(500);
	}

	public static Logger log()
	{
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}
//	Login

	@AfterTest
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);

		driver.quit();

	}
	
}
