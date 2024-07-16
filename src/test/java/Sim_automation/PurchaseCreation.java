package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.PurchaseListPage;

public class PurchaseCreation extends PurchaseListPage {


	@Test (priority = 1, description = "Add a Purchase in the SIM-Web App")
	public void invoiceform() throws InterruptedException {
		PurchaseListPage purpom = new PurchaseListPage();

		boolean createPur = purpom.openPurchaseCreationForm();
		Assert.assertEquals(createPur, true, "Create Purchase page Open successfully");
		Thread.sleep(5000);

		boolean client = purpom.addSupplier();
		Assert.assertEquals(client, true, "Supplier Added successfully");

		boolean product = purpom.selectProduct();
		Assert.assertEquals(product, true, "product Added successfully");
		Thread.sleep(4000);

		boolean saveInv = purpom.savePurchase();
		Assert.assertEquals(saveInv, true, "Purchase Added successfully");
		Thread.sleep(9000);

		boolean invToDashboard = purpom.dashboard();
		Assert.assertEquals(invToDashboard, true, "Successfully Came back to Dasboard");
		Thread.sleep(3500);

	}
	

}