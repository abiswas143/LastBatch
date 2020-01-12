package generic_package;

public interface IAutoConstant {
	//store the path of all the project files
	String CONFIG_FILE_PATH = ".\\configuration.properties";

	String CHROME_KEY = "webdriver.chrome.driver";
	String CHROME_VALUE = "./drivers/chromedriver.exe";

	String GECKO_KEY = "webdriver.gecko.driver";
	String GECKO_VALUE = "./drivers/geckodriver.exe";

	String EXCEL_FILE_PATH = "./TestData/";
	String SCREENSHOT_FILE_PATH = "./Screenshots/";
}