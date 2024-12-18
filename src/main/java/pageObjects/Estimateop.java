package pageObjects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.Status;

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class Estimateop extends DataCreationPage {
	DataCreationPage dcp = new DataCreationPage();

//	2 Create Constructor and invoke both Driver from parent and this class

	public Estimateop() {

		PageFactory.initElements(driver, this);
	}

	public boolean openEstimateModuleFromDashBoard() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dcp.openModuleFromDashBoard(3);

		return true;

	}

	public boolean openAddNewEstimatePage() {

		dcp.CreateNewInvoicePageButton();

		BrowserOpen.log().info("Estimate creation Form Open");
		ExtentManager.test.log(Status.PASS, "Estimate creation Form Open");
		return true;

	}

	public boolean cancelEstimateCreationForm() {

		driver.manage().timeouts().implicitlyWait(duration.ofSeconds(5));
		dcp.CreateNewInvoicePageButton();
		dcp.cancelInvoiceForm();

		BrowserOpen.log().info("Cancel Button is working on Estimate Creation Form");
		ExtentManager.test.log(Status.PASS, "Cancel Button is working on Estimate Creation Form");
		return true;

	}

	public boolean addHeader() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		dcp.addDataForHeader();

		BrowserOpen.log().info("Estimate Header Added");
		ExtentManager.test.log(Status.PASS, "Estimate Header Added");

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

		BrowserOpen.log().info("Estimate Terms & Condition And Custom Field Added");
		ExtentManager.test.log(Status.PASS, "Estimate Terms&Condition And Custom Field Added");

		return true;

	}

	public boolean addDiscountTaxShippingAndROundOff() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.addDiscount();
		dcp.addTax();
		dcp.shipping();
		dcp.roundOff();

		BrowserOpen.log().info("Estimate Discount, Tax Shpping Charges And RoundOff Added");
		ExtentManager.test.log(Status.PASS, "Estimate Discount, Tax Shpping Charges And RoundOff Added");

		return true;

	}

	public boolean addFooterAndNote() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.addFooter();
		dcp.invoiceNote();

		BrowserOpen.log().info("Footer And Notes of Estimate Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "Footer And Notes of Estimate Added SuccessFully");

		return true;

	}

	public boolean saveEstimate() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		dcp.saveInvoiceButton();

		BrowserOpen.log().info(" Estimate Added SuccessFully");
		ExtentManager.test.log(Status.PASS, "Estimate Added SuccessFully");

		return true;

	}

	public boolean listToDashboard() {
		dcp.listToDashBoard();
		return true;
	}

}
