package com.orangeHrm.qa.utilities;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.orangeHrm.qa.base.BaseTest;

public class Screenshot extends BaseTest implements ITestListener{

	public Screenshot() throws IOException {
		super();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		DateFormat DF=new SimpleDateFormat("dd_MM_yyyy hh_mm_ss");
		Date D=new Date();
		String date=DF.format(D);
		
		System.out.println(result.getMethod().getMethodName());
		captureScreenshot(result.getMethod().getMethodName()+date+".jpg");
		
		
		
	}
	

}
