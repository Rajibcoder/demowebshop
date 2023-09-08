package utilities;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class MyListener implements ITestListener{
	private WebDriver driver;
	
	public MyListener() {
        driver = new ChromeDriver();
    }
	
	 @Override
	    public void onTestFailure(ITestResult result) {
	        if (driver != null) {
	            try {
	                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	                String screenshotName = result.getName() + "_failure.png"; // Customize the screenshot name

	                String screenshotPath = "C:\\Users\\Rajib\\Documents\\fail image\\" + screenshotName;

	                FileUtils.copyFile(screenshotFile, new File(screenshotPath));

	                System.out.println("Test failed. Screenshot captured at: " + screenshotPath);
	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                driver.quit();
	            }
	        }
	 }

//	@Override
//	public void onStart(ITestContext context) {
//		System.out.println("*** Test Suite " + context.getName() + " started ***");
//	}
//
//	@Override
//	public void onFinish(ITestContext context) {
//		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
//		ExtentTestManager.endTest();
//		ExtentManager.getInstance().flush();
//	}

}
