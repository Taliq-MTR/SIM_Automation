package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.PurchaseOrderListPage;

public class PurchaseOrderCreation extends PurchaseOrderListPage {

	@Test (priority = 3, description = "Add a Purchase Order in the SIM-Web App")
	public void purchaseOrderform() throws InterruptedException {
		PurchaseOrderListPage purOrderpom = new PurchaseOrderListPage();

		boolean createPurorder = purOrderpom.openPurchaseOrderCreationForm();
		Assert.assertEquals(createPurorder, true, "Create Purchase order page Open successfully");
		Thread.sleep(2000);

		boolean supplier = purOrderpom.addSupplier();
		Assert.assertEquals(supplier, true, "Supplier Added successfully");

		boolean product = purOrderpom.selectProduct();
		Assert.assertEquals(product, true, "product Added successfully");
		Thread.sleep(2000);

		boolean savepurOrder = purOrderpom.savePurchase();
		Assert.assertEquals(savepurOrder, true, "Purchase order Added successfully");
		Thread.sleep(5000);

		boolean purOrderToDashboard = purOrderpom.dashboard();
		Assert.assertEquals(purOrderToDashboard, true, "Successfully Came back to Dasboard From Purchase order List");
		Thread.sleep(3500);

	}
	
}
