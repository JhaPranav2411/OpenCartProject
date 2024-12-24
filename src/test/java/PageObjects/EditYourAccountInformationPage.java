package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditYourAccountInformationPage extends BasePage {

	public EditYourAccountInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id ="input-firstname")
	WebElement NewFname;

	@FindBy ( id = "input-lastname")
	WebElement NewLname;

	@FindBy (id = "input-email")
	WebElement NewEmail;

	@FindBy ( id = "input-telephone")
	WebElement NewTelephone;

	@FindBy (xpath = "//input[@value='Continue']")
	WebElement BtnContinue;
	
	@FindBy (xpath = "//*[text()='Success: Your account has been successfully updated.']")
	WebElement MsgConf;
	
	
	// methods....

	public void EnterFirstName(String fname) {
		NewFname.clear();
		NewFname.sendKeys(fname);

	}

	public void EnterLastName(String lname) {
		NewLname.clear();
		NewLname.sendKeys(lname);

	}	


	public void EnterEmail(String email) {
		NewEmail.clear();
		NewEmail.sendKeys(email);

	}


	public void EnterTelephone(String tel) {
		NewTelephone.clear();
		NewTelephone.sendKeys(tel);

	}

public void ClickBtn() {
	BtnContinue.click();
	
}

public String getConfirmationMsg()
{
	try {
		return(MsgConf.getText());
	} catch (Exception e  ) {
		return e.getMessage()	;
	}
}



}
