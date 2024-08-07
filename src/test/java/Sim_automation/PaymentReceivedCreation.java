package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.PaymentReceivedListPage;

public class PaymentReceivedCreation extends PaymentReceivedListPage{

	@Test (priority = 5, description = "Add a Payment (Received) in the SIM-Web App")
	public void paymentRecivedForm() throws InterruptedException {
	
		PaymentReceivedListPage paymentR = new PaymentReceivedListPage();
		
		boolean openPaymentList = paymentR.openPaymentListForm();
		Assert.assertEquals(openPaymentList, true, "Payment List Form Open");
		Thread.sleep(5000);
		
		boolean addNewPayment = paymentR.addPaymentForm();
		Assert.assertEquals(addNewPayment, true, "Form open to fill up Details for New payment");
		Thread.sleep(5000);
		
		boolean addNewReceipt = paymentR.addReceiptForm();
		Assert.assertEquals(addNewReceipt, true, "Form open to fill up Details for the receipt of the corresponding Payment");
		Thread.sleep(5000);
		
		boolean paymentToDashboard = paymentR.dashboard();
		Assert.assertEquals(paymentToDashboard, true, "Successfully Came back to Dasboard From Payment List");
		Thread.sleep(3500);
		
	}
}
