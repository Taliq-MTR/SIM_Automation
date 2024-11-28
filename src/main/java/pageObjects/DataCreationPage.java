package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import browserSetup.BrowserOpen;

public class DataCreationPage extends BrowserOpen {

	// Click on Create New Invoices
	@FindBy(css = "button[type=\"button\"].New_product")
	WebElement addNewDataPage;

	// Add Reference
	@FindBy(css = "input[name=\"reference\"]")
	WebElement reference;

	// Add Header
	@FindBy(css = "a[data-bs-target=\"#lwInvoiceHeader\"]")
	WebElement addHeader;

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
				@FindBy(xpath = "div[href=\"#collapseExample\"].paddingPayment.py-2")
				WebElement addPayment;
				

	// Now Click on Save estimate
	@FindBy(css = "button[type=\"submit\"].btn-done")
	WebElement saveDataofInvoices;

	// Now Going Back To Dashboard
	@FindBy(css = "li.breadcrumb-item > a[routerlink='/dashboard']")
	WebElement EstimateToDashboard;

}
