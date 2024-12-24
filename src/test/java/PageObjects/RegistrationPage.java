package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {

		super(driver);
	}

	// LOCATORS OF THE PAGE....

	@FindBy (xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy (xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy (id = "input-email")
	WebElement txtEmail;

	@FindBy (id = "input-telephone")
	WebElement txtTelephone;

	@FindBy (id = "input-password")
	WebElement txtPassword;

	@FindBy (id = "input-confirm")
	WebElement txtConfirmPassword;

	@FindBy ( xpath = "//input[@type='checkbox']")
	WebElement chkbPolicy;

	@FindBy ( xpath = "//input[@type='submit']")
	WebElement btnContinue;

	@FindBy ( xpath = "h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;



	//  MEthods for EACH LOCATOR..

	public void EnterFirstName(String fname) {
		txtFirstName.sendKeys(fname);

	}

	public void EnterLastName(String lname) {
		txtLastName.sendKeys(lname);

	}	


	public void EnterEmail(String email) {
		txtEmail.sendKeys(email);

	}



	public void EnterTelephone(String tel) {
		txtTelephone.sendKeys(tel);

	}



	public void EnterPassword(String pwd) {
		txtPassword.sendKeys(pwd);

	}



	public void EnterConfirmPwd(String cnfpwd) {
		txtConfirmPassword.sendKeys(cnfpwd);

	}

	public void clickCheckBox()
	{
		chkbPolicy.click();
	}

	public void ClickBtnContinue() {

		btnContinue.click();
	}


	public String getConfirmationMsg()
	{
		try {
			return(msgConfirmation.getText());
		} catch (Exception e  ) {
			return e.getMessage()	;
		}
	}




}
