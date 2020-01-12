package generic_package;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;

public class Utilities implements IAutoConstant{
	public static Workbook wb;
	public static String getCellData(String excelFileName, String sheetName, int rowNum, int colNum) {
		String cellValue="";
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_FILE_PATH + excelFileName +".xlsx"));
			cellValue = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellValue;		
	}
	public static String getPropertyValue(String propertyName)
	{
		String getPropertyValue = "";
		try {
			Properties prop = new Properties();
			//load the property file
			prop.load(new FileInputStream(CONFIG_FILE_PATH));
			getPropertyValue = prop.getProperty(propertyName);
		} catch (Exception e) {
			//Properties prop = null;
			//fetch the load
			//String propertyvalue = prop.getProperty(propertyName);
		}
		return getPropertyValue;
	}
	public static void captureScreenshot(WebDriver driver, String testMethodName) {
		try {
			//capture screenshot
			//TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String currentDateAndTime = new Date().toString().replaceAll(":", "_");
			File dstFile = new File(SCREENSHOT_FILE_PATH+testMethodName+"_"+currentDateAndTime+".png");
			Files.copy(srcFile, dstFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int getRowCount(String excelFileName, String sheetName) {
		int rowCount=0;
		try {
			wb= WorkbookFactory.create(new FileInputStream(EXCEL_FILE_PATH + excelFileName + ".xlsx"));
			Sheet sh = wb.getSheet(sheetName);
			rowCount = sh.getLastRowNum();
		} catch (Exception e) {
		}
		return rowCount;
	}
}
