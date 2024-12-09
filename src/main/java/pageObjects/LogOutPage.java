package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class LogOutPage extends BrowserOpen {

	@FindBy(xpath = "//a[@id='dropdownMenuButton1']")
	WebElement dropDown;

	@FindBy(xpath = "//ul[@class='dropdown-menu me-2 dropdown-menu-end show']/li[4]")
	WebElement logoutButton;

	public LogOutPage() {
		PageFactory.initElements(driver, this);
	}

	Duration duration = Duration.ofSeconds(10l, 10);
	WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
	
	public boolean logOutDetails() {

		try {
			Thread.sleep(6000);
			wait.until(ExpectedConditions.elementToBeClickable(dropDown));
			dropDown.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			logoutButton.click();
			log().info("App Logout Successfully");
			ExtentManager.test.log(Status.PASS, "App Logout Successfully");
			return true;
		} catch (Exception e) {

//			System.out.println("User Login Failed");
			log().error("User LogOut action Failed" + e);
			ExtentManager.test.log(Status.PASS, "User LogOut action Failed" + e);
		}
		return false;
	}
}
