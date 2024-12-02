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

import browserSetup.BrowserOpen;
import browserSetup.ExtentManager;



public class PurchaseListPage extends DataCreationPage {

//	All the elements to make a Purchase required actions
//	We use @FindBy testNg method to locate the element
//	There are 3 works happen in page object model 1. Locate all the element 2. make constructor & initialize elements
//	3. Perform actions on the elements


//	(1) All the elements will locate here


//	 Click On Purchase Module
	
	@FindBy(xpath = "//div[@class='grid-container']//div[2]/h4[contains(text(), 'Purchase ')]")
	WebElement openPurchaseModule;
	// Click on Add Purchase button
	@FindBy(css = "button.New_product")
	WebElement addNewPurchase;

	// Click on Supplier Section
	@FindBy(css = "#lwAddClient")
	WebElement searchSupplier;


	// Select and Add Client
	@FindBy(xpath = "//mat-option//span[text()=' MTR ']")
	WebElement addSupplier;

	// Click on Add product section to search for product
	@FindBy(css = "input[name='itemName']")
	WebElement searchProduct;

	// Add Product
	@FindBy(xpath = "//mat-option//span[text()=' Football ']")
	WebElement addProduct;

	// Scroll the Page to click on line item
	@FindBy(css = "th.qty-field")
	WebElement scrollToQtyINV;

//	We have to wait and then Click on add product line item Button
	@FindBy(css = "button.add-line-form")
	WebElement addItemButton;

	// Now Click on Save Purchase
	@FindBy(xpath ="//button[contains(@class, 'btn-done') and contains(text(), 'Save Purchase')]")
	WebElement savePurchase;

	// Now Going Back To Dashboard
	@FindBy(css = "a[href='#/dashboard']")
	WebElement purchaseToDashboard;

//	(2) Made a Constructor 
//	Initialize the Element
	public PurchaseListPage() {
		
		PageFactory.initElements(driver, this);
	}

// (3) Perform Action on the Elements

	public boolean openPurchaseCreationForm() {
		try {
			
//			// 2 => Purchase
//			int formType = 2;
//
//			BrowserOpen.log().info("Purchase Creation Started");
//			ExtentManager.test.log(Status.PASS, "Purchase Creation Started");
//
//			String dashboardSelectorCss = String.format(".grid-container > :nth-child(%s)", formType);
//			// TODO Auto-generated method stub
//			WebElement openPurchaseList = driver.findElement(By.cssSelector(dashboardSelectorCss));
//			openPurchaseList.click();
			openPurchaseModule.click();

			Duration duration = Duration.ofSeconds(10l, 10);
			WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.New_product")));

			createNewInvoiceFormButton.click();

			BrowserOpen.log().info("Purchase creation Form Open");
			ExtentManager.test.log(Status.PASS, "Purchase creation Form Open");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Purchase Creation Form not Opened:" + e);
			ExtentManager.test.log(Status.FAIL, "Purchase Creation Form not Opened:" + e);
			
		}

		return false;
	}

	public boolean addSupplier() {
		try {
			searchSupplier.click();
			addSupplier.click();
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Supplier not added:" + e);
			ExtentManager.test.log(Status.FAIL, "Supplier not added:" + e);
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

//			System.out.println("Product Added Successfully");
			BrowserOpen.log().info("Product Added Successfully");
			ExtentManager.test.log(Status.PASS, "Product Added Successfully");
			return true;
		} catch (Exception e) {
//			System.out.println("Product Line item not Added");
			BrowserOpen.log().error("Product Line item not Added:" + e);
			ExtentManager.test.log(Status.FAIL, "Product Line item not Added:" + e);
			
		}

		return false;
	}

	public boolean savePurchase() {
		try {

			savePurchase.click();

			BrowserOpen.log().info("Purchase Added Successfully");
			ExtentManager.test.log(Status.PASS, "Purchase Added Successfully");
			return true;
		} catch (Exception e) {

			BrowserOpen.log().error("Didn't Click on Save Purchase Button:" + e );
			ExtentManager.test.log(Status.FAIL, "Didn't Click on Save Purchase Button:" + e);
		}

		return false;

	}

	public boolean dashboard() {
		try {

			BrowserOpen.log().info("Waited 5 second");
			ExtentManager.test.log(Status.PASS, "Waited 5 second");
			purchaseToDashboard.click();
			
			BrowserOpen.log().info("We have Successfully Completed First Module");
			ExtentManager.test.log(Status.PASS, "We have Successfully Completed First Module");
			// Set implicit wait of 5 seconds

			return true;
		} catch (Exception e) {
			BrowserOpen.log().error("Failed to Go on Dashboard from Purchase List" + e);
			ExtentManager.test.log(Status.FAIL, "Failed to Go on Dashboard from Purchase List" + e);			e.printStackTrace();
		}

		return false;

	}

}