package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.PurchaseListPage;
import pageObjects.Purchaseop;

public class PurchaseCreation extends PurchaseListPage {

	@Test(priority = 2, description = "Add a Purchase in the SIM-Web App")
	public void Purchaseform() throws InterruptedException {
		Purchaseop purpom = new Purchaseop();

		boolean createPur = purpom.openPurchaseModuleFromDashBoard();
		Assert.assertEquals(createPur, true, "open Purchase List Page From DashBoard successfully");
		Thread.sleep(500);

		boolean purpage = purpom.openAddNewPurchasePage();
		Assert.assertEquals(purpage, true,
				"Open Purchase Form From the Purice List page with \"Add New Purchase Button\" successfully");

		boolean headerRef = purpom.addHeaderReferenceDueDate();
		Assert.assertEquals(headerRef, true,
				"On Purchase Form Header, Reference And Due Date Module Added successfully");
		Thread.sleep(400);

		boolean customer = purpom.addSupplier();
		Assert.assertEquals(customer, true, "Supplier For the Purchase Added successfully");
		Thread.sleep(400);

		boolean product = purpom.addproduct();
		Assert.assertEquals(product, true, "product of the Purchase with Product Custom Field Added successfully");
		Thread.sleep(400);

		boolean termsCustom = purpom.addtermsAndCustomField();
		Assert.assertEquals(termsCustom, true, "Terms&Condition with Custom Field of The Purchase Added successfully");
		Thread.sleep(400);
		boolean discount = purpom.addDiscountTaxShippingAndROundOff();
		Assert.assertEquals(discount, true,
				"Discount, Shipping Charges & Round-Off for the Purchase Added successfully");
		Thread.sleep(400);

		boolean payment = purpom.addPaymentOfPurchase();
		Assert.assertEquals(payment, true, "Payment of The Purchase Added successfully");
		Thread.sleep(400);

		boolean footerNote = purpom.addFooterAndNote();
		Assert.assertEquals(footerNote, true, "Footer Along with Note for the Purchase Added successfully");
		Thread.sleep(400);

		boolean savePur = purpom.savePurchase();
		Assert.assertEquals(savePur, true, "Purchase Created successfully");
		Thread.sleep(1000);

		boolean purToDashboard = purpom.listToDashBoard();
		Assert.assertEquals(purToDashboard, true, "Successfully Came back to Dasboard From Purchase");
		Thread.sleep(3500);

	}

}