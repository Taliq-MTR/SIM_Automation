package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.InvoiceListPage;
import pageObjects.SaleOrderListPage;

public class SaleOrderCreation extends SaleOrderListPage {

	@Test(priority = 5, description = "Add an SaleOrder in the SIM-Web App")
	public void SaleOrderform() throws InterruptedException {
		SaleOrderListPage SaleOrderpom = new SaleOrderListPage();

		boolean createSaleOrder = SaleOrderpom.openSaleOrderModuleFromDashBoard();
		Assert.assertEquals(createSaleOrder, true, "open SaleOrder List Page From DashBoard successfully");
		Thread.sleep(500);

		boolean cancelSaleOrder = SaleOrderpom.cancelSaleOrderCreationForm();
		Assert.assertEquals(cancelSaleOrder, true, "Sale Order Form Cancelled successfully");
		Thread.sleep(500);

		boolean SaleOrderpage = SaleOrderpom.openAddNewSaleOrderPage();
		Assert.assertEquals(SaleOrderpage, true,
				"Open SaleOrder Form From the SaleOrderice List page with \"Add New SaleOrder Button\" successfully");

		boolean headerRef = SaleOrderpom.addHeader();
		Assert.assertEquals(headerRef, true, "On SaleOrder Form Header Added successfully");
		Thread.sleep(400);

		boolean customer = SaleOrderpom.addCustomer();
		Assert.assertEquals(customer, true, "Customer For the SaleOrder Added successfully");
		Thread.sleep(400);

		boolean product = SaleOrderpom.addproduct();
		Assert.assertEquals(product, true, "product of the SaleOrder with Product Custom Field Added successfully");
		Thread.sleep(400);

		boolean termsCustom = SaleOrderpom.addtermsAndCustomField();
		Assert.assertEquals(termsCustom, true, "Terms&Condition with Custom Field of The SaleOrder Added successfully");
		Thread.sleep(400);
		boolean discount = SaleOrderpom.addDiscountTaxShippingAndROundOff();
		Assert.assertEquals(discount, true,
				"Discount, Shipping Charges & Round-Off for the SaleOrder Added successfully");
		Thread.sleep(400);

		boolean footerNote = SaleOrderpom.addFooterAndNote();
		Assert.assertEquals(footerNote, true, "Footer Along with Note for the SaleOrder Added successfully");
		Thread.sleep(400);

		boolean saveSaleOrder = SaleOrderpom.saveSaleOrder();
		Assert.assertEquals(saveSaleOrder, true, "SaleOrder Created successfully");
		Thread.sleep(1000);

		boolean SaleOrderToDashboard = SaleOrderpom.listToDashBoard();
		Assert.assertEquals(SaleOrderToDashboard, true, "Successfully Came back to Dasboard From SaleOrder");
		Thread.sleep(3500);

	}

}
