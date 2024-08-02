package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

import org.openqa.selenium.support.PageFactory;

import browserSetup_Login.BrowserOpen;


public class PaymentRecievedListPage extends BrowserOpen {
	
//	(1) All the elements will locate here
	@FindBy(xpath= "//*[@id=\"side-menu\"]/li[6]/a")
	 WebElement paymentsideMenu;
	
	@FindBy(xpath= "//a[contains(text(), ' Payment List ')]")
	WebElement openPaymentlist;
	
	@FindBy(xpath= "//button[contains(text(), ' Add Payment ')]")
	WebElement addnewPaymentButton;
	
	
	@FindBy(xpath= "//h4[(text()='Sneha ')]")
	WebElement selectCustomer;

	@FindBy(xpath= "//div[contains(text(), 'Lumpsum Amount')]")
	WebElement selectLumsumPayment;
	
	@FindBy(xpath= "//tbody/tr[4]/td[2]/input")
	WebElement addAmount;
	
	@FindBy(xpath= "//tbody/tr[5]/td[2]/textarea")
	WebElement addNotes;
	
	@FindBy(xpath= "//button[@class='btn-done']")
	WebElement nextButton;
	
	@FindBy(xpath= "//button[contains(@class, 'pay-next font-size-15')]")
	WebElement paymentDonebutton;
	
	@FindBy(xpath= "//button[@class='btn-done']")
	WebElement AddreceiptYesButton;
	
	@FindBy(xpath= "//button[@class='btn-done']")
	WebElement saveReceipt;
	
//	(2) Made a Constructor 
//	Initialize the Element
//	 public	PaymentRecievedListPage() {
//		 
//		 PageFactory.initElements(driver, this);
//	 }
	 
}
