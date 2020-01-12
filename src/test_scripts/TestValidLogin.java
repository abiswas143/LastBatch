package test_scripts;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_package.BaseTest;
import generic_package.Utilities;
import pom_packages.LoginPage;


//@Listeners(fully qualified name of the listener implemented class)
public class TestValidLogin extends BaseTest { 
	@Test
	public void testValidLogin() throws Exception
	{
		LoginPage login = new LoginPage(driver);
		//enter valid username from excelfile
		//login.setUserName("admin");	
		String username = Utilities.getCellData("LoginData", "ValidLogin", 1, 0);
		String password = Utilities.getCellData("LoginData", "ValidLogin", 1, 1);
		//enter username
		login.setUserName(username);
		//enter valid password
		login.setPassword(password);
		//click on login button
		login.clickLogin();
		Thread.sleep(3000);
		
		//Wait till the home page is loaded -- using Explicit wait
		
		String actHPTitle = driver.getTitle();
		
		WebDriverWait wait = new WebDriverWait(driver, 13);
		wait.until(ExpectedConditions.titleIs("actiTIME - Enter Time-Track"));
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actHPTitle, "actiTIME - Enter Time-Track");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//validate that home page is displayed or not
		//Assert.assertEquals(driver.getTitle(),"I dont know....");
		//Assert.fail("forcibly failing this testcase...");
	}
}
