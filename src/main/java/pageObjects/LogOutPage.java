package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	public boolean logOutDetails() {

		try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		dropDown.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		logoutButton.click();
		log().info("App Logout Successfully");
		ExtentManager.test.log(Status.PASS, "App Logout Successfully");
		return true;
		}catch (Exception e) {
			
//			System.out.println("User Login Failed");
			log().error("User LogOut action Failed" + e);
			ExtentManager.test.log(Status.PASS, "User LogOut action Failed" + e);
		}
		return false;
	}
}
