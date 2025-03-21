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

public class PaymentPaidListPage extends BrowserOpen {
	
//	(1) All the elements will locate here
	
//	Select Payment Module from Left Drawer
	@FindBy(xpath= "//*[@id='side-menu']/li[6]/a")
	 WebElement paymentsideMenu;
//	Adding element for wait
	@FindBy(xpath= "//a[text()=' Payment List ']") 
	WebElement paymentListLink;
	
//	Click on Payment List To open Payment List
	@FindBy(xpath= "//ul[@id='side-menu']/li[6]/ul/li[2]")
	WebElement openPaymentlist;
	
//	Click on Paid Button to add Paid payment
	@FindBy(xpath= " //*[@id=\"wrapper\"]//a[contains(text(), ' Paid ')]")
	WebElement PaidButton;
	
//	Click on Add new Payment Button
	@FindBy(xpath= "//button[contains(text(), ' Add Payment ')]")
	WebElement addnewPaymentButton;
	
//	Click On supplier button to select supplier
	@FindBy(xpath= "//div[@class='mat-mdc-tab-labels']/div[2]//span[text()= 'Supplier']")
	WebElement supplierButton;
	
//	Scroll to the Supplier to select the Supplier which we want to make payment
	@FindBy(xpath= "//*[@class=\"scrollable-content\"]//table/tbody/tr[2]/td/div/div/h4[contains(text(), 'Abc ')]")
	WebElement scrollToSelectSupplier;
	
	
//	Select Supplier for payment
	@FindBy(xpath= "//table[@class='table no-border']//h4[contains(text(), 'MTR ')]")
	WebElement selectSupplierName;

// 	Click on 'Lumsum' Amount for advance payment 
	@FindBy(xpath= "//div[contains(text(), 'Lumpsum Amount')]")
	WebElement selectLumsumPayment;
	
//	Add number of amount for payment 
	@FindBy(xpath= "//tbody/tr[4]/td[2]/input")
	WebElement addAmount;
	
//	Write notes for payment
	@FindBy(xpath= "//tbody/tr[5]/td[2]/textarea")
	WebElement addNotes;
	
//	Click on Next button to submit payment
	@FindBy(xpath= "//button[@class='btn-done']")
	WebElement nextButton;
	
//	Click on Done button to submit the payment form
	@FindBy(xpath= "//button[contains(@class, 'pay-next font-size-15')]")
	WebElement paymentDonebutton;
	

	
//	Payment List to Dashboard
	@FindBy(xpath= "//li[@class='breadcrumb-item']/a")
	WebElement paymentlistToDashboard ;
	
//	(2) Made a Constructor 
//	Initialize the Element
	 public	PaymentPaidListPage() {
		 
		 
		 PageFactory.initElements(driver, this);
	 }
	// (3) Perform Action on the Elements
	 
	 protected WebElement selectSupplier(int index) {
			try {
				// Use String.format to dynamically insert the index into the XPath
				String clientSelection = String.format("//virtual-scroller//tr[%d]//h4", index);
				WebElement clientSelected = driver.findElement(By.xpath(clientSelection));
				clientSelected.click();

				BrowserOpen.log().info("Dynamically Supplier Selected For Advance Payment");
				ExtentManager.test.log(Status.PASS, "Dynamically Supplier Selected For Advance Payment");
				return clientSelected;
			} catch (Exception e) {
				// Log the error if the client is not added
				BrowserOpen.log().error("Dynamic Client Is not Added: " + e);
				ExtentManager.test.log(Status.FAIL, "Dynamic Client Is not Added: " + e);
			}
			return null;
		}
	 
	 public boolean openPaymentListForm () {
		 try {
		 paymentsideMenu.click();
		// Wait for the "Payment List" element to be visible and clickable
		    Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
	        wait.until(ExpectedConditions.elementToBeClickable(paymentListLink));
	        
	     // Scroll into view if necessary (optional)
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paymentListLink);
//	        Click on Payment list
	        openPaymentlist.click();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        PaidButton.click();
		 return true;
		 }catch (Exception e){
			 BrowserOpen.log().error("Didn't Click on Payment Button in Left Drawer On Dashboard:" + e );
				ExtentManager.test.log(Status.FAIL, "Didn't Click on Payment Button in Left Drawer On Dashboard:" + e);
		 }
	 return false;
	 }
	 
	public boolean addPaymentForm () {
		 try {
			 
//	 	Click on Add Payment button
			 
		 addnewPaymentButton.click();
		   BrowserOpen.log().info("Clicked On Add New Payment Button");
		   ExtentManager.test.log(Status.PASS, "Clicked On Add New Payment Button");
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		   supplierButton.click();
		   Thread.sleep(2000);
////		 Scroll to select the Supplier we want
//		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToSelectSupplier);
//		   BrowserOpen.log().info("Supplier List Scrolled SuccessFully");
//		   ExtentManager.test.log(Status.PASS, "Supplier List Scrolled SuccessFully");
//		 
//		   selectSupplierName.click();
		   
//		   Select supplier Dynamically by calling method
		   selectSupplier(3);
		   Thread.sleep(2000);
		   BrowserOpen.log().info("Seleceted The Supplier MTR");
		   ExtentManager.test.log(Status.PASS, "Seleceted The Supplier Sneha");
		   
 
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		  Click on 'Lumsum' Amount for advance payment 	 
		  selectLumsumPayment.click();
		   BrowserOpen.log().info("Click on 'Lumsum' Amount for advance payment");
		   ExtentManager.test.log(Status.PASS, "Click on 'Lumsum' Amount for advance payment");
		 
		 addAmount.click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		 addAmount.sendKeys("100");
		 addNotes.sendKeys("Automated Notes Added For this Payment");
		 
		   BrowserOpen.log().info("Amount and Notes data Added");
		   ExtentManager.test.log(Status.PASS, "Amount and Notes data Added");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		 Thread.sleep(2000);
		 nextButton.click();
		   BrowserOpen.log().info("Click on Next Button To complete the payment");
		   ExtentManager.test.log(Status.PASS, "Click on Next Button To complete the payment");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		 paymentDonebutton.click();
		 Thread.sleep(2000);
		 BrowserOpen.log().info("Payment Added SuccessFully");
		   ExtentManager.test.log(Status.PASS, "Payment Added SuccessFully");
			
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		 
		 return true;
	 }catch (Exception e){
		 BrowserOpen.log().error("Payment Is not completed:" + e );
			ExtentManager.test.log(Status.FAIL, "Payment Is not completed:" + e);
	 }
 return false;
	 } 
	 
	
	 public boolean dashboard() {
			try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				BrowserOpen.log().info("Waited 5 second");
				ExtentManager.test.log(Status.PASS, "Waited 5 second");
				paymentlistToDashboard.click();
				
				BrowserOpen.log().info("We have Successfully Completed Payment Paid");
				ExtentManager.test.log(Status.PASS, "We have Successfully Completed Payment Paid");
				// Set implicit wait of 5 seconds
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				return true;
			} catch (Exception e) {
				BrowserOpen.log().error("Failed to Go on Dashboard from Payment List" + e);
				ExtentManager.test.log(Status.FAIL, "Failed to Go on Dashboard from Payment List" + e);		
			}

			return false;

		}
	 
}
