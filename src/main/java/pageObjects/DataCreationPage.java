package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;

public class DataCreationPage extends BrowserOpen {

//	All the elements to make a Purchase required actions
//	We use @FindBy testNg method to locate the element
//	There are 3 works happen in page object model 1. Locate all the element 2. make constructor & initialize elements
//	3. Perform actions on the elements

//	(1) All the elements will locate here

	// Click on Dashboard to start every test case without any dependency
	@FindBy(css = "a._ngcontent-ng-c3709988206,img[src='assets/img/menu/dash.png']")
	private WebElement clickOnDashBoardIcon;

	// Click on Create New Invoices
	@FindBy(css = "button.empty-add-btn, button.New_product")
	private WebElement createNewInvoiceFormButton;

	// Add Reference
	@FindBy(css = "input[name='reference']")
	private WebElement reference;

	// Click on Header Button
	@FindBy(css = "a[data-bs-target='#lwInvoiceHeader']")
	private WebElement headerButton;

	// Add Data in Header
	@FindBy(css = "textarea[name='invoiceHeader']")
	private WebElement addDataInHeader;

	// Due Date selection
	@FindBy(id = "selectDueDate")
	private WebElement dueDateDropdown;

	// Click on Client Section
	@FindBy(id = "lwAddClient")
	private WebElement searchClient;

	// Scroll the Page to click on line item
	@FindBy(css = "th.qty-field")
	private WebElement scrollToQty;

	// Click on Add product section to search for product
	@FindBy(css = "input[name='itemName']")
	private WebElement searchProduct;

	// Select product
	@FindBy(css = "div[role='listbox'] mat-option:nth-of-type(1)")
	private WebElement addProduct;

	// Product custom Field
	@FindBy(xpath = "//h2[@class='accordion-header mt-0']")
	private WebElement productCustomField;

//	Product Custom Field element is not working so We need to invoke element by cicking on it
	@FindBy(xpath = "//*[@id='collapseOne']/div/div/div/div/div")
	private WebElement clickOnProductCustomFieldBox;

	// Product custom Field Data Added
	@FindBy(xpath = "//*[@id='collapseOne']/div/div/div/div//div/input")
	private WebElement productCustomFieldData;

	// We have to wait and then Click on add product line item Button
	@FindBy(css = "button.add-line-form")
	private WebElement addItemButton;

	// Add Terms And Condition Button
	@FindBy(xpath = "//button[contains (text(), ' Add Terms ')]")
	private WebElement termsAndConditionButton;

	// Add Terms And Condition from popUpd
	@FindBy(xpath = "//*[@id='termstwo']/div/div/div[1]/div//span")
	private WebElement selectTermsAndCondition;

	// Add Terms And Condition from popUpd
	@FindBy(css = "button[color='btn-primary']")
	private WebElement doneButtonTermsAndCondition;

	// Add Custom Field For Invoice
	@FindBy(xpath = "//*[@id='wrapper']/div//div/div//div/form/div[1]/div[4]/div[2]/div[1]/div[2]/div[2]//div/input | //*[@id='wrapper']/div//div/div//div/form/div[1]/div[5]/div[2]/div[1]/div[2]/div[2]//div/input")
	private WebElement customField;

	// Scroll Page to Sub Total
	@FindBy(xpath = "//div[contains(text(), 'Sub Total ')]")
	private WebElement subTotal;

	// Add Discount
	@FindBy(css = "input[name='discountOnBillRate']")
	private WebElement addDiscount;

	// Click on Tax
	@FindBy(css = "label.container-checkbox input[type='checkbox']")
	private WebElement tax;

	// Add Shipping Charges
	@FindBy(css = "input[name='shippingCharges']")
	private WebElement shippingCharges;

	// Add RoundOff
	@FindBy(css = "input[name='adjustment']")
	private WebElement addRoundOff;

	// Click on Paid Button
	@FindBy(css = "div[href='#collapseExample'].paddingPayment.py-2")
	private WebElement paidButton;

	// Add Note to the Payment
	@FindBy(css = "textarea[name='note']")
	private WebElement addPaymentNote;

	// Click on Add to Payment Button
	@FindBy(xpath = "//*[@id='collapseExample']/div/div/div[1]/div[4]/button")
	private WebElement addPayment;

	// Click on Footer
	@FindBy(css = "a[href='#lwInvoiceFooter']")
	private WebElement footer;

	// Click on Footer
	@FindBy(css = "textarea[name='invoiceFooter']")
	private WebElement addDataInFooter;

	// Click on Add to Notes Button
	@FindBy(css = "textarea[name='invoiceNote']")
	private WebElement addDataIn_InvoiceNote;

	// Now Click on Save Invoices/Purchases

	@FindBy(css = "button[type='submit'].btn-done, button[type='submit']")
	private WebElement saveDataofInvoices;

	// Now Going Back To Dashboard
	@FindBy(css = "li.breadcrumb-item > a[routerlink='/dashboard']")
	private WebElement listToDashboard;

//	@FindBy(className = "btn-cancel")
//	private WebElement cancelButtonByClassName;

	@FindBy(xpath = "//button[contains(text(), 'Cancel')]")
	private WebElement cancelButton;

//	(2) Made a Constructor 
//	Initialize the Element

	public DataCreationPage() {
		PageFactory.initElements(driver, this);
	}

//	Explicit Wait
//	 Wait for the element to be present and clickable
	Duration duration = Duration.ofSeconds(10l, 10);
	WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds

//	Add Methods for The action on The Invoices/Purchases

	protected Boolean openModuleFromDashBoard(int formType) {
		try {

			Thread.sleep(1000);

			String dashboardSelectorCss = String.format(".grid-container > :nth-child(%s)", formType);
			// TODO Auto-generated method stub
			WebElement openInvoiceList = driver.findElement(By.cssSelector(dashboardSelectorCss));
			openInvoiceList.click();
			BrowserOpen.log().info("Open list Page From DashBoard");
			ExtentManager.test.log(Status.PASS, "Open list Page From DashBoard");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("The user Didn't open the" + formType + "Module from  DashBoard:" + e);
			ExtentManager.test.log(Status.FAIL, "The user Didn't open the" + formType + "Module from  DashBoard:" + e);

		}

		return false;
	}

//	Cancel Invoice Form Button Check

	public boolean cancelInvoiceForm() {

		try {

			Thread.sleep(500);
			cancelButton.click();

			BrowserOpen.log().info("Cancel Button is working on after open any type of creation Creation Form");
			ExtentManager.test.log(Status.PASS, "Cancel Button is working on after open any type of creation Creation Form");
			return true;

		} catch (Exception e) {

			BrowserOpen.log().error("Cancel Button is not working on after open any type of creation Creation Form:" + e);
			ExtentManager.test.log(Status.FAIL, "Cancel Button is not working on after open any type of creation Creation Form:" + e);

		}

		return false;
	}

//	 Method to get the dynamic addClient element
	protected WebElement addClient(int index) {
		try {
			String ClientSelection = String.format("div[role='listbox'] mat-option:nth-of-type(%d)", index);
			WebElement clientSelected = driver.findElement(By.cssSelector(ClientSelection));
			clientSelected.click();
			return clientSelected;
		} catch (Exception e) {

			BrowserOpen.log().error("Dynamic Client Is not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Dynamic Client Is not Added:" + e);

		}
		return null;

	}

//	 Method to get the dynamic addClient element	

	protected WebElement addProduct(int index) {
		try {
			String productSelection = String.format("div[role='listbox'] mat-option:nth-of-type(%d)", index);

			WebElement productselected = driver.findElement(By.cssSelector(productSelection));
			productselected.click();
			return productselected;
		} catch (Exception e) {

			BrowserOpen.log().error("Dynamic Product Is not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Dynamic Product Is not Added:" + e);

		}

		return null;
	}

	protected boolean openTheDashBoard() {
		try {
			clickOnDashBoardIcon.click();
			BrowserOpen.log().info("The user Click/came Back to DashBoard");
			ExtentManager.test.log(Status.PASS, "The user Click/came Back to DashBoard");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("The user Didn't come to DashBoard:" + e);
			ExtentManager.test.log(Status.FAIL, "The user Didn't come to DashBoard:" + e);

		}

		return false;
	}

	protected boolean CreateNewInvoicePageButton() {
		try {
			Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.cssSelector("button.empty-add-btn, button.New_product")));

			createNewInvoiceFormButton.click();
			BrowserOpen.log().info("The user Clicked On Create New Form Button.");
			ExtentManager.test.log(Status.PASS, "The user Clicked On Create New Form Button.");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("The user didn't click On Create New Form Button:" + e);
			ExtentManager.test.log(Status.FAIL, "The user didn't click On Create New Form Button:" + e);

		}

		return false;
	}

	protected boolean addReferenceForInvoice() {

		try {
			reference.sendKeys("MTR Refrence");

			BrowserOpen.log().info("Reference Added Successfully");
			ExtentManager.test.log(Status.PASS, "Reference Added Successfully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("The Reference Of The Invoice not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "The Reference Of The Invoice not Added:" + e);

		}
		return false;
	}

	protected boolean addDataForHeader() {

		try {
			headerButton.click();
			addDataInHeader.sendKeys("The Header Of The Invoice Added");

			BrowserOpen.log().info("Header Added Successfully");
			ExtentManager.test.log(Status.PASS, "Header Added Successfully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("The Header Of The Invoice not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "The Header Of The Invoice not Added:" + e);

		}
		return false;
	}

	protected boolean addDueDate() {

		try {
			dueDateDropdown.click();
//		    Create an instance of the Select class
			Select select = new Select(dueDateDropdown);

//			Select the "Immediately" option by visible text
			select.selectByVisibleText("Immediately");

			BrowserOpen.log().info("Due Date Added Successfully");
			ExtentManager.test.log(Status.PASS, "Due Date Added Successfully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("The Due Date Of The Invoice not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "The Du Date Of The Invoice not Added:" + e);

		}
		return false;
	}

	protected boolean SelectClient() {

		try {
			searchClient.click();

			BrowserOpen.log().info("Client Search Button Clicked Successfully");
			ExtentManager.test.log(Status.PASS, "Client Search Button Clicked Successfully");

			BrowserOpen.log().info("Client button clicked Successfully");
			ExtentManager.test.log(Status.PASS, "Client button clicked Successfully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Client button Is not clicked:" + e);
			ExtentManager.test.log(Status.FAIL, "Client button Is not clicked:" + e);

		}
		return false;
	}

	protected boolean addProductItem() {

		try {
			// Click the element using JavaScript to avoid interception issues
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToQty);

			BrowserOpen.log().info("Page scrolled to 'QtY' ");
			ExtentManager.test.log(Status.PASS, "Page scrolled to 'QtY' ");

			// Wait for the element to be present and clickable
			wait.until(ExpectedConditions.elementToBeClickable(productCustomField));
			Thread.sleep(900);
			searchProduct.click();

//			Call Add Product Method

			addProduct(1);

			wait.until(ExpectedConditions.elementToBeClickable(productCustomField)).click();

			wait.until(ExpectedConditions.elementToBeClickable(clickOnProductCustomFieldBox)).click();

			wait.until(ExpectedConditions.elementToBeClickable(productCustomFieldData))
					.sendKeys("Added Data in Product Custom Field.");

			wait.until(ExpectedConditions.elementToBeClickable(addItemButton)).click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			Just Random click to Avoid product name Pop-up
			subTotal.click();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			productCustomField.click();

			BrowserOpen.log().info("Product And product Custom Field Added Successfully");
			ExtentManager.test.log(Status.PASS, "Product And product Custom Field Added Successfully");

			return true;
		} catch (Exception e) {
//			System.out.println("Product Line item not Added");
			BrowserOpen.log().error("Product Line item not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Product Line item not Added:" + e);

		}
		return false;
	}

	protected boolean termsAndCondition() {

		try {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			termsAndConditionButton.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			selectTermsAndCondition.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			doneButtonTermsAndCondition.click();

			BrowserOpen.log().info("Terms And Conditions Selected SuccessFully");
			ExtentManager.test.log(Status.PASS, "Terms And Conditions Selected SuccessFully");

			return true;
		} catch (Exception e) {
//		System.out.println("Product Line item not Added");
			BrowserOpen.log().error("Terms And Conditions not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Terms And Conditions not Added:" + e);

		}
		return false;
	}

	protected boolean addCustomField() {
		try {
//			customField.click();
			customField.sendKeys("Custom Field Data Added SuccessFully By Automated Script");

			BrowserOpen.log().info("Custom Field Data Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Custom Field Data Added SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Custom Field not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Custom Field not Added:" + e);

		}
		return false;
	}

	protected boolean addDiscount() {

		try {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			addDiscount.click();
			addDiscount.sendKeys("12.5");

			BrowserOpen.log().info("Discount Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Discount Added SuccessFully");

//			 scroll the page
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subTotal);
//			wait.until(ExpectedConditions.elementToBeClickable(addDiscount));
			BrowserOpen.log().info("Page scrolled to 'Sub Total' ");
			ExtentManager.test.log(Status.PASS, "Page scrolled to 'Sub Total' ");
			Thread.sleep(1000);

			return true;
		} catch (Exception e) {
//		System.out.println("Product Line item not Added");
			BrowserOpen.log().error("Discount not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Discount not Added:" + e);

		}
		return false;
	}

	protected boolean addTax() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			tax.click();

			BrowserOpen.log().info("Tax Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Tax Added SuccessFully");

			return true;
		} catch (Exception e) {
//		System.out.println("Product Line item not Added");
			BrowserOpen.log().error("Tax not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Tax not Added:" + e);

		}
		return false;
	}

	protected boolean shipping() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			shippingCharges.click();
			shippingCharges.sendKeys("85.75");

			BrowserOpen.log().info("Shipping Charges Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Shipping Charges Added SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Shipping Charges not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Shipping Charges not Added:" + e);

		}
		return false;
	}

	protected boolean roundOff() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			addRoundOff.clear();
			addRoundOff.sendKeys("0.75");

			BrowserOpen.log().info("RoundOff Amount Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "RoundOff Amount Added SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("RoundOff Amount not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "RoundOff Amount not Added:" + e);

		}
		return false;
	}

	protected boolean addPayment() {

		try {

			wait.until(ExpectedConditions.elementToBeClickable(paidButton));
			// Scroll to paid Button
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paidButton);

//			wait.until(ExpectedConditions.elementToBeClickable(footer));
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);

			BrowserOpen.log().info("Page scrolled to \"Paid Button\" ");
			ExtentManager.test.log(Status.PASS, "Page scrolled to \"Paid Button\" ");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(paidButton));
			paidButton.click();
			wait.until(ExpectedConditions.elementToBeClickable(addPaymentNote));
			addPaymentNote.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			addPaymentNote.sendKeys("This Note is auto generated through script Written By MTR For the Payment");
			wait.until(ExpectedConditions.elementToBeClickable(addPayment));
			addPayment.click();

			BrowserOpen.log().info("Payment Amount Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Payment Amount Added SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Payment Amount not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Payment Amount not Added:" + e);

		}
		return false;
	}

	protected boolean addFooter() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			// Click the element using JavaScript to avoid interception issues
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);

			BrowserOpen.log().info("Page scrolled to \"Footer\" ");
			ExtentManager.test.log(Status.PASS, "Page scrolled to \"Footer\" ");

			Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			wait.until(ExpectedConditions.elementToBeClickable(footer));
//			 Click the element using JavaScript to avoid interception issues
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", footer);

			addDataInFooter.sendKeys("Footer Added For the Invoice");

			BrowserOpen.log().info("Footer Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Footer Added SuccessFully");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Footer not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Footer not Added:" + e);

		}
		return false;
	}

	public boolean invoiceNote() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			addDataIn_InvoiceNote.click();
			addDataIn_InvoiceNote
					.sendKeys("Notes Added for the Invoice Which will Not show in PDF, This Data is Auto Genereated");

			BrowserOpen.log().info("Invoice Note Added SuccessFully");
			ExtentManager.test.log(Status.PASS, "Invoice Note Added SuccessFully");

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Invoice Note Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Invoice Note Added:" + e);

		}
		return false;
	}

	protected boolean saveInvoiceButton() {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			saveDataofInvoices.click();

			BrowserOpen.log().info("Form Submitted SuccessFully");
			ExtentManager.test.log(Status.PASS, "Form Submitted SuccessFully");
			return true;
		} catch (Exception e) {
//		System.out.println("Product Line item not Added");
			BrowserOpen.log().error("Form not Submitted:" + e);
			ExtentManager.test.log(Status.FAIL, "Form not Submitted:" + e);

		}
		return false;
	}

	public boolean listToDashBoard() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

			listToDashboard.click();

			BrowserOpen.log().info("User SuccessFully Came To DashBoard");
			ExtentManager.test.log(Status.PASS, "User SuccessFully Came To DashBoard");
			return true;

		} catch (Exception e) {
			BrowserOpen.log().error("User not Came To DashBoard:" + e);
			ExtentManager.test.log(Status.FAIL, "User not Came To DashBoard:" + e);
			try {
				clickOnDashBoardIcon.click();
				BrowserOpen.log().info("User SuccessFully Came To DashBoard By Click On the DashBoard Icon");
				ExtentManager.test.log(Status.PASS,
						"User SuccessFully Came To DashBoard By Click On the DashBoard Icon");
				return true;
			} catch (Exception e1) {
				BrowserOpen.log().error("User not Came To DashBoard by Click On DashBoard Icon:" + e1);
				ExtentManager.test.log(Status.FAIL, "User not Came To DashBoard by Click On DashBoard Icon:" + e1);
			}
			return false;
		}

	}
}
