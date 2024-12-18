package pageObjects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;
import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class PurchaseOrderListPage extends DataCreationPage {

//	All the elements to make a Purchase required actions
//	We use @FindBy testNg method to locate the element
//	There are 3 works happen in page object model 1. Locate all the element 2. make constructor & initialize elements
//	3. Perform actions on the elements

//	(2) Made a Constructor 
//	Initialize the Element
	public PurchaseOrderListPage() {

		PageFactory.initElements(driver, this);
	}

	DataCreationPage dcp = new DataCreationPage();

// (3) Perform Action on the Elements

	public boolean openPurchaseOrderModuleFromDashBoard() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.openModuleFromDashBoard(4);

		return true;

	}

	public boolean cancelPurchaseOrderCreationForm() {

		dcp.CreateNewInvoicePageButton();
		dcp.cancelInvoiceForm();

		BrowserOpen.log().info("Cancel Button is working on Purchase Order Creation Form");
		ExtentManager.test.log(Status.PASS, "Cancel Button is working on Purchase Order Creation Form");
		return true;

	}

	public boolean openAddNewPurchaseOrderPage() {

		dcp.CreateNewInvoicePageButton();

		BrowserOpen.log().info("PurchaseOrder creation Form Open");
		ExtentManager.test.log(Status.PASS, "PurchaseOrder creation Form Open");
		return true;

	}

	public boolean addHeader() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		dcp.addDataForHeader();

		BrowserOpen.log().info("PurchaseOrder Header Added");
		ExtentManager.test.log(Status.PASS, "PurchaseOrder Header Added");

		return true;

	}

	public boolean addSupplier() {

		dcp.SelectClient();
		dcp.addClient(3);

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

		BrowserOpen.log().info("PurchaseOrder Terms&Condition And Custom Field Added");
		ExtentManager.test.log(Status.PASS, "PurchaseOrder Terms&Condition And Custom Field Added");

		return true;

	}

	public boolean addDiscountTaxShippingAndROundOff() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.addDiscount();
		dcp.addTax();
		dcp.shipping();
		dcp.roundOff();

		BrowserOpen.log().info("PurchaseOrder Discount, Tax Shpping Charges And RoundOff Added");
		ExtentManager.test.log(Status.PASS, "PurchaseOrder Discount, Tax Shpping Charges And RoundOff Added");

		return true;

	}

	public boolean addFooterAndNote() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.addFooter();
		dcp.invoiceNote();

		BrowserOpen.log().info("Footer And Notes of PurchaseOrder Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "Footer And Notes of PurchaseOrder Added SuccessFully");

		return true;

	}

	public boolean savePurchaseOrder() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.saveInvoiceButton();

		BrowserOpen.log().info(" PurchaseOrder Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "PurchaseOrder Added SuccessFully");

		return true;

	}

	public boolean listToDashboard() {
		dcp.listToDashBoard();
		return true;
	}

}
