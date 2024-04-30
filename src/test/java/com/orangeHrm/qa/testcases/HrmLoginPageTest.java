package com.orangeHrm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangeHrm.qa.base.BaseTest;
import com.orangeHrm.qa.pom.HrmDashboardPage;
import com.orangeHrm.qa.pom.HrmLogin;

public class HrmLoginPageTest extends BaseTest {
	HrmLogin hrmLogin;
	HrmDashboardPage hrmDahboradPage;
	
	public HrmLoginPageTest() throws IOException {
		super();
	}

	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		hrmLogin=new HrmLogin();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1)
	public void hrmTitle() {
		String title=hrmLogin.validateHRMPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void hrmLogo() {
		boolean logo=hrmLogin.validateHRMLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void HRMLogin() throws Throwable {
		hrmDahboradPage = hrmLogin.hRMLogin(property.getProperty("username"), property.getProperty("password"));
	}
	
}























