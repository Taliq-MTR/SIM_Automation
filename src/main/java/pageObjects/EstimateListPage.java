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

import browserSetup_Login.BrowserOpen;
import browserSetup_Login.ExtentManager;

public class EstimateListPage extends BrowserOpen {
	
//	All the elements to make a Invoice required actions
//	We use @FindBy testNg method to locate the element
//	There are 3 works happen in page object model 1. Locate all the element 2. make constructor & initialize elements
//	3. Perform actions on the elements

//	WebDriver driver;
//	(1) All the elements will locate here

	// Click on Add Invoice button
	@FindBy(css = "button.New_product")
	WebElement addNewSaleOrder;

	// Click on Client Section
	@FindBy(css = "input[placeholder='Search & Select Client']")
	WebElement searchClient;


	// Select and Add Client
	@FindBy(xpath = "//mat-option//span[contains(text(), 'MMR')]")
	WebElement addClient;

	// Click on Add product section to search for product
	@FindBy(css = "input[name='itemName']")
	WebElement searchProduct;

	// Add Product
	@FindBy(xpath = "//mat-option//span[text()=' Football ']")
	WebElement addProduct;

	// Scroll the Page to click on line itme
	@FindBy(css = "th.qty-field")
	WebElement scrollToQtyINV;

//	We have to wait and then Click on add product line item Button
	@FindBy(css = "button.add-line-form")
	WebElement addItemButton;

	// Now Click on Save Invoice
	@FindBy(xpath = "//*[@id=\"wrapper\"]/div/app-add-edit/div/div/div[2]/div[2]/div/form/div[4]/div/button[2]")
	WebElement saveSaleOrder;

	// Now Going Back To Dashboard
	@FindBy(css = "li.breadcrumb-item > a[routerlink='/dashboard']")
	WebElement saleOrderToDashboard;

//	(2) Made a Constructor 
//	Initialize the Element
	public EstimateListPage() {

		

		PageFactory.initElements(driver, this);
	}

// (3) Perform Action on the Elements

	public boolean openInvoiceCreationForm() {
		try {
			
			// 1 => Sale Order
			int formType = 3;


			BrowserOpen.log().info("Creating Sale Order");
			ExtentManager.test.log(Status.PASS, "Creating Sale Order");

			String dashboardSelectorCss = String.format(".grid-container > :nth-child(%s)", formType);
			// TODO Auto-generated method stub
			WebElement openInvoiceList = driver.findElement(By.cssSelector(dashboardSelectorCss));
			openInvoiceList.click();

			Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.New_product")));

			addNewSaleOrder.click();

			BrowserOpen.log().info("Sale Order creation Form Open");
			ExtentManager.test.log(Status.PASS, "Sale Order creation Form Open");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Sale Order Creation Form not Opened:" + e);
			ExtentManager.test.log(Status.FAIL, "Sale Order Creation Form not Opened:" + e);
			
		}

		return false;
	}

	public boolean addCCustomer() {
		try {
			searchClient.click();
			addClient.click();
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Customer not added:" + e);
			ExtentManager.test.log(Status.FAIL, "Customer not added:" + e);
		}

		return false;

	}

	public boolean selectProduct() {
		try {
			searchProduct.click();
			addProduct.click();

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToQtyINV);

			BrowserOpen.log().info("Page scrolled to 'QtY' ");
			ExtentManager.test.log(Status.PASS, "Page scrolled to 'QtY' ");

			// Wait for the element to be present and clickable
			Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			wait.until(ExpectedConditions.elementToBeClickable(addItemButton));
			// Click the element using JavaScript to avoid interception issues
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", addItemButton);


			BrowserOpen.log().info("Product Added Successfully");
			ExtentManager.test.log(Status.PASS, "Product Added Successfully");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Product Line item not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Product Line item not Added:" + e);
			
		}

		return false;
	}

	public boolean saveInvoice() {
		try {

			saveSaleOrder.click();

			BrowserOpen.log().info("Sale Order Added Successfully");
			ExtentManager.test.log(Status.PASS, "Sale Order Added Successfully");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Didn't Click on Save Sale Order Button:" + e );
			ExtentManager.test.log(Status.FAIL, "Didn't Click on Save Sale Order Button:" + e);
		}

		return false;

	}

	public boolean dashboard() {
		try {


			BrowserOpen.log().info("Waited 5 second");
			ExtentManager.test.log(Status.PASS, "Waited 5 second");
			saleOrderToDashboard.click();
			

			BrowserOpen.log().info("We have Successfully Completed Fourth Module");
			ExtentManager.test.log(Status.PASS, "We have Successfully Completed Fourth Module");
		

			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Failed to Go on Dashboard from Invoice List" + e);
			ExtentManager.test.log(Status.FAIL, "Failed to Go on Dashboard from Invoice List" + e);			e.printStackTrace();
		}

		return false;

	}

}
