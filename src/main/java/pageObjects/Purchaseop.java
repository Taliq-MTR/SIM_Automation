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

//	@FindBy(css = "div[href='#commission']")
//	WebElement commissionButtonDropDown;
//
//	@FindBy(xpath = "//div/span[text()=' Shipping Charges ']")
//	WebElement scrollToshippingCharges;
//
//	@FindBy(xpath = "//label[text()='Commission']/following::span[contains(@class, 'dropdown-toggle')]")
//	WebElement currencyArrowToSelectPercent;
//
//	@FindBy(xpath = "//*[@id='commission']/div[1]/div[1]/div[2]/div[1]//li[2]")
//	WebElement clickOnPercentbutton;
//
//	@FindBy(css = "input[name='perOrAmountValue']")
//	WebElement enterCommssionAmount;
//
//	@FindBy(xpath = "//li/input[@id='f-option']/following-sibling::label[text()='Pay Now']")
//	WebElement commissionPayNowButton;
//
//	@FindBy(css = "button[class='add-commission']")
//	WebElement AddcommisionButton;
//
//	@FindBy(css = "input[placeholder='Search & Select Agent']")
//	WebElement selectAgentDropDown;

//	2 Create Constructor and invoke both Driver from parent and this class

	public Purchaseop() {

		PageFactory.initElements(driver, this);
	}

//	Dynamic Agent selection
//	protected WebElement addAgent(int index) {
//		try {
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			selectAgentDropDown.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			String AgentSelection = String.format("div[role='listbox'] mat-option:nth-of-type(%d)", index);
//			WebElement agentSelected = driver.findElement(By.cssSelector(AgentSelection));
//			agentSelected.click();
//
//			BrowserOpen.log().info("Agent Added (Dynamically) Successfully");
//			ExtentManager.test.log(Status.PASS, "Agent Added (Dynamically) Successfully");
//			return agentSelected;
//
//		} catch (Exception e) {
//
//			BrowserOpen.log().error("Dynamic Agent Is not Added:" + e);
//			ExtentManager.test.log(Status.FAIL, "Dynamic Agent Is not Added:" + e);
//
//		}
//		return null;
//
//	}

	public boolean openPurchaseModuleFromDashBoard() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.openModuleFromDashBoard(2);

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Purchase Creation Form not Opened:" + e);
			ExtentManager.test.log(Status.FAIL, "Purchase Creation Form not Opened:" + e);

		}

		return false;
	}

	public boolean openAddNewPurchasePage() {
		try {

			Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.cssSelector("button.empty-add-btn, button.New_product")));

			dcp.CreateNewInvoicePageButton();

			BrowserOpen.log().info("Purchase creation Form Open");
			ExtentManager.test.log(Status.PASS, "Purchase creation Form Open");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Purchase Creation Form not Opened:" + e);
			ExtentManager.test.log(Status.FAIL, "Purchase Creation Form not Opened:" + e);

		}

		return false;
	}

	public boolean addHeaderReferenceDueDate() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.addReferenceForInvoice();
			dcp.addDataForHeader();
			dcp.addDueDate();

			BrowserOpen.log().info("Purchase Header, Reference And Due Date Added");
			ExtentManager.test.log(Status.PASS, "Purchase Header, Reference And Due Date Added");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Purchase Header, Reference And Due Date not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Purchase Header, Reference And Due Date not Added:" + e);

		}

		return false;
	}

	public boolean addSupplier() {
		try {

			dcp.SelectClient();
			dcp.addClient(4);

			BrowserOpen.log().info("Supplier Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Supplier Added SuccessFully");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Supplier not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Supplier not Added:" + e);

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

			BrowserOpen.log().info("Purchase Terms&Condition And Custom Field Added");
			ExtentManager.test.log(Status.PASS, "Purchase Terms&Condition And Custom Field Added");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Purchase Terms&Condition And Custom Field not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Purchase Terms&Condition And Custom Field not Added:" + e);

		}

		return false;
	}

	public boolean addDiscountTaxShippingAndROundOff() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.addDiscount();
			dcp.addTax();
			dcp.shipping();
			dcp.roundOff();

			BrowserOpen.log().info("Purchase Discount, Tax Shpping Charges And RoundOff Added");
			ExtentManager.test.log(Status.PASS, "Purchase Discount, Tax Shpping Charges And RoundOff Added");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Purchase Discount, Tax, Shpping Charges And RoundOff not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Purchase Discount, Tax, Shpping Charges And RoundOff not Added:" + e);

		}

		return false;
	}

//	public boolean addCommission() {
//		try {
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			commissionButtonDropDown.click();
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToshippingCharges);
//			wait.until(ExpectedConditions.elementToBeClickable(AddcommisionButton));
//			addAgent(2);
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			currencyArrowToSelectPercent.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			clickOnPercentbutton.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			enterCommssionAmount.click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			enterCommssionAmount.sendKeys("15");
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			commissionPayNowButton.click();
//			AddcommisionButton.click();
//
//			BrowserOpen.log().info("Commission Added in Purchase");
//			ExtentManager.test.log(Status.PASS, "Commission Added in Purchase");
//
//			return true;
//		} catch (Exception e) {
//
//			BrowserOpen.log().error("Commission Not Added in Purchase:" + e);
//			ExtentManager.test.log(Status.FAIL, "Commission Not Added in Purchase:" + e);
//
//		}
//
//		return false;
//	}

	public boolean addPaymentOfPurchase() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.addPayment();

			BrowserOpen.log().info("Payment of the Purchase Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Payment of the Purchase Added SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Payment of the Purchase not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Payment of the Purchase not Added:" + e);

		}

		return false;
	}

	public boolean addFooterAndNote() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.addFooter();
			dcp.invoiceNote();

			BrowserOpen.log().info("Footer And Notes of Purchase Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Footer And Notes of Purchase Added SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Footer And Notes of Purchase not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Footer And Notes of Purchase not Added:" + e);

		}

		return false;
	}

	public boolean savePurchase() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			dcp.saveInvoiceButton();

			BrowserOpen.log().info(" Purchase Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Purchase Added SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Save Purchase not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Purchase not Added:" + e);

		}

		return false;
	}

	public void listToDashboard() {
		dcp.listToDashBoard();
	}

}
