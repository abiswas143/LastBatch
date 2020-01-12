package pom_packages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//declare the web elements
	@FindBy(id="username")
	private WebElement unTB;
	@FindBy(name="pwd")
	private WebElement pwdTB;
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement loginButton;
	//initialize elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilize
	public void setUserName(String username)
	{
		unTB.sendKeys(username);
	}
	public void setPassword(String password)
	{
		pwdTB.sendKeys(password);
	}
	public void clickLogin()
	{
		loginButton.click();
	}
}
