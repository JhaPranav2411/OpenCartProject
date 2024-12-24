package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{


	public HomePage(WebDriver driver) {

		super(driver);

	}

	// locators
	@FindBy( xpath = "//span[normalize-space()='My Account']")
	WebElement BtnMyAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']") 
	WebElement RegLink;

	@FindBy (xpath = "//a[normalize-space()='Login']")
	WebElement LoginLink ;


	// methods to click 

	public void ClickMyAccount() {
		
		BtnMyAccount.click();
	}
	
	
	public void ClickRegister() {
		RegLink.click();

	}

	public void ClickLogin() {
		LoginLink.click();

	}











}
