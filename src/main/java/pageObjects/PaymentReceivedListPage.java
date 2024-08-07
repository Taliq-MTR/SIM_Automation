package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import browserSetup_Login.BrowserOpen;
import browserSetup_Login.ExtentManager;
import browserSetup_Login.Login;


public class PaymentReceivedListPage extends BrowserOpen {
	
//	(1) All the elements will locate here
	
//	Select Payment Module from Left Drawer
	@FindBy(xpath= "//*[@id=\"side-menu\"]/li[6]/a")
	 WebElement paymentsideMenu;
	
//	Click on Payment List To open Payment List
	@FindBy(xpath= "//a[contains(text(), ' Payment List ')]")
	WebElement openPaymentlist;
	
//	Click on Add new Payment Button
	@FindBy(xpath= "//button[contains(text(), ' Add Payment ')]")
	WebElement addnewPaymentButton;
	
//	Scroll to the customer to select the customer which we want to make payment
	@FindBy(xpath= "//div/h4[text()= 'MMR ']")
	WebElement scrollToSelectCustomer;
	
	
//	Select Customer for payment
	@FindBy(xpath= "//h4[(text()='Sneha ')]")
	WebElement selectCustomer;

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
	
//	Click on Yes button to add Receipt
	@FindBy(xpath= "//button[@class='btn-done']")
	WebElement AddreceiptYesButton;
	
//	Click on Save button to add receipt
	@FindBy(xpath= "//button[@class='btn-done']")
	WebElement saveReceipt;
	
//	Payment List to Dashboard
	@FindBy(xpath= "//li[@class='breadcrumb-item']/a")
	WebElement paymentlistToDashboard ;
	
//	(2) Made a Constructor 
//	Initialize the Element
	 public	PaymentReceivedListPage() {
		 
		 
		 PageFactory.initElements(driver, this);
	 }
	// (3) Perform Action on the Elements
	 
	 
	 public boolean openPaymentListForm () {
		 try {
		 paymentsideMenu.click();
		 openPaymentlist.click();
		 return true;
		 }catch (Exception e){
			 Login.log().error("Didn't Click on Payment Button in Left Drawer On Dashboard:" + e );
				ExtentManager.test.log(Status.FAIL, "Didn't Click on Payment Button in Left Drawer On Dashboard:" + e);
		 }
	 return false;
	 }
	 public boolean addPaymentForm () {
		 try {
//	 	Click on Add Payment button
		 addnewPaymentButton.click();
		   Login.log().info("Clicked On Add New Payment Button");
		   ExtentManager.test.log(Status.PASS, "Clicked On Add New Payment Button");
		 
//		 Scroll to select the customer we want
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToSelectCustomer);
		   Login.log().info("Customer List Scrolled SuccessFully");
		   ExtentManager.test.log(Status.PASS, "Customer List Scrolled SuccessFully");
		   
		 selectCustomer.click();
		   Login.log().info("Seleceted The customer Sneha");
		   ExtentManager.test.log(Status.PASS, "Seleceted The customer Sneha");
		 
//		 Click on 'Lumsum' Amount for advance payment 	 
		 selectLumsumPayment.click();
		   Login.log().info("Click on 'Lumsum' Amount for advance payment");
		   ExtentManager.test.log(Status.PASS, "Click on 'Lumsum' Amount for advance payment");
		 
		 addAmount.click();
		 
		 addAmount.sendKeys("100");
		 addNotes.sendKeys("Automated Notes Added For this Payment");
		 
		   Login.log().info("Amount and Notes data Added");
		   ExtentManager.test.log(Status.PASS, "Amount and Notes data Added");
		   
		 nextButton.click();
		   Login.log().info("Click on Next Button To complete the payment");
		   ExtentManager.test.log(Status.PASS, "Click on Next Button To complete the payment");
		 
		 paymentDonebutton.click();
		   Login.log().info("Payment Added SuccessFully");
		   ExtentManager.test.log(Status.PASS, "Payment Added SuccessFully");
			
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 return true;
	 }catch (Exception e){
		 Login.log().error("Payment Is not completed:" + e );
			ExtentManager.test.log(Status.FAIL, "Payment Is not completed:" + e);
	 }
 return false;
	 } 
	 public boolean addReceiptForm () {
		 try {
		 AddreceiptYesButton.click();
		 Login.log().info("Clcik On Add Receipt");
			ExtentManager.test.log(Status.PASS, "Clcik On Add Receipt");
		 saveReceipt.click();
		 Login.log().info("Receipt Added Successfully");
			ExtentManager.test.log(Status.PASS, "Receipt Added Successfully");
		 return true;
	 }catch (Exception e){
		 Login.log().error("Receipt Is not made:" + e );
			ExtentManager.test.log(Status.FAIL, "Receipt Is not made:" + e);
	 }
 return false;
	 }
	 public boolean dashboard() {
			try {

				Login.log().info("Waited 5 second");
				ExtentManager.test.log(Status.PASS, "Waited 5 second");
				paymentlistToDashboard.click();
				
				Login.log().info("We have Successfully Completed Payment Received");
				ExtentManager.test.log(Status.PASS, "We have Successfully Completed Payment Received");
				// Set implicit wait of 5 seconds

				return true;
			} catch (Exception e) {
				Login.log().error("Failed to Go on Dashboard from Payment List" + e);
				ExtentManager.test.log(Status.FAIL, "Failed to Go on Dashboard from Payment List" + e);		
			}

			return false;

		}
	 
}
