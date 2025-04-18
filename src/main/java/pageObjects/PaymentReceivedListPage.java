package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class PaymentReceivedListPage extends PaymentCreationPage {

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
	@FindBy(xpath = "//button[@class='save_btn']")
	WebElement AddreceiptYesButton;

//	Click on Save button to add receipt
	@FindBy(css = "button[type='submit']")
	WebElement saveReceipt;

//	Payment List to Dashboard
	@FindBy(xpath = "//li[@class='breadcrumb-item']/a")
	WebElement paymentlistToDashboard;

//	(2) Made a Constructor 
//	Initialize the Element
	public PaymentReceivedListPage() {

		PageFactory.initElements(driver, this);
	}

	PaymentCreationPage pcp = new PaymentCreationPage();
	// (3) Perform Action on the Elements

	public boolean fromHomeToDashboard() {
		try {
			pcp.goToHome();
			pcp.goToDashBoard();

			BrowserOpen.log().info("Perform Action of Go to Home & Then Came Back to Dashboard SuccessFully");
			ExtentManager.test.log(Status.PASS,
					"Perform Action of Go to Home & Then Came Back to Dashboard SuccessFully");
			return true;
		} catch (Exception e) {
			BrowserOpen.log().error("Didn't Perform Action of Go to Home & Then Came Back to Dashboard:" + e);
			ExtentManager.test.log(Status.FAIL,
					"Didn't Perform Action of Go to Home & Then Came Back to Dashboard:" + e);
		}
		return false;
	}

	public boolean fromDashboardToPaymentListPage() {
		try {
			pcp.clickOnPaymentOnSidebar();
			pcp.openPaymentListForm();

			BrowserOpen.log().info("Perform Action from Dashboard to Open Payment List SuccessFully");
			ExtentManager.test.log(Status.PASS, "Perform Action from Dashboard to Open Payment List SuccessFully");
			return true;
		} catch (Exception e) {
			BrowserOpen.log().error("Didn't Perform Action from Dashboard to Open Payment List SuccessFully:" + e);
			ExtentManager.test.log(Status.FAIL,
					"Didn't Perform Action from Dashboard to Open Payment List SuccessFully:" + e);
		}
		return false;
	}

	public boolean closeButtonOnPaymentcreation() {
		try {
			pcp.closeModule();

			BrowserOpen.log().info("Perform Action to Close New Payment Form in Payment List SuccessFully");
			ExtentManager.test.log(Status.PASS,
					"Perform Action to Close New Payment Form in Payment List SuccessFully");
			return true;
		} catch (Exception e) {
			BrowserOpen.log()
					.error("Didn't Perform Action to Close New Payment Form in Payment List SuccessFully:" + e);
			ExtentManager.test.log(Status.FAIL,
					"Didn't Perform Action to Close New Payment Form in Payment List SuccessFully:" + e);
		}
		return false;
	}

	public WebElement selectCustomer(int index) {
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

//	public boolean openPaymentListForm() {
//		try {
//			paymentsideMenu.click();
//			// Wait for the "Payment List" element to be visible and clickable
//			Duration duration = Duration.ofSeconds(10l, 10);
//			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
//			wait.until(ExpectedConditions.elementToBeClickable(paymentListLink));
//
//			// Scroll into view if necessary (optional)
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentListLink);
////	        Click on Payment list
//			openPaymentlist.click();
//			return true;
//		} catch (Exception e) {
//			BrowserOpen.log().error("Didn't Click on Payment Button in Left Drawer On Dashboard:" + e);
//			ExtentManager.test.log(Status.FAIL, "Didn't Click on Payment Button in Left Drawer On Dashboard:" + e);
//		}
//		return false;
//	}

	public boolean addPaymentForm() {
		try {
			addnewPaymentButton.click();
			Thread.sleep(200);
			pcp.selectClient(5);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			pcp.addLumsumPayment();
			// Previous Code Below
////	 	Click on Add Payment button
//			addnewPaymentButton.click();
//			BrowserOpen.log().info("Clicked On Add New Payment Button");
//			ExtentManager.test.log(Status.PASS, "Clicked On Add New Payment Button");
//
//////		 Scroll to select the customer we want
////			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToSelectCustomer);
////			BrowserOpen.log().info("Customer List Scrolled SuccessFully");
////			ExtentManager.test.log(Status.PASS, "Customer List Scrolled SuccessFully");
////
////			selectCustomer.click();
////			Add client dynamically
//			selectCustomer(4);
//			BrowserOpen.log().info("Seleceted The customer Sneha");
//			ExtentManager.test.log(Status.PASS, "Seleceted The customer Sneha");
//
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
////		  Click on 'Lumsum' Amount for advance payment 	 
//			selectLumsumPayment.click();
//			BrowserOpen.log().info("Click on 'Lumsum' Amount for advance payment");
//			ExtentManager.test.log(Status.PASS, "Click on 'Lumsum' Amount for advance payment");
//
//			addAmount.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//			addAmount.sendKeys("100");
//			addNotes.sendKeys("Automated Notes Added For this Payment");
//
//			BrowserOpen.log().info("Amount and Notes data Added");
//			ExtentManager.test.log(Status.PASS, "Amount and Notes data Added");
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//			nextButton.click();
//			BrowserOpen.log().info("Click on Next Button To complete the payment");
//			ExtentManager.test.log(Status.PASS, "Click on Next Button To complete the payment");
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//			paymentDonebutton.click();
			BrowserOpen.log().info("Payment Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Payment Added SuccessFully");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

			return true;
		} catch (Exception e) {
			BrowserOpen.log().error("Payment Is not completed:" + e);
			ExtentManager.test.log(Status.FAIL, "Payment Is not completed:" + e);
		}
		return false;
	}

	public boolean addReceiptForm() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			AddreceiptYesButton.click();
			BrowserOpen.log().info("Clcik On Add Receipt");
			ExtentManager.test.log(Status.PASS, "Clcik On Add Receipt");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
			saveReceipt.click();
			BrowserOpen.log().info("Receipt Added Successfully");
			ExtentManager.test.log(Status.PASS, "Receipt Added Successfully");
			return true;
		} catch (Exception e) {
			BrowserOpen.log().error("Receipt Is not made:" + e);
			ExtentManager.test.log(Status.FAIL, "Receipt Is not made:" + e);
		}
		return false;
	}

	public boolean listToDashboard() {

		pcp.paymentListToDashBoard();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return true;
	}

}
