package Sim_automation;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import browserSetup_Login.BrowserOpen;
import browserSetup_Login.ExcelUtils;
import browserSetup_Login.ExtentManager;
import pageObjects.LoginPage;

public class Login extends LoginPage {
	
	@Test (priority = 1, description = "Login in the SIM-Web App")
	public void logindata () {
		LoginPage  login = new LoginPage();
		boolean loginaction = login.loginDetail();
		Assert.assertEquals(loginaction, true, "USer login in the app successfully");
		}

	
}
