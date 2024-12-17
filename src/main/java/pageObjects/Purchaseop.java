package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class Purchaseop extends DataCreationPage {
	DataCreationPage dcp = new DataCreationPage();

//	2 Create Constructor and invoke both Driver from parent and this class

	public Purchaseop() {

		PageFactory.initElements(driver, this);
	}

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
