package com.orangeHrm.qa.pom;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHrm.qa.base.BaseTest;

public class HrmDashboardPage extends BaseTest {
	
	@FindBy(xpath="//span[@class='oxd-topbar-header-breadcrumb']")
	WebElement pageHeader;
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']//child::p")
	WebElement userName;
	
	@FindBy(xpath="//button[@class='oxd-icon-button']")
	WebElement help;

	public HrmDashboardPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public boolean dashbordHeader() {
		boolean header=pageHeader.isDisplayed();
		return header;
	}
	
	public boolean  hrmUserName() {
		boolean hrmUser=userName.isDisplayed();
		return hrmUser;
	}
	
	public void hrmUserDropDown(String name) {
		userName.click();
		WebElement userNameDropDown=driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"));
		userNameDropDown.isDisplayed();
		userNameDropDown.click();
	}
	
	public void  hrmHelp() {
		help.click();
	}
	
}
