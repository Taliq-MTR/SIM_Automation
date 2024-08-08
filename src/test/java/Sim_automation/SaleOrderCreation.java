package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.InvoiceListPage;
import pageObjects.SaleOrderListPage;

public class SaleOrderCreation extends SaleOrderListPage {

	@Test (priority = 5, description = "Add a Sale Order in the SIM-Web App")
	public void saleOrderform() throws InterruptedException {
		SaleOrderListPage saleOrderpom = new SaleOrderListPage();

		boolean createSaleOrder = saleOrderpom.openInvoiceCreationForm();
		Assert.assertEquals(createSaleOrder, true, "Create Sale Order page Open successfully");
		Thread.sleep(5000);

		boolean client = saleOrderpom.addCCustomer();
		Assert.assertEquals(client, true, "Customer Added successfully");

		boolean product = saleOrderpom.selectProduct();
		Assert.assertEquals(product, true, "product Added successfully");
		Thread.sleep(4000);

		boolean saveInv = saleOrderpom.saveInvoice();
		Assert.assertEquals(saveInv, true, "Sale Order Added successfully");
		Thread.sleep(9000);

		boolean saleOrderToDashboard = saleOrderpom.dashboard();
		Assert.assertEquals(saleOrderToDashboard, true, "Successfully Came back to Dasboard From Sale Order List");
		Thread.sleep(3500);

	}
	
}
