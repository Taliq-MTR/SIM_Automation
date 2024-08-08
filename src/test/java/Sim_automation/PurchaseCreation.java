package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.PurchaseListPage;

public class PurchaseCreation extends PurchaseListPage {


	@Test (priority = 2, description = "Add a Purchase in the SIM-Web App")
	public void purchaseform() throws InterruptedException {
		PurchaseListPage purpom = new PurchaseListPage();

		boolean createPur = purpom.openPurchaseCreationForm();
		Assert.assertEquals(createPur, true, "Create Purchase page Open successfully");
		Thread.sleep(5000);

		boolean client = purpom.addSupplier();
		Assert.assertEquals(client, true, "Supplier Added successfully");

		boolean product = purpom.selectProduct();
		Assert.assertEquals(product, true, "product Added successfully");
		Thread.sleep(4000);

		boolean savePur = purpom.savePurchase();
		Assert.assertEquals(savePur, true, "Purchase Added successfully");
		Thread.sleep(9000);

		boolean purToDashboard = purpom.dashboard();
		Assert.assertEquals(purToDashboard, true, "Successfully Came back to Dasboard From Purchase List");
		Thread.sleep(3500);

	}
	

}