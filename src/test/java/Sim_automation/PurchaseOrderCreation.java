package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.PurchaseOrderListPage;

public class PurchaseOrderCreation extends PurchaseOrderListPage {

	@Test(priority = 4, description = "Add an PurchaseOrder in the SIM-Web App")
	public void PurchaseOrderform() throws InterruptedException {
		PurchaseOrderListPage PurchaseOrderpom = new PurchaseOrderListPage();

		boolean createPurchaseOrder = PurchaseOrderpom.openPurchaseOrderModuleFromDashBoard();
		Assert.assertEquals(createPurchaseOrder, true, "open PurchaseOrder List Page From DashBoard successfully");
		Thread.sleep(500);

		boolean cancelPurchaseOrder = PurchaseOrderpom.cancelPurchaseOrderCreationForm();
		Assert.assertEquals(cancelPurchaseOrder, true, "Purchase Order Form Cancelled successfully");
		Thread.sleep(500);

		boolean PurchaseOrderpage = PurchaseOrderpom.openAddNewPurchaseOrderPage();
		Assert.assertEquals(PurchaseOrderpage, true,
				"Open PurchaseOrder Form From the PurchaseOrderice List page with \"Add New PurchaseOrder Button\" successfully");

		boolean headerRef = PurchaseOrderpom.addHeader();
		Assert.assertEquals(headerRef, true, "On PurchaseOrder Form Header Added successfully");
		Thread.sleep(400);

		boolean customer = PurchaseOrderpom.addSupplier();
		Assert.assertEquals(customer, true, "Supplier For the PurchaseOrder Added successfully");
		Thread.sleep(400);

		boolean product = PurchaseOrderpom.addproduct();
		Assert.assertEquals(product, true, "product of the PurchaseOrder with Product Custom Field Added successfully");
		Thread.sleep(400);

		boolean termsCustom = PurchaseOrderpom.addtermsAndCustomField();
		Assert.assertEquals(termsCustom, true,
				"Terms&Condition with Custom Field of The PurchaseOrder Added successfully");
		Thread.sleep(400);
		boolean discount = PurchaseOrderpom.addDiscountTaxShippingAndROundOff();
		Assert.assertEquals(discount, true,
				"Discount, Shipping Charges & Round-Off for the PurchaseOrder Added successfully");
		Thread.sleep(400);

		boolean footerNote = PurchaseOrderpom.addFooterAndNote();
		Assert.assertEquals(footerNote, true, "Footer Along with Note for the PurchaseOrder Added successfully");
		Thread.sleep(400);

		boolean savePurchaseOrder = PurchaseOrderpom.savePurchaseOrder();
		Assert.assertEquals(savePurchaseOrder, true, "PurchaseOrder Created successfully");
		Thread.sleep(1000);

		boolean PurchaseOrderToDashboard = PurchaseOrderpom.listToDashBoard();
		Assert.assertEquals(PurchaseOrderToDashboard, true, "Successfully Came back to Dasboard From PurchaseOrder");
		Thread.sleep(3500);

	}

}
