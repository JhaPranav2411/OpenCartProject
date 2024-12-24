package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTestCase extends BaseClass{


	@Test (dataProvider = "LoginData" , dataProviderClass = DataProviders.class ,groups = "data driven")  // getting data provider from different class
	public void verify_LOgin(String email, String pwd, String res) {


		logger.info("To verify the login test method.....");

		try {
			HomePage hp = new HomePage(driver);

			hp.ClickMyAccount();
			hp.ClickLogin();

			LoginPage lp = new LoginPage(driver);

			lp.EnterLoginEmail(p.getProperty(email));
			lp.EnterLoginPwd(p.getProperty(pwd));
			lp.ClickLoginBtn();


			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExist();

			/*
		data is valid > login success > pass 
		              > login failed  > Fail
		data is invalid > login success > Fail 
		              > login failed  > Pass



			 */
			if (res.equalsIgnoreCase("Valid")) {

				if (targetPage == true) {
					map.ClickLogout();
					Assert.assertTrue(true);
				}else {
					Assert.assertTrue(false);
				}	
			}
			if (res.equalsIgnoreCase("Invalid")) {

				if (targetPage == true) {
					map.ClickLogout();
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
				}	

			}
		}catch (Exception e) {

			Assert.fail();
		}

	}

}
