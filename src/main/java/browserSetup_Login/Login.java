package browserSetup_Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BrowserOpen {

	public boolean loginDetail() {

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

			return true;

		} catch (Exception e) {
			
//			System.out.println("User Login Failed");
			log().error("User Login Failed" + e);
		}
		return false;
	}

}
