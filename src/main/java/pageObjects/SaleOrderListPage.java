package pageObjects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class SaleOrderListPage extends DataCreationPage {
	
//	All the elements to make a Invoice required actions
//	We use @FindBy testNg method to locate the element
//	There are 3 works happen in page object model 1. Locate all the element 2. make constructor & initialize elements
//	3. Perform actions on the elements



//	(2) Made a Constructor 
//	Initialize the Element
	public SaleOrderListPage() {

		PageFactory.initElements(driver, this);
	}

// (3) Perform Action on the Elements

	DataCreationPage dcp = new DataCreationPage();
	
	
	public boolean openSaleOrderModuleFromDashBoard() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dcp.openModuleFromDashBoard(3);

		return true;

	}

	public boolean openAddNewSaleOrderPage() {

		dcp.CreateNewInvoicePageButton();

		BrowserOpen.log().info("SaleOrder creation Form Open");
		ExtentManager.test.log(Status.PASS, "SaleOrder creation Form Open");
		return true;

	}

	public boolean cancelSaleOrderCreationForm() {

		driver.manage().timeouts().implicitlyWait(duration.ofSeconds(5));
		dcp.CreateNewInvoicePageButton();
		dcp.cancelInvoiceForm();

		BrowserOpen.log().info("Cancel Button is working on Sale Order Creation Form");
		ExtentManager.test.log(Status.PASS, "Cancel Button is working on Sale Order Creation Form");
		return true;

	}

	public boolean addHeader() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		dcp.addDataForHeader();

		BrowserOpen.log().info("SaleOrder Header Added");
		ExtentManager.test.log(Status.PASS, "SaleOrder Header Added");

		return true;

	}

	public boolean addCustomer() {

		dcp.SelectClient();
		dcp.addClient(6);

		BrowserOpen.log().info("Customer Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "Customer Added SuccessFully");
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

		BrowserOpen.log().info("SaleOrder Terms&Condition And Custom Field Added");
		ExtentManager.test.log(Status.PASS, "SaleOrder Terms&Condition And Custom Field Added");

		return true;

	}

	public boolean addDiscountTaxShippingAndROundOff() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.addDiscount();
		dcp.addTax();
		dcp.shipping();
		dcp.roundOff();

		BrowserOpen.log().info("SaleOrder Discount, Tax Shpping Charges And RoundOff Added");
		ExtentManager.test.log(Status.PASS, "SaleOrder Discount, Tax Shpping Charges And RoundOff Added");

		return true;

	}

	public boolean addFooterAndNote() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.addFooter();
		dcp.invoiceNote();

		BrowserOpen.log().info("Footer And Notes of SaleOrder Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "Footer And Notes of SaleOrder Added SuccessFully");

		return true;

	}

	public boolean saveSaleOrder() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.saveInvoiceButton();

		BrowserOpen.log().info(" SaleOrder Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "SaleOrder Added SuccessFully");

		return true;

	}

	public boolean listToDashboard() {
		dcp.listToDashBoard();
		return true;
	}

}
