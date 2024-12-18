package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EstimateListPage;

public class EstimateCreation extends EstimateListPage {

	@Test(priority = 6, description = "Add an Estimate in the SIM-Web App")
	public void Estimateform() throws InterruptedException {
		EstimateListPage Estimatepom = new EstimateListPage();

		boolean createEstimate = Estimatepom.openEstimateModuleFromDashBoard();
		Assert.assertEquals(createEstimate, true, "open Estimate List Page From DashBoard successfully");
		Thread.sleep(500);

		boolean cancelEstimate = Estimatepom.cancelEstimateCreationForm();
		Assert.assertEquals(cancelEstimate, true, "Estimate Form Cancelled successfully");
		Thread.sleep(500);

		boolean Estimatepage = Estimatepom.openAddNewEstimatePage();
		Assert.assertEquals(Estimatepage, true,
				"Open Estimate Form From the Estimateice List page with \"Add New Estimate Button\" successfully");

		boolean headerRef = Estimatepom.addHeader();
		Assert.assertEquals(headerRef, true, "On Estimate Form Header Added successfully");
		Thread.sleep(400);

		boolean customer = Estimatepom.addCustomer();
		Assert.assertEquals(customer, true, "Customer For the Estimate Added successfully");
		Thread.sleep(400);

		boolean product = Estimatepom.addproduct();
		Assert.assertEquals(product, true, "product of the Estimate with Product Custom Field Added successfully");
		Thread.sleep(400);

		boolean termsCustom = Estimatepom.addtermsAndCustomField();
		Assert.assertEquals(termsCustom, true,
				"Terms & Condition with Custom Field of The Estimate Added successfully");
		Thread.sleep(400);
		boolean discount = Estimatepom.addDiscountTaxShippingAndROundOff();
		Assert.assertEquals(discount, true,
				"Discount, Shipping Charges & Round-Off for the Estimate Added successfully");
		Thread.sleep(400);

		boolean footerNote = Estimatepom.addFooterAndNote();
		Assert.assertEquals(footerNote, true, "Footer Along with Note for the Estimate Added successfully");
		Thread.sleep(400);

		boolean saveEstimate = Estimatepom.saveEstimate();
		Assert.assertEquals(saveEstimate, true, "Estimate Created successfully");
		Thread.sleep(1000);

		boolean EstimateToDashboard = Estimatepom.listToDashBoard();
		Assert.assertEquals(EstimateToDashboard, true, "Successfully Came back to Dasboard From Estimate");
		Thread.sleep(3500);
		
		boolean closeInvList = Estimatepom.closeInvoiceListdropDown();
		Assert.assertEquals(closeInvList, true, "Invoice List DropDown Closed");
		Thread.sleep(500);
		

	}

}
