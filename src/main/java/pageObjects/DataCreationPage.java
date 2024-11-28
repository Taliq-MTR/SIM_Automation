package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import browserSetup.BrowserOpen;

public class DataCreationPage extends BrowserOpen {

	// Click on Create New Invoices
	@FindBy(css = "button[type='button'].New_product")
	WebElement createNewInvoiceFormButton;

	// Add Reference
	@FindBy(css = "input[name=\"reference\"]")
	WebElement reference;

	// Click on Header Button
	@FindBy(css = "a[data-bs-target=\"#lwInvoiceHeader\"]")
	WebElement headerButton;

	// Add Data in Header
	@FindBy(css = "textarea[name=\"invoiceHeader\"]")
	WebElement addDataInHeader;

	// Click on Client Section
	@FindBy(css = "input[placeholder='Search & Select Client']")
	WebElement searchClient;

	// Click on Add product section to search for product
	@FindBy(css = "input[name='itemName']")
	WebElement searchProduct;

	// Product custom Field
	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-valid ng-touched']")
	WebElement productCustomField;

	// Scroll the Page to click on line item
	@FindBy(css = "th.qty-field")
	WebElement scrollToQtyINV;

//		We have to wait and then Click on add product line item Button
	@FindBy(css = "//*[@id=\"wrapper\"]/div/app-sale-add-edit/div//div[2]/div[2]/div/div/div/div/input")
	WebElement addItemButton;

	// Add Custom Field For Invoice
	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-valid ng-touched']")
	WebElement customField;

	// Add Discount
	@FindBy(css = "input[name=\"discountOnBillRate\"]")
	WebElement discount;

	// Click on Tax
	@FindBy(css = "label.container-checkbox input[type=\"checkbox\"]")
	WebElement tax;

	// Add Shipping Charges
	@FindBy(css = "input[name=\"shippingCharges\"]")
	WebElement shippingCharges;

	// Add RoundOff
	@FindBy(css = "input[name=\"adjustment\"]")
	WebElement roundOff;

	// Click on Paid Button
	@FindBy(css = "div[href=\"#collapseExample\"].paddingPayment.py-2")
	WebElement paidButton;

	// Click on Add to Payment Button
	@FindBy(xpath = "//*[@id='collapseExample']/div/div/div[1]/div[4]/button")
	WebElement addPayment;

	// Click on Footer
	@FindBy(css = "a[href='#lwInvoiceFooter']")
	WebElement footer;

	// Click on Add to Payment Button
	@FindBy(css = "textarea[name='invoiceFooter']")
	WebElement addDataInFooter;

	// Click on Add to Payment Button
	@FindBy(css = "textarea[name='invoiceNote']")
	WebElement addDataIn_InvoiceNote;

	// Now Click on Save Invoices/Purchases

	@FindBy(css = "button[type='submit'].btn-done")
	WebElement saveDataofInvoices;

	// Now Going Back To Dashboard
	@FindBy(css = "li.breadcrumb-item > a[routerlink='/dashboard']")
	WebElement EstimateToDashboard;

//	(2) Made a Constructor 
//	Initialize the Element

	public DataCreationPage() {
		PageFactory.initElements(driver, this);
	}

//	Add Methods for The action on The Invoices/Purchases

	protected void CreateNewInvoicePageButton() {

		createNewInvoiceFormButton.click();

	}

	protected void addReferenceForInvoice() {
		
		reference.sendKeys("MTR Refrence");
	}

	protected void addDataForHeader() {
		headerButton.click();
		addDataInHeader.sendKeys("The Header Of The Invoice Added");

	}

	protected void clientName() {

		searchClient.click();
		
	}

	protected void addProductItem() {

		searchProduct.click();
	}

	protected void CreateNewInvoi4cePageButton() {

	}

	protected void CreateNewIn6voicePageButton() {

	}

	protected void CreateNewInv5oicePageButton() {

	}

	protected void CreateNewInvo7icePageButton() {

	}

	protected void CreateNewInvo8icePageButton() {

	}

	protected void CreateNewInvo9icePageButton() {

	}

	protected void CreateNewInvo0icePageButton() {

	}

	protected void CreateNewInvoic11ePageButton() {

	}

	protected void CreateNewInvoic12ePageButton() {

	}

}
