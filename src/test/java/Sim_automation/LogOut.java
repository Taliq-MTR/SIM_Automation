package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LogOutPage;

public class LogOut extends LogOutPage {

	@Test(priority = 9, description = "Log-Out From the SIM-Web App")
	public void logOutdata() {
		LogOutPage logOut = new LogOutPage();
		boolean logOutaction = logOut.logOutDetails();
		Assert.assertEquals(logOutaction, true, "USer Log-Out From the SIM-Web App successfully");
	}

}
