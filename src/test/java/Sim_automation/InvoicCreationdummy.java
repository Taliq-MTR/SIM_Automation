package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.InvoiceListPage;
import pageObjects.Invoiceop;

public class InvoicCreationdummy extends Invoiceop {

	@Test(priority = 3, description = "Add an Invoice in the SIM-Web App")
	public void invoiceform() throws InterruptedException {
		Invoiceop invpom = new Invoiceop();

		boolean createInv = invpom.openInvoiceModuleFromDashBoard();
		Assert.assertEquals(createInv, true, "Create Invoice page Open successfully");
		Thread.sleep(500);

		boolean Invpage = invpom.openAddNewInvoicePage();
		Assert.assertEquals(Invpage, true, "Customer Added successfully");

		boolean headerRef = invpom.addHeaderReferenceDueDate();
		Assert.assertEquals(headerRef, true, "product Added successfully");
		Thread.sleep(400);

		boolean customer = invpom.addCustomer();
		Assert.assertEquals(customer, true, "product Added successfully");
		Thread.sleep(400);

		boolean product = invpom.addproduct();
		Assert.assertEquals(product, true, "product Added successfully");
		Thread.sleep(400);
		boolean termsCustom = invpom.addtermsAndCustomField();
		Assert.assertEquals(termsCustom, true, "product Added successfully");
		Thread.sleep(400);
		boolean discount = invpom.addDiscountTaxShippingAndROundOff();
		Assert.assertEquals(discount, true, "product Added successfully");
		Thread.sleep(400);

		boolean commission = invpom.addCommission();
		Assert.assertEquals(discount, true, "Commission Added successfully");
		Thread.sleep(400);

		boolean payment = invpom.addPaymentOfInvoice();
		Assert.assertEquals(payment, true, "product Added successfully");
		Thread.sleep(400);

		boolean footerNote = invpom.addFooterAndNote();
		Assert.assertEquals(footerNote, true, "product Added successfully");
		Thread.sleep(400);

		boolean saveInv = invpom.saveInvoice();
		Assert.assertEquals(saveInv, true, "Invoice Added successfully");
		Thread.sleep(1000);

//		boolean invToDashboard = invpom.listToDashboard();
//		Assert.assertEquals(invToDashboard, true, "Successfully Came back to Dasboard");
//		Thread.sleep(3500);

	}

}