package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class PaymentCreationPage extends BrowserOpen {

//	(1) All the elements will locate here

//	Click on Home To disable any Kind of Side bar menue
	@FindBy(css = "button.home-btn")
	private WebElement homeBttn;

//	Click on Go to Dashboard
	@FindBy(css = "button[routerlink='/dashboard']")
	private WebElement goToDashboardBttn;
	
//	Scroll to expense To Open payment List
	@FindBy(xpath = "//ul[@id= 'side-menu']/li[4]")
	private WebElement scrollToExpense;
	

//	Select Payment Module from Left Drawer
	@FindBy(xpath = "//*[@id='side-menu']/li[6]/a")
	private WebElement paymentsideMenu;
//	Adding element for wait
	@FindBy(xpath = "//a[text()=' Payment List ']")
	private WebElement paymentListLink;

//	Click on Payment List To open Payment List
	@FindBy(xpath = "//ul[@id='side-menu']/li[6]/ul/li[2]")
	private WebElement openPaymentlist;

//	Click on Add new Payment Button
	@FindBy(xpath = "//button[contains(text(), ' Add Payment ')]")
	private WebElement addnewPaymentButton;

////	Scroll to the customer to select the customer which we want to make payment
//	@FindBy(xpath = "//*[@class=\"mat-mdc-tab-body-wrapper\"]//table/tbody/tr[2]/td/div/div/h4[contains(text(), 'Neha ')]")
//	private WebElement scrollToSelectCustomer;
//
////	Select Customer for payment
//	@FindBy(xpath = "//h4[(text()='Sneha ')]")
//	private WebElement selectCustomer;

// 	Click on 'Lumsum' Amount for advance payment 
	@FindBy(xpath = "//div[contains(text(), 'Lumpsum Amount')]")
	private WebElement selectLumsumPayment;

//	Add number of amount for payment 
	@FindBy(xpath = "//tbody/tr[4]/td[2]/input")
	private WebElement addAmount;

//	Write notes for payment
	@FindBy(xpath = "//tbody/tr[5]/td[2]/textarea")
	private WebElement addNotes;

//	Click on Next button to submit payment
	@FindBy(xpath = "//button[@class='save_btn']")
	private WebElement nextButton;

//	Click on Done button to submit the payment form
	@FindBy(xpath = "//button[contains(@class, 'payment_next_btn') and text()=' Next ']")
	private WebElement paymentDonebutton;

//	Click on Yes button to add Receipt
	@FindBy(xpath = "//button[@class='btn-done']")
	private WebElement AddreceiptYesButton;

//	Click on Save button to add receipt
	@FindBy(css = "button[type='submit']")
	private WebElement saveReceipt;

//	Payment List to Dashboard
	@FindBy(xpath = "//li[@class='breadcrumb-item']/a")
	private WebElement paymentlistToDashboard;

//	CLose Button
	@FindBy(css = "button[class='cancel_btn']")
	private WebElement closeButton;

	public PaymentCreationPage() {

		PageFactory.initElements(driver, this);
	}

	protected boolean goToHome() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			homeBttn.click();
			

			return true;
		} catch (Exception e) {
			BrowserOpen.log().error("Didn't Perform action to Go on Home Page:" + e);
			ExtentManager.test.log(Status.FAIL, "Didn't Perform action to Go on Home Page:" + e);
		}
		return false;
	}

	protected boolean goToDashBoard() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			goToDashboardBttn.click();
			return true;
		} catch (Exception e) {
			BrowserOpen.log().error("Didn't Perform action to \"Go To DashBoard\":" + e);
			ExtentManager.test.log(Status.FAIL, "Didn't Perform action to \"Go To DashBoard\":" + e);
		}
		return false;
	}

	protected boolean clickOnPaymentOnSidebar() {
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", scrollToExpense);
			
			paymentsideMenu.click();
			return true;
		} catch (Exception e) {
			BrowserOpen.log().error("Didn't Click on Payment Button in Left Drawer On Dashboard:" + e);
			ExtentManager.test.log(Status.FAIL, "Didn't Click on Payment Button in Left Drawer On Dashboard:" + e);
		}
		return false;
	}

	protected boolean openPaymentListForm() {
		try {

			// Wait for the "Payment List" element to be visible and clickable
			Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			wait.until(ExpectedConditions.elementToBeClickable(paymentListLink));

			// Scroll into view if necessary (optional)
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentListLink);
//	        Click on Payment list
			openPaymentlist.click();
			return true;
		} catch (Exception e) {
			BrowserOpen.log().error("Didn't Click on Payment Button in Left Drawer On Dashboard:" + e);
			ExtentManager.test.log(Status.FAIL, "Didn't Click on Payment Button in Left Drawer On Dashboard:" + e);
		}
		return false;
	}

//	Check the Close Button is working or not
	protected boolean closeModule() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			addnewPaymentButton.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			selectClient(2).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			selectLumsumPayment.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			closeButton.click();
			BrowserOpen.log().info("Clicked On CLose Button");
			ExtentManager.test.log(Status.PASS, "Clicked On CLose Button");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("CLose Button is Not Clicked: " + e);
			ExtentManager.test.log(Status.FAIL, "CLose Button is Not Clicked: " + e);
		}
		return false;
	}

	protected WebElement selectClient(int index) {
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
	
	protected boolean addLumsumPayment() {
		try {
			PaymentCreationPage pcp = new PaymentCreationPage();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			addnewPaymentButton.click();	
			selectLumsumPayment.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			addAmount.sendKeys("500");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			addNotes.sendKeys("This Payment Added Through Hybrid FrameWork By SIR \"MTR\" ");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			Thread.sleep(200);
			nextButton.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			paymentDonebutton.click();
			
			
			
			BrowserOpen.log().info("LumSum Payment Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "LumSum Payment Added SuccessFully");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("LumSum Payment not Added: " + e);
			ExtentManager.test.log(Status.FAIL, "LumSum Payment not Added: " + e);
		}
		return false;
	}
	
	protected boolean addReciept() {
		try {
			closeButton.click();
			BrowserOpen.log().info("Clicked On CLose Button");
			ExtentManager.test.log(Status.PASS, "Clicked On CLose Button");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("CLose Button is Not Clicked: " + e);
			ExtentManager.test.log(Status.FAIL, "CLose Button is Not Clicked: " + e);
		}
		return false;
	}
	
	protected boolean paymentListToDashBoard() {
		try {
			paymentlistToDashboard.click();
			BrowserOpen.log().info("Clicked On CLose Button");
			ExtentManager.test.log(Status.PASS, "Clicked On CLose Button");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("CLose Button is Not Clicked: " + e);
			ExtentManager.test.log(Status.FAIL, "CLose Button is Not Clicked: " + e);
		}
		return false;
	}

}
