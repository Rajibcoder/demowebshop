package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageAfterLogin {

	@FindBy(linkText = "Log out")
	private WebElement logout;
	
	public LandingPageAfterLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String TheText() {
		return logout.getText();
	}
}
