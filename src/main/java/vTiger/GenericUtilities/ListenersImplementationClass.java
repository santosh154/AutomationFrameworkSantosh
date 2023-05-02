package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * This class provides implementation to ItestListener interface of TestNG
 * @author PT
 *
 */
public class ListenersImplementationClass implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		
		 test = report.createTest(methodName);
		 test.log(Status.PASS, "--"+methodName+"Test execution started---");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		
		test.log(Status.PASS,"--"+methodName+"Test execution success---" );
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
	
		test.log(Status.FAIL, "--"+methodName+"Test execution failed---");
		test.log(Status.WARNING, result.getThrowable());
		
		/*Takes screenshots for failed test scripts*/
		
		String screenShotName=methodName+"-"+new JavaUtility().getSystemDateInFormat();
		WebDriverUtility wUtil=new WebDriverUtility();
		try {
			String path = wUtil.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);//attach screen shot to report
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
	
		test.log(Status.SKIP, "--"+methodName+"Test execution skipped---");
		test.log(Status.WARNING,result.getThrowable() );
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("---Suite execution started---");
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("VTiger Execution Report");
		htmlReport.config().setReportName("QCO-SJEADD-M1-Automation Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "firefox");
		report.setSystemInfo("Base URL", "https://localhost:8888");
		report.setSystemInfo("Base Platform", "Win 10");
		report.setSystemInfo("Reporter name", "Santosh");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("---Suite execution finished---");
		report.flush();
	}
	
	
}
