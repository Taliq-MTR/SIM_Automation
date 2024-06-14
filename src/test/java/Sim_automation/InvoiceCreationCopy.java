//package Sim_automation;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import browserSetup_Login.BrowserOpen;
//import browserSetup_Login.Login;
//
//
//public class InvoiceCreationCopy extends Login  {
//
//	
//	@Test(priority= 4)
//	public void invoiceform () throws InterruptedException {
//		WebElement saveInvoice = driver.findElement(By.xpath("//button[contains(@class, 'btn-done') and contains(text(), 'Save Invoice')]"));
//		Thread.sleep(5000);
//		saveInvoice.click();
//		System.out.println("Invoice Added Successfully");
//		Thread.sleep(3000);
//		System.out.println("Waited 5 second");
////	    Navigate to Dashboard
//		WebElement invToDashboard = driver.findElement(By.cssSelector("li.breadcrumb-item > a[routerlink='/dashboard']"));
//		invToDashboard.click();
//		System.out.println("We have Successfully Completed First Module");
//		Thread.sleep(3000);
//		
//		
//	}
//	
//	
//	
//	@Test(priority= 2)
//	public void addClient() {
//		// TODO Auto-generated method stub
//		WebElement searchClient = driver.findElement(By.cssSelector("input[placeholder='Search & Select Client']"));
//		searchClient.click();
//		WebElement addClient = driver.findElement(By.xpath("//span[@class='mdc-list-item__primary-text' and text()=' Saim ']"));
//		addClient.click();
//	
//		
//	}
//
//	
//	
//	
//	@Test(priority= 3)
//	public void addProduct() {
//		// TODO Auto-generated method stub
//		WebElement searchProduct= driver.findElement(By.cssSelector("input[name='itemName']"));
//		searchProduct.click();
//		WebElement addProduct = driver.findElement(By.xpath("//mat-option[contains(@class, 'mat-mdc-option')]/span[contains(@class, 'mdc-list-item__primary-text')][text()=' Football ']"));
//		addProduct.click();
////		Scrolling on Quantity to click add item button
//		WebElement scrollToQtyINV = driver.findElement(By.cssSelector("th.qty-field"));
//		
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollToQtyINV);
//		System.out.println("Page scrolled to 'QtY' ");
//		
//		// Wait for the element to be present and clickable
//		Duration duration = Duration.ofSeconds(10l, 10);
//		WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
//		WebElement addItemButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.add-line-form")));
//		  
//
//        // Click the element using JavaScript to avoid interception issues
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addItemButton);
//        System.out.println("Product Added Successfully");
//
//
//	}
//
//	
//	
//	@Test(priority= 1)
//	public  void navigateToForm() {
//		boolean loginsuccess = loginDetail();
//		Assert.assertEquals(loginsuccess, false);
//		// 1 => INVOICE
//		int formType = 1;
//		
//		System.out.println("Creating Invoices");
//		
//		String dashboardSelectorCss = String.format(".grid-container > :nth-child(%s)",formType);
//		// TODO Auto-generated method stub
//		WebElement openInvoiceList = driver
//				.findElement(By.cssSelector(dashboardSelectorCss));
//		openInvoiceList.click();
//		
//		Duration duration = Duration.ofSeconds(10l, 10);
//		WebDriverWait wait = new WebDriverWait(driver, duration); // Set an explicit wait of 10 seconds
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.New_product")));
//
//
//		
//		WebElement addNewInvoice = driver.findElement(By.cssSelector("button.New_product"));
//		addNewInvoice.click();
//		
//	}
//  
//	
//
//}
