package browserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;




public class DriverManager {

	public WebDriver initializeDriver() {
		
		WebDriverManager.chromedriver().setup();
		 WebDriver driver = new ChromeDriver();
		
//		WebDriverManager.firefoxdriver().setup();
//
//        // Use Firefox options (No custom profile)
//        FirefoxOptions options = new FirefoxOptions();
//
//        // If needed, you can add arguments here
//        // options.addArguments("--headless"); // Uncomment for headless mode
//
//        // Initialize the Firefox driver
//        WebDriver driver = new FirefoxDriver(options);

		driver.manage().window().maximize();
		return driver;

	}
}