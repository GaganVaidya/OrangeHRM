package com.orangeHrm.qa.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport implements ITestListener{
	
	public ExtentReports extentReport;
	public ExtentSparkReporter sparkReport;
	public ExtentTest extentTest;
	
	String reportName;

	@Override
	public void onStart(ITestContext context) {
		String time=new SimpleDateFormat("dd_MM_yyyy hh_mm_ss").format(new Date());
		reportName = "Test-Automation"+time+".html";
		
		//Report UI
		sparkReport=new ExtentSparkReporter(".\\reports\\"+reportName);
		sparkReport.config().setDocumentTitle("Automation Reprot");
		sparkReport.config().setReportName("Results Of Your Test");
		sparkReport.config().setTheme(Theme.DARK);
		
		//Report detailing
		extentReport=new ExtentReports();
		extentReport.attachReporter(sparkReport);
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Client Name", "ABCD");
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("Test Name", "GGN");		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
		extentTest.createNode(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.PASS, "Test Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.FAIL, "Test Fail");
		extentTest.log(Status.FAIL, result.getThrowable().getMessage());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest=extentReport.createTest(result.getName());
		extentTest.assignCategory(result.getMethod().getGroups());
		extentTest.log(Status.SKIP, "Test Skip");
		extentTest.log(Status.SKIP, result.getThrowable().getMessage());
	}
}
