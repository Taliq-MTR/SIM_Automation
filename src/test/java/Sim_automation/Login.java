package Sim_automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class Login extends LoginPage {
	
	@Test (priority = 1, description = "Login in the SIM-Web App")
	public void logindata () {
		LoginPage  login = new LoginPage();
		boolean loginaction = login.loginDetail();
		Assert.assertEquals(loginaction, true, "USer login in the app successfully");
		}

}
