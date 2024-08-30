package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EstimateListPage;


public class EstimateCreation extends EstimateListPage {

	@Test (priority = 5, description = "Add a Estimate in the SIM-Web App")
	public void estimateform() throws InterruptedException {
		EstimateListPage estimatepom = new EstimateListPage();

		boolean createEstimate = estimatepom.openEstimateCreationForm();
		Assert.assertEquals(createEstimate, true, "Create Estimate page Open successfully");
		Thread.sleep(5000);

		boolean client = estimatepom.addCCustomer();
		Assert.assertEquals(client, true, "Customer Added successfully");

		boolean product = estimatepom.selectProduct();
		Assert.assertEquals(product, true, "product Added successfully");
		Thread.sleep(4000);

		boolean saveInv = estimatepom.saveEstimate();
		Assert.assertEquals(saveInv, true, "Estimate Added successfully");
		Thread.sleep(5000);

		boolean estimateToDashboard = estimatepom.dashboard();
		Assert.assertEquals(estimateToDashboard, true, "Successfully Came back to Dasboard From Estimate List");
		Thread.sleep(3500);

	}
	
}
