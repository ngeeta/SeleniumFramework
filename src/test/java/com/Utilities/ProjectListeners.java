package com.Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BaseClass;

public class ProjectListeners extends BaseClass implements ITestListener, IRetryAnalyzer {
	public ExtentSparkReporter extentSparkReporter;
	public ExtentReports extentReports = new ExtentReports();;
	public static ExtentTest extentTest;

	public void extentConfig() {
		String path = System.getProperty("user.dir") + "/ExtentReports/report.html";
		extentSparkReporter = new ExtentSparkReporter(path);
		extentReports.attachReporter(extentSparkReporter);
		extentSparkReporter.config().setTheme(Theme.STANDARD);
		extentSparkReporter.config().setDocumentTitle("Automation Report");
		extentSparkReporter.config().setReportName("Automation test result Of Mini Project");

	}

	@Override
	public void onStart(ITestContext context) {
		extentConfig();
		System.out.println("----------onStart----------");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();

		extentTest.info("onFinish");
		System.out.println("----------onFinish----------");

	}
	/*
	 * @Override public void onTestStart(ITestResult result) {
	 * 
	 * extentTest = extentReports.createTest(result.getName());
	 * 
	 * extentTest.info("onTestStart");
	 * System.out.println("----------onTestStart----------"); }
	 */

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest = extentReports.createTest(result.getName());

		extentTest.log(Status.PASS,
				MarkupHelper.createLabel("Test is passed : " + result.getName(), ExtentColor.GREEN));
		extentTest.info("onTestSuccess");

		System.out.println("----------onTestSuccess----------");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test is Failed : " + result.getName(), ExtentColor.RED));
		extentTest.info("onTestFailure");
		System.out.println("----------onTestFailure----------");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png";
		
		try {
			FileUtils.copyFile(src, new File(path));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		extentTest.addScreenCaptureFromPath(path);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());

		extentTest.log(Status.SKIP,
				MarkupHelper.createLabel("Test is Skipped : " + result.getName(), ExtentColor.AMBER));
		extentTest.info("onTestSkipped");

		System.out.println("----------onTestSkipped----------");
	}

	@Override
	public boolean retry(ITestResult result) {
int count=0;
int retryCount=2;
while(count<retryCount) {
	count++;
	return true;

}
		return false;
	}

}
