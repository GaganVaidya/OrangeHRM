package com.orangeHrm.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangeHrm.qa.base.BaseTest;
import com.orangeHrm.qa.pom.HrmDashboardPage;
import com.orangeHrm.qa.pom.HrmLogin;

public class HrmDashboardPageTest extends BaseTest{
	HrmLogin hrmLogin;
	HrmDashboardPage hrmDahboradPage;
	
	public HrmDashboardPageTest() throws Throwable {
		super();
	}
	
	@BeforeTest
	public void setUp() throws Throwable {
		initialization();
		hrmLogin=new HrmLogin();
		WebDriverWait waitLogin=new WebDriverWait(driver, Duration.ofSeconds(120));
		waitLogin.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("username"))));
		hrmDahboradPage = hrmLogin.hRMLogin(property.getProperty("username"), property.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void hrmDashBoard() {
		WebDriverWait waitHeader=new WebDriverWait(driver, Duration.ofSeconds(60));
		waitHeader.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']"))));
		boolean header=hrmDahboradPage.dashbordHeader();
		Assert.assertTrue(header);
	}
	
	@Test
	public void hrmUserName() {
		boolean hrmUser=hrmDahboradPage.hrmUserName();
		Assert.assertTrue(hrmUser);
	}
	
	@Test
	public void hrmUsernameDropDown() {
		hrmDahboradPage.hrmUserDropDown("About");
	}

}
