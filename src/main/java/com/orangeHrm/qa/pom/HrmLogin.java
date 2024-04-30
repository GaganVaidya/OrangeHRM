package com.orangeHrm.qa.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.qa.base.BaseTest;

public class HrmLogin extends BaseTest{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement submitBtn;

	@FindBy(xpath="//div[@class='orangehrm-login-forgot']/child::p")
	WebElement forgotLink;
	
	@FindBy(xpath="//div[@class='orangehrm-login-branding']")
	WebElement hrmLogo;
	
	public HrmLogin() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHRMPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateHRMLogo() {
		return hrmLogo.isDisplayed();
	}
	
	public HrmDashboardPage hRMLogin(String uname, String pword) throws Throwable {
		username.sendKeys(uname);
		password.sendKeys(pword);
		submitBtn.click();
		
		return new HrmDashboardPage();
	}
	
	public HrmForgotPassword hRMForgotPassword() {
		forgotLink.click();
		
		return new HrmForgotPassword();
	}
	
}
