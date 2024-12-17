package pageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class PurchaseListPage extends DataCreationPage {
	DataCreationPage dcp = new DataCreationPage();

////	 Click On Purchase Module
//
//	@FindBy(xpath = "//div[@class='grid-container']//div[2]/h4[contains(text(), 'Purchase ')]")
//	WebElement openPurchaseModule;
//	// Click on Add Purchase button
//	@FindBy(css = "button.New_product")
//	WebElement addNewPurchase;
//
//	// Click on Supplier Section
//	@FindBy(css = "#lwAddClient")
//	WebElement searchSupplier;
//
//	// Select and Add Client
//	@FindBy(css = "div[role='listbox'] mat-option:nth-of-type(2)")
//	WebElement addSupplier;
//
//	// Click on Add product section to search for product
//	@FindBy(css = "input[name='itemName']")
//	WebElement searchProduct;
//
//	// Add Product
//	@FindBy(xpath = "//mat-option//span[text()=' Football ']")
//	WebElement addProduct;
//
//	// Scroll the Page to click on line item
//	@FindBy(css = "th.qty-field")
//	WebElement scrollToQtyINV;
//
////	We have to wait and then Click on add product line item Button
//	@FindBy(css = "button.add-line-form")
//	WebElement addItemButton;
//
//	// Now Click on Save Purchase
//	@FindBy(xpath = "//button[contains(@class, 'btn-done') and contains(text(), 'Save Purchase')]")
//	WebElement savePurchase;
//
//	// Now Going Back To Dashboard
//	@FindBy(css = "a[href='#/dashboard']")
//	WebElement purchaseToDashboard;

//	(2) Made a Constructor 
//	Initialize the Element
	public PurchaseListPage() {

		PageFactory.initElements(driver, this);
	}

// (3) Perform Action on the Elements

	public boolean openPurchaseModuleFromDashBoard() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.openModuleFromDashBoard(2);

		return true;

	}

	public boolean openAddNewPurchasePage() {

		dcp.CreateNewInvoicePageButton();

		BrowserOpen.log().info("Purchase creation Form Open");
		ExtentManager.test.log(Status.PASS, "Purchase creation Form Open");
		return true;

	}

	public boolean addHeaderReferenceDueDate() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.addReferenceForInvoice();
		dcp.addDataForHeader();
		dcp.addDueDate();

		BrowserOpen.log().info("Purchase Header, Reference And Due Date Added");
		ExtentManager.test.log(Status.PASS, "Purchase Header, Reference And Due Date Added");

		return true;

	}

	public boolean addSupplier() {

		dcp.SelectClient();
		dcp.addClient(4);

		BrowserOpen.log().info("Supplier Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "Supplier Added SuccessFully");
		return true;

	}

	public boolean addproduct() {

		dcp.addProductItem();

		BrowserOpen.log().info("Product Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "Product Added SuccessFully");
		return true;
	}

	public boolean addtermsAndCustomField() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.termsAndCondition();
		dcp.addCustomField();

		BrowserOpen.log().info("Purchase Terms&Condition And Custom Field Added");
		ExtentManager.test.log(Status.PASS, "Purchase Terms&Condition And Custom Field Added");

		return true;

	}

	public boolean addDiscountTaxShippingAndROundOff() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.addDiscount();
		dcp.addTax();
		dcp.shipping();
		dcp.roundOff();

		BrowserOpen.log().info("Purchase Discount, Tax Shpping Charges And RoundOff Added");
		ExtentManager.test.log(Status.PASS, "Purchase Discount, Tax Shpping Charges And RoundOff Added");

		return true;

	}

	public boolean addPaymentOfPurchase() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.addPayment();

		BrowserOpen.log().info("Payment of the Purchase Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "Payment of the Purchase Added SuccessFully");

		return true;

	}

	public boolean addFooterAndNote() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.addFooter();
		dcp.invoiceNote();

		BrowserOpen.log().info("Footer And Notes of Purchase Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "Footer And Notes of Purchase Added SuccessFully");

		return true;

	}

	public boolean savePurchase() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.saveInvoiceButton();

		BrowserOpen.log().info(" Purchase Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "Purchase Added SuccessFully");

		return true;

	}

	public boolean listToDashboard() {
		dcp.listToDashBoard();
		return true;
	}

}