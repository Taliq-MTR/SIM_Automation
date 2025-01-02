package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browserSetup.BrowserOpen;

public class LoginPage extends BrowserOpen {
	
//	1) Allocate all the web element
	@FindBy (css="input[name='email']")
	WebElement username;

	@FindBy (css="input[name='password']")
	WebElement password;
	
	@FindBy (css = "button.public-btn")
	WebElement loginButton;
	
//	2) Make a Constructor
	public LoginPage (){
		PageFactory.initElements(driver, this);
	}
	
//	3) perform action
	
	public boolean loginDetail() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			username.sendKeys("mtr@maildrop.cc");

			password.click();	
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

}