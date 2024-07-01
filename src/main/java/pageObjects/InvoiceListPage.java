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

import browserSetup_Login.ExtentManager;
import browserSetup_Login.Login;

public class InvoiceListPage extends Login {

//	All the elements to make a Invoice required actions
//	We use @FindBy testNg method to locate the element
//	There are 3 works happen in page object model 1. Locate all the element 2. make constructor & initialize elements
//	3. Perform actions on the elements

//	WebDriver driver;
//	(1) All the elements will locate here

	// Click on Add Invoice button
	@FindBy(css = "button.New_product")
	WebElement addNewInvoice;

	// Click on Client Section
	@FindBy(css = "input[placeholder='Search & Select Client']")
	WebElement searchClient;
//	ssa

	// Select and Add Client
	@FindBy(xpath = "//span[@class='mdc-list-item__primary-text' and text()=' Saim ']")
	WebElement addClient;

	// Click on Add product section to search for product
	@FindBy(css = "input[name='itemName']")
	WebElement searchProduct;

	// Add Product
	@FindBy(xpath = "//mat-option[contains(@class, 'mat-mdc-option')]/span[contains(@class, 'mdc-list-item__primary-text')][text()=' Football ']")
	WebElement addProduct;

	// Scroll the Page to click on line itme
	@FindBy(css = "th.qty-field")
	WebElement scrollToQtyINV;

//	We have to wait and then Click on add product line item Button
	@FindBy(css = "button.add-line-form")
	WebElement addItemButton;

	// Now Click on Save Invoice
	@FindBy(xpath = "//button[contains(@class, 'btn-done') and contains(text(), 'Save Invoice')]")
	WebElement saveInvoice;

	// Now Going Back To Dashboard
	@FindBy(css = "li.breadcrumb-item > a[routerlink='/dashboard']")
	WebElement invToDashboard;

//	(2) Made a Constructor 
//	Initialize the Element
	public InvoiceListPage() {
//		System.out.println("This is search context" + driver);
		Login.log().info("This is search context" + driver);

		PageFactory.initElements(driver, this);
	}

// (3) Perform Action on the Elements

	public boolean openInvoiceCreationForm() {
		try {
			Login loginD = new Login();
			boolean loginsuccess = loginD.loginDetail();
			Assert.assertEquals(loginsuccess, true);
			// 1 => INVOICE
			int formType = 1;

//			System.out.println("Creating Invoices");
			Login.log().info("Creating Invoices");
			ExtentManager.test.log(Status.PASS, "Creating Invoices");

			String dashboardSelectorCss = String.format(".grid-container > :nth-child(%s)", formType);
			// TODO Auto-generated method stub
			WebElement openInvoiceList = driver.findElement(By.cssSelector(dashboardSelectorCss));
			openInvoiceList.click();

			Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.New_product")));

			addNewInvoice.click();
//			System.out.println("Invoice creation Form Open");
			Login.log().info("Invoice creation Form Open");
			ExtentManager.test.log(Status.PASS, "Invoice creation Form Open");
			return true;
		} catch (Exception e) {
//			System.out.println("Invoice Creation Form not Opened");
			Login.log().error("Invoice Creation Form not Opened:" + e);
			ExtentManager.test.log(Status.FAIL, "Invoice Creation Form not Opened:" + e);
			
		}

		return false;
	}

	public boolean addCCustomer() {
		try {
			searchClient.click();
			addClient.click();
			return true;
		} catch (Exception e) {
//			System.out.println("Customer not added");
			Login.log().error("Customer not added:" + e);
			ExtentManager.test.log(Status.FAIL, "Customer not added:" + e);
		}

		return false;

	}

	public boolean selectProduct() {
		try {
			searchProduct.click();
			addProduct.click();

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToQtyINV);
//			System.out.println("Page scrolled to 'QtY' ");
			Login.log().info("Page scrolled to 'QtY' ");
			ExtentManager.test.log(Status.PASS, "Page scrolled to 'QtY' ");

			// Wait for the element to be present and clickable
			Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			wait.until(ExpectedConditions.elementToBeClickable(addItemButton));
			// Click the element using JavaScript to avoid interception issues
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", addItemButton);

//			System.out.println("Product Added Successfully");
			Login.log().info("Product Added Successfully");
			ExtentManager.test.log(Status.PASS, "Product Added Successfully");
			return true;
		} catch (Exception e) {
//			System.out.println("Product Line item not Added");
			Login.log().error("Product Line item not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Product Line item not Added:" + e);
			
		}

		return false;
	}

	public boolean saveInvoice() {
		try {

			saveInvoice.click();
//			System.out.println("Invoice Added Successfully");
			Login.log().info("Invoice Added Successfully");
			ExtentManager.test.log(Status.PASS, "Invoice Added Successfully");
			return true;
		} catch (Exception e) {
//			System.out.println("Didn't Click on Save Invoice Button");
			Login.log().error("Didn't Click on Save Invoice Button:" + e );
			ExtentManager.test.log(Status.FAIL, "Didn't Click on Save Invoice Button:" + e);
		}

		return false;

	}

	public boolean dashboard() {
		try {

//			System.out.println("Waited 5 second");
			Login.log().info("Waited 5 second");
			ExtentManager.test.log(Status.PASS, "Waited 5 second");
			invToDashboard.click();
			
//			System.out.println("We have Successfully Completed First Module");
			Login.log().info("We have Successfully Completed First Module");
			ExtentManager.test.log(Status.PASS, "We have Successfully Completed First Module");
			// Set implicit wait of 5 seconds

			return true;
		} catch (Exception e) {
//			System.out.println("Failed to Go on Dashboard from Invoice List");
			Login.log().error("Failed to Go on Dashboard from Invoice List" + e);
			ExtentManager.test.log(Status.FAIL, "Failed to Go on Dashboard from Invoice List" + e);			e.printStackTrace();
		}

		return false;

	}

}
