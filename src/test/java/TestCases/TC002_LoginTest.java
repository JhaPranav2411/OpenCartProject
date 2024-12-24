package TestCases;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test (groups = {"sanity", "master"})
	 @Parameters ({"os", "browser"})
	
	public void verify_LOgin(@Optional String os, @Optional String browser) {
		
		
		logger.info("To verify the login test method.....");
	
		try {
		HomePage hp = new HomePage(driver);

		hp.ClickMyAccount();
		hp.ClickLogin();


		LoginPage lp = new LoginPage(driver);

		lp.EnterLoginEmail(p.getProperty("ConfigEmail"));
		lp.EnterLoginPwd(p.getProperty("ConfigPassword"));
		lp.ClickLoginBtn();


		MyAccountPage map = new MyAccountPage(driver);
		boolean targetPage = map.isMyAccountPageExist();
       
        Assert.assertTrue(targetPage); // Assert.assertEquals(targetPage, true, "Login Failed");
		} catch (Exception e) {
			
			Assert.fail();
		}
        logger.info("TC002_Login TEST ************");
        
	}





}
