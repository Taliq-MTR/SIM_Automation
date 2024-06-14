package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.InvoiceListPage;

public class InvoiceCreation extends InvoiceListPage {

	@Test
	public void invoiceform() throws InterruptedException {
		InvoiceListPage invpom = new InvoiceListPage();

		boolean createInv = invpom.openInvoiceCreationForm();
		Assert.assertEquals(createInv, true, "Create Invoice page Open successfully");

		boolean client = invpom.addCCustomer();
		Assert.assertEquals(client, true, "Customer Added successfully");

		boolean product = invpom.selectProduct();
		Assert.assertEquals(product, true, "product Added successfully");
		Thread.sleep(1000);

		boolean saveInv = invpom.saveInvoice();
		Assert.assertEquals(saveInv, true, "Invoice Added successfully");
		Thread.sleep(800);

		boolean invToDashboard = invpom.dashboard();
		Assert.assertEquals(invToDashboard, true, "Successfully Came back to Dasboard");
		Thread.sleep(1500);

	}

}
