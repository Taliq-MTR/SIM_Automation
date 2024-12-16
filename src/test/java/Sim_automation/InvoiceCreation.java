package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.InvoiceListPage;


public class InvoiceCreation extends InvoiceListPage {

	@Test(priority = 4, description = "Add an Invoice in the SIM-Web App")
	public void invoiceform() throws InterruptedException {
		InvoiceListPage invpom = new InvoiceListPage();

		boolean createInv = invpom.openInvoiceModuleFromDashBoard();
		Assert.assertEquals(createInv, true, "open Invoice List Page From DashBoard successfully");
		Thread.sleep(500);

		boolean Invpage = invpom.openAddNewInvoicePage();
		Assert.assertEquals(Invpage, true, "Open Invoice Form From the Invice List page with \"Add New Invoice Button\" successfully");

		boolean headerRef = invpom.addHeaderReferenceDueDate();
		Assert.assertEquals(headerRef, true, "On Invoice Form Header, Reference And Due Date Module Added successfully");
		Thread.sleep(400);

		boolean customer = invpom.addCustomer();
		Assert.assertEquals(customer, true, "Customer For the Invoice Added successfully");
		Thread.sleep(400);

		boolean product = invpom.addproduct();
		Assert.assertEquals(product, true, "product of the Invoice with Product Custom Field Added successfully");
		Thread.sleep(400);
		boolean termsCustom = invpom.addtermsAndCustomField();
		Assert.assertEquals(termsCustom, true, "Terms&Condition with Custom Field of The Invoice Added successfully");
		Thread.sleep(400);
		boolean discount = invpom.addDiscountTaxShippingAndROundOff();
		Assert.assertEquals(discount, true, "Discount, Shipping Charges & Round-Off for the Invoice Added successfully");
		Thread.sleep(400);

		boolean commission = invpom.addCommission();
		Assert.assertEquals(discount, true, "Commission of The Invoice Paid successfully");
		Thread.sleep(400);

		boolean payment = invpom.addPaymentOfInvoice();
		Assert.assertEquals(payment, true, "Payment of The Invoice Added successfully");
		Thread.sleep(400);

		boolean footerNote = invpom.addFooterAndNote();
		Assert.assertEquals(footerNote, true, "Footer Along with Note for the Invoice Added successfully");
		Thread.sleep(400);

		boolean saveInv = invpom.saveInvoice();
		Assert.assertEquals(saveInv, true, "Invoice Created successfully");
		Thread.sleep(1000);

//		boolean invToDashboard = invpom.listToDashboard();
//		Assert.assertEquals(invToDashboard, true, "Successfully Came back to Dasboard");
//		Thread.sleep(3500);

	}

}
