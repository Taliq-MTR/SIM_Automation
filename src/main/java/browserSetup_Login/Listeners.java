package browserSetup_Login;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listeners extends ExtentManager implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// This can be used to set up the driver before any test methods run

		test = extent.createTest(result.getMethod().getDescription());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Pass test case :" + result.getName());
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// Downcast web driver object to TakeScreenshot child interface
		TakesScreenshot scrShot = (TakesScreenshot) BrowserOpen.driver;

		// Call getScreenshotAs method to create image file
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Generate current date and time
		String timeStamps = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());
//    	 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

		String destFolder = ("./screenshots/" + timeStamps + "screenshot.png");
		File destFile = new File(destFolder);

		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//     	ScreenShot with Logs report
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + "-Test Case Fialed", ExtentColor.RED));
				test.log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + "-Test Case Fialed", ExtentColor.RED));
				test.addScreenCaptureFromPath(
						System.getProperty("user.dir") + "/screenshots/" + timeStamps + "screenshot.png");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
