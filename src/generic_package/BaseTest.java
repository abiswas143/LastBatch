package generic_package;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
public class BaseTest implements IAutoConstant {
	public static WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		//set the path
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		//launch the browser
		driver = new ChromeDriver();
		//enter the url
		driver.get(Utilities.getPropertyValue("URL"));
		//set implicit time period to 10 seconds
		String ito = Utilities.getPropertyValue("IMPLICIT_WAIT");
		driver.manage().timeouts().implicitlyWait(Long.parseLong(ito), TimeUnit.SECONDS);
		//for Firefox driver
		/*	System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver = new FirefoxDriver();
		driver.get(Utilities.getPropertyValue("URL"));*/
	}
	@AfterMethod
	public void tearDown(ITestResult res)
	{
		// capture screenshot if test method fails
		if(ITestResult.FAILURE==res.getStatus())
		{
			Utilities.captureScreenshot(driver, res.getName());
		}
		//close the browser
		driver.quit();
	}
}