package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.PaymentPaidListPage;


public class PaymentPaidCreation extends PaymentPaidListPage{

	@Test (priority = 8, description = "Add a Payment (Paid) in the SIM-Web App")
	public void paymentPecivedForm() throws InterruptedException {
	
		PaymentPaidListPage paymentP = new PaymentPaidListPage();
		
		boolean openPaymentList = paymentP.openPaymentListForm();
		Assert.assertEquals(openPaymentList, true, "Payment List Form Open");
		Thread.sleep(2000);
		
		boolean addNewPayment = paymentP.addPaymentForm();
		Assert.assertEquals(addNewPayment, true, "Form open to fill up Details for New payment");
		Thread.sleep(2000);
		
		
		
		boolean paymentToDashboard = paymentP.dashboard();
		Assert.assertEquals(paymentToDashboard, true, "Successfully Came back to Dasboard From Payment List");
		Thread.sleep(3500);
		
	}
}
