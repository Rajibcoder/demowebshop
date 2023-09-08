package test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtility;

@Listeners(utilities.TestListener.class)

public class LoginTest {
	WebDriver driver;
	@BeforeTest
	public void lunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
	}	
	
  @Test
  public void run() throws IOException {
	  String[][] data = ExcelUtility.getData("C:\\Users\\Rajib\\eclipse-workspace\\Myframework\\src\\test\\resources\\TestData1.xlsx", "Sheet1");	
		for(int i=1;i<data.length;i++)
		{
			try {
				String username = data[i][0];
				String password = data[i][1];
				LoginPage loginpage = new LoginPage(driver);
				loginpage.login(username, password);
			}
			catch (Exception e) {
				System.out.println("fail");
			}
			
			
		}
//		Assert.assertTrue(false);
  }
  
  @AfterTest
  public void close() {
	  driver.close();
  }
}
