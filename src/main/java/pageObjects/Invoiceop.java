package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class Invoiceop extends DataCreationPage {
	DataCreationPage dcp = new DataCreationPage();

//	2 Create Constructor and invoke both Driver from parent and this class

	public Invoiceop() {

		PageFactory.initElements(driver, this);
	}

	public boolean openInvoiceModuleFromDashBoard() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.openModuleFromDashBoard(1);

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Invoice Creation Form not Opened:" + e);
			ExtentManager.test.log(Status.FAIL, "Invoice Creation Form not Opened:" + e);

		}

		return false;
	}

	public boolean openAddNewInvoicePage() {
		try {

			Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.New_product")));

			dcp.CreateNewInvoicePageButton();

			BrowserOpen.log().info("Invoice creation Form Open");
			ExtentManager.test.log(Status.PASS, "Invoice creation Form Open");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Invoice Creation Form not Opened:" + e);
			ExtentManager.test.log(Status.FAIL, "Invoice Creation Form not Opened:" + e);

		}

		return false;
	}

	public boolean addHeaderAndReference() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.addReferenceForInvoice();
			dcp.addDataForHeader();

			BrowserOpen.log().info("Invoice Header Reference And Header Added");
			ExtentManager.test.log(Status.PASS, "Invoice  Refrence And Header Added");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Invoice  Refrence, Header not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Invoice Header Reference, Header not Added:" + e);

		}

		return false;
	}

	public boolean addCustomer() {
		try {

			dcp.SelectClient();
			dcp.addClient(2);

			BrowserOpen.log().info("Customer Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Customer Added SuccessFully");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Customer not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Customer not Added:" + e);

		}

		return false;
	}

	public boolean addproduct() {
		try {

			dcp.addProductItem();

			BrowserOpen.log().info("Product Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Product Added SuccessFully");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Product not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Product not Added:" + e);

		}

		return false;
	}

	public boolean addtermsAndCustomField() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.termsAndCondition();
			dcp.addCustomField();

			BrowserOpen.log().info("Invoice Terms&Condition And Custom Field Added");
			ExtentManager.test.log(Status.PASS, "Invoice Terms&Condition And Custom Field Added");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Invoice Terms&Condition And Custom Field not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Invoice Terms&Condition And Custom Field not Added:" + e);

		}

		return false;
	}

	public boolean addDiscountTaxShippingAndROundOff() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.addDiscount();
			dcp.addTax();
			dcp.shippingAndRoundOff();

			BrowserOpen.log().info("Invoice Discount, Tax Shpping Charges And RoundOff Added");
			ExtentManager.test.log(Status.PASS, "Invoice Discount, Tax Shpping Charges And RoundOff Added");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Invoice Discount, Tax, Shpping Charges And RoundOff not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Invoice Discount, Tax, Shpping Charges And RoundOff not Added:" + e);

		}

		return false;
	}

	public boolean addPaymentOfInvoice() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.addPayment();
			
			

			BrowserOpen.log().info("Payment of the Invoice Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Payment of the Invoice Added SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Payment of the Invoice not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Payment of the Invoice not Added:" + e);

		}

		return false;
	}

	public boolean addFooterAndNote() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.addFooter();
			dcp.invoiceNote();

			BrowserOpen.log().info("Footer And Notes of Invoice Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Footer And Notes of Invoice Added SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Footer And Notes of Invoice not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Footer And Notes of Invoice not Added:" + e);

		}

		return false;
	}
	
	public boolean saveInvoice() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.saveInvoiceButton();
		

			BrowserOpen.log().info(" Invoice Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Invoice Added SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Save Invoice not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Invoice not Added:" + e);

		}

		return false;
	}
	
	
	public void listToDashboard() {
		dcp.listToDashBoard();
	}

}
