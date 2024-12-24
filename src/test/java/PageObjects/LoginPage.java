package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{  
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	
	// LOCATORS...
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement LoginEmail;
	
	@FindBy (xpath = "//input[@id='input-password']")
	WebElement LoginPwd;
	
	@FindBy( xpath = "//input[@value='Login']")
	WebElement LoginBtn;
	
	
	
	// METHODS FOR EACH LOCATORS..
	
	public void EnterLoginEmail(String emailid) {
		LoginEmail.sendKeys(emailid);
		
	}
	
	
	public void EnterLoginPwd(String Pwd) {
		LoginPwd.sendKeys(Pwd);
		
	}
	
	public void ClickLoginBtn() {
		LoginBtn.click();
		
	}
	

}
