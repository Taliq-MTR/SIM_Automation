package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class Invoiceop extends DataCreationPage {
	DataCreationPage dcp = new DataCreationPage();

	public boolean openInvoiceCreationForm() {
		try {
			
			// 1 => INVOICE
			int formType = 1;

//			System.out.println("Creating Invoices");
			BrowserOpen.log().info("Invoice Creation Started");
			ExtentManager.test.log(Status.PASS, "Invoice Creation Started");

			String dashboardSelectorCss = String.format(".grid-container > :nth-child(%s)", formType);
			// TODO Auto-generated method stub
			WebElement openInvoiceList = driver.findElement(By.cssSelector(dashboardSelectorCss));
			openInvoiceList.click();

			Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.New_product")));

			
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Invoice Creation Form not Opened:" + e);
			ExtentManager.test.log(Status.FAIL, "Invoice Creation Form not Opened:" + e);
			
		}

		return false;
	}
	protected void upperData() {

		dcp.CreateNewInvoicePageButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.addReferenceForInvoice();
		dcp.addDataForHeader();
		dcp.clientSearch();
//		now select the client now make a Dynamic Client select method like Product
		
	}

}
