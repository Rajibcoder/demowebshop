package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(linkText = "Log in")
	private WebElement loginlink;

	@FindBy(id="Email")
	private WebElement userid;
	
	@FindBy(id="Password")
	private WebElement pass;
	
	@FindBy(xpath="//input[contains(@class,'button-1 login-button')]")
	private WebElement loginbtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String email,String password) {
		loginlink.click();
		userid.sendKeys(email);
		pass.sendKeys(password);
		loginbtn.click();
	}
}
