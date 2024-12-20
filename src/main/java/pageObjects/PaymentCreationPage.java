package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class PaymentCreationPage extends BrowserOpen {
	
//	(1) All the elements will locate here

//	Select Payment Module from Left Drawer
	@FindBy(xpath = "//*[@id='side-menu']/li[6]/a")
	WebElement paymentsideMenu;
//	Adding element for wait
	@FindBy(xpath = "//a[text()=' Payment List ']")
	WebElement paymentListLink;

//	Click on Payment List To open Payment List
	@FindBy(xpath = "//ul[@id='side-menu']/li[6]/ul/li[2]")
	WebElement openPaymentlist;

//	Click on Add new Payment Button
	@FindBy(xpath = "//button[contains(text(), ' Add Payment ')]")
	WebElement addnewPaymentButton;

//	Scroll to the customer to select the customer which we want to make payment
	@FindBy(xpath = "//*[@class=\"mat-mdc-tab-body-wrapper\"]//table/tbody/tr[2]/td/div/div/h4[contains(text(), 'Neha ')]")
	WebElement scrollToSelectCustomer;

//	Select Customer for payment
	@FindBy(xpath = "//h4[(text()='Sneha ')]")
	WebElement selectCustomer;

// 	Click on 'Lumsum' Amount for advance payment 
	@FindBy(xpath = "//div[contains(text(), 'Lumpsum Amount')]")
	WebElement selectLumsumPayment;

//	Add number of amount for payment 
	@FindBy(xpath = "//tbody/tr[4]/td[2]/input")
	WebElement addAmount;

//	Write notes for payment
	@FindBy(xpath = "//tbody/tr[5]/td[2]/textarea")
	WebElement addNotes;

//	Click on Next button to submit payment
	@FindBy(xpath = "//button[@class='btn-done']")
	WebElement nextButton;

//	Click on Done button to submit the payment form
	@FindBy(xpath = "//button[contains(@class, 'pay-next font-size-15')]")
	WebElement paymentDonebutton;

//	Click on Yes button to add Receipt
	@FindBy(xpath = "//button[@class='btn-done']")
	WebElement AddreceiptYesButton;

//	Click on Save button to add receipt
	@FindBy(css = "button[type='submit']")
	WebElement saveReceipt;

//	Payment List to Dashboard
	@FindBy(xpath = "//li[@class='breadcrumb-item']/a")
	WebElement paymentlistToDashboard;
	
	public PaymentCreationPage() {

		PageFactory.initElements(driver, this);
	}
	
	protected WebElement selectCustomer(int index) {
		try {
			// Use String.format to dynamically insert the index into the XPath
			String clientSelection = String.format("//virtual-scroller//tr[%d]//h4", index);
			WebElement clientSelected = driver.findElement(By.xpath(clientSelection));
			clientSelected.click();

			BrowserOpen.log().info("Dynamically Customer Selected For Advance Payment");
			ExtentManager.test.log(Status.PASS, "Dynamically Customer Selected For Advance Payment");
			return clientSelected;
		} catch (Exception e) {
			// Log the error if the client is not added
			BrowserOpen.log().error("Dynamic Client Is not Added: " + e);
			ExtentManager.test.log(Status.FAIL, "Dynamic Client Is not Added: " + e);
		}
		return null;
	}
	

}
