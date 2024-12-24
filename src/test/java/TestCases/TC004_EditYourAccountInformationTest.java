package TestCases;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import PageObjects.EditYourAccountInformationPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;

public class TC004_EditYourAccountInformationTest extends BaseClass {


	@Test
	public void VerifyEditAccountFunctionalty() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		
		
		 Thread.sleep(5000);
		LoginPage lp = new LoginPage(driver);
		
		lp.EnterLoginEmail("test.1@gmail.com");

		lp.EnterLoginPwd("Admin@123");
		
		 Thread.sleep(5000);
		 
		lp.ClickLoginBtn();
		
        Thread.sleep(4000);
        
		MyAccountPage  map = new MyAccountPage(driver);

		map.ClickOnEditYourAccountInfo();


		EditYourAccountInformationPage  eainfo = new EditYourAccountInformationPage(driver);

		eainfo.EnterFirstName("Chhaya");
		eainfo.EnterLastName("RAI");
		eainfo.EnterEmail("chhayar@gmail.com");	
		eainfo.EnterTelephone("7458963254");

		eainfo.ClickBtn();
		
		String ConfMsg = eainfo.getConfirmationMsg();
		
		Assert.assertEquals(ConfMsg, "Success: Your account has been successfully updated.");
		
		
	}

}
