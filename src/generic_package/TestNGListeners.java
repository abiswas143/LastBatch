package generic_package;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestNGListeners implements ISuiteListener, ITestListener{

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log(suite.getName() + " --> suite finished.....", true);
	}

	@Override
	public void onStart(ISuite suite) {
		Reporter.log(suite.getName() + " --> suite Started.....", true);
	}

	@Override
	public void onFinish(ITestContext testblock) {
		Reporter.log(testblock.getName() + " --> block finished.....", true);
		
	}
	@Override
	public void onStart(ITestContext testblock) {
		Reporter.log(testblock.getName() + " --> block Started.....", true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}
	@Override
	public void onTestFailure(ITestResult testMethod) {
		Reporter.log(testMethod.getName() + " --> test method Failed.....", true);
	}

	@Override
	public void onTestSkipped(ITestResult testMethod) {
		Reporter.log(testMethod.getName() + " --> test method SKIPPED.....", true);
		
	}

	@Override
	public void onTestStart(ITestResult testMethod) {
		Reporter.log(testMethod.getName() + " --> test method Started.....", true);
		
	}

	@Override
	public void onTestSuccess(ITestResult testMethod) {
		Reporter.log(testMethod.getName() + " --> test method Pass.....", true);
		
	}

}
