package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy( xpath = "//h2[text()='My Account']")
	WebElement msgHeading;
	
	@FindBy ( xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement  Logout;
	
	
//	@FindBy ( linkText = "Edit your account information");
	
	@FindBy (xpath = "//div[@id='content']")
	WebElement MyAccountSection;
	
	@FindBy (xpath = "//a[normalize-space()='Edit your account information']")
	WebElement EditAccBtn;
	
	// methods..
	
	public boolean isMyAccountPageExist() {
		 try {
		
			return msgHeading.isDisplayed();
		 } catch (Exception e) {
			 
			 return false;
		 }
		
		
	}
	

	public void ClickLogout() {
		Logout.click();
		
	}
/*
	public void MoveToMyAccountSection () throws InterruptedException {
		MyAccountSection.wait(3000);
	}
	*/
	
	public void ClickOnEditYourAccountInfo () {
		
		EditAccBtn.click();
		
	}
	
	
	
}
