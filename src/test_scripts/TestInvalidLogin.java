package test_scripts;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import generic_package.BaseTest;
import generic_package.Utilities;
import pom_packages.LoginPage;

public class TestInvalidLogin extends BaseTest{   
	@Test
	public void testInvalidLogin() throws Exception {
		LoginPage login = new LoginPage(driver);
		int rowCount = Utilities.getRowCount("LoginData", "InvalidLogin");
		System.out.println("Total active rows in InvalidLogin sheet are "+rowCount);
		for(int row = 1; row<=rowCount-5; row++)
		{
			String username = Utilities.getCellData("LoginData", "InvalidLogin", row, 0);
			String password = Utilities.getCellData("LoginData", "InvalidLogin", row, 1);
			login.setUserName(username);
			login.setPassword(password);
			//Thread.sleep(2000);
			login.clickLogin();
			
			Assert.fail();
			}
	}
}