package TestCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import TestBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	@Test (groups = {"master","regression"})
//	 @Parameters ({"os", "browser"})
	public void VerifyAccountRegistration(@Optional String os, @Optional String browser) {

		logger.info("TEst case execution begins........");
		
		HomePage hp = new HomePage(driver);
	
		hp.ClickMyAccount();
		hp.ClickRegister();   

		RegistrationPage repage = new RegistrationPage(driver) ;
		repage.EnterFirstName(Randomstring().toUpperCase());
		repage.EnterLastName(Randomstring().toUpperCase());
		repage.EnterEmail(Randomstring()+ "@gmail.com");
		repage.EnterTelephone(randomnumber());
	
		String PWD = randomPassword();
		
		repage.EnterPassword(PWD);
		repage.EnterConfirmPwd(PWD);

		repage.clickCheckBox();
		repage.ClickBtnContinue();	

		String confMsg =  repage.getConfirmationMsg();
		Assert.assertEquals(confMsg, "Your Account Has Been Created!");

	}


}
