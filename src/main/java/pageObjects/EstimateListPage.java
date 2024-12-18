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

public class EstimateListPage extends DataCreationPage {

//	All the elements to make a Invoice required actions
//	We use @FindBy testNg method to locate the element
//	There are 3 works happen in page object model 1. Locate all the element 2. make constructor & initialize elements
//	3. Perform actions on the elements

//	WebDriver driver;
//	(1) All the elements will locate here

	// Open Invoice to select Estimate list
	@FindBy(xpath = "//div[@class='menu-scrolling']/div/ul/li[2]/a")
	private WebElement clickOnInvoice;

	// Click on Add Invoice button
	@FindBy(xpath = "//li[@class='mm-active']/ul/li[4]/a[contains(text(),  'Estimate List')]")
	private WebElement openEstimateList;

//	(2) Made a Constructor 
//	Initialize the Element
	public EstimateListPage() {

		PageFactory.initElements(driver, this);
	}

	DataCreationPage dcp = new DataCreationPage();
// (3) Perform Action on the Elements

	public boolean openEstimateModuleFromDashBoard() {
		try {

			clickOnInvoice.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			openEstimateList.click();

			BrowserOpen.log().info("Estimate Creation Started");
			ExtentManager.test.log(Status.PASS, "Estimate Creation Started");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Estimate Creation Form not Opened:" + e);
			ExtentManager.test.log(Status.FAIL, "Estimate Creation Form not Opened:" + e);

		}

		return false;
	}

	public boolean openAddNewEstimatePage() {

		dcp.CreateNewInvoicePageButton();

		BrowserOpen.log().info("Estimate creation Form Open");
		ExtentManager.test.log(Status.PASS, "Estimate creation Form Open");
		return true;

	}

	public boolean cancelEstimateCreationForm() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return true;
	}

	public boolean closeInvoiceListdropDown() {
		try {

			clickOnInvoice.click();
			BrowserOpen.log().info("Invoice List DropDown Close SuccessFully");
			ExtentManager.test.log(Status.PASS, "Invoice List DropDown Close SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Invoice List DropDown not Close:" + e);
			ExtentManager.test.log(Status.FAIL, "Invoice List DropDown not Close:" + e);

		}

		return false;
	}

}
