package Sim_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PurchaseCreation implements RecordCreation {


	@Override
	public void addClient(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProduct(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void navigateToForm(WebDriver driver) {
		
		// 2 => Purchase
		int formType = 2;
		
		String dashboardSelectorCss = String.format(".grid-container > :nth-child(%s)",formType);
		// TODO Auto-generated method stub
		WebElement addNewPurchase = driver
				.findElement(By.cssSelector(dashboardSelectorCss));
		addNewPurchase.click();
	}
  
	

}
