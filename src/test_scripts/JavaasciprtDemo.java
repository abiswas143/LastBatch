package test_scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_package.BaseTest;

public class JavaasciprtDemo {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//enter username -- using javascript
		driver.get("https://www.google.com/");
		
		//get the window popup -- conrol P
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_P);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
		//execute the compiled autoit script
		Runtime.getRuntime().exec("C:\\Users\\Er. Asad Kamil\\eclipse-workspace\\WeekendHybridFramework\\autoIT\\printpop.exe");
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
