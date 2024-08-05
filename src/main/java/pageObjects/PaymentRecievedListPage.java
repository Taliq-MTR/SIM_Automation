package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;

import browserSetup_Login.BrowserOpen;


public class PaymentRecievedListPage extends BrowserOpen {
	
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
	
//	(2) Made a Constructor 
//	Initialize the Element
	 public	PaymentRecievedListPage() {
		 
		 PageFactory.initElements(driver, this);
	 }
	// (3) Perform Action on the Elements
	 public void openPaymentListForm () {
		 paymentsideMenu.click();
		 openPaymentlist.click();
		 
	 
	 }
	 public void addPaymentForm () {
		 
//	 	Click on Add Payment button
		 addnewPaymentButton.click();
		 
//		 Scroll to select the customer we want
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToSelectCustomer);
					
		 selectCustomer.click();
		 
//		 Click on 'Lumsum' Amount for advance payment 	 
		 selectLumsumPayment.click();
		 
		 addAmount.sendKeys("100");
		 addNotes.sendKeys("Automated Notes Added For this Payment");
		 nextButton.click();
		 paymentDonebutton.click();
		 driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 } 
	 public void addReceiptForm () {
		 
		 AddreceiptYesButton.click();
		 saveReceipt.click();
	 }
	 
}
